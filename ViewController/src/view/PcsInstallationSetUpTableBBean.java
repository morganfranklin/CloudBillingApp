package view;

import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;

public class PcsInstallationSetUpTableBBean {
    private RichPopup pcsTerminalAddItem_popup;
    private RichPopup pcsTerminalEditItem_popup;
    private RichTable pcsInstallationSetUpTblBind;
    private RichPopup pcsAddressAdd_popup;
    private RichPopup pcsAddressEdit_popup;

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

    public void setPcsInstallationSetUpTblBind(RichTable pcsInstallationSetUpTblBind) {
        this.pcsInstallationSetUpTblBind = pcsInstallationSetUpTblBind;
    }

    public RichTable getPcsInstallationSetUpTblBind() {
        return pcsInstallationSetUpTblBind;
    }

    public void setPcsAddressAdd_popup(RichPopup pcsAddressAdd_popup) {
        this.pcsAddressAdd_popup = pcsAddressAdd_popup;
    }

    public RichPopup getPcsAddressAdd_popup() {
        return pcsAddressAdd_popup;
    }

    public void setPcsAddressEdit_popup(RichPopup pcsAddressEdit_popup) {
        this.pcsAddressEdit_popup = pcsAddressEdit_popup;
    }

    public RichPopup getPcsAddressEdit_popup() {
        return pcsAddressEdit_popup;
    }
}
