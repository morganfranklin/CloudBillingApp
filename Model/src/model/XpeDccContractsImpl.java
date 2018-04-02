package model;

import java.math.BigInteger;

import java.sql.Timestamp;

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
// ---    Tue Aug 22 10:04:21 IST 2017
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class XpeDccContractsImpl extends EntityImpl {

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        XpeContractId,
        XpeContractDesc,
        Setid,
        CustId,
        CreatedBy,
        CurrencyCd,
        XpeDccPcsname,
        CustContractContactName,
        CustContractApproverEmail,
        AddressSeqNum,
        LastUpdatedBy,
        CreatedDate,
        LastUpdatedDate,
        XpeDccContractParty,
        XpeDccContractVersion,
        XpeDccPlatformEvent;
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
    public static final int XPECONTRACTDESC = AttributesEnum.XpeContractDesc.index();
    public static final int SETID = AttributesEnum.Setid.index();
    public static final int CUSTID = AttributesEnum.CustId.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int CURRENCYCD = AttributesEnum.CurrencyCd.index();
    public static final int XPEDCCPCSNAME = AttributesEnum.XpeDccPcsname.index();
    public static final int CUSTCONTRACTCONTACTNAME = AttributesEnum.CustContractContactName.index();
    public static final int CUSTCONTRACTAPPROVEREMAIL = AttributesEnum.CustContractApproverEmail.index();
    public static final int ADDRESSSEQNUM = AttributesEnum.AddressSeqNum.index();
    public static final int LASTUPDATEDBY = AttributesEnum.LastUpdatedBy.index();
    public static final int CREATEDDATE = AttributesEnum.CreatedDate.index();
    public static final int LASTUPDATEDDATE = AttributesEnum.LastUpdatedDate.index();
    public static final int XPEDCCCONTRACTPARTY = AttributesEnum.XpeDccContractParty.index();
    public static final int XPEDCCCONTRACTVERSION = AttributesEnum.XpeDccContractVersion.index();
    public static final int XPEDCCPLATFORMEVENT = AttributesEnum.XpeDccPlatformEvent.index();

    /**
     * This is the default constructor (do not remove).
     */
    public XpeDccContractsImpl() {
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
     * Gets the attribute value for XpeContractDesc, using the alias name XpeContractDesc.
     * @return the value of XpeContractDesc
     */
    public String getXpeContractDesc() {
        return (String) getAttributeInternal(XPECONTRACTDESC);
    }

    /**
     * Sets <code>value</code> as the attribute value for XpeContractDesc.
     * @param value value to set the XpeContractDesc
     */
    public void setXpeContractDesc(String value) {
        setAttributeInternal(XPECONTRACTDESC, value);
    }

    /**
     * Gets the attribute value for Setid, using the alias name Setid.
     * @return the value of Setid
     */
    public String getSetid() {
        return (String) getAttributeInternal(SETID);
    }

    /**
     * Sets <code>value</code> as the attribute value for Setid.
     * @param value value to set the Setid
     */
    public void setSetid(String value) {
        setAttributeInternal(SETID, value);
    }

    /**
     * Gets the attribute value for CustId, using the alias name CustId.
     * @return the value of CustId
     */
    public String getCustId() {
        return (String) getAttributeInternal(CUSTID);
    }

    /**
     * Sets <code>value</code> as the attribute value for CustId.
     * @param value value to set the CustId
     */
    public void setCustId(String value) {
        setAttributeInternal(CUSTID, value);
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
     * Gets the attribute value for CurrencyCd, using the alias name CurrencyCd.
     * @return the value of CurrencyCd
     */
    public String getCurrencyCd() {
        return (String) getAttributeInternal(CURRENCYCD);
    }

    /**
     * Sets <code>value</code> as the attribute value for CurrencyCd.
     * @param value value to set the CurrencyCd
     */
    public void setCurrencyCd(String value) {
        setAttributeInternal(CURRENCYCD, value);
    }

    /**
     * Gets the attribute value for XpeDccPcsname, using the alias name XpeDccPcsname.
     * @return the value of XpeDccPcsname
     */
    public String getXpeDccPcsname() {
        return (String) getAttributeInternal(XPEDCCPCSNAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for XpeDccPcsname.
     * @param value value to set the XpeDccPcsname
     */
    public void setXpeDccPcsname(String value) {
        setAttributeInternal(XPEDCCPCSNAME, value);
    }

    /**
     * Gets the attribute value for CustContractContactName, using the alias name CustContractContactName.
     * @return the value of CustContractContactName
     */
    public String getCustContractContactName() {
        return (String) getAttributeInternal(CUSTCONTRACTCONTACTNAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for CustContractContactName.
     * @param value value to set the CustContractContactName
     */
    public void setCustContractContactName(String value) {
        setAttributeInternal(CUSTCONTRACTCONTACTNAME, value);
    }

    /**
     * Gets the attribute value for CustContractApproverEmail, using the alias name CustContractApproverEmail.
     * @return the value of CustContractApproverEmail
     */
    public String getCustContractApproverEmail() {
        return (String) getAttributeInternal(CUSTCONTRACTAPPROVEREMAIL);
    }

    /**
     * Sets <code>value</code> as the attribute value for CustContractApproverEmail.
     * @param value value to set the CustContractApproverEmail
     */
    public void setCustContractApproverEmail(String value) {
        setAttributeInternal(CUSTCONTRACTAPPROVEREMAIL, value);
    }

    /**
     * Gets the attribute value for AddressSeqNum, using the alias name AddressSeqNum.
     * @return the value of AddressSeqNum
     */
    public BigInteger getAddressSeqNum() {
        return (BigInteger) getAttributeInternal(ADDRESSSEQNUM);
    }

    /**
     * Sets <code>value</code> as the attribute value for AddressSeqNum.
     * @param value value to set the AddressSeqNum
     */
    public void setAddressSeqNum(BigInteger value) {
        setAttributeInternal(ADDRESSSEQNUM, value);
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
     * Gets the attribute value for CreatedDate, using the alias name CreatedDate.
     * @return the value of CreatedDate
     */
    public Timestamp getCreatedDate() {
        return (Timestamp) getAttributeInternal(CREATEDDATE);
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
    public RowIterator getXpeDccContractParty() {
        return (RowIterator) getAttributeInternal(XPEDCCCONTRACTPARTY);
    }

    /**
     * @return the associated entity oracle.jbo.RowIterator.
     */
    public RowIterator getXpeDccContractVersion() {
        return (RowIterator) getAttributeInternal(XPEDCCCONTRACTVERSION);
    }

    /**
     * @return the associated entity oracle.jbo.RowIterator.
     */
    public RowIterator getXpeDccPlatformEvent() {
        return (RowIterator) getAttributeInternal(XPEDCCPLATFORMEVENT);
    }

    /**
     * @param xpeContractId key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(String xpeContractId) {
        return new Key(new Object[] { xpeContractId });
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        return EntityDefImpl.findDefObject("model.XpeDccContracts");
    }


    protected String nextVal(String sequenceName) {
        SequenceImpl s = new SequenceImpl(sequenceName, getDBTransaction());
        return "C"+s.getSequenceNumber().toString();
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
            this.setCreatedBy(userName);
            this.setLastUpdatedBy(userName);
        }
        //UPDATE
        if(i==this.DML_UPDATE) 
            this.setLastUpdatedBy(userName);
        
        super.doDML(i, transactionEvent);
    }
}

