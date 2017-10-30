package view;

import java.io.Serializable;

import javax.faces.event.ActionEvent;

import oracle.adf.view.rich.component.rich.RichPopup;

import view.utils.ADFUtils;

public class ContractApprovalFacilitySetUpMBean implements Serializable{
    @SuppressWarnings("compatibility:-7540524635873301715")
    private static final long serialVersionUID = 1L;

    public ContractApprovalFacilitySetUpMBean() {
    }
    
    private ContractApprovalFacilitySetUpBBean getContractApprovalFacilitySetUpBBean() {
        ContractApprovalFacilitySetUpBBean contractApprovalFacilitySetUpBBean =
            (ContractApprovalFacilitySetUpBBean) ADFUtils.evaluateEL("#{backingBeanScope.ContractApprovalFacilitySetUpBBean}");
        return contractApprovalFacilitySetUpBBean;
    }

    public void onMswFacilityCreation(ActionEvent actionEvent) {
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getContractApprovalFacilitySetUpBBean().getMswFacilityAdd_popup().show(hints);
    }

    public void onMswFacilityEdit(ActionEvent actionEvent) {
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getContractApprovalFacilitySetUpBBean().getMswFacilityEdit_popup().show(hints);
    }

    public void mswFacilityAddSaveorCancel(ActionEvent actionEvent) {
        this.getContractApprovalFacilitySetUpBBean().getMswFacilityAdd_popup().hide();
    }

    public void mswFacilityEditSaveorCancel(ActionEvent actionEvent) {
        this.getContractApprovalFacilitySetUpBBean().getMswFacilityEdit_popup().hide();
    }

    public void onCommitmentFacilityCreation(ActionEvent actionEvent) {
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getContractApprovalFacilitySetUpBBean().getCmtmntFacilityAdd_popup().show(hints);
    }

    public void onCommitmentFacilityEdit(ActionEvent actionEvent) {
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getContractApprovalFacilitySetUpBBean().getCmtmntFacilityEdit_popup().show(hints);
    }

    public void cmtmntFacilityAddSaveorCancel(ActionEvent actionEvent) {
        this.getContractApprovalFacilitySetUpBBean().getCmtmntFacilityAdd_popup().hide();
    }

    public void cmtmntFacilityEditSaveorCancel(ActionEvent actionEvent) {
        this.getContractApprovalFacilitySetUpBBean().getCmtmntFacilityEdit_popup().hide();
    }

    public void onMetalsFacilityCreation(ActionEvent actionEvent) {
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getContractApprovalFacilitySetUpBBean().getMetalsFacilityAdd_popup().show(hints);
    }

    public void onMetalsFacilityEdit(ActionEvent actionEvent) {
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getContractApprovalFacilitySetUpBBean().getMetalsFacilityEdit_popup().show(hints);
    }

    public void metalsFacilityAddSaveorCancel(ActionEvent actionEvent) {
        this.getContractApprovalFacilitySetUpBBean().getMetalsFacilityAdd_popup().hide();
    }

    public void metalsFacilityEditSaveorCancel(ActionEvent actionEvent) {
        this.getContractApprovalFacilitySetUpBBean().getMetalsFacilityEdit_popup().hide();
    }
}
