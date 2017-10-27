package view;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.MethodExpression;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.QueryOperationEvent;

import view.utils.ADFUtils;

public class AccountingSetUpTableMBean {
    public AccountingSetUpTableMBean() {
    }
    
    private AccountingSetUpTableBBean getAccountingSetUpTableBBean() {
        AccountingSetUpTableBBean accountingSetUpTableBBean =
            (AccountingSetUpTableBBean) ADFUtils.evaluateEL("#{backingBeanScope.AccountingSetUpTableBBean}");
        return accountingSetUpTableBBean;
    }

    public void onAccountingCreation(ActionEvent actionEvent) {
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getAccountingSetUpTableBBean().getAccountingAddItem_popup().show(hints);
    }

    public void queryOperationListener(QueryOperationEvent queryOperationEvent) {
        invokeEL("#{bindings.AccountingCriteriaQuery.processQueryOperation}",Object.class,
                 QueryOperationEvent.class, queryOperationEvent);
        if (queryOperationEvent.getOperation().name().toUpperCase().equals("RESET")) {
            DCIteratorBinding carrierIter = ADFUtils.findIterator("XpeDccCfgAccountingEOVOIterator");
            carrierIter.getViewObject().executeEmptyRowSet();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.getAccountingSetUpTableBBean().getAccountingSetUpTblBind());
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

    public void onAccountingCreationSaveorCancel(ActionEvent actionEvent) {
        this.getAccountingSetUpTableBBean().getAccountingAddItem_popup().hide();
    }

    public void onAccountingEditSaveorCancel(ActionEvent actionEvent) {
        this.getAccountingSetUpTableBBean().getAccountingEdit_popup().hide();
    }

    public void onAccountingEdit(ActionEvent actionEvent) {
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getAccountingSetUpTableBBean().getAccountingEdit_popup().show(hints);
    }
}