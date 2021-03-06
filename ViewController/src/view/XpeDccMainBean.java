package view;

import java.io.ByteArrayInputStream;
import java.io.OutputStream;

import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import model.XpeDccContractLineViewImpl;
import model.XpeDccContractLineViewRowImpl;
import model.XpeDccContractVersionViewRowImpl;
import model.XpeDccContractsViewImpl;
import model.XpeDccContractsViewRowImpl;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.PopupCanceledEvent;

import oracle.adf.view.rich.event.QueryEvent;

import oracle.adf.view.rich.model.AttributeCriterion;
import oracle.adf.view.rich.model.AttributeDescriptor;
import oracle.adf.view.rich.model.ConjunctionCriterion;
import oracle.adf.view.rich.model.Criterion;
import oracle.adf.view.rich.model.QueryDescriptor;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import org.apache.commons.io.IOUtils;

import view.utils.ADFUtils;
import view.utils.JSFUtils;


public class XpeDccMainBean {
    private RichTable contractVersionTableBidning;
    private RichTable customerSearchTblBind;

    public XpeDccMainBean() {
        super();
    }

    public void setContractVersionTableBidning(RichTable contractVersionTableBidning) {
        this.contractVersionTableBidning = contractVersionTableBidning;
    }

    public RichTable getContractVersionTableBidning() {
        return contractVersionTableBidning;
    }

    public String submitActionListener() {
        // Add event code here...
        AdfFacesContext.getCurrentInstance().addPartialTarget(contractVersionTableBidning);
        return "";
    }

    public void closePopupActionListener(ActionEvent actionEvent) {
        // Add event code here...
    }

    public void contractPopupCancelListener(PopupCanceledEvent popupCanceledEvent) {
        // Add event code here...

        ADFUtils.executeOperationBinding("Rollback");
    }

    public void refreshAllViewObject() {
        ADFUtils.executeOperationBinding("excecuteVersionVO");
        ADFUtils.executeOperationBinding("executeContractVO");
        ADFUtils.executeOperationBinding("executePartyVO");
        ADFUtils.executeOperationBinding("executeEventVO");
        ADFUtils.executeOperationBinding("executeContractLineVO");
        ADFUtils.executeOperationBinding("executeContractNotes");
        ADFUtils.executeOperationBinding("executeContractDocTermVO");
        ADFUtils.executeOperationBinding("executeContractPricingTerm");
        ADFUtils.executeOperationBinding("executeContractCarrierVO");
        ADFUtils.executeOperationBinding("executeContractPricingOverview");

    }

    public void addContractActionListener(ActionEvent actionEvent) {
        // Add event code here...
        ADFUtils.executeOperationBinding("CreateInsert");
        JSFUtils.showPopup("p1");
    }

    public void copyActionListener(ActionEvent actionEvent) {
        // Add event code here...
        ADFUtils.executeOperationBinding("copyContractRow");


        JSFUtils.showPopup("p1");
    }

    public void submitActionListener(ActionEvent actionEvent) {
        // Add event code here...
        ADFUtils.executeOperationBinding("Commit");
        JSFUtils.hidePopup("p1");
        ADFUtils.showInfoMessage("Contract has been copied");
    }

    public void InitializeVersionRow() {
        XpeDccContractsViewImpl contractVo =
            (XpeDccContractsViewImpl) ADFUtils.findViewObjectFromIteratorName("XpeDccContractsView1Iterator");
        XpeDccContractsViewRowImpl contractRow = (XpeDccContractsViewRowImpl) contractVo.createAndInitRow(null);
        System.out.println("contract Id-" + contractRow.getXpeContractId());
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("NewContractId", contractRow.getXpeContractId());
        XpeDccContractVersionViewRowImpl versionRow =
            (XpeDccContractVersionViewRowImpl) contractRow.getXpeDccContractVersionView().createRow();
        versionRow.setXpeContractVersion("V1");
        contractVo.insertRow(contractRow);
        contractRow.getXpeDccContractVersionView().insertRow(versionRow);
    }

    public void addLineDetailsActionListener(ActionEvent actionEvent) {
        // Add event code here...
        String currentLine = "0";
        XpeDccContractLineViewImpl lineVO =
            (XpeDccContractLineViewImpl) ADFUtils.findViewObjectFromIteratorName("XpeDccContractLineView2Iterator");
        XpeDccContractLineViewRowImpl lineRow =
            (XpeDccContractLineViewRowImpl) ADFUtils.findIterator("XpeDccContractLineView2Iterator").getCurrentRow();
        if (lineRow != null) {
            currentLine = lineRow.getXpeContractLine();

        }
        XpeDccContractLineViewRowImpl newLineRow = (XpeDccContractLineViewRowImpl) lineVO.createRow();
        Integer newLineNumber = Integer.parseInt(currentLine) + 1;
        newLineRow.setXpeContractLine(newLineNumber.toString());
        lineVO.next();
        lineVO.insertRow(newLineRow);
    }

    public void addVersionRow(ActionEvent actionEvent) {
        // Add event code here...
        ADFUtils.executeOperationBinding("createVersionRow");
        XpeDccContractVersionViewRowImpl versionRow =
            (XpeDccContractVersionViewRowImpl) ADFUtils.findViewObjectFromIteratorName("XpeDccContractVersionView2Iterator").getCurrentRow();
        versionRow.setXpeContractVersion("V1");

    }


    public void onRouteForApproval(ActionEvent actionEvent) {
        try {
            BindingContext bc = BindingContext.getCurrent();
            BindingContainer bindings = bc.getCurrentBindingsEntry();
            OperationBinding operationBinding = bindings.getOperationBinding("routeForApproval");
            if (null != operationBinding) {
                Map pdf = (Map) operationBinding.execute();
                if (null != pdf) {
                    if (pdf.size() > 1) {
                        if (null != pdf.get("VERSION_STATUS") && "DRA".equals(pdf.get("VERSION_STATUS"))) {
                            OperationBinding operationBinding1 = bindings.getOperationBinding("pushEmailForApproval");
                            if (null != operationBinding1) {
                                if(null!=pdf.get("TEMPLATE_NAME")){//Template name will be null when waste type is Special Waste/Ecovanta
                                operationBinding1.getParamsMap().put("bytes",
                                                                     FileOperations.genPdfRep(String.valueOf(pdf.get("XML")).getBytes(),
                                                                                              FileOperations.getRTFAsInputStream(String.valueOf(pdf.get("TEMPLATE_NAME")))));
                                }
                                String emailStatus = (String) operationBinding1.execute();
                                if (null != emailStatus && "SUCCESS".equals(emailStatus)) {
                                    ADFUtils.setvalueToExpression("#{bindings.XpeContractStatus.inputValue}","IWF");
                                    ADFUtils.invokeEL("#{bindings.Commit.execute}");
                                    ADFUtils.showInfoMessage("Email Sent to Approver.");
                                }
                            }
                        } else
                            ADFUtils.showErrorMessage(String.valueOf(pdf.get("VERSION_STATUS")));
                    } else
                        ADFUtils.showErrorMessage(String.valueOf(pdf.get("VERSION_STATUS")));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void downloadPDF(FacesContext facesContext, OutputStream outputStream) {
        try {
            String wasteType = (String)ADFUtils.evaluateEL("#{bindings.XpeWasteType.inputValue}");
            if(null!=wasteType && ("MSW".equals(wasteType) || "MTL".equals(wasteType))){
                BindingContext bc = BindingContext.getCurrent();
                BindingContainer bindings = bc.getCurrentBindingsEntry();
                OperationBinding operationBinding = bindings.getOperationBinding("buildXML");
                if (null != operationBinding) {
                    Map pdf = (Map) operationBinding.execute();
                    if (null != pdf && pdf.size() > 1) {
                        IOUtils.copy(new ByteArrayInputStream(FileOperations.genPdfRep(String.valueOf(pdf.get("XML")).getBytes(),
                                                                              FileOperations.getRTFAsInputStream(String.valueOf(pdf.get("TEMPLATE_NAME"))))), outputStream);
                        // flush the outout stream
                        outputStream.flush();
                    }
                }
            }else{
                ADFUtils.showInfoMessage("No PDF available.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            ADFUtils.showErrorMessage("Error while downloading PDF.");
        }
    }
    
    
    public void onContractLineAdd(ActionEvent actionEvent) {
        // Add event code here...
        try {
            DCBindingContainer bindings = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
            OperationBinding operationBinding = bindings.getOperationBinding("contractLineAdd");
            if (null != operationBinding)
                operationBinding.execute();
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
    }
    
    public void onContractPricingTermLineAdd(ActionEvent actionEvent) {
        // Add event code here...
        try {
            DCBindingContainer bindings = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
            OperationBinding operationBinding = bindings.getOperationBinding("nextContractPricingTermNumber");
            if (null != operationBinding){
                Integer nextContractPricingTermLineNbr = (Integer)operationBinding.execute();
                if(null!=nextContractPricingTermLineNbr){
                    ADFUtils.invokeEL("#{bindings.CreateInsert.execute}");
                    OperationBinding operationBinding1 = bindings.getOperationBinding("contractPricingTermLineAdd");
                    if (null != operationBinding1){
                        operationBinding1.getParamsMap().put("nextPricingTermLineNbr", nextContractPricingTermLineNbr);
                        operationBinding1.execute();
                    }
                }
            }
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
    }
    
    public void onContractPricingOverLineAdd(ActionEvent actionEvent) {
        // Add event code here...
        try {
            DCBindingContainer bindings = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
            OperationBinding operationBinding = bindings.getOperationBinding("contractPricingOverLineAdd");
            if (null != operationBinding)
                operationBinding.execute();
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
    }

    public void setCustomerSearchTblBind(RichTable customerSearchTblBind) {
        this.customerSearchTblBind = customerSearchTblBind;
    }

    public RichTable getCustomerSearchTblBind() {
        return customerSearchTblBind;
    }
}
