package view;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.MethodExpression;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import model.views.entitybased.XpeDccCfgCountiesEOVORowImpl;

import model.views.entitybased.XpeDccCfgGeneralCnvEOVORowImpl;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.RichPopup;

import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.QueryOperationEvent;

import oracle.binding.OperationBinding;

import view.utils.ADFUtils;
import view.utils.JSFUtils;

public class GeneralConversionSetUpTableMBean implements Serializable{
    @SuppressWarnings("compatibility:-5253779638613274066")
    private static final long serialVersionUID = 1L;

    public GeneralConversionSetUpTableMBean() {
    }
    
    private GeneralConversionSetUpTableBBean getGeneralConversionSetUpTableBBean() {
        GeneralConversionSetUpTableBBean generalConversionSetUpTableBBean =
            (GeneralConversionSetUpTableBBean) ADFUtils.evaluateEL("#{backingBeanScope.GeneralConversionSetUpTableBBean}");
        return generalConversionSetUpTableBBean;
    }

    public void onGeneralConversionCreation(ActionEvent actionEvent) {
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getGeneralConversionSetUpTableBBean().getGeneralConversionAddItem_popup().show(hints);
    }

    public void onGeneralConversionEdit(ActionEvent actionEvent) {
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getGeneralConversionSetUpTableBBean().getGeneralConversionEditItem_popup().show(hints);
    }

    public void onGeneralConversionCreationSave(ActionEvent actionEvent) {
        OperationBinding opb = ADFUtils.findOperation("Commit");
        opb.execute();
        if(opb.getErrors().isEmpty()){
            this.getGeneralConversionSetUpTableBBean().getGeneralConversionAddItem_popup().hide();
            JSFUtils.addFacesInformationMessage("Data Saved Successfully.");
        }else{
            JSFUtils.addFacesErrorMessage("Error while saving the data. Please contact system Administrator.");
        }
    }
    
    public void onGeneralConversionCreationCancel(ActionEvent actionEvent) {
        this.getGeneralConversionSetUpTableBBean().getGeneralConversionAddItem_popup().hide();
    }

    public void onGeneralConversionEditSave(ActionEvent actionEvent) {
        OperationBinding opb = ADFUtils.findOperation("Commit");
        opb.execute();
        if(opb.getErrors().isEmpty()){
            this.getGeneralConversionSetUpTableBBean().getGeneralConversionEditItem_popup().hide();
            JSFUtils.addFacesInformationMessage("Data Saved Successfully.");
        }else{
            JSFUtils.addFacesErrorMessage("Error while saving the data. Please contact system Administrator.");
        }
    }
    
    public void onGeneralConversionEditCancel(ActionEvent actionEvent) {
        this.getGeneralConversionSetUpTableBBean().getGeneralConversionEditItem_popup().hide();
    }

    public void queryOperationListener(QueryOperationEvent queryOperationEvent) {
        ADFUtils.invokeEL("#{bindings.GeneralConversionCriteriaQuery.processQueryOperation}",Object.class,
                 QueryOperationEvent.class, queryOperationEvent);
        if (queryOperationEvent.getOperation().name().toUpperCase().equals("RESET")) {
            DCIteratorBinding carrierIter = ADFUtils.findIterator("XpeDccCfgGeneralCnvEOVOIterator");
            carrierIter.getViewObject().executeEmptyRowSet();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.getGeneralConversionSetUpTableBBean().getGeneralConversionSetUpTblBind());
        }
    }

    public void onInactiveValChgLstnr(ValueChangeEvent valueChangeEvent) {
        DCIteratorBinding genCnvIter = ADFUtils.findIterator("XpeDccCfgGeneralCnvEOVOIterator");
        XpeDccCfgGeneralCnvEOVORowImpl genCnvRow = (XpeDccCfgGeneralCnvEOVORowImpl) genCnvIter.getCurrentRow();
        if (null != valueChangeEvent.getNewValue() && valueChangeEvent.getNewValue().equals("Y")) {
            genCnvRow.setInactiveDate(new Timestamp(System.currentTimeMillis()));
        } else {
            genCnvRow.setInactiveDate(null);
        }
    }
}
