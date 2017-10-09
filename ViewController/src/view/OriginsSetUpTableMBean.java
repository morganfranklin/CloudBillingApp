package view;

import java.io.Serializable;

import javax.faces.event.ActionEvent;

import oracle.adf.view.rich.component.rich.RichPopup;

import view.utils.ADFUtils;

public class OriginsSetUpTableMBean implements Serializable {
    @SuppressWarnings("compatibility:1404748106680805910")
    private static final long serialVersionUID = 1L;

    public OriginsSetUpTableMBean() {
    }
    
    private OriginSetUpTableBBean getOriginSetUpTableBBean() {
        OriginSetUpTableBBean originSetUpTableBean =
            (OriginSetUpTableBBean) ADFUtils.evaluateEL("#{backingBeanScope.OriginSetUpTableBBean}");
        return originSetUpTableBean;
    }

    public void onTerminalSearchSaveorCancel(ActionEvent actionEvent) {
        this.getOriginSetUpTableBBean().getOrgAssTerminalCreation_popup().hide();
    }

    public void onTerminalEditSaveorCancel(ActionEvent actionEvent) {
        this.getOriginSetUpTableBBean().getOrgAssTerminalEdit_popup().hide();
    }

    public void onTerminalSearch(ActionEvent actionEvent) {
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getOriginSetUpTableBBean().getOrgAssTerminalCreation_popup().show(hints);
    }

    public void onTerminalEdit(ActionEvent actionEvent) {
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getOriginSetUpTableBBean().getOrgAssTerminalEdit_popup().show(hints);
    }
}
