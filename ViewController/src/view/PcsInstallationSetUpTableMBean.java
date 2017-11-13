package view;

import java.sql.Timestamp;
import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import model.views.entitybased.XpeDccCfgPcsAssTerminalsEOVORowImpl;
import model.views.entitybased.XpeDccCfgPcsEOVOImpl;

import model.views.entitybased.XpeDccCfgPcsEOVORowImpl;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.RichPopup;

import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.QueryOperationEvent;

import oracle.binding.OperationBinding;

import view.utils.ADFUtils;
import view.utils.JSFUtils;

public class PcsInstallationSetUpTableMBean {

    public PcsInstallationSetUpTableMBean() {
    }
    
    private PcsInstallationSetUpTableBBean getPcsInstallationSetUpTableBBean() {
        PcsInstallationSetUpTableBBean pcsInstallationSetUpTableBBean =
            (PcsInstallationSetUpTableBBean) ADFUtils.evaluateEL("#{backingBeanScope.PcsInstallationSetUpTableBBean}");
        return pcsInstallationSetUpTableBBean;
    }

    public void onTerminalSearch(ActionEvent actionEvent) {
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getPcsInstallationSetUpTableBBean().getPcsTerminalAddItem_popup().show(hints);
    }

    public void pcsTerminalSearchSave(ActionEvent actionEvent) {
        OperationBinding opb = ADFUtils.findOperation("addAssTerminalToPCS");
        opb.execute();
        Object terminalSrchRslt = opb.getResult();
        String rtnMsg = (String) terminalSrchRslt;
        if ("DUPLICATE_EXIST".equals(rtnMsg)) {
            JSFUtils.addFacesErrorMessage("Selected Terminal is associated to PCS. Please select another terminal.");
        }else{
        this.getPcsInstallationSetUpTableBBean().getPcsTerminalAddItem_popup().hide();
        }
    }

    public void pcsTerminalEditSaveorCancel(ActionEvent actionEvent) {
        this.getPcsInstallationSetUpTableBBean().getPcsTerminalEditItem_popup().hide();
    }

    public void onTerminalEdit(ActionEvent actionEvent) {
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getPcsInstallationSetUpTableBBean().getPcsTerminalEditItem_popup().show(hints);
    }

    public void queryOperationListener(QueryOperationEvent queryOperationEvent) {
        ADFUtils.invokeEL("#{bindings.PCSCriteriaQuery.processQueryOperation}", Object.class, QueryOperationEvent.class,
                 queryOperationEvent);
        if (queryOperationEvent.getOperation().name().toUpperCase().equals("RESET")) {
            DCIteratorBinding carrierIter = ADFUtils.findIterator("XpeDccCfgPcsEOVOIterator");
            carrierIter.getViewObject().executeEmptyRowSet();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.getPcsInstallationSetUpTableBBean().getPcsInstallationSetUpTblBind());
        }
    }

    public void onPcsInstallationCreation(ActionEvent actionEvent) {
        DCIteratorBinding dcIterBind = ADFUtils.findIterator("XpeDccCfgNewPcsEOVOIterator");
        XpeDccCfgPcsEOVOImpl pcsImpl = (XpeDccCfgPcsEOVOImpl) dcIterBind.getViewObject();
        pcsImpl.executeQuery();
        XpeDccCfgPcsEOVORowImpl pcsRowImpl = (XpeDccCfgPcsEOVORowImpl) pcsImpl.createRow();
        pcsImpl.insertRow(pcsRowImpl);
        pcsImpl.setCurrentRow(pcsRowImpl);
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("SiteId", pcsRowImpl.getSiteId());
    }

    public void pcsTerminalSearchCancel(ActionEvent actionEvent) {
        this.getPcsInstallationSetUpTableBBean().getPcsTerminalAddItem_popup().hide();
    }

    public void onTerminalEditInactiveValChgLstnr(ValueChangeEvent valueChangeEvent) {
        DCIteratorBinding pcsAssocTermIter = ADFUtils.findIterator("XpeDccCfgNewPcsAssTerminalsEOVOIterator");
        XpeDccCfgPcsAssTerminalsEOVORowImpl pcsAssocTermRow =
            (XpeDccCfgPcsAssTerminalsEOVORowImpl) pcsAssocTermIter.getCurrentRow();
        if (null != valueChangeEvent.getNewValue() && valueChangeEvent.getNewValue().equals("Y")) {
            pcsAssocTermRow.setInactiveDate(new Timestamp(System.currentTimeMillis()));
        } else {
            pcsAssocTermRow.setInactiveDate(null);
        }
    }

    public void onTerminalAddInactiveValChgLstnr(ValueChangeEvent valueChangeEvent) {
        DCIteratorBinding pcsAssocTermIter = ADFUtils.findIterator("XpeDccCfgNewPcsAssTerminalsEOVOIterator");
        XpeDccCfgPcsAssTerminalsEOVORowImpl pcsAssocTermRow =
            (XpeDccCfgPcsAssTerminalsEOVORowImpl) pcsAssocTermIter.getCurrentRow();
        if (null != valueChangeEvent.getNewValue() && valueChangeEvent.getNewValue().equals("Y")){
            pcsAssocTermRow.setInactiveDate(new Timestamp(System.currentTimeMillis()));
        }else{
            pcsAssocTermRow.setInactiveDate(null);
        }
    }

    public void onPcsSiteEditInactiveValChgLstnr(ValueChangeEvent valueChangeEvent) {
        DCIteratorBinding pcsIter = ADFUtils.findIterator("XpeDccCfgNewPcsEOVOIterator");
        XpeDccCfgPcsEOVORowImpl pcsRow = (XpeDccCfgPcsEOVORowImpl) pcsIter.getCurrentRow();
        if (null != valueChangeEvent.getNewValue() && valueChangeEvent.getNewValue().equals("Y")){
            pcsRow.setInactiveDate(new Timestamp(System.currentTimeMillis()));
        }else{
            pcsRow.setInactiveDate(null);
        }
    }

    public void pcsSitesSaveActnLstnr(ActionEvent actionEvent) {
        OperationBinding opb = ADFUtils.findOperation("Commit");
        opb.execute();
        if (opb.getErrors().isEmpty()) {
            JSFUtils.addFacesInformationMessage("Data Saved Successfully.");
        } else {
            JSFUtils.addFacesErrorMessage("Error while saving the data. Please contact system Administrator.");
        }
    }
}
