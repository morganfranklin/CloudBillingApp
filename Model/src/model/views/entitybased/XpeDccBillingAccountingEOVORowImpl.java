package model.views.entitybased;

import java.math.BigDecimal;

import java.sql.Timestamp;

import oracle.jbo.RowSet;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Jan 17 23:12:58 EST 2018
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class XpeDccBillingAccountingEOVORowImpl extends ViewRowImpl {
    public static final int ENTITY_XPEDCCBILLINGACCOUNTINGEO = 0;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        CreatedBy,
        CreationDate,
        LastUpdateDate,
        LastUpdatedBy,
        XpeBillCycleId,
        XpeBillDate,
        XpeBillingAccountingId,
        XpeFacilityId,
        XpeDccCfgPcsROVO_LOV;
        private static AttributesEnum[] vals = null;
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
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int CREATIONDATE = AttributesEnum.CreationDate.index();
    public static final int LASTUPDATEDATE = AttributesEnum.LastUpdateDate.index();
    public static final int LASTUPDATEDBY = AttributesEnum.LastUpdatedBy.index();
    public static final int XPEBILLCYCLEID = AttributesEnum.XpeBillCycleId.index();
    public static final int XPEBILLDATE = AttributesEnum.XpeBillDate.index();
    public static final int XPEBILLINGACCOUNTINGID = AttributesEnum.XpeBillingAccountingId.index();
    public static final int XPEFACILITYID = AttributesEnum.XpeFacilityId.index();
    public static final int XPEDCCCFGPCSROVO_LOV = AttributesEnum.XpeDccCfgPcsROVO_LOV.index();

    /**
     * This is the default constructor (do not remove).
     */
    public XpeDccBillingAccountingEOVORowImpl() {
    }

    /**
     * Gets XpeDccBillingAccountingEO entity object.
     * @return the XpeDccBillingAccountingEO
     */
    public EntityImpl getXpeDccBillingAccountingEO() {
        return (EntityImpl) getEntity(ENTITY_XPEDCCBILLINGACCOUNTINGEO);
    }

    /**
     * Gets the attribute value for CREATED_BY using the alias name CreatedBy.
     * @return the CREATED_BY
     */
    public String getCreatedBy() {
        return (String) getAttributeInternal(CREATEDBY);
    }

    /**
     * Gets the attribute value for CREATION_DATE using the alias name CreationDate.
     * @return the CREATION_DATE
     */
    public Timestamp getCreationDate() {
        return (Timestamp) getAttributeInternal(CREATIONDATE);
    }

    /**
     * Gets the attribute value for LAST_UPDATE_DATE using the alias name LastUpdateDate.
     * @return the LAST_UPDATE_DATE
     */
    public Timestamp getLastUpdateDate() {
        return (Timestamp) getAttributeInternal(LASTUPDATEDATE);
    }

    /**
     * Gets the attribute value for LAST_UPDATED_BY using the alias name LastUpdatedBy.
     * @return the LAST_UPDATED_BY
     */
    public String getLastUpdatedBy() {
        return (String) getAttributeInternal(LASTUPDATEDBY);
    }

    /**
     * Gets the attribute value for XPE_BILL_CYCLE_ID using the alias name XpeBillCycleId.
     * @return the XPE_BILL_CYCLE_ID
     */
    public String getXpeBillCycleId() {
        return (String) getAttributeInternal(XPEBILLCYCLEID);
    }

    /**
     * Sets <code>value</code> as attribute value for XPE_BILL_CYCLE_ID using the alias name XpeBillCycleId.
     * @param value value to set the XPE_BILL_CYCLE_ID
     */
    public void setXpeBillCycleId(String value) {
        setAttributeInternal(XPEBILLCYCLEID, value);
    }

    /**
     * Gets the attribute value for XPE_BILL_DATE using the alias name XpeBillDate.
     * @return the XPE_BILL_DATE
     */
    public Timestamp getXpeBillDate() {
        return (Timestamp) getAttributeInternal(XPEBILLDATE);
    }

    /**
     * Sets <code>value</code> as attribute value for XPE_BILL_DATE using the alias name XpeBillDate.
     * @param value value to set the XPE_BILL_DATE
     */
    public void setXpeBillDate(Timestamp value) {
        setAttributeInternal(XPEBILLDATE, value);
    }

    /**
     * Gets the attribute value for XPE_BILLING_ACCOUNTING_ID using the alias name XpeBillingAccountingId.
     * @return the XPE_BILLING_ACCOUNTING_ID
     */
    public BigDecimal getXpeBillingAccountingId() {
        return (BigDecimal) getAttributeInternal(XPEBILLINGACCOUNTINGID);
    }

    /**
     * Sets <code>value</code> as attribute value for XPE_BILLING_ACCOUNTING_ID using the alias name XpeBillingAccountingId.
     * @param value value to set the XPE_BILLING_ACCOUNTING_ID
     */
    public void setXpeBillingAccountingId(BigDecimal value) {
        setAttributeInternal(XPEBILLINGACCOUNTINGID, value);
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
     * Gets the view accessor <code>RowSet</code> XpeDccCfgPcsROVO_LOV.
     */
    public RowSet getXpeDccCfgPcsROVO_LOV() {
        return (RowSet) getAttributeInternal(XPEDCCCFGPCSROVO_LOV);
    }
}

