package view;

import view.utils.ADFUtils;

public class CovantaExpirationReportMBean {
    public CovantaExpirationReportMBean() {
        super();
    }
    
    private CovantaExpirationReportBBean getCovantaExpirationReportBBean() {
        CovantaExpirationReportBBean covantaExpirationReportBBean =
            (CovantaExpirationReportBBean) ADFUtils.evaluateEL("#{backingBeanScope.CovantaExpirationReportBBean}");
        return covantaExpirationReportBBean;
    }
    
}
