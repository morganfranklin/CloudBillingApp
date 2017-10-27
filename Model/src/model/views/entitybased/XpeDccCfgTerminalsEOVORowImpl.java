package model.views.entitybased;

import java.sql.Timestamp;

import model.entities.XpeDccCfgTerminalsEOImpl;

import oracle.jbo.RowIterator;
import oracle.jbo.RowSet;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sun Sep 10 03:02:20 EDT 2017
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class XpeDccCfgTerminalsEOVORowImpl extends ViewRowImpl {


    public static final int ENTITY_XPEDCCCFGTERMINALSEO = 0;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        TerminalId,
        TerminalType,
        TerminalDesc,
        County,
        State,
        CreatedBy,
        CreatedDate,
        Inactive,
        InactiveDate,
        LastUpdatedBy,
        LastUpdatedDate,
        XpeDccCfgDstAssTerminalsEOVO,
        XpeDccCfgPcsAssTerminalsEOVO,
        XpeDccCfgOgnAssTerminalsEOVO,
        LookupSharedAppModule_TerminalTypeLOV,
        LookupSharedAppModule_YorNLOV,
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


    public static final int TERMINALID = AttributesEnum.TerminalId.index();
    public static final int TERMINALTYPE = AttributesEnum.TerminalType.index();
    public static final int TERMINALDESC = AttributesEnum.TerminalDesc.index();
    public static final int COUNTY = AttributesEnum.County.index();
    public static final int STATE = AttributesEnum.State.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int CREATEDDATE = AttributesEnum.CreatedDate.index();
    public static final int INACTIVE = AttributesEnum.Inactive.index();
    public static final int INACTIVEDATE = AttributesEnum.InactiveDate.index();
    public static final int LASTUPDATEDBY = AttributesEnum.LastUpdatedBy.index();
    public static final int LASTUPDATEDDATE = AttributesEnum.LastUpdatedDate.index();
    public static final int XPEDCCCFGDSTASSTERMINALSEOVO = AttributesEnum.XpeDccCfgDstAssTerminalsEOVO.index();
    public static final int XPEDCCCFGPCSASSTERMINALSEOVO = AttributesEnum.XpeDccCfgPcsAssTerminalsEOVO.index();
    public static final int XPEDCCCFGOGNASSTERMINALSEOVO = AttributesEnum.XpeDccCfgOgnAssTerminalsEOVO.index();
    public static final int LOOKUPSHAREDAPPMODULE_TERMINALTYPELOV =
        AttributesEnum.LookupSharedAppModule_TerminalTypeLOV.index();
    public static final int LOOKUPSHAREDAPPMODULE_YORNLOV = AttributesEnum.LookupSharedAppModule_YorNLOV.index();
    public static final int XPEDCCCFGCOUNTIESLOV = AttributesEnum.XpeDccCfgCountiesLOV.index();
    public static final int XPEDCCCFGSTATESLOV = AttributesEnum.XpeDccCfgStatesLOV.index();

    /**
     * This is the default constructor (do not remove).
     */
    public XpeDccCfgTerminalsEOVORowImpl() {
    }

    /**
     * Gets XpeDccCfgTerminalsEO entity object.
     * @return the XpeDccCfgTerminalsEO
     */
    public XpeDccCfgTerminalsEOImpl getXpeDccCfgTerminalsEO() {
        return (XpeDccCfgTerminalsEOImpl) getEntity(ENTITY_XPEDCCCFGTERMINALSEO);
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
     * Gets the attribute value for TERMINAL_DESC using the alias name TerminalDesc.
     * @return the TERMINAL_DESC
     */
    public String getTerminalDesc() {
        return (String) getAttributeInternal(TERMINALDESC);
    }

    /**
     * Sets <code>value</code> as attribute value for TERMINAL_DESC using the alias name TerminalDesc.
     * @param value value to set the TERMINAL_DESC
     */
    public void setTerminalDesc(String value) {
        setAttributeInternal(TERMINALDESC, value);
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
     * Gets the attribute value for TERMINAL_TYPE using the alias name TerminalType.
     * @return the TERMINAL_TYPE
     */
    public String getTerminalType() {
        return (String) getAttributeInternal(TERMINALTYPE);
    }

    /**
     * Sets <code>value</code> as attribute value for TERMINAL_TYPE using the alias name TerminalType.
     * @param value value to set the TERMINAL_TYPE
     */
    public void setTerminalType(String value) {
        setAttributeInternal(TERMINALTYPE, value);
    }

    /**
     * Gets the associated <code>RowIterator</code> using master-detail link XpeDccCfgDstAssTerminalsEOVO.
     */
    public RowIterator getXpeDccCfgDstAssTerminalsEOVO() {
        return (RowIterator) getAttributeInternal(XPEDCCCFGDSTASSTERMINALSEOVO);
    }

    /**
     * Gets the associated <code>RowIterator</code> using master-detail link XpeDccCfgPcsAssTerminalsEOVO.
     */
    public RowIterator getXpeDccCfgPcsAssTerminalsEOVO() {
        return (RowIterator) getAttributeInternal(XPEDCCCFGPCSASSTERMINALSEOVO);
    }

    /**
     * Gets the associated <code>RowIterator</code> using master-detail link XpeDccCfgOgnAssTerminalsEOVO.
     */
    public RowIterator getXpeDccCfgOgnAssTerminalsEOVO() {
        return (RowIterator) getAttributeInternal(XPEDCCCFGOGNASSTERMINALSEOVO);
    }

    /**
     * Gets the view accessor <code>RowSet</code> LookupSharedAppModule_TerminalTypeLOV.
     */
    public RowSet getLookupSharedAppModule_TerminalTypeLOV() {
        return (RowSet) getAttributeInternal(LOOKUPSHAREDAPPMODULE_TERMINALTYPELOV);
    }

    /**
     * Gets the view accessor <code>RowSet</code> LookupSharedAppModule_YorNLOV.
     */
    public RowSet getLookupSharedAppModule_YorNLOV() {
        return (RowSet) getAttributeInternal(LOOKUPSHAREDAPPMODULE_YORNLOV);
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

