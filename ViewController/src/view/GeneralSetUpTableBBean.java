package view;

import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;

public class GeneralSetUpTableBBean {
    private RichPopup generalItemAddItem_popup;
    private RichPopup generalItemEditItem_popup;
    private RichTable generalSetUpTblBind;

    public GeneralSetUpTableBBean() {
    }

    public void setGeneralItemAddItem_popup(RichPopup generalItemAddItem_popup) {
        this.generalItemAddItem_popup = generalItemAddItem_popup;
    }

    public RichPopup getGeneralItemAddItem_popup() {
        return generalItemAddItem_popup;
    }

    public void setGeneralItemEditItem_popup(RichPopup generalItemEditItem_popup) {
        this.generalItemEditItem_popup = generalItemEditItem_popup;
    }

    public RichPopup getGeneralItemEditItem_popup() {
        return generalItemEditItem_popup;
    }

    public void setGeneralSetUpTblBind(RichTable generalSetUpTblBind) {
        this.generalSetUpTblBind = generalSetUpTblBind;
    }

    public RichTable getGeneralSetUpTblBind() {
        return generalSetUpTblBind;
    }
}
