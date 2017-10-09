package view;

import oracle.adf.view.rich.component.rich.RichPopup;

public class CarriersSetUpTableBBean {
    private RichPopup carrierAddItem_popup;
    private RichPopup carrierEditItem_popup;

    public CarriersSetUpTableBBean() {
    }

    public void setCarrierAddItem_popup(RichPopup carrierAddItem_popup) {
        this.carrierAddItem_popup = carrierAddItem_popup;
    }

    public RichPopup getCarrierAddItem_popup() {
        return carrierAddItem_popup;
    }

    public void setCarrierEditItem_popup(RichPopup carrierEditItem_popup) {
        this.carrierEditItem_popup = carrierEditItem_popup;
    }

    public RichPopup getCarrierEditItem_popup() {
        return carrierEditItem_popup;
    }
}
