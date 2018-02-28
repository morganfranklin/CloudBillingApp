package view;

import java.sql.Timestamp;

import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import model.views.entitybased.XpeDccCfgBusinessunitEOVORowImpl;

import model.views.entitybased.XpeDccCfgUserBusinessUnitEOVORowImpl;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.QueryOperationEvent;

import oracle.binding.OperationBinding;

import view.utils.ADFUtils;
import view.utils.JSFUtils;

public class UserBusinessUnitSetUpTableMBean {
    public UserBusinessUnitSetUpTableMBean() {
    }
    
    private UserBusinessUnitSetUpTableBBean getUserBusinessUnitSetUpTableBBean() {
        UserBusinessUnitSetUpTableBBean userBusinessUnitSetUpTableBBean =
            (UserBusinessUnitSetUpTableBBean) ADFUtils.evaluateEL("#{backingBeanScope.UserBusinessUnitSetUpTableBBean}");
        return userBusinessUnitSetUpTableBBean;
    }
    
    public void onUserBusinessUnitCreation(ActionEvent actionEvent) {
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getUserBusinessUnitSetUpTableBBean().getUserBusinessUnitSetupAddItem_popup().show(hints);
    }

    public void queryOperationListener(QueryOperationEvent queryOperationEvent) {
        ADFUtils.invokeEL("#{bindings.UserBusinessUnitCriteriaQuery.processQueryOperation}",Object.class,
                 QueryOperationEvent.class, queryOperationEvent);
        if (queryOperationEvent.getOperation().name().toUpperCase().equals("RESET")) {
            DCIteratorBinding usrBusUnitIter = ADFUtils.findIterator("XpeDccCfgUserBusinessUnitEOVO1Iterator");
            usrBusUnitIter.getViewObject().executeEmptyRowSet();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.getUserBusinessUnitSetUpTableBBean().getUserBusinessUnitSetupTable());
        }
    }

    public void UserBusinessUnitCreationSave(ActionEvent actionEvent) {
        OperationBinding opb = ADFUtils.findOperation("Commit");
        opb.execute();
        if(opb.getErrors().isEmpty()){
            this.getUserBusinessUnitSetUpTableBBean().getUserBusinessUnitSetupAddItem_popup().hide();
            JSFUtils.addFacesInformationMessage("Data Saved Successfully.");
        }else{
            JSFUtils.addFacesErrorMessage("Error while saving the data. Please contact system Administrator.");
        }
    }

    public void UserBusinessUnitCreationCancel(ActionEvent actionEvent) {
        this.getUserBusinessUnitSetUpTableBBean().getUserBusinessUnitSetupAddItem_popup().hide();
    }

    public void userBusinessUnitInactiveValChgLstnr(ValueChangeEvent valueChangeEvent) {
        DCIteratorBinding usrBusinessUnitIter = ADFUtils.findIterator("XpeDccCfgUserBusinessUnitEOVO1Iterator");
        XpeDccCfgUserBusinessUnitEOVORowImpl usrBusinessUnitRow = (XpeDccCfgUserBusinessUnitEOVORowImpl) usrBusinessUnitIter.getCurrentRow();
        if (null != valueChangeEvent.getNewValue() && valueChangeEvent.getNewValue().equals("Y")) {
            usrBusinessUnitRow.setInactiveDate(new Timestamp(System.currentTimeMillis()));
        } else {
            usrBusinessUnitRow.setInactiveDate(null);
        }
    }

    public void onUserBusinessUnitEdit(ActionEvent actionEvent) {
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getUserBusinessUnitSetUpTableBBean().getUserBusinessUnitSetUpEditItem_popup().show(hints);
    }

    public void UserBusinessUnitEditSave(ActionEvent actionEvent) {
        OperationBinding opb = ADFUtils.findOperation("Commit");
        opb.execute();
        if(opb.getErrors().isEmpty()){
            this.getUserBusinessUnitSetUpTableBBean().getUserBusinessUnitSetUpEditItem_popup().hide();
            JSFUtils.addFacesInformationMessage("Data Saved Successfully.");
        }else{
            JSFUtils.addFacesErrorMessage("Error while saving the data. Please contact system Administrator.");
        }
    }

    public void UserBusinessUnitEditCancel(ActionEvent actionEvent) {
        this.getUserBusinessUnitSetUpTableBBean().getUserBusinessUnitSetUpEditItem_popup().hide();
    }
}
