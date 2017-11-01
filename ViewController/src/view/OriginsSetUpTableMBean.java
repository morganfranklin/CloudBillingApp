package view;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.MethodExpression;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import model.views.entitybased.XpeDccCfgOgnAssTerminalsEOVORowImpl;
import model.views.entitybased.XpeDccCfgOriginsEOVOImpl;

import model.views.entitybased.XpeDccCfgOriginsEOVORowImpl;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.RichPopup;

import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.QueryOperationEvent;

import oracle.binding.OperationBinding;

import view.utils.ADFUtils;
import view.utils.JSFUtils;

public class OriginsSetUpTableMBean implements Serializable {
    @SuppressWarnings("compatibility:1404748106680805910")
    private static final long serialVersionUID = 1L;

    public OriginsSetUpTableMBean() {
    }

    private OriginSetUpTableBBean getOriginSetUpTableBBean() {
        OriginSetUpTableBBean originSetUpTableBean =
            (OriginSetUpTableBBean) ADFUtils.evaluateEL("#{backingBeanScope.OriginSetUpTableBBean}");
        return originSetUpTableBean;
    }

    public void onTerminalSearchSave(ActionEvent actionEvent) {
        OperationBinding opb = ADFUtils.findOperation("addAssTerminalToOrigin");
        opb.execute();
        Object terminalSrchRslt = opb.getResult();
        String rtnMsg = (String) terminalSrchRslt;
        if ("DUPLICATE_EXIST".equals(rtnMsg)) {
            JSFUtils.addFacesErrorMessage("Selected Terminal is associated to Origin. Please select another terminal.");
        } else {
            this.getOriginSetUpTableBBean().getOrgAssTerminalCreation_popup().hide();
        }
    }

    public void onTerminalEditSaveorCancel(ActionEvent actionEvent) {
        this.getOriginSetUpTableBBean().getOrgAssTerminalEdit_popup().hide();
    }

    public void onTerminalSearch(ActionEvent actionEvent) {
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getOriginSetUpTableBBean().getOrgAssTerminalCreation_popup().show(hints);
    }

    public void onTerminalEdit(ActionEvent actionEvent) {
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getOriginSetUpTableBBean().getOrgAssTerminalEdit_popup().show(hints);
    }

    public void queryOperationListener(QueryOperationEvent queryOperationEvent) {
        invokeEL("#{bindings.OriginsCriteriaQuery.processQueryOperation}", Object.class, QueryOperationEvent.class,
                 queryOperationEvent);
        if (queryOperationEvent.getOperation().name().toUpperCase().equals("RESET")) {
            DCIteratorBinding carrierIter = ADFUtils.findIterator("XpeDccCfgOriginsEOVOIterator");
            carrierIter.getViewObject().executeEmptyRowSet();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.getOriginSetUpTableBBean().getOriginsSetUpTblBind());
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

    public void onOriginCreation(ActionEvent actionEvent) {
        DCIteratorBinding dcIterBind = ADFUtils.findIterator("XpeDccCfgNewOriginsEOVOIterator");
        XpeDccCfgOriginsEOVOImpl originImpl = (XpeDccCfgOriginsEOVOImpl) dcIterBind.getViewObject();
        originImpl.executeQuery();
        XpeDccCfgOriginsEOVORowImpl originRowImpl = (XpeDccCfgOriginsEOVORowImpl) originImpl.createRow();
        originImpl.insertRow(originRowImpl);
        originImpl.setCurrentRow(originRowImpl);
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("OriginId", originRowImpl.getOriginId());
    }

    public void onTerminalSearchCancel(ActionEvent actionEvent) {
        this.getOriginSetUpTableBBean().getOrgAssTerminalCreation_popup().hide();
    }

    public void onOriginInactiveValChgLstnr(ValueChangeEvent valueChangeEvent) {
        DCIteratorBinding originIter = ADFUtils.findIterator("XpeDccCfgNewOriginsEOVOIterator");
        XpeDccCfgOriginsEOVORowImpl originRow = (XpeDccCfgOriginsEOVORowImpl) originIter.getCurrentRow();
        if (null != valueChangeEvent.getNewValue() && valueChangeEvent.getNewValue().equals("Y")){
            originRow.setInactiveDate(new Timestamp(System.currentTimeMillis()));
        }else{
            originRow.setInactiveDate(null);
        }
    }

    public void onTerminalInactiveValChgLstnr(ValueChangeEvent valueChangeEvent) {
        DCIteratorBinding orgAssocTermIter = ADFUtils.findIterator("XpeDccCfgNewOgnAssTerminalsEOVOIterator");
        XpeDccCfgOgnAssTerminalsEOVORowImpl orgAssocTermRow =
            (XpeDccCfgOgnAssTerminalsEOVORowImpl) orgAssocTermIter.getCurrentRow();
        if (null != valueChangeEvent.getNewValue() && valueChangeEvent.getNewValue().equals("Y")){
            orgAssocTermRow.setInactiveDate(new Timestamp(System.currentTimeMillis()));
        }else{
            orgAssocTermRow.setInactiveDate(null);
        }
    }

    public void onAddOgnTerminalInactiveValChgLstnr(ValueChangeEvent valueChangeEvent) {
        DCIteratorBinding orgAssocTermIter = ADFUtils.findIterator("XpeDccCfgNewOgnAssTerminalsEOVOIterator");
        XpeDccCfgOgnAssTerminalsEOVORowImpl orgAssocTermRow =
            (XpeDccCfgOgnAssTerminalsEOVORowImpl) orgAssocTermIter.getCurrentRow();
        if (null != valueChangeEvent.getNewValue() && valueChangeEvent.getNewValue().equals("Y")){
            orgAssocTermRow.setInactiveDate(new Timestamp(System.currentTimeMillis()));
        }else{
            orgAssocTermRow.setInactiveDate(null);
        }
    }
}
