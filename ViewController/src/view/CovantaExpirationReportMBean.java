package view;

import java.io.Serializable;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.QueryOperationEvent;

import view.utils.ADFUtils;

public class CovantaExpirationReportMBean implements Serializable{
    @SuppressWarnings("compatibility:2969440298370778632")
    private static final long serialVersionUID = 259659917215830355L;

    public CovantaExpirationReportMBean() {
        super();
    }
    
    private CovantaExpirationReportBBean getCovantaExpirationReportBBean() {
        CovantaExpirationReportBBean covantaExpirationReportBBean =
            (CovantaExpirationReportBBean) ADFUtils.evaluateEL("#{backingBeanScope.covExpReportBBean}");
        return covantaExpirationReportBBean;
    }

    public void expirationReportQueryOperationListener(QueryOperationEvent queryOperationEvent) {              
            ADFUtils.invokeEL("#{bindings.XpeDccCovCntrctExpirationReportROVOCriteriaQuery.processQueryOperation}",Object.class,
                     QueryOperationEvent.class, queryOperationEvent);
            if (queryOperationEvent.getOperation().name().toUpperCase().equals("RESET")) {
                DCIteratorBinding carrierIter = ADFUtils.findIterator("XpeDccCovCntrctExpirationReportROVOIterator");
                carrierIter.getViewObject().executeEmptyRowSet();
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.getCovantaExpirationReportBBean().getExpirationReportPanelCollection());
            }
    }
}
