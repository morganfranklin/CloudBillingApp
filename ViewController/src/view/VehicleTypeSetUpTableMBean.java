package view;

import java.io.Serializable;

import javax.faces.event.ActionEvent;

import oracle.adf.view.rich.component.rich.RichPopup;

import view.utils.ADFUtils;

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
}
