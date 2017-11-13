package view;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.MethodExpression;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import model.views.entitybased.XpeDccCfgTerminalsEOVORowImpl;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.RichPopup;

import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.QueryOperationEvent;

import oracle.binding.OperationBinding;

import view.utils.ADFUtils;
import view.utils.JSFUtils;

public class XpeCfgTableSetupMBean implements Serializable {
    @SuppressWarnings("compatibility:4267063345257999077")
    private static final long serialVersionUID = -6995675695570335476L;

    public XpeCfgTableSetupMBean() {
        super();
    }
    
    private XpeCfgTableSetupBBean getXpeCfgTableSetupBBean() {
        XpeCfgTableSetupBBean xpeCfgTableSetupBBean =
            (XpeCfgTableSetupBBean) ADFUtils.evaluateEL("#{backingBeanScope.XpeCfgTableSetupBBean}");
        return xpeCfgTableSetupBBean;
    }
    
    //Terminal Set Up
    public void onTerminalCreation(ActionEvent actionEvent) {
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getXpeCfgTableSetupBBean().getTerminalAddItem_popup().show(hints);
    }
    
    public void onTerminalCreationSave(ActionEvent actionEvent) {
        OperationBinding opb = ADFUtils.findOperation("Commit");
        opb.execute();
        if(opb.getErrors().isEmpty()){
            this.getXpeCfgTableSetupBBean().getTerminalAddItem_popup().hide();
            JSFUtils.addFacesInformationMessage("Data Saved Successfully.");
        }else{
            JSFUtils.addFacesErrorMessage("Error while saving the data. Please contact system Administrator.");
        }
    }
    
    public void onTerminalCreationCancel(ActionEvent actionEvent) {
        this.getXpeCfgTableSetupBBean().getTerminalAddItem_popup().hide();
    }
    
    public void onTerminalEdit(ActionEvent actionEvent) {
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getXpeCfgTableSetupBBean().getTerminalEditItem_popup().show(hints);
    }
    
    public void onTerminalEditSave(ActionEvent actionEvent) {
        OperationBinding opb = ADFUtils.findOperation("Commit");
        opb.execute();
        if(opb.getErrors().isEmpty()){
            this.getXpeCfgTableSetupBBean().getTerminalEditItem_popup().hide();
            JSFUtils.addFacesInformationMessage("Data Saved Successfully.");
        }else{
            JSFUtils.addFacesErrorMessage("Error while saving the data. Please contact system Administrator.");
        }
    }
    
    public void onTerminalEditCancel(ActionEvent actionEvent) {
        this.getXpeCfgTableSetupBBean().getTerminalEditItem_popup().hide();
    }
    
    //Terminal Search Set Up
    public void onTerminalSearch(ActionEvent actionEvent) {
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getXpeCfgTableSetupBBean().getTerminalSearch_popup().show(hints);
    }
    
    public void onTerminalSearchSaveOrCancel(ActionEvent actionEvent) {
        this.getXpeCfgTableSetupBBean().getTerminalSearch_popup().hide();
    }

    public void onInActiveValChgLstnr(ValueChangeEvent valueChangeEvent) {
        DCIteratorBinding terminalsIter = ADFUtils.findIterator("XpeDccCfgTerminalsEOVOIterator");
        XpeDccCfgTerminalsEOVORowImpl terminalsRow = (XpeDccCfgTerminalsEOVORowImpl) terminalsIter.getCurrentRow();
        if (null != valueChangeEvent.getNewValue() && valueChangeEvent.getNewValue().equals("Y")) {
            terminalsRow.setInactiveDate(new Timestamp(System.currentTimeMillis()));
        } else {
            terminalsRow.setInactiveDate(null);
        }
    }
    
    public void queryOperationListener(QueryOperationEvent queryOperationEvent) {
        ADFUtils.invokeEL("#{bindings.TerminalsCriteriaQuery.processQueryOperation}",Object.class,
                 QueryOperationEvent.class, queryOperationEvent);
        if (queryOperationEvent.getOperation().name().toUpperCase().equals("RESET")) {
            DCIteratorBinding carrierIter = ADFUtils.findIterator("XpeDccCfgTerminalsEOVOIterator");
            carrierIter.getViewObject().executeEmptyRowSet();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.getXpeCfgTableSetupBBean().getTerminalSetUpTblBind());
        }
    }
}
