package view;


import java.sql.Date;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;

import javax.faces.application.Application;
import javax.faces.context.FacesContext;


public class PlanLauncher {

    private Date selectedFromDate = new Date(System.currentTimeMillis());
    private Date selectedToDate = new Date(System.currentTimeMillis());
    private boolean selectedTestRun;

    public String resolvEl(String data) {
        FacesContext fc = FacesContext.getCurrentInstance();
        Application app = fc.getApplication();
        ExpressionFactory elFactory = app.getExpressionFactory();
        ELContext elContext = fc.getELContext();
        ValueExpression valueExp = elFactory.createValueExpression(elContext, data, Object.class);
        String Message = valueExp.getValue(elContext).toString();
        return Message;
    }


    public PlanLauncher() {
        super();
    }

    public String launchPlanInstance() {

        String userCfgFile = "";
        String userIdSelected = "";
        userIdSelected = "NEUSTAR";
        String runType = "TST";

        // 161114 begin

        if (getSelectedTestRun()) {
            runType = "TST";
        } else {
            runType = "PRD";
        }

        // 161114 end


        //Constants

        //PROD
        // userCfgFile = "/psft/wl12adf/user_projects/domains/adfprd/config/xpe_prd_cfg.properties";

        //unix uat
        // userCfgFile = "/psft/wl12adf/user_projects/domains/tnsuat/config/xpe_uat_cfg.properties";

        //unix BREAK FIX
        // userCfgFile = "/psft/wl12adf/user_projects/domains/tnsuat/config/xpe_breakfix_cfg.properties";
        
        // 
        userCfgFile = "/dcva3t/local/xpe_batch/xpe_aws.properties";
        


        String selectedExecutionPlan = resolvEl("#{bindings.CisExecPlanCode.inputValue}");

        System.out.println("INFO executing " + selectedExecutionPlan + " " + selectedFromDate.toString() + " " +
                           selectedToDate.toString());

        GenericDataHandler dataAdapter = new GenericDataHandler();
        dataAdapter.setConfig(userCfgFile);
        dataAdapter.setUserId(userIdSelected);
        dataAdapter.setRunType(runType);

        dataAdapter.setExecutionParameters(selectedExecutionPlan, selectedFromDate, selectedToDate);

        System.out.println("INFO starting as a new thread");

        Thread newThread = new Thread(dataAdapter);
        newThread.start();

        System.out.println("INFO launched data adapter");

        return null;
    }

    public void setSelectedFromDate(Date selectedFromDate) {
        this.selectedFromDate = selectedFromDate;
    }

    public Date getSelectedFromDate() {
        return selectedFromDate;
    }

    public void setSelectedToDate(Date selectedToDate) {
        this.selectedToDate = selectedToDate;
    }

    public Date getSelectedToDate() {
        return selectedToDate;
    }

    public void setSelectedTestRun(boolean selectedTestRun) {
        this.selectedTestRun = selectedTestRun;
    }

    public boolean getSelectedTestRun() {
        return selectedTestRun;
    }
}
