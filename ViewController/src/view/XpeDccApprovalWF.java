package view;

import java.util.Map;

import oracle.adf.model.BindingContext;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import view.utils.ADFUtils;

public class XpeDccApprovalWF {
    public XpeDccApprovalWF() {
        super();
    }
    
    public void buildPDF(){
        try {
                BindingContext bc = BindingContext.getCurrent();
                BindingContainer bindings = bc.getCurrentBindingsEntry();
                OperationBinding operationBinding = bindings.getOperationBinding("fetchPDFXML");
                if (null != operationBinding){
                    Map pdf = (Map)operationBinding.execute();
                    if(null!=pdf && pdf.size()>1){
                        ADFUtils.setvalueToExpression("#{pageFlowScope.PDF}", FileOperations.genPdfRep(String.valueOf(pdf.get("XML")).getBytes(), FileOperations.getRTFAsInputStream(String.valueOf(pdf.get("TEMPLATE_NAME")))));
                        if(pdf.size()==4)
                            ADFUtils.setvalueToExpression("#{pageFlowScope.COVER_SHEET_PDF}", FileOperations.genPdfRep(String.valueOf(pdf.get("COVER_SHEET_XML")).getBytes(), FileOperations.getRTFAsInputStream(String.valueOf(pdf.get("COVER_SHEET_TEMPLATE_NAME")))));
                    }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
