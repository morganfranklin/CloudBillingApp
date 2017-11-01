package view;

import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;

public class BusinessUnitSetUpTableBBean {
    private RichTable businessUnitSetUpTblBind;
    private RichPopup businessUnitAddItem_popup;
    private RichPopup businessUnitEditItem_popup;

    public BusinessUnitSetUpTableBBean() {
    }

    public void setBusinessUnitSetUpTblBind(RichTable businessUnitSetUpTblBind) {
        this.businessUnitSetUpTblBind = businessUnitSetUpTblBind;
    }

    public RichTable getBusinessUnitSetUpTblBind() {
        return businessUnitSetUpTblBind;
    }

    public void setBusinessUnitAddItem_popup(RichPopup businessUnitAddItem_popup) {
        this.businessUnitAddItem_popup = businessUnitAddItem_popup;
    }

    public RichPopup getBusinessUnitAddItem_popup() {
        return businessUnitAddItem_popup;
    }

    public void setBusinessUnitEditItem_popup(RichPopup businessUnitEditItem_popup) {
        this.businessUnitEditItem_popup = businessUnitEditItem_popup;
    }

    public RichPopup getBusinessUnitEditItem_popup() {
        return businessUnitEditItem_popup;
    }
}
