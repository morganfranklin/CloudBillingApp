package view;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.MethodExpression;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import model.views.entitybased.XpeDccCfgOriginsEOVOImpl;
import model.views.entitybased.XpeDccCfgOriginsEOVORowImpl;

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
    private RichPopup pcsTerminalEditItem_popup;

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
        OperationBinding opb = ADFUtils.findOperation("addAssTerminalToPCSInstallation");
        opb.execute();
        Object terminalSrchRslt = opb.getResult();
        String rtnMsg = (String) terminalSrchRslt;
        if ("DUPLICATE_EXIST".equals(rtnMsg)) {
            JSFUtils.addFacesErrorMessage("Selected Terminal is associated to Origin. Please select another terminal.");
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
        invokeEL("#{bindings.PCSCriteriaQuery.processQueryOperation}", Object.class, QueryOperationEvent.class,
                 queryOperationEvent);
        if (queryOperationEvent.getOperation().name().toUpperCase().equals("RESET")) {
            DCIteratorBinding carrierIter = ADFUtils.findIterator("XpeDccCfgPcsEOVOIterator");
            carrierIter.getViewObject().executeEmptyRowSet();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.getPcsInstallationSetUpTableBBean().getPcsInstallationSetUpTblBind());
        }
    }

    public Object invokeMethodExpression(String expr, Class returnType, Class[] argTypes, Object[] args) {
        FacesContext fc = FacesContext.getCurrentInstance();
        ELContext elctx = fc.getELContext();
        ExpressionFactory elFactory = fc.getApplication().getExpressionFactory();
        MethodExpression methodExpr = elFactory.createMethodExpression(elctx, expr, returnType, argTypes);
        return methodExpr.invoke(elctx, args);
    }

    public Object invokeEL(String expr, Class returnType, Class argType, Object argument) {
        return invokeMethodExpression(expr, returnType, new Class[] { argType }, new Object[] { argument });
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

    public void setPcsTerminalEditItem_popup(RichPopup pcsTerminalEditItem_popup) {
        this.pcsTerminalEditItem_popup = pcsTerminalEditItem_popup;
    }

    public RichPopup getPcsTerminalEditItem_popup() {
        return pcsTerminalEditItem_popup;
    }

    public void pcsTerminalSearchCancel(ActionEvent actionEvent) {
        this.getPcsInstallationSetUpTableBBean().getPcsTerminalAddItem_popup().hide();
    }
}
