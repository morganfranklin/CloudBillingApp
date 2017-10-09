package view;

import oracle.adf.view.rich.component.rich.RichPopup;

public class OriginSetUpTableBBean {
    private RichPopup originCreationAddItem_popup;
    private RichPopup originSetUpEdit_popup;
    private RichPopup orgAssTerminalCreation_popup;
    private RichPopup orgAssTerminalEdit_popup;

    public OriginSetUpTableBBean() {
    }

    public void setOriginCreationAddItem_popup(RichPopup originCreationAddItem_popup) {
        this.originCreationAddItem_popup = originCreationAddItem_popup;
    }

    public RichPopup getOriginCreationAddItem_popup() {
        return originCreationAddItem_popup;
    }

    public void setOriginSetUpEdit_popup(RichPopup originSetUpEdit_popup) {
        this.originSetUpEdit_popup = originSetUpEdit_popup;
    }

    public RichPopup getOriginSetUpEdit_popup() {
        return originSetUpEdit_popup;
    }

    public void setOrgAssTerminalCreation_popup(RichPopup orgAssTerminalCreation_popup) {
        this.orgAssTerminalCreation_popup = orgAssTerminalCreation_popup;
    }

    public RichPopup getOrgAssTerminalCreation_popup() {
        return orgAssTerminalCreation_popup;
    }

    public void setOrgAssTerminalEdit_popup(RichPopup orgAssTerminalEdit_popup) {
        this.orgAssTerminalEdit_popup = orgAssTerminalEdit_popup;
    }

    public RichPopup getOrgAssTerminalEdit_popup() {
        return orgAssTerminalEdit_popup;
    }
}
