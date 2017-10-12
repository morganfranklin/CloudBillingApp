package view;

import java.sql.Timestamp;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.MethodExpression;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import model.views.entitybased.XpeDccCfgOriginsEOVOImpl;
import model.views.entitybased.XpeDccCfgOriginsEOVORowImpl;

import model.views.entitybased.XpeDccCfgProductserviceEOVOImpl;

import model.views.entitybased.XpeDccCfgProductserviceEOVORowImpl;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.RichPopup;

import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.QueryOperationEvent;

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

    public void productServiceUomEditSaveOrCancel(ActionEvent actionEvent) {
        this.getProductServiceSetUpTableBBean().getProductServiceUomEditItem_popup().hide();
    }

    public void queryOperationListener(QueryOperationEvent queryOperationEvent) {
        invokeEL("#{bindings.ProductServiceCriteriaQuery.processQueryOperation}",Object.class,
                 QueryOperationEvent.class, queryOperationEvent);
        if (queryOperationEvent.getOperation().name().toUpperCase().equals("RESET")) {
            DCIteratorBinding carrierIter = ADFUtils.findIterator("XpeDccCfgProductserviceEOVOIterator");
            carrierIter.getViewObject().executeEmptyRowSet();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.getProductServiceSetUpTableBBean().getProductServiceSetUpTblBind());
        }
    }
    
    public Object invokeMethodExpression(String expr, Class returnType, Class[] argTypes, Object[] args) {
        FacesContext fc = FacesContext.getCurrentInstance();
        ELContext elctx = fc.getELContext();
        ExpressionFactory elFactory = fc.getApplication().getExpressionFactory();
        MethodExpression methodExpr = elFactory.createMethodExpression(elctx, expr, returnType, argTypes);
        return methodExpr.invoke(elctx, args);
    }

    public Object invokeEL(String expr, Class returnType, Class argType, Object argument) {
        return invokeMethodExpression(expr, returnType, new Class[] { argType }, new Object[] { argument });
    }
    
    public void onEditPrdtInactiveValChgLstnr(ValueChangeEvent valueChangeEvent) {
        JSFUtils.setExpressionValue("#{bindings.InactiveDate.inputValue}", new Timestamp(System.currentTimeMillis()));
    }

    public void onEditPrdtUomInactiveValChgLstnr(ValueChangeEvent valueChangeEvent) {
        JSFUtils.setExpressionValue("#{bindings.InactiveDate1.inputValue}", new Timestamp(System.currentTimeMillis()));
    }

    public void onAddPrdtUomInactiveValChgLstnr(ValueChangeEvent valueChangeEvent) {
        JSFUtils.setExpressionValue("#{bindings.InactiveDate.inputValue}", new Timestamp(System.currentTimeMillis()));
    }

    public void onProductServiceCreation(ActionEvent actionEvent) {
        DCIteratorBinding dcIterBind = ADFUtils.findIterator("XpeDccCfgNewProductserviceEOVOIterator");
        XpeDccCfgProductserviceEOVOImpl prdServiceImpl = (XpeDccCfgProductserviceEOVOImpl) dcIterBind.getViewObject();
        prdServiceImpl.executeQuery();
        XpeDccCfgProductserviceEOVORowImpl prdServiceRowImpl = (XpeDccCfgProductserviceEOVORowImpl) prdServiceImpl.createRow();
        prdServiceImpl.insertRow(prdServiceRowImpl);
        prdServiceImpl.setCurrentRow(prdServiceRowImpl);
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("ItemId", prdServiceRowImpl.getItemId());
    }
}
