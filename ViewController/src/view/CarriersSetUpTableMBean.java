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

import view.utils.ADFUtils;
import view.utils.JSFUtils;

public class CarriersSetUpTableMBean implements Serializable{
    @SuppressWarnings("compatibility:7029674105800992849")
    private static final long serialVersionUID = 1L;

    public CarriersSetUpTableMBean() {
    }
    
    private CarriersSetUpTableBBean getcarriersSetUpTableBBean() {
        CarriersSetUpTableBBean carriersSetUpTableBBean =
            (CarriersSetUpTableBBean) ADFUtils.evaluateEL("#{backingBeanScope.CarriersSetUpTableBBean}");
        return carriersSetUpTableBBean;
    }

    public void onCarriersCreation(ActionEvent actionEvent) {
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getcarriersSetUpTableBBean().getCarrierAddItem_popup().show(hints);
    }

    public void onCarrierEdit(ActionEvent actionEvent) {
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getcarriersSetUpTableBBean().getCarrierEditItem_popup().show(hints);
    }

    public void onCarrierCreationSaveorCancel(ActionEvent actionEvent) {
        this.getcarriersSetUpTableBBean().getCarrierAddItem_popup().hide();
    }

    public void onCarrierEditSaveorCancel(ActionEvent actionEvent) {
        this.getcarriersSetUpTableBBean().getCarrierEditItem_popup().hide();
    }
    
    public void queryOperationListener(QueryOperationEvent queryOperationEvent) {
        invokeEL("#{bindings.CarriersCriteriaQuery.processQueryOperation}",Object.class,
                 QueryOperationEvent.class, queryOperationEvent);
        if (queryOperationEvent.getOperation().name().toUpperCase().equals("RESET")) {
            DCIteratorBinding carrierIter = ADFUtils.findIterator("XpeDccCfgCarriersEOVOIterator");
            carrierIter.getViewObject().executeEmptyRowSet();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.getcarriersSetUpTableBBean().getCarrierSetUpTblBind());
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

    public void onInActiveValChgLstnr(ValueChangeEvent valueChangeEvent) {
        JSFUtils.setExpressionValue("#{bindings.InactiveDate.inputValue}", new Timestamp(System.currentTimeMillis()));
    }
}
