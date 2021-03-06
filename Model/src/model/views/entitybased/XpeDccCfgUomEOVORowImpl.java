package model.views.entitybased;

import java.sql.Timestamp;

import oracle.jbo.RowSet;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Tue Oct 31 23:40:47 EDT 2017
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class XpeDccCfgUomEOVORowImpl extends ViewRowImpl {


    public static final int ENTITY_XPEDCCCFGUOMEO = 0;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        CreatedBy,
        CreatedDate,
        FeedMethod,
        Inactive,
        InactiveDate,
        ItemId,
        LastUpdatedBy,
        LastUpdatedDate,
        Uom,
        UomDesc,
        Pcsuom,
        XpeDccGeneralItemListROVO_UOMLOV,
        LookupSharedAppModule_FeedMethodLOV,
        LookupSharedAppModule_XpeDccDicNewContractSetupROVO1,
        XpeDccGeneralItemListROVO1;
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


    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int CREATEDDATE = AttributesEnum.CreatedDate.index();
    public static final int FEEDMETHOD = AttributesEnum.FeedMethod.index();
    public static final int INACTIVE = AttributesEnum.Inactive.index();
    public static final int INACTIVEDATE = AttributesEnum.InactiveDate.index();
    public static final int ITEMID = AttributesEnum.ItemId.index();
    public static final int LASTUPDATEDBY = AttributesEnum.LastUpdatedBy.index();
    public static final int LASTUPDATEDDATE = AttributesEnum.LastUpdatedDate.index();
    public static final int UOM = AttributesEnum.Uom.index();
    public static final int UOMDESC = AttributesEnum.UomDesc.index();
    public static final int PCSUOM = AttributesEnum.Pcsuom.index();
    public static final int XPEDCCGENERALITEMLISTROVO_UOMLOV = AttributesEnum.XpeDccGeneralItemListROVO_UOMLOV.index();
    public static final int LOOKUPSHAREDAPPMODULE_FEEDMETHODLOV =
        AttributesEnum.LookupSharedAppModule_FeedMethodLOV.index();
    public static final int LOOKUPSHAREDAPPMODULE_XPEDCCDICNEWCONTRACTSETUPROVO1 =
        AttributesEnum.LookupSharedAppModule_XpeDccDicNewContractSetupROVO1.index();
    public static final int XPEDCCGENERALITEMLISTROVO1 = AttributesEnum.XpeDccGeneralItemListROVO1.index();

    /**
     * This is the default constructor (do not remove).
     */
    public XpeDccCfgUomEOVORowImpl() {
    }

    /**
     * Gets XpeDccCfgUomEO entity object.
     * @return the XpeDccCfgUomEO
     */
    public EntityImpl getXpeDccCfgUomEO() {
        return (EntityImpl) getEntity(ENTITY_XPEDCCCFGUOMEO);
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
     * Gets the attribute value for FEED_METHOD using the alias name FeedMethod.
     * @return the FEED_METHOD
     */
    public String getFeedMethod() {
        return (String) getAttributeInternal(FEEDMETHOD);
    }

    /**
     * Sets <code>value</code> as attribute value for FEED_METHOD using the alias name FeedMethod.
     * @param value value to set the FEED_METHOD
     */
    public void setFeedMethod(String value) {
        setAttributeInternal(FEEDMETHOD, value);
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
     * Gets the attribute value for ITEM_ID using the alias name ItemId.
     * @return the ITEM_ID
     */
    public String getItemId() {
        return (String) getAttributeInternal(ITEMID);
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
     * Gets the attribute value for UOM using the alias name Uom.
     * @return the UOM
     */
    public String getUom() {
        return (String) getAttributeInternal(UOM);
    }

    /**
     * Sets <code>value</code> as attribute value for UOM using the alias name Uom.
     * @param value value to set the UOM
     */
    public void setUom(String value) {
        setAttributeInternal(UOM, value);
    }

    /**
     * Gets the attribute value for UOM_DESC using the alias name UomDesc.
     * @return the UOM_DESC
     */
    public String getUomDesc() {
        return (String) getAttributeInternal(UOMDESC);
    }

    /**
     * Sets <code>value</code> as attribute value for UOM_DESC using the alias name UomDesc.
     * @param value value to set the UOM_DESC
     */
    public void setUomDesc(String value) {
        setAttributeInternal(UOMDESC, value);
    }

    /**
     * Gets the attribute value for PCSUOM using the alias name Pcsuom.
     * @return the PCSUOM
     */
    public String getPcsuom() {
        return (String) getAttributeInternal(PCSUOM);
    }

    /**
     * Sets <code>value</code> as attribute value for PCSUOM using the alias name Pcsuom.
     * @param value value to set the PCSUOM
     */
    public void setPcsuom(String value) {
        setAttributeInternal(PCSUOM, value);
    }

    /**
     * Gets the view accessor <code>RowSet</code> XpeDccGeneralItemListROVO_UOMLOV.
     */
    public RowSet getXpeDccGeneralItemListROVO_UOMLOV() {
        return (RowSet) getAttributeInternal(XPEDCCGENERALITEMLISTROVO_UOMLOV);
    }

    /**
     * Gets the view accessor <code>RowSet</code> LookupSharedAppModule_FeedMethodLOV.
     */
    public RowSet getLookupSharedAppModule_FeedMethodLOV() {
        return (RowSet) getAttributeInternal(LOOKUPSHAREDAPPMODULE_FEEDMETHODLOV);
    }

    /**
     * Gets the view accessor <code>RowSet</code> LookupSharedAppModule_XpeDccDicNewContractSetupROVO1.
     */
    public RowSet getLookupSharedAppModule_XpeDccDicNewContractSetupROVO1() {
        return (RowSet) getAttributeInternal(LOOKUPSHAREDAPPMODULE_XPEDCCDICNEWCONTRACTSETUPROVO1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> XpeDccGeneralItemListROVO1.
     */
    public RowSet getXpeDccGeneralItemListROVO1() {
        return (RowSet) getAttributeInternal(XPEDCCGENERALITEMLISTROVO1);
    }
}

