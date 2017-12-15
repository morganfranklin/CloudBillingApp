package model;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;

import java.math.BigDecimal;

import java.sql.SQLException;
import java.sql.Timestamp;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import model.common.AppModule;

import model.constants.NEUCloudBillingConstants;

import model.utils.EmailUtils;

import model.views.entitybased.XpeDccCfgAccountingEOVOImpl;
import model.views.entitybased.XpeDccCfgBusinessunitEOVOImpl;
import model.views.entitybased.XpeDccCfgCarriersEOVOImpl;
import model.views.entitybased.XpeDccCfgCmtmntFacilityEOVOImpl;
import model.views.entitybased.XpeDccCfgCmtmntFacilityEOVORowImpl;
import model.views.entitybased.XpeDccCfgCountiesEOVOImpl;
import model.views.entitybased.XpeDccCfgDestinationsEOVOImpl;
import model.views.entitybased.XpeDccCfgDestinationsEOVORowImpl;
import model.views.entitybased.XpeDccCfgDstAssTerminalsEOVOImpl;
import model.views.entitybased.XpeDccCfgDstAssTerminalsEOVORowImpl;
import model.views.entitybased.XpeDccCfgGeneralCnvEOVOImpl;
import model.views.entitybased.XpeDccCfgGeneralEOVOImpl;
import model.views.entitybased.XpeDccCfgMetalsFacilityEOVOImpl;
import model.views.entitybased.XpeDccCfgMetalsFacilityEOVORowImpl;
import model.views.entitybased.XpeDccCfgMswFacilityEOVOImpl;
import model.views.entitybased.XpeDccCfgMswFacilityEOVORowImpl;
import model.views.entitybased.XpeDccCfgNotifGroupsEOVOImpl;
import model.views.entitybased.XpeDccCfgNotificationEOVOImpl;
import model.views.entitybased.XpeDccCfgNycDosTermCustEOVOImpl;
import model.views.entitybased.XpeDccCfgOgnAssTerminalsEOVOImpl;
import model.views.entitybased.XpeDccCfgOgnAssTerminalsEOVORowImpl;
import model.views.entitybased.XpeDccCfgOriginsEOVOImpl;
import model.views.entitybased.XpeDccCfgOriginsEOVORowImpl;
import model.views.entitybased.XpeDccCfgPcsAssTerminalsEOVOImpl;
import model.views.entitybased.XpeDccCfgPcsAssTerminalsEOVORowImpl;
import model.views.entitybased.XpeDccCfgPcsEOVOImpl;
import model.views.entitybased.XpeDccCfgPcsEOVORowImpl;
import model.views.entitybased.XpeDccCfgPcsshortnamesEOVOImpl;
import model.views.entitybased.XpeDccCfgProductserviceEOVOImpl;
import model.views.entitybased.XpeDccCfgSpclWasteFcltyEOVOImpl;
import model.views.entitybased.XpeDccCfgTerminalsEOVOImpl;
import model.views.entitybased.XpeDccCfgUomEOVOImpl;
import model.views.entitybased.XpeDccCfgVehiclesEOVOImpl;
import model.views.entitybased.XpeDccNewContractsEOVOImpl;
import model.views.entitybased.XpeDccNewContractsEOVORowImpl;
import model.views.entitybased.XpeDccTermsContractEOVOImpl;
import model.views.entitybased.XpeDccTermsContractEOVORowImpl;
import model.views.entitybased.XpeDccWfActionEOVOImpl;
import model.views.entitybased.XpeDccWfActionEOVORowImpl;
import model.views.entitybased.XpeDccWfEventEOVOImpl;
import model.views.entitybased.XpeDccWfEventEOVORowImpl;
import model.views.entitybased.XpeDmsCustomerEOVOImpl;
import model.views.entitybased.XpeDmsCustomerEOVORowImpl;
import model.views.readonly.XpeDccCfgAccrualandRevenueGenerationROVOImpl;
import model.views.readonly.XpeDccCfgAccrualandRevenueGenerationROVORowImpl;
import model.views.readonly.XpeDccCfgBillingandAccountingROVOImpl;
import model.views.readonly.XpeDccCfgBillingandAccountingROVORowImpl;
import model.views.readonly.XpeDccCfgCntrcttAprFcltyROVOImpl;
import model.views.readonly.XpeDccCfgCntrcttAprFcltyROVORowImpl;
import model.views.readonly.XpeDccCfgDstAssTerminalsROVOImpl;
import model.views.readonly.XpeDccCfgDstAssTerminalsROVORowImpl;
import model.views.readonly.XpeDccCfgOgnAssTerminalsROVOImpl;
import model.views.readonly.XpeDccCfgOgnAssTerminalsROVORowImpl;
import model.views.readonly.XpeDccCfgPcsAddressROVOImpl;
import model.views.readonly.XpeDccCfgPcsAddressROVORowImpl;
import model.views.readonly.XpeDccCfgPcsAssTerminalsROVOImpl;
import model.views.readonly.XpeDccCfgPcsAssTerminalsROVORowImpl;
import model.views.readonly.XpeDccCfgTerminalsSearchROVOImpl;
import model.views.readonly.XpeDccCfgTerminalsSearchROVORowImpl;
import model.views.readonly.XpeDccContractSearchROVOImpl;
import model.views.readonly.XpeDccContractSearchROVORowImpl;
import model.views.readonly.XpeDccCustContractShortNameROVOImpl;
import model.views.readonly.XpeDccCustContractShortNameROVORowImpl;
import model.views.readonly.XpeDccNewContractCustomerSearchROVOImpl;
import model.views.readonly.XpeDccNewContractCustomerSearchROVORowImpl;
import model.views.readonly.XpeDccNewContractSetupROVOImpl;
import model.views.readonly.XpeDccNewContractSetupROVORowImpl;
import model.views.readonly.XpeDccTermsForMasterTermROVOImpl;
import model.views.readonly.XpeDccTermsForMasterTermROVORowImpl;
import model.views.readonly.XpeDccWfActionROVOImpl;
import model.views.readonly.XpeDccWfActionROVORowImpl;
import model.views.readonly.XpeDmsCustomerROVOImpl;

import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.RowIterator;
import oracle.jbo.RowSet;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewCriteria;
import oracle.jbo.domain.BlobDomain;
import oracle.jbo.domain.ClobDomain;
import oracle.jbo.server.ApplicationModuleImpl;
import oracle.jbo.server.Entity;
import oracle.jbo.server.ViewLinkImpl;
import oracle.jbo.server.ViewObjectImpl;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Aug 14 13:09:27 IST 2017
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class AppModuleImpl extends ApplicationModuleImpl implements AppModule {
    /**
     * This is the default constructor (do not remove).
     */
    public AppModuleImpl() {
    }

    /**
     * Container's getter for NeuTnsSourceTblView1.
     * @return NeuTnsSourceTblView1
     */
    public ViewObjectImpl getNeuTnsSourceTblView1() {
        return (ViewObjectImpl) findViewObject("NeuTnsSourceTblView1");
    }

    /**
     * Container's getter for NeuAllSourceTblView1.
     * @return NeuAllSourceTblView1
     */
    public ViewObjectImpl getNeuAllSourceTblView1() {
        return (ViewObjectImpl) findViewObject("NeuAllSourceTblView1");
    }

    /**
     * Container's getter for NeuSourceStatTblView1.
     * @return NeuSourceStatTblView1
     */
    public ViewObjectImpl getNeuSourceStatTblView1() {
        return (ViewObjectImpl) findViewObject("NeuSourceStatTblView1");
    }

    /**
     * Container's getter for NeuTnsVndrXrefView1.
     * @return NeuTnsVndrXrefView1
     */
    public ViewObjectImpl getNeuTnsVndrXrefView1() {
        return (ViewObjectImpl) findViewObject("NeuTnsVndrXrefView1");
    }

    /**
     * Container's getter for NeuTnsVendVwView1.
     * @return NeuTnsVendVwView1
     */
    public ViewObjectImpl getNeuTnsVendVwView1() {
        return (ViewObjectImpl) findViewObject("NeuTnsVendVwView1");
    }

    /**
     * Container's getter for NeuVendorsVwView1.
     * @return NeuVendorsVwView1
     */
    public ViewObjectImpl getNeuVendorsVwView1() {
        return (ViewObjectImpl) findViewObject("NeuVendorsVwView1");
    }

    /**
     * Container's getter for NeuTnsCustXrefView1.
     * @return NeuTnsCustXrefView1
     */
    public ViewObjectImpl getNeuTnsCustXrefView1() {
        return (ViewObjectImpl) findViewObject("NeuTnsCustXrefView1");
    }

    /**
     * Container's getter for NeuCustomersVwView1.
     * @return NeuCustomersVwView1
     */
    public ViewObjectImpl getNeuCustomersVwView1() {
        return (ViewObjectImpl) findViewObject("NeuCustomersVwView1");
    }

    /**
     * Container's getter for NeuTnsCustVwView1.
     * @return NeuTnsCustVwView1
     */
    public ViewObjectImpl getNeuTnsCustVwView1() {
        return (ViewObjectImpl) findViewObject("NeuTnsCustVwView1");
    }

    /**
     * Container's getter for NeuTnsCustXrefView2.
     * @return NeuTnsCustXrefView2
     */
    public ViewObjectImpl getNeuTnsCustXrefView2() {
        return (ViewObjectImpl) findViewObject("NeuTnsCustXrefView2");
    }

    /**
     * Container's getter for NeuEventBillTblView1.
     * @return NeuEventBillTblView1
     */
    public ViewObjectImpl getNeuEventBillTblView1() {
        return (ViewObjectImpl) findViewObject("NeuEventBillTblView1");
    }

    /**
     * Container's getter for NeuEventVchrTblView1.
     * @return NeuEventVchrTblView1
     */
    public ViewObjectImpl getNeuEventVchrTblView1() {
        return (ViewObjectImpl) findViewObject("NeuEventVchrTblView1");
    }

    /**
     * Container's getter for NeuParAllTblView1.
     * @return NeuParAllTblView1
     */
    public ViewObjectImpl getNeuParAllTblView1() {
        return (ViewObjectImpl) findViewObject("NeuParAllTblView1");
    }

    /**
     * Container's getter for NeuParAllTblQView1.
     * @return NeuParAllTblQView1
     */
    public ViewObjectImpl getNeuParAllTblQView1() {
        return (ViewObjectImpl) findViewObject("NeuParAllTblQView1");
    }

    /**
     * Container's getter for NeuRulesetTblView1.
     * @return NeuRulesetTblView1
     */
    public ViewObjectImpl getNeuRulesetTblView1() {
        return (ViewObjectImpl) findViewObject("NeuRulesetTblView1");
    }

    /**
     * Container's getter for NeuParSourceSystemView1.
     * @return NeuParSourceSystemView1
     */
    public ViewObjectImpl getNeuParSourceSystemView1() {
        return (ViewObjectImpl) findViewObject("NeuParSourceSystemView1");
    }

    /**
     * Container's getter for NeuParRuleOperatorView1.
     * @return NeuParRuleOperatorView1
     */
    public ViewObjectImpl getNeuParRuleOperatorView1() {
        return (ViewObjectImpl) findViewObject("NeuParRuleOperatorView1");
    }

    /**
     * Container's getter for NeuParAttributeLeftView1.
     * @return NeuParAttributeLeftView1
     */
    public ViewObjectImpl getNeuParAttributeLeftView1() {
        return (ViewObjectImpl) findViewObject("NeuParAttributeLeftView1");
    }

    /**
     * Container's getter for NeuParConditionOperatorView1.
     * @return NeuParConditionOperatorView1
     */
    public ViewObjectImpl getNeuParConditionOperatorView1() {
        return (ViewObjectImpl) findViewObject("NeuParConditionOperatorView1");
    }

    /**
     * Container's getter for NeuParCustomConditionView1.
     * @return NeuParCustomConditionView1
     */
    public ViewObjectImpl getNeuParCustomConditionView1() {
        return (ViewObjectImpl) findViewObject("NeuParCustomConditionView1");
    }

    /**
     * Container's getter for NeuParActionTypeView1.
     * @return NeuParActionTypeView1
     */
    public ViewObjectImpl getNeuParActionTypeView1() {
        return (ViewObjectImpl) findViewObject("NeuParActionTypeView1");
    }

    /**
     * Container's getter for NeuParDimensionView1.
     * @return NeuParDimensionView1
     */
    public ViewObjectImpl getNeuParDimensionView1() {
        return (ViewObjectImpl) findViewObject("NeuParDimensionView1");
    }

    /**
     * Container's getter for NeuParMappingTableView1.
     * @return NeuParMappingTableView1
     */
    public ViewObjectImpl getNeuParMappingTableView1() {
        return (ViewObjectImpl) findViewObject("NeuParMappingTableView1");
    }

    /**
     * Container's getter for NeuActionTblView1.
     * @return NeuActionTblView1
     */
    public ViewObjectImpl getNeuActionTblView1() {
        return (ViewObjectImpl) findViewObject("NeuActionTblView1");
    }

    /**
     * Container's getter for NeuCondTblView1.
     * @return NeuCondTblView1
     */
    public ViewObjectImpl getNeuCondTblView1() {
        return (ViewObjectImpl) findViewObject("NeuCondTblView1");
    }

    /**
     * Container's getter for NeuRuleTblView1.
     * @return NeuRuleTblView1
     */
    public ViewObjectImpl getNeuRuleTblView1() {
        return (ViewObjectImpl) findViewObject("NeuRuleTblView1");
    }

    /**
     * Container's getter for NeuRulesetTbl1View1.
     * @return NeuRulesetTbl1View1
     */
    public ViewObjectImpl getNeuRulesetTbl1View1() {
        return (ViewObjectImpl) findViewObject("NeuRulesetTbl1View1");
    }

    /**
     * Container's getter for NeuRuleTblView2.
     * @return NeuRuleTblView2
     */
    public ViewObjectImpl getNeuRuleTblView2() {
        return (ViewObjectImpl) findViewObject("NeuRuleTblView2");
    }

    /**
     * Container's getter for NeuCondTblView2.
     * @return NeuCondTblView2
     */
    public ViewObjectImpl getNeuCondTblView2() {
        return (ViewObjectImpl) findViewObject("NeuCondTblView2");
    }

    /**
     * Container's getter for NeuActionTblView2.
     * @return NeuActionTblView2
     */
    public ViewObjectImpl getNeuActionTblView2() {
        return (ViewObjectImpl) findViewObject("NeuActionTblView2");
    }

    /**
     * Container's getter for NeuParAttributeRightView1.
     * @return NeuParAttributeRightView1
     */
    public ViewObjectImpl getNeuParAttributeRightView1() {
        return (ViewObjectImpl) findViewObject("NeuParAttributeRightView1");
    }

    /**
     * Container's getter for PsCisXpeImportView1.
     * @return PsCisXpeImportView1
     */
    public ViewObjectImpl getPsCisXpeImportView1() {
        return (ViewObjectImpl) findViewObject("PsCisXpeImportView1");
    }

    /**
     * Container's getter for PsCisXpeContrView1.
     * @return PsCisXpeContrView1
     */
    public ViewObjectImpl getPsCisXpeContrView1() {
        return (ViewObjectImpl) findViewObject("PsCisXpeContrView1");
    }

    /**
     * Container's getter for PsCisXpeExecplnView1.
     * @return PsCisXpeExecplnView1
     */
    public ViewObjectImpl getPsCisXpeExecplnView1() {
        return (ViewObjectImpl) findViewObject("PsCisXpeExecplnView1");
    }

    /**
     * Container's getter for PsCisXpeExecstpView1.
     * @return PsCisXpeExecstpView1
     */
    public ViewObjectImpl getPsCisXpeExecstpView1() {
        return (ViewObjectImpl) findViewObject("PsCisXpeExecstpView1");
    }

    /**
     * Container's getter for PsCisXpeExecstpView2.
     * @return PsCisXpeExecstpView2
     */
    public ViewObjectImpl getPsCisXpeExecstpView2() {
        return (ViewObjectImpl) findViewObject("PsCisXpeExecstpView2");
    }

    /**
     * Container's getter for PsCisXpeRulcondView1.
     * @return PsCisXpeRulcondView1
     */
    public ViewObjectImpl getPsCisXpeRulcondView1() {
        return (ViewObjectImpl) findViewObject("PsCisXpeRulcondView1");
    }

    /**
     * Container's getter for PsCisXpeRuleView1.
     * @return PsCisXpeRuleView1
     */
    public ViewObjectImpl getPsCisXpeRuleView1() {
        return (ViewObjectImpl) findViewObject("PsCisXpeRuleView1");
    }

    /**
     * Container's getter for PsCisXpeRulesetView1.
     * @return PsCisXpeRulesetView1
     */
    public ViewObjectImpl getPsCisXpeRulesetView1() {
        return (ViewObjectImpl) findViewObject("PsCisXpeRulesetView1");
    }

    /**
     * Container's getter for PsCisXpeRuleView2.
     * @return PsCisXpeRuleView2
     */
    public ViewObjectImpl getPsCisXpeRuleView2() {
        return (ViewObjectImpl) findViewObject("PsCisXpeRuleView2");
    }

    /**
     * Container's getter for PsCisXpeRuleView3.
     * @return PsCisXpeRuleView3
     */
    public ViewObjectImpl getPsCisXpeRuleView3() {
        return (ViewObjectImpl) findViewObject("PsCisXpeRuleView3");
    }

    /**
     * Container's getter for PsCisXpeActDtlView1.
     * @return PsCisXpeActDtlView1
     */
    public ViewObjectImpl getPsCisXpeActDtlView1() {
        return (ViewObjectImpl) findViewObject("PsCisXpeActDtlView1");
    }

    /**
     * Container's getter for PsCisXpeActionView1.
     * @return PsCisXpeActionView1
     */
    public PsCisXpeActionViewImpl getPsCisXpeActionView1() {
        return (PsCisXpeActionViewImpl) findViewObject("PsCisXpeActionView1");
    }

    /**
     * Container's getter for PsCisXpeActDtlView2.
     * @return PsCisXpeActDtlView2
     */
    public ViewObjectImpl getPsCisXpeActDtlView2() {
        return (ViewObjectImpl) findViewObject("PsCisXpeActDtlView2");
    }

    /**
     * Container's getter for PsCisXpeUdcaCurrentVwView1.
     * @return PsCisXpeUdcaCurrentVwView1
     */
    public ViewObjectImpl getPsCisXpeUdcaCurrentVwView1() {
        return (ViewObjectImpl) findViewObject("PsCisXpeUdcaCurrentVwView1");
    }

    /**
     * Container's getter for PsCisXpeUdcaClosedVwView1.
     * @return PsCisXpeUdcaClosedVwView1
     */
    public ViewObjectImpl getPsCisXpeUdcaClosedVwView1() {
        return (ViewObjectImpl) findViewObject("PsCisXpeUdcaClosedVwView1");
    }

    /**
     * Container's getter for PsCisXpeUdcaHistoryVwView1.
     * @return PsCisXpeUdcaHistoryVwView1
     */
    public ViewObjectImpl getPsCisXpeUdcaHistoryVwView1() {
        return (ViewObjectImpl) findViewObject("PsCisXpeUdcaHistoryVwView1");
    }

    /**
     * Container's getter for PsCisXpeImpContrVwView1.
     * @return PsCisXpeImpContrVwView1
     */
    public ViewObjectImpl getPsCisXpeImpContrVwView1() {
        return (ViewObjectImpl) findViewObject("PsCisXpeImpContrVwView1");
    }

    /**
     * Container's getter for PsCisXpeProcessView1.
     * @return PsCisXpeProcessView1
     */
    public ViewObjectImpl getPsCisXpeProcessView1() {
        return (ViewObjectImpl) findViewObject("PsCisXpeProcessView1");
    }

    /**
     * Container's getter for RoleQuery1.
     * @return RoleQuery1
     */
    public RoleQueryImpl getRoleQuery1() {
        return (RoleQueryImpl) findViewObject("RoleQuery1");
    }

    /**
     * Container's getter for PsCisXpeRuleView4.
     * @return PsCisXpeRuleView4
     */
    public ViewObjectImpl getPsCisXpeRuleView4() {
        return (ViewObjectImpl) findViewObject("PsCisXpeRuleView4");
    }

    /**
     * Container's getter for PsCisXpeActionView2.
     * @return PsCisXpeActionView2
     */
    public PsCisXpeActionViewImpl getPsCisXpeActionView2() {
        return (PsCisXpeActionViewImpl) findViewObject("PsCisXpeActionView2");
    }

    /**
     * Container's getter for ActiveInactive1.
     * @return ActiveInactive1
     */
    public ViewObjectImpl getActiveInactive1() {
        return (ViewObjectImpl) findViewObject("ActiveInactive1");
    }

    /**
     * Container's getter for PsCisXpeActTypView1.
     * @return PsCisXpeActTypView1
     */
    public ViewObjectImpl getPsCisXpeActTypView1() {
        return (ViewObjectImpl) findViewObject("PsCisXpeActTypView1");
    }

    /**
     * Container's getter for PsCisXpeMapDtlView1.
     * @return PsCisXpeMapDtlView1
     */
    public ViewObjectImpl getPsCisXpeMapDtlView1() {
        return (ViewObjectImpl) findViewObject("PsCisXpeMapDtlView1");
    }

    /**
     * Container's getter for PsCisXpeMappingView1.
     * @return PsCisXpeMappingView1
     */
    public ViewObjectImpl getPsCisXpeMappingView1() {
        return (ViewObjectImpl) findViewObject("PsCisXpeMappingView1");
    }

    /**
     * Container's getter for PsCisXpeMapDtlView2.
     * @return PsCisXpeMapDtlView2
     */
    public ViewObjectImpl getPsCisXpeMapDtlView2() {
        return (ViewObjectImpl) findViewObject("PsCisXpeMapDtlView2");
    }

    /**
     * Container's getter for ProcessingStatView1.
     * @return ProcessingStatView1
     */
    public ViewObjectImpl getProcessingStatView1() {
        return (ViewObjectImpl) findViewObject("ProcessingStatView1");
    }

    /**
     * Container's getter for NeuStatErrorsCount1.
     * @return NeuStatErrorsCount1
     */
    public ViewObjectImpl getNeuStatErrorsCount1() {
        return (ViewObjectImpl) findViewObject("NeuStatErrorsCount1");
    }

    /**
     * Container's getter for NeuStatActiveProcesses1.
     * @return NeuStatActiveProcesses1
     */
    public ViewObjectImpl getNeuStatActiveProcesses1() {
        return (ViewObjectImpl) findViewObject("NeuStatActiveProcesses1");
    }

    /**
     * Container's getter for NeuStatPendingContracts1.
     * @return NeuStatPendingContracts1
     */
    public ViewObjectImpl getNeuStatPendingContracts1() {
        return (ViewObjectImpl) findViewObject("NeuStatPendingContracts1");
    }

    /**
     * Container's getter for NeuStatPendingTransactions1.
     * @return NeuStatPendingTransactions1
     */
    public ViewObjectImpl getNeuStatPendingTransactions1() {
        return (ViewObjectImpl) findViewObject("NeuStatPendingTransactions1");
    }

    /**
     * Container's getter for NeuStatErrorTypes1.
     * @return NeuStatErrorTypes1
     */
    public ViewObjectImpl getNeuStatErrorTypes1() {
        return (ViewObjectImpl) findViewObject("NeuStatErrorTypes1");
    }

    /**
     * Container's getter for CovLookupsView1.
     * @return CovLookupsView1
     */
    public ViewObjectImpl getCovLookupsView1() {
        return (ViewObjectImpl) findViewObject("CovLookupsView1");
    }

    /**
     * Container's getter for CovContractDetailsView1.
     * @return CovContractDetailsView1
     */
    public ViewObjectImpl getCovContractDetailsView1() {
        return (ViewObjectImpl) findViewObject("CovContractDetailsView1");
    }

    /**
     * Container's getter for CovContractLinesView1.
     * @return CovContractLinesView1
     */
    public ViewObjectImpl getCovContractLinesView1() {
        return (ViewObjectImpl) findViewObject("CovContractLinesView1");
    }

    /**
     * Container's getter for CovContractsView1.
     * @return CovContractsView1
     */
    public ViewObjectImpl getCovContractsView1() {
        return (ViewObjectImpl) findViewObject("CovContractsView1");
    }

    /**
     * Container's getter for CovLookups1View1.
     * @return CovLookups1View1
     */
    public ViewObjectImpl getCovLookups1View1() {
        return (ViewObjectImpl) findViewObject("CovLookups1View1");
    }

    /**
     * Container's getter for CovContractDetailsView2.
     * @return CovContractDetailsView2
     */
    public ViewObjectImpl getCovContractDetailsView2() {
        return (ViewObjectImpl) findViewObject("CovContractDetailsView2");
    }

    /**
     * Container's getter for CovContractDetailsView3.
     * @return CovContractDetailsView3
     */
    public ViewObjectImpl getCovContractDetailsView3() {
        return (ViewObjectImpl) findViewObject("CovContractDetailsView3");
    }

    /**
     * Container's getter for CovContractLinesView2.
     * @return CovContractLinesView2
     */
    public ViewObjectImpl getCovContractLinesView2() {
        return (ViewObjectImpl) findViewObject("CovContractLinesView2");
    }

    /**
     * Container's getter for CovDictionarySales1.
     * @return CovDictionarySales1
     */
    public ViewObjectImpl getCovDictionarySales1() {
        return (ViewObjectImpl) findViewObject("CovDictionarySales1");
    }

    /**
     * Container's getter for CovDictionaryWaste1.
     * @return CovDictionaryWaste1
     */
    public ViewObjectImpl getCovDictionaryWaste1() {
        return (ViewObjectImpl) findViewObject("CovDictionaryWaste1");
    }

    /**
     * Container's getter for CovDictionaryDestination1.
     * @return CovDictionaryDestination1
     */
    public ViewObjectImpl getCovDictionaryDestination1() {
        return (ViewObjectImpl) findViewObject("CovDictionaryDestination1");
    }

    /**
     * Container's getter for CovDictionaryMaterial1.
     * @return CovDictionaryMaterial1
     */
    public ViewObjectImpl getCovDictionaryMaterial1() {
        return (ViewObjectImpl) findViewObject("CovDictionaryMaterial1");
    }

    /**
     * Container's getter for CovDictionaryCarrier1.
     * @return CovDictionaryCarrier1
     */
    public ViewObjectImpl getCovDictionaryCarrier1() {
        return (ViewObjectImpl) findViewObject("CovDictionaryCarrier1");
    }

    /**
     * Container's getter for CovDictionaryVehicle1.
     * @return CovDictionaryVehicle1
     */
    public ViewObjectImpl getCovDictionaryVehicle1() {
        return (ViewObjectImpl) findViewObject("CovDictionaryVehicle1");
    }

    /**
     * Container's getter for CovDictionaryDetailType1.
     * @return CovDictionaryDetailType1
     */
    public ViewObjectImpl getCovDictionaryDetailType1() {
        return (ViewObjectImpl) findViewObject("CovDictionaryDetailType1");
    }

    /**
     * Container's getter for CovTerms1.
     * @return CovTerms1
     */
    public ViewObjectImpl getCovTerms1() {
        return (ViewObjectImpl) findViewObject("CovTerms1");
    }

    /**
     * Container's getter for CovUnbill1.
     * @return CovUnbill1
     */
    public ViewObjectImpl getCovUnbill1() {
        return (ViewObjectImpl) findViewObject("CovUnbill1");
    }

    /**
     * Container's getter for CovBill1.
     * @return CovBill1
     */
    public ViewObjectImpl getCovBill1() {
        return (ViewObjectImpl) findViewObject("CovBill1");
    }

    /**
     * Container's getter for CovAudit1.
     * @return CovAudit1
     */
    public ViewObjectImpl getCovAudit1() {
        return (ViewObjectImpl) findViewObject("CovAudit1");
    }

    /**
     * Container's getter for XpeDccLookupMasterView1.
     * @return XpeDccLookupMasterView1
     */
    public ViewObjectImpl getXpeDccLookupMasterView1() {
        return (ViewObjectImpl) findViewObject("XpeDccLookupMasterView1");
    }

    /**
     * Container's getter for XpeDccPlatformEventView1.
     * @return XpeDccPlatformEventView1
     */
    public ViewObjectImpl getXpeDccPlatformEventView1() {
        return (ViewObjectImpl) findViewObject("XpeDccPlatformEventView1");
    }


    /**
     * Container's getter for XpeDccDicPartyType1.
     * @return XpeDccDicPartyType1
     */
    public ViewObjectImpl getXpeDccDicPartyType1() {
        return (ViewObjectImpl) findViewObject("XpeDccDicPartyType1");
    }

    /**
     * Container's getter for XpeDccDicYesNo1.
     * @return XpeDccDicYesNo1
     */
    public ViewObjectImpl getXpeDccDicYesNo1() {
        return (ViewObjectImpl) findViewObject("XpeDccDicYesNo1");
    }

    /**
     * Container's getter for XpeDccDicContractStatus1.
     * @return XpeDccDicContractStatus1
     */
    public ViewObjectImpl getXpeDccDicContractStatus1() {
        return (ViewObjectImpl) findViewObject("XpeDccDicContractStatus1");
    }

    /**
     * Container's getter for XpeDccDicOptionsBilling1.
     * @return XpeDccDicOptionsBilling1
     */
    public ViewObjectImpl getXpeDccDicOptionsBilling1() {
        return (ViewObjectImpl) findViewObject("XpeDccDicOptionsBilling1");
    }

    /**
     * Container's getter for XpeDccDicOptionsRenewal1.
     * @return XpeDccDicOptionsRenewal1
     */
    public ViewObjectImpl getXpeDccDicOptionsRenewal1() {
        return (ViewObjectImpl) findViewObject("XpeDccDicOptionsRenewal1");
    }

    /**
     * Container's getter for XpeDccDicOptionsAccounting1.
     * @return XpeDccDicOptionsAccounting1
     */
    public ViewObjectImpl getXpeDccDicOptionsAccounting1() {
        return (ViewObjectImpl) findViewObject("XpeDccDicOptionsAccounting1");
    }

    /**
     * Container's getter for XpeDccDicBusinessUnits1.
     * @return XpeDccDicBusinessUnits1
     */
    public ViewObjectImpl getXpeDccDicBusinessUnits1() {
        return (ViewObjectImpl) findViewObject("XpeDccDicBusinessUnits1");
    }

    /**
     * Container's getter for XpeDccDicCurrency1.
     * @return XpeDccDicCurrency1
     */
    public ViewObjectImpl getXpeDccDicCurrency1() {
        return (ViewObjectImpl) findViewObject("XpeDccDicCurrency1");
    }

    /**
     * Container's getter for XpeDccDicFacilities1.
     * @return XpeDccDicFacilities1
     */
    public ViewObjectImpl getXpeDccDicFacilities1() {
        return (ViewObjectImpl) findViewObject("XpeDccDicFacilities1");
    }

    /**
     * Container's getter for XpeDccDicProducts1.
     * @return XpeDccDicProducts1
     */
    public ViewObjectImpl getXpeDccDicProducts1() {
        return (ViewObjectImpl) findViewObject("XpeDccDicProducts1");
    }

    /**
     * Container's getter for XpeDccDicUnitsOfMeasure1.
     * @return XpeDccDicUnitsOfMeasure1
     */
    public ViewObjectImpl getXpeDccDicUnitsOfMeasure1() {
        return (ViewObjectImpl) findViewObject("XpeDccDicUnitsOfMeasure1");
    }

    /**
     * Container's getter for XpeDccDicPeriods1.
     * @return XpeDccDicPeriods1
     */
    public ViewObjectImpl getXpeDccDicPeriods1() {
        return (ViewObjectImpl) findViewObject("XpeDccDicPeriods1");
    }

    /**
     * Container's getter for XpeDccDicRateTypes1.
     * @return XpeDccDicRateTypes1
     */
    public ViewObjectImpl getXpeDccDicRateTypes1() {
        return (ViewObjectImpl) findViewObject("XpeDccDicRateTypes1");
    }

    /**
     * Container's getter for XpeDccDicRolloverTypes1.
     * @return XpeDccDicRolloverTypes1
     */
    public ViewObjectImpl getXpeDccDicRolloverTypes1() {
        return (ViewObjectImpl) findViewObject("XpeDccDicRolloverTypes1");
    }

    /**
     * Container's getter for XpeDccDicResetTypes1.
     * @return XpeDccDicResetTypes1
     */
    public ViewObjectImpl getXpeDccDicResetTypes1() {
        return (ViewObjectImpl) findViewObject("XpeDccDicResetTypes1");
    }

    /**
     * Container's getter for XpeDccDicOverrideType1.
     * @return XpeDccDicOverrideType1
     */
    public ViewObjectImpl getXpeDccDicOverrideType1() {
        return (ViewObjectImpl) findViewObject("XpeDccDicOverrideType1");
    }

    /**
     * Container's getter for XpeDccDicFields1.
     * @return XpeDccDicFields1
     */
    public ViewObjectImpl getXpeDccDicFields1() {
        return (ViewObjectImpl) findViewObject("XpeDccDicFields1");
    }

    /**
     * Container's getter for XpeDccDicConditions1.
     * @return XpeDccDicConditions1
     */
    public ViewObjectImpl getXpeDccDicConditions1() {
        return (ViewObjectImpl) findViewObject("XpeDccDicConditions1");
    }

    /**
     * Container's getter for XpeDccDicVehicleTypes1.
     * @return XpeDccDicVehicleTypes1
     */
    public ViewObjectImpl getXpeDccDicVehicleTypes1() {
        return (ViewObjectImpl) findViewObject("XpeDccDicVehicleTypes1");
    }

    /**
     * Container's getter for XpeDccCustomerSearch1.
     * @return XpeDccCustomerSearch1
     */
    public ViewObjectImpl getXpeDccCustomerSearch1() {
        return (ViewObjectImpl) findViewObject("XpeDccCustomerSearch1");
    }

    /**
     * Container's getter for XpeDccContractsView2.
     * @return XpeDccContractsView2
     */
    public XpeDccContractsViewImpl getXpeDccContractsView2() {
        return (XpeDccContractsViewImpl) findViewObject("XpeDccContractsView2");
    }

    /**
     * Container's getter for XpeDccContractPartyView1.
     * @return XpeDccContractPartyView1
     */
    public ViewObjectImpl getXpeDccContractPartyView1() {
        return (ViewObjectImpl) findViewObject("XpeDccContractPartyView1");
    }

    /**
     * Container's getter for XpeDccContractVersionView1.
     * @return XpeDccContractVersionView1
     */
    public XpeDccContractVersionViewImpl getXpeDccContractVersionView1() {
        return (XpeDccContractVersionViewImpl) findViewObject("XpeDccContractVersionView1");
    }

    /**
     * Container's getter for XpeDccPlatformEventView3.
     * @return XpeDccPlatformEventView3
     */
    public ViewObjectImpl getXpeDccPlatformEventView3() {
        return (ViewObjectImpl) findViewObject("XpeDccPlatformEventView3");
    }

    /**
     * Container's getter for XpeDccContractLineView1.
     * @return XpeDccContractLineView1
     */
    public XpeDccContractLineViewImpl getXpeDccContractLineView1() {
        return (XpeDccContractLineViewImpl) findViewObject("XpeDccContractLineView1");
    }

    /**
     * Container's getter for XpeDccContractDocTermView1.
     * @return XpeDccContractDocTermView1
     */
    public ViewObjectImpl getXpeDccContractDocTermView1() {
        return (ViewObjectImpl) findViewObject("XpeDccContractDocTermView1");
    }

    /**
     * Container's getter for XpeDccContractPricingTermView1.
     * @return XpeDccContractPricingTermView1
     */
    public XpeDccContractPricingTermViewImpl getXpeDccContractPricingTermView1() {
        return (XpeDccContractPricingTermViewImpl) findViewObject("XpeDccContractPricingTermView1");
    }

    /**
     * Container's getter for XpeDccContractCarrierView1.
     * @return XpeDccContractCarrierView1
     */
    public XpeDccContractCarrierViewImpl getXpeDccContractCarrierView1() {
        return (XpeDccContractCarrierViewImpl) findViewObject("XpeDccContractCarrierView1");
    }


    /**
     * Container's getter for XpeDccContractNotesView1.
     * @return XpeDccContractNotesView1
     */
    public XpeDccContractNotesViewImpl getXpeDccContractNotesView1() {
        return (XpeDccContractNotesViewImpl) findViewObject("XpeDccContractNotesView1");
    }


    /**
     * Container's getter for XpeDccContractsView1.
     * @return XpeDccContractsView1
     */
    public XpeDccContractsViewImpl getXpeDccContractsView1() {
        return (XpeDccContractsViewImpl) findViewObject("XpeDccContractsView1");
    }


    /**
     * Container's getter for XpeDccContractsAttachmentsView1.
     * @return XpeDccContractsAttachmentsView1
     */
    public ViewObjectImpl getXpeDccContractsAttachmentsView1() {
        return (ViewObjectImpl) findViewObject("XpeDccContractsAttachmentsView1");
    }

    /**
     * Container's getter for NeuRuleTblFk1Link1.
     * @return NeuRuleTblFk1Link1
     */
    public ViewLinkImpl getNeuRuleTblFk1Link1() {
        return (ViewLinkImpl) findViewLink("NeuRuleTblFk1Link1");
    }

    /**
     * Container's getter for NeuCondTblFk1Link1.
     * @return NeuCondTblFk1Link1
     */
    public ViewLinkImpl getNeuCondTblFk1Link1() {
        return (ViewLinkImpl) findViewLink("NeuCondTblFk1Link1");
    }

    /**
     * Container's getter for NeuActionTblFk1Link1.
     * @return NeuActionTblFk1Link1
     */
    public ViewLinkImpl getNeuActionTblFk1Link1() {
        return (ViewLinkImpl) findViewLink("NeuActionTblFk1Link1");
    }

    /**
     * Container's getter for PsCisXpeExecutionStepFk1Link1.
     * @return PsCisXpeExecutionStepFk1Link1
     */
    public ViewLinkImpl getPsCisXpeExecutionStepFk1Link1() {
        return (ViewLinkImpl) findViewLink("PsCisXpeExecutionStepFk1Link1");
    }

    /**
     * Container's getter for PsCisXpeRuleRuleSetFk1Link1.
     * @return PsCisXpeRuleRuleSetFk1Link1
     */
    public ViewLinkImpl getPsCisXpeRuleRuleSetFk1Link1() {
        return (ViewLinkImpl) findViewLink("PsCisXpeRuleRuleSetFk1Link1");
    }

    /**
     * Container's getter for PsCisXpeRuleFk1Link1.
     * @return PsCisXpeRuleFk1Link1
     */
    public ViewLinkImpl getPsCisXpeRuleFk1Link1() {
        return (ViewLinkImpl) findViewLink("PsCisXpeRuleFk1Link1");
    }

    /**
     * Container's getter for PsCisXpeActionDetailFk1Link1.
     * @return PsCisXpeActionDetailFk1Link1
     */
    public ViewLinkImpl getPsCisXpeActionDetailFk1Link1() {
        return (ViewLinkImpl) findViewLink("PsCisXpeActionDetailFk1Link1");
    }

    /**
     * Container's getter for PsCisXpeMappingDetailFk1Link1.
     * @return PsCisXpeMappingDetailFk1Link1
     */
    public ViewLinkImpl getPsCisXpeMappingDetailFk1Link1() {
        return (ViewLinkImpl) findViewLink("PsCisXpeMappingDetailFk1Link1");
    }

    /**
     * Container's getter for CovContractDetailsFk1Link1.
     * @return CovContractDetailsFk1Link1
     */
    public ViewLinkImpl getCovContractDetailsFk1Link1() {
        return (ViewLinkImpl) findViewLink("CovContractDetailsFk1Link1");
    }

    /**
     * Container's getter for CovContractDetailsFk2Link1.
     * @return CovContractDetailsFk2Link1
     */
    public ViewLinkImpl getCovContractDetailsFk2Link1() {
        return (ViewLinkImpl) findViewLink("CovContractDetailsFk2Link1");
    }

    /**
     * Container's getter for CovContractLinesFk1Link1.
     * @return CovContractLinesFk1Link1
     */
    public ViewLinkImpl getCovContractLinesFk1Link1() {
        return (ViewLinkImpl) findViewLink("CovContractLinesFk1Link1");
    }

    /**
     * Container's getter for XpeDccCustomerContractVl1.
     * @return XpeDccCustomerContractVl1
     */
    public ViewLinkImpl getXpeDccCustomerContractVl1() {
        return (ViewLinkImpl) findViewLink("XpeDccCustomerContractVl1");
    }

    /**
     * Container's getter for XpeDccContractPartyFk1Link2.
     * @return XpeDccContractPartyFk1Link2
     */
    public ViewLinkImpl getXpeDccContractPartyFk1Link2() {
        return (ViewLinkImpl) findViewLink("XpeDccContractPartyFk1Link2");
    }

    /**
     * Container's getter for XpeDccContractVersionFk1Link2.
     * @return XpeDccContractVersionFk1Link2
     */
    public ViewLinkImpl getXpeDccContractVersionFk1Link2() {
        return (ViewLinkImpl) findViewLink("XpeDccContractVersionFk1Link2");
    }

    /**
     * Container's getter for XpeDccPlatformEventFk1Link2.
     * @return XpeDccPlatformEventFk1Link2
     */
    public ViewLinkImpl getXpeDccPlatformEventFk1Link2() {
        return (ViewLinkImpl) findViewLink("XpeDccPlatformEventFk1Link2");
    }

    /**
     * Container's getter for XpeDccContractLineFk1Link1.
     * @return XpeDccContractLineFk1Link1
     */
    public ViewLinkImpl getXpeDccContractLineFk1Link1() {
        return (ViewLinkImpl) findViewLink("XpeDccContractLineFk1Link1");
    }

    /**
     * Container's getter for XpeDccContractDocTermFk1Link1.
     * @return XpeDccContractDocTermFk1Link1
     */
    public ViewLinkImpl getXpeDccContractDocTermFk1Link1() {
        return (ViewLinkImpl) findViewLink("XpeDccContractDocTermFk1Link1");
    }

    /**
     * Container's getter for XpeDccContractPricingFk1Link1.
     * @return XpeDccContractPricingFk1Link1
     */
    public ViewLinkImpl getXpeDccContractPricingFk1Link1() {
        return (ViewLinkImpl) findViewLink("XpeDccContractPricingFk1Link1");
    }

    /**
     * Container's getter for XpeDccContractCarrierFk1Link1.
     * @return XpeDccContractCarrierFk1Link1
     */
    public ViewLinkImpl getXpeDccContractCarrierFk1Link1() {
        return (ViewLinkImpl) findViewLink("XpeDccContractCarrierFk1Link1");
    }


    /**
     * Container's getter for XpeDccContractNotesFk1Link1.
     * @return XpeDccContractNotesFk1Link1
     */
    public ViewLinkImpl getXpeDccContractNotesFk1Link1() {
        return (ViewLinkImpl) findViewLink("XpeDccContractNotesFk1Link1");
    }


    /**
     * Container's getter for XpeDccContractsAttachmFk2Link1.
     * @return XpeDccContractsAttachmFk2Link1
     */
    public ViewLinkImpl getXpeDccContractsAttachmFk2Link1() {
        return (ViewLinkImpl) findViewLink("XpeDccContractsAttachmFk2Link1");
    }

    public Boolean uploadFiletoDB(String filename, BlobDomain blob) {
        ViewObjectImpl vo = this.getXpeDccContractsAttachmentsView1();
        Row row = vo.createRow();
        row.setAttribute("Name", filename);
        row.setAttribute("UploadFile", blob);
        vo.insertRow(row);
        this.getDBTransaction().commit();
        return true;
    }

    public void copyContractRow() {
        XpeDccContractsViewImpl contractToCopyVO = this.getXpeDccContractsView2();

        XpeDccContractsViewImpl targetContract = this.getXpeDccContractsView1();
        XpeDccContractsViewRowImpl targetRow = (XpeDccContractsViewRowImpl) targetContract.createAndInitRow(null);
        XpeDccContractsViewRowImpl sourceRow = (XpeDccContractsViewRowImpl) contractToCopyVO.getCurrentRow();
        targetRow.setCustId(sourceRow.getCustId());
        targetRow.setXpeContractDesc(sourceRow.getXpeContractDesc());
        targetRow.setCreatedBy(sourceRow.getCreatedBy());
        targetRow.setSetid(sourceRow.getSetid());
        targetContract.insertRow(targetRow);
        copyContractVersion(sourceRow, targetRow, targetRow.getXpeContractId());
    }

    private void copyContractVersion(XpeDccContractsViewRowImpl source, XpeDccContractsViewRowImpl target,
                                     String contractId) {
        RowIterator versionSourceRowSet = source.getXpeDccContractVersionView();
        RowIterator versionTargetRowSet = target.getXpeDccContractVersionView();
        XpeDccContractVersionViewRowImpl targetVersionRow =
            (XpeDccContractVersionViewRowImpl) versionTargetRowSet.createAndInitRow(null);

        XpeDccContractVersionViewRowImpl sourceVersionRow =
            (XpeDccContractVersionViewRowImpl) this.getXpeDccContractVersionView1().getCurrentRow();
        targetVersionRow.setBusinessUnitGl(sourceVersionRow.getBusinessUnitGl());
        targetVersionRow.setCreatedBy(sourceVersionRow.getCreatedBy());
        targetVersionRow.setXpeContractId(contractId);
        targetVersionRow.setCurrencyCd(sourceVersionRow.getCurrencyCd());
        targetVersionRow.setXpeContractStatus("DRA");
        targetVersionRow.setXpeContractVersion("V1");
        targetVersionRow.setXpeAcctgOptionsSet(sourceVersionRow.getXpeAcctgOptionsSet());
        targetVersionRow.setXpeContractTemplate(sourceVersionRow.getXpeContractTemplate());
        targetVersionRow.setXpeEndDate(sourceVersionRow.getXpeEndDate());
        targetVersionRow.setXpeStartDate(sourceVersionRow.getXpeStartDate());
        targetVersionRow.setXpeNewTermMode(sourceVersionRow.getXpeNewTermMode());
        versionTargetRowSet.insertRow(targetVersionRow);
        copyContractLine(sourceVersionRow, targetVersionRow, contractId, "V1");


    }

    private void copyContractLine(XpeDccContractVersionViewRowImpl source, XpeDccContractVersionViewRowImpl target,
                                  String contractId, String versionId) {
        RowIterator lineSourceRowSet = source.getXpeDccContractLineView();
        RowIterator lineTargetRowSet = target.getXpeDccContractLineView();
        while (lineSourceRowSet.hasNext()) {
            XpeDccContractLineViewRowImpl lineSourceRow = (XpeDccContractLineViewRowImpl) lineSourceRowSet.next();
            XpeDccContractLineViewRowImpl lineTargetRow =
                (XpeDccContractLineViewRowImpl) lineTargetRowSet.createAndInitRow(null);
            lineTargetRow.setXpeContractId(contractId);
            lineTargetRow.setXpeContractVersion(versionId);
            lineTargetRow.setXpeContractLine(lineSourceRow.getXpeContractLine());
            lineTargetRow.setXpeFacility(lineSourceRow.getXpeFacility());
            lineTargetRow.setXpePeriodType(lineSourceRow.getXpePeriodType());
            lineTargetRow.setXpeProductId(lineSourceRow.getXpeProductId());
            lineTargetRow.setXpeProductUom(lineSourceRow.getXpeProductUom());
            lineTargetRow.setXpeQtyMax(lineSourceRow.getXpeQtyMax());
            lineTargetRow.setXpeQtyMin(lineSourceRow.getXpeQtyMin());
            lineTargetRow.setXpeSwApprNbr(lineSourceRow.getXpeSwApprNbr());
            lineTargetRow.setCurrencyCd(lineTargetRow.getCurrencyCd());
            lineTargetRowSet.insertRow(lineTargetRow);
            copyPricingTerm(lineSourceRow, lineTargetRow);
        }

    }

    private void copyPricingTerm(XpeDccContractLineViewRowImpl source, XpeDccContractLineViewRowImpl target) {


        RowIterator lineSourceRowSet = source.getXpeDccContractPricingTermView();
        RowIterator lineTargetRowSet = target.getXpeDccContractPricingTermView();
        while (lineSourceRowSet.hasNext()) {

            XpeDccContractPricingTermViewRowImpl sourcePricingTermRow =
                (XpeDccContractPricingTermViewRowImpl) lineSourceRowSet.next();

            XpeDccContractPricingTermViewRowImpl targetPricingTermRow =
                (XpeDccContractPricingTermViewRowImpl) lineTargetRowSet.createAndInitRow(null);
            targetPricingTermRow.setXpeChargeDesc(sourcePricingTermRow.getXpeChargeDesc());
            targetPricingTermRow.setXpeChargeOverMax(sourcePricingTermRow.getXpeChargeOverMax());
            targetPricingTermRow.setXpeChargeOverMin(sourcePricingTermRow.getXpeChargeOverMin());
            targetPricingTermRow.setXpeContractLine(sourcePricingTermRow.getXpeContractLine());
            targetPricingTermRow.setXpeContractVersion("V1");
            targetPricingTermRow.setXpePeriodNbr(sourcePricingTermRow.getXpePeriodNbr());
            targetPricingTermRow.setXpePeriodType(sourcePricingTermRow.getXpePeriodType());
            targetPricingTermRow.setXpePricingTermLine(sourcePricingTermRow.getXpePricingTermLine());
            targetPricingTermRow.setXpePricingTermType(sourcePricingTermRow.getXpePricingTermType());
            targetPricingTermRow.setXpeQtyMax(sourcePricingTermRow.getXpeQtyMax());
            targetPricingTermRow.setXpeRate(sourcePricingTermRow.getXpeQtyMax());
            targetPricingTermRow.setXpeResetType(sourcePricingTermRow.getXpeResetType());
            targetPricingTermRow.setXpeRolloverType(sourcePricingTermRow.getXpeRolloverType());
            lineTargetRowSet.insertRow(targetPricingTermRow);
            copyCarrierDetails(sourcePricingTermRow, targetPricingTermRow);
        }

    }

    private void copyCarrierDetails(XpeDccContractPricingTermViewRowImpl source,
                                    XpeDccContractPricingTermViewRowImpl target) {


        RowIterator carrierDetailsSource = source.getXpeDccContractCarrierView();
        RowIterator carrierDetailsTarget = target.getXpeDccContractCarrierView();
        while (carrierDetailsSource.hasNext()) {
            System.out.println("inside carrier details");
            XpeDccContractCarrierViewRowImpl sourceCarrierDetailRow =
                (XpeDccContractCarrierViewRowImpl) carrierDetailsSource.next();
            XpeDccContractCarrierViewRowImpl targetCarrierDetailRow =
                (XpeDccContractCarrierViewRowImpl) carrierDetailsTarget.createAndInitRow(null);
            targetCarrierDetailRow.setXpeCarrierId(sourceCarrierDetailRow.getXpeCarrierId());
            //   targetCarrierDetailRow.setXpeContractId(sourceCarrierDetailRow.getXpeContractId());
            targetCarrierDetailRow.setXpeContractLine(sourceCarrierDetailRow.getXpeContractLine());
            targetCarrierDetailRow.setXpeContractVersion("V1");
            targetCarrierDetailRow.setXpePricingTermLine(sourceCarrierDetailRow.getXpePricingTermLine());
            targetCarrierDetailRow.setXpeRateOverride(sourceCarrierDetailRow.getXpeRateOverride());
            targetCarrierDetailRow.setXpeSubNbr(sourceCarrierDetailRow.getXpeSubNbr());
            targetCarrierDetailRow.setXpeSurcharge(sourceCarrierDetailRow.getXpeSurcharge());
            targetCarrierDetailRow.setXpeVehicleNbr(sourceCarrierDetailRow.getXpeVehicleNbr());
            targetCarrierDetailRow.setXpeSurcharge(sourceCarrierDetailRow.getXpeSurcharge());
            targetCarrierDetailRow.setXpeVehicleType(sourceCarrierDetailRow.getXpeVehicleType());
            targetCarrierDetailRow.setXpeVehicleType(sourceCarrierDetailRow.getXpeVehicleType());
            carrierDetailsTarget.insertRow(targetCarrierDetailRow);
        }

    }

    /**
     * Container's getter for XpeDccContractVersionView2.
     * @return XpeDccContractVersionView2
     */
    public XpeDccContractVersionViewImpl getXpeDccContractVersionView2() {
        return (XpeDccContractVersionViewImpl) findViewObject("XpeDccContractVersionView2");
    }

    /**
     * Container's getter for XpeDccContractVersionFk1Link1.
     * @return XpeDccContractVersionFk1Link1
     */
    public ViewLinkImpl getXpeDccContractVersionFk1Link1() {
        return (ViewLinkImpl) findViewLink("XpeDccContractVersionFk1Link1");
    }

    /**
     * Container's getter for XpeDccContractLineView2.
     * @return XpeDccContractLineView2
     */
    public XpeDccContractLineViewImpl getXpeDccContractLineView2() {
        return (XpeDccContractLineViewImpl) findViewObject("XpeDccContractLineView2");
    }

    /**
     * Container's getter for XpeDccContractLineFk1Link2.
     * @return XpeDccContractLineFk1Link2
     */
    public ViewLinkImpl getXpeDccContractLineFk1Link2() {
        return (ViewLinkImpl) findViewLink("XpeDccContractLineFk1Link2");
    }

    /**
     * Container's getter for XpeDccContractPricingTermView2.
     * @return XpeDccContractPricingTermView2
     */
    public XpeDccContractPricingTermViewImpl getXpeDccContractPricingTermView2() {
        return (XpeDccContractPricingTermViewImpl) findViewObject("XpeDccContractPricingTermView2");
    }

    /**
     * Container's getter for XpeDccContractPricingFk1Link2.
     * @return XpeDccContractPricingFk1Link2
     */
    public ViewLinkImpl getXpeDccContractPricingFk1Link2() {
        return (ViewLinkImpl) findViewLink("XpeDccContractPricingFk1Link2");
    }

    /**
     * Container's getter for XpeDccContractCarrierView2.
     * @return XpeDccContractCarrierView2
     */
    public XpeDccContractCarrierViewImpl getXpeDccContractCarrierView2() {
        return (XpeDccContractCarrierViewImpl) findViewObject("XpeDccContractCarrierView2");
    }

    /**
     * Container's getter for XpeDccContractCarrierFk1Link2.
     * @return XpeDccContractCarrierFk1Link2
     */
    public ViewLinkImpl getXpeDccContractCarrierFk1Link2() {
        return (ViewLinkImpl) findViewLink("XpeDccContractCarrierFk1Link2");
    }

    public void createContractAndVersionRow() {
        XpeDccContractsViewImpl contractView = this.getXpeDccContractsView1();
        XpeDccContractsViewRowImpl contractRow = (XpeDccContractsViewRowImpl) contractView.createAndInitRow(null);
        contractView.insertRow(contractRow);
        XpeDccContractVersionViewImpl versionVO = this.getXpeDccContractVersionView2();

        XpeDccContractVersionViewRowImpl versionRow =
            (XpeDccContractVersionViewRowImpl) versionVO.createAndInitRow(null);
        versionRow.setXpeContractVersion("V1");
        versionVO.insertRow(versionRow);
    }

    /**
     * Container's getter for XpeDccDicMetalIndexes1.
     * @return XpeDccDicMetalIndexes1
     */
    public ViewObjectImpl getXpeDccDicMetalIndexes1() {
        return (ViewObjectImpl) findViewObject("XpeDccDicMetalIndexes1");
    }

    /**
     * Container's getter for XpeDccIndexType1.
     * @return XpeDccIndexType1
     */
    public ViewObjectImpl getXpeDccIndexType1() {
        return (ViewObjectImpl) findViewObject("XpeDccIndexType1");
    }

    /**
     * Container's getter for XpeDccNewContractSetupROVO1.
     * @return XpeDccNewContractSetupROVO1
     */
    public XpeDccNewContractSetupROVOImpl getXpeDccNewContractSetupROVO() {
        return (XpeDccNewContractSetupROVOImpl) findViewObject("XpeDccNewContractSetupROVO");
    }

    /**
     * Container's getter for XpeDccContractsView3.
     * @return XpeDccContractsView3
     */
    public XpeDccNewContractsEOVOImpl getXpeDccNewContractsEOVO() {
        return (XpeDccNewContractsEOVOImpl) findViewObject("XpeDccNewContractsEOVO");
    }

    /**
     * Container's getter for XpeDccContractVersionView3.
     * @return XpeDccContractVersionView3
     */
    public XpeDccContractVersionViewImpl getXpeDccNewContractVersionView() {
        return (XpeDccContractVersionViewImpl) findViewObject("XpeDccNewContractVersionView");
    }

    /**
     * Container's getter for XpeDccContractVersionFk1Link3.
     * @return XpeDccContractVersionFk1Link3
     */
    public ViewLinkImpl getXpeDccContractVersionFkVL() {
        return (ViewLinkImpl) findViewLink("XpeDccContractVersionFkVL");
    }

    /**
     * Container's getter for XpeDccContractLineView3.
     * @return XpeDccContractLineView3
     */
    public XpeDccContractLineViewImpl getXpeDccNewContractLineView() {
        return (XpeDccContractLineViewImpl) findViewObject("XpeDccNewContractLineView");
    }

    /**
     * Container's getter for XpeDccContractLineFk1Link3.
     * @return XpeDccContractLineFk1Link3
     */
    public ViewLinkImpl getXpeDccContractLineFk1Link3() {
        return (ViewLinkImpl) findViewLink("XpeDccContractLineFk1Link3");
    }

    /**
     * Container's getter for XpeDccContractPricingTermView3.
     * @return XpeDccContractPricingTermView3
     */
    public XpeDccContractPricingTermViewImpl getXpeDccNewContractPricingTermView() {
        return (XpeDccContractPricingTermViewImpl) findViewObject("XpeDccNewContractPricingTermView");
    }

    /**
     * Container's getter for XpeDccContractPricingFk1Link3.
     * @return XpeDccContractPricingFk1Link3
     */
    public ViewLinkImpl getXpeDccContractPricingFk1Link3() {
        return (ViewLinkImpl) findViewLink("XpeDccContractPricingFk1Link3");
    }

    /**
     * Container's getter for XpeDccContractCarrierView3.
     * @return XpeDccContractCarrierView3
     */
    public XpeDccContractCarrierViewImpl getXpeDccNewContractCarrierView() {
        return (XpeDccContractCarrierViewImpl) findViewObject("XpeDccNewContractCarrierView");
    }

    /**
     * Container's getter for XpeDccContractCarrierFk1Link3.
     * @return XpeDccContractCarrierFk1Link3
     */
    public ViewLinkImpl getXpeDccContractCarrierFk1Link3() {
        return (ViewLinkImpl) findViewLink("XpeDccContractCarrierFk1Link3");
    }


    /**
     * Container's getter for XpeDccTermMasterEOVO1.
     * @return XpeDccTermMasterEOVO1
     */
    public ViewObjectImpl getXpeDccTermMasterEOVO() {
        return (ViewObjectImpl) findViewObject("XpeDccTermMasterEOVO");
    }

    /**
     * Container's getter for XpeDccTermsEOVO1.
     * @return XpeDccTermsEOVO1
     */
    public ViewObjectImpl getXpeDccTermsEOVO() {
        return (ViewObjectImpl) findViewObject("XpeDccTermsEOVO");
    }

    /**
     * Container's getter for XpeDccTermsFKVL1.
     * @return XpeDccTermsFKVL1
     */
    public ViewLinkImpl getXpeDccTermsFKVL1() {
        return (ViewLinkImpl) findViewLink("XpeDccTermsFKVL1");
    }

    /**
     * Container's getter for XpeDccContractNotesView2.
     * @return XpeDccContractNotesView2
     */
    public XpeDccContractNotesViewImpl getXpeDccNewContractNotesView() {
        return (XpeDccContractNotesViewImpl) findViewObject("XpeDccNewContractNotesView");
    }

    /**
     * Container's getter for XpeDccContractNotesFk1Link2.
     * @return XpeDccContractNotesFk1Link2
     */
    public ViewLinkImpl getXpeDccContractNotesFk1Link2() {
        return (ViewLinkImpl) findViewLink("XpeDccContractNotesFk1Link2");
    }

    /**
     * Container's getter for XpeDccTermMasterEOVO1.
     * @return XpeDccTermMasterEOVO1
     */
    public ViewObjectImpl getXpeDccTermMasterNewRowCreationEOVO() {
        return (ViewObjectImpl) findViewObject("XpeDccTermMasterNewRowCreationEOVO");
    }
    
    public void fetchClauseForMasterTerm() {
        XpeDccContractVersionViewRowImpl xpeDccContractVersionViewRow =
            (XpeDccContractVersionViewRowImpl) this.getXpeDccNewContractVersionView().getCurrentRow();
        removeTermsContract();
        if (null != xpeDccContractVersionViewRow) {
            XpeDccTermsContractEOVOImpl xpeDccTermsContractEOVO = getXpeDccTermsContractEOVO();
            XpeDccTermsForMasterTermROVOImpl xpeDccTermsForMasterTermROVO = this.getXpeDccTermsForMasterTermROVO();
            xpeDccTermsForMasterTermROVO.executeEmptyRowSet();
            xpeDccTermsForMasterTermROVO.setbind_Term(xpeDccContractVersionViewRow.getXpeTermId());
            xpeDccTermsForMasterTermROVO.executeQuery();
            RowSetIterator rowSetIterator = xpeDccTermsForMasterTermROVO.createRowSetIterator(null);
            while (rowSetIterator.hasNext()) {
                XpeDccTermsForMasterTermROVORowImpl xpeDccTermsForMasterTermROVORow =
                    (XpeDccTermsForMasterTermROVORowImpl) rowSetIterator.next();
                //get handle to the last row
                 Row lastRow = xpeDccTermsContractEOVO.last();
                 //obtain the index of the last row
                int lastRowIndex = xpeDccTermsContractEOVO.getRangeIndexOf(lastRow);
                XpeDccTermsContractEOVORowImpl xpeDccTermsContractEOVORow =
                    (XpeDccTermsContractEOVORowImpl) xpeDccTermsContractEOVO.createRow();
                //initialize the row
                xpeDccTermsContractEOVORow.setNewRowState(Row.STATUS_INITIALIZED);
                if (null != xpeDccTermsContractEOVORow) {
                    xpeDccTermsContractEOVORow.setXpeDccTerm(xpeDccTermsForMasterTermROVORow.getXpeDccTerm());
                    xpeDccTermsContractEOVORow.setXpeDccClause(xpeDccTermsForMasterTermROVORow.getXpeDccClause());
                    xpeDccTermsContractEOVORow.setXpeDccSeq(xpeDccTermsForMasterTermROVORow.getXpeDccSeq());
                    xpeDccTermsContractEOVORow.setXpeDccTermTemplate(xpeDccTermsForMasterTermROVORow.getXpeDccTermTemplate());
                    xpeDccTermsContractEOVO.insertRowAtRangeIndex(lastRowIndex+1,xpeDccTermsContractEOVORow);
                }
            }
            Row firstRow = xpeDccTermsContractEOVO.first();
            if(null!=firstRow)
                xpeDccTermsContractEOVO.setCurrentRow(firstRow);
            rowSetIterator.closeRowSetIterator();
        }
    }
    
    private void removeTermsContract() {
        RowSetIterator termsContractRowIterator = getXpeDccTermsContractEOVO().createRowSetIterator(null);
        while (termsContractRowIterator.hasNext()) {
            XpeDccTermsContractEOVORowImpl xpeDccTermsContractEOVORow =
                (XpeDccTermsContractEOVORowImpl) termsContractRowIterator.next();
            xpeDccTermsContractEOVORow.remove();
        }
        termsContractRowIterator.closeRowSetIterator();
    }
    
    public void createTermContractRow(String termId){
        XpeDccTermsContractEOVORowImpl xpeDccTermsContractEOVORow =
            (XpeDccTermsContractEOVORowImpl) getXpeDccTermsContractEOVO().createRow();
        if (null != xpeDccTermsContractEOVORow) {
            xpeDccTermsContractEOVORow.setXpeDccTerm(termId);
            getXpeDccTermsContractEOVO().insertRow(xpeDccTermsContractEOVORow);
        }
    }

    public boolean newContractCreation(byte[] bytes, String contractId,String contractVersion, String submissionType) {
        try {

            XpeDccNewContractSetupROVORowImpl newContractSetupRow =
                (XpeDccNewContractSetupROVORowImpl) this.getXpeDccNewContractSetupROVO().getCurrentRow();
            if (null != newContractSetupRow && "EXT".equals(newContractSetupRow.getCustomer_Type())) {
                XpeDmsCustomerEOVORowImpl dmsCustomerRow =
                    (XpeDmsCustomerEOVORowImpl) this.getXpeDmsCustomerEOVO().getCurrentRow();
                if (null != dmsCustomerRow)
                    dmsCustomerRow.remove();
            }
            //creating approval work flow
            createApprovalEventAction(contractId,contractVersion,submissionType);
            //commiting transaction
            this.getDBTransaction().commit();
            if (null != submissionType && "IWF".equals(submissionType)) {
                //pushing email notifications for approvals
                pushEmailForApproval(bytes, contractId, contractVersion);
                //commiting transaction after pushing email notification
                this.getDBTransaction().commit();
            }
            return true;
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
            return false;
        }
    }
    
    private void createApprovalEventAction(String contractId, String contractVersion, String submissionType) {

        try {
            Map<String, String> approvalEmails = new HashMap<String, String>();

            Key key = new Key(new Object[] { contractId, contractVersion });
            Row[] rows = getXpeDccNewContractVersionView().findByKey(key, 1);
            if (null != rows && rows.length > 0) {
                XpeDccContractVersionViewRowImpl contractVersionViewRow = (XpeDccContractVersionViewRowImpl) rows[0];
                XpeDccContractLineViewRowImpl xpeDccContractLineViewRow =
                    (XpeDccContractLineViewRowImpl) contractVersionViewRow.getXpeDccContractLineView().first();
                XpeDccNewContractSetupROVORowImpl newContractSetupRow =
                    (XpeDccNewContractSetupROVORowImpl) this.getXpeDccNewContractSetupROVO().getCurrentRow();

                XpeDccCfgMswFacilityEOVOImpl xpeDccCfgMswFacilityEOVO = this.getXpeDccCfgMswFacilityEOVO1();
                XpeDccCfgMetalsFacilityEOVOImpl xpeDccCfgMetalsFacilityEOVO = this.getXpeDccCfgMetalsFacilityEOVO1();
                XpeDccCfgCmtmntFacilityEOVOImpl xpeDccCfgCmtmntFacilityEOVO = this.getXpeDccCfgCmtmntFacilityEOVO1();

                String wasteType = contractVersionViewRow.getXpeWasteType();
                String contractSubType = contractVersionViewRow.getXpeContractSubType();
                String agreementType = contractVersionViewRow.getXpeAgreementType();

                if (null != wasteType && "MTL".equals(wasteType)) {
                    xpeDccCfgMetalsFacilityEOVO.executeEmptyRowSet();
                    xpeDccCfgMetalsFacilityEOVO.setApplyViewCriteriaName("findByFacilityId");
                    xpeDccCfgMetalsFacilityEOVO.setbind_FacilityId(xpeDccContractLineViewRow.getXpeFacility());
                    xpeDccCfgMetalsFacilityEOVO.executeQuery();
                    XpeDccCfgMetalsFacilityEOVORowImpl xpeDccCfgMetalsFacilityEOVORow =
                        (XpeDccCfgMetalsFacilityEOVORowImpl) xpeDccCfgMetalsFacilityEOVO.first();
                    if (null != xpeDccCfgMetalsFacilityEOVORow) {
                        approvalEmails.put(NEUCloudBillingConstants.CUSTOMER_CARE, xpeDccCfgMetalsFacilityEOVORow.getCustomerCareReview());
                        approvalEmails.put(NEUCloudBillingConstants.LEGAL, xpeDccCfgMetalsFacilityEOVORow.getLegalReview());
                        approvalEmails.put(NEUCloudBillingConstants.FINANCIAL, xpeDccCfgMetalsFacilityEOVORow.getFinancialReview());
                        approvalEmails.put(NEUCloudBillingConstants.SVP, xpeDccCfgMetalsFacilityEOVORow.getSvpReview());
                    }
                }
                if (null != wasteType && null != contractSubType) {
                    if ("MSW".equals(wasteType) &&
                        ("SPT".equals(contractSubType) ||
                         ("PMM".equals(contractSubType) && null != agreementType && "PNC".equals(agreementType)))) {
                        xpeDccCfgMswFacilityEOVO.executeEmptyRowSet();
                        xpeDccCfgMswFacilityEOVO.setApplyViewCriteriaName("findByFacilityId");
                        xpeDccCfgMswFacilityEOVO.setbind_FacilityId(xpeDccContractLineViewRow.getXpeFacility());
                        xpeDccCfgMswFacilityEOVO.executeQuery();
                        XpeDccCfgMswFacilityEOVORowImpl xpeDccCfgMswFacilityEOVORow =
                            (XpeDccCfgMswFacilityEOVORowImpl) xpeDccCfgMswFacilityEOVO.first();
                        if (null != xpeDccCfgMswFacilityEOVORow) {
                            approvalEmails.put(NEUCloudBillingConstants.CUSTOMER_CARE, xpeDccCfgMswFacilityEOVORow.getCustomerCareReview());
                            //If Terms and Conditions modified then send email to Legal Reviewer
                            if (null != newContractSetupRow && null!= newContractSetupRow.getTerms_Modifier_Check() && "Y".equals(newContractSetupRow.getTerms_Modifier_Check())){
                                approvalEmails.put(NEUCloudBillingConstants.LEGAL, xpeDccCfgMswFacilityEOVORow.getLegalReview());
                            }
                            approvalEmails.put(NEUCloudBillingConstants.GENERAL_MANAGER, xpeDccCfgMswFacilityEOVORow.getGeneralManagerReview());
                        }
                    } else if ("MSW".equals(wasteType) &&
                               ("FLY".equals(contractSubType) ||
                                ("PMM".equals(contractSubType) && null != agreementType &&
                                 "PC".equals(agreementType)))) {
                        xpeDccCfgCmtmntFacilityEOVO.executeEmptyRowSet();
                        xpeDccCfgCmtmntFacilityEOVO.setApplyViewCriteriaName("findByFacilityId");
                        xpeDccCfgCmtmntFacilityEOVO.setbind_FacilityId(xpeDccContractLineViewRow.getXpeFacility());
                        xpeDccCfgCmtmntFacilityEOVO.executeQuery();
                        XpeDccCfgCmtmntFacilityEOVORowImpl xpeDccCfgCmtmntFacilityEOVORow =
                            (XpeDccCfgCmtmntFacilityEOVORowImpl) xpeDccCfgCmtmntFacilityEOVO.first();
                        if (null != xpeDccCfgCmtmntFacilityEOVORow && null != newContractSetupRow.getApproval_Level()) {
                            if ("EVP".equals(newContractSetupRow.getApproval_Level())) {
                                approvalEmails.put(NEUCloudBillingConstants.CUSTOMER_CARE, xpeDccCfgCmtmntFacilityEOVORow.getCustomerCareReview());
                                approvalEmails.put(NEUCloudBillingConstants.LEGAL, xpeDccCfgCmtmntFacilityEOVORow.getLegalReview());
                                approvalEmails.put(NEUCloudBillingConstants.FINANCIAL, xpeDccCfgCmtmntFacilityEOVORow.getFinancialReview());
                                approvalEmails.put(NEUCloudBillingConstants.GENERAL_MANAGER, xpeDccCfgCmtmntFacilityEOVORow.getGeneralManagerReview());
                                approvalEmails.put(NEUCloudBillingConstants.EVP, xpeDccCfgCmtmntFacilityEOVORow.getSustSolReview());
                            } else if ("CEO".equals(newContractSetupRow.getApproval_Level())) {
                                approvalEmails.put(NEUCloudBillingConstants.CUSTOMER_CARE, xpeDccCfgCmtmntFacilityEOVORow.getCustomerCareReview());
                                approvalEmails.put(NEUCloudBillingConstants.LEGAL, xpeDccCfgCmtmntFacilityEOVORow.getLegalReview());
                                approvalEmails.put(NEUCloudBillingConstants.FINANCIAL, xpeDccCfgCmtmntFacilityEOVORow.getFinancialReview());
                                approvalEmails.put(NEUCloudBillingConstants.GENERAL_MANAGER, xpeDccCfgCmtmntFacilityEOVORow.getGeneralManagerReview());
                                approvalEmails.put(NEUCloudBillingConstants.EVP, xpeDccCfgCmtmntFacilityEOVORow.getSustSolReview());
                                approvalEmails.put(NEUCloudBillingConstants.CFO, xpeDccCfgCmtmntFacilityEOVORow.getCfoReview());
                                approvalEmails.put(NEUCloudBillingConstants.CEO, xpeDccCfgCmtmntFacilityEOVORow.getCeoReview());
                            } else if ("NA".equals(newContractSetupRow.getApproval_Level())) {
                                approvalEmails.put(NEUCloudBillingConstants.CUSTOMER_CARE, xpeDccCfgCmtmntFacilityEOVORow.getCustomerCareReview());
                                approvalEmails.put(NEUCloudBillingConstants.LEGAL, xpeDccCfgCmtmntFacilityEOVORow.getLegalReview());
                                approvalEmails.put(NEUCloudBillingConstants.FINANCIAL, xpeDccCfgCmtmntFacilityEOVORow.getFinancialReview());
                                approvalEmails.put(NEUCloudBillingConstants.GENERAL_MANAGER, xpeDccCfgCmtmntFacilityEOVORow.getGeneralManagerReview());
                            }
                        }
                    }
                }

                //setting contract version status
                contractVersionViewRow.setXpeContractStatus(submissionType);
                
                //creating Internal Approval Work Flow Event
                XpeDccWfEventEOVORowImpl approvalWFEventRow =
                    (XpeDccWfEventEOVORowImpl)contractVersionViewRow.getXpeDccWfEventEOVO().createRow();
                approvalWFEventRow.setXpeEventStatus(submissionType);
                approvalWFEventRow.setXpeEventType("I");
                contractVersionViewRow.getXpeDccWfEventEOVO().insertRow(approvalWFEventRow);

                if (null != approvalWFEventRow && null != approvalWFEventRow.getXpeEventNumber()) {
                    //creating Approval Work Flow Action
                    for (Map.Entry<String, String> approvalEmail : approvalEmails.entrySet()) {

                        XpeDccWfActionEOVORowImpl xpeDccWfActionEOVORow =
                            (XpeDccWfActionEOVORowImpl) approvalWFEventRow.getXpeDccWfActionEOVO().createRow();
                        xpeDccWfActionEOVORow.setXpeContractId(approvalWFEventRow.getXpeContractId());
                        xpeDccWfActionEOVORow.setXpeContractVersion(approvalWFEventRow.getXpeContractVersion());
                        xpeDccWfActionEOVORow.setXpeUuid(UUID.randomUUID().toString());
                        xpeDccWfActionEOVORow.setXpeApproverEmail(approvalEmail.getValue());
                        xpeDccWfActionEOVORow.setXpeApproverLevel(approvalEmail.getKey());
                        xpeDccWfActionEOVORow.setXpeActionStatus("W");
                        approvalWFEventRow.getXpeDccWfActionEOVO().insertRow(xpeDccWfActionEOVORow);
                    }
                }
            }
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
    }
    
    private void pushEmailForApproval(XpeDccWfActionEOVORowImpl xpeDccWfActionEOVORow, byte[] bytes,String userType) {

        if (EmailUtils.sendEmail(xpeDccWfActionEOVORow.getXpeApproverEmail(),
                                 buildEmailBody(xpeDccWfActionEOVORow,userType),
                                 bytes)) {
            xpeDccWfActionEOVORow.setXpeActionStatus("P");//P - Pending
        }else
            xpeDccWfActionEOVORow.setXpeActionStatus("W");//W - Waiting
    }

    public String pushEmailForApproval(byte[] bytes, String contractId, String contractVersion) {
        String emailStatus = null;
        try {
            XpeDccWfEventEOVOImpl approvalWFEvent = this.getXpeDccWfEventEOVO();
            approvalWFEvent.executeEmptyRowSet();
            approvalWFEvent.setApplyViewCriteriaName("XpeDccWfEventContractVersionEOVOCriteria");
            approvalWFEvent.setbind_contractId(contractId);
            approvalWFEvent.setbind_contractVersion(contractVersion);
            approvalWFEvent.executeQuery();
            XpeDccWfEventEOVORowImpl approvalWFEventRow = (XpeDccWfEventEOVORowImpl) approvalWFEvent.first();
            if (null != approvalWFEventRow) {
                XpeDccWfActionEOVORowImpl xpeDccWfActionEOVORow =
                    (XpeDccWfActionEOVORowImpl) approvalWFEventRow.getXpeDccWfActionEOVO().first();
                if (EmailUtils.sendEmail(xpeDccWfActionEOVORow.getXpeApproverEmail(),
                                         buildEmailBody(xpeDccWfActionEOVORow, "I"),
                                         bytes)) {
                    if (null != approvalWFEventRow.getXpeEventStatus() &&
                        "DRA".equals(approvalWFEventRow.getXpeEventStatus()))
                        approvalWFEventRow.setXpeEventStatus("IWF");
                    xpeDccWfActionEOVORow.setXpeActionStatus("P");
                    emailStatus = "SUCCESS";
                }
            }
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
        return emailStatus;
    }
    
    private String buildEmailBody(XpeDccWfActionEOVORowImpl xpeDccWfActionEOVORow, String userType){
        String customerName=null,contractStartDate=null,contractEndDate=null,salesPerson=null,termAgreement=null,valTrans=null,varBudget=null,
            paymentHist=null,paymentMethod=null,estDisposalVol=null,extCustomer=null,justification=null,creditLimit=null;
        XpeDccNewContractsEOVOImpl contractView = this.getXpeDccNewContractsEOVO1();
        contractView.executeEmptyRowSet();
        contractView.setApplyViewCriteriaName("FetchExtContractCriteria");
        contractView.setbind_ContractId(xpeDccWfActionEOVORow.getXpeContractId());
        contractView.executeQuery();
        XpeDccNewContractsEOVORowImpl xpeDccNewContractsEOVORow = (XpeDccNewContractsEOVORowImpl) contractView.first();
        if(null!=xpeDccNewContractsEOVORow){
            XpeDccNewContractCustomerSearchROVOImpl xpeDccNewContractCustomerSearchROVO = this.getXpeDccNewContractCustomerSearchROVO1();
            xpeDccNewContractCustomerSearchROVO.executeEmptyRowSet();
            xpeDccNewContractCustomerSearchROVO.setApplyViewCriteriaName("NewContractCustomerSearch");
            xpeDccNewContractCustomerSearchROVO.setbind_CustomerId(xpeDccNewContractsEOVORow.getCustId());
            xpeDccNewContractCustomerSearchROVO.executeQuery();
            XpeDccNewContractCustomerSearchROVORowImpl xpeDccNewContractCustomerSearchROVORow = (XpeDccNewContractCustomerSearchROVORowImpl)xpeDccNewContractCustomerSearchROVO.first();
            if (null != xpeDccNewContractCustomerSearchROVORow)
                customerName = checkIfNull(xpeDccNewContractCustomerSearchROVORow.getName1());
            else {
                Row customerRow = null;
                Key newCustKey = new Key(new Object[] { xpeDccWfActionEOVORow.getXpeContractId() });
                Row[] newCustRows = this.getXpeDmsCustomerEOVO().findByKey(newCustKey, 1);
                if (null != newCustRows && newCustRows.length > 0)
                    customerRow = newCustRows[0];
                else {
                    XpeDmsCustomerROVOImpl xpeDmsCustomerROVO = this.getXpeDmsCustomerROVO();
                    xpeDmsCustomerROVO.executeEmptyRowSet();
                    xpeDmsCustomerROVO.setApplyViewCriteriaName("XpeDmsCustomerROVOCriteria");
                    xpeDmsCustomerROVO.setbind_CustId(xpeDccNewContractsEOVORow.getCustId());
                    xpeDmsCustomerROVO.executeQuery();
                    customerRow = xpeDmsCustomerROVO.first();
                    if (null != customerRow)
                        customerName = checkIfNull((String) customerRow.getAttribute("CompanyName"));
                }
            }
            
            Key key = new Key(new Object[] { xpeDccWfActionEOVORow.getXpeContractId(), xpeDccWfActionEOVORow.getXpeContractVersion() });
            Row[] rows = xpeDccNewContractsEOVORow.getXpeDccContractVersionView().findByKey(key, 1);
            if (null != rows && rows.length > 0) {
                XpeDccContractVersionViewRowImpl contractVersionViewRow = (XpeDccContractVersionViewRowImpl) rows[0];
                contractStartDate = formatDate(String.valueOf(contractVersionViewRow.getXpeStartDate()));
                contractEndDate = formatDate(String.valueOf(contractVersionViewRow.getXpeEndDate()));
                salesPerson = getLookupDescription(contractVersionViewRow.getPsSalesPersonROVO1(),contractVersionViewRow.getSalesPerson(), "Descr");
                termAgreement = contractVersionViewRow.getXpeTermAgreement();
                valTrans = contractVersionViewRow.getXpeValueTransaction();
                varBudget = contractVersionViewRow.getXpeVarianceBudget();
                paymentHist = contractVersionViewRow.getXpePaymentHistory();
                paymentMethod = contractVersionViewRow.getXpePaymentMethod();
                estDisposalVol = contractVersionViewRow.getXpeEstDisposalVol();
                extCustomer = getLookupDescription(contractVersionViewRow.getLookupSharedAppModule_YORNLOV(),contractVersionViewRow.getXpeExistingCustomer(), "XpeLookupDesc");
                justification = contractVersionViewRow.getXpeJustification();
                creditLimit = contractVersionViewRow.getXpeCreditLimit();
            }
        }
            
        StringBuilder html = new StringBuilder();
        html.append("<p>");
        html.append("<b>Customer Name:</b>").append("&nbsp;&nbsp;").append(null != customerName ? customerName :
                                                                           "").append("<br><br>");
        html.append("<b>Contract Start Date:</b>").append("&nbsp;&nbsp;").append(null != contractStartDate ?
                                                                                 contractStartDate :
                                                                                 "").append("<br><br>");
        html.append("<b>Contract End Date:</b>").append("&nbsp;&nbsp;").append(null != contractEndDate ?
                                                                               contractEndDate : "").append("<br><br>");
        html.append("<b>Sales Person:</b>").append("&nbsp;&nbsp;").append(null != salesPerson ? salesPerson :
                                                                          "").append("<br><br>");
        
        String approverLevel = xpeDccWfActionEOVORow.getXpeApproverLevel();
        List<String> gmAndApproverList = new ArrayList<String>(Arrays.asList("GM","SVP","EVP","CFO","CEO"));
        if(gmAndApproverList.contains(approverLevel)){
        html.append("<u><b>Contract Detail</b></u>").append("<br><br>");
        html.append("<b>Term of Agreement:</b>").append("&nbsp;&nbsp;").append(null != termAgreement ? termAgreement :
                                                                           "").append("<br><br>");
        html.append("<b>Variance to Budget:</b>").append("&nbsp;&nbsp;").append(null != varBudget ?
                                                                                 varBudget :
                                                                                 "").append("<br><br>");
        html.append("<b>Estimated Disposal Volume:</b>").append("&nbsp;&nbsp;").append(null != estDisposalVol ?
                                                                               estDisposalVol : "").append("<br><br>");
        html.append("<b>Value of Transaction:</b>").append("&nbsp;&nbsp;").append(null != valTrans ? valTrans :
                                                                          "").append("<br><br>");
        html.append("<b>Justification/Circumstances:</b>").append("&nbsp;&nbsp;").append(null != justification ? justification :
                                                                           "").append("<br><br>");
        html.append("<u><b>Credit Analysis</b></u>").append("<br><br>");
        html.append("<b>Existing Customer:</b>").append("&nbsp;&nbsp;").append(null != extCustomer ?
                                                                                 extCustomer :
                                                                                 "").append("<br><br>");
        html.append("<b>Payment Method:</b>").append("&nbsp;&nbsp;").append(null != paymentMethod ?
                                                                               paymentMethod : "").append("<br><br>");
        html.append("<b>Payment History:</b>").append("&nbsp;&nbsp;").append(null != paymentHist ? paymentHist :
                                                                          "").append("<br><br>");
        html.append("<b>Credit Limit:</b>").append("&nbsp;&nbsp;").append(null != creditLimit ? creditLimit :
                                                                          "").append("<br><br>");
        }
        html.append("<a href=\"");
        //html.append("http://localhost:7101/neuCloudBilling1010/faces/adf.task-flow?adf.tfId=approvalWorkFlow&adf.tfDoc=/WEB-INF/approvalWorkFlow.xml");
        html.append("http://morganfranklinlabs.us:7101/neuCloudBilling1010_34/faces/adf.task-flow?adf.tfId=approvalWorkFlow&adf.tfDoc=/WEB-INF/approvalWorkFlow.xml");
        html.append("&").append("uuid=").append(xpeDccWfActionEOVORow.getXpeUuid()).append("&").append("action=").append("ACCEPT").append("&").append("user=").append(userType);
        html.append("\"><b>Accept</b></a>");
        html.append("&nbsp;&nbsp;&nbsp;");
        html.append("<a href=\"");
        //html.append("http://localhost:7101/neuCloudBilling1010/faces/adf.task-flow?adf.tfId=approvalWorkFlow&adf.tfDoc=/WEB-INF/approvalWorkFlow.xml");
        html.append("http://morganfranklinlabs.us:7101/neuCloudBilling1010_34/faces/adf.task-flow?adf.tfId=approvalWorkFlow&adf.tfDoc=/WEB-INF/approvalWorkFlow.xml");
        html.append("&").append("uuid=").append(xpeDccWfActionEOVORow.getXpeUuid()).append("&").append("action=").append("REJECT").append("&").append("user=").append(userType);
        html.append("\"><b>Reject</b></a>");
        html.append("</p>");

        return html.toString();
    }
    
    private String formatDate(String dateInString) {
           SimpleDateFormat dateFormat = new SimpleDateFormat(
                   "yyyy-MM-dd hh:mm:ss");
           SimpleDateFormat  formatter = new SimpleDateFormat("MM/dd/yyyy");
        try {
            if (null != dateInString && dateInString.trim().length()>0) {
                Date date = dateFormat.parse(dateInString);
                System.out.println(date);
                return formatter.format(date);
            }
        } catch (ParseException e) {
               e.printStackTrace();
           }
          return "";
       }
    
    public Map routeForApproval(String contractId, String contractVersion) {
        Map pdf = new HashMap();
        try {
            Key contractKey = new Key(new Object[] { contractId });
            Row[] xpeDccExtContractsRows = this.getXpeDccContractsView2().findByKey(contractKey, 1);
            if (null != xpeDccExtContractsRows && xpeDccExtContractsRows.length > 0) {
                XpeDccContractsViewRowImpl xpeDccExtContractsRow =
                    (XpeDccContractsViewRowImpl) xpeDccExtContractsRows[0];
                if (null != xpeDccExtContractsRow) {
                    Key key = new Key(new Object[] { contractId, contractVersion });
                    Row[] rows = xpeDccExtContractsRow.getXpeDccContractVersionView().findByKey(key, 1);
                    if (null != rows && rows.length > 0) {
                        XpeDccContractVersionViewRowImpl contractVersionViewRow =
                            (XpeDccContractVersionViewRowImpl) rows[0];
                        String contractVersionStatus = contractVersionViewRow.getXpeContractStatus();
                        if (null != contractVersionStatus) {
                            if ("DRA".equals(contractVersionStatus)) {
                                pdf.putAll(buildXML(contractId, contractVersion, "N",null));
                                pdf.put("VERSION_STATUS", contractVersionStatus);
                            } else if ("IWF".equals(contractVersionStatus))
                                pdf.put("VERSION_STATUS", "This contract is already in approval workflow.");
                            else if ("APR".equals(contractVersionStatus))
                                pdf.put("VERSION_STATUS", "This contract is already approved.");
                            else if ("REJ".equals(contractVersionStatus))
                                pdf.put("VERSION_STATUS", "This contract is already rejected.");
                        } else
                            pdf.put("VERSION_STATUS", "Unexpected Error. Please contact system administrator.");
                    }
                }
            }
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
        return pdf;
    }
    
    public Map fetchPDFXML(String uuId){
        try {
            this.getXpeDccWfActionROVO().executeEmptyRowSet();
            this.getXpeDccWfActionROVO().setApplyViewCriteriaName("XpeDccWfActionROVOCriteria");
            this.getXpeDccWfActionROVO().setbind_uuId(uuId);
            this.getXpeDccWfActionROVO().executeQuery();
            XpeDccWfActionROVORowImpl xpeDccWfActionROVORow =
                (XpeDccWfActionROVORowImpl) this.getXpeDccWfActionROVO().first();
            if (null != xpeDccWfActionROVORow)
                return this.buildXML(xpeDccWfActionROVORow.getXpeContractId(),
                                     xpeDccWfActionROVORow.getXpeContractVersion(),"N",uuId);
            else
                return new HashMap();
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
        return new HashMap();
    }
    
    
    public void updateContractApprovalStatus(String uuId, String action, byte[] bytes, String userType){
        try {
            this.getXpeDccWfActionROVO().executeEmptyRowSet();
            this.getXpeDccWfActionROVO().setApplyViewCriteriaName("XpeDccWfActionROVOCriteria");
            this.getXpeDccWfActionROVO().setbind_uuId(uuId);
            this.getXpeDccWfActionROVO().executeQuery();
            XpeDccWfActionROVORowImpl xpeDccWfActionROVORow =
                (XpeDccWfActionROVORowImpl) this.getXpeDccWfActionROVO().first();
            if (null != xpeDccWfActionROVORow) {
                this.getXpeDccWfEventEOVO().executeEmptyRowSet();
                this.getXpeDccWfEventEOVO().setApplyViewCriteriaName("XpeDccWfEventEOVOCriteria");
                this.getXpeDccWfEventEOVO().setbind_eventNumber(xpeDccWfActionROVORow.getXpeEventNumber());
                this.getXpeDccWfEventEOVO().executeQuery();
                XpeDccWfEventEOVORowImpl approvalWFEventRow =
                    (XpeDccWfEventEOVORowImpl) this.getXpeDccWfEventEOVO().first();
                if (null != approvalWFEventRow) {
                    RowIterator rowIterator = approvalWFEventRow.getXpeDccWfActionEOVO();
                    while (rowIterator.hasNext()) {
                        XpeDccWfActionEOVORowImpl xpeDccWfActionEOVORow =
                            (XpeDccWfActionEOVORowImpl) rowIterator.next();
                        if (null != action) {
                            if (xpeDccWfActionEOVORow.getXpeApproverSequence().equals(xpeDccWfActionROVORow.getXpeApproverSequence())) {
                                if ("ACCEPT".equals(action))
                                    xpeDccWfActionEOVORow.setXpeActionStatus("A");
                                else if ("REJECT".equals(action)) {
                                    xpeDccWfActionEOVORow.setXpeActionStatus("R");
                                    approvalWFEventRow.setXpeEventStatus("REJ");
                                    updateContractVersionStatus(approvalWFEventRow.getXpeContractId(),approvalWFEventRow.getXpeContractVersion(), "REJ");
                                }
                            } else if ("ACCEPT".equals(action) &&
                                       !"A".equals(xpeDccWfActionEOVORow.getXpeActionStatus())) {
                                this.pushEmailForApproval(xpeDccWfActionEOVORow, bytes,"I");//I - Internal User
                                break;
                            } else if ("REJECT".equals(action) &&
                                       !"A".equals(xpeDccWfActionEOVORow.getXpeActionStatus()))
                                xpeDccWfActionEOVORow.setXpeActionStatus("I");//I - Ignore
                        }
                    }
                    //commiting transaction
                    this.getDBTransaction().commit();
                    if (null != action && "ACCEPT".equals(action)) {
                        this.getXpeDccWfActionROVO().executeEmptyRowSet();
                        this.getXpeDccWfActionROVO().setApplyViewCriteriaName("XpeDccWfActionApprovalCheckCriteria");
                        this.getXpeDccWfActionROVO().setbind_EventNumber(approvalWFEventRow.getXpeEventNumber());
                        this.getXpeDccWfActionROVO().setbind_ActionStatus("A");
                        this.getXpeDccWfActionROVO().executeQuery();
                        Long rowCount = this.getXpeDccWfActionROVO().getEstimatedRowCount();
                        if (rowCount.intValue() == 0) {
                            approvalWFEventRow.setXpeEventStatus("APR");
                            pushEmailForExternalUser(userType,approvalWFEventRow.getXpeContractId(),approvalWFEventRow.getXpeContractVersion(),bytes);
                            //commiting transaction
                            this.getDBTransaction().commit();
                        }
                    }
                }
            }
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
    }
    
    private void updateContractVersionStatus(String contractId,String contractVersion, String status){
        XpeDccNewContractsEOVOImpl contractView = this.getXpeDccNewContractsEOVO();
        contractView.executeEmptyRowSet();
        contractView.setApplyViewCriteriaName("FetchExtContractCriteria");
        contractView.setbind_ContractId(contractId);
        contractView.executeQuery();
        XpeDccNewContractsEOVORowImpl xpeDccNewContractsEOVORow = (XpeDccNewContractsEOVORowImpl) contractView.first();
        if(null!=xpeDccNewContractsEOVORow){
            RowIterator contractVersionRowIterator =  xpeDccNewContractsEOVORow.getXpeDccContractVersionView();
            Key key =
                new Key(new Object[] {contractId,contractVersion});
            Row[] rows = contractVersionRowIterator.findByKey(key, 1);
            if (null != rows && rows.length > 0) {
                XpeDccContractVersionViewRowImpl contractVersionViewRow = (XpeDccContractVersionViewRowImpl) rows[0];
                contractVersionViewRow.setXpeContractStatus(status);
            }
        }
    }
    
    private void pushEmailForExternalUser(String userType,String contractId,String contractVersion, byte[] bytes){
        if (null != userType) {
            if ("I".equals(userType)) { //I - Internal User(Last Approver)
                //creating External Approval Work Flow Event
                XpeDccNewContractsEOVOImpl contractView = this.getXpeDccNewContractsEOVO();
                contractView.executeEmptyRowSet();
                contractView.setApplyViewCriteriaName("FetchExtContractCriteria");
                contractView.setbind_ContractId(contractId);
                contractView.executeQuery();
                XpeDccNewContractsEOVORowImpl xpeDccNewContractsEOVORow = (XpeDccNewContractsEOVORowImpl) contractView.first();
                if (null != xpeDccNewContractsEOVORow) {
                    RowIterator contractVersionRowIterator = xpeDccNewContractsEOVORow.getXpeDccContractVersionView();
                    Key key = new Key(new Object[] { contractId, contractVersion });
                    Row[] rows = contractVersionRowIterator.findByKey(key, 1);
                    if (null != rows && rows.length > 0) {
                        XpeDccContractVersionViewRowImpl contractVersionViewRow =
                            (XpeDccContractVersionViewRowImpl) rows[0];
                        XpeDccWfEventEOVORowImpl approvalWFEventExternalRow =
                            (XpeDccWfEventEOVORowImpl) contractVersionViewRow.getXpeDccWfEventEOVO().createRow();
                        approvalWFEventExternalRow.setXpeEventStatus("IWF");
                        approvalWFEventExternalRow.setXpeEventType("E"); //E - External User
                        contractVersionViewRow.getXpeDccWfEventEOVO().insertRow(approvalWFEventExternalRow);
                        if (null != approvalWFEventExternalRow) {
                            //creating External Approval Work Flow Action
                            XpeDccWfActionEOVORowImpl xpeDccWfActionEOVORow =
                                                              (XpeDccWfActionEOVORowImpl) approvalWFEventExternalRow.getXpeDccWfActionEOVO().createRow();
                            xpeDccWfActionEOVORow.setXpeContractId(approvalWFEventExternalRow.getXpeContractId());
                            xpeDccWfActionEOVORow.setXpeContractVersion(approvalWFEventExternalRow.getXpeContractVersion());
                            xpeDccWfActionEOVORow.setXpeUuid(UUID.randomUUID().toString());
                            //setting customer email Id to push email notification
                            xpeDccWfActionEOVORow.setXpeApproverEmail(xpeDccNewContractsEOVORow.getCustContractApproverEmail());
                            xpeDccWfActionEOVORow.setXpeApproverLevel(NEUCloudBillingConstants.CUSTOMER);
                            xpeDccWfActionEOVORow.setXpeActionStatus("W");//W-Waiting
                            approvalWFEventExternalRow.getXpeDccWfActionEOVO().insertRow(xpeDccWfActionEOVORow);
                            this.pushEmailForApproval(xpeDccWfActionEOVORow, bytes,"E"); //E - External User
                        }
                    }
                }
            } else if ("E".equals(userType)) { //E - External User
                updateContractVersionStatus(contractId,contractVersion, "APR");

                BlobDomain blobDomain = null;
                OutputStream out = null;
                try {
                    out = blobDomain.getBinaryOutputStream();
                    IOUtils.copy(new ByteArrayInputStream(bytes), out);
                    this.uploadFiletoDB("Template.pdf", blobDomain);
                } catch (SQLException sqle) {
                    // TODO: Add catch code
                    sqle.printStackTrace();
                } catch (IOException ioe) {
                    // TODO: Add catch code
                    ioe.printStackTrace();
                }
            }
        }
    }
    
    
    public Map buildXML(String contractId, String contractVersion, String inContractFlow, String uuId){
        Map pdf = new HashMap();
        try {
            String xmlTag = "<?xml version=\"1.0\" encoding=\"windows-1252\"?>";
            StringBuilder xmlBuilder = new StringBuilder();
            xmlBuilder.append(xmlTag);
            xmlBuilder.append("<CONTRACT_DETAILS>");
            xmlBuilder.append("<CONTRACT_DETAILS_ROW>");
            
            XpeDccNewContractsEOVORowImpl xpeDccNewContractsEOVORow = null;
            if (null != inContractFlow) {
                if ("Y".equals(inContractFlow)) {
                    Key contractKey = new Key(new Object[] { contractId });
                    Row[] xpeDccNewContractsEOVORows = this.getXpeDccNewContractsEOVO().findByKey(contractKey, 1);
                    if (null != xpeDccNewContractsEOVORows && xpeDccNewContractsEOVORows.length > 0)
                        xpeDccNewContractsEOVORow = (XpeDccNewContractsEOVORowImpl) xpeDccNewContractsEOVORows[0];
                } else if ("N".equals(inContractFlow)) {
                    XpeDccNewContractsEOVOImpl contractView = this.getXpeDccNewContractsEOVO();
                    contractView.executeEmptyRowSet();
                    contractView.setApplyViewCriteriaName("FetchExtContractCriteria");
                    contractView.setbind_ContractId(contractId);
                    contractView.executeQuery();
                    if(null!=contractView.first())
                        xpeDccNewContractsEOVORow = (XpeDccNewContractsEOVORowImpl)contractView.first();
                }
            }
            
            if (null != xpeDccNewContractsEOVORow) {
                String customerName = null;
                XpeDccNewContractCustomerSearchROVOImpl xpeDccNewContractCustomerSearchROVO = this.getXpeDccNewContractCustomerSearchROVO1();
                xpeDccNewContractCustomerSearchROVO.executeEmptyRowSet();
                xpeDccNewContractCustomerSearchROVO.setApplyViewCriteriaName("NewContractCustomerSearch");
                xpeDccNewContractCustomerSearchROVO.setbind_CustomerId(xpeDccNewContractsEOVORow.getCustId());
                xpeDccNewContractCustomerSearchROVO.executeQuery();
                XpeDccNewContractCustomerSearchROVORowImpl xpeDccNewContractCustomerSearchROVORow = (XpeDccNewContractCustomerSearchROVORowImpl)xpeDccNewContractCustomerSearchROVO.first();
                if(null!=xpeDccNewContractCustomerSearchROVORow){
                    xmlBuilder.append("<CUSTOMER_ID>").append(checkIfNull(xpeDccNewContractCustomerSearchROVORow.getCustId())).append("</CUSTOMER_ID>");
                    customerName = checkIfNull(xpeDccNewContractCustomerSearchROVORow.getName1());
                    xmlBuilder.append("<CUSTOMER_NAME>").append(checkIfNull(xpeDccNewContractCustomerSearchROVORow.getName1())).append("</CUSTOMER_NAME>");
                    //xmlBuilder.append("<CONTACT_NAME>").append(ADFUtils.getValueFrmExpression("#{bindings.ContactName.inputValue}")).append("</CONTACT_NAME>");
                    xmlBuilder.append("<CUSTOMER_ADDRESS>").append(checkIfNull(xpeDccNewContractCustomerSearchROVORow.getAddress1())).append("</CUSTOMER_ADDRESS>");
                    xmlBuilder.append("<CUSTOMER_ADDRESS1>").append(checkIfNull(xpeDccNewContractCustomerSearchROVORow.getAddress2())).append("</CUSTOMER_ADDRESS1>");
                    xmlBuilder.append("<CITY>").append(checkIfNull(xpeDccNewContractCustomerSearchROVORow.getCity())).append("</CITY>");
                    xmlBuilder.append("<STATE>").append(checkIfNull(xpeDccNewContractCustomerSearchROVORow.getState())).append("</STATE>");
                    xmlBuilder.append("<POSTAL_CODE>").append(checkIfNull(xpeDccNewContractCustomerSearchROVORow.getPostal())).append("</POSTAL_CODE>");
                    
                    XpeDccCustContractShortNameROVOImpl xpeDccCustContractShortNameROVO = this.getXpeDccCustContractShortNameROVO();
                    xpeDccCustContractShortNameROVO.setbind_ContractId(xpeDccNewContractsEOVORow.getXpeContractId());
                    xpeDccCustContractShortNameROVO.executeQuery();
                    XpeDccCustContractShortNameROVORowImpl xpeDccCustContractShortNameROVORow = (XpeDccCustContractShortNameROVORowImpl)xpeDccCustContractShortNameROVO.first();
                    if(null!=xpeDccCustContractShortNameROVORow && null!=xpeDccCustContractShortNameROVORow.getXpeDccPcsname()){
                        xmlBuilder.append("<BILLING_ADDRESS1>").append(checkIfNull(xpeDccCustContractShortNameROVORow.getAddress1())).append("</BILLING_ADDRESS1>");
                        xmlBuilder.append("<BILLING_ADDRESS2>").append(checkIfNull(xpeDccCustContractShortNameROVORow.getAddress2())).append("</BILLING_ADDRESS2>");
                        xmlBuilder.append("<BILLING_CITY>").append(checkIfNull(xpeDccCustContractShortNameROVORow.getCity())).append("</BILLING_CITY>");
                        xmlBuilder.append("<BILLING_STATE>").append(checkIfNull(xpeDccCustContractShortNameROVORow.getState())).append("</BILLING_STATE>");
                        xmlBuilder.append("<BILLING_POSTAL_CODE>").append(checkIfNull(xpeDccCustContractShortNameROVORow.getPostal())).append("</BILLING_POSTAL_CODE>");
                    }else{
                        xmlBuilder.append("<BILLING_ADDRESS1>").append(checkIfNull(xpeDccNewContractCustomerSearchROVORow.getAddress1())).append("</BILLING_ADDRESS1>");
                        xmlBuilder.append("<BILLING_ADDRESS2>").append(checkIfNull(xpeDccNewContractCustomerSearchROVORow.getAddress2())).append("</BILLING_ADDRESS2>");
                        xmlBuilder.append("<BILLING_CITY>").append(checkIfNull(xpeDccNewContractCustomerSearchROVORow.getCity())).append("</BILLING_CITY>");
                        xmlBuilder.append("<BILLING_STATE>").append(checkIfNull(xpeDccNewContractCustomerSearchROVORow.getState())).append("</BILLING_STATE>");
                        xmlBuilder.append("<BILLING_POSTAL_CODE>").append(checkIfNull(xpeDccNewContractCustomerSearchROVORow.getPostal())).append("</BILLING_POSTAL_CODE>");   
                    }      
                }else{
                    Row customerRow = null;
                    Key newCustKey = new Key(new Object[] {xpeDccNewContractsEOVORow.getCustId()});
                    Row[] newCustRows = this.getXpeDmsCustomerEOVO().findByKey(newCustKey, 1);
                    if (null != newCustRows && newCustRows.length>0) 
                     customerRow = newCustRows[0];
                    else{
                        XpeDmsCustomerROVOImpl xpeDmsCustomerROVO = this.getXpeDmsCustomerROVO();
                        xpeDmsCustomerROVO.executeEmptyRowSet();
                        xpeDmsCustomerROVO.setApplyViewCriteriaName("XpeDmsCustomerROVOCriteria");
                        xpeDmsCustomerROVO.setbind_CustId(xpeDccNewContractsEOVORow.getCustId());
                        xpeDmsCustomerROVO.executeQuery();
                        customerRow = xpeDmsCustomerROVO.first();
                    }
                        if(null!=customerRow){
                            customerName = checkIfNull((String)customerRow.getAttribute("CompanyName"));
                            xmlBuilder.append("<CUSTOMER_ID>").append("NEW").append("</CUSTOMER_ID>");
                            xmlBuilder.append("<CUSTOMER_NAME>").append(checkIfNull((String)customerRow.getAttribute("CompanyName"))).append("</CUSTOMER_NAME>");
                            xmlBuilder.append("<CUSTOMER_ADDRESS>").append(checkIfNull((String)customerRow.getAttribute("MailingAddress1"))).append("</CUSTOMER_ADDRESS>");
                            xmlBuilder.append("<CUSTOMER_ADDRESS1>").append(checkIfNull((String)customerRow.getAttribute("MailingAddress2"))).append("</CUSTOMER_ADDRESS1>");
                            xmlBuilder.append("<CITY>").append(checkIfNull((String)customerRow.getAttribute("MailingCity"))).append("</CITY>");
                            xmlBuilder.append("<STATE>").append(checkIfNull((String)customerRow.getAttribute("MailingState"))).append("</STATE>");
                            xmlBuilder.append("<POSTAL_CODE>").append(checkIfNull((String)customerRow.getAttribute("MailingPostal"))).append("</POSTAL_CODE>");
                            
                            xmlBuilder.append("<CONTACT_NAME>").append(checkIfNull((String)customerRow.getAttribute("ContactName"))).append("</CONTACT_NAME>");
                            xmlBuilder.append("<CONTACT_TITLE>").append(checkIfNull((String)customerRow.getAttribute("Title"))).append("</CONTACT_TITLE>");
                            xmlBuilder.append("<CONTACT_PHONE>").append(checkIfNull((String)customerRow.getAttribute("PhoneNum"))).append("</CONTACT_PHONE>");
                            xmlBuilder.append("<CONTACT_EMAIL>").append(checkIfNull((String)customerRow.getAttribute("Email"))).append("</CONTACT_EMAIL>");
                            
                            xmlBuilder.append("<BILLING_ADDRESS1>").append(checkIfNull((String)customerRow.getAttribute("BillingAddress1"))).append("</BILLING_ADDRESS1>");
                            xmlBuilder.append("<BILLING_ADDRESS2>").append(checkIfNull((String)customerRow.getAttribute("BillingAddress2"))).append("</BILLING_ADDRESS2>");
                            xmlBuilder.append("<BILLING_CITY>").append(checkIfNull((String)customerRow.getAttribute("City"))).append("</BILLING_CITY>");
                            xmlBuilder.append("<BILLING_STATE>").append(checkIfNull((String)customerRow.getAttribute("State"))).append("</BILLING_STATE>");
                            xmlBuilder.append("<BILLING_POSTAL_CODE>").append(checkIfNull((String)customerRow.getAttribute("Postal"))).append("</BILLING_POSTAL_CODE>");
                            xmlBuilder.append("<BUSINESS_TYPE>").append(checkIfNull((String)customerRow.getAttribute("BusinessType"))).append("</BUSINESS_TYPE>");
                        }
                }
                
                Key key = new Key(new Object[] { contractId, contractVersion });
                Row[] rows = xpeDccNewContractsEOVORow.getXpeDccContractVersionView().findByKey(key, 1);
                if (null != rows && rows.length > 0) {
                    XpeDccContractVersionViewRowImpl contractVersionViewRow = (XpeDccContractVersionViewRowImpl) rows[0];
                    xmlBuilder.append("<AS_OF_DATE>").append(formatDate(String.valueOf(contractVersionViewRow.getXpeAsOfDate()))).append("</AS_OF_DATE>");
                    xmlBuilder.append("<FROM_DATE>").append(formatDate(String.valueOf(contractVersionViewRow.getXpeStartDate()))).append("</FROM_DATE>");
                    xmlBuilder.append("<TO_DATE>").append(formatDate(String.valueOf(contractVersionViewRow.getXpeEndDate()))).append("</TO_DATE>");
                    xmlBuilder.append("<USER_NAME>").append(getLookupDescription(contractVersionViewRow.getPsSalesPersonROVO1(),contractVersionViewRow.getSalesPerson(), "Descr")).append("</USER_NAME>");
                    //Getting Facility details
                    RowIterator contractLineRowSet = contractVersionViewRow.getXpeDccContractLineView();
                    
                    while (contractLineRowSet.hasNext()) {
                        XpeDccContractLineViewRowImpl contractLineRow = (XpeDccContractLineViewRowImpl) contractLineRowSet.next();
                        if(null!=contractLineRow){
                            xmlBuilder.append("<FACILITIES_ROW>");
                            xmlBuilder.append("<FACILITY>").append(getLookupDescription(contractLineRow.getXpeDccCfgPcsROVO_LOV(),contractLineRow.getXpeFacility(), "SiteDesc")).append("</FACILITY>");
                            XpeDccCfgPcsAddressROVOImpl xpeDccCfgPcsAddressROVO = this.getXpeDccCfgPcsAddressROVO();
                            xpeDccCfgPcsAddressROVO.setbind_SiteId(contractLineRow.getXpeFacility());
                            xpeDccCfgPcsAddressROVO.executeQuery();
                            XpeDccCfgPcsAddressROVORowImpl xpeDccCfgPcsAddressROVORow = (XpeDccCfgPcsAddressROVORowImpl)xpeDccCfgPcsAddressROVO.first();
                            if(null!=xpeDccCfgPcsAddressROVORow){
                                xmlBuilder.append("<FACILITY_ADDRESS>").append(checkIfNull(xpeDccCfgPcsAddressROVORow.getSiteAddress1())).append("</FACILITY_ADDRESS>");
                                xmlBuilder.append("<FACILITY_CITY>").append(checkIfNull(xpeDccCfgPcsAddressROVORow.getSiteCity())).append("</FACILITY_CITY>");
                                xmlBuilder.append("<FACILITY_STATE>").append(checkIfNull(xpeDccCfgPcsAddressROVORow.getSiteState())).append("</FACILITY_STATE>");
                                xmlBuilder.append("<FACILITY_POSTAL_CODE>").append(checkIfNull(xpeDccCfgPcsAddressROVORow.getSitePostal())).append("</FACILITY_POSTAL_CODE>");
                                xmlBuilder.append("<FACILITY_OPERATING_HOURS>").append(checkIfNull(xpeDccCfgPcsAddressROVORow.getSiteOperatingHours())).append("</FACILITY_OPERATING_HOURS>");
                            }
                            RowIterator pricingTermRowSet = contractLineRow.getXpeDccContractPricingTermView();
                            BigDecimal materialQtyFrom = new BigDecimal(0);
                            while (pricingTermRowSet.hasNext()) {
                                XpeDccContractPricingTermViewRowImpl pricingTermRow = (XpeDccContractPricingTermViewRowImpl) pricingTermRowSet.next();
                                if(null!=pricingTermRow){
                                    if(null!=pricingTermRow.getXpePricingTermType()){
                                        if (!"FEE".equalsIgnoreCase(pricingTermRow.getXpePricingTermType())) {
                                            xmlBuilder.append("<PRICING_ROW>");
                                            xmlBuilder.append("<MATERIAL_WASTE_TYPE>").append(getLookupDescription(contractLineRow.getXpeDccDicProducts1(),contractLineRow.getXpeProductId(), "XpeLookupDesc")).append("</MATERIAL_WASTE_TYPE>");
                                            xmlBuilder.append("<PRICING_TYPE>").append(getLookupDescription(pricingTermRow.getXpeDccDicRateTypes1(),pricingTermRow.getXpePricingTermType(), "XpeLookupDesc")).append("</PRICING_TYPE>");
                                            if (null != pricingTermRow.getXpePricingTermType()) {
                                                if (!"RTE".equals(pricingTermRow.getXpePricingTermType())) {
                                                    xmlBuilder.append("<MATERIAL_QUANTITY_FROM>").append(materialQtyFrom).append("</MATERIAL_QUANTITY_FROM>");
                                                    xmlBuilder.append("<MATERIAL_QUANTITY_TO>").append(pricingTermRow.getXpeQtyMax()).append("</MATERIAL_QUANTITY_TO>");
                                                }
                                            } else {
                                                xmlBuilder.append("<MATERIAL_QUANTITY_FROM>").append(materialQtyFrom).append("</MATERIAL_QUANTITY_FROM>");
                                                xmlBuilder.append("<MATERIAL_QUANTITY_TO>").append(pricingTermRow.getXpeQtyMax()).append("</MATERIAL_QUANTITY_TO>");
                                            }
                                            xmlBuilder.append("<DISPOSAL_PRICE>").append(pricingTermRow.getXpeRate()).append("</DISPOSAL_PRICE>");
                                            xmlBuilder.append("<RESET_PERIOD>").append(getLookupDescription(pricingTermRow.getXpeDccDicPeriods1(),pricingTermRow.getXpePeriodType(), "XpeLookupDesc")).append("</RESET_PERIOD>");
                                            xmlBuilder.append("</PRICING_ROW>");
                                            materialQtyFrom = pricingTermRow.getXpeQtyMax();
                                        }else{
                                            xmlBuilder.append("<PRICING_FEE_ROW>");
                                            xmlBuilder.append("<MATERIAL_WASTE_TYPE>").append(getLookupDescription(pricingTermRow.getXpeDccDicRateTypes1(),pricingTermRow.getXpePricingTermType(), "XpeLookupDesc")).append("</MATERIAL_WASTE_TYPE>");
                                            xmlBuilder.append("<DISPOSAL_PRICE>").append(pricingTermRow.getXpeRate()).append("</DISPOSAL_PRICE>");
                                            if (null != pricingTermRow.getXpePeriodType() && "EVE".equals(pricingTermRow.getXpePeriodType()))
                                                xmlBuilder.append("<CHARGE_SHIPMENT>").append(pricingTermRow.getXpeRate()).append("</CHARGE_SHIPMENT>");
                                            xmlBuilder.append("<RESET_PERIOD>").append(getLookupDescription(pricingTermRow.getXpeDccDicPeriods1(),pricingTermRow.getXpePeriodType(), "XpeLookupDesc")).append("</RESET_PERIOD>");
                                            xmlBuilder.append("</PRICING_FEE_ROW>");
                                        }
                                    }
                                }
                            }
                            xmlBuilder.append("</FACILITIES_ROW>");
                        }   
                    }
                    
                    XpeDccContractNotesViewRowImpl xpeDccContractNotesViewRow = (XpeDccContractNotesViewRowImpl)contractVersionViewRow.getXpeDccContractNotesView().first();
                    if(null!=xpeDccContractNotesViewRow)
                        xmlBuilder.append("<CUSTOMER_NOTES>").append(checkIfNull(xpeDccContractNotesViewRow.getXpeNote())).append("</CUSTOMER_NOTES>");
                    
                    xmlBuilder = buildXMLForTerms(contractVersionViewRow,xmlBuilder,customerName);
                    pdf.put("TEMPLATE_NAME",this.getTemplateName(contractVersionViewRow));
                }
                
                if (null != inContractFlow && "N".equals(inContractFlow)) {
                    this.getXpeDccWfActionROVO().executeEmptyRowSet();
                    this.getXpeDccWfActionROVO().setApplyViewCriteriaName("XpeDccWfActionROVOCriteria");
                    this.getXpeDccWfActionROVO().setbind_uuId(uuId);
                    this.getXpeDccWfActionROVO().executeQuery();
                    XpeDccWfActionROVORowImpl xpeDccWfActionROVORow =
                        (XpeDccWfActionROVORowImpl) this.getXpeDccWfActionROVO().first();
                    if (null != xpeDccWfActionROVORow) {
                        this.getXpeDccWfActionROVO().executeEmptyRowSet();
                        this.getXpeDccWfActionROVO().setApplyViewCriteriaName("XpeDccWfActionApprovalCheckCriteria");
                        this.getXpeDccWfActionROVO().setbind_EventNumber(xpeDccWfActionROVORow.getXpeEventNumber());
                        this.getXpeDccWfActionROVO().setbind_ActionStatus("A");
                        this.getXpeDccWfActionROVO().executeQuery();
                        Long rowCount = this.getXpeDccWfActionROVO().getEstimatedRowCount();
                        if (rowCount.intValue() == 1 && null != rows && rows.length > 0) {
                            XpeDccContractVersionViewRowImpl contractVersionViewRow = (XpeDccContractVersionViewRowImpl) rows[0];
                            XpeDccContractLineViewRowImpl xpeDccContractLineViewRow =
                                (XpeDccContractLineViewRowImpl) contractVersionViewRow.getXpeDccContractLineView().first();

                            String wasteType = contractVersionViewRow.getXpeWasteType();
                            String contractSubType = contractVersionViewRow.getXpeContractSubType();
                            String agreementType = contractVersionViewRow.getXpeAgreementType();

                            if (null != wasteType && null != contractSubType && "MSW".equals(wasteType) &&
                                ("SPT".equals(contractSubType) || ("PMM".equals(contractSubType) && null != agreementType && "PNC".equals(agreementType)))) {
                                XpeDccCfgMswFacilityEOVOImpl xpeDccCfgMswFacilityEOVO = this.getXpeDccCfgMswFacilityEOVO1();
                                xpeDccCfgMswFacilityEOVO.executeEmptyRowSet();
                                xpeDccCfgMswFacilityEOVO.setApplyViewCriteriaName("findByFacilityId");
                                xpeDccCfgMswFacilityEOVO.setbind_FacilityId(xpeDccContractLineViewRow.getXpeFacility());
                                xpeDccCfgMswFacilityEOVO.executeQuery();
                                XpeDccCfgMswFacilityEOVORowImpl xpeDccCfgMswFacilityEOVORow = (XpeDccCfgMswFacilityEOVORowImpl) xpeDccCfgMswFacilityEOVO.first();
                                if (null != xpeDccCfgMswFacilityEOVORow) {
                                    //(assuming you have a ResultSet named RS)
                                    BlobDomain signatureBlob = xpeDccCfgMswFacilityEOVORow.getGeneralManagerSignature();
                                    if (null != signatureBlob && (int) signatureBlob.getLength() > 0) {
                                        byte[] signatureBlobAsEncodedBytes = Base64.encodeBase64(signatureBlob.getBytes(1,(int) signatureBlob.getLength()));
                                        xmlBuilder.append("<IMAGE_ELEMENT>").append(signatureBlobAsEncodedBytes).append("</IMAGE_ELEMENT>");
                                    }
                                }
                            }
                        }
                    }
                }
            }
            
            xmlBuilder.append("</CONTRACT_DETAILS_ROW>");
            xmlBuilder.append("</CONTRACT_DETAILS>");

            System.out.println(xmlBuilder.toString());
            pdf.put("XML",xmlBuilder.toString());
            
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
        return pdf;
    }
    
    private String getLookupDescription(RowSet rowSet, String lookupId, String lookupAttributeName){
        String lookupDesc = "";
        Key key = new Key(new Object[] {lookupId});
        Row[] rows = rowSet.findByKey(key, 1);
        if(null!=rows && rows.length>0)
            lookupDesc = (String)rows[0].getAttribute(lookupAttributeName);
        return lookupDesc;
    }
    
    private StringBuilder buildXMLForTerms(XpeDccContractVersionViewRowImpl contractVersionViewRow, StringBuilder xmlBuilder, String customerName){
        try {
            RowIterator rowIterator = contractVersionViewRow.getXpeDccTermsContractEOVO();
            while(rowIterator.hasNext()){
                XpeDccTermsContractEOVORowImpl xpeDccTermsContractEOVORow =(XpeDccTermsContractEOVORowImpl)rowIterator.next();
            xmlBuilder.append("<TERM_DETAILS_ROW>");
            xmlBuilder.append("<HTML_TEXT>").append("<![CDATA[").append(replaceHtml(contractVersionViewRow,convertClobToString(xpeDccTermsContractEOVORow.getXpeDccTermTemplate()),customerName)).append("]]>").append("</HTML_TEXT>");
            xmlBuilder.append("</TERM_DETAILS_ROW>");
            }
            System.out.println(xmlBuilder.toString());
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
        return xmlBuilder;
    }
    
    private String convertClobToString(ClobDomain html) {
        StringBuilder htmlBuilder = new StringBuilder();
        try {
            Reader initialReader = html.getCharacterStream();
            char[] charBuffer = new char[8 * 1024];
            int numCharsRead;
            while ((numCharsRead = initialReader.read(charBuffer, 0, charBuffer.length)) != -1) {
                htmlBuilder.append(charBuffer, 0, numCharsRead);
            }
            initialReader.close();
        } catch (IOException ioe) {
            // TODO: Add catch code
            ioe.printStackTrace();
        }
        return htmlBuilder.toString();
    }
    
    private String checkIfNull(String val){ 
        if(null==val || val.trim().length()==0)
          return "";
        else
         return val;
    }
    
    private String replaceHtml(XpeDccContractVersionViewRowImpl contractVersionViewRow,String htmlString,String customerName) {
        //ADFUtils.setvalueToExpression("#{pageFlowScope.html}", null);
        if (null != htmlString && htmlString.length() > 0) {
            htmlString = htmlString.replaceAll("\\{CUSTOMER NAME\\}",customerName);
            htmlString = htmlString.replaceAll("\\{WASTE TYPE\\}",  contractVersionViewRow.getXpeWasteType());
            htmlString = htmlString.replaceAll("\\{CONTRACT SUB TYPE\\}",  contractVersionViewRow.getXpeContractSubType());
            htmlString = htmlString.replaceAll("\\{AGREEMENT TYPE\\}", contractVersionViewRow.getXpeAgreementType());
            //ADFUtils.setvalueToExpression("#{pageFlowScope.html}", htmlString);
        }
        return htmlString;
    }
    private String getTemplateName(XpeDccContractVersionViewRowImpl contractVersionViewRow) {
        String templateName = null;
        String wasteType = contractVersionViewRow.getXpeWasteType();
        String contractSubType = contractVersionViewRow.getXpeContractSubType();
        String agreementType = contractVersionViewRow.getXpeAgreementType();
        if (null != wasteType && null != contractSubType) {
            if ("MTL".equals(wasteType) && "FRS".equals(contractSubType)) 
                templateName = "OGI - Ferrous Purchase Sale Agreement spot v12-21-14";
            else if ("MTL".equals(wasteType) && "NFR".equals(contractSubType)) 
                templateName = "OGI - Non-Ferrous Purchase Sale Agreement spot v12-21-14";
            else if ("MSW".equals(wasteType) && "PMM".equals(contractSubType) && null!=agreementType && ("PC".equals(agreementType) || "PNC".equals(agreementType)))
                templateName = "Covanta - Spot-Premium Contract Template v2";
            else if ("MSW".equals(wasteType) && "SPT".equals(contractSubType))
                templateName = "Covanta - Spot-Premium Contract Template v2";
        }
        return templateName;
    }
    
    public String createNewContractVersion(String contractType){
        String version = null;
        try {
            XpeDccContractSearchROVORowImpl contractSearchROVORow =
                (XpeDccContractSearchROVORowImpl) this.getXpeDccContractSearchROVO().getCurrentRow();
            if (null != contractSearchROVORow) {
                System.err.println("Contract Id: " + contractSearchROVORow.getXpeContractId());
                System.err.println("Version: " + contractSearchROVORow.getXpeContractVersion());
                this.getXpeDccNewContractsEOVO().executeEmptyRowSet();
                this.getXpeDccNewContractsEOVO().setApplyViewCriteriaName("FetchExtContractCriteria");
                this.getXpeDccNewContractsEOVO().setbind_ContractId(contractSearchROVORow.getXpeContractId());
                this.getXpeDccNewContractsEOVO().executeQuery();
                System.err.println("ERC: " + this.getXpeDccNewContractsEOVO().getEstimatedRowCount());
                XpeDccNewContractsEOVORowImpl xpeDccNewContractsEOVORow =
                    (XpeDccNewContractsEOVORowImpl) this.getXpeDccNewContractsEOVO().first();
                if (null != xpeDccNewContractsEOVORow) {
                    Key key =
                        new Key(new Object[] { contractSearchROVORow.getXpeContractId(),
                                               contractSearchROVORow.getXpeContractVersion() });
                    Row[] rows = xpeDccNewContractsEOVORow.getXpeDccContractVersionView().findByKey(key, 1);
                    if (null != rows && rows.length > 0) {
                        removeNewContractVersionRow();
                        version = getVersionNumber();
                        XpeDccContractVersionViewRowImpl sourceContractVersionViewRow =
                            (XpeDccContractVersionViewRowImpl) rows[0];
                        XpeDccContractVersionViewRowImpl targetContractVersionViewRow =
                            (XpeDccContractVersionViewRowImpl) xpeDccNewContractsEOVORow.getXpeDccContractVersionView().createAndInitRow(null);
                        targetContractVersionViewRow.setXpeContractVersion(version);
                        targetContractVersionViewRow.setXpeWasteType(sourceContractVersionViewRow.getXpeWasteType());
                        targetContractVersionViewRow.setXpeContractSubType(sourceContractVersionViewRow.getXpeContractSubType());
                        targetContractVersionViewRow.setXpeAgreementType(sourceContractVersionViewRow.getXpeAgreementType());
                        targetContractVersionViewRow.setXpeAsOfDate(sourceContractVersionViewRow.getXpeAsOfDate());
                        targetContractVersionViewRow.setXpeStartDate(sourceContractVersionViewRow.getXpeStartDate());
                        targetContractVersionViewRow.setXpeEndDate(sourceContractVersionViewRow.getXpeEndDate());
                        targetContractVersionViewRow.setSalesPerson(sourceContractVersionViewRow.getSalesPerson());
                        targetContractVersionViewRow.setXpeAcctgOptionsSet(sourceContractVersionViewRow.getXpeAcctgOptionsSet());
                        targetContractVersionViewRow.setCurrencyCd(sourceContractVersionViewRow.getCurrencyCd());
                        targetContractVersionViewRow.setXpeContractDirection(sourceContractVersionViewRow.getXpeContractDirection());       
                        targetContractVersionViewRow.setXpeTermAgreement(sourceContractVersionViewRow.getXpeTermAgreement());
                        targetContractVersionViewRow.setXpeValueTransaction(sourceContractVersionViewRow.getXpeValueTransaction());
                        targetContractVersionViewRow.setXpeVarianceBudget(sourceContractVersionViewRow.getXpeVarianceBudget());
                        targetContractVersionViewRow.setXpePaymentHistory(sourceContractVersionViewRow.getXpePaymentHistory());
                        targetContractVersionViewRow.setXpePaymentMethod(sourceContractVersionViewRow.getXpePaymentMethod());
                        targetContractVersionViewRow.setXpeEstDisposalVol(sourceContractVersionViewRow.getXpeEstDisposalVol());
                        targetContractVersionViewRow.setXpeExistingCustomer(sourceContractVersionViewRow.getXpeExistingCustomer());
                        targetContractVersionViewRow.setXpeJustification(sourceContractVersionViewRow.getXpeJustification());
                        targetContractVersionViewRow.setXpeCreditLimit(sourceContractVersionViewRow.getXpeCreditLimit());
                        
                        xpeDccNewContractsEOVORow.getXpeDccContractVersionView().insertRow(targetContractVersionViewRow);
                        copyNewVersionContractLine(sourceContractVersionViewRow, targetContractVersionViewRow,
                                                   contractType);
                        copyNewVersionContractNotes(sourceContractVersionViewRow, targetContractVersionViewRow);
                    }
                }
            }
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
        return version;
    }

    private void removeNewContractVersionRow() {
        RowSetIterator rowSetIterator = this.getXpeDccNewContractVersionView().createRowSetIterator(null);
        while (rowSetIterator.hasNext()) {
            XpeDccContractVersionViewRowImpl versionViewRow = (XpeDccContractVersionViewRowImpl) rowSetIterator.next();
            byte newRowStatus = versionViewRow.getEntity(0).getEntityState();
            if (newRowStatus == Entity.STATUS_NEW)
                versionViewRow.remove();
        }
        rowSetIterator.closeRowSetIterator();
    }
    
    private String getVersionNumber(){
        List<Integer> versionList = new ArrayList<Integer>();
        try {
            RowSetIterator rowSetIterator = this.getXpeDccNewContractVersionView().createRowSetIterator(null);
            while (rowSetIterator.hasNext()) {
                Row row = rowSetIterator.next();
                String versionNumber = (String) row.getAttribute("XpeContractVersion");
                versionNumber = versionNumber.trim().substring(1);
                versionList.add(new Integer(versionNumber));
            }
            rowSetIterator.closeRowSetIterator();
        } catch (NumberFormatException nfe) {
            // TODO: Add catch code
            nfe.printStackTrace();
        }
        Integer maxVersionNumber =  new Integer(Collections.max(versionList));
        System.err.println("Max Version Number: "+maxVersionNumber);
        maxVersionNumber = maxVersionNumber+1;
        return "V"+maxVersionNumber;
    }
    
    private void copyNewVersionContractLine(XpeDccContractVersionViewRowImpl source, XpeDccContractVersionViewRowImpl target, String contractType) {
        RowIterator lineSourceRowSet = source.getXpeDccContractLineView();
        RowIterator lineTargetRowSet = target.getXpeDccContractLineView();
        while (lineSourceRowSet.hasNext()) {
            XpeDccContractLineViewRowImpl lineSourceRow = (XpeDccContractLineViewRowImpl) lineSourceRowSet.next();
            XpeDccContractLineViewRowImpl lineTargetRow =
                (XpeDccContractLineViewRowImpl) lineTargetRowSet.createAndInitRow(null);
            //lineTargetRow.setXpeContractId(contractId);
            //lineTargetRow.setXpeContractVersion(versionId);
            lineTargetRow.setXpeContractLine(lineSourceRow.getXpeContractLine());
            lineTargetRow.setBusinessUnitGl(lineSourceRow.getBusinessUnitGl());
            lineTargetRow.setXpeFacility(lineSourceRow.getXpeFacility());
            lineTargetRow.setXpePeriodType(lineSourceRow.getXpePeriodType());
            lineTargetRow.setXpeProductId(lineSourceRow.getXpeProductId());
            lineTargetRow.setXpeProductUom(lineSourceRow.getXpeProductUom());
            lineTargetRow.setXpeQtyMax(lineSourceRow.getXpeQtyMax());
            lineTargetRow.setXpeQtyMin(lineSourceRow.getXpeQtyMin());
            lineTargetRow.setXpeSwApprNbr(lineSourceRow.getXpeSwApprNbr());
            lineTargetRow.setCurrencyCd(lineTargetRow.getCurrencyCd());
            lineTargetRowSet.insertRow(lineTargetRow);
            copyNewVersionPricingTerm(lineSourceRow, lineTargetRow);
            if(null != contractType && "BLS".equals(contractType)){
            copyNewVersionBlueLightsSpecial(lineSourceRow, lineTargetRow);
            }
        }

    }

    private void copyNewVersionPricingTerm(XpeDccContractLineViewRowImpl source, XpeDccContractLineViewRowImpl target) {


        RowIterator lineSourceRowSet = source.getXpeDccContractPricingTermView();
        RowIterator lineTargetRowSet = target.getXpeDccContractPricingTermView();
        while (lineSourceRowSet.hasNext()) {

            XpeDccContractPricingTermViewRowImpl sourcePricingTermRow =
                (XpeDccContractPricingTermViewRowImpl) lineSourceRowSet.next();

            XpeDccContractPricingTermViewRowImpl targetPricingTermRow =
                (XpeDccContractPricingTermViewRowImpl) lineTargetRowSet.createAndInitRow(null);
            targetPricingTermRow.setXpeChargeDesc(sourcePricingTermRow.getXpeChargeDesc());
            targetPricingTermRow.setXpeChargeOverMax(sourcePricingTermRow.getXpeChargeOverMax());
            targetPricingTermRow.setXpeChargeOverMin(sourcePricingTermRow.getXpeChargeOverMin());
            targetPricingTermRow.setXpeContractLine(sourcePricingTermRow.getXpeContractLine());
            //targetPricingTermRow.setXpeContractVersion("V1");
            targetPricingTermRow.setXpePeriodNbr(sourcePricingTermRow.getXpePeriodNbr());
            targetPricingTermRow.setXpePeriodType(sourcePricingTermRow.getXpePeriodType());
            targetPricingTermRow.setXpePricingTermLine(sourcePricingTermRow.getXpePricingTermLine());
            targetPricingTermRow.setXpePricingTermType(sourcePricingTermRow.getXpePricingTermType());
            targetPricingTermRow.setXpeQtyMax(sourcePricingTermRow.getXpeQtyMax());
            targetPricingTermRow.setXpeRate(sourcePricingTermRow.getXpeRate());
            targetPricingTermRow.setXpeResetType(sourcePricingTermRow.getXpeResetType());
            targetPricingTermRow.setXpeRolloverType(sourcePricingTermRow.getXpeRolloverType());
            lineTargetRowSet.insertRow(targetPricingTermRow);
            copyNewVersionCarrierDetails(sourcePricingTermRow, targetPricingTermRow);
        }

    }
    
    private void copyNewVersionBlueLightsSpecial(XpeDccContractLineViewRowImpl source, XpeDccContractLineViewRowImpl target){
        Timestamp currentDate = new Timestamp(System.currentTimeMillis());
        RowIterator priceOverSourceRowSet = source.getXpeDccContractPricingOverView();
        RowIterator priceOverTargetRowSet = target.getXpeDccContractPricingOverView();
        while(priceOverSourceRowSet.hasNext()){
           XpeDccContractPricingOverViewRowImpl sourcePricingOverRow =
                (XpeDccContractPricingOverViewRowImpl) priceOverSourceRowSet.next();
            if(currentDate.compareTo(sourcePricingOverRow.getXpeOverStart()) > 0 && currentDate.compareTo(sourcePricingOverRow.getXpeOverEnd()) < 0){
                XpeDccContractPricingOverViewRowImpl targetPricingOverRow =
                    (XpeDccContractPricingOverViewRowImpl) priceOverTargetRowSet.createAndInitRow(null);
                targetPricingOverRow.setXpeContractOverNbr(sourcePricingOverRow.getXpeContractOverNbr());
                targetPricingOverRow.setXpeOverType("sourcePricingOverRow.getXpeOverType()");
                targetPricingOverRow.setXpeOverStart(sourcePricingOverRow.getXpeOverStart());
                targetPricingOverRow.setXpeOverEnd(sourcePricingOverRow.getXpeOverEnd());
                targetPricingOverRow.setXpeSourceFld(sourcePricingOverRow.getXpeSourceFld());
                targetPricingOverRow.setXpeCondition(sourcePricingOverRow.getXpeTargetFld());
                targetPricingOverRow.setXpeCheck(sourcePricingOverRow.getXpeCheck());
                targetPricingOverRow.setXpeTargetFld(sourcePricingOverRow.getXpeTargetFld());
                targetPricingOverRow.setXpeOverMsg(sourcePricingOverRow.getXpeOverMsg());
                targetPricingOverRow.setXpeOverDesc(sourcePricingOverRow.getXpeOverDesc());
                targetPricingOverRow.setCarryForwardedPricingOver("Y");
                priceOverTargetRowSet.insertRow(targetPricingOverRow);
            }
        }
    }

    private void copyNewVersionCarrierDetails(XpeDccContractPricingTermViewRowImpl source,
                                    XpeDccContractPricingTermViewRowImpl target) {


        RowIterator carrierDetailsSource = source.getXpeDccContractCarrierView();
        RowIterator carrierDetailsTarget = target.getXpeDccContractCarrierView();
        while (carrierDetailsSource.hasNext()) {
            System.out.println("inside carrier details");
            XpeDccContractCarrierViewRowImpl sourceCarrierDetailRow =
                (XpeDccContractCarrierViewRowImpl) carrierDetailsSource.next();
            XpeDccContractCarrierViewRowImpl targetCarrierDetailRow =
                (XpeDccContractCarrierViewRowImpl) carrierDetailsTarget.createAndInitRow(null);
            targetCarrierDetailRow.setXpeCarrierId(sourceCarrierDetailRow.getXpeCarrierId());
            //   targetCarrierDetailRow.setXpeContractId(sourceCarrierDetailRow.getXpeContractId());
            targetCarrierDetailRow.setXpeContractLine(sourceCarrierDetailRow.getXpeContractLine());
            //targetCarrierDetailRow.setXpeContractVersion("V1");
            targetCarrierDetailRow.setXpePricingTermLine(sourceCarrierDetailRow.getXpePricingTermLine());
            targetCarrierDetailRow.setXpeRateOverride(sourceCarrierDetailRow.getXpeRateOverride());
            targetCarrierDetailRow.setXpeSubNbr(sourceCarrierDetailRow.getXpeSubNbr());
            targetCarrierDetailRow.setXpeSurcharge(sourceCarrierDetailRow.getXpeSurcharge());
            targetCarrierDetailRow.setXpeVehicleNbr(sourceCarrierDetailRow.getXpeVehicleNbr());
            targetCarrierDetailRow.setXpeSurcharge(sourceCarrierDetailRow.getXpeSurcharge());
            targetCarrierDetailRow.setXpeVehicleType(sourceCarrierDetailRow.getXpeVehicleType());
            targetCarrierDetailRow.setXpeVehicleType(sourceCarrierDetailRow.getXpeVehicleType());
            carrierDetailsTarget.insertRow(targetCarrierDetailRow);
        }

    }

    private void copyNewVersionContractNotes(XpeDccContractVersionViewRowImpl source, XpeDccContractVersionViewRowImpl target) {
        RowIterator sourceNotesRowIterator = source.getXpeDccContractNotesView();
        while(sourceNotesRowIterator.hasNext()) {
            XpeDccContractNotesViewRowImpl sourceNotesRow = (XpeDccContractNotesViewRowImpl) sourceNotesRowIterator.next();
            XpeDccContractNotesViewRowImpl targetNotesRow = (XpeDccContractNotesViewRowImpl) target.getXpeDccContractNotesView().createAndInitRow(null);
            targetNotesRow.setXpeNoteDttm(sourceNotesRow.getXpeNoteDttm());
            targetNotesRow.setXpeNoteType(sourceNotesRow.getXpeNoteType());
            targetNotesRow.setXpeNote(sourceNotesRow.getXpeNote());
            targetNotesRow.setXpeNoteLong(sourceNotesRow.getXpeNoteLong());
            targetNotesRow.setXpeUser(sourceNotesRow.getXpeUser());
            target.getXpeDccContractNotesView().insertRow(targetNotesRow);
        }
    }
    
    public void clearNewContract(){
        this.getXpeDccNewContractSetupROVO().clearCache();
        this.getXpeDccNewContractSetupROVO().executeQuery();
        XpeDccNewContractSetupROVORowImpl newContractSetupRow =
            (XpeDccNewContractSetupROVORowImpl) this.getXpeDccNewContractSetupROVO().first();
        if (null != newContractSetupRow)
            newContractSetupRow.setTerms_Modifier_Check("N");
        this.getXpeDmsCustomerEOVO().setApplyViewCriteriaName("XpeDmsCustomerEmptyEOVOCriteria");
        this.getXpeDmsCustomerEOVO().executeQuery();
        this.getXpeDccNewContractCustomerSearchROVO().executeEmptyRowSet();
        this.getXpeDccNewContractsEOVO().setApplyViewCriteriaName("NewContractsEmptyCriteria");
        this.getXpeDccNewContractsEOVO().executeQuery();
        this.getXpeDccContractSearchROVO().executeEmptyRowSet();
    }
    
    public void clearTermMaster(){
        this.getXpeDccTermMasterSetupROVO().clearCache();
        this.getXpeDccTermMasterEOVO().executeEmptyRowSet();
        this.getXpeDccTermMasterNewRowCreationEOVO().setApplyViewCriteriaName("XpeDccTermMasterEmptyCriteria");
        this.getXpeDccTermMasterNewRowCreationEOVO().executeQuery();
    }

    /**
     * Container's getter for XpeDmsCustomerEOVO1.
     * @return XpeDmsCustomerEOVO1
     */
    public XpeDmsCustomerEOVOImpl getXpeDmsCustomerEOVO() {
        return (XpeDmsCustomerEOVOImpl) findViewObject("XpeDmsCustomerEOVO");
    }

    /**
     * Container's getter for NewContractCustomerSearchROVO1.
     * @return NewContractCustomerSearchROVO1
     */
    public XpeDccNewContractCustomerSearchROVOImpl getXpeDccNewContractCustomerSearchROVO() {
        return (XpeDccNewContractCustomerSearchROVOImpl) findViewObject("XpeDccNewContractCustomerSearchROVO");
    }

    /**
     * Container's getter for XpeDccTermMasterSetupROVO1.
     * @return XpeDccTermMasterSetupROVO1
     */
    public ViewObjectImpl getXpeDccTermMasterSetupROVO() {
        return (ViewObjectImpl) findViewObject("XpeDccTermMasterSetupROVO");
    }

    /**
     * Container's getter for XpeDccCfgTerminalsEOVO1.
     * @return XpeDccCfgTerminalsEOVO1
     */
    public XpeDccCfgTerminalsEOVOImpl getXpeDccCfgTerminalsEOVO() {
        return (XpeDccCfgTerminalsEOVOImpl) findViewObject("XpeDccCfgTerminalsEOVO");
    }

    /**
     * Container's getter for XpeDccCfgTerminalsEOVO1.
     * @return XpeDccCfgTerminalsEOVO1
     */
    public XpeDccCfgTerminalsEOVOImpl getXpeDccCfgNewTerminalCreationEOVO() {
        return (XpeDccCfgTerminalsEOVOImpl) findViewObject("XpeDccCfgNewTerminalCreationEOVO");
    }

    /**
     * Container's getter for XpeDccCfgDestinationsEOVO1.
     * @return XpeDccCfgDestinationsEOVO1
     */
    public XpeDccCfgDestinationsEOVOImpl getXpeDccCfgDestinationsEOVO() {
        return (XpeDccCfgDestinationsEOVOImpl) findViewObject("XpeDccCfgDestinationsEOVO");
    }

    /**
     * Container's getter for XpeDccCfgDstAssTerminalsEOVO1.
     * @return XpeDccCfgDstAssTerminalsEOVO1
     */
    public XpeDccCfgDstAssTerminalsEOVOImpl getXpeDccCfgDstAssTerminalsEOVO() {
        return (XpeDccCfgDstAssTerminalsEOVOImpl) findViewObject("XpeDccCfgDstAssTerminalsEOVO");
    }

    /**
     * Container's getter for XpeDccCfgDestinationsFKVL1.
     * @return XpeDccCfgDestinationsFKVL1
     */
    public ViewLinkImpl getXpeDccCfgDestinationsFKVL1() {
        return (ViewLinkImpl) findViewLink("XpeDccCfgDestinationsFKVL1");
    }

    /**
     * Container's getter for XpeDccCfgDestinationsEOVO1.
     * @return XpeDccCfgDestinationsEOVO1
     */
    public XpeDccCfgDestinationsEOVOImpl getXpeDccCfgNewDestinationsCreationEOVO() {
        return (XpeDccCfgDestinationsEOVOImpl) findViewObject("XpeDccCfgNewDestinationsCreationEOVO");
    }

    /**
     * Container's getter for XpeDccCfgDstAssTerminalsEOVO1.
     * @return XpeDccCfgDstAssTerminalsEOVO1
     */
    public XpeDccCfgDstAssTerminalsEOVOImpl getXpeDccCfgNewDstAssTerminalsCreationEOVO() {
        return (XpeDccCfgDstAssTerminalsEOVOImpl) findViewObject("XpeDccCfgNewDstAssTerminalsCreationEOVO");
    }

    /**
     * Container's getter for XpeDccCfgDestinationsFKVL2.
     * @return XpeDccCfgDestinationsFKVL2
     */
    public ViewLinkImpl getXpeDccCfgDestinationsFKVL2() {
        return (ViewLinkImpl) findViewLink("XpeDccCfgDestinationsFKVL2");
    }

    /**
     * Container's getter for XpeDccCfgPcsEOVO1.
     * @return XpeDccCfgPcsEOVO1
     */
    public XpeDccCfgPcsEOVOImpl getXpeDccCfgPcsEOVO() {
        return (XpeDccCfgPcsEOVOImpl) findViewObject("XpeDccCfgPcsEOVO");
    }

    /**
     * Container's getter for XpeDccCfgPcsAssTerminalsEOVO1.
     * @return XpeDccCfgPcsAssTerminalsEOVO1
     */
    public XpeDccCfgPcsAssTerminalsEOVOImpl getXpeDccCfgPcsAssTerminalsEOVO() {
        return (XpeDccCfgPcsAssTerminalsEOVOImpl) findViewObject("XpeDccCfgPcsAssTerminalsEOVO");
    }

    /**
     * Container's getter for XpeDccCfgSitesFKVL1.
     * @return XpeDccCfgSitesFKVL1
     */
    public ViewLinkImpl getXpeDccCfgSitesFKVL1() {
        return (ViewLinkImpl) findViewLink("XpeDccCfgSitesFKVL1");
    }

    /**
     * Container's getter for XpeDccCfgOriginsEOVO1.
     * @return XpeDccCfgOriginsEOVO1
     */
    public XpeDccCfgOriginsEOVOImpl getXpeDccCfgOriginsEOVO() {
        return (XpeDccCfgOriginsEOVOImpl) findViewObject("XpeDccCfgOriginsEOVO");
    }


    /**
     * Container's getter for XpeDccCfgOgnAssTerminalsEOVO1.
     * @return XpeDccCfgOgnAssTerminalsEOVO1
     */
    public XpeDccCfgOgnAssTerminalsEOVOImpl getXpeDccCfgOgnAssTerminalsEOVO() {
        return (XpeDccCfgOgnAssTerminalsEOVOImpl) findViewObject("XpeDccCfgOgnAssTerminalsEOVO");
    }

    /**
     * Container's getter for XpeDccCfgOriginsFKVL1.
     * @return XpeDccCfgOriginsFKVL1
     */
    public ViewLinkImpl getXpeDccCfgOriginsFKVL1() {
        return (ViewLinkImpl) findViewLink("XpeDccCfgOriginsFKVL1");
    }

    /**
     * Container's getter for XpeDccCfgCountiesEOVO1.
     * @return XpeDccCfgCountiesEOVO1
     */
    public XpeDccCfgCountiesEOVOImpl getXpeDccCfgCountiesEOVO() {
        return (XpeDccCfgCountiesEOVOImpl) findViewObject("XpeDccCfgCountiesEOVO");
    }

    /**
     * Container's getter for XpeDccCfgCarriersEOVO1.
     * @return XpeDccCfgCarriersEOVO1
     */
    public XpeDccCfgCarriersEOVOImpl getXpeDccCfgCarriersEOVO() {
        return (XpeDccCfgCarriersEOVOImpl) findViewObject("XpeDccCfgCarriersEOVO");
    }

    /**
     * Container's getter for XpeDccCfgVehiclesEOVO1.
     * @return XpeDccCfgVehiclesEOVO1
     */
    public XpeDccCfgVehiclesEOVOImpl getXpeDccCfgVehiclesEOVO() {
        return (XpeDccCfgVehiclesEOVOImpl) findViewObject("XpeDccCfgVehiclesEOVO");
    }

    /**
     * Container's getter for XpeDccCfgPcsshortnamesEOVO1.
     * @return XpeDccCfgPcsshortnamesEOVO1
     */
    public XpeDccCfgPcsshortnamesEOVOImpl getXpeDccCfgPcsshortnamesEOVO() {
        return (XpeDccCfgPcsshortnamesEOVOImpl) findViewObject("XpeDccCfgPcsshortnamesEOVO");
    }

    /**
     * Container's getter for XpeDccCfgGeneralEOVO1.
     * @return XpeDccCfgGeneralEOVO1
     */
    public XpeDccCfgGeneralEOVOImpl getXpeDccCfgGeneralEOVO() {
        return (XpeDccCfgGeneralEOVOImpl) findViewObject("XpeDccCfgGeneralEOVO");
    }

    /**
     * Container's getter for XpeDccCfgProductserviceEOVO1.
     * @return XpeDccCfgProductserviceEOVO1
     */
    public XpeDccCfgProductserviceEOVOImpl getXpeDccCfgProductserviceEOVO() {
        return (XpeDccCfgProductserviceEOVOImpl) findViewObject("XpeDccCfgProductserviceEOVO");
    }

    /**
     * Container's getter for XpeDccCfgUomEOVO1.
     * @return XpeDccCfgUomEOVO1
     */
    public XpeDccCfgUomEOVOImpl getXpeDccCfgUomEOVO() {
        return (XpeDccCfgUomEOVOImpl) findViewObject("XpeDccCfgUomEOVO");
    }

    /**
     * Container's getter for XpeDccCfgUOMFKVL1.
     * @return XpeDccCfgUOMFKVL1
     */
    public ViewLinkImpl getXpeDccCfgUOMFKVL1() {
        return (ViewLinkImpl) findViewLink("XpeDccCfgUOMFKVL1");
    }


    /**
     * Container's getter for XpeDccCfgAccountingEOVO1.
     * @return XpeDccCfgAccountingEOVO1
     */
    public XpeDccCfgAccountingEOVOImpl getXpeDccCfgAccountingEOVO() {
        return (XpeDccCfgAccountingEOVOImpl) findViewObject("XpeDccCfgAccountingEOVO");
    }

    /**
     * Container's getter for XpeDccCfgBusinessunitEOVO1.
     * @return XpeDccCfgBusinessunitEOVO1
     */
    public XpeDccCfgBusinessunitEOVOImpl getXpeDccCfgBusinessunitEOVO() {
        return (XpeDccCfgBusinessunitEOVOImpl) findViewObject("XpeDccCfgBusinessunitEOVO");
    }

    /**
     * Container's getter for XpeDccCfgGeneralCnvEOVO1.
     * @return XpeDccCfgGeneralCnvEOVO1
     */
    public XpeDccCfgGeneralCnvEOVOImpl getXpeDccCfgGeneralCnvEOVO() {
        return (XpeDccCfgGeneralCnvEOVOImpl) findViewObject("XpeDccCfgGeneralCnvEOVO");
    }


    /**
     * Container's getter for XpeDccTermsForMasterTermROVO1.
     * @return XpeDccTermsForMasterTermROVO1
     */
    public XpeDccTermsForMasterTermROVOImpl getXpeDccTermsForMasterTermROVO() {
        return (XpeDccTermsForMasterTermROVOImpl) findViewObject("XpeDccTermsForMasterTermROVO");
    }

    /**
     * Container's getter for XpeDccCfgCountiesEOVO1.
     * @return XpeDccCfgCountiesEOVO1
     */
    public XpeDccCfgCountiesEOVOImpl getXpeDccCfgNewCountiesCreationEOVO() {
        return (XpeDccCfgCountiesEOVOImpl) findViewObject("XpeDccCfgNewCountiesCreationEOVO");
    }

    /**
     * Container's getter for XpeDccCfgCarriersEOVO1.
     * @return XpeDccCfgCarriersEOVO1
     */
    public XpeDccCfgCarriersEOVOImpl getXpeDccCfgNewCarriersCreationEOVO() {
        return (XpeDccCfgCarriersEOVOImpl) findViewObject("XpeDccCfgNewCarriersCreationEOVO");
    }

    /**
     * Container's getter for XpeDccCfgVehiclesEOVO1.
     * @return XpeDccCfgVehiclesEOVO1
     */
    public XpeDccCfgVehiclesEOVOImpl getXpeDccCfgNewVehiclesCreationEOVO() {
        return (XpeDccCfgVehiclesEOVOImpl) findViewObject("XpeDccCfgNewVehiclesCreationEOVO");
    }

    /**
     * Container's getter for XpeDccCfgOriginsEOVO1.
     * @return XpeDccCfgOriginsEOVO1
     */
    public XpeDccCfgOriginsEOVOImpl getXpeDccCfgNewOriginsEOVO() {
        return (XpeDccCfgOriginsEOVOImpl) findViewObject("XpeDccCfgNewOriginsEOVO");
    }

    /**
     * Container's getter for XpeDccCfgOgnAssTerminalsEOVO1.
     * @return XpeDccCfgOgnAssTerminalsEOVO1
     */
    public XpeDccCfgOgnAssTerminalsEOVOImpl getXpeDccCfgNewOgnAssTerminalsEOVO() {
        return (XpeDccCfgOgnAssTerminalsEOVOImpl) findViewObject("XpeDccCfgNewOgnAssTerminalsEOVO");
    }

    /**
     * Container's getter for XpeDccCfgOriginsFKVL2.
     * @return XpeDccCfgOriginsFKVL2
     */
    public ViewLinkImpl getXpeDccCfgOriginsFKVL2() {
        return (ViewLinkImpl) findViewLink("XpeDccCfgOriginsFKVL2");
    }

    /**
     * Container's getter for XpeDccCfgPcsEOVO1.
     * @return XpeDccCfgPcsEOVO1
     */
    public XpeDccCfgPcsEOVOImpl getXpeDccCfgNewPcsEOVO() {
        return (XpeDccCfgPcsEOVOImpl) findViewObject("XpeDccCfgNewPcsEOVO");
    }

    /**
     * Container's getter for XpeDccCfgPcsAssTerminalsEOVO1.
     * @return XpeDccCfgPcsAssTerminalsEOVO1
     */
    public XpeDccCfgPcsAssTerminalsEOVOImpl getXpeDccCfgNewPcsAssTerminalsEOVO() {
        return (XpeDccCfgPcsAssTerminalsEOVOImpl) findViewObject("XpeDccCfgNewPcsAssTerminalsEOVO");
    }

    /**
     * Container's getter for XpeDccCfgSitesFKVL2.
     * @return XpeDccCfgSitesFKVL2
     */
    public ViewLinkImpl getXpeDccCfgSitesFKVL2() {
        return (ViewLinkImpl) findViewLink("XpeDccCfgSitesFKVL2");
    }

    /**
     * Container's getter for XpeDccContractSearchROVO1.
     * @return XpeDccContractSearchROVO1
     */
    public XpeDccContractSearchROVOImpl getXpeDccContractSearchROVO() {
        return (XpeDccContractSearchROVOImpl) findViewObject("XpeDccContractSearchROVO");
    }

    /**
     * Container's getter for XpeDccCfgProductserviceEOVO1.
     * @return XpeDccCfgProductserviceEOVO1
     */
    public XpeDccCfgProductserviceEOVOImpl getXpeDccCfgNewProductserviceEOVO() {
        return (XpeDccCfgProductserviceEOVOImpl) findViewObject("XpeDccCfgNewProductserviceEOVO");
    }

    /**
     * Container's getter for XpeDccCfgUomEOVO1.
     * @return XpeDccCfgUomEOVO1
     */
    public XpeDccCfgUomEOVOImpl getXpeDccCfgNewUomEOVO() {
        return (XpeDccCfgUomEOVOImpl) findViewObject("XpeDccCfgNewUomEOVO");
    }

    /**
     * Container's getter for XpeDccCfgUOMFKVL2.
     * @return XpeDccCfgUOMFKVL2
     */
    public ViewLinkImpl getXpeDccCfgUOMFKVL2() {
        return (ViewLinkImpl) findViewLink("XpeDccCfgUOMFKVL2");
    }

    /**
     * Container's getter for XpeDccCfgGeneralEOVO1.
     * @return XpeDccCfgGeneralEOVO1
     */
    public XpeDccCfgGeneralEOVOImpl getXpeDccCfgNewGeneralEOVO() {
        return (XpeDccCfgGeneralEOVOImpl) findViewObject("XpeDccCfgNewGeneralEOVO");
    }

    /**
     * Container's getter for XpeDccCfgPcsshortnamesEOVO1.
     * @return XpeDccCfgPcsshortnamesEOVO1
     */
    public XpeDccCfgPcsshortnamesEOVOImpl getXpeDccCfgNewPcsshortnamesEOVO() {
        return (XpeDccCfgPcsshortnamesEOVOImpl) findViewObject("XpeDccCfgNewPcsshortnamesEOVO");
    }
    
    public void resetQueryResult(String paramVOName, String criteriaName){
        ViewObjectImpl paramVo = (ViewObjectImpl) this.findViewObject(paramVOName);
        ViewCriteria vc = paramVo.getViewCriteria(criteriaName);
        paramVo.removeViewCriteria(criteriaName);
        paramVo.applyViewCriteria(vc);
    }

    /**
     * Container's getter for XpeDccCfgTerminalsSearchROVO1.
     * @return XpeDccCfgTerminalsSearchROVO1
     */
    public XpeDccCfgTerminalsSearchROVOImpl getXpeDccCfgTerminalsSearchROVO1() {
        return (XpeDccCfgTerminalsSearchROVOImpl) findViewObject("XpeDccCfgTerminalsSearchROVO1");
    }
    
    public String addAssTerminalToDestination(){
        String rtnMsg = "SUCCESS";
        XpeDccCfgTerminalsSearchROVOImpl terminalSearchVO = this.getXpeDccCfgTerminalsSearchROVO1();
        XpeDccCfgTerminalsSearchROVORowImpl terminalSearchVORow =
            (XpeDccCfgTerminalsSearchROVORowImpl) terminalSearchVO.getCurrentRow();
        XpeDccCfgDestinationsEOVOImpl destinationVO = this.getXpeDccCfgNewDestinationsCreationEOVO();
        XpeDccCfgDestinationsEOVORowImpl destinationVORow =
            (XpeDccCfgDestinationsEOVORowImpl) destinationVO.getCurrentRow();
        boolean rtn = this.checkDuplicateDestTerminal(destinationVORow.getDestinationId(), terminalSearchVORow.getTerminalId());
        if(!rtn){
            XpeDccCfgDstAssTerminalsEOVOImpl dstAssTermVO = this.getXpeDccCfgNewDstAssTerminalsCreationEOVO();
            XpeDccCfgDstAssTerminalsEOVORowImpl dstAssTermVORow =
                (XpeDccCfgDstAssTerminalsEOVORowImpl) dstAssTermVO.createRow();
            dstAssTermVORow.setTerminalId(terminalSearchVORow.getTerminalId());
            dstAssTermVORow.setTerminalDesc(terminalSearchVORow.getTerminalDesc());
            dstAssTermVORow.setInactive("N");
            dstAssTermVO.insertRow(dstAssTermVORow);
        }else{
            rtnMsg = "DUPLICATE_EXIST";
        }
        return rtnMsg;
    }
    
    public boolean checkDuplicateDestTerminal(String destinationId, String terminalId){
        boolean rtn = false;
        XpeDccCfgDstAssTerminalsROVOImpl dstTerminal = this.getXpeDccCfgDstAssTerminalsROVO1();
        dstTerminal.setApplyViewCriteriaName("findByTerminalIdandDestinationId", false);
        dstTerminal.setNamedWhereClauseParam("bind_DestinationId", destinationId);
        dstTerminal.setNamedWhereClauseParam("bind_TerminalId", terminalId);
        dstTerminal.executeQuery();
        XpeDccCfgDstAssTerminalsROVORowImpl dstTerminalRow = (XpeDccCfgDstAssTerminalsROVORowImpl) dstTerminal.first();
        if(null != dstTerminalRow){
            rtn = true;
        }
        return rtn;
    }
    
    public String addAssTerminalToOrigin(){
        String rtnMsg = "SUCCESS";
        XpeDccCfgTerminalsSearchROVOImpl terminalSearchVO = this.getXpeDccCfgTerminalsSearchROVO1();
        XpeDccCfgTerminalsSearchROVORowImpl terminalSearchVORow =
            (XpeDccCfgTerminalsSearchROVORowImpl) terminalSearchVO.getCurrentRow();
        XpeDccCfgOriginsEOVOImpl originsVO = this.getXpeDccCfgNewOriginsEOVO();
        XpeDccCfgOriginsEOVORowImpl originsVORow = (XpeDccCfgOriginsEOVORowImpl) originsVO.getCurrentRow();
        boolean rtn = this.checkDuplicateOriginTerminal(originsVORow.getOriginId(), terminalSearchVORow.getTerminalId());
        if(!rtn){
            XpeDccCfgOgnAssTerminalsEOVOImpl ognAssTerminalVO = this.getXpeDccCfgNewOgnAssTerminalsEOVO();
            XpeDccCfgOgnAssTerminalsEOVORowImpl ognAssTerminalVORow =
                (XpeDccCfgOgnAssTerminalsEOVORowImpl) ognAssTerminalVO.createRow();
            ognAssTerminalVORow.setTerminalId(terminalSearchVORow.getTerminalId());
            ognAssTerminalVORow.setTerminalDesc(terminalSearchVORow.getTerminalDesc());
            ognAssTerminalVORow.setInactive("N");
            ognAssTerminalVO.insertRow(ognAssTerminalVORow);
        }else{
            rtnMsg = "DUPLICATE_EXIST";
        }
        return rtnMsg;
    }
    
    public boolean checkDuplicateOriginTerminal(String originId, String terminalId){
        boolean rtn = false;
        XpeDccCfgOgnAssTerminalsROVOImpl ognTerminal = this.getXpeDccCfgOgnAssTerminalsROVO1();
        ognTerminal.setApplyViewCriteriaName("findByTerminalIdandOriginId", false);
        ognTerminal.setNamedWhereClauseParam("bind_OriginId", originId);
        ognTerminal.setNamedWhereClauseParam("bind_TerminalId", terminalId);
        ognTerminal.executeQuery();
        XpeDccCfgOgnAssTerminalsROVORowImpl ognTerminalRow = (XpeDccCfgOgnAssTerminalsROVORowImpl) ognTerminal.first();
        if(null != ognTerminalRow){
            rtn = true;
        }
        return rtn;
    }
    
    public String addAssTerminalToPCS(){
        String rtnMsg = "SUCCESS";
        XpeDccCfgTerminalsSearchROVOImpl terminalSearchVO = this.getXpeDccCfgTerminalsSearchROVO1();
        XpeDccCfgTerminalsSearchROVORowImpl terminalSearchVORow =
            (XpeDccCfgTerminalsSearchROVORowImpl) terminalSearchVO.getCurrentRow();
        XpeDccCfgPcsEOVOImpl pcsVO = this.getXpeDccCfgPcsEOVO();
        XpeDccCfgPcsEOVORowImpl pcsVORow = (XpeDccCfgPcsEOVORowImpl) pcsVO.getCurrentRow();
        boolean rtn = this.checkDuplicatePcsSiteTerminal(pcsVORow.getSiteId(), terminalSearchVORow.getTerminalId());
        if(!rtn){
            XpeDccCfgPcsAssTerminalsEOVOImpl pcsAssTerminalVO = this.getXpeDccCfgNewPcsAssTerminalsEOVO();
            XpeDccCfgPcsAssTerminalsEOVORowImpl pcsAssTerminalVORow =
                (XpeDccCfgPcsAssTerminalsEOVORowImpl) pcsAssTerminalVO.createRow();
            pcsAssTerminalVORow.setTerminalId(terminalSearchVORow.getTerminalId());
            pcsAssTerminalVORow.setTerminalDesc(terminalSearchVORow.getTerminalDesc());
            pcsAssTerminalVORow.setInactive("N");
            pcsAssTerminalVO.insertRow(pcsAssTerminalVORow);
        }else{
            rtnMsg = "DUPLICATE_EXIST";
        }
        return rtnMsg;
    }
    
    public boolean checkDuplicatePcsSiteTerminal(String siteId, String terminalId){
        boolean rtn = false;
        XpeDccCfgPcsAssTerminalsROVOImpl pcsTerminal = this.getXpeDccCfgPcsAssTerminalsROVO1();
        pcsTerminal.setApplyViewCriteriaName("findByTerminalIdandSiteId", false);
        pcsTerminal.setNamedWhereClauseParam("bind_SiteId", siteId);
        pcsTerminal.setNamedWhereClauseParam("bind_TerminalId", terminalId);
        pcsTerminal.executeQuery();
        XpeDccCfgPcsAssTerminalsROVORowImpl pcsTerminalRow = (XpeDccCfgPcsAssTerminalsROVORowImpl) pcsTerminal.first();
        if(null != pcsTerminalRow){
            rtn = true;
        }
        return rtn;  
    }

    /**
     * Container's getter for XpeDccCfgDstAssTerminalsROVO1.
     * @return XpeDccCfgDstAssTerminalsROVO1
     */
    public XpeDccCfgDstAssTerminalsROVOImpl getXpeDccCfgDstAssTerminalsROVO1() {
        return (XpeDccCfgDstAssTerminalsROVOImpl) findViewObject("XpeDccCfgDstAssTerminalsROVO1");
    }

    /**
     * Container's getter for XpeDccCfgOgnAssTerminalsROVO1.
     * @return XpeDccCfgOgnAssTerminalsROVO1
     */
    public XpeDccCfgOgnAssTerminalsROVOImpl getXpeDccCfgOgnAssTerminalsROVO1() {
        return (XpeDccCfgOgnAssTerminalsROVOImpl) findViewObject("XpeDccCfgOgnAssTerminalsROVO1");
    }

    /**
     * Container's getter for XpeDccCfgPcsAssTerminalsROVO1.
     * @return XpeDccCfgPcsAssTerminalsROVO1
     */
    public XpeDccCfgPcsAssTerminalsROVOImpl getXpeDccCfgPcsAssTerminalsROVO1() {
        return (XpeDccCfgPcsAssTerminalsROVOImpl) findViewObject("XpeDccCfgPcsAssTerminalsROVO1");
    }

    /**
     * Container's getter for XpeDccCfgGeneralCnvEOVO1.
     * @return XpeDccCfgGeneralCnvEOVO1
     */
    public XpeDccCfgGeneralCnvEOVOImpl getXpeDccCfgNewGeneralCnvEOVO() {
        return (XpeDccCfgGeneralCnvEOVOImpl) findViewObject("XpeDccCfgNewGeneralCnvEOVO");
    }

    /**
     * Container's getter for XpeDccTermsContractEOVO1.
     * @return XpeDccTermsContractEOVO1
     */
    public XpeDccTermsContractEOVOImpl getXpeDccTermsContractEOVO() {
        return (XpeDccTermsContractEOVOImpl) findViewObject("XpeDccTermsContractEOVO");
    }

    /**
     * Container's getter for XpeDccTermsContractFKVL1.
     * @return XpeDccTermsContractFKVL1
     */
    public ViewLinkImpl getXpeDccTermsContractFKVL1() {
        return (ViewLinkImpl) findViewLink("XpeDccTermsContractFKVL1");
    }

    /**
     * Container's getter for XpeDccWfEventEOVO1.
     * @return XpeDccWfEventEOVO1
     */
    public XpeDccWfEventEOVOImpl getXpeDccWfEventEOVO() {
        return (XpeDccWfEventEOVOImpl) findViewObject("XpeDccWfEventEOVO");
    }

    /**
     * Container's getter for XpeDccWfActionEOVO1.
     * @return XpeDccWfActionEOVO1
     */
    public XpeDccWfActionEOVOImpl getXpeDccWfActionEOVO() {
        return (XpeDccWfActionEOVOImpl) findViewObject("XpeDccWfActionEOVO");
    }

    /**
     * Container's getter for XpeDccWfActionFKVL1.
     * @return XpeDccWfActionFKVL1
     */
    public ViewLinkImpl getXpeDccWfActionFKVL1() {
        return (ViewLinkImpl) findViewLink("XpeDccWfActionFKVL1");
    }
    
    /**
     * Container's getter for XpeDccContractPricingOverView1.
     * @return XpeDccContractPricingOverView1
     */
    public XpeDccContractPricingOverViewImpl getXpeDccContractPricingOverView1() {
        return (XpeDccContractPricingOverViewImpl) findViewObject("XpeDccContractPricingOverView1");
    }

    /**
     * Container's getter for XpeDccContractPricingFk2Link1.
     * @return XpeDccContractPricingFk2Link1
     */
    public ViewLinkImpl getXpeDccContractPricingFk2Link1() {
        return (ViewLinkImpl) findViewLink("XpeDccContractPricingFk2Link1");
    }

    /**
     * Container's getter for XpeDccContractPricingOverView2.
     * @return XpeDccContractPricingOverView2
     */
    public XpeDccContractPricingOverViewImpl getXpeDccNewContractPricingOverView() {
        return (XpeDccContractPricingOverViewImpl) findViewObject("XpeDccNewContractPricingOverView");
    }

    /**
     * Container's getter for XpeDccContractPricingFk2Link2.
     * @return XpeDccContractPricingFk2Link2
     */
    public ViewLinkImpl getXpeDccContractPricingFk2Link2() {
        return (ViewLinkImpl) findViewLink("XpeDccContractPricingFk2Link2");
    }

    /**
     * Container's getter for XpeDccWfActionROVO1.
     * @return XpeDccWfActionROVO1
     */
    public XpeDccWfActionROVOImpl getXpeDccWfActionROVO() {
        return (XpeDccWfActionROVOImpl) findViewObject("XpeDccWfActionROVO");
    }


    /**
     * Container's getter for XpeBillAccountProcessesEOVO2.
     * @return XpeBillAccountProcessesEOVO2
     */
    public ViewObjectImpl getXpeNewBillAccountProcessesEOVO() {
        return (ViewObjectImpl) findViewObject("XpeNewBillAccountProcessesEOVO");
    }

    /**
     * Container's getter for XpeDccCfgAccountingEOVO1.
     * @return XpeDccCfgAccountingEOVO1
     */
    public XpeDccCfgAccountingEOVOImpl getXpeDccCfgNewAccountingEOVO() {
        return (XpeDccCfgAccountingEOVOImpl) findViewObject("XpeDccCfgNewAccountingEOVO");
    }

    /**
     * Container's getter for XpeDccCfgBillingandAccountingROVO1.
     * @return XpeDccCfgBillingandAccountingROVO1
     */
    public XpeDccCfgBillingandAccountingROVOImpl getXpeDccCfgBillingandAccountingROVO1() {
        return (XpeDccCfgBillingandAccountingROVOImpl) findViewObject("XpeDccCfgBillingandAccountingROVO1");
    }
    
    public void initBillAccountProcess(){
        XpeDccCfgBillingandAccountingROVOImpl billAccountVO = this.getXpeDccCfgBillingandAccountingROVO1();
        billAccountVO.executeEmptyRowSet();
        XpeDccCfgBillingandAccountingROVORowImpl billAccountVORow =
            (XpeDccCfgBillingandAccountingROVORowImpl) billAccountVO.createRow();
        billAccountVO.insertRow(billAccountVORow);
    }
    
    public void billAndAccountingProcess(){
        XpeDccCfgBillingandAccountingROVOImpl billAccountVO = this.getXpeDccCfgBillingandAccountingROVO1();
        RowSetIterator billAccountRSet = billAccountVO.createRowSetIterator(null);
        billAccountRSet.reset();
        while(billAccountRSet.hasNext()){
            XpeDccCfgBillingandAccountingROVORowImpl billAccountVORow =
                (XpeDccCfgBillingandAccountingROVORowImpl) billAccountRSet.next();
        }
        this.initBillAccountProcess();
    }
    
    public void initAccrualRevenueGeneration(){
        XpeDccCfgAccrualandRevenueGenerationROVOImpl accrualRevenueVO = this.getXpeDccCfgAccrualandRevenueGenerationROVO1();
        accrualRevenueVO.executeEmptyRowSet();
        XpeDccCfgAccrualandRevenueGenerationROVORowImpl accrualRevenueVORow =
            (XpeDccCfgAccrualandRevenueGenerationROVORowImpl) accrualRevenueVO.createRow();
        accrualRevenueVO.insertRow(accrualRevenueVORow);
    }
    
    public void accrualandRevenueGenerationProcesses(){
        XpeDccCfgAccrualandRevenueGenerationROVOImpl accrualRevenueVO = this.getXpeDccCfgAccrualandRevenueGenerationROVO1();
        RowSetIterator AccrualRevenueRSetIter =  accrualRevenueVO.createRowSetIterator(null);
        AccrualRevenueRSetIter.reset();
        while(AccrualRevenueRSetIter.hasNext()){
        XpeDccCfgAccrualandRevenueGenerationROVORowImpl accrualRevenueVORow =
                (XpeDccCfgAccrualandRevenueGenerationROVORowImpl) AccrualRevenueRSetIter.next();
        }
        this.initAccrualRevenueGeneration();
    }

    /**
     * Container's getter for XpeDccCfgMswFacilityEOVO1.
     * @return XpeDccCfgMswFacilityEOVO1
     */
    public XpeDccCfgMswFacilityEOVOImpl getXpeDccCfgMswFacilityEOVO1() {
        return (XpeDccCfgMswFacilityEOVOImpl) findViewObject("XpeDccCfgMswFacilityEOVO1");
    }

    /**
     * Container's getter for XpeDccCfgCmtmntFacilityEOVO1.
     * @return XpeDccCfgCmtmntFacilityEOVO1
     */
    public XpeDccCfgCmtmntFacilityEOVOImpl getXpeDccCfgCmtmntFacilityEOVO1() {
        return (XpeDccCfgCmtmntFacilityEOVOImpl) findViewObject("XpeDccCfgCmtmntFacilityEOVO1");
    }

    /**
     * Container's getter for XpeDccCfgMetalsFacilityEOVO1.
     * @return XpeDccCfgMetalsFacilityEOVO1
     */
    public XpeDccCfgMetalsFacilityEOVOImpl getXpeDccCfgMetalsFacilityEOVO1() {
        return (XpeDccCfgMetalsFacilityEOVOImpl) findViewObject("XpeDccCfgMetalsFacilityEOVO1");
    }

    /**
     * Container's getter for XpeDccCfgCntrcttAprFcltyROVO1.
     * @return XpeDccCfgCntrcttAprFcltyROVO1
     */
    public XpeDccCfgCntrcttAprFcltyROVOImpl getXpeDccCfgCntrcttAprFcltyROVO1() {
        return (XpeDccCfgCntrcttAprFcltyROVOImpl) findViewObject("XpeDccCfgCntrcttAprFcltyROVO1");
    }
    
    public void initCntrctAprFcltySetUp(){
        XpeDccCfgCntrcttAprFcltyROVOImpl cntrctAprFcltyVO = this.getXpeDccCfgCntrcttAprFcltyROVO1();
        cntrctAprFcltyVO.executeEmptyRowSet();
        XpeDccCfgCntrcttAprFcltyROVORowImpl cntrctAprFcltyVORow =
            (XpeDccCfgCntrcttAprFcltyROVORowImpl) cntrctAprFcltyVO.createRow();
        cntrctAprFcltyVO.insertRow(cntrctAprFcltyVORow);
    }
    
    public void resetCntrctAprFcltySetUp() {
        this.initCntrctAprFcltySetUp();
        XpeDccCfgMswFacilityEOVOImpl mswFacilityVo = this.getXpeDccCfgMswFacilityEOVO1();
        mswFacilityVo.setApplyViewCriteriaName("findByFacilityId", false);
        mswFacilityVo.setNamedWhereClauseParam("bind_FacilityId", null);
        mswFacilityVo.executeQuery();
        XpeDccCfgCmtmntFacilityEOVOImpl cmtmntFacilityVo = this.getXpeDccCfgCmtmntFacilityEOVO1();
        cmtmntFacilityVo.setApplyViewCriteriaName("findByFacilityId", false);
        cmtmntFacilityVo.setNamedWhereClauseParam("bind_FacilityId", null);
        cmtmntFacilityVo.executeQuery();
        XpeDccCfgMetalsFacilityEOVOImpl metalsFacilityVo = this.getXpeDccCfgMetalsFacilityEOVO1();
        metalsFacilityVo.setApplyViewCriteriaName("findByFacilityId", false);
        metalsFacilityVo.setNamedWhereClauseParam("bind_FacilityId", null);
        metalsFacilityVo.executeQuery();
    }
    
    public void searchCntrctAprFcltySetUp(String type) {
        XpeDccCfgCntrcttAprFcltyROVOImpl cntrctAprFcltyVO = this.getXpeDccCfgCntrcttAprFcltyROVO1();
        XpeDccCfgCntrcttAprFcltyROVORowImpl cntrctAprFcltyVORow =
            (XpeDccCfgCntrcttAprFcltyROVORowImpl) cntrctAprFcltyVO.getCurrentRow();
        if (null != cntrctAprFcltyVORow) {
            XpeDccCfgMswFacilityEOVOImpl mswFacilityVo = this.getXpeDccCfgMswFacilityEOVO1();
            XpeDccCfgCmtmntFacilityEOVOImpl cmtmntFacilityVo = this.getXpeDccCfgCmtmntFacilityEOVO1();
            XpeDccCfgMetalsFacilityEOVOImpl metalsFacilityVo = this.getXpeDccCfgMetalsFacilityEOVO1();
            XpeDccCfgSpclWasteFcltyEOVOImpl spclWstFcltyVo =  this.getXpeDccCfgSpclWasteFcltyEOVO1();
            if (null != type && "MSW".equals(type) && null != cntrctAprFcltyVORow.getXpeFacilityId()) {
                mswFacilityVo.setApplyViewCriteriaName("findByFacilityId", false);
                mswFacilityVo.setNamedWhereClauseParam("bind_FacilityId", cntrctAprFcltyVORow.getXpeFacilityId());
                mswFacilityVo.executeQuery();
            } else if (null != type && "MSW".equals(type)) {
                mswFacilityVo.setApplyViewCriteriaName(null);
                mswFacilityVo.executeQuery();
            }
            if (null != type && "CMTMNT".equals(type) && null != cntrctAprFcltyVORow.getXpeFacilityId()) {
                cmtmntFacilityVo.setApplyViewCriteriaName("findByFacilityId", false);
                cmtmntFacilityVo.setNamedWhereClauseParam("bind_FacilityId", cntrctAprFcltyVORow.getXpeFacilityId());
                cmtmntFacilityVo.executeQuery();
            } else if (null != type && "CMTMNT".equals(type)) {
                cmtmntFacilityVo.setApplyViewCriteriaName(null);
                cmtmntFacilityVo.executeQuery();
            }
            if (null != type && "MTL".equals(type) && null != cntrctAprFcltyVORow.getXpeFacilityId()) {
                metalsFacilityVo.setApplyViewCriteriaName("findByFacilityId", false);
                metalsFacilityVo.setNamedWhereClauseParam("bind_FacilityId", cntrctAprFcltyVORow.getXpeFacilityId());
                metalsFacilityVo.executeQuery();
            } else if (null != type && "MTL".equals(type)) {
                metalsFacilityVo.setApplyViewCriteriaName(null);
                metalsFacilityVo.executeQuery();
            }
            if(null != type && "SW".equals(type) && null != cntrctAprFcltyVORow.getXpeFacilityId()){
                spclWstFcltyVo.setApplyViewCriteriaName("findByFacilityId", false);
                spclWstFcltyVo.setNamedWhereClauseParam("bind_facilityId", cntrctAprFcltyVORow.getXpeFacilityId());
                spclWstFcltyVo.executeQuery();
            } else if (null != type && "SW".equals(type)){
                spclWstFcltyVo.setApplyViewCriteriaName(null);
                spclWstFcltyVo.executeQuery();
            }
        }
    }

    /**
     * Container's getter for XpeDccCfgMswFacilityEOVO2.
     * @return XpeDccCfgMswFacilityEOVO2
     */
    public XpeDccCfgMswFacilityEOVOImpl getXpeDccCfgNewMswFacilityEOVO() {
        return (XpeDccCfgMswFacilityEOVOImpl) findViewObject("XpeDccCfgNewMswFacilityEOVO");
    }

    /**
     * Container's getter for XpeDccCfgCmtmntFacilityEOVO2.
     * @return XpeDccCfgCmtmntFacilityEOVO2
     */
    public XpeDccCfgCmtmntFacilityEOVOImpl getXpeDccCfgNewCmtmntFacilityEOVO() {
        return (XpeDccCfgCmtmntFacilityEOVOImpl) findViewObject("XpeDccCfgNewCmtmntFacilityEOVO");
    }

    /**
     * Container's getter for XpeDccCfgMetalsFacilityEOVO2.
     * @return XpeDccCfgMetalsFacilityEOVO2
     */
    public XpeDccCfgMetalsFacilityEOVOImpl getXpeDccCfgNewMetalsFacilityEOVO() {
        return (XpeDccCfgMetalsFacilityEOVOImpl) findViewObject("XpeDccCfgNewMetalsFacilityEOVO");
    }

    /**
     * Container's getter for XpeDccCfgBusinessunitEOVO1.
     * @return XpeDccCfgBusinessunitEOVO1
     */
    public XpeDccCfgBusinessunitEOVOImpl getXpeDccCfgNewBusinessunitEOVO() {
        return (XpeDccCfgBusinessunitEOVOImpl) findViewObject("XpeDccCfgNewBusinessunitEOVO");
    }

    /**
     * Container's getter for XpeDccNewContractCustomerSearchROVO1.
     * @return XpeDccNewContractCustomerSearchROVO1
     */
    public XpeDccNewContractCustomerSearchROVOImpl getXpeDccNewContractCustomerSearchROVO1() {
        return (XpeDccNewContractCustomerSearchROVOImpl) findViewObject("XpeDccNewContractCustomerSearchROVO1");
    }

    /**
     * Container's getter for XpeDmsCustomerROVO1.
     * @return XpeDmsCustomerROVO1
     */
    public XpeDmsCustomerROVOImpl getXpeDmsCustomerROVO() {
        return (XpeDmsCustomerROVOImpl) findViewObject("XpeDmsCustomerROVO");
    }
    /**
     * Container's getter for XpeDccCfgNotificationEOVO1.
     * @return XpeDccCfgNotificationEOVO1
     */
    public XpeDccCfgNotificationEOVOImpl getXpeDccCfgNotificationEOVO1() {
        return (XpeDccCfgNotificationEOVOImpl) findViewObject("XpeDccCfgNotificationEOVO1");
    }

    /**
     * Container's getter for XpeDccCfgNotifGroupsEOVO1.
     * @return XpeDccCfgNotifGroupsEOVO1
     */
    public XpeDccCfgNotifGroupsEOVOImpl getXpeDccCfgNotifGroupsEOVO1() {
        return (XpeDccCfgNotifGroupsEOVOImpl) findViewObject("XpeDccCfgNotifGroupsEOVO1");
    }

    /**
     * Container's getter for NotificationFkLink1.
     * @return NotificationFkLink1
     */
    public ViewLinkImpl getNotificationFkLink1() {
        return (ViewLinkImpl) findViewLink("NotificationFkLink1");
    }

    /**
     * Container's getter for XpeDccCfgNotificationEOVO2.
     * @return XpeDccCfgNotificationEOVO2
     */
    public XpeDccCfgNotificationEOVOImpl getXpeDccCfgNewNotificationEOVO() {
        return (XpeDccCfgNotificationEOVOImpl) findViewObject("XpeDccCfgNewNotificationEOVO");
    }

    /**
     * Container's getter for XpeDccCfgNotifGroupsEOVO2.
     * @return XpeDccCfgNotifGroupsEOVO2
     */
    public XpeDccCfgNotifGroupsEOVOImpl getXpeDccCfgNewNotifGroupsEOVO() {
        return (XpeDccCfgNotifGroupsEOVOImpl) findViewObject("XpeDccCfgNewNotifGroupsEOVO");
    }

    /**
     * Container's getter for NotificationFkLink2.
     * @return NotificationFkLink2
     */
    public ViewLinkImpl getNotificationFkLink2() {
        return (ViewLinkImpl) findViewLink("NotificationFkLink2");
    }

    /**
     * Container's getter for XpeDccNewContractsEOVO1.
     * @return XpeDccNewContractsEOVO1
     */
    public XpeDccNewContractsEOVOImpl getXpeDccNewContractsEOVO1() {
        return (XpeDccNewContractsEOVOImpl) findViewObject("XpeDccNewContractsEOVO1");
    }

    /**
     * Container's getter for XpeDccContractVersionView3.
     * @return XpeDccContractVersionView3
     */
    public XpeDccContractVersionViewImpl getXpeDccContractVersionView3() {
        return (XpeDccContractVersionViewImpl) findViewObject("XpeDccContractVersionView3");
    }

    /**
     * Container's getter for XpeDccContractVersionFKVL1.
     * @return XpeDccContractVersionFKVL1
     */
    public ViewLinkImpl getXpeDccContractVersionFKVL1() {
        return (ViewLinkImpl) findViewLink("XpeDccContractVersionFKVL1");
    }

    /**
     * Container's getter for XpeDccCfgAccrualandRevenueGenerationROVO1.
     * @return XpeDccCfgAccrualandRevenueGenerationROVO1
     */
    public XpeDccCfgAccrualandRevenueGenerationROVOImpl getXpeDccCfgAccrualandRevenueGenerationROVO1() {
        return (XpeDccCfgAccrualandRevenueGenerationROVOImpl) findViewObject("XpeDccCfgAccrualandRevenueGenerationROVO1");
    }

    /**
     * Container's getter for XpeDccContractPricingOverView2.
     * @return XpeDccContractPricingOverView2
     */
    public XpeDccContractPricingOverViewImpl getXpeDccContractPricingOverView2() {
        return (XpeDccContractPricingOverViewImpl) findViewObject("XpeDccContractPricingOverView2");
    }

    /**
     * Container's getter for XpeDccContractPricingFk2Link3.
     * @return XpeDccContractPricingFk2Link3
     */
    public ViewLinkImpl getXpeDccContractPricingFk2Link3() {
        return (ViewLinkImpl) findViewLink("XpeDccContractPricingFk2Link3");
    }

    /**
     * Container's getter for XpeDccCfgPcsAddressROVO1.
     * @return XpeDccCfgPcsAddressROVO1
     */
    public XpeDccCfgPcsAddressROVOImpl getXpeDccCfgPcsAddressROVO() {
        return (XpeDccCfgPcsAddressROVOImpl) findViewObject("XpeDccCfgPcsAddressROVO");
    }

    /**
     * Container's getter for XpeDCCCustContractShortNameROVO.
     * @return XpeDccCustContractShortNameROVO1
     */
    public XpeDccCustContractShortNameROVOImpl getXpeDccCustContractShortNameROVO() {
        return (XpeDccCustContractShortNameROVOImpl) findViewObject("XpeDccCustContractShortNameROVO");
    }

    /**
     * Container's getter for XpeDccCfgNycDosTermCustEOVO1.
     * @return XpeDccCfgNycDosTermCustEOVO1
     */
    public XpeDccCfgNycDosTermCustEOVOImpl getXpeDccCfgNycDosTermCustEOVO() {
        return (XpeDccCfgNycDosTermCustEOVOImpl) findViewObject("XpeDccCfgNycDosTermCustEOVO");
    }

    /**
     * Container's getter for XpeDccCfgNycDosTermCustFKVL1.
     * @return XpeDccCfgNycDosTermCustFKVL1
     */
    public ViewLinkImpl getNew() {
        return (ViewLinkImpl) findViewLink("New");
    }

    /**
     * Container's getter for XpeDccCfgNycDosTermCustFKVL1.
     * @return XpeDccCfgNycDosTermCustFKVL1
     */
    public ViewLinkImpl getXpeDccCfgNycDosTermCustFKVL1() {
        return (ViewLinkImpl) findViewLink("XpeDccCfgNycDosTermCustFKVL1");
    }

    /**
     * Container's getter for XpeDccCfgNycDosTermCustEOVO1.
     * @return XpeDccCfgNycDosTermCustEOVO1
     */
    public XpeDccCfgNycDosTermCustEOVOImpl getXpeDccCfgNewNycDosTermCustEOVO() {
        return (XpeDccCfgNycDosTermCustEOVOImpl) findViewObject("XpeDccCfgNewNycDosTermCustEOVO");
    }

    /**
     * Container's getter for XpeDccCfgNycDosTermCustFKVL2.
     * @return XpeDccCfgNycDosTermCustFKVL2
     */
    public ViewLinkImpl getXpeDccCfgNycDosTermCustFKVL2() {
        return (ViewLinkImpl) findViewLink("XpeDccCfgNycDosTermCustFKVL2");
    }

    /**
     * Container's getter for XpeDccWfEventEOVO1.
     * @return XpeDccWfEventEOVO1
     */
    public XpeDccWfEventEOVOImpl getXpeDccWfEventEOVO1() {
        return (XpeDccWfEventEOVOImpl) findViewObject("XpeDccWfEventEOVO1");
    }

    /**
     * Container's getter for XpeDccWfEventFKVL1.
     * @return XpeDccWfEventFKVL1
     */
    public ViewLinkImpl getXpeDccWfEventFKVL1() {
        return (ViewLinkImpl) findViewLink("XpeDccWfEventFKVL1");
    }

    /**
     * Container's getter for XpeDccWfActionEOVO1.
     * @return XpeDccWfActionEOVO1
     */
    public XpeDccWfActionEOVOImpl getXpeDccWfActionEOVO1() {
        return (XpeDccWfActionEOVOImpl) findViewObject("XpeDccWfActionEOVO1");
    }

    /**
     * Container's getter for XpeDccWfActionFKVL2.
     * @return XpeDccWfActionFKVL2
     */
    public ViewLinkImpl getXpeDccWfActionFKVL2() {
        return (ViewLinkImpl) findViewLink("XpeDccWfActionFKVL2");
    }

    /**
     * Container's getter for XpeDccWfEventEOVO2.
     * @return XpeDccWfEventEOVO2
     */
    public XpeDccWfEventEOVOImpl getXpeDccWfEventEOVO2() {
        return (XpeDccWfEventEOVOImpl) findViewObject("XpeDccWfEventEOVO2");
    }

    /**
     * Container's getter for XpeDccWfEventFKVL2.
     * @return XpeDccWfEventFKVL2
     */
    public ViewLinkImpl getXpeDccWfEventFKVL2() {
        return (ViewLinkImpl) findViewLink("XpeDccWfEventFKVL2");
    }

    /**
     * Container's getter for XpeDccWfActionEOVO2.
     * @return XpeDccWfActionEOVO2
     */
    public XpeDccWfActionEOVOImpl getXpeDccWfActionEOVO2() {
        return (XpeDccWfActionEOVOImpl) findViewObject("XpeDccWfActionEOVO2");
    }

    /**
     * Container's getter for XpeDccWfActionFKVL3.
     * @return XpeDccWfActionFKVL3
     */
    public ViewLinkImpl getXpeDccWfActionFKVL3() {
        return (ViewLinkImpl) findViewLink("XpeDccWfActionFKVL3");
    }

    /**
     * Container's getter for XpeDccCfgSpclWasteFcltyEOVO1.
     * @return XpeDccCfgSpclWasteFcltyEOVO1
     */
    public XpeDccCfgSpclWasteFcltyEOVOImpl getXpeDccCfgSpclWasteFcltyEOVO1() {
        return (XpeDccCfgSpclWasteFcltyEOVOImpl) findViewObject("XpeDccCfgSpclWasteFcltyEOVO1");
    }

    /**
     * Container's getter for XpeDccCfgSpclWasteFcltyEOVO2.
     * @return XpeDccCfgSpclWasteFcltyEOVO2
     */
    public XpeDccCfgSpclWasteFcltyEOVOImpl getXpeDccCfgNewSpclWasteFcltyEOVO() {
        return (XpeDccCfgSpclWasteFcltyEOVOImpl) findViewObject("XpeDccCfgNewSpclWasteFcltyEOVO");
    }
}

