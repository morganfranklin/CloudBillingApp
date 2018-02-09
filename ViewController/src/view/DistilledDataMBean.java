package view;

import java.io.ByteArrayInputStream;
import java.io.OutputStream;

import javax.faces.context.FacesContext;

import oracle.adf.model.BindingContext;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import org.apache.commons.io.IOUtils;

import view.utils.ADFUtils;

public class DistilledDataMBean {
    public DistilledDataMBean() {
        super();
    }

    public void summaryPDFDownload(FacesContext facesContext, OutputStream outputStream) {
        try {
                BindingContext bc = BindingContext.getCurrent();
                BindingContainer bindings = bc.getCurrentBindingsEntry();
                OperationBinding operationBinding = bindings.getOperationBinding("writeVoToXmlSummary");
                if (null != operationBinding) {
                    String xml = (String) operationBinding.execute();
                    if (null != xml && xml.length() > 0) {
                        IOUtils.copy(new ByteArrayInputStream(FileOperations.genPdfRep(xml.getBytes(),
                                                                              FileOperations.getRTFAsInputStream("SummaryReport"))), outputStream);
                        // flush the outout stream
                        outputStream.flush();
                    }else
                        ADFUtils.showInfoMessage("No PDF available.");
                }else
                    ADFUtils.showInfoMessage("No PDF available.");
        } catch (Exception e) {
            e.printStackTrace();
            ADFUtils.showErrorMessage("Error while downloading PDF.");
        }

    }
    
    public void detailsPDFDownload(FacesContext facesContext, OutputStream outputStream) {
        try {
                BindingContext bc = BindingContext.getCurrent();
                BindingContainer bindings = bc.getCurrentBindingsEntry();
                OperationBinding operationBinding = bindings.getOperationBinding("writeVoToXmlDetails");
                if (null != operationBinding) {
                    String xml = (String) operationBinding.execute();
                    if (null != xml && xml.length() > 0) {
                        IOUtils.copy(new ByteArrayInputStream(FileOperations.genPdfRep(xml.getBytes(),
                                                                              FileOperations.getRTFAsInputStream("DetailsReport"))), outputStream);
                        // flush the outout stream
                        outputStream.flush();
                    }else
                        ADFUtils.showInfoMessage("No PDF available.");
                }else
                    ADFUtils.showInfoMessage("No PDF available.");
        } catch (Exception e) {
            e.printStackTrace();
            ADFUtils.showErrorMessage("Error while downloading PDF.");
        }

    }
}
