package view;

import java.io.Serializable;

import javax.faces.event.ActionEvent;

import oracle.adf.controller.TaskFlowId;

public class SetupTableRegionName implements Serializable {
    @SuppressWarnings("compatibility:-2977815651237131232")
    private static final long serialVersionUID = 7756754203189027214L;
    private String taskFlowId = "/WEB-INF/terminalSetUpTable.xml#terminalSetUpTable";

    public SetupTableRegionName() {
    }

    public TaskFlowId getDynamicTaskFlowId() {
        return TaskFlowId.parse(taskFlowId);
    }

    public void setDynamicTaskFlowId(String taskFlowId) {
        this.taskFlowId = taskFlowId;
    }

    public String terminalSetUpTable() {
        setDynamicTaskFlowId("/WEB-INF/terminalSetUpTable.xml#terminalSetUpTable");
        return null;
    }

    public String destinationSetUpTable() {
        setDynamicTaskFlowId("/WEB-INF/destinationSetUpTable.xml#destinationSetUpTable");
        return null;
    }
    
    public String countiesSetUpTable() {
        setDynamicTaskFlowId("/WEB-INF/countiesSetUpTable.xml#countiesSetUpTable");
        return null;
    }
    
    public String carriersSetUpTable() {
        setDynamicTaskFlowId("/WEB-INF/carriersSetUpTable.xml#carriersSetUpTable");
        return null;
    }

    public String vehicleTypesSetUpTable() {
        setDynamicTaskFlowId("/WEB-INF/vehiclesSetUpTable.xml#vehiclesSetUpTable");
        return null;
    }

    public String originsSetUpTable() {
        setDynamicTaskFlowId("/WEB-INF/originsSetUpTable.xml#originsSetUpTable");
        return null;
    }

    public String pcsInstallationSetUpTable() {
        setDynamicTaskFlowId("/WEB-INF/pcsInstallationSetUpTable.xml#pcsInstallationSetUpTable");
        return null;
    }

    public String productServiceSetUpTable() {
        setDynamicTaskFlowId("/WEB-INF/productServiceSetUpTable.xml#productServiceSetUpTable");
        return null;
    }

    public String generalSetUpTable() {
        setDynamicTaskFlowId("/WEB-INF/generalSetUpTable.xml#generalSetUpTable");
        return null;
    }

    public String pcsShortNameSetUpTable() {
        setDynamicTaskFlowId("/WEB-INF/pcsShortNameSetUpTable.xml#pcsShortNameSetUpTable");
        return null;
    }
}
