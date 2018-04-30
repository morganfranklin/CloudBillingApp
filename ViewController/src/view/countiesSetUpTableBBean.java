package view;

import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;

public class countiesSetUpTableBBean {
    private RichPopup countyAddItem_popup;
    private RichPopup countyEditItem_popp;
    private RichTable countySetUpTblBind;
    private RichSelectOneChoice countryBind;

    public countiesSetUpTableBBean() {
    }

    public void setCountyAddItem_popup(RichPopup countyAddItem_popup) {
        this.countyAddItem_popup = countyAddItem_popup;
    }

    public RichPopup getCountyAddItem_popup() {
        return countyAddItem_popup;
    }

    public void setCountyEditItem_popp(RichPopup countyEditItem_popp) {
        this.countyEditItem_popp = countyEditItem_popp;
    }

    public RichPopup getCountyEditItem_popp() {
        return countyEditItem_popp;
    }

    public void setCountySetUpTblBind(RichTable countySetUpTblBind) {
        this.countySetUpTblBind = countySetUpTblBind;
    }

    public RichTable getCountySetUpTblBind() {
        return countySetUpTblBind;
    }

    public void setCountryBind(RichSelectOneChoice countryBind) {
        this.countryBind = countryBind;
    }

    public RichSelectOneChoice getCountryBind() {
        return countryBind;
    }
}
