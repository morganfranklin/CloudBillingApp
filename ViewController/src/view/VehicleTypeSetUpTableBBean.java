package view;

import oracle.adf.view.rich.component.rich.RichPopup;

public class VehicleTypeSetUpTableBBean {
    private RichPopup vehicleTypeAddItem_popup;
    private RichPopup vehicleTypeSetUpEdit_popup;

    public VehicleTypeSetUpTableBBean() {
    }

    public void setVehicleTypeAddItem_popup(RichPopup vehicleTypeAddItem_popup) {
        this.vehicleTypeAddItem_popup = vehicleTypeAddItem_popup;
    }

    public RichPopup getVehicleTypeAddItem_popup() {
        return vehicleTypeAddItem_popup;
    }

    public void setVehicleTypeSetUpEdit_popup(RichPopup vehicleTypeSetUpEdit_popup) {
        this.vehicleTypeSetUpEdit_popup = vehicleTypeSetUpEdit_popup;
    }

    public RichPopup getVehicleTypeSetUpEdit_popup() {
        return vehicleTypeSetUpEdit_popup;
    }
}
