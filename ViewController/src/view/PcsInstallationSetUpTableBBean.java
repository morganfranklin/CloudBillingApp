package view;

import oracle.adf.view.rich.component.rich.RichPopup;

public class PcsInstallationSetUpTableBBean {
    private RichPopup pcsTerminalAddItem_popup;
    private RichPopup pcsTerminalEditItem_popup;

    public PcsInstallationSetUpTableBBean() {
    }

    public void setPcsTerminalAddItem_popup(RichPopup pcsTerminalAddItem_popup) {
        this.pcsTerminalAddItem_popup = pcsTerminalAddItem_popup;
    }

    public RichPopup getPcsTerminalAddItem_popup() {
        return pcsTerminalAddItem_popup;
    }

    public void setPcsTerminalEditItem_popup(RichPopup pcsTerminalEditItem_popup) {
        this.pcsTerminalEditItem_popup = pcsTerminalEditItem_popup;
    }

    public RichPopup getPcsTerminalEditItem_popup() {
        return pcsTerminalEditItem_popup;
    }
}
