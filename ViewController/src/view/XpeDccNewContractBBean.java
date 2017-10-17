package view;

import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.RichQuery;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichTextEditor;


public class XpeDccNewContractBBean {
    private RichTable contractSearchROVOTblBind;
    private RichTable contractCustSearchROVOTblBind;

    public XpeDccNewContractBBean() {
        super();
    }
    
    private RichPopup html_popup;
    private RichTextEditor termTemplateRTE;

    public void setTermTemplateRTE(RichTextEditor termTemplateRTE) {
        this.termTemplateRTE = termTemplateRTE;
    }

    public RichTextEditor getTermTemplateRTE() {
        return termTemplateRTE;
    }

    public void setHtml_popup(RichPopup html_popup) {
        this.html_popup = html_popup;
    }

    public RichPopup getHtml_popup() {
        return html_popup;
    }

    public void setContractSearchROVOTblBind(RichTable contractSearchROVOTblBind) {
        this.contractSearchROVOTblBind = contractSearchROVOTblBind;
    }

    public RichTable getContractSearchROVOTblBind() {
        return contractSearchROVOTblBind;
    }

    public void setContractCustSearchROVOTblBind(RichTable contractCustSearchROVOTblBind) {
        this.contractCustSearchROVOTblBind = contractCustSearchROVOTblBind;
    }

    public RichTable getContractCustSearchROVOTblBind() {
        return contractCustSearchROVOTblBind;
    }
}
