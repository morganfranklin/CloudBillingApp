package view;

import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;

public class BillandAccountProcessesBBean {
    private RichTable billandAccountProcessTblBind;
    private RichPopup processBillandAccount_popup;

    public BillandAccountProcessesBBean() {
    }

    public void setBillandAccountProcessTblBind(RichTable billandAccountProcessTblBind) {
        this.billandAccountProcessTblBind = billandAccountProcessTblBind;
    }

    public RichTable getBillandAccountProcessTblBind() {
        return billandAccountProcessTblBind;
    }

    public void setProcessBillandAccount_popup(RichPopup processBillandAccount_popup) {
        this.processBillandAccount_popup = processBillandAccount_popup;
    }

    public RichPopup getProcessBillandAccount_popup() {
        return processBillandAccount_popup;
    }
}
