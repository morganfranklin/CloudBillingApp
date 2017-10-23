package view;

import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;

public class AccountingSetUpTableBBean {
    private RichTable accountingSetUpTblBind;
    private RichPopup accountingAddItem_popup;
    private RichPopup accountingEdit_popup;

    public AccountingSetUpTableBBean() {
    }

    public void setAccountingSetUpTblBind(RichTable accountingSetUpTblBind) {
        this.accountingSetUpTblBind = accountingSetUpTblBind;
    }

    public RichTable getAccountingSetUpTblBind() {
        return accountingSetUpTblBind;
    }

    public void setAccountingAddItem_popup(RichPopup accountingAddItem_popup) {
        this.accountingAddItem_popup = accountingAddItem_popup;
    }

    public RichPopup getAccountingAddItem_popup() {
        return accountingAddItem_popup;
    }

    public void setAccountingEdit_popup(RichPopup accountingEdit_popup) {
        this.accountingEdit_popup = accountingEdit_popup;
    }

    public RichPopup getAccountingEdit_popup() {
        return accountingEdit_popup;
    }
}
