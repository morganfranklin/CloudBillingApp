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

    boolean newContractCreation();

    void clearNewContract();

    void clearTermMaster();

    void fetchClauseForMasterTerm();

    void createTermContractRow(String termId);

    void updateContract();

    String addAssTerminalToDestination();

    String addAssTerminalToOrigin();

    String addAssTerminalToPCSInstallation();
}

