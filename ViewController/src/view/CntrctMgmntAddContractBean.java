package view;

import javax.faces.event.ActionEvent;

import oracle.adf.view.rich.component.rich.RichPopup;

import oracle.binding.OperationBinding;

import view.utils.ADFUtils;

public class CntrctMgmntAddContractBean {
    private RichPopup confirmationMsgPpBind;

    public CntrctMgmntAddContractBean() {
    }

    public void saveContractActnLstnr(ActionEvent actionEvent) {
        OperationBinding opb = ADFUtils.findOperation("Commit");
        opb.execute();
        if(opb.getErrors().isEmpty()){
            this.getConfirmationMsgPpBind().show(new RichPopup.PopupHints());
        }
    }

    public void setConfirmationMsgPpBind(RichPopup confirmationMsgPpBind) {
        this.confirmationMsgPpBind = confirmationMsgPpBind;
    }

    public RichPopup getConfirmationMsgPpBind() {
        return confirmationMsgPpBind;
    }
}
