package view;

import javax.faces.event.ActionEvent;

import model.views.readonly.XpeDccCfgCntrcttAprFcltyROVOImpl;

import model.views.readonly.XpeDccCfgCntrcttAprFcltyROVORowImpl;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.share.ADFContext;

import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;

import oracle.adf.view.rich.context.AdfFacesContext;

import view.utils.ADFUtils;
import view.utils.JSFUtils;

public class ContractApprovalFacilitySetUpBean {
    private RichPanelGroupLayout facilityTablesPanelGroupBind;

    public ContractApprovalFacilitySetUpBean() {
    }

    public void searchFacilityLookUp(ActionEvent actionEvent) {
        String type = null;
        DCIteratorBinding facilityROIter = ADFUtils.findIterator("XpeDccCfgCntrcttAprFcltyROVO1Iterator");
        XpeDccCfgCntrcttAprFcltyROVOImpl facilityROView =
            (XpeDccCfgCntrcttAprFcltyROVOImpl) facilityROIter.getViewObject();
        XpeDccCfgCntrcttAprFcltyROVORowImpl facilityROViewRow =
            (XpeDccCfgCntrcttAprFcltyROVORowImpl) facilityROView.getCurrentRow();
        if(null != facilityROViewRow){
        if(null != facilityROViewRow.getXpeWasteType() && "MSW".equals(facilityROViewRow.getXpeWasteType())){
            type = facilityROViewRow.getXpeWasteType();
        }else if(null != facilityROViewRow.getXpeWasteType() && "CMTMNT".equals(facilityROViewRow.getXpeWasteType())){
            type = facilityROViewRow.getXpeWasteType();
        }else if(null != facilityROViewRow.getXpeWasteType() && "MTL".equals(facilityROViewRow.getXpeWasteType())){
            type = facilityROViewRow.getXpeWasteType();
        }
        ADFContext.getCurrent().getRequestScope().put("type", type);
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(facilityTablesPanelGroupBind);
    }

    public void resetFacilityLookUp(ActionEvent actionEvent) {
        ADFContext.getCurrent().getRequestScope().put("type", null);
        AdfFacesContext.getCurrentInstance().addPartialTarget(facilityTablesPanelGroupBind);
    }

    public void onMswFacilityCreation(ActionEvent actionEvent) {
        // Add event code here...
    }

    public void onCommitmentFacilityCreation(ActionEvent actionEvent) {
        // Add event code here...
    }

    public void onMetalsFacilityCreation(ActionEvent actionEvent) {
        // Add event code here...
    }

    public void setFacilityTablesPanelGroupBind(RichPanelGroupLayout facilityTablesPanelGroupBind) {
        this.facilityTablesPanelGroupBind = facilityTablesPanelGroupBind;
    }

    public RichPanelGroupLayout getFacilityTablesPanelGroupBind() {
        return facilityTablesPanelGroupBind;
    }
}
