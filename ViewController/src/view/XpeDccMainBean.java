package view;

import javax.faces.event.ActionEvent;

import model.XpeDccContractLineViewImpl;
import model.XpeDccContractLineViewRowImpl;
import model.XpeDccContractVersionViewImpl;

import model.XpeDccContractVersionViewRowImpl;

import model.XpeDccContractsViewImpl;

import model.XpeDccContractsViewRowImpl;

import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.PopupCanceledEvent;

import oracle.jbo.Row;

import view.utils.ADFUtils;
import view.utils.JSFUtils;


public class XpeDccMainBean {
    private RichTable contractVersionTableBidning;

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
}
