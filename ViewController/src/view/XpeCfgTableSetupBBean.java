package view;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.MethodExpression;

import javax.faces.context.FacesContext;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.QueryOperationEvent;

import view.utils.ADFUtils;

public class XpeCfgTableSetupBBean {
    private RichTable terminalSetUpTblBind;

    public XpeCfgTableSetupBBean() {
        super();
    }
    //Terminal Set Up
    private RichPopup terminalAddItem_popup;
    private RichPopup terminalEditItem_popup;
    //Destination Set Up
    private RichPopup terminalSearch_popup;

    public void setTerminalSearch_popup(RichPopup terminalSearch_popup) {
        this.terminalSearch_popup = terminalSearch_popup;
    }

    public RichPopup getTerminalSearch_popup() {
        return terminalSearch_popup;
    }

    public void setTerminalAddItem_popup(RichPopup terminalAddItem_popup) {
        this.terminalAddItem_popup = terminalAddItem_popup;
    }

    public RichPopup getTerminalAddItem_popup() {
        return terminalAddItem_popup;
    }

    public void setTerminalEditItem_popup(RichPopup terminalEditItem_popup) {
        this.terminalEditItem_popup = terminalEditItem_popup;
    }

    public RichPopup getTerminalEditItem_popup() {
        return terminalEditItem_popup;
    }

    public void setTerminalSetUpTblBind(RichTable terminalSetUpTblBind) {
        this.terminalSetUpTblBind = terminalSetUpTblBind;
    }

    public RichTable getTerminalSetUpTblBind() {
        return terminalSetUpTblBind;
    }
}
