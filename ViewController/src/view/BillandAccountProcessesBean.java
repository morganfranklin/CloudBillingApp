package view;

import javax.faces.event.ActionEvent;

import view.utils.ADFUtils;

public class BillandAccountProcessesBean {
    public BillandAccountProcessesBean() {
    }

    public void processBillandAccounting(ActionEvent actionEvent) {
        ADFUtils.findOperation("billAndAccountingProcess").execute();
    }
}
