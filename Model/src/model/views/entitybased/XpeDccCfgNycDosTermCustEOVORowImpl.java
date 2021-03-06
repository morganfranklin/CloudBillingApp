package model.views.entitybased;

import java.sql.Timestamp;

import oracle.jbo.RowSet;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Tue Dec 12 23:17:40 EST 2017
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class XpeDccCfgNycDosTermCustEOVORowImpl extends ViewRowImpl {
    public static final int ENTITY_XPEDCCCFGNYCDOSTERMCUSTEO = 0;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        OriginId,
        TerminalId,
        PcsshortnameId,
        Inactive,
        InactiveDate,
        CreatedBy,
        CreatedDate,
        LastUpdatedBy,
        LastUpdatedDate,
        XpeDccCfgPCSShortNamesROVO1,
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
    public static final int ORIGINID = AttributesEnum.OriginId.index();
    public static final int TERMINALID = AttributesEnum.TerminalId.index();
    public static final int PCSSHORTNAMEID = AttributesEnum.PcsshortnameId.index();
    public static final int INACTIVE = AttributesEnum.Inactive.index();
    public static final int INACTIVEDATE = AttributesEnum.InactiveDate.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int CREATEDDATE = AttributesEnum.CreatedDate.index();
    public static final int LASTUPDATEDBY = AttributesEnum.LastUpdatedBy.index();
    public static final int LASTUPDATEDDATE = AttributesEnum.LastUpdatedDate.index();
    public static final int XPEDCCCFGPCSSHORTNAMESROVO1 = AttributesEnum.XpeDccCfgPCSShortNamesROVO1.index();
    public static final int LOOKUPSHAREDAPPMODULE_XPEDCCDICNEWCONTRACTSETUPROVO1 =
        AttributesEnum.LookupSharedAppModule_XpeDccDicNewContractSetupROVO1.index();

    /**
     * This is the default constructor (do not remove).
     */
    public XpeDccCfgNycDosTermCustEOVORowImpl() {
    }

    /**
     * Gets XpeDccCfgNycDosTermCustEO entity object.
     * @return the XpeDccCfgNycDosTermCustEO
     */
    public EntityImpl getXpeDccCfgNycDosTermCustEO() {
        return (EntityImpl) getEntity(ENTITY_XPEDCCCFGNYCDOSTERMCUSTEO);
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
     * Gets the attribute value for PCSSHORTNAME_ID using the alias name PcsshortnameId.
     * @return the PCSSHORTNAME_ID
     */
    public String getPcsshortnameId() {
        return (String) getAttributeInternal(PCSSHORTNAMEID);
    }

    /**
     * Sets <code>value</code> as attribute value for PCSSHORTNAME_ID using the alias name PcsshortnameId.
     * @param value value to set the PCSSHORTNAME_ID
     */
    public void setPcsshortnameId(String value) {
        setAttributeInternal(PCSSHORTNAMEID, value);
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
     * Gets the view accessor <code>RowSet</code> XpeDccCfgPCSShortNamesROVO1.
     */
    public RowSet getXpeDccCfgPCSShortNamesROVO1() {
        return (RowSet) getAttributeInternal(XPEDCCCFGPCSSHORTNAMESROVO1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> LookupSharedAppModule_XpeDccDicNewContractSetupROVO1.
     */
    public RowSet getLookupSharedAppModule_XpeDccDicNewContractSetupROVO1() {
        return (RowSet) getAttributeInternal(LOOKUPSHAREDAPPMODULE_XPEDCCDICNEWCONTRACTSETUPROVO1);
    }
}

