package view;

import java.io.Serializable;

import oracle.adf.controller.TaskFlowId;
import oracle.adf.view.rich.event.RegionNavigationEvent;

public class integrationDashboardRegionName implements Serializable {
    @SuppressWarnings("compatibility:7495095175841506203")
    private static final long serialVersionUID = 1L;
    private String taskFlowId =
        // "/WEB-INF/secureXPEflow.xml#transmittedData";
        // 160927
        // "/WEB-INF/transmittedData.xml#transmittedData";
        // "/WEB-INF/billingEvents.xml#billingEvents";
        // 170314
        "/WEB-INF/adminStats.xml#adminStats";

    public integrationDashboardRegionName() {
    }

    public TaskFlowId getDynamicTaskFlowId() {
        return TaskFlowId.parse(taskFlowId);
    }

    public void setDynamicTaskFlowId(String taskFlowId) {
        this.taskFlowId = taskFlowId;
    }

    public String distilledData() {
        setDynamicTaskFlowId("/WEB-INF/distilledData.xml#distilledData");
        return null;
    }

    public String transmittedData() {
        setDynamicTaskFlowId("/WEB-INF/transmittedData.xml#transmittedData");
        return null;
    }

    public String crossReferences() {
        setDynamicTaskFlowId("/WEB-INF/crossReferences.xml#crossReferences");
        return null;
    }

    public String billingEvents() {
        setDynamicTaskFlowId("/WEB-INF/billingEvents.xml#billingEvents");
        return null;
    }

    public String voucherEvents() {
        setDynamicTaskFlowId("/WEB-INF/voucherEvents.xml#voucherEvents");
        return null;
    }

    public String rulesetConfiguration() {
        setDynamicTaskFlowId("/WEB-INF/rulesetConfiguration.xml#rulesetConfiguration");
        return null;
    }

    public String lookupSets() {
        setDynamicTaskFlowId("/WEB-INF/lookupSets.xml#lookupSets");
        return null;
    }

    public String mappedContracts() {
        setDynamicTaskFlowId("/WEB-INF/mappedContracts.xml#mappedContracts");
        return null;
    }

    public String rulesets() {
        setDynamicTaskFlowId("/WEB-INF/rulesets.xml#rulesets");
        return null;
    }

    public String executionPlan() {
        setDynamicTaskFlowId("/WEB-INF/executionPlan.xml#executionPlan");
        return null;
    }

    public String launchExecutionPlan() {
        // ss
        return null;
    }

    public String actions() {
        setDynamicTaskFlowId("/WEB-INF/actions.xml#actions");
        return null;
    }

    public String filterActionsByRule() {
        // Add event code here...
        return null;
    }

    public String adminStats() {
        setDynamicTaskFlowId("/WEB-INF/adminStats.xml#adminStats");
        return null;
    }

    public String contractMaster() {
        setDynamicTaskFlowId("/WEB-INF/contractMaster.xml#contractMaster");
        return null;
    }

    public String dccContractMaintenance() {
        setDynamicTaskFlowId("/WEB-INF/dccContractMaintenance.xml#dccContractMaintenance");
        return null;
    }
    
    public String newContract() {
        setDynamicTaskFlowId("/WEB-INF/newContractRootSetup.xml#newContractRootSetup");
        return null;
    }
    
    public String updateContract() {
        setDynamicTaskFlowId("/WEB-INF/extContractRootSetup.xml#extContractRootSetup");
        return null;
    }
    
    public String termMaster() {
        setDynamicTaskFlowId("/WEB-INF/termsMaster.xml#termsMaster");
        return null;
    }
    
    public String setUpTables() {
        setDynamicTaskFlowId("/WEB-INF/setupTables.xml#setupTables");
        return null;
    }

    public String blueLightSpecials() {
        setDynamicTaskFlowId("/WEB-INF/blsContractRootSetUp.xml#blsContractRootSetUp");
        return null;
    }

    public String billingAccountingProcesses() {
        setDynamicTaskFlowId("/WEB-INF/billingAccountingProcesses.xml#billingAccountingProcesses");
        return null;
    }

    public void regionNavigationListener(RegionNavigationEvent regionNavigationEvent) {
        if(regionNavigationEvent.getNewViewId() == null){
            setDynamicTaskFlowId("/WEB-INF/adminStats.xml#adminStats");
        }
    }

    public String accrualRevenueGenerationProcesses() {
        setDynamicTaskFlowId("/WEB-INF/accrualRevenueGenerationProcesses.xml#accrualRevenueGenerationProcesses");
        return null;
    }
                          
    public String covantaContractExpirationReport() {
        setDynamicTaskFlowId("/WEB-INF/covantaContractExpirationReport.xml#covantaContractExpirationReport");
        return null;
    }
    
    public String roleAndScreenSecuritySetUp() {
        setDynamicTaskFlowId("/WEB-INF/roleSecurityFlow.xml#roleSecurityFlow");
        return null;
    }

    public String userBusinessUnitSetUp() {
        setDynamicTaskFlowId("/WEB-INF/userBusinessUnitSetUpTable.xml#userBusinessUnitSetUpTable");
        return null;
    }
    
    public String metalsIndices() {
        setDynamicTaskFlowId("/WEB-INF/MetalIndicesFlow.xml#MetalIndicesFlow");
        return null;
    }
}
