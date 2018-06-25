package model.views.entitybased;

import java.sql.Timestamp;

import model.entities.XpeDccCfgPcsEOImpl;

import oracle.jbo.RowIterator;
import oracle.jbo.RowSet;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sun Sep 10 03:03:56 EDT 2017
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class XpeDccCfgPcsEOVORowImpl extends ViewRowImpl {


    public static final int ENTITY_XPEDCCCFGPCSEO = 0;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        SiteId,
        SiteDesc,
        FacilityId,
        DbLink,
        DirectToCustomer,
        EmailNotificationGroup,
        Activate,
        CreatedBy,
        CreatedDate,
        Inactive,
        InactiveDate,
        LastUpdatedBy,
        LastUpdatedDate,
        SiteOverride,
        PrintStage,
        XpeDccCfgPcsAssTerminalsEOVO,
        XpeDccCfgPcsAddressEOVO,
        LookupSharedAppModule_YONLOV,
        LookupSharedAppModule_XpeDccDicNewContractSetupROVO1;
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


    public static final int SITEID = AttributesEnum.SiteId.index();
    public static final int SITEDESC = AttributesEnum.SiteDesc.index();
    public static final int FACILITYID = AttributesEnum.FacilityId.index();
    public static final int DBLINK = AttributesEnum.DbLink.index();
    public static final int DIRECTTOCUSTOMER = AttributesEnum.DirectToCustomer.index();
    public static final int EMAILNOTIFICATIONGROUP = AttributesEnum.EmailNotificationGroup.index();
    public static final int ACTIVATE = AttributesEnum.Activate.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int CREATEDDATE = AttributesEnum.CreatedDate.index();
    public static final int INACTIVE = AttributesEnum.Inactive.index();
    public static final int INACTIVEDATE = AttributesEnum.InactiveDate.index();
    public static final int LASTUPDATEDBY = AttributesEnum.LastUpdatedBy.index();
    public static final int LASTUPDATEDDATE = AttributesEnum.LastUpdatedDate.index();
    public static final int SITEOVERRIDE = AttributesEnum.SiteOverride.index();
    public static final int PRINTSTAGE = AttributesEnum.PrintStage.index();
    public static final int XPEDCCCFGPCSASSTERMINALSEOVO = AttributesEnum.XpeDccCfgPcsAssTerminalsEOVO.index();
    public static final int XPEDCCCFGPCSADDRESSEOVO = AttributesEnum.XpeDccCfgPcsAddressEOVO.index();
    public static final int LOOKUPSHAREDAPPMODULE_YONLOV = AttributesEnum.LookupSharedAppModule_YONLOV.index();
    public static final int LOOKUPSHAREDAPPMODULE_XPEDCCDICNEWCONTRACTSETUPROVO1 =
        AttributesEnum.LookupSharedAppModule_XpeDccDicNewContractSetupROVO1.index();

    /**
     * This is the default constructor (do not remove).
     */
    public XpeDccCfgPcsEOVORowImpl() {
    }

    /**
     * Gets XpeDccCfgPcsEO entity object.
     * @return the XpeDccCfgPcsEO
     */
    public XpeDccCfgPcsEOImpl getXpeDccCfgPcsEO() {
        return (XpeDccCfgPcsEOImpl) getEntity(ENTITY_XPEDCCCFGPCSEO);
    }

    /**
     * Gets the attribute value for ACTIVATE using the alias name Activate.
     * @return the ACTIVATE
     */
    public String getActivate() {
        return (String) getAttributeInternal(ACTIVATE);
    }

    /**
     * Sets <code>value</code> as attribute value for ACTIVATE using the alias name Activate.
     * @param value value to set the ACTIVATE
     */
    public void setActivate(String value) {
        setAttributeInternal(ACTIVATE, value);
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
     * Gets the attribute value for DB_LINK using the alias name DbLink.
     * @return the DB_LINK
     */
    public String getDbLink() {
        return (String) getAttributeInternal(DBLINK);
    }

    /**
     * Sets <code>value</code> as attribute value for DB_LINK using the alias name DbLink.
     * @param value value to set the DB_LINK
     */
    public void setDbLink(String value) {
        setAttributeInternal(DBLINK, value);
    }

    /**
     * Gets the attribute value for DIRECT_TO_CUSTOMER using the alias name DirectToCustomer.
     * @return the DIRECT_TO_CUSTOMER
     */
    public String getDirectToCustomer() {
        return (String) getAttributeInternal(DIRECTTOCUSTOMER);
    }

    /**
     * Sets <code>value</code> as attribute value for DIRECT_TO_CUSTOMER using the alias name DirectToCustomer.
     * @param value value to set the DIRECT_TO_CUSTOMER
     */
    public void setDirectToCustomer(String value) {
        setAttributeInternal(DIRECTTOCUSTOMER, value);
    }

    /**
     * Gets the attribute value for EMAIL_NOTIFICATION_GROUP using the alias name EmailNotificationGroup.
     * @return the EMAIL_NOTIFICATION_GROUP
     */
    public String getEmailNotificationGroup() {
        return (String) getAttributeInternal(EMAILNOTIFICATIONGROUP);
    }

    /**
     * Sets <code>value</code> as attribute value for EMAIL_NOTIFICATION_GROUP using the alias name EmailNotificationGroup.
     * @param value value to set the EMAIL_NOTIFICATION_GROUP
     */
    public void setEmailNotificationGroup(String value) {
        setAttributeInternal(EMAILNOTIFICATIONGROUP, value);
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
     * Gets the attribute value for SITE_OVERRIDE using the alias name SiteOverride.
     * @return the SITE_OVERRIDE
     */
    public String getSiteOverride() {
        return (String) getAttributeInternal(SITEOVERRIDE);
    }

    /**
     * Sets <code>value</code> as attribute value for SITE_OVERRIDE using the alias name SiteOverride.
     * @param value value to set the SITE_OVERRIDE
     */
    public void setSiteOverride(String value) {
        setAttributeInternal(SITEOVERRIDE, value);
    }


    /**
     * Gets the attribute value for PRINT_STAGE using the alias name PrintStage.
     * @return the PRINT_STAGE
     */
    public String getPrintStage() {
        return (String) getAttributeInternal(PRINTSTAGE);
    }

    /**
     * Sets <code>value</code> as attribute value for PRINT_STAGE using the alias name PrintStage.
     * @param value value to set the PRINT_STAGE
     */
    public void setPrintStage(String value) {
        setAttributeInternal(PRINTSTAGE, value);
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
     * Gets the attribute value for FACILITY_ID using the alias name FacilityId.
     * @return the FACILITY_ID
     */
    public String getFacilityId() {
        return (String) getAttributeInternal(FACILITYID);
    }

    /**
     * Sets <code>value</code> as attribute value for FACILITY_ID using the alias name FacilityId.
     * @param value value to set the FACILITY_ID
     */
    public void setFacilityId(String value) {
        setAttributeInternal(FACILITYID, value);
    }

    /**
     * Gets the associated <code>RowIterator</code> using master-detail link XpeDccCfgPcsAssTerminalsEOVO.
     */
    public RowIterator getXpeDccCfgPcsAssTerminalsEOVO() {
        return (RowIterator) getAttributeInternal(XPEDCCCFGPCSASSTERMINALSEOVO);
    }

    /**
     * Gets the associated <code>RowIterator</code> using master-detail link XpeDccCfgPcsAddressEOVO.
     */
    public RowIterator getXpeDccCfgPcsAddressEOVO() {
        return (RowIterator) getAttributeInternal(XPEDCCCFGPCSADDRESSEOVO);
    }

    /**
     * Gets the view accessor <code>RowSet</code> LookupSharedAppModule_YONActivateLOV.
     */
    public RowSet getLookupSharedAppModule_YONLOV() {
        return (RowSet) getAttributeInternal(LOOKUPSHAREDAPPMODULE_YONLOV);
    }

    /**
     * Gets the view accessor <code>RowSet</code> LookupSharedAppModule_XpeDccDicNewContractSetupROVO1.
     */
    public RowSet getLookupSharedAppModule_XpeDccDicNewContractSetupROVO1() {
        return (RowSet) getAttributeInternal(LOOKUPSHAREDAPPMODULE_XPEDCCDICNEWCONTRACTSETUPROVO1);
    }
}

