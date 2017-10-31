package model.views.entitybased;

import java.sql.Timestamp;

import oracle.jbo.RowSet;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Fri Oct 27 14:32:44 EDT 2017
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class XpeDccCfgMswFacilityEOVORowImpl extends ViewRowImpl {


    public static final int ENTITY_XPEDCCCFGMSWFACILITYEO = 0;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        XpeFacilityId,
        CustomerCareReview,
        LegalReview,
        GeneralManagerReview,
        CreatedBy,
        CreationDate,
        LastUpdatedBy,
        LastUpdateDate,
        Inactive,
        InactiveDate,
        XpeDccDicFacilities1,
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


    public static final int XPEFACILITYID = AttributesEnum.XpeFacilityId.index();
    public static final int CUSTOMERCAREREVIEW = AttributesEnum.CustomerCareReview.index();
    public static final int LEGALREVIEW = AttributesEnum.LegalReview.index();
    public static final int GENERALMANAGERREVIEW = AttributesEnum.GeneralManagerReview.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int CREATIONDATE = AttributesEnum.CreationDate.index();
    public static final int LASTUPDATEDBY = AttributesEnum.LastUpdatedBy.index();
    public static final int LASTUPDATEDATE = AttributesEnum.LastUpdateDate.index();
    public static final int INACTIVE = AttributesEnum.Inactive.index();
    public static final int INACTIVEDATE = AttributesEnum.InactiveDate.index();
    public static final int XPEDCCDICFACILITIES1 = AttributesEnum.XpeDccDicFacilities1.index();
    public static final int LOOKUPSHAREDAPPMODULE_XPEDCCDICNEWCONTRACTSETUPROVO1 =
        AttributesEnum.LookupSharedAppModule_XpeDccDicNewContractSetupROVO1.index();

    /**
     * This is the default constructor (do not remove).
     */
    public XpeDccCfgMswFacilityEOVORowImpl() {
    }

    /**
     * Gets XpeDccCfgMswFacilityEO entity object.
     * @return the XpeDccCfgMswFacilityEO
     */
    public EntityImpl getXpeDccCfgMswFacilityEO() {
        return (EntityImpl) getEntity(ENTITY_XPEDCCCFGMSWFACILITYEO);
    }

    /**
     * Gets the attribute value for XPE_FACILITY_ID using the alias name XpeFacilityId.
     * @return the XPE_FACILITY_ID
     */
    public String getXpeFacilityId() {
        return (String) getAttributeInternal(XPEFACILITYID);
    }

    /**
     * Sets <code>value</code> as attribute value for XPE_FACILITY_ID using the alias name XpeFacilityId.
     * @param value value to set the XPE_FACILITY_ID
     */
    public void setXpeFacilityId(String value) {
        setAttributeInternal(XPEFACILITYID, value);
    }

    /**
     * Gets the attribute value for CUSTOMER_CARE_REVIEW using the alias name CustomerCareReview.
     * @return the CUSTOMER_CARE_REVIEW
     */
    public String getCustomerCareReview() {
        return (String) getAttributeInternal(CUSTOMERCAREREVIEW);
    }

    /**
     * Sets <code>value</code> as attribute value for CUSTOMER_CARE_REVIEW using the alias name CustomerCareReview.
     * @param value value to set the CUSTOMER_CARE_REVIEW
     */
    public void setCustomerCareReview(String value) {
        setAttributeInternal(CUSTOMERCAREREVIEW, value);
    }

    /**
     * Gets the attribute value for LEGAL_REVIEW using the alias name LegalReview.
     * @return the LEGAL_REVIEW
     */
    public String getLegalReview() {
        return (String) getAttributeInternal(LEGALREVIEW);
    }

    /**
     * Sets <code>value</code> as attribute value for LEGAL_REVIEW using the alias name LegalReview.
     * @param value value to set the LEGAL_REVIEW
     */
    public void setLegalReview(String value) {
        setAttributeInternal(LEGALREVIEW, value);
    }

    /**
     * Gets the attribute value for GENERAL_MANAGER_REVIEW using the alias name GeneralManagerReview.
     * @return the GENERAL_MANAGER_REVIEW
     */
    public String getGeneralManagerReview() {
        return (String) getAttributeInternal(GENERALMANAGERREVIEW);
    }

    /**
     * Sets <code>value</code> as attribute value for GENERAL_MANAGER_REVIEW using the alias name GeneralManagerReview.
     * @param value value to set the GENERAL_MANAGER_REVIEW
     */
    public void setGeneralManagerReview(String value) {
        setAttributeInternal(GENERALMANAGERREVIEW, value);
    }

    /**
     * Gets the attribute value for CREATED_BY using the alias name CreatedBy.
     * @return the CREATED_BY
     */
    public Long getCreatedBy() {
        return (Long) getAttributeInternal(CREATEDBY);
    }

    /**
     * Sets <code>value</code> as attribute value for CREATED_BY using the alias name CreatedBy.
     * @param value value to set the CREATED_BY
     */
    public void setCreatedBy(Long value) {
        setAttributeInternal(CREATEDBY, value);
    }

    /**
     * Gets the attribute value for CREATION_DATE using the alias name CreationDate.
     * @return the CREATION_DATE
     */
    public Timestamp getCreationDate() {
        return (Timestamp) getAttributeInternal(CREATIONDATE);
    }

    /**
     * Sets <code>value</code> as attribute value for CREATION_DATE using the alias name CreationDate.
     * @param value value to set the CREATION_DATE
     */
    public void setCreationDate(Timestamp value) {
        setAttributeInternal(CREATIONDATE, value);
    }

    /**
     * Gets the attribute value for LAST_UPDATED_BY using the alias name LastUpdatedBy.
     * @return the LAST_UPDATED_BY
     */
    public Long getLastUpdatedBy() {
        return (Long) getAttributeInternal(LASTUPDATEDBY);
    }

    /**
     * Sets <code>value</code> as attribute value for LAST_UPDATED_BY using the alias name LastUpdatedBy.
     * @param value value to set the LAST_UPDATED_BY
     */
    public void setLastUpdatedBy(Long value) {
        setAttributeInternal(LASTUPDATEDBY, value);
    }

    /**
     * Gets the attribute value for LAST_UPDATE_DATE using the alias name LastUpdateDate.
     * @return the LAST_UPDATE_DATE
     */
    public Timestamp getLastUpdateDate() {
        return (Timestamp) getAttributeInternal(LASTUPDATEDATE);
    }

    /**
     * Sets <code>value</code> as attribute value for LAST_UPDATE_DATE using the alias name LastUpdateDate.
     * @param value value to set the LAST_UPDATE_DATE
     */
    public void setLastUpdateDate(Timestamp value) {
        setAttributeInternal(LASTUPDATEDATE, value);
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
     * Gets the view accessor <code>RowSet</code> XpeDccDicFacilities1.
     */
    public RowSet getXpeDccDicFacilities1() {
        return (RowSet) getAttributeInternal(XPEDCCDICFACILITIES1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> LookupSharedAppModule_XpeDccDicNewContractSetupROVO1.
     */
    public RowSet getLookupSharedAppModule_XpeDccDicNewContractSetupROVO1() {
        return (RowSet) getAttributeInternal(LOOKUPSHAREDAPPMODULE_XPEDCCDICNEWCONTRACTSETUPROVO1);
    }
}
