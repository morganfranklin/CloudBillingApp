package model.views.entitybased;

import java.sql.Timestamp;

import oracle.jbo.RowSet;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Tue Nov 28 22:08:10 EST 2017
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class XpeDccCfgGeneralEOVORowImpl extends ViewRowImpl {
    public static final int ENTITY_XPEDCCCFGGENERALEO = 0;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        ItemId,
        ItemListType,
        ValidValue,
        CreatedBy,
        CreatedDate,
        LastUpdatedBy,
        LastUpdatedDate,
        Inactive,
        InactiveDate,
        LookupSharedAppModule_GeneralItemListLOV,
        LookupSharedAppModule_XpeDccDicNewContractSetupROVO1;
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
    public static final int ITEMID = AttributesEnum.ItemId.index();
    public static final int ITEMLISTTYPE = AttributesEnum.ItemListType.index();
    public static final int VALIDVALUE = AttributesEnum.ValidValue.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int CREATEDDATE = AttributesEnum.CreatedDate.index();
    public static final int LASTUPDATEDBY = AttributesEnum.LastUpdatedBy.index();
    public static final int LASTUPDATEDDATE = AttributesEnum.LastUpdatedDate.index();
    public static final int INACTIVE = AttributesEnum.Inactive.index();
    public static final int INACTIVEDATE = AttributesEnum.InactiveDate.index();
    public static final int LOOKUPSHAREDAPPMODULE_GENERALITEMLISTLOV =
        AttributesEnum.LookupSharedAppModule_GeneralItemListLOV.index();
    public static final int LOOKUPSHAREDAPPMODULE_XPEDCCDICNEWCONTRACTSETUPROVO1 =
        AttributesEnum.LookupSharedAppModule_XpeDccDicNewContractSetupROVO1.index();

    /**
     * This is the default constructor (do not remove).
     */
    public XpeDccCfgGeneralEOVORowImpl() {
    }

    /**
     * Gets XpeDccCfgGeneralEO entity object.
     * @return the XpeDccCfgGeneralEO
     */
    public EntityImpl getXpeDccCfgGeneralEO() {
        return (EntityImpl) getEntity(ENTITY_XPEDCCCFGGENERALEO);
    }

    /**
     * Gets the attribute value for ITEM_ID using the alias name ItemId.
     * @return the ITEM_ID
     */
    public String getItemId() {
        return (String) getAttributeInternal(ITEMID);
    }

    /**
     * Sets <code>value</code> as attribute value for ITEM_ID using the alias name ItemId.
     * @param value value to set the ITEM_ID
     */
    public void setItemId(String value) {
        setAttributeInternal(ITEMID, value);
    }

    /**
     * Gets the attribute value for ITEM_LIST_TYPE using the alias name ItemListType.
     * @return the ITEM_LIST_TYPE
     */
    public String getItemListType() {
        return (String) getAttributeInternal(ITEMLISTTYPE);
    }

    /**
     * Sets <code>value</code> as attribute value for ITEM_LIST_TYPE using the alias name ItemListType.
     * @param value value to set the ITEM_LIST_TYPE
     */
    public void setItemListType(String value) {
        setAttributeInternal(ITEMLISTTYPE, value);
    }

    /**
     * Gets the attribute value for VALID_VALUE using the alias name ValidValue.
     * @return the VALID_VALUE
     */
    public String getValidValue() {
        return (String) getAttributeInternal(VALIDVALUE);
    }

    /**
     * Sets <code>value</code> as attribute value for VALID_VALUE using the alias name ValidValue.
     * @param value value to set the VALID_VALUE
     */
    public void setValidValue(String value) {
        setAttributeInternal(VALIDVALUE, value);
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
     * Gets the view accessor <code>RowSet</code> LookupSharedAppModule_GeneralItemListLOV.
     */
    public RowSet getLookupSharedAppModule_GeneralItemListLOV() {
        return (RowSet) getAttributeInternal(LOOKUPSHAREDAPPMODULE_GENERALITEMLISTLOV);
    }

    /**
     * Gets the view accessor <code>RowSet</code> LookupSharedAppModule_XpeDccDicNewContractSetupROVO1.
     */
    public RowSet getLookupSharedAppModule_XpeDccDicNewContractSetupROVO1() {
        return (RowSet) getAttributeInternal(LOOKUPSHAREDAPPMODULE_XPEDCCDICNEWCONTRACTSETUPROVO1);
    }
}

