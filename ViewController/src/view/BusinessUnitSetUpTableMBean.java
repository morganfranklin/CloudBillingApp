package view;

import java.sql.Timestamp;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.MethodExpression;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import model.views.entitybased.XpeDccCfgBusinessunitEOVORowImpl;
import model.views.entitybased.XpeDccCfgCountiesEOVORowImpl;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.QueryOperationEvent;

import view.utils.ADFUtils;

public class BusinessUnitSetUpTableMBean {
    public BusinessUnitSetUpTableMBean() {
    }
    
    private BusinessUnitSetUpTableBBean getBusinessUnitSetUpTableBBean() {
        BusinessUnitSetUpTableBBean businessUnitSetUpTableBBean =
            (BusinessUnitSetUpTableBBean) ADFUtils.evaluateEL("#{backingBeanScope.BusinessUnitSetUpTableBBean}");
        return businessUnitSetUpTableBBean;
    }

    public void onBusinessUnitCreation(ActionEvent actionEvent) {
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getBusinessUnitSetUpTableBBean().getBusinessUnitAddItem_popup().show(hints);
    }

    public void queryOperationListener(QueryOperationEvent queryOperationEvent) {
        invokeEL("#{bindings.BusinessUnitCriteriaQuery.processQueryOperation}",Object.class,
                 QueryOperationEvent.class, queryOperationEvent);
        if (queryOperationEvent.getOperation().name().toUpperCase().equals("RESET")) {
            DCIteratorBinding carrierIter = ADFUtils.findIterator("XpeDccCfgBusinessunitEOVOIterator");
            carrierIter.getViewObject().executeEmptyRowSet();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.getBusinessUnitSetUpTableBBean().getBusinessUnitSetUpTblBind());
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

    public void onBusinessUnitEdit(ActionEvent actionEvent) {
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getBusinessUnitSetUpTableBBean().getBusinessUnitEditItem_popup().show(hints);
    }

    public void businessUnitCreationSaveorCancel(ActionEvent actionEvent) {
        this.getBusinessUnitSetUpTableBBean().getBusinessUnitAddItem_popup().hide();
    }

    public void businessUnitEditSaveorCancel(ActionEvent actionEvent) {
        this.getBusinessUnitSetUpTableBBean().getBusinessUnitEditItem_popup().hide();
    }

    public void businessUnitInactiveValChgLstnr(ValueChangeEvent valueChangeEvent) {
        DCIteratorBinding businessUnitIter = ADFUtils.findIterator("XpeDccCfgBusinessunitEOVOIterator");
        XpeDccCfgBusinessunitEOVORowImpl businessUnitRow = (XpeDccCfgBusinessunitEOVORowImpl) businessUnitIter.getCurrentRow();
        if (null != valueChangeEvent.getNewValue() && valueChangeEvent.getNewValue().equals("Y")) {
            businessUnitRow.setInactiveDate(new Timestamp(System.currentTimeMillis()));
        } else {
            businessUnitRow.setInactiveDate(null);
        }
    }
}
