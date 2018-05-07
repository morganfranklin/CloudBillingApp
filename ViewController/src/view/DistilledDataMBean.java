package view;

import java.io.ByteArrayInputStream;
import java.io.OutputStream;

import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.event.QueryEvent;
import oracle.adf.view.rich.model.AttributeCriterion;
import oracle.adf.view.rich.model.ConjunctionCriterion;
import oracle.adf.view.rich.model.Criterion;
import oracle.adf.view.rich.model.FilterableQueryDescriptor;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import org.apache.commons.io.IOUtils;

import view.utils.ADFUtils;

public class DistilledDataMBean {
    private RichTable summaryTableBind;
    private RichTable detailsTableBind;

    public DistilledDataMBean() {
        super();
    }

    public void summaryPDFDownload(FacesContext facesContext, OutputStream outputStream) {
        try {
                BindingContext bc = BindingContext.getCurrent();
                BindingContainer bindings = bc.getCurrentBindingsEntry();
                OperationBinding operationBinding = bindings.getOperationBinding("writeVoToXmlSummary");
                if (null != operationBinding) {
                    String xml = (String) operationBinding.execute();
                    if (null != xml && xml.length() > 0) {
                        IOUtils.copy(new ByteArrayInputStream(FileOperations.genPdfRep(xml.getBytes(),
                                                                              FileOperations.getRTFAsInputStream("SummaryReport"))), outputStream);
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
    
    public void detailsPDFDownload(FacesContext facesContext, OutputStream outputStream) {
        try {
                BindingContext bc = BindingContext.getCurrent();
                BindingContainer bindings = bc.getCurrentBindingsEntry();
                OperationBinding operationBinding = bindings.getOperationBinding("writeVoToXmlDetails");
                if (null != operationBinding) {
                    String xml = (String) operationBinding.execute();
                    if (null != xml && xml.length() > 0) {
                        IOUtils.copy(new ByteArrayInputStream(FileOperations.genPdfRep(xml.getBytes(),
                                                                              FileOperations.getRTFAsInputStream("DetailsReport"))), outputStream);
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
    
    /**
      * method to reset filter attributes on an af:table
      * @param actionEvent event which triggers the method
      */
     public void resetSummaryTableFilterAction(ActionEvent actionEvent) {
         FilterableQueryDescriptor queryDescriptor = (FilterableQueryDescriptor) getSummaryTableBind().getFilterModel();
         if (null!=queryDescriptor && null!=queryDescriptor.getFilterConjunctionCriterion()) {
             ConjunctionCriterion cc = queryDescriptor.getFilterConjunctionCriterion();
             List<Criterion> lc = cc.getCriterionList();
             for (Criterion c : lc) {
                 if (c instanceof AttributeCriterion) {
                     AttributeCriterion ac = (AttributeCriterion) c;
                     ac.setValue(null);
                 }
             }
             getSummaryTableBind().queueEvent(new QueryEvent(getSummaryTableBind(), queryDescriptor));
         }
     }
    
    /**
      * method to reset filter attributes on an af:table
      * @param actionEvent event which triggers the method
      */
     public void resetDetailsTableFilterAction(ActionEvent actionEvent) {
         FilterableQueryDescriptor queryDescriptor = (FilterableQueryDescriptor) getDetailsTableBind().getFilterModel();
         if (null!=queryDescriptor && null!=queryDescriptor.getFilterConjunctionCriterion()) {
             ConjunctionCriterion cc = queryDescriptor.getFilterConjunctionCriterion();
             List<Criterion> lc = cc.getCriterionList();
             for (Criterion c : lc) {
                 if (c instanceof AttributeCriterion) {
                     AttributeCriterion ac = (AttributeCriterion) c;
                     ac.setValue(null);
                 }
             }
             getDetailsTableBind().queueEvent(new QueryEvent(getDetailsTableBind(), queryDescriptor));
         }
     }

    public void setSummaryTableBind(RichTable summaryTableBind) {
        this.summaryTableBind = summaryTableBind;
    }

    public RichTable getSummaryTableBind() {
        return summaryTableBind;
    }

    public void setDetailsTableBind(RichTable detailsTableBind) {
        this.detailsTableBind = detailsTableBind;
    }

    public RichTable getDetailsTableBind() {
        return detailsTableBind;
    }
}
