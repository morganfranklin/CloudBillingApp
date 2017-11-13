package view;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.MethodExpression;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.RichPopup;

import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.QueryOperationEvent;

import oracle.binding.OperationBinding;

import view.utils.ADFUtils;
import view.utils.JSFUtils;

public class generalSetUpTableMBean {
    public generalSetUpTableMBean() {
    }
         
    private GeneralSetUpTableBBean getGeneralSetUpTableBBean() {
        GeneralSetUpTableBBean generalSetUpTableBBean =
            (GeneralSetUpTableBBean) ADFUtils.evaluateEL("#{backingBeanScope.GeneralSetUpTableBBean}");
        return generalSetUpTableBBean;
    }

    public void onGeneralItemCreation(ActionEvent actionEvent) {
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getGeneralSetUpTableBBean().getGeneralItemAddItem_popup().show(hints);
    }

    public void onGeneralItemDelete(ActionEvent actionEvent) {
        ADFUtils.findOperation("Commit").execute();
    }

    public void onGeneralItemSave(ActionEvent actionEvent) {
        OperationBinding opb = ADFUtils.findOperation("Commit");
        opb.execute();
        if(opb.getErrors().isEmpty()){
            this.getGeneralSetUpTableBBean().getGeneralItemAddItem_popup().hide();
            JSFUtils.addFacesInformationMessage("Data Saved Successfully.");
        }else{
            JSFUtils.addFacesErrorMessage("Error while saving the data. Please contact system Administrator.");
        }
    }
    
    public void onGeneralItemCancel(ActionEvent actionEvent) {
        this.getGeneralSetUpTableBBean().getGeneralItemAddItem_popup().hide();
    }

    public void onGeneralItemEditSave(ActionEvent actionEvent) {
        OperationBinding opb = ADFUtils.findOperation("Commit");
        opb.execute();
        if(opb.getErrors().isEmpty()){
            this.getGeneralSetUpTableBBean().getGeneralItemEditItem_popup().hide();
            JSFUtils.addFacesInformationMessage("Data Saved Successfully.");
        }else{
            JSFUtils.addFacesErrorMessage("Error while saving the data. Please contact system Administrator.");
        }
    }
    
    public void onGeneralItemEditCancel(ActionEvent actionEvent) {
        this.getGeneralSetUpTableBBean().getGeneralItemEditItem_popup().hide();
    }

    public void onGeneralItemEdit(ActionEvent actionEvent) {
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getGeneralSetUpTableBBean().getGeneralItemEditItem_popup().show(hints);
    }

    public void queryOperationListener(QueryOperationEvent queryOperationEvent) {
        ADFUtils.invokeEL("#{bindings.GeneralCriteriaQuery.processQueryOperation}",Object.class,
                 QueryOperationEvent.class, queryOperationEvent);
        if (queryOperationEvent.getOperation().name().toUpperCase().equals("RESET")) {
            DCIteratorBinding carrierIter = ADFUtils.findIterator("XpeDccCfgGeneralEOVOIterator");
            carrierIter.getViewObject().executeEmptyRowSet();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.getGeneralSetUpTableBBean().getGeneralSetUpTblBind());
        }
    }
}
