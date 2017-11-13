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

import oracle.binding.OperationBinding;

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

    public void onVehicleTypeCreationSave(ActionEvent actionEvent) {
        OperationBinding opb = ADFUtils.findOperation("Commit");
        opb.execute();
        if(opb.getErrors().isEmpty()){
            this.getVehicleTypeSetUpTableBBean().getVehicleTypeAddItem_popup().hide();
            JSFUtils.addFacesInformationMessage("Data Saved Successfully.");
        }else{
            JSFUtils.addFacesErrorMessage("Error while saving the data. Please contact system Administrator.");
        }
    }
    
    public void onVehicleTypeCreationCancel(ActionEvent actionEvent) {
        this.getVehicleTypeSetUpTableBBean().getVehicleTypeAddItem_popup().hide();
    }

    public void onVehicleTypeEditSave(ActionEvent actionEvent) {
        OperationBinding opb = ADFUtils.findOperation("Commit");
        opb.execute();
        if(opb.getErrors().isEmpty()){
            this.getVehicleTypeSetUpTableBBean().getVehicleTypeSetUpEdit_popup().hide();
            JSFUtils.addFacesInformationMessage("Data Saved Successfully.");
        }else{
            JSFUtils.addFacesErrorMessage("Error while saving the data. Please contact system Administrator.");
        }
    }
    
    public void onVehicleTypeEditCancel(ActionEvent actionEvent) {
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
        ADFUtils.invokeEL("#{bindings.VehiclesCriteriaQuery.processQueryOperation}",Object.class,
                 QueryOperationEvent.class, queryOperationEvent);
        if (queryOperationEvent.getOperation().name().toUpperCase().equals("RESET")) {
            DCIteratorBinding carrierIter = ADFUtils.findIterator("XpeDccCfgVehiclesEOVOIterator");
            carrierIter.getViewObject().executeEmptyRowSet();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.getVehicleTypeSetUpTableBBean().getVehicleTypeSetUpTblBind());
        }
    }
}
