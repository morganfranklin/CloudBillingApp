package view;

import oracle.adf.view.rich.component.rich.data.RichTable;

public class PcsShortNameSetUpTableBBean {
    private RichTable pcsShortNamesSetUpTblBind;

    public PcsShortNameSetUpTableBBean() {
    }

    public void setPcsShortNamesSetUpTblBind(RichTable pcsShortNamesSetUpTblBind) {
        this.pcsShortNamesSetUpTblBind = pcsShortNamesSetUpTblBind;
    }

    public RichTable getPcsShortNamesSetUpTblBind() {
        return pcsShortNamesSetUpTblBind;
    }
}
