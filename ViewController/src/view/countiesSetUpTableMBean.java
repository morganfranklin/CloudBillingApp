package view;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.MethodExpression;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import model.views.entitybased.XpeDccCfgCountiesEOVORowImpl;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.RichPopup;

import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.QueryOperationEvent;

import view.utils.ADFUtils;
import view.utils.JSFUtils;

public class countiesSetUpTableMBean implements Serializable{
    @SuppressWarnings("compatibility:-1524329099856585005")
    private static final long serialVersionUID = 1L;

    public countiesSetUpTableMBean() {
    }
    
    private countiesSetUpTableBBean getcountiesSetUpTableBBean() {
        countiesSetUpTableBBean countiesSetUpTavleBBean =
            (countiesSetUpTableBBean) ADFUtils.evaluateEL("#{backingBeanScope.countiesSetUpTableBBean}");
        return countiesSetUpTavleBBean;
    }

    public void onCountyCreation(ActionEvent actionEvent) {
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getcountiesSetUpTableBBean().getCountyAddItem_popup().show(hints);
    }

    public void onCountyCreationSaveorCancel(ActionEvent actionEvent) {
        this.getcountiesSetUpTableBBean().getCountyAddItem_popup().hide();
    }

    public void onCountyEditSaveorCancel(ActionEvent actionEvent) {
        this.getcountiesSetUpTableBBean().getCountyEditItem_popp().hide();
    }

    public void onCountyEdit(ActionEvent actionEvent) {
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getcountiesSetUpTableBBean().getCountyEditItem_popp().show(hints);
    }

    public void queryOperationListener(QueryOperationEvent queryOperationEvent) {
        invokeEL("#{bindings.CountiesCriteriaQuery.processQueryOperation}",Object.class,
                 QueryOperationEvent.class, queryOperationEvent);
        if (queryOperationEvent.getOperation().name().toUpperCase().equals("RESET")) {
            DCIteratorBinding carrierIter = ADFUtils.findIterator("XpeDccCfgCountiesEOVOIterator");
            carrierIter.getViewObject().executeEmptyRowSet();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.getcountiesSetUpTableBBean().getCountySetUpTblBind());
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

    public void onInactiveValChgLstnr(ValueChangeEvent valueChangeEvent) {
        DCIteratorBinding countiesIter = ADFUtils.findIterator("XpeDccCfgCountiesEOVOIterator");
        XpeDccCfgCountiesEOVORowImpl countiesRow = (XpeDccCfgCountiesEOVORowImpl) countiesIter.getCurrentRow();
        if (null != valueChangeEvent.getNewValue() && valueChangeEvent.getNewValue().equals("Y")) {
            countiesRow.setInactiveDate(new Timestamp(System.currentTimeMillis()));
        } else {
            countiesRow.setInactiveDate(null);
        }
    }
}
