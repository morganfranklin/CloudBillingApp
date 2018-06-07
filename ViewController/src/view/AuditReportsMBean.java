package view;

import java.io.ByteArrayInputStream;
import java.io.OutputStream;

import javax.faces.context.FacesContext;

import oracle.adf.model.BindingContext;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.QueryOperationEvent;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import org.apache.commons.io.IOUtils;

import view.utils.ADFUtils;

public class AuditReportsMBean {

    public AuditReportsMBean() {
        super();
    }
    
    private auditReportsBBean getAuditReportsBBean() {
        auditReportsBBean auditRptsBBean =
            (auditReportsBBean) ADFUtils.evaluateEL("#{backingBeanScope.auditReportsBBean}");
        return auditRptsBBean;
    }
    
    public void auditReportPDFDownload(FacesContext facesContext, OutputStream outputStream) {
        String methodName = (String)ADFUtils.evaluateEL("#{backingBeanScope.methodActionName}");
        String reportName = (String)ADFUtils.evaluateEL("#{backingBeanScope.reportName}");
        System.err.println("Method Name: "+methodName);
        System.err.println("Report Name: "+reportName);
        try {
                BindingContext bc = BindingContext.getCurrent();
                BindingContainer bindings = bc.getCurrentBindingsEntry();
                OperationBinding operationBinding = bindings.getOperationBinding(methodName);
                if (null != operationBinding) {
                    String xml = (String) operationBinding.execute();
                    if (null != xml && xml.length() > 0) {
                        IOUtils.copy(new ByteArrayInputStream(FileOperations.genPdfRep(xml.getBytes(),
                                                                              FileOperations.getRTFAsInputStream(reportName))), outputStream);
                        // flush the outout stream
                        outputStream.flush();
                    }else
                        ADFUtils.showInfoMessage("No PDF available.");
                }else
                    ADFUtils.showInfoMessage("No PDF available.");
        } catch (Exception e) {
            e.printStackTrace();
            ADFUtils.showErrorMessage("Error while downloading PDF.");
        }

    }

    public void carriersQueryOperationListener(QueryOperationEvent queryOperationEvent) {
        ADFUtils.invokeEL("#{bindings.XpeDccCfgCarriersAdtViewCriteriaQuery.processQueryOperation}", Object.class,
                          QueryOperationEvent.class, queryOperationEvent);
        if (queryOperationEvent.getOperation().name().toUpperCase().equals("RESET")) {
            DCIteratorBinding carrierIter = ADFUtils.findIterator("XpeDccCfgCarriersAdtView1Iterator");
            carrierIter.getViewObject().executeEmptyRowSet();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.getAuditReportsBBean().getCarriersTblBind());
        }
    }

    public void countiesQueryOperationListener(QueryOperationEvent queryOperationEvent) {
        ADFUtils.invokeEL("#{bindings.XpeDccCfgCountiesAdtViewCriteriaQuery.processQueryOperation}", Object.class,
                          QueryOperationEvent.class, queryOperationEvent);
        if (queryOperationEvent.getOperation().name().toUpperCase().equals("RESET")) {
            DCIteratorBinding viewIter = ADFUtils.findIterator("XpeDccCfgCountiesAdtView1Iterator");
            viewIter.getViewObject().executeEmptyRowSet();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.getAuditReportsBBean().getCountiesTblBind());
        }
    }

    public void destinationQueryOperationListener(QueryOperationEvent queryOperationEvent) {
        ADFUtils.invokeEL("#{bindings.XpeDccCfgDestinationsAdtViewCriteriaQuery.processQueryOperation}", Object.class,
                          QueryOperationEvent.class, queryOperationEvent);
        if (queryOperationEvent.getOperation().name().toUpperCase().equals("RESET")) {
            DCIteratorBinding viewIter = ADFUtils.findIterator("XpeDccCfgDestinationsAdtView1Iterator");
            viewIter.getViewObject().executeEmptyRowSet();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.getAuditReportsBBean().getDestinationTblBind());
        }
    }

    public void originQueryOperationListener(QueryOperationEvent queryOperationEvent) {
        ADFUtils.invokeEL("#{bindings.XpeDccCfgOriginsAdtViewCriteriaQuery.processQueryOperation}", Object.class,
                          QueryOperationEvent.class, queryOperationEvent);
        if (queryOperationEvent.getOperation().name().toUpperCase().equals("RESET")) {
            DCIteratorBinding viewIter = ADFUtils.findIterator("XpeDccCfgOriginsAdtView1Iterator");
            viewIter.getViewObject().executeEmptyRowSet();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.getAuditReportsBBean().getOriginsTblBind());
        }
    }

    public void vehiclesQueryOperationListener(QueryOperationEvent queryOperationEvent) {
        ADFUtils.invokeEL("#{bindings.XpeDccCfgVehiclesAdtViewCriteriaQuery.processQueryOperation}", Object.class,
                          QueryOperationEvent.class, queryOperationEvent);
        if (queryOperationEvent.getOperation().name().toUpperCase().equals("RESET")) {
            DCIteratorBinding viewIter = ADFUtils.findIterator("XpeDccCfgVehiclesAdtView1Iterator");
            viewIter.getViewObject().executeEmptyRowSet();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.getAuditReportsBBean().getVehiclesTblBind());
        }
    }

    public void customerQueryOperationListener(QueryOperationEvent queryOperationEvent) {
        ADFUtils.invokeEL("#{bindings.XpeDccCfgPcsshtnamesAdtViewCriteriaQuery.processQueryOperation}", Object.class,
                          QueryOperationEvent.class, queryOperationEvent);
        if (queryOperationEvent.getOperation().name().toUpperCase().equals("RESET")) {
            DCIteratorBinding viewIter = ADFUtils.findIterator("XpeDccCfgPcsshtnamesAdtView1Iterator");
            viewIter.getViewObject().executeEmptyRowSet();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.getAuditReportsBBean().getCustomerTblBind());
        }
    }

    public void contractsQueryOperationListener(QueryOperationEvent queryOperationEvent) {
        ADFUtils.invokeEL("#{bindings.XpeDccContractsAdtViewCriteriaQuery.processQueryOperation}", Object.class,
                          QueryOperationEvent.class, queryOperationEvent);
        if (queryOperationEvent.getOperation().name().toUpperCase().equals("RESET")) {
            DCIteratorBinding viewIter = ADFUtils.findIterator("XpeDccContractsAdtView1Iterator");
            viewIter.getViewObject().executeEmptyRowSet();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.getAuditReportsBBean().getContractsTblBind());
        }
    }

    public void contractVerQueryOperationListener(QueryOperationEvent queryOperationEvent) {
        ADFUtils.invokeEL("#{bindings.XpeDccContractVersionAdtViewCriteriaQuery.processQueryOperation}", Object.class,
                          QueryOperationEvent.class, queryOperationEvent);
        if (queryOperationEvent.getOperation().name().toUpperCase().equals("RESET")) {
            DCIteratorBinding viewIter = ADFUtils.findIterator("XpeDccContractVersionAdtView1Iterator");
            viewIter.getViewObject().executeEmptyRowSet();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.getAuditReportsBBean().getContractVerTblBind());
        }
    }

    public void contractLineQueryOperationListener(QueryOperationEvent queryOperationEvent) {
        ADFUtils.invokeEL("#{bindings.XpeDccContractLineAdtViewCriteriaQuery.processQueryOperation}", Object.class,
                          QueryOperationEvent.class, queryOperationEvent);
        if (queryOperationEvent.getOperation().name().toUpperCase().equals("RESET")) {
            DCIteratorBinding viewIter = ADFUtils.findIterator("XpeDccContractLineAdtView1Iterator");
            viewIter.getViewObject().executeEmptyRowSet();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.getAuditReportsBBean().getContractLineTblBind());
        }
    }
    
    public void cntrctPrcngQueryOperationLstnr(QueryOperationEvent queryOperationEvent) {
            ADFUtils.invokeEL("#{bindings.XpeDccCntrctPrcngTermAdtViewCriteriaQuery.processQueryOperation}",Object.class,
                     QueryOperationEvent.class, queryOperationEvent);
            if (queryOperationEvent.getOperation().name().toUpperCase().equals("RESET")) {
                DCIteratorBinding carrierIter = ADFUtils.findIterator("XpeDccCntrctPrcngTermAdtView1Iterator");
                carrierIter.getViewObject().executeEmptyRowSet();
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.getAuditReportsBBean().getCntrctPrcngTblBind());
            }
        }
}
