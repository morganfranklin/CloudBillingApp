package view;

import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;

public class GeneralConversionSetUpTableBBean {
    private RichTable generalConversionSetUpTblBind;
    private RichPopup generalConversionAddItem_popup;
    private RichPopup generalConversionEditItem_popup;

    public GeneralConversionSetUpTableBBean() {
    }

    public void setGeneralConversionSetUpTblBind(RichTable generalConversionSetUpTblBind) {
        this.generalConversionSetUpTblBind = generalConversionSetUpTblBind;
    }

    public RichTable getGeneralConversionSetUpTblBind() {
        return generalConversionSetUpTblBind;
    }

    public void setGeneralConversionAddItem_popup(RichPopup generalConversionAddItem_popup) {
        this.generalConversionAddItem_popup = generalConversionAddItem_popup;
    }

    public RichPopup getGeneralConversionAddItem_popup() {
        return generalConversionAddItem_popup;
    }

    public void setGeneralConversionEditItem_popup(RichPopup generalConversionEditItem_popup) {
        this.generalConversionEditItem_popup = generalConversionEditItem_popup;
    }

    public RichPopup getGeneralConversionEditItem_popup() {
        return generalConversionEditItem_popup;
    }
}
