package view;

import javax.faces.event.ActionEvent;

import oracle.adf.view.rich.component.rich.RichPopup;

import view.utils.ADFUtils;

public class PcsInstallationSetUpTableMBean {
    public PcsInstallationSetUpTableMBean() {
    }
    
    private PcsInstallationSetUpTableBBean getPcsInstallationSetUpTableBBean() {
        PcsInstallationSetUpTableBBean pcsInstallationSetUpTableBBean =
            (PcsInstallationSetUpTableBBean) ADFUtils.evaluateEL("#{backingBeanScope.PcsInstallationSetUpTableBBean}");
        return pcsInstallationSetUpTableBBean;
    }

    public void onTerminalSearch(ActionEvent actionEvent) {
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getPcsInstallationSetUpTableBBean().getPcsTerminalAddItem_popup().show(hints);
    }

    public void pcsTerminalSearchSaveorCancel(ActionEvent actionEvent) {
        this.getPcsInstallationSetUpTableBBean().getPcsTerminalAddItem_popup().hide();
    }

    public void pcsTerminalEditSaveorCancel(ActionEvent actionEvent) {
        this.getPcsInstallationSetUpTableBBean().getPcsTerminalEditItem_popup().hide();
    }

    public void onTerminalEdit(ActionEvent actionEvent) {
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getPcsInstallationSetUpTableBBean().getPcsTerminalEditItem_popup().show(hints);
    }
}
