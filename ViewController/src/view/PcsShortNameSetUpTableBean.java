package view;

import java.io.Serializable;

import java.math.BigDecimal;
import java.math.BigInteger;

import java.sql.Timestamp;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.MethodExpression;

import javax.faces.context.FacesContext;

import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import model.views.entitybased.XpeDccCfgOriginsEOVOImpl;
import model.views.entitybased.XpeDccCfgOriginsEOVORowImpl;

import model.views.entitybased.XpeDccCfgPcsshortnamesEOVOImpl;

import model.views.entitybased.XpeDccCfgPcsshortnamesEOVORowImpl;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.QueryOperationEvent;

import oracle.binding.OperationBinding;

import view.utils.ADFUtils;
import view.utils.JSFUtils;

public class PcsShortNameSetUpTableBean implements Serializable {
    @SuppressWarnings("compatibility:-2467857551141199013")
    private static final long serialVersionUID = 1L;

    public PcsShortNameSetUpTableBean() {
    }

    private PcsShortNameSetUpTableBBean getPcsShortNameSetUpTableBBean() {
        PcsShortNameSetUpTableBBean pcsShortNameSetUpTableBBean =
            (PcsShortNameSetUpTableBBean) ADFUtils.evaluateEL("#{backingBeanScope.PcsShortNameSetUpTableBBean}");
        return pcsShortNameSetUpTableBBean;
    }

    public void queryOperationListener(QueryOperationEvent queryOperationEvent) {
        ADFUtils.invokeEL("#{bindings.PCSShortNameCriteriaQuery.processQueryOperation}", Object.class, QueryOperationEvent.class,
                 queryOperationEvent);
        if (queryOperationEvent.getOperation().name().toUpperCase().equals("RESET")) {
            DCIteratorBinding carrierIter = ADFUtils.findIterator("XpeDccCfgPcsshortnamesEOVOIterator");
            carrierIter.getViewObject().executeEmptyRowSet();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.getPcsShortNameSetUpTableBBean().getPcsShortNamesSetUpTblBind());
        }
    }

    public void onPcsShortNameCreation(ActionEvent actionEvent) {
        DCIteratorBinding dcIterBind = ADFUtils.findIterator("XpeDccCfgNewPcsshortnamesEOVOIterator");
        XpeDccCfgPcsshortnamesEOVOImpl pcsShortNameImpl = (XpeDccCfgPcsshortnamesEOVOImpl) dcIterBind.getViewObject();
        pcsShortNameImpl.executeQuery();
        XpeDccCfgPcsshortnamesEOVORowImpl pcsShortNameRowImpl =
            (XpeDccCfgPcsshortnamesEOVORowImpl) pcsShortNameImpl.createRow();
        pcsShortNameImpl.insertRow(pcsShortNameRowImpl);
        pcsShortNameImpl.setCurrentRow(pcsShortNameRowImpl);
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("PcsShortNameId",
                                                                    pcsShortNameRowImpl.getPcsshortnameId());
    }

    public void onEditPcsShortNameInactiveValChgLstnr(ValueChangeEvent valueChangeEvent) {
        DCIteratorBinding pcsShortNameIter = ADFUtils.findIterator("XpeDccCfgPcsshortnamesEOVOIterator");
        XpeDccCfgPcsshortnamesEOVORowImpl pcsShortNameRow =
            (XpeDccCfgPcsshortnamesEOVORowImpl) pcsShortNameIter.getCurrentRow();
        if (null != valueChangeEvent.getNewValue() && valueChangeEvent.getNewValue().equals("Y")) {
            pcsShortNameRow.setInactiveDate(new Timestamp(System.currentTimeMillis()));
        } else {
            pcsShortNameRow.setInactiveDate(null);
        }
    }

    public void pcsShortNamesSaveActnLstnr(ActionEvent actionEvent) {
        OperationBinding opb = ADFUtils.findOperation("Commit");
        opb.execute();
        if (opb.getErrors().isEmpty()) {
            JSFUtils.addFacesInformationMessage("Data Saved Successfully.");
        } else {
            JSFUtils.addFacesErrorMessage("Error while saving the data. Please contact system Administrator.");
        }
    }

    public void pcsShortNameEditActnLstnr(ActionEvent actionEvent) {
        DCIteratorBinding pcsShortNameIter = ADFUtils.findIterator("XpeDccCfgPcsshortnamesEOVOIterator");
        XpeDccCfgPcsshortnamesEOVOImpl pcsShortNameImpl =
            (XpeDccCfgPcsshortnamesEOVOImpl) pcsShortNameIter.getViewObject();
        XpeDccCfgPcsshortnamesEOVORowImpl pcsShortNameRowImpl =
            (XpeDccCfgPcsshortnamesEOVORowImpl) pcsShortNameImpl.getCurrentRow();
        if (null != pcsShortNameRowImpl) {
            BigDecimal soldLocNum = pcsShortNameRowImpl.getCovSoldLocNum();
            BigDecimal billLocNum = pcsShortNameRowImpl.getCovBillLocNum();
            pcsShortNameRowImpl.setCovSoldLocNum(soldLocNum);
            pcsShortNameRowImpl.setCovBillLocNum(billLocNum);
        }
    }
}
