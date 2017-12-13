package view;

import java.sql.Timestamp;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.MethodExpression;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import model.views.entitybased.XpeDccCfgAccountingEOVORowImpl;
import model.views.entitybased.XpeDccCfgBusinessunitEOVORowImpl;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.QueryOperationEvent;

import oracle.binding.OperationBinding;

import view.utils.ADFUtils;
import view.utils.JSFUtils;

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

    public void onAccountingCreationCancel(ActionEvent actionEvent) {
        this.getAccountingSetUpTableBBean().getAccountingAddItem_popup().hide();
    }

    public void onAccountingEditCancel(ActionEvent actionEvent) {
        this.getAccountingSetUpTableBBean().getAccountingEdit_popup().hide();
    }

    public void onAccountingEdit(ActionEvent actionEvent) {
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getAccountingSetUpTableBBean().getAccountingEdit_popup().show(hints);
    }

    public void onAccountingCreationSave(ActionEvent actionEvent) {
        OperationBinding opb = ADFUtils.findOperation("Commit");
        opb.execute();
        if(opb.getErrors().isEmpty()){
            this.getAccountingSetUpTableBBean().getAccountingAddItem_popup().hide();
            JSFUtils.addFacesInformationMessage("Data Saved Successfully.");
        }else{
            JSFUtils.addFacesErrorMessage("Error while saving the data. Please contact system Administrator.");
        }
    }

    public void onAccountingEditSave(ActionEvent actionEvent) {
        OperationBinding opb = ADFUtils.findOperation("Commit");
        opb.execute();
        if(opb.getErrors().isEmpty()){
            this.getAccountingSetUpTableBBean().getAccountingEdit_popup().hide();
            JSFUtils.addFacesInformationMessage("Data Saved Successfully.");
        }else{
            JSFUtils.addFacesErrorMessage("Error while saving the data. Please contact system Administrator.");
        }
    }

    public void accountingSetUpTblValChgLstnr(ValueChangeEvent valueChangeEvent) {
        DCIteratorBinding accountingUnitIter = ADFUtils.findIterator("XpeDccCfgAccountingEOVOIterator");
        XpeDccCfgAccountingEOVORowImpl accountingUnitRow = (XpeDccCfgAccountingEOVORowImpl) accountingUnitIter.getCurrentRow();
        if (null != valueChangeEvent.getNewValue() && valueChangeEvent.getNewValue().equals("Y")) {
            accountingUnitRow.setInactiveDate(new Timestamp(System.currentTimeMillis()));
        } else {
            accountingUnitRow.setInactiveDate(null);
        }
    }
}
