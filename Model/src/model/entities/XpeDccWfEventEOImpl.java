package model.entities;

import java.sql.Timestamp;

import model.XpeDccContractVersionImpl;

import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.RowIterator;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.SequenceImpl;
import oracle.jbo.server.TransactionEvent;
import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Oct 18 17:39:56 EDT 2017
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class XpeDccWfEventEOImpl extends EntityImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        XpeContractId,
        XpeContractVersion,
        XpeEventNumber,
        XpeEventStatus,
        XpeEventType,
        CreatedBy,
        CreatedDate,
        LastUpdatedBy,
        LastUpdatedDate,
        XpeDccWfActionEO,
        XpeDccContractVersion;
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


    public static final int XPECONTRACTID = AttributesEnum.XpeContractId.index();
    public static final int XPECONTRACTVERSION = AttributesEnum.XpeContractVersion.index();
    public static final int XPEEVENTNUMBER = AttributesEnum.XpeEventNumber.index();
    public static final int XPEEVENTSTATUS = AttributesEnum.XpeEventStatus.index();
    public static final int XPEEVENTTYPE = AttributesEnum.XpeEventType.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int CREATEDDATE = AttributesEnum.CreatedDate.index();
    public static final int LASTUPDATEDBY = AttributesEnum.LastUpdatedBy.index();
    public static final int LASTUPDATEDDATE = AttributesEnum.LastUpdatedDate.index();
    public static final int XPEDCCWFACTIONEO = AttributesEnum.XpeDccWfActionEO.index();
    public static final int XPEDCCCONTRACTVERSION = AttributesEnum.XpeDccContractVersion.index();

    /**
     * This is the default constructor (do not remove).
     */
    public XpeDccWfEventEOImpl() {
    }

    /**
     * Gets the attribute value for XpeContractId, using the alias name XpeContractId.
     * @return the value of XpeContractId
     */
    public String getXpeContractId() {
        return (String) getAttributeInternal(XPECONTRACTID);
    }

    /**
     * Sets <code>value</code> as the attribute value for XpeContractId.
     * @param value value to set the XpeContractId
     */
    public void setXpeContractId(String value) {
        setAttributeInternal(XPECONTRACTID, value);
    }

    /**
     * Gets the attribute value for XpeContractVersion, using the alias name XpeContractVersion.
     * @return the value of XpeContractVersion
     */
    public String getXpeContractVersion() {
        return (String) getAttributeInternal(XPECONTRACTVERSION);
    }

    /**
     * Sets <code>value</code> as the attribute value for XpeContractVersion.
     * @param value value to set the XpeContractVersion
     */
    public void setXpeContractVersion(String value) {
        setAttributeInternal(XPECONTRACTVERSION, value);
    }

    /**
     * Gets the attribute value for XpeEventNumber, using the alias name XpeEventNumber.
     * @return the value of XpeEventNumber
     */
    public String getXpeEventNumber() {
        return (String) getAttributeInternal(XPEEVENTNUMBER);
    }

    /**
     * Sets <code>value</code> as the attribute value for XpeEventNumber.
     * @param value value to set the XpeEventNumber
     */
    public void setXpeEventNumber(String value) {
        setAttributeInternal(XPEEVENTNUMBER, value);
    }

    /**
     * Gets the attribute value for XpeEventStatus, using the alias name XpeEventStatus.
     * @return the value of XpeEventStatus
     */
    public String getXpeEventStatus() {
        return (String) getAttributeInternal(XPEEVENTSTATUS);
    }

    /**
     * Sets <code>value</code> as the attribute value for XpeEventStatus.
     * @param value value to set the XpeEventStatus
     */
    public void setXpeEventStatus(String value) {
        setAttributeInternal(XPEEVENTSTATUS, value);
    }

    /**
     * Gets the attribute value for XpeEventType, using the alias name XpeEventType.
     * @return the value of XpeEventType
     */
    public String getXpeEventType() {
        return (String) getAttributeInternal(XPEEVENTTYPE);
    }

    /**
     * Sets <code>value</code> as the attribute value for XpeEventType.
     * @param value value to set the XpeEventType
     */
    public void setXpeEventType(String value) {
        setAttributeInternal(XPEEVENTTYPE, value);
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
     * @return the associated entity oracle.jbo.RowIterator.
     */
    public RowIterator getXpeDccWfActionEO() {
        return (RowIterator) getAttributeInternal(XPEDCCWFACTIONEO);
    }

    /**
     * @return the associated entity model.XpeDccContractVersionImpl.
     */
    public XpeDccContractVersionImpl getXpeDccContractVersion() {
        return (XpeDccContractVersionImpl) getAttributeInternal(XPEDCCCONTRACTVERSION);
    }

    /**
     * Sets <code>value</code> as the associated entity model.XpeDccContractVersionImpl.
     */
    public void setXpeDccContractVersion(XpeDccContractVersionImpl value) {
        setAttributeInternal(XPEDCCCONTRACTVERSION, value);
    }

    /**
     * @param xpeEventNumber key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(String xpeEventNumber) {
        return new Key(new Object[] { xpeEventNumber });
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        return EntityDefImpl.findDefObject("model.entities.XpeDccWfEventEO");
    }


    protected String nextVal(String sequenceName) {
        SequenceImpl s = new SequenceImpl(sequenceName, getDBTransaction());
        return s.getSequenceNumber().toString();
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
        if(i==this.DML_INSERT){
            System.err.println("Inside Event INSERT: "+userName);
            this.setCreatedBy(userName);
            this.setLastUpdatedBy(userName);
        }
        //UPDATE
        if(i==this.DML_UPDATE) 
            this.setLastUpdatedBy(userName);
        
        super.doDML(i, transactionEvent);
    }
}

