package model.views.entitybased;

import java.sql.Timestamp;

import model.entities.XpeDccCfgOriginsEOImpl;

import oracle.jbo.RowIterator;
import oracle.jbo.RowSet;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu Oct 12 00:06:31 EDT 2017
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class XpeDccCfgOriginsEOVORowImpl extends ViewRowImpl {

    public static final int ENTITY_XPEDCCCFGORIGINSEO = 0;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        CreatedBy,
        CreatedDate,
        Inactive,
        InactiveDate,
        LastUpdatedBy,
        LastUpdatedDate,
        OriginDesc,
        OriginId,
        State,
        County,
        XpeDccNycDosDistrict,
        XpeDccCfgOgnAssTerminalsEOVO,
        LookupSharedAppModule_YONLOV,
        XpeDccCfgCountiesLOV,
        XpeDccCfgStatesLOV;
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
    public static final int INACTIVE = AttributesEnum.Inactive.index();
    public static final int INACTIVEDATE = AttributesEnum.InactiveDate.index();
    public static final int LASTUPDATEDBY = AttributesEnum.LastUpdatedBy.index();
    public static final int LASTUPDATEDDATE = AttributesEnum.LastUpdatedDate.index();
    public static final int ORIGINDESC = AttributesEnum.OriginDesc.index();
    public static final int ORIGINID = AttributesEnum.OriginId.index();
    public static final int STATE = AttributesEnum.State.index();
    public static final int COUNTY = AttributesEnum.County.index();
    public static final int XPEDCCNYCDOSDISTRICT = AttributesEnum.XpeDccNycDosDistrict.index();
    public static final int XPEDCCCFGOGNASSTERMINALSEOVO = AttributesEnum.XpeDccCfgOgnAssTerminalsEOVO.index();
    public static final int LOOKUPSHAREDAPPMODULE_YONLOV = AttributesEnum.LookupSharedAppModule_YONLOV.index();
    public static final int XPEDCCCFGCOUNTIESLOV = AttributesEnum.XpeDccCfgCountiesLOV.index();
    public static final int XPEDCCCFGSTATESLOV = AttributesEnum.XpeDccCfgStatesLOV.index();

    /**
     * This is the default constructor (do not remove).
     */
    public XpeDccCfgOriginsEOVORowImpl() {
    }

    /**
     * Gets XpeDccCfgOriginsEO entity object.
     * @return the XpeDccCfgOriginsEO
     */
    public XpeDccCfgOriginsEOImpl getXpeDccCfgOriginsEO() {
        return (XpeDccCfgOriginsEOImpl) getEntity(ENTITY_XPEDCCCFGORIGINSEO);
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
     * Sets <code>value</code> as attribute value for LAST_UPDATED_DATE using the alias name LastUpdatedDate.
     * @param value value to set the LAST_UPDATED_DATE
     */
    public void setLastUpdatedDate(Timestamp value) {
        setAttributeInternal(LASTUPDATEDDATE, value);
    }

    /**
     * Gets the attribute value for ORIGIN_DESC using the alias name OriginDesc.
     * @return the ORIGIN_DESC
     */
    public String getOriginDesc() {
        return (String) getAttributeInternal(ORIGINDESC);
    }

    /**
     * Sets <code>value</code> as attribute value for ORIGIN_DESC using the alias name OriginDesc.
     * @param value value to set the ORIGIN_DESC
     */
    public void setOriginDesc(String value) {
        setAttributeInternal(ORIGINDESC, value);
    }

    /**
     * Gets the attribute value for ORIGIN_ID using the alias name OriginId.
     * @return the ORIGIN_ID
     */
    public String getOriginId() {
        return (String) getAttributeInternal(ORIGINID);
    }

    /**
     * Sets <code>value</code> as attribute value for ORIGIN_ID using the alias name OriginId.
     * @param value value to set the ORIGIN_ID
     */
    public void setOriginId(String value) {
        setAttributeInternal(ORIGINID, value);
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
     * Gets the attribute value for COUNTY using the alias name County.
     * @return the COUNTY
     */
    public String getCounty() {
        return (String) getAttributeInternal(COUNTY);
    }

    /**
     * Sets <code>value</code> as attribute value for COUNTY using the alias name County.
     * @param value value to set the COUNTY
     */
    public void setCounty(String value) {
        setAttributeInternal(COUNTY, value);
    }

    /**
     * Gets the attribute value for XPE_DCC_NYC_DOS_DISTRICT using the alias name XpeDccNycDosDistrict.
     * @return the XPE_DCC_NYC_DOS_DISTRICT
     */
    public String getXpeDccNycDosDistrict() {
        return (String) getAttributeInternal(XPEDCCNYCDOSDISTRICT);
    }

    /**
     * Sets <code>value</code> as attribute value for XPE_DCC_NYC_DOS_DISTRICT using the alias name XpeDccNycDosDistrict.
     * @param value value to set the XPE_DCC_NYC_DOS_DISTRICT
     */
    public void setXpeDccNycDosDistrict(String value) {
        setAttributeInternal(XPEDCCNYCDOSDISTRICT, value);
    }

    /**
     * Gets the associated <code>RowIterator</code> using master-detail link XpeDccCfgOgnAssTerminalsEOVO.
     */
    public RowIterator getXpeDccCfgOgnAssTerminalsEOVO() {
        return (RowIterator) getAttributeInternal(XPEDCCCFGOGNASSTERMINALSEOVO);
    }

    /**
     * Gets the view accessor <code>RowSet</code> LookupSharedAppModule_YONLOV.
     */
    public RowSet getLookupSharedAppModule_YONLOV() {
        return (RowSet) getAttributeInternal(LOOKUPSHAREDAPPMODULE_YONLOV);
    }

    /**
     * Gets the view accessor <code>RowSet</code> XpeDccCfgCountiesLOV.
     */
    public RowSet getXpeDccCfgCountiesLOV() {
        return (RowSet) getAttributeInternal(XPEDCCCFGCOUNTIESLOV);
    }

    /**
     * Gets the view accessor <code>RowSet</code> XpeDccCfgStatesLOV.
     */
    public RowSet getXpeDccCfgStatesLOV() {
        return (RowSet) getAttributeInternal(XPEDCCCFGSTATESLOV);
    }
}

