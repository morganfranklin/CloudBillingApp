package view;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import model.views.entitybased.XpeDccCfgCmtmntFacilityEOVORowImpl;
import model.views.entitybased.XpeDccCfgMetalsFacilityEOVORowImpl;
import model.views.entitybased.XpeDccCfgMswFacilityEOVORowImpl;
import model.views.readonly.XpeDccCfgCntrcttAprFcltyROVORowImpl;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.RichPopup;

import oracle.binding.OperationBinding;

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

    public void searchFacilityActnLstnr(ActionEvent actionEvent) {
        DCIteratorBinding facilityIter = ADFUtils.findIterator("XpeDccCfgCntrcttAprFcltyROVO1Iterator");
        XpeDccCfgCntrcttAprFcltyROVORowImpl facilityRow =
            (XpeDccCfgCntrcttAprFcltyROVORowImpl) facilityIter.getCurrentRow();
        String wasteType = facilityRow.getXpeWasteType();
        String agreementType = facilityRow.getXpeAgreementType();
        String contractType = facilityRow.getXpeContractSubType();
        if (null != wasteType && "MSW".equals(wasteType)) {
            if (null != contractType && "SPT".equals(contractType)) {
                ADFContext.getCurrent().getRequestScope().put("type", "MSW");
            } else if (null != contractType && "PMM".equals(contractType)) {
                if (null != agreementType && "PC".equals(agreementType)) {
                    ADFContext.getCurrent().getRequestScope().put("type", "CMTMNT");
                } else if (null != agreementType && "PNC".equals(agreementType)) {
                    ADFContext.getCurrent().getRequestScope().put("type", "MSW");
                }
            } else if (null != contractType && "FLY".equals(contractType)) {
                ADFContext.getCurrent().getRequestScope().put("type", "CMTMNT");
            }
        } else if (null != wasteType && "MTL".equals(wasteType)) {
            ADFContext.getCurrent().getRequestScope().put("type", "MTL");
        }
        ADFUtils.findOperation("searchCntrctAprFcltySetUp").execute();
    }

    public void mswInactiveValChgLstnr(ValueChangeEvent valueChangeEvent) {
        DCIteratorBinding mswIter = ADFUtils.findIterator("XpeDccCfgMswFacilityEOVO1Iterator");
        XpeDccCfgMswFacilityEOVORowImpl mswRow = (XpeDccCfgMswFacilityEOVORowImpl) mswIter.getCurrentRow();
        if (null != valueChangeEvent.getNewValue() && valueChangeEvent.getNewValue().equals("Y")){
            mswRow.setInactiveDate(new Timestamp(System.currentTimeMillis()));
        }else{
            mswRow.setInactiveDate(null);
        }
    }

    public void cmtmntInactiveValChgLstnr(ValueChangeEvent valueChangeEvent) {
        DCIteratorBinding cmtmntIter = ADFUtils.findIterator("XpeDccCfgCmtmntFacilityEOVO1Iterator");
        XpeDccCfgCmtmntFacilityEOVORowImpl cmtmntRow = (XpeDccCfgCmtmntFacilityEOVORowImpl) cmtmntIter.getCurrentRow();
        if (null != valueChangeEvent.getNewValue() && valueChangeEvent.getNewValue().equals("Y")){
            cmtmntRow.setInactiveDate(new Timestamp(System.currentTimeMillis()));
        }else{
            cmtmntRow.setInactiveDate(null);
        }
    }

    public void mtlInactiveValChgLstnr(ValueChangeEvent valueChangeEvent) {
        DCIteratorBinding metalsIter = ADFUtils.findIterator("XpeDccCfgMetalsFacilityEOVO1Iterator");
        XpeDccCfgMetalsFacilityEOVORowImpl metalsRow = (XpeDccCfgMetalsFacilityEOVORowImpl) metalsIter.getCurrentRow();
        if (null != valueChangeEvent.getNewValue() && valueChangeEvent.getNewValue().equals("Y")){
            metalsRow.setInactiveDate(new Timestamp(System.currentTimeMillis()));
        }else{
            metalsRow.setInactiveDate(null);
        }
    }
}
