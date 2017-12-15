package model.views.entitybased;

import java.sql.Timestamp;

import oracle.jbo.RowSet;
import oracle.jbo.domain.BlobDomain;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Fri Dec 15 00:01:48 EST 2017
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class XpeDccCfgSpclWasteFcltyEOVORowImpl extends ViewRowImpl {


    public static final int ENTITY_XPEDCCCFGSPCLWASTEFCLTYEO = 0;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        XpeFacilityId,
        CustomerCareReview,
        CustomerCareSignature,
        CreatedBy,
        CreationDate,
        LastUpdatedBy,
        LastUpdatedDate,
        Inactive,
        InactiveDate,
        LookupSharedAppModule_XpeDccDicNewContractSetupROVO1,
        XpeDccCfgPcsROVO1;
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
    public static final int CUSTOMERCARESIGNATURE = AttributesEnum.CustomerCareSignature.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int CREATIONDATE = AttributesEnum.CreationDate.index();
    public static final int LASTUPDATEDBY = AttributesEnum.LastUpdatedBy.index();
    public static final int LASTUPDATEDDATE = AttributesEnum.LastUpdatedDate.index();
    public static final int INACTIVE = AttributesEnum.Inactive.index();
    public static final int INACTIVEDATE = AttributesEnum.InactiveDate.index();
    public static final int LOOKUPSHAREDAPPMODULE_XPEDCCDICNEWCONTRACTSETUPROVO1 =
        AttributesEnum.LookupSharedAppModule_XpeDccDicNewContractSetupROVO1.index();
    public static final int XPEDCCCFGPCSROVO1 = AttributesEnum.XpeDccCfgPcsROVO1.index();

    /**
     * This is the default constructor (do not remove).
     */
    public XpeDccCfgSpclWasteFcltyEOVORowImpl() {
    }

    /**
     * Gets XpeDccCfgSpclWasteFcltyEO entity object.
     * @return the XpeDccCfgSpclWasteFcltyEO
     */
    public EntityImpl getXpeDccCfgSpclWasteFcltyEO() {
        return (EntityImpl) getEntity(ENTITY_XPEDCCCFGSPCLWASTEFCLTYEO);
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
     * Gets the attribute value for CUSTOMER_CARE_SIGNATURE using the alias name CustomerCareSignature.
     * @return the CUSTOMER_CARE_SIGNATURE
     */
    public BlobDomain getCustomerCareSignature() {
        return (BlobDomain) getAttributeInternal(CUSTOMERCARESIGNATURE);
    }

    /**
     * Sets <code>value</code> as attribute value for CUSTOMER_CARE_SIGNATURE using the alias name CustomerCareSignature.
     * @param value value to set the CUSTOMER_CARE_SIGNATURE
     */
    public void setCustomerCareSignature(BlobDomain value) {
        setAttributeInternal(CUSTOMERCARESIGNATURE, value);
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
     * Gets the view accessor <code>RowSet</code> LookupSharedAppModule_XpeDccDicNewContractSetupROVO1.
     */
    public RowSet getLookupSharedAppModule_XpeDccDicNewContractSetupROVO1() {
        return (RowSet) getAttributeInternal(LOOKUPSHAREDAPPMODULE_XPEDCCDICNEWCONTRACTSETUPROVO1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> XpeDccCfgPcsROVO1.
     */
    public RowSet getXpeDccCfgPcsROVO1() {
        return (RowSet) getAttributeInternal(XPEDCCCFGPCSROVO1);
    }
}

