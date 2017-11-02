package view;

import java.sql.Timestamp;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.MethodExpression;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import model.views.entitybased.XpeDccCfgNotifGroupsEOVORowImpl;
import model.views.entitybased.XpeDccCfgNotificationEOVOImpl;
import model.views.entitybased.XpeDccCfgNotificationEOVORowImpl;

import model.views.entitybased.XpeDccCfgPcsshortnamesEOVOImpl;
import model.views.entitybased.XpeDccCfgPcsshortnamesEOVORowImpl;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.QueryOperationEvent;

import view.utils.ADFUtils;

public class NotificationSetUpTableMBean {
    public NotificationSetUpTableMBean() {
    }
    
    private NotificationSetUpTableBBean getNotificationSetUpTableBBean() {
        NotificationSetUpTableBBean notificationSetUpTableBBean =
            (NotificationSetUpTableBBean) ADFUtils.evaluateEL("#{backingBeanScope.NotificationSetUpTableBBean}");
        return notificationSetUpTableBBean;
    }

    public void queryOperationListener(QueryOperationEvent queryOperationEvent) {
        ADFUtils.invokeEL("#{bindings.NotificationCriteriaQuery.processQueryOperation}",Object.class,
                 QueryOperationEvent.class, queryOperationEvent);
        if (queryOperationEvent.getOperation().name().toUpperCase().equals("RESET")) {
            DCIteratorBinding carrierIter = ADFUtils.findIterator("XpeDccCfgNotificationEOVO1Iterator");
            carrierIter.getViewObject().executeEmptyRowSet();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.getNotificationSetUpTableBBean().getNotificationSetUpTblBind());
        }
    }

    public void onNotificationCreation(ActionEvent actionEvent) {
        DCIteratorBinding dcIterBind = ADFUtils.findIterator("XpeDccCfgNewNotificationEOVOIterator");
        XpeDccCfgNotificationEOVOImpl notifImpl = (XpeDccCfgNotificationEOVOImpl) dcIterBind.getViewObject();
        notifImpl.executeQuery();
        XpeDccCfgNotificationEOVORowImpl notifeRowImpl = (XpeDccCfgNotificationEOVORowImpl) notifImpl.createRow();
        notifImpl.insertRow(notifeRowImpl);
        notifImpl.setCurrentRow(notifeRowImpl);
    }

    public void onNotificationEdit(ActionEvent actionEvent) {
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getNotificationSetUpTableBBean().getNotificationEdit_popup().show(hints);
    }

    public void notificationAddSaveorCancel(ActionEvent actionEvent) {
        this.getNotificationSetUpTableBBean().getNotificationAdd_popup().hide();
    }

    public void notificationEditSaveorCancel(ActionEvent actionEvent) {
        this.getNotificationSetUpTableBBean().getNotificationEdit_popup().hide();
    }

    public void inactiveNotificationValChgLstnr(ValueChangeEvent valueChangeEvent) {
        DCIteratorBinding notificationsIter = ADFUtils.findIterator("XpeDccCfgNotificationEOVO1Iterator");
        XpeDccCfgNotificationEOVORowImpl notificationsRow =
            (XpeDccCfgNotificationEOVORowImpl) notificationsIter.getCurrentRow();
        if (null != valueChangeEvent.getNewValue() && valueChangeEvent.getNewValue().equals("Y")){
            notificationsRow.setInactiveDate(new Timestamp(System.currentTimeMillis()));
        }else{
            notificationsRow.setInactiveDate(null);
        }
    }

    public void inactiveNotifGrpValChgLstnr(ValueChangeEvent valueChangeEvent) {
        DCIteratorBinding notifGrpIter = ADFUtils.findIterator("XpeDccCfgNotifGroupsEOVO1Iterator");
        XpeDccCfgNotifGroupsEOVORowImpl notifGrpRow =
            (XpeDccCfgNotifGroupsEOVORowImpl) notifGrpIter.getCurrentRow();
        if (null != valueChangeEvent.getNewValue() && valueChangeEvent.getNewValue().equals("Y")){
            notifGrpRow.setInactiveDate(new Timestamp(System.currentTimeMillis()));
        }else{
            notifGrpRow.setInactiveDate(null);
        }
    }
}
