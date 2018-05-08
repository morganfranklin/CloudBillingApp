package view;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.MethodExpression;

import javax.faces.context.FacesContext;

import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import model.views.entitybased.XpeDccCfgDestinationsEOVOImpl;

import model.views.entitybased.XpeDccCfgDestinationsEOVORowImpl;

import model.views.entitybased.XpeDccCfgDstAssTerminalsEOVORowImpl;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.QueryOperationEvent;

import oracle.binding.OperationBinding;

import oracle.jbo.Key;

import oracle.jbo.Row;

import view.utils.ADFUtils;
import view.utils.JSFUtils;

public class DestinationSetUpTableMBean implements Serializable{
    @SuppressWarnings("compatibility:4804481086372471615")
    private static final long serialVersionUID = 1L;

    public DestinationSetUpTableMBean() {
    }
    
    private DestinationSetUpTableBBean getDestinationSetUpTableBBean() {
        DestinationSetUpTableBBean destinationSetUpTableBBean =
            (DestinationSetUpTableBBean) ADFUtils.evaluateEL("#{backingBeanScope.DestinationSetUpTableBBean}");
        return destinationSetUpTableBBean;
    }

    public void queryOperationListener(QueryOperationEvent queryOperationEvent) {
        invokeEL("#{bindings.DestinationsCriteriaQuery.processQueryOperation}",Object.class,
                 QueryOperationEvent.class, queryOperationEvent);
        if (queryOperationEvent.getOperation().name().toUpperCase().equals("RESET")) {
            DCIteratorBinding carrierIter = ADFUtils.findIterator("XpeDccCfgDestinationsEOVOIterator");
            carrierIter.getViewObject().executeEmptyRowSet();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.getDestinationSetUpTableBBean().getDestinationSetUpTblBind());
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

    public void onTerminalSearchSave(ActionEvent actionEvent) {
        OperationBinding opb = ADFUtils.findOperation("addAssTerminalToDestination");
        opb.execute();
        Object terminalSrchRslt = opb.getResult();
        String rtnMsg = (String) terminalSrchRslt;
        if("DUPLICATE_EXIST".equals(rtnMsg)){
            JSFUtils.addFacesErrorMessage("Selected Terminal is associated to destination. Please select another terminal.");
        }else{
        this.getDestinationSetUpTableBBean().getTerminalSearch_popup().hide();
        }
    }

    public void onTerminalSearchCancel(ActionEvent actionEvent) {
        this.getDestinationSetUpTableBBean().getTerminalSearch_popup().hide();
    }

    public void onTerminalSearch(ActionEvent actionEvent) {
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getDestinationSetUpTableBBean().getTerminalSearch_popup().show(hints);
    }

    public void onTerminalEdit(ActionEvent actionEvent) {
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getDestinationSetUpTableBBean().getTerminalEdit_popup().show(hints);
    }

    public void onTerminalEditSaveOrCancel(ActionEvent actionEvent) {
        this.getDestinationSetUpTableBBean().getTerminalEdit_popup().hide();
    }

    public void onDestinationEdit(ActionEvent actionEvent) {
        String destinationId = (String) AdfFacesContext.getCurrentInstance().getPageFlowScope().get("DestinationId");
        DCIteratorBinding dcIterBind = ADFUtils.findIterator("XpeDccCfgNewDestinationsCreationEOVOIterator");
        XpeDccCfgDestinationsEOVOImpl destinationImpl = (XpeDccCfgDestinationsEOVOImpl) dcIterBind.getViewObject();
        destinationImpl.executeQuery();
        Row[] Destinations = destinationImpl.findByKey(new Key(new Object[]{destinationId }), 1);
        if(null != Destinations && Destinations.length > 0){
            XpeDccCfgDestinationsEOVORowImpl destinationRowImpl = (XpeDccCfgDestinationsEOVORowImpl) Destinations[0];
            destinationImpl.setCurrentRow(destinationRowImpl);
        }
    }

    public void onInactiveValChgLstnr(ValueChangeEvent valueChangeEvent) {
        DCIteratorBinding destAssocIter = ADFUtils.findIterator("XpeDccCfgNewDstAssTerminalsCreationEOVOIterator");
        XpeDccCfgDstAssTerminalsEOVORowImpl destAssocTermRow =
            (XpeDccCfgDstAssTerminalsEOVORowImpl) destAssocIter.getCurrentRow();
        if (null != valueChangeEvent.getNewValue() && valueChangeEvent.getNewValue().equals("Y")){
            destAssocTermRow.setInactiveDate(new Timestamp(System.currentTimeMillis()));
        }else{
            destAssocTermRow.setInactiveDate(null);
        }
    }

    public void onAddDesInactiveValChgLstnr(ValueChangeEvent valueChangeEvent) {
        DCIteratorBinding destAssocIter = ADFUtils.findIterator("XpeDccCfgNewDstAssTerminalsCreationEOVOIterator");
        XpeDccCfgDstAssTerminalsEOVORowImpl destAssocTermRow =
            (XpeDccCfgDstAssTerminalsEOVORowImpl) destAssocIter.getCurrentRow();
        if (null != valueChangeEvent.getNewValue() && valueChangeEvent.getNewValue().equals("Y")){
            destAssocTermRow.setInactiveDate(new Timestamp(System.currentTimeMillis()));
        }else{
            destAssocTermRow.setInactiveDate(null);
        }
    }

    public void onDestinationCreation(ActionEvent actionEvent) {
        DCIteratorBinding dcIterBind = ADFUtils.findIterator("XpeDccCfgNewDestinationsCreationEOVOIterator");
        XpeDccCfgDestinationsEOVOImpl destinationImpl = (XpeDccCfgDestinationsEOVOImpl) dcIterBind.getViewObject();
        destinationImpl.executeQuery();
        XpeDccCfgDestinationsEOVORowImpl destinationRowImpl = (XpeDccCfgDestinationsEOVORowImpl) destinationImpl.createRow();
        destinationImpl.insertRow(destinationRowImpl);
        destinationImpl.setCurrentRow(destinationRowImpl);
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("DestinationId", destinationRowImpl.getDestinationId());
    }

    public void onDestinationInactiveValChgLstnr(ValueChangeEvent valueChangeEvent) {
        DCIteratorBinding dcIterBind = ADFUtils.findIterator("XpeDccCfgNewDestinationsCreationEOVOIterator");
        XpeDccCfgDestinationsEOVORowImpl destinationRow = (XpeDccCfgDestinationsEOVORowImpl) dcIterBind.getCurrentRow();
        if (null != valueChangeEvent.getNewValue() && valueChangeEvent.getNewValue().equals("Y")){
            destinationRow.setInactiveDate(new Timestamp(System.currentTimeMillis()));
        }else{
            destinationRow.setInactiveDate(null);
        }
    }

    public void destinationSaveActnLstnr(ActionEvent actionEvent) {
        String stateName = (String) ADFUtils.evaluateEL("#{bindings.State.inputValue}");
        String country = (String) ADFUtils.evaluateEL("#{bindings.Country.inputValue}");
        if (this.checkInvalidCombination(country, stateName)) {
            JSFUtils.addFacesErrorMessage("Invalid State/Country Combination.");
        } else {
            OperationBinding opb = ADFUtils.findOperation("Commit");
            opb.execute();
            if (opb.getErrors().isEmpty()) {
                JSFUtils.addFacesInformationMessage("Data Saved Successfully.");
            } else {
                JSFUtils.addFacesErrorMessage("Error while saving the data. Please contact system Administrator.");
            }
        }
    }

    public void stateValChgLstnr(ValueChangeEvent valueChangeEvent) {
        DCIteratorBinding dcIterBind = ADFUtils.findIterator("XpeDccCfgNewDestinationsCreationEOVOIterator");
        XpeDccCfgDestinationsEOVORowImpl destinationRow = (XpeDccCfgDestinationsEOVORowImpl) dcIterBind.getCurrentRow();
        if (null != valueChangeEvent.getNewValue() && !valueChangeEvent.getNewValue().equals("XX")) {
            this.getDestinationSetUpTableBBean().getCountryBind().setValue("USA");
            destinationRow.setCountry("USA");
        } else {
            this.getDestinationSetUpTableBBean().getCountryBind().setValue(null);
            destinationRow.setCountry(null);
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.getDestinationSetUpTableBBean().getCountryBind());
    }
    
    public boolean checkInvalidCombination(String countryName, String stateName){
        boolean rtnVal = false;    
        if(null != stateName && "XX".equals(stateName) && null != countryName && "USA".equals(countryName)){
            rtnVal = true;
        } else if(null != stateName && !"XX".equals(stateName) && null != countryName && !"USA".equals(countryName)){
            rtnVal = true;
        }
        return rtnVal;
    }
}
