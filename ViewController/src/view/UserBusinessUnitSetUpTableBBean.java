package view;

import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;

public class UserBusinessUnitSetUpTableBBean {
    private RichTable userBusinessUnitSetupTable;
    private RichPopup userBusinessUnitSetupAddItem_popup;
    private RichPopup userBusinessUnitSetUpEditItem_popup;

    public UserBusinessUnitSetUpTableBBean() {
    }

    public void setUserBusinessUnitSetupTable(RichTable userBusinessUnitSetupTable) {
        this.userBusinessUnitSetupTable = userBusinessUnitSetupTable;
    }

    public RichTable getUserBusinessUnitSetupTable() {
        return userBusinessUnitSetupTable;
    }

    public void setUserBusinessUnitSetupAddItem_popup(RichPopup userBusinessUnitSetupAddItem_popup) {
        this.userBusinessUnitSetupAddItem_popup = userBusinessUnitSetupAddItem_popup;
    }

    public RichPopup getUserBusinessUnitSetupAddItem_popup() {
        return userBusinessUnitSetupAddItem_popup;
    }

    public void setUserBusinessUnitSetUpEditItem_popup(RichPopup userBusinessUnitSetUpEditItem_popup) {
        this.userBusinessUnitSetUpEditItem_popup = userBusinessUnitSetUpEditItem_popup;
    }

    public RichPopup getUserBusinessUnitSetUpEditItem_popup() {
        return userBusinessUnitSetUpEditItem_popup;
    }
}
