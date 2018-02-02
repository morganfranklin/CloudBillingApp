package model.entities;

import java.sql.Timestamp;

import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.RowIterator;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.TransactionEvent;
import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu Feb 01 03:10:45 EST 2018
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class XpeDccCfgOgnAssTerminalsEOImpl extends EntityImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        TerminalId,
        OriginId,
        TerminalDesc,
        Inactive,
        InactiveDate,
        CreatedBy,
        CreatedDate,
        LastUpdatedBy,
        LastUpdatedDate,
        XpeDccCfgTerminalsEO,
        XpeDccCfgOriginsEO,
        XpeDccCfgNycDosTermCustEO;
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
    public static final int TERMINALID = AttributesEnum.TerminalId.index();
    public static final int ORIGINID = AttributesEnum.OriginId.index();
    public static final int TERMINALDESC = AttributesEnum.TerminalDesc.index();
    public static final int INACTIVE = AttributesEnum.Inactive.index();
    public static final int INACTIVEDATE = AttributesEnum.InactiveDate.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int CREATEDDATE = AttributesEnum.CreatedDate.index();
    public static final int LASTUPDATEDBY = AttributesEnum.LastUpdatedBy.index();
    public static final int LASTUPDATEDDATE = AttributesEnum.LastUpdatedDate.index();
    public static final int XPEDCCCFGTERMINALSEO = AttributesEnum.XpeDccCfgTerminalsEO.index();
    public static final int XPEDCCCFGORIGINSEO = AttributesEnum.XpeDccCfgOriginsEO.index();
    public static final int XPEDCCCFGNYCDOSTERMCUSTEO = AttributesEnum.XpeDccCfgNycDosTermCustEO.index();

    /**
     * This is the default constructor (do not remove).
     */
    public XpeDccCfgOgnAssTerminalsEOImpl() {
    }

    /**
     * Gets the attribute value for TerminalId, using the alias name TerminalId.
     * @return the value of TerminalId
     */
    public String getTerminalId() {
        return (String) getAttributeInternal(TERMINALID);
    }

    /**
     * Sets <code>value</code> as the attribute value for TerminalId.
     * @param value value to set the TerminalId
     */
    public void setTerminalId(String value) {
        setAttributeInternal(TERMINALID, value);
    }

    /**
     * Gets the attribute value for OriginId, using the alias name OriginId.
     * @return the value of OriginId
     */
    public String getOriginId() {
        return (String) getAttributeInternal(ORIGINID);
    }

    /**
     * Sets <code>value</code> as the attribute value for OriginId.
     * @param value value to set the OriginId
     */
    public void setOriginId(String value) {
        setAttributeInternal(ORIGINID, value);
    }

    /**
     * Gets the attribute value for TerminalDesc, using the alias name TerminalDesc.
     * @return the value of TerminalDesc
     */
    public String getTerminalDesc() {
        return (String) getAttributeInternal(TERMINALDESC);
    }

    /**
     * Sets <code>value</code> as the attribute value for TerminalDesc.
     * @param value value to set the TerminalDesc
     */
    public void setTerminalDesc(String value) {
        setAttributeInternal(TERMINALDESC, value);
    }

    /**
     * Gets the attribute value for Inactive, using the alias name Inactive.
     * @return the value of Inactive
     */
    public String getInactive() {
        return (String) getAttributeInternal(INACTIVE);
    }

    /**
     * Sets <code>value</code> as the attribute value for Inactive.
     * @param value value to set the Inactive
     */
    public void setInactive(String value) {
        setAttributeInternal(INACTIVE, value);
    }

    /**
     * Gets the attribute value for InactiveDate, using the alias name InactiveDate.
     * @return the value of InactiveDate
     */
    public Timestamp getInactiveDate() {
        return (Timestamp) getAttributeInternal(INACTIVEDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for InactiveDate.
     * @param value value to set the InactiveDate
     */
    public void setInactiveDate(Timestamp value) {
        setAttributeInternal(INACTIVEDATE, value);
    }

    /**
     * Gets the attribute value for CreatedBy, using the alias name CreatedBy.
     * @return the value of CreatedBy
     */
    public String getCreatedBy() {
        return (String) getAttributeInternal(CREATEDBY);
    }

    /**
     * Sets <code>value</code> as the attribute value for CreatedBy.
     * @param value value to set the CreatedBy
     */
    public void setCreatedBy(String value) {
        setAttributeInternal(CREATEDBY, value);
    }

    /**
     * Gets the attribute value for CreatedDate, using the alias name CreatedDate.
     * @return the value of CreatedDate
     */
    public Timestamp getCreatedDate() {
        return (Timestamp) getAttributeInternal(CREATEDDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for CreatedDate.
     * @param value value to set the CreatedDate
     */
    public void setCreatedDate(Timestamp value) {
        setAttributeInternal(CREATEDDATE, value);
    }

    /**
     * Gets the attribute value for LastUpdatedBy, using the alias name LastUpdatedBy.
     * @return the value of LastUpdatedBy
     */
    public String getLastUpdatedBy() {
        return (String) getAttributeInternal(LASTUPDATEDBY);
    }

    /**
     * Sets <code>value</code> as the attribute value for LastUpdatedBy.
     * @param value value to set the LastUpdatedBy
     */
    public void setLastUpdatedBy(String value) {
        setAttributeInternal(LASTUPDATEDBY, value);
    }

    /**
     * Gets the attribute value for LastUpdatedDate, using the alias name LastUpdatedDate.
     * @return the value of LastUpdatedDate
     */
    public Timestamp getLastUpdatedDate() {
        return (Timestamp) getAttributeInternal(LASTUPDATEDDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for LastUpdatedDate.
     * @param value value to set the LastUpdatedDate
     */
    public void setLastUpdatedDate(Timestamp value) {
        setAttributeInternal(LASTUPDATEDDATE, value);
    }

    /**
     * @return the associated entity XpeDccCfgTerminalsEOImpl.
     */
    public XpeDccCfgTerminalsEOImpl getXpeDccCfgTerminalsEO() {
        return (XpeDccCfgTerminalsEOImpl) getAttributeInternal(XPEDCCCFGTERMINALSEO);
    }

    /**
     * Sets <code>value</code> as the associated entity XpeDccCfgTerminalsEOImpl.
     */
    public void setXpeDccCfgTerminalsEO(XpeDccCfgTerminalsEOImpl value) {
        setAttributeInternal(XPEDCCCFGTERMINALSEO, value);
    }

    /**
     * @return the associated entity XpeDccCfgOriginsEOImpl.
     */
    public XpeDccCfgOriginsEOImpl getXpeDccCfgOriginsEO() {
        return (XpeDccCfgOriginsEOImpl) getAttributeInternal(XPEDCCCFGORIGINSEO);
    }

    /**
     * Sets <code>value</code> as the associated entity XpeDccCfgOriginsEOImpl.
     */
    public void setXpeDccCfgOriginsEO(XpeDccCfgOriginsEOImpl value) {
        setAttributeInternal(XPEDCCCFGORIGINSEO, value);
    }

    /**
     * @return the associated entity oracle.jbo.RowIterator.
     */
    public RowIterator getXpeDccCfgNycDosTermCustEO() {
        return (RowIterator) getAttributeInternal(XPEDCCCFGNYCDOSTERMCUSTEO);
    }

    /**
     * @param terminalId key constituent
     * @param originId key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(String terminalId, String originId) {
        return new Key(new Object[] { terminalId, originId });
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        return EntityDefImpl.findDefObject("model.entities.XpeDccCfgOgnAssTerminalsEO");
    }
    
    @Override
    protected void doDML(int i, TransactionEvent transactionEvent) {
        // TODO Implement this method
        String userName = "DB_ADMIN";
        ViewObjectImpl userInfoVO = (ViewObjectImpl)this.getDBTransaction().getRootApplicationModule().findViewObject("XpeDccUserInfoROVO");
        Row userInforVORow = userInfoVO.first();
        if(null!=userInforVORow)
            userName = (String)userInforVORow.getAttribute("USER_NAME");
        //INSERT
        if(i==this.DML_INSERT) 
            this.setCreatedBy(userName);
        //UPDATE
        if(i==this.DML_UPDATE) 
            this.setLastUpdatedBy(userName);
        
        super.doDML(i, transactionEvent);
    }
}
