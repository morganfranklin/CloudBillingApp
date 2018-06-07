package view;

import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.event.QueryOperationEvent;

public class auditReportsBBean {
    private RichTable carriersTblBind;
    private RichTable countiesTblBind;
    private RichTable destinationTblBind;
    private RichTable originsTblBind;
    private RichTable vehiclesTblBind;
    private RichTable customerTblBind;
    private RichTable contractsTblBind;
    private RichTable contractVerTblBind;
    private RichTable contractLineTblBind;
    private RichTable cntrctPrcngTblBind;

    public auditReportsBBean() {
    }

    public void setCarriersTblBind(RichTable carriersTblBind) {
        this.carriersTblBind = carriersTblBind;
    }

    public RichTable getCarriersTblBind() {
        return carriersTblBind;
    }

    public void countiesTblBind(QueryOperationEvent queryOperationEvent) {
        // Add event code here...
    }

    public void setCountiesTblBind(RichTable countiesTblBind) {
        this.countiesTblBind = countiesTblBind;
    }

    public RichTable getCountiesTblBind() {
        return countiesTblBind;
    }

    public void setDestinationTblBind(RichTable destinationTblBind) {
        this.destinationTblBind = destinationTblBind;
    }

    public RichTable getDestinationTblBind() {
        return destinationTblBind;
    }

    public void setOriginsTblBind(RichTable originsTblBind) {
        this.originsTblBind = originsTblBind;
    }

    public RichTable getOriginsTblBind() {
        return originsTblBind;
    }

    public void setVehiclesTblBind(RichTable vehiclesTblBind) {
        this.vehiclesTblBind = vehiclesTblBind;
    }

    public RichTable getVehiclesTblBind() {
        return vehiclesTblBind;
    }

    public void setCustomerTblBind(RichTable customerTblBind) {
        this.customerTblBind = customerTblBind;
    }

    public RichTable getCustomerTblBind() {
        return customerTblBind;
    }

    public void setContractsTblBind(RichTable contractsTblBind) {
        this.contractsTblBind = contractsTblBind;
    }

    public RichTable getContractsTblBind() {
        return contractsTblBind;
    }

    public void setContractVerTblBind(RichTable contractVerTblBind) {
        this.contractVerTblBind = contractVerTblBind;
    }

    public RichTable getContractVerTblBind() {
        return contractVerTblBind;
    }

    public void setContractLineTblBind(RichTable contractLineTblBind) {
        this.contractLineTblBind = contractLineTblBind;
    }

    public RichTable getContractLineTblBind() {
        return contractLineTblBind;
    }

    public void setCntrctPrcngTblBind(RichTable cntrctPrcngTblBind) {
        this.cntrctPrcngTblBind = cntrctPrcngTblBind;
    }

    public RichTable getCntrctPrcngTblBind() {
        return cntrctPrcngTblBind;
    }
}
