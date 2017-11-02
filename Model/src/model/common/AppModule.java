package model.common;

import java.util.Map;

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



    String createNewContractVersion(String contractType);

    void billAndAccountingProcess();

    void initBillAccountProcess();


    void initCntrctAprFcltySetUp();

    void resetCntrctAprFcltySetUp();

    void searchCntrctAprFcltySetUp(String type);
    String addAssTerminalToPCS();

    boolean newContractCreation(byte[] bytes, String contractId, String contractVersion);


    void updateContractApprovalStatus(String uuId, String action, byte[] bytes);


    Map buildXML(String contractId, String contractVersion);

    Map fetchPDFXML(String uuId);}

