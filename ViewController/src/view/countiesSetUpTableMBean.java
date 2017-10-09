package view;

import java.io.Serializable;

import javax.faces.event.ActionEvent;

import oracle.adf.view.rich.component.rich.RichPopup;

import view.utils.ADFUtils;

public class countiesSetUpTableMBean implements Serializable{
    @SuppressWarnings("compatibility:-1524329099856585005")
    private static final long serialVersionUID = 1L;

    public countiesSetUpTableMBean() {
    }
    
    private countiesSetUpTableBBean getcountiesSetUpTableBBean() {
        countiesSetUpTableBBean countiesSetUpTavleBBean =
            (countiesSetUpTableBBean) ADFUtils.evaluateEL("#{backingBeanScope.countiesSetUpTableBBean}");
        return countiesSetUpTavleBBean;
    }

    public void onCountyCreation(ActionEvent actionEvent) {
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getcountiesSetUpTableBBean().getCountyAddItem_popup().show(hints);
    }

    public void onCountyCreationSaveorCancel(ActionEvent actionEvent) {
        this.getcountiesSetUpTableBBean().getCountyAddItem_popup().hide();
    }

    public void onCountyEditSaveorCancel(ActionEvent actionEvent) {
        this.getcountiesSetUpTableBBean().getCountyEditItem_popp().hide();
    }

    public void onCountyEdit(ActionEvent actionEvent) {
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getcountiesSetUpTableBBean().getCountyEditItem_popp().show(hints);
    }
}
