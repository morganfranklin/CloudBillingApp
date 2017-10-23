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

public class BillingandAccountingProcessesMBean {
    public BillingandAccountingProcessesMBean() {
    }
    
    private BillandAccountProcessesBBean getBillandAccountProcessesBBean() {
        BillandAccountProcessesBBean billandAccountProcessesBBean =
            (BillandAccountProcessesBBean) ADFUtils.evaluateEL("#{backingBeanScope.BillandAccountProcessesBBean}");
        return billandAccountProcessesBBean;
    }

    public void onBillandAccountCreation(ActionEvent actionEvent) {
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getBillandAccountProcessesBBean().getProcessBillandAccount_popup().show(hints);
    }

    public void processBillingandAccounting(ActionEvent actionEvent) {
        this.getBillandAccountProcessesBBean().getProcessBillandAccount_popup().hide();
    }

    public void onBillingandAccountCancel(ActionEvent actionEvent) {
        this.getBillandAccountProcessesBBean().getProcessBillandAccount_popup().hide();
    }

    public void queryOperationListener(QueryOperationEvent queryOperationEvent) {
        invokeEL("#{bindings.BillingAccountingProcessesCriteriaQuery.processQueryOperation}",Object.class,
                 QueryOperationEvent.class, queryOperationEvent);
        if (queryOperationEvent.getOperation().name().toUpperCase().equals("RESET")) {
            DCIteratorBinding carrierIter = ADFUtils.findIterator("XpeBillAccountProcessesEOVO1Iterator");
            carrierIter.getViewObject().executeEmptyRowSet();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.getBillandAccountProcessesBBean().getBillandAccountProcessTblBind());
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
}
