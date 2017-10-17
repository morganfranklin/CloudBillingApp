package view;

import java.io.Serializable;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.MethodExpression;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.RichPopup;

import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.QueryOperationEvent;

import view.utils.ADFUtils;

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

    public void onGeneralConversionCreationSaveOrCancel(ActionEvent actionEvent) {
        this.getGeneralConversionSetUpTableBBean().getGeneralConversionAddItem_popup().hide();
    }

    public void onGeneralConversionEditSaveOrCancel(ActionEvent actionEvent) {
        this.getGeneralConversionSetUpTableBBean().getGeneralConversionEditItem_popup().hide();
    }

    public void queryOperationListener(QueryOperationEvent queryOperationEvent) {
        invokeEL("#{bindings.GeneralConversionCriteriaQuery.processQueryOperation}",Object.class,
                 QueryOperationEvent.class, queryOperationEvent);
        if (queryOperationEvent.getOperation().name().toUpperCase().equals("RESET")) {
            DCIteratorBinding carrierIter = ADFUtils.findIterator("XpeDccCfgGeneralCnvEOVOIterator");
            carrierIter.getViewObject().executeEmptyRowSet();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.getGeneralConversionSetUpTableBBean().getGeneralConversionSetUpTblBind());
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
}
