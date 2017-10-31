package view;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.MethodExpression;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

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
    
    public void onTerminalCreationSaveOrCancel(ActionEvent actionEvent) {
        this.getXpeCfgTableSetupBBean().getTerminalAddItem_popup().hide();
    }
    
    public void onTerminalEdit(ActionEvent actionEvent) {
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getXpeCfgTableSetupBBean().getTerminalEditItem_popup().show(hints);
    }
    
    public void onTerminalEditSaveOrCancel(ActionEvent actionEvent) {
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
        if(null != valueChangeEvent.getNewValue() && valueChangeEvent.getNewValue().equals("Y")){
        JSFUtils.setExpressionValue("#{bindings.InactiveDate.inputValue}", new Timestamp(System.currentTimeMillis()));
        }else{
            JSFUtils.setExpressionValue("#{bindings.InactiveDate.inputValue}",null);
        }
    }
    
    public void queryOperationListener(QueryOperationEvent queryOperationEvent) {
        invokeEL("#{bindings.TerminalsCriteriaQuery.processQueryOperation}",Object.class,
                 QueryOperationEvent.class, queryOperationEvent);
        if (queryOperationEvent.getOperation().name().toUpperCase().equals("RESET")) {
            DCIteratorBinding carrierIter = ADFUtils.findIterator("XpeDccCfgTerminalsEOVOIterator");
            carrierIter.getViewObject().executeEmptyRowSet();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.getXpeCfgTableSetupBBean().getTerminalSetUpTblBind());
        }
    }
    
    /**
     * @param expr
     * @param returnType
     * @param argTypes
     * @param args
     * @return
     */
    public Object invokeMethodExpression(String expr, Class returnType, Class[] argTypes, Object[] args) {
        FacesContext fc = FacesContext.getCurrentInstance();
        ELContext elctx = fc.getELContext();
        ExpressionFactory elFactory = fc.getApplication().getExpressionFactory();
        MethodExpression methodExpr = elFactory.createMethodExpression(elctx, expr, returnType, argTypes);
        return methodExpr.invoke(elctx, args);
    }

    /**
     * @param expr
     * @param returnType
     * @param argType
     * @param argument
     * @return
     */
    public Object invokeEL(String expr, Class returnType, Class argType, Object argument) {
        return invokeMethodExpression(expr, returnType, new Class[] { argType }, new Object[] { argument });
    }
}
