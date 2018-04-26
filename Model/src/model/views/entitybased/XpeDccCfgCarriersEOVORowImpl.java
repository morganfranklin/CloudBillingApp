package model.views.entitybased;

import java.sql.Timestamp;

import model.entities.XpeDccCfgCarriersEOImpl;

import oracle.jbo.RowSet;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Tue Oct 31 12:30:39 EDT 2017
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class XpeDccCfgCarriersEOVORowImpl extends ViewRowImpl {


    public static final int ENTITY_XPEDCCCFGCARRIERSEO = 0;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        CarrierId,
        CarrierName,
        State,
        Inactive,
        InactiveDate,
        CreatedBy,
        CreatedDate,
        LastUpdatedBy,
        LastUpdatedDate,
        LookupSharedAppModule_YONLOV,
        XpeDccGeneralItemListROVO3;
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


    public static final int CARRIERID = AttributesEnum.CarrierId.index();
    public static final int CARRIERNAME = AttributesEnum.CarrierName.index();
    public static final int STATE = AttributesEnum.State.index();
    public static final int INACTIVE = AttributesEnum.Inactive.index();
    public static final int INACTIVEDATE = AttributesEnum.InactiveDate.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int CREATEDDATE = AttributesEnum.CreatedDate.index();
    public static final int LASTUPDATEDBY = AttributesEnum.LastUpdatedBy.index();
    public static final int LASTUPDATEDDATE = AttributesEnum.LastUpdatedDate.index();
    public static final int LOOKUPSHAREDAPPMODULE_YONLOV = AttributesEnum.LookupSharedAppModule_YONLOV.index();
    public static final int XPEDCCGENERALITEMLISTROVO3 = AttributesEnum.XpeDccGeneralItemListROVO3.index();

    /**
     * This is the default constructor (do not remove).
     */
    public XpeDccCfgCarriersEOVORowImpl() {
    }

    /**
     * Gets XpeDccCfgCarriersEO entity object.
     * @return the XpeDccCfgCarriersEO
     */
    public XpeDccCfgCarriersEOImpl getXpeDccCfgCarriersEO() {
        return (XpeDccCfgCarriersEOImpl) getEntity(ENTITY_XPEDCCCFGCARRIERSEO);
    }

    /**
     * Gets the attribute value for CARRIER_ID using the alias name CarrierId.
     * @return the CARRIER_ID
     */
    public String getCarrierId() {
        return (String) getAttributeInternal(CARRIERID);
    }

    /**
     * Sets <code>value</code> as attribute value for CARRIER_ID using the alias name CarrierId.
     * @param value value to set the CARRIER_ID
     */
    public void setCarrierId(String value) {
        setAttributeInternal(CARRIERID, value);
    }

    /**
     * Gets the attribute value for CARRIER_NAME using the alias name CarrierName.
     * @return the CARRIER_NAME
     */
    public String getCarrierName() {
        return (String) getAttributeInternal(CARRIERNAME);
    }

    /**
     * Sets <code>value</code> as attribute value for CARRIER_NAME using the alias name CarrierName.
     * @param value value to set the CARRIER_NAME
     */
    public void setCarrierName(String value) {
        if (null != value) {
            setAttributeInternal(CARRIERNAME, value.toUpperCase());
        } else {
            setAttributeInternal(CARRIERNAME, value);
        }
    }

    /**
     * Gets the attribute value for STATE using the alias name State.
     * @return the STATE
     */
    public String getState() {
        return (String) getAttributeInternal(STATE);
    }

    /**
     * Sets <code>value</code> as attribute value for STATE using the alias name State.
     * @param value value to set the STATE
     */
    public void setState(String value) {
        setAttributeInternal(STATE, value);
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
     * Gets the view accessor <code>RowSet</code> LookupSharedAppModule_YONLOV.
     */
    public RowSet getLookupSharedAppModule_YONLOV() {
        return (RowSet) getAttributeInternal(LOOKUPSHAREDAPPMODULE_YONLOV);
    }

    /**
     * Gets the view accessor <code>RowSet</code> XpeDccGeneralItemListROVO3.
     */
    public RowSet getXpeDccGeneralItemListROVO3() {
        return (RowSet) getAttributeInternal(XPEDCCGENERALITEMLISTROVO3);
    }
}

