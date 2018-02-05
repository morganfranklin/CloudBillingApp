package view;

import oracle.adf.view.rich.component.rich.output.RichPanelCollection;


public class CovantaExpirationReportBBean {

    private RichPanelCollection expirationReportPanelCollection;

    public CovantaExpirationReportBBean() {
        super();
    }

    public void setExpirationReportPanelCollection(RichPanelCollection expirationReportPanelCollection) {
        this.expirationReportPanelCollection = expirationReportPanelCollection;
    }

    public RichPanelCollection getExpirationReportPanelCollection() {
        return expirationReportPanelCollection;
    }
}
