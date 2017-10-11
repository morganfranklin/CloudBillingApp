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

import view.utils.ADFUtils;

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

    public void onGeneralItemSaveOrCancel(ActionEvent actionEvent) {
        this.getGeneralSetUpTableBBean().getGeneralItemAddItem_popup().hide();
    }

    public void onGeneralItemEditSaveOrCancel(ActionEvent actionEvent) {
        this.getGeneralSetUpTableBBean().getGeneralItemEditItem_popup().hide();
    }

    public void onGeneralItemEdit(ActionEvent actionEvent) {
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getGeneralSetUpTableBBean().getGeneralItemEditItem_popup().show(hints);
    }

    public void queryOperationListener(QueryOperationEvent queryOperationEvent) {
        invokeEL("#{bindings.GeneralCriteriaQuery.processQueryOperation}",Object.class,
                 QueryOperationEvent.class, queryOperationEvent);
        if (queryOperationEvent.getOperation().name().toUpperCase().equals("RESET")) {
            DCIteratorBinding carrierIter = ADFUtils.findIterator("XpeDccCfgGeneralEOVOIterator");
            carrierIter.getViewObject().executeEmptyRowSet();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.getGeneralSetUpTableBBean().getGeneralSetUpTblBind());
        }
    }
    
    /**
     * @param expr
     * @param returnType
     * @param argTypes
     * @param args
     * @return
     */
    public Object invokeMethodExpression(String expr, Class returnType, Class[] argTypes, Object[] args) {
        FacesContext fc = FacesContext.getCurrentInstance();
        ELContext elctx = fc.getELContext();
        ExpressionFactory elFactory = fc.getApplication().getExpressionFactory();
        MethodExpression methodExpr = elFactory.createMethodExpression(elctx, expr, returnType, argTypes);
        return methodExpr.invoke(elctx, args);
    }

    /**
     * @param expr
     * @param returnType
     * @param argType
     * @param argument
     * @return
     */
    public Object invokeEL(String expr, Class returnType, Class argType, Object argument) {
        return invokeMethodExpression(expr, returnType, new Class[] { argType }, new Object[] { argument });
    }
}
