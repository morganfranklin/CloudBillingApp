package view;

import java.sql.Timestamp;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.MethodExpression;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import model.views.entitybased.XpeDccCfgOriginsEOVOImpl;
import model.views.entitybased.XpeDccCfgOriginsEOVORowImpl;

import model.views.entitybased.XpeDccCfgProductserviceEOVOImpl;

import model.views.entitybased.XpeDccCfgProductserviceEOVORowImpl;

import model.views.entitybased.XpeDccCfgUomEOVORowImpl;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.RichPopup;

import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.QueryOperationEvent;

import oracle.binding.OperationBinding;

import oracle.jbo.Row;

import view.utils.ADFUtils;
import view.utils.JSFUtils;

public class ProductServiceSetUpTableMBean {
    public ProductServiceSetUpTableMBean() {
    }

    private ProductServiceSetUpTableBBean getProductServiceSetUpTableBBean() {
        ProductServiceSetUpTableBBean productServiceSetUpTableBBean =
            (ProductServiceSetUpTableBBean) ADFUtils.evaluateEL("#{backingBeanScope.ProductServiceSetUpTableBBean}");
        return productServiceSetUpTableBBean;
    }

    public void onProductUomCreation(ActionEvent actionEvent) {
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getProductServiceSetUpTableBBean().getProductServiceUomAddItem_popup().show(hints);
    }

    public void productServiceUomSaveorCancel(ActionEvent actionEvent) {
        this.getProductServiceSetUpTableBBean().getProductServiceUomAddItem_popup().hide();
    }

    public void onProductUomEdit(ActionEvent actionEvent) {
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getProductServiceSetUpTableBBean().getProductServiceUomEditItem_popup().show(hints);
    }

    public void productServiceUomEditSave(ActionEvent actionEvent) {
        this.getProductServiceSetUpTableBBean().getProductServiceUomEditItem_popup().hide();
    }
    
    public void productServiceUomEditCancel(ActionEvent actionEvent) {
        DCIteratorBinding prdServiceUomIter = ADFUtils.findIterator("XpeDccCfgNewUomEOVOIterator");
        XpeDccCfgUomEOVORowImpl prdServiceUomRow = (XpeDccCfgUomEOVORowImpl) prdServiceUomIter.getCurrentRow();
        prdServiceUomRow.refresh(Row.REFRESH_UNDO_CHANGES|Row.REFRESH_WITH_DB_FORGET_CHANGES); 
        this.getProductServiceSetUpTableBBean().getProductServiceUomEditItem_popup().hide();
    }

    public void queryOperationListener(QueryOperationEvent queryOperationEvent) {
        ADFUtils.invokeEL("#{bindings.ProductServiceCriteriaQuery.processQueryOperation}", Object.class,
                 QueryOperationEvent.class, queryOperationEvent);
        if (queryOperationEvent.getOperation().name().toUpperCase().equals("RESET")) {
            DCIteratorBinding carrierIter = ADFUtils.findIterator("XpeDccCfgProductserviceEOVOIterator");
            carrierIter.getViewObject().executeEmptyRowSet();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.getProductServiceSetUpTableBBean().getProductServiceSetUpTblBind());
        }
    }

    public void onEditPrdtInactiveValChgLstnr(ValueChangeEvent valueChangeEvent) {
        DCIteratorBinding prdServiceIter = ADFUtils.findIterator("XpeDccCfgNewProductserviceEOVOIterator");
        XpeDccCfgProductserviceEOVORowImpl prdServiceRow =
            (XpeDccCfgProductserviceEOVORowImpl) prdServiceIter.getCurrentRow();
        if (null != valueChangeEvent.getNewValue() && valueChangeEvent.getNewValue().equals("Y")) {
            prdServiceRow.setInactiveDate(new Timestamp(System.currentTimeMillis()));
        } else {
            prdServiceRow.setInactiveDate(null);
        }
    }

    public void onEditPrdtUomInactiveValChgLstnr(ValueChangeEvent valueChangeEvent) {
        DCIteratorBinding prdServiceUomIter = ADFUtils.findIterator("XpeDccCfgNewUomEOVOIterator");
        XpeDccCfgUomEOVORowImpl prdServiceUomRow = (XpeDccCfgUomEOVORowImpl) prdServiceUomIter.getCurrentRow();
        if (null != valueChangeEvent.getNewValue() && valueChangeEvent.getNewValue().equals("Y")) {
            prdServiceUomRow.setInactiveDate(new Timestamp(System.currentTimeMillis()));
        } else {
            prdServiceUomRow.setInactiveDate(null);
        }
    }

    public void onAddPrdtUomInactiveValChgLstnr(ValueChangeEvent valueChangeEvent) {
        DCIteratorBinding prdServiceUomIter = ADFUtils.findIterator("XpeDccCfgNewUomEOVOIterator");
        XpeDccCfgUomEOVORowImpl prdServiceUomRow = (XpeDccCfgUomEOVORowImpl) prdServiceUomIter.getCurrentRow();
        if (null != valueChangeEvent.getNewValue() && valueChangeEvent.getNewValue().equals("Y")) {
            prdServiceUomRow.setInactiveDate(new Timestamp(System.currentTimeMillis()));
        } else {
            prdServiceUomRow.setInactiveDate(null);
        }
    }

    public void onProductServiceCreation(ActionEvent actionEvent) {
        DCIteratorBinding dcIterBind = ADFUtils.findIterator("XpeDccCfgNewProductserviceEOVOIterator");
        XpeDccCfgProductserviceEOVOImpl prdServiceImpl = (XpeDccCfgProductserviceEOVOImpl) dcIterBind.getViewObject();
        prdServiceImpl.executeQuery();
        XpeDccCfgProductserviceEOVORowImpl prdServiceRowImpl =
            (XpeDccCfgProductserviceEOVORowImpl) prdServiceImpl.createRow();
        prdServiceImpl.insertRow(prdServiceRowImpl);
        prdServiceImpl.setCurrentRow(prdServiceRowImpl);
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("ItemId", prdServiceRowImpl.getItemId());
    }

    public void productServiceSaveActnLstnr(ActionEvent actionEvent) {
        String itemType = (String) ADFUtils.evaluateEL("#{bindings.ItemType.inputValue}");
        if (null != itemType && "PRD".equals(itemType)) {
            DCIteratorBinding prdUOMIter = ADFUtils.findIterator("XpeDccCfgNewUomEOVOIterator");
            long rowCount = prdUOMIter.getEstimatedRowCount();
            if (rowCount > 0) {
                this.commitPrdctSrvc();
            } else {
                JSFUtils.addFacesErrorMessage("Please Add atleast one UOM.");
            }
        } else {
            this.commitPrdctSrvc();
        }
    }
    
    public void commitPrdctSrvc(){
        OperationBinding opb = ADFUtils.findOperation("Commit");
        opb.execute();
        if (opb.getErrors().isEmpty()) {
            JSFUtils.addFacesInformationMessage("Data Saved Successfully.");
        } else {
            JSFUtils.addFacesErrorMessage("Error while saving the data. Please contact system Administrator.");
        }
    }

    public void itemTypeValChgLstnr(ValueChangeEvent valueChangeEvent) {
        if(null != valueChangeEvent.getNewValue() && valueChangeEvent.getNewValue().equals("MAT")){
            FacesMessage fm = new FacesMessage("Category is Required for Material Type");
            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
                    FacesContext context = FacesContext.getCurrentInstance();
                    context.addMessage(getProductServiceSetUpTableBBean().getCategoryIdBind().getClientId(context), fm);
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(getProductServiceSetUpTableBBean().getCategoryIdBind());
    }
}
