package view;

import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;

public class NotificationSetUpTableBBean {
    private RichTable notificationSetUpTblBind;
    private RichPopup notificationAdd_popup;
    private RichPopup notificationEdit_popup;

    public NotificationSetUpTableBBean() {
    }

    public void setNotificationSetUpTblBind(RichTable notificationSetUpTblBind) {
        this.notificationSetUpTblBind = notificationSetUpTblBind;
    }

    public RichTable getNotificationSetUpTblBind() {
        return notificationSetUpTblBind;
    }

    public void setNotificationAdd_popup(RichPopup notificationAdd_popup) {
        this.notificationAdd_popup = notificationAdd_popup;
    }

    public RichPopup getNotificationAdd_popup() {
        return notificationAdd_popup;
    }

    public void setNotificationEdit_popup(RichPopup notificationEdit_popup) {
        this.notificationEdit_popup = notificationEdit_popup;
    }

    public RichPopup getNotificationEdit_popup() {
        return notificationEdit_popup;
    }
}
