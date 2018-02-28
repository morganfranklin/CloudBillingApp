package view;

import java.sql.Timestamp;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.MethodExpression;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import model.views.entitybased.XpeDccCfgBusinessunitEOVORowImpl;
import model.views.entitybased.XpeDccCfgCountiesEOVORowImpl;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.QueryOperationEvent;

import oracle.binding.OperationBinding;

import view.utils.ADFUtils;
import view.utils.JSFUtils;

public class BusinessUnitSetUpTableMBean {
    public BusinessUnitSetUpTableMBean() {
    }
    
    private BusinessUnitSetUpTableBBean getBusinessUnitSetUpTableBBean() {
        BusinessUnitSetUpTableBBean businessUnitSetUpTableBBean =
            (BusinessUnitSetUpTableBBean) ADFUtils.evaluateEL("#{backingBeanScope.BusinessUnitSetUpTableBBean}");
        return businessUnitSetUpTableBBean;
    }

    public void onBusinessUnitCreation(ActionEvent actionEvent) {
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getBusinessUnitSetUpTableBBean().getBusinessUnitAddItem_popup().show(hints);
    }

    public void queryOperationListener(QueryOperationEvent queryOperationEvent) {
        ADFUtils.invokeEL("#{bindings.BusinessUnitCriteriaQuery.processQueryOperation}",Object.class,
                 QueryOperationEvent.class, queryOperationEvent);
        if (queryOperationEvent.getOperation().name().toUpperCase().equals("RESET")) {
            DCIteratorBinding carrierIter = ADFUtils.findIterator("XpeDccCfgBusinessunitEOVOIterator");
            carrierIter.getViewObject().executeEmptyRowSet();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.getBusinessUnitSetUpTableBBean().getBusinessUnitSetUpTblBind());
        }
    }

    public void onBusinessUnitEdit(ActionEvent actionEvent) {
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getBusinessUnitSetUpTableBBean().getBusinessUnitEditItem_popup().show(hints);
    }

    public void businessUnitCreationSave(ActionEvent actionEvent) {
        OperationBinding opb = ADFUtils.findOperation("Commit");
        opb.execute();
        if(opb.getErrors().isEmpty()){
            this.getBusinessUnitSetUpTableBBean().getBusinessUnitAddItem_popup().hide();
            JSFUtils.addFacesInformationMessage("Data Saved Successfully.");
        }else{
            JSFUtils.addFacesErrorMessage("Error while saving the data. Please contact system Administrator.");
        }
    }
    
    public void businessUnitCreationCancel(ActionEvent actionEvent) {
        this.getBusinessUnitSetUpTableBBean().getBusinessUnitAddItem_popup().hide();
    }

    public void businessUnitEditSave(ActionEvent actionEvent) {
        OperationBinding opb = ADFUtils.findOperation("Commit");
        opb.execute();
        if(opb.getErrors().isEmpty()){
            this.getBusinessUnitSetUpTableBBean().getBusinessUnitEditItem_popup().hide();
            JSFUtils.addFacesInformationMessage("Data Saved Successfully.");
        }else{
            JSFUtils.addFacesErrorMessage("Error while saving the data. Please contact system Administrator.");
        }
    }
    
    public void businessUnitEditCancel(ActionEvent actionEvent) {
        this.getBusinessUnitSetUpTableBBean().getBusinessUnitEditItem_popup().hide();
    }

    public void businessUnitInactiveValChgLstnr(ValueChangeEvent valueChangeEvent) {
        DCIteratorBinding businessUnitIter = ADFUtils.findIterator("XpeDccCfgBusinessunitEOVOIterator");
        XpeDccCfgBusinessunitEOVORowImpl businessUnitRow = (XpeDccCfgBusinessunitEOVORowImpl) businessUnitIter.getCurrentRow();
        if (null != valueChangeEvent.getNewValue() && valueChangeEvent.getNewValue().equals("Y")) {
            businessUnitRow.setInactiveDate(new Timestamp(System.currentTimeMillis()));
        } else {
            businessUnitRow.setInactiveDate(null);
        }
    }
}
