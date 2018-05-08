package view;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.MethodExpression;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import model.views.entitybased.XpeDccCfgCountiesEOVOImpl;
import model.views.entitybased.XpeDccCfgCountiesEOVORowImpl;

import model.views.readonly.XpeDccCfgCountiesROVOImpl;

import model.views.readonly.XpeDccCfgCountiesROVORowImpl;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.RichPopup;

import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.QueryOperationEvent;

import oracle.binding.OperationBinding;

import view.utils.ADFUtils;
import view.utils.JSFUtils;

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

    public void onCountyCreationSave(ActionEvent actionEvent) {
        String countyName = (String) ADFUtils.evaluateEL("#{bindings.CountyName.inputValue}");
        String stateName = (String) ADFUtils.evaluateEL("#{bindings.State.inputValue}");
        String country = (String) ADFUtils.evaluateEL("#{bindings.Country.inputValue}");
        if (this.checkDuplicateCounty(countyName, stateName)) {
            JSFUtils.addFacesErrorMessage("County Name Exists. Please Enter Another County Name.");
        } else if (this.checkInvalidCombination(country, stateName)) {
            JSFUtils.addFacesErrorMessage("Invalid State/Country Combination.");
        } else {
            OperationBinding opb = ADFUtils.findOperation("Commit");
            opb.execute();
            if (opb.getErrors().isEmpty()) {
                this.getcountiesSetUpTableBBean().getCountyAddItem_popup().hide();
                JSFUtils.addFacesInformationMessage("Data Saved Successfully.");
            } else {
                JSFUtils.addFacesErrorMessage("Error while saving the data. Please contact system Administrator.");
            }
        }
    }
    
    public boolean checkDuplicateCounty(String countyName, String stateName){
        boolean rtnVal = false;        
        DCIteratorBinding countiesIter = ADFUtils.findIterator("XpeDccCfgCountiesROVO1Iterator");
        XpeDccCfgCountiesROVOImpl countiesView = (XpeDccCfgCountiesROVOImpl) countiesIter.getViewObject();
        countiesView.setApplyViewCriteriaName("XpeDccCfgCountiesROVOCriteria", false);
        countiesView.setNamedWhereClauseParam("bindCountyName", countyName);
        countiesView.setNamedWhereClauseParam("bindState", stateName);
        countiesView.executeQuery();
        XpeDccCfgCountiesROVORowImpl countiesViewRow = (XpeDccCfgCountiesROVORowImpl) countiesView.first();
        if(null != countiesViewRow){
            rtnVal = true;
        }
        return rtnVal;
    }
    
    public boolean checkInvalidCombination(String countryName, String stateName){
        boolean rtnVal = false;    
        if(null != stateName && "XX".equals(stateName) && null != countryName && "USA".equals(countryName)){
            rtnVal = true;
        }
        return rtnVal;
    }
    
    public void onCountyCreationCancel(ActionEvent actionEvent) {
        this.getcountiesSetUpTableBBean().getCountyAddItem_popup().hide();
    }

    public void onCountyEditSave(ActionEvent actionEvent) {
        String countyName = (String) ADFUtils.evaluateEL("#{bindings.CountyName1.inputValue}");
        String stateName = (String) ADFUtils.evaluateEL("#{bindings.State1.inputValue}");
        String country = (String) ADFUtils.evaluateEL("#{bindings.Country1.inputValue}");
        if (this.checkDuplicateCounty(countyName, stateName)) {
            JSFUtils.addFacesErrorMessage("County Name Exists. Please Enter Another County Name.");
        } else if (this.checkInvalidCombination(country, stateName)) {
            JSFUtils.addFacesErrorMessage("Invalid State/Country Combination.");
        } else {
            OperationBinding opb = ADFUtils.findOperation("Commit");
            opb.execute();
            if (opb.getErrors().isEmpty()) {
                this.getcountiesSetUpTableBBean().getCountyEditItem_popp().hide();
                JSFUtils.addFacesInformationMessage("Data Saved Successfully.");
            } else {
                JSFUtils.addFacesErrorMessage("Error while saving the data. Please contact system Administrator.");
            }
        }
    }
    
    public void onCountyEditCancel(ActionEvent actionEvent) {
        this.getcountiesSetUpTableBBean().getCountyEditItem_popp().hide();
    }

    public void onCountyEdit(ActionEvent actionEvent) {
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getcountiesSetUpTableBBean().getCountyEditItem_popp().show(hints);
    }
    
    public void commitCounty(){
        OperationBinding opb = ADFUtils.findOperation("Commit");
        opb.execute();
        if (opb.getErrors().isEmpty()) {
            this.getcountiesSetUpTableBBean().getCountyEditItem_popp().hide();
            JSFUtils.addFacesInformationMessage("Data Saved Successfully.");
        } else {
            JSFUtils.addFacesErrorMessage("Error while saving the data. Please contact system Administrator.");
        }
    }

    public void queryOperationListener(QueryOperationEvent queryOperationEvent) {
        ADFUtils.invokeEL("#{bindings.CountiesCriteriaQuery.processQueryOperation}",Object.class,
                 QueryOperationEvent.class, queryOperationEvent);
        if (queryOperationEvent.getOperation().name().toUpperCase().equals("RESET")) {
            DCIteratorBinding carrierIter = ADFUtils.findIterator("XpeDccCfgCountiesEOVOIterator");
            carrierIter.getViewObject().executeEmptyRowSet();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.getcountiesSetUpTableBBean().getCountySetUpTblBind());
        }
    }

    public void onInactiveValChgLstnr(ValueChangeEvent valueChangeEvent) {
        DCIteratorBinding countiesIter = ADFUtils.findIterator("XpeDccCfgCountiesEOVOIterator");
        XpeDccCfgCountiesEOVORowImpl countiesRow = (XpeDccCfgCountiesEOVORowImpl) countiesIter.getCurrentRow();
        if (null != valueChangeEvent.getNewValue() && valueChangeEvent.getNewValue().equals("Y")) {
            countiesRow.setInactiveDate(new Timestamp(System.currentTimeMillis()));
        } else {
            countiesRow.setInactiveDate(null);
        }        
    }

    public void stateValChgLstnr(ValueChangeEvent valueChangeEvent) {
        DCIteratorBinding countiesIter = ADFUtils.findIterator("XpeDccCfgCountiesEOVOIterator");
        XpeDccCfgCountiesEOVOImpl countiesView = (XpeDccCfgCountiesEOVOImpl) countiesIter.getViewObject();
        XpeDccCfgCountiesEOVORowImpl countiesViewRow = (XpeDccCfgCountiesEOVORowImpl) countiesView.getCurrentRow();
        if (null != valueChangeEvent.getNewValue() && !valueChangeEvent.getNewValue().equals("XX")) {
            this.getcountiesSetUpTableBBean().getCountryBind().setValue("USA");
            countiesViewRow.setCountry("USA");
        } else {
            this.getcountiesSetUpTableBBean().getCountryBind().setValue(null);
            countiesViewRow.setCountry(null);
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.getcountiesSetUpTableBBean().getCountryBind());
    }
    
    public void newCountyStateValChgLstnr(ValueChangeEvent valueChangeEvent) {
        DCIteratorBinding countiesIter = ADFUtils.findIterator("XpeDccCfgNewCountiesCreationEOVOIterator");
        XpeDccCfgCountiesEOVOImpl countiesView = (XpeDccCfgCountiesEOVOImpl) countiesIter.getViewObject();
        XpeDccCfgCountiesEOVORowImpl countiesViewRow = (XpeDccCfgCountiesEOVORowImpl) countiesView.getCurrentRow();
        if (null != valueChangeEvent.getNewValue() && !valueChangeEvent.getNewValue().equals("XX")) {
            this.getcountiesSetUpTableBBean().getCountryBind().setValue("USA");
            countiesViewRow.setCountry("USA");
        } else {
            this.getcountiesSetUpTableBBean().getCountryBind().setValue(null);
            countiesViewRow.setCountry(null);
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.getcountiesSetUpTableBBean().getCountryBind());
    }
}
