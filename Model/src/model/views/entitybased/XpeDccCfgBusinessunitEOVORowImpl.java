package model.views.entitybased;

import java.math.BigDecimal;

import java.sql.Timestamp;

import model.entities.XpeDccCfgBusinessunitEOImpl;

import oracle.jbo.RowSet;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Nov 01 09:46:58 EDT 2017
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class XpeDccCfgBusinessunitEOVORowImpl extends ViewRowImpl {


    public static final int ENTITY_XPEDCCCFGBUSINESSUNITEO = 0;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        BusinessUnit,
        SiteId,
        TerminalId,
        AccountingClass,
        Affliate,
        BillingBusinessUnit,
        BusinessUnitRef,
        GlBusinessUnit,
        Inactive,
        InactiveDate,
        OperatingUnit,
        SiteDesc,
        StatsOnly,
        CreatedBy,
        CreatedDate,
        LastUpdatedBy,
        LastUpdatedDate,
        BillingGlBusinessUnit,
        BillingOperatingUnit,
        BillingAffiliate,
        BusinessunitId,
        XpeDccCfgTerminals_LOV,
        XpeDccCfgPCSShortNames_LOV,
        XpeDccGeneralItemList_ACLOV,
        LookupSharedAppModule_YONLOV,
        XpeDccCfgPcsAssTerminalsROVO1,
        XpeDccCfgPcsROVO1,
        PsBusUnitTblBiROVO1,
        PsOperUnitTblROVO1,
        PsOperUnitTblROVO2,
        PsBusUnitTblFsROVO1,
        PsBusUnitTblFsROVO2,
        PsBusUnitTblFsROVO3,
        PsBusUnitTblFsROVO4,
        PsBusUnitTblFsROVO5,
        PsPlantBURefROVO_LOV,
        XpeDccGeneralItemListROVO1,
        PsBusUnitTblBiROVO2;
        static AttributesEnum[] vals = null;
        ;
        private static final int firstIndex = 0;

        public int index() {
            return AttributesEnum.firstIndex() + ordinal();
        }

        public static final int firstIndex() {
            return firstIndex;
        }

        public static int count() {
            return AttributesEnum.firstIndex() + AttributesEnum.staticValues().length;
        }

        public static final AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = AttributesEnum.values();
            }
            return vals;
        }
    }


    public static final int BUSINESSUNIT = AttributesEnum.BusinessUnit.index();
    public static final int SITEID = AttributesEnum.SiteId.index();
    public static final int TERMINALID = AttributesEnum.TerminalId.index();
    public static final int ACCOUNTINGCLASS = AttributesEnum.AccountingClass.index();
    public static final int AFFLIATE = AttributesEnum.Affliate.index();
    public static final int BILLINGBUSINESSUNIT = AttributesEnum.BillingBusinessUnit.index();
    public static final int BUSINESSUNITREF = AttributesEnum.BusinessUnitRef.index();
    public static final int GLBUSINESSUNIT = AttributesEnum.GlBusinessUnit.index();
    public static final int INACTIVE = AttributesEnum.Inactive.index();
    public static final int INACTIVEDATE = AttributesEnum.InactiveDate.index();
    public static final int OPERATINGUNIT = AttributesEnum.OperatingUnit.index();
    public static final int SITEDESC = AttributesEnum.SiteDesc.index();
    public static final int STATSONLY = AttributesEnum.StatsOnly.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int CREATEDDATE = AttributesEnum.CreatedDate.index();
    public static final int LASTUPDATEDBY = AttributesEnum.LastUpdatedBy.index();
    public static final int LASTUPDATEDDATE = AttributesEnum.LastUpdatedDate.index();
    public static final int BILLINGGLBUSINESSUNIT = AttributesEnum.BillingGlBusinessUnit.index();
    public static final int BILLINGOPERATINGUNIT = AttributesEnum.BillingOperatingUnit.index();
    public static final int BILLINGAFFILIATE = AttributesEnum.BillingAffiliate.index();
    public static final int BUSINESSUNITID = AttributesEnum.BusinessunitId.index();
    public static final int XPEDCCCFGTERMINALS_LOV = AttributesEnum.XpeDccCfgTerminals_LOV.index();
    public static final int XPEDCCCFGPCSSHORTNAMES_LOV = AttributesEnum.XpeDccCfgPCSShortNames_LOV.index();
    public static final int XPEDCCGENERALITEMLIST_ACLOV = AttributesEnum.XpeDccGeneralItemList_ACLOV.index();
    public static final int LOOKUPSHAREDAPPMODULE_YONLOV = AttributesEnum.LookupSharedAppModule_YONLOV.index();
    public static final int XPEDCCCFGPCSASSTERMINALSROVO1 = AttributesEnum.XpeDccCfgPcsAssTerminalsROVO1.index();
    public static final int XPEDCCCFGPCSROVO1 = AttributesEnum.XpeDccCfgPcsROVO1.index();
    public static final int PSBUSUNITTBLBIROVO1 = AttributesEnum.PsBusUnitTblBiROVO1.index();
    public static final int PSOPERUNITTBLROVO1 = AttributesEnum.PsOperUnitTblROVO1.index();
    public static final int PSOPERUNITTBLROVO2 = AttributesEnum.PsOperUnitTblROVO2.index();
    public static final int PSBUSUNITTBLFSROVO1 = AttributesEnum.PsBusUnitTblFsROVO1.index();
    public static final int PSBUSUNITTBLFSROVO2 = AttributesEnum.PsBusUnitTblFsROVO2.index();
    public static final int PSBUSUNITTBLFSROVO3 = AttributesEnum.PsBusUnitTblFsROVO3.index();
    public static final int PSBUSUNITTBLFSROVO4 = AttributesEnum.PsBusUnitTblFsROVO4.index();
    public static final int PSBUSUNITTBLFSROVO5 = AttributesEnum.PsBusUnitTblFsROVO5.index();
    public static final int PSPLANTBUREFROVO_LOV = AttributesEnum.PsPlantBURefROVO_LOV.index();
    public static final int XPEDCCGENERALITEMLISTROVO1 = AttributesEnum.XpeDccGeneralItemListROVO1.index();
    public static final int PSBUSUNITTBLBIROVO2 = AttributesEnum.PsBusUnitTblBiROVO2.index();

    /**
     * This is the default constructor (do not remove).
     */
    public XpeDccCfgBusinessunitEOVORowImpl() {
    }

    /**
     * Gets XpeDccCfgBusinessunitEO entity object.
     * @return the XpeDccCfgBusinessunitEO
     */
    public XpeDccCfgBusinessunitEOImpl getXpeDccCfgBusinessunitEO() {
        return (XpeDccCfgBusinessunitEOImpl) getEntity(ENTITY_XPEDCCCFGBUSINESSUNITEO);
    }

    /**
     * Gets the attribute value for SITE_ID using the alias name SiteId.
     * @return the SITE_ID
     */
    public String getSiteId() {
        return (String) getAttributeInternal(SITEID);
    }

    /**
     * Sets <code>value</code> as attribute value for SITE_ID using the alias name SiteId.
     * @param value value to set the SITE_ID
     */
    public void setSiteId(String value) {
        setAttributeInternal(SITEID, value);
    }

    /**
     * Gets the attribute value for TERMINAL_ID using the alias name TerminalId.
     * @return the TERMINAL_ID
     */
    public String getTerminalId() {
        return (String) getAttributeInternal(TERMINALID);
    }

    /**
     * Sets <code>value</code> as attribute value for TERMINAL_ID using the alias name TerminalId.
     * @param value value to set the TERMINAL_ID
     */
    public void setTerminalId(String value) {
        setAttributeInternal(TERMINALID, value);
    }

    /**
     * Gets the attribute value for BUSINESS_UNIT using the alias name BusinessUnit.
     * @return the BUSINESS_UNIT
     */
    public String getBusinessUnit() {
        return (String) getAttributeInternal(BUSINESSUNIT);
    }

    /**
     * Sets <code>value</code> as attribute value for BUSINESS_UNIT using the alias name BusinessUnit.
     * @param value value to set the BUSINESS_UNIT
     */
    public void setBusinessUnit(String value) {
        setAttributeInternal(BUSINESSUNIT, value);
    }

    /**
     * Gets the attribute value for ACCOUNTING_CLASS using the alias name AccountingClass.
     * @return the ACCOUNTING_CLASS
     */
    public String getAccountingClass() {
        return (String) getAttributeInternal(ACCOUNTINGCLASS);
    }

    /**
     * Sets <code>value</code> as attribute value for ACCOUNTING_CLASS using the alias name AccountingClass.
     * @param value value to set the ACCOUNTING_CLASS
     */
    public void setAccountingClass(String value) {
        setAttributeInternal(ACCOUNTINGCLASS, value);
    }

    /**
     * Gets the attribute value for AFFLIATE using the alias name Affliate.
     * @return the AFFLIATE
     */
    public String getAffliate() {
        return (String) getAttributeInternal(AFFLIATE);
    }

    /**
     * Sets <code>value</code> as attribute value for AFFLIATE using the alias name Affliate.
     * @param value value to set the AFFLIATE
     */
    public void setAffliate(String value) {
        setAttributeInternal(AFFLIATE, value);
    }

    /**
     * Gets the attribute value for BILLING_BUSINESS_UNIT using the alias name BillingBusinessUnit.
     * @return the BILLING_BUSINESS_UNIT
     */
    public String getBillingBusinessUnit() {
        return (String) getAttributeInternal(BILLINGBUSINESSUNIT);
    }

    /**
     * Sets <code>value</code> as attribute value for BILLING_BUSINESS_UNIT using the alias name BillingBusinessUnit.
     * @param value value to set the BILLING_BUSINESS_UNIT
     */
    public void setBillingBusinessUnit(String value) {
        setAttributeInternal(BILLINGBUSINESSUNIT, value);
    }

    /**
     * Gets the attribute value for BUSINESS_UNIT_REF using the alias name BusinessUnitRef.
     * @return the BUSINESS_UNIT_REF
     */
    public String getBusinessUnitRef() {
        return (String) getAttributeInternal(BUSINESSUNITREF);
    }

    /**
     * Sets <code>value</code> as attribute value for BUSINESS_UNIT_REF using the alias name BusinessUnitRef.
     * @param value value to set the BUSINESS_UNIT_REF
     */
    public void setBusinessUnitRef(String value) {
        setAttributeInternal(BUSINESSUNITREF, value);
    }

    /**
     * Gets the attribute value for GL_BUSINESS_UNIT using the alias name GlBusinessUnit.
     * @return the GL_BUSINESS_UNIT
     */
    public String getGlBusinessUnit() {
        return (String) getAttributeInternal(GLBUSINESSUNIT);
    }

    /**
     * Sets <code>value</code> as attribute value for GL_BUSINESS_UNIT using the alias name GlBusinessUnit.
     * @param value value to set the GL_BUSINESS_UNIT
     */
    public void setGlBusinessUnit(String value) {
        setAttributeInternal(GLBUSINESSUNIT, value);
    }

    /**
     * Gets the attribute value for INACTIVE using the alias name Inactive.
     * @return the INACTIVE
     */
    public String getInactive() {
        return (String) getAttributeInternal(INACTIVE);
    }

    /**
     * Sets <code>value</code> as attribute value for INACTIVE using the alias name Inactive.
     * @param value value to set the INACTIVE
     */
    public void setInactive(String value) {
        setAttributeInternal(INACTIVE, value);
    }

    /**
     * Gets the attribute value for INACTIVE_DATE using the alias name InactiveDate.
     * @return the INACTIVE_DATE
     */
    public Timestamp getInactiveDate() {
        return (Timestamp) getAttributeInternal(INACTIVEDATE);
    }

    /**
     * Sets <code>value</code> as attribute value for INACTIVE_DATE using the alias name InactiveDate.
     * @param value value to set the INACTIVE_DATE
     */
    public void setInactiveDate(Timestamp value) {
        setAttributeInternal(INACTIVEDATE, value);
    }

    /**
     * Gets the attribute value for OPERATING_UNIT using the alias name OperatingUnit.
     * @return the OPERATING_UNIT
     */
    public String getOperatingUnit() {
        return (String) getAttributeInternal(OPERATINGUNIT);
    }

    /**
     * Sets <code>value</code> as attribute value for OPERATING_UNIT using the alias name OperatingUnit.
     * @param value value to set the OPERATING_UNIT
     */
    public void setOperatingUnit(String value) {
        setAttributeInternal(OPERATINGUNIT, value);
    }

    /**
     * Gets the attribute value for SITE_DESC using the alias name SiteDesc.
     * @return the SITE_DESC
     */
    public String getSiteDesc() {
        return (String) getAttributeInternal(SITEDESC);
    }

    /**
     * Sets <code>value</code> as attribute value for SITE_DESC using the alias name SiteDesc.
     * @param value value to set the SITE_DESC
     */
    public void setSiteDesc(String value) {
        setAttributeInternal(SITEDESC, value);
    }

    /**
     * Gets the attribute value for STATS_ONLY using the alias name StatsOnly.
     * @return the STATS_ONLY
     */
    public String getStatsOnly() {
        return (String) getAttributeInternal(STATSONLY);
    }

    /**
     * Sets <code>value</code> as attribute value for STATS_ONLY using the alias name StatsOnly.
     * @param value value to set the STATS_ONLY
     */
    public void setStatsOnly(String value) {
        setAttributeInternal(STATSONLY, value);
    }

    /**
     * Gets the attribute value for CREATED_BY using the alias name CreatedBy.
     * @return the CREATED_BY
     */
    public String getCreatedBy() {
        return (String) getAttributeInternal(CREATEDBY);
    }

    /**
     * Sets <code>value</code> as attribute value for CREATED_BY using the alias name CreatedBy.
     * @param value value to set the CREATED_BY
     */
    public void setCreatedBy(String value) {
        setAttributeInternal(CREATEDBY, value);
    }

    /**
     * Gets the attribute value for CREATED_DATE using the alias name CreatedDate.
     * @return the CREATED_DATE
     */
    public Timestamp getCreatedDate() {
        return (Timestamp) getAttributeInternal(CREATEDDATE);
    }

    /**
     * Sets <code>value</code> as attribute value for CREATED_DATE using the alias name CreatedDate.
     * @param value value to set the CREATED_DATE
     */
    public void setCreatedDate(Timestamp value) {
        setAttributeInternal(CREATEDDATE, value);
    }

    /**
     * Gets the attribute value for LAST_UPDATED_BY using the alias name LastUpdatedBy.
     * @return the LAST_UPDATED_BY
     */
    public String getLastUpdatedBy() {
        return (String) getAttributeInternal(LASTUPDATEDBY);
    }

    /**
     * Sets <code>value</code> as attribute value for LAST_UPDATED_BY using the alias name LastUpdatedBy.
     * @param value value to set the LAST_UPDATED_BY
     */
    public void setLastUpdatedBy(String value) {
        setAttributeInternal(LASTUPDATEDBY, value);
    }

    /**
     * Gets the attribute value for LAST_UPDATED_DATE using the alias name LastUpdatedDate.
     * @return the LAST_UPDATED_DATE
     */
    public Timestamp getLastUpdatedDate() {
        return (Timestamp) getAttributeInternal(LASTUPDATEDDATE);
    }

    /**
     * Sets <code>value</code> as attribute value for LAST_UPDATED_DATE using the alias name LastUpdatedDate.
     * @param value value to set the LAST_UPDATED_DATE
     */
    public void setLastUpdatedDate(Timestamp value) {
        setAttributeInternal(LASTUPDATEDDATE, value);
    }

    /**
     * Gets the attribute value for BILLING_GL_BUSINESS_UNIT using the alias name BillingGlBusinessUnit.
     * @return the BILLING_GL_BUSINESS_UNIT
     */
    public String getBillingGlBusinessUnit() {
        return (String) getAttributeInternal(BILLINGGLBUSINESSUNIT);
    }

    /**
     * Sets <code>value</code> as attribute value for BILLING_GL_BUSINESS_UNIT using the alias name BillingGlBusinessUnit.
     * @param value value to set the BILLING_GL_BUSINESS_UNIT
     */
    public void setBillingGlBusinessUnit(String value) {
        setAttributeInternal(BILLINGGLBUSINESSUNIT, value);
    }

    /**
     * Gets the attribute value for BILLING_OPERATING_UNIT using the alias name BillingOperatingUnit.
     * @return the BILLING_OPERATING_UNIT
     */
    public String getBillingOperatingUnit() {
        return (String) getAttributeInternal(BILLINGOPERATINGUNIT);
    }

    /**
     * Sets <code>value</code> as attribute value for BILLING_OPERATING_UNIT using the alias name BillingOperatingUnit.
     * @param value value to set the BILLING_OPERATING_UNIT
     */
    public void setBillingOperatingUnit(String value) {
        setAttributeInternal(BILLINGOPERATINGUNIT, value);
    }

    /**
     * Gets the attribute value for BILLING_AFFILIATE using the alias name BillingAffiliate.
     * @return the BILLING_AFFILIATE
     */
    public String getBillingAffiliate() {
        return (String) getAttributeInternal(BILLINGAFFILIATE);
    }

    /**
     * Sets <code>value</code> as attribute value for BILLING_AFFILIATE using the alias name BillingAffiliate.
     * @param value value to set the BILLING_AFFILIATE
     */
    public void setBillingAffiliate(String value) {
        setAttributeInternal(BILLINGAFFILIATE, value);
    }

    /**
     * Gets the attribute value for BUSINESSUNIT_ID using the alias name BusinessunitId.
     * @return the BUSINESSUNIT_ID
     */
    public String getBusinessunitId() {
        return (String) getAttributeInternal(BUSINESSUNITID);
    }

    /**
     * Sets <code>value</code> as attribute value for BUSINESSUNIT_ID using the alias name BusinessunitId.
     * @param value value to set the BUSINESSUNIT_ID
     */
    public void setBusinessunitId(String value) {
        setAttributeInternal(BUSINESSUNITID, value);
    }

    /**
     * Gets the view accessor <code>RowSet</code> XpeDccCfgTerminals_LOV.
     */
    public RowSet getXpeDccCfgTerminals_LOV() {
        return (RowSet) getAttributeInternal(XPEDCCCFGTERMINALS_LOV);
    }

    /**
     * Gets the view accessor <code>RowSet</code> XpeDccCfgPCSShortNames_LOV.
     */
    public RowSet getXpeDccCfgPCSShortNames_LOV() {
        return (RowSet) getAttributeInternal(XPEDCCCFGPCSSHORTNAMES_LOV);
    }

    /**
     * Gets the view accessor <code>RowSet</code> XpeDccGeneralItemList_ACLOV.
     */
    public RowSet getXpeDccGeneralItemList_ACLOV() {
        return (RowSet) getAttributeInternal(XPEDCCGENERALITEMLIST_ACLOV);
    }

    /**
     * Gets the view accessor <code>RowSet</code> LookupSharedAppModule_YONLOV.
     */
    public RowSet getLookupSharedAppModule_YONLOV() {
        return (RowSet) getAttributeInternal(LOOKUPSHAREDAPPMODULE_YONLOV);
    }

    /**
     * Gets the view accessor <code>RowSet</code> XpeDccCfgPcsAssTerminalsROVO1.
     */
    public RowSet getXpeDccCfgPcsAssTerminalsROVO1() {
        return (RowSet) getAttributeInternal(XPEDCCCFGPCSASSTERMINALSROVO1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> XpeDccCfgPcsROVO1.
     */
    public RowSet getXpeDccCfgPcsROVO1() {
        return (RowSet) getAttributeInternal(XPEDCCCFGPCSROVO1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> PsBusUnitTblBiROVO1.
     */
    public RowSet getPsBusUnitTblBiROVO1() {
        return (RowSet) getAttributeInternal(PSBUSUNITTBLBIROVO1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> PsOperUnitTblROVO1.
     */
    public RowSet getPsOperUnitTblROVO1() {
        return (RowSet) getAttributeInternal(PSOPERUNITTBLROVO1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> PsOperUnitTblROVO2.
     */
    public RowSet getPsOperUnitTblROVO2() {
        return (RowSet) getAttributeInternal(PSOPERUNITTBLROVO2);
    }

    /**
     * Gets the view accessor <code>RowSet</code> PsBusUnitTblFsROVO1.
     */
    public RowSet getPsBusUnitTblFsROVO1() {
        return (RowSet) getAttributeInternal(PSBUSUNITTBLFSROVO1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> PsBusUnitTblFsROVO2.
     */
    public RowSet getPsBusUnitTblFsROVO2() {
        return (RowSet) getAttributeInternal(PSBUSUNITTBLFSROVO2);
    }

    /**
     * Gets the view accessor <code>RowSet</code> PsBusUnitTblFsROVO3.
     */
    public RowSet getPsBusUnitTblFsROVO3() {
        return (RowSet) getAttributeInternal(PSBUSUNITTBLFSROVO3);
    }

    /**
     * Gets the view accessor <code>RowSet</code> PsBusUnitTblFsROVO4.
     */
    public RowSet getPsBusUnitTblFsROVO4() {
        return (RowSet) getAttributeInternal(PSBUSUNITTBLFSROVO4);
    }

    /**
     * Gets the view accessor <code>RowSet</code> PsBusUnitTblFsROVO5.
     */
    public RowSet getPsBusUnitTblFsROVO5() {
        return (RowSet) getAttributeInternal(PSBUSUNITTBLFSROVO5);
    }

    /**
     * Gets the view accessor <code>RowSet</code> PsPlantBURefROVO_LOV.
     */
    public RowSet getPsPlantBURefROVO_LOV() {
        return (RowSet) getAttributeInternal(PSPLANTBUREFROVO_LOV);
    }

    /**
     * Gets the view accessor <code>RowSet</code> XpeDccGeneralItemListROVO1.
     */
    public RowSet getXpeDccGeneralItemListROVO1() {
        return (RowSet) getAttributeInternal(XPEDCCGENERALITEMLISTROVO1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> PsBusUnitTblBiROVO2.
     */
    public RowSet getPsBusUnitTblBiROVO2() {
        return (RowSet) getAttributeInternal(PSBUSUNITTBLBIROVO2);
    }
}

