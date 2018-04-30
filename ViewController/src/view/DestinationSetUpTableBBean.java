package view;

import javax.faces.event.ActionEvent;

import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;

public class DestinationSetUpTableBBean {
    private RichTable destinationSetUpTblBind;
    private RichPopup terminalSearch_popup;
    private RichPopup terminalEdit_popup;
    private RichSelectOneChoice countryBind;

    public DestinationSetUpTableBBean() {
    }

    public void setDestinationSetUpTblBind(RichTable destinationSetUpTblBind) {
        this.destinationSetUpTblBind = destinationSetUpTblBind;
    }

    public RichTable getDestinationSetUpTblBind() {
        return destinationSetUpTblBind;
    }

    public void setTerminalSearch_popup(RichPopup terminalSearch_popup) {
        this.terminalSearch_popup = terminalSearch_popup;
    }

    public RichPopup getTerminalSearch_popup() {
        return terminalSearch_popup;
    }

    public void setTerminalEdit_popup(RichPopup terminalEdit_popup) {
        this.terminalEdit_popup = terminalEdit_popup;
    }

    public RichPopup getTerminalEdit_popup() {
        return terminalEdit_popup;
    }

    public void setCountryBind(RichSelectOneChoice countryBind) {
        this.countryBind = countryBind;
    }

    public RichSelectOneChoice getCountryBind() {
        return countryBind;
    }
}
