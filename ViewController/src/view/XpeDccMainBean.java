package view;

import java.io.ByteArrayInputStream;
import java.io.OutputStream;

import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import model.XpeDccContractLineViewImpl;
import model.XpeDccContractLineViewRowImpl;
import model.XpeDccContractVersionViewRowImpl;
import model.XpeDccContractsViewImpl;
import model.XpeDccContractsViewRowImpl;

import oracle.adf.model.BindingContext;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.PopupCanceledEvent;

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
        XpeDccContractVersionViewRowImpl versionRow =
            (XpeDccContractVersionViewRowImpl) contractRow.getXpeDccContractVersionView().createRow();
        versionRow.setXpeContractVersion("V1");
        contractVo.insertRow(contractRow);
        contractRow.getXpeDccContractVersionView().insertRow(versionRow);

    }

    public void addLineDetailsActionListener(ActionEvent actionEvent) {
        // Add event code here...
        //String currentLine = "0";
        XpeDccContractLineViewImpl lineVO =
            (XpeDccContractLineViewImpl) ADFUtils.findViewObjectFromIteratorName("XpeDccContractLineView2Iterator");
        /*XpeDccContractLineViewRowImpl lineRow =
            (XpeDccContractLineViewRowImpl) ADFUtils.findIterator("XpeDccContractLineView2Iterator").getCurrentRow();
        if (lineRow != null) {
            currentLine = lineRow.getXpeContractLine();

        }*/
        XpeDccContractLineViewRowImpl newLineRow = (XpeDccContractLineViewRowImpl) lineVO.createRow();
        //Integer newLineNumber = Integer.parseInt(currentLine) + 1;
        //newLineRow.setXpeContractLine(newLineNumber.toString());
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
                                operationBinding1.getParamsMap().put("bytes",
                                                                     FileOperations.genPdfRep(String.valueOf(pdf.get("XML")).getBytes(),
                                                                                              FileOperations.getRTFAsInputStream(String.valueOf(pdf.get("TEMPLATE_NAME")))));
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
        } catch (Exception e) {
            e.printStackTrace();
            ADFUtils.showErrorMessage("Error while downloading PDF.");
        }
    }

    public void setCustomerSearchTblBind(RichTable customerSearchTblBind) {
        this.customerSearchTblBind = customerSearchTblBind;
    }

    public RichTable getCustomerSearchTblBind() {
        return customerSearchTblBind;
    }
}
