package model.common;

import oracle.jbo.ApplicationModule;
import oracle.jbo.domain.BlobDomain;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Aug 14 13:10:25 IST 2017
// ---------------------------------------------------------------------
public interface AppModule extends ApplicationModule {
    Boolean uploadFiletoDB(String filename, BlobDomain blob);

    void copyContractRow();


    void clearNewContract();

    void clearTermMaster();

    void fetchClauseForMasterTerm();

    void createTermContractRow(String termId);


    String addAssTerminalToDestination();

    String addAssTerminalToOrigin();

    String addAssTerminalToPCSInstallation();

    void updateContractApprovalStatus(String uuId, String action);
    
    String createNewContractVersion(String contractType);

    void billAndAccountingProcess();

    void initBillAccountProcess();

    boolean newContractCreation(byte[] bytes, String contractType);
}

