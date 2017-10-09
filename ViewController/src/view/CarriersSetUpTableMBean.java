package view;

import java.io.Serializable;

import javax.faces.event.ActionEvent;

import oracle.adf.view.rich.component.rich.RichPopup;

import view.utils.ADFUtils;

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
}
