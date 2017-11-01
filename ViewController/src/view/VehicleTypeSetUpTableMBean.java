package view;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.MethodExpression;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import model.views.entitybased.XpeDccCfgVehiclesEOVORowImpl;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.RichPopup;

import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.QueryOperationEvent;

import view.utils.ADFUtils;
import view.utils.JSFUtils;

public class VehicleTypeSetUpTableMBean implements Serializable {
    @SuppressWarnings("compatibility:7971573688997836872")
    private static final long serialVersionUID = 1L;

    public VehicleTypeSetUpTableMBean() {
    }
    
    private VehicleTypeSetUpTableBBean getVehicleTypeSetUpTableBBean() {
        VehicleTypeSetUpTableBBean vehicleTypeSetUpTableBBean =
            (VehicleTypeSetUpTableBBean) ADFUtils.evaluateEL("#{backingBeanScope.VehicleTypeSetUpTableBBean}");
        return vehicleTypeSetUpTableBBean;
    }

    public void onVehicleTypeCreation(ActionEvent actionEvent) {
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getVehicleTypeSetUpTableBBean().getVehicleTypeAddItem_popup().show(hints);
    }

    public void onVehicleTypeEdit(ActionEvent actionEvent) {
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getVehicleTypeSetUpTableBBean().getVehicleTypeSetUpEdit_popup().show(hints);
    }

    public void onVehicleTypeCreationSaveorCancel(ActionEvent actionEvent) {
        this.getVehicleTypeSetUpTableBBean().getVehicleTypeAddItem_popup().hide();
    }

    public void onVehicleTypeEditSaveorCancel(ActionEvent actionEvent) {
        this.getVehicleTypeSetUpTableBBean().getVehicleTypeSetUpEdit_popup().hide();
    }

    public void onInactiveValChgLstnr(ValueChangeEvent valueChangeEvent) {
        DCIteratorBinding vehicleTypesIter = ADFUtils.findIterator("XpeDccCfgVehiclesEOVOIterator");
        XpeDccCfgVehiclesEOVORowImpl vehicleTypesRow = (XpeDccCfgVehiclesEOVORowImpl) vehicleTypesIter.getCurrentRow();
        if (null != valueChangeEvent.getNewValue() && valueChangeEvent.getNewValue().equals("Y")){
            vehicleTypesRow.setInactiveDate(new Timestamp(System.currentTimeMillis()));
        }else{
            vehicleTypesRow.setInactiveDate(null);
        }
    }

    public void queryOperationListener(QueryOperationEvent queryOperationEvent) {
        invokeEL("#{bindings.VehiclesCriteriaQuery.processQueryOperation}",Object.class,
                 QueryOperationEvent.class, queryOperationEvent);
        if (queryOperationEvent.getOperation().name().toUpperCase().equals("RESET")) {
            DCIteratorBinding carrierIter = ADFUtils.findIterator("XpeDccCfgVehiclesEOVOIterator");
            carrierIter.getViewObject().executeEmptyRowSet();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.getVehicleTypeSetUpTableBBean().getVehicleTypeSetUpTblBind());
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
