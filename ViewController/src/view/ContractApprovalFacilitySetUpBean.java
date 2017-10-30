package view;

import javax.faces.event.ActionEvent;

import model.views.readonly.XpeDccCfgCntrcttAprFcltyROVOImpl;

import model.views.readonly.XpeDccCfgCntrcttAprFcltyROVORowImpl;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.share.ADFContext;

import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;

import oracle.adf.view.rich.context.AdfFacesContext;

import view.utils.ADFUtils;
import view.utils.JSFUtils;

public class ContractApprovalFacilitySetUpBean {
    private RichPopup mswFacilityAdd_popup;
    private RichPopup mswFacilityEdit_popup;
    private RichPopup cmtmntFacilityAdd_popup;
    private RichPopup cmtmntFacilityEdit_popup;
    private RichPopup metalsFacilityAdd_popup;
    private RichPopup metalsFacilityEdit_popup;

    public ContractApprovalFacilitySetUpBean() {
    }

    public void onMswFacilityCreation(ActionEvent actionEvent) {
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getMswFacilityAdd_popup().show(hints);
    }
    
    public void onMswFacilityEdit(ActionEvent actionEvent) {
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getMswFacilityEdit_popup().show(hints);
    }

    public void onCommitmentFacilityCreation(ActionEvent actionEvent) {
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getCmtmntFacilityAdd_popup().show(hints);
    }
    
    public void onCommitmentFacilityEdit(ActionEvent actionEvent) {
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getCmtmntFacilityEdit_popup().show(hints);
    }

    public void onMetalsFacilityCreation(ActionEvent actionEvent) {
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getMetalsFacilityAdd_popup().show(hints);
    }
    
    public void onMetalsFacilityEdit(ActionEvent actionEvent) {
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getMetalsFacilityAdd_popup().show(hints);
    }

    public void setMswFacilityAdd_popup(RichPopup mswFacilityAdd_popup) {
        this.mswFacilityAdd_popup = mswFacilityAdd_popup;
    }

    public RichPopup getMswFacilityAdd_popup() {
        return mswFacilityAdd_popup;
    }

    public void setMswFacilityEdit_popup(RichPopup mswFacilityEdit_popup) {
        this.mswFacilityEdit_popup = mswFacilityEdit_popup;
    }

    public RichPopup getMswFacilityEdit_popup() {
        return mswFacilityEdit_popup;
    }

    public void mswFacilityAddSaveorCancel(ActionEvent actionEvent) {
        this.getMswFacilityAdd_popup().hide();
    }

    public void mswFacilityEditSaveorCancel(ActionEvent actionEvent) {
        this.getMswFacilityAdd_popup().hide();
    }

    public void setCmtmntFacilityAdd_popup(RichPopup cmtmntFacilityAdd_popup) {
        this.cmtmntFacilityAdd_popup = cmtmntFacilityAdd_popup;
    }

    public RichPopup getCmtmntFacilityAdd_popup() {
        return cmtmntFacilityAdd_popup;
    }

    public void setCmtmntFacilityEdit_popup(RichPopup cmtmntFacilityEdit_popup) {
        this.cmtmntFacilityEdit_popup = cmtmntFacilityEdit_popup;
    }

    public RichPopup getCmtmntFacilityEdit_popup() {
        return cmtmntFacilityEdit_popup;
    }

    public void cmtmntFacilityAddSaveorCancel(ActionEvent actionEvent) {
        this.getCmtmntFacilityAdd_popup().hide();
    }

    public void cmtmntFacilityEditSaveorCancel(ActionEvent actionEvent) {
        this.getCmtmntFacilityEdit_popup().hide();
    }

    public void setMetalsFacilityAdd_popup(RichPopup metalsFacilityAdd_popup) {
        this.metalsFacilityAdd_popup = metalsFacilityAdd_popup;
    }

    public RichPopup getMetalsFacilityAdd_popup() {
        return metalsFacilityAdd_popup;
    }

    public void metalsFacilityAddSaveorCancel(ActionEvent actionEvent) {
        this.getMetalsFacilityAdd_popup().hide();
    }

    public void setMetalsFacilityEdit_popup(RichPopup metalsFacilityEdit_popup) {
        this.metalsFacilityEdit_popup = metalsFacilityEdit_popup;
    }

    public RichPopup getMetalsFacilityEdit_popup() {
        return metalsFacilityEdit_popup;
    }

    public void metalsFacilityEditSaveorCancel(ActionEvent actionEvent) {
        this.getMetalsFacilityEdit_popup().hide();
    }
}
