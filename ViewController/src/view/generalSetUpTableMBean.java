package view;

import javax.faces.event.ActionEvent;

import oracle.adf.view.rich.component.rich.RichPopup;

import view.utils.ADFUtils;

public class generalSetUpTableMBean {
    public generalSetUpTableMBean() {
    }
         
    private GeneralSetUpTableBBean getGeneralSetUpTableBBean() {
        GeneralSetUpTableBBean generalSetUpTableBBean =
            (GeneralSetUpTableBBean) ADFUtils.evaluateEL("#{backingBeanScope.GeneralSetUpTableBBean}");
        return generalSetUpTableBBean;
    }

    public void onGeneralItemCreation(ActionEvent actionEvent) {
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getGeneralSetUpTableBBean().getGeneralItemAddItem_popup().show(hints);
    }

    public void onGeneralItemDelete(ActionEvent actionEvent) {
        ADFUtils.findOperation("Commit").execute();
    }

    public void onGeneralItemSaveOrCancel(ActionEvent actionEvent) {
        this.getGeneralSetUpTableBBean().getGeneralItemAddItem_popup().hide();
    }

    public void onGeneralItemEditSaveOrCancel(ActionEvent actionEvent) {
        this.getGeneralSetUpTableBBean().getGeneralItemEditItem_popup().hide();
    }

    public void onGeneralItemEdit(ActionEvent actionEvent) {
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getGeneralSetUpTableBBean().getGeneralItemEditItem_popup().show(hints);
    }
}
