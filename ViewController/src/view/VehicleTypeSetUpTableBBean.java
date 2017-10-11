package view;

import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;

public class VehicleTypeSetUpTableBBean {
    private RichPopup vehicleTypeAddItem_popup;
    private RichPopup vehicleTypeSetUpEdit_popup;
    private RichTable vehicleTypeSetUpTblBind;

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

    public void setVehicleTypeSetUpTblBind(RichTable vehicleTypeSetUpTblBind) {
        this.vehicleTypeSetUpTblBind = vehicleTypeSetUpTblBind;
    }

    public RichTable getVehicleTypeSetUpTblBind() {
        return vehicleTypeSetUpTblBind;
    }
}
