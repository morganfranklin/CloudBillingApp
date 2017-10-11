package view;

import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;

public class countiesSetUpTableBBean {
    private RichPopup countyAddItem_popup;
    private RichPopup countyEditItem_popp;
    private RichTable countySetUpTblBind;

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
}
