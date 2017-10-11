package view;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.MethodExpression;

import javax.faces.context.FacesContext;

import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.QueryOperationEvent;

import view.utils.ADFUtils;
import view.utils.JSFUtils;

public class CarriersSetUpTableBBean {
    private RichPopup carrierAddItem_popup;
    private RichPopup carrierEditItem_popup;
    private RichTable carrierSetUpTblBind;

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

    public void setCarrierSetUpTblBind(RichTable carrierSetUpTblBind) {
        this.carrierSetUpTblBind = carrierSetUpTblBind;
    }

    public RichTable getCarrierSetUpTblBind() {
        return carrierSetUpTblBind;
    }
}
