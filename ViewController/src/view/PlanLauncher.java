package view;


import java.sql.Date;

import java.util.Map;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;

import javax.faces.application.Application;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.model.BindingContext;

import oracle.adf.model.binding.DCBindingContainer;

import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import view.utils.ADFUtils;


public class PlanLauncher {

    private Date selectedFromDate = new Date(System.currentTimeMillis());
    private Date selectedToDate = new Date(System.currentTimeMillis());
    private boolean selectedTestRun;
    
    private String planOverride = null;
    private Boolean selectAllFacilities;

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
        String userIdSelected = (String)ADFUtils.evaluateEL("#{sessionScope.userId}");
        //userIdSelected = "NEUSTAR";
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
        userCfgFile = "/autofs/ood_implementation/lib4wls/xpe_batch/xpe_aws.properties";
        // userCfgFile = "C:\\JDeveloper\\CovOverride\\xpe_aws.properties";
        
        String selectedExecutionPlan ;
        
        if (planOverride==null) {
                selectedExecutionPlan = resolvEl("#{bindings.CisExecPlanCode.inputValue}");
        } else {
            selectedExecutionPlan = planOverride;
        }
        

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

    public void setPlanOverride(String planOverride) {
        this.planOverride = planOverride;
    }

    public String getPlanOverride() {
        return planOverride;
    }

    public void setSelectAllFacilities(Boolean selectAllFacilities) {
        this.selectAllFacilities = selectAllFacilities;
    }

    public Boolean getSelectAllFacilities() {
        return selectAllFacilities;
    }

    public void onRunForAllFacilities(ValueChangeEvent valueChangeEvent) {
        if (null != valueChangeEvent) {
            Boolean facilityCheck = (Boolean) valueChangeEvent.getNewValue();
            System.err.println(facilityCheck);
            ADFUtils.invokeEL("#{bindings.Rollback.execute}");
            if (Boolean.TRUE.equals(facilityCheck)) {
                DCBindingContainer bindings =
                    (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                OperationBinding operationBinding = bindings.getOperationBinding("createAllFacilitiesForAccurals");
                if (null != operationBinding)
                    operationBinding.execute();
            } 
        }
    }
}
