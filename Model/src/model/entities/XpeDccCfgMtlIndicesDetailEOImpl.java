package model.entities;

import java.math.BigDecimal;
import java.math.BigInteger;

import java.sql.Timestamp;

import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.TransactionEvent;
import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Mar 07 23:48:32 CST 2018
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class XpeDccCfgMtlIndicesDetailEOImpl extends EntityImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        XpeMtlIndexDtl,
        XpeStartDate,
        XpeEndDate,
        XpeIndexPrice,
        XpeIndexChangeId,
        CreatedBy,
        CreationDate,
        LastUpdatedBy,
        LastUpdateDate,
        XpeDccCfgMtlIndicesHeaderEO;
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
    public static final int XPEMTLINDEXDTL = AttributesEnum.XpeMtlIndexDtl.index();
    public static final int XPESTARTDATE = AttributesEnum.XpeStartDate.index();
    public static final int XPEENDDATE = AttributesEnum.XpeEndDate.index();
    public static final int XPEINDEXPRICE = AttributesEnum.XpeIndexPrice.index();
    public static final int XPEINDEXCHANGEID = AttributesEnum.XpeIndexChangeId.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int CREATIONDATE = AttributesEnum.CreationDate.index();
    public static final int LASTUPDATEDBY = AttributesEnum.LastUpdatedBy.index();
    public static final int LASTUPDATEDATE = AttributesEnum.LastUpdateDate.index();
    public static final int XPEDCCCFGMTLINDICESHEADEREO = AttributesEnum.XpeDccCfgMtlIndicesHeaderEO.index();

    /**
     * This is the default constructor (do not remove).
     */
    public XpeDccCfgMtlIndicesDetailEOImpl() {
    }

    /**
     * Gets the attribute value for XpeMtlIndexDtl, using the alias name XpeMtlIndexDtl.
     * @return the value of XpeMtlIndexDtl
     */
    public BigDecimal getXpeMtlIndexDtl() {
        return (BigDecimal) getAttributeInternal(XPEMTLINDEXDTL);
    }

    /**
     * Sets <code>value</code> as the attribute value for XpeMtlIndexDtl.
     * @param value value to set the XpeMtlIndexDtl
     */
    public void setXpeMtlIndexDtl(BigDecimal value) {
        setAttributeInternal(XPEMTLINDEXDTL, value);
    }

    /**
     * Gets the attribute value for XpeStartDate, using the alias name XpeStartDate.
     * @return the value of XpeStartDate
     */
    public Timestamp getXpeStartDate() {
        return (Timestamp) getAttributeInternal(XPESTARTDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for XpeStartDate.
     * @param value value to set the XpeStartDate
     */
    public void setXpeStartDate(Timestamp value) {
        setAttributeInternal(XPESTARTDATE, value);
    }

    /**
     * Gets the attribute value for XpeEndDate, using the alias name XpeEndDate.
     * @return the value of XpeEndDate
     */
    public Timestamp getXpeEndDate() {
        return (Timestamp) getAttributeInternal(XPEENDDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for XpeEndDate.
     * @param value value to set the XpeEndDate
     */
    public void setXpeEndDate(Timestamp value) {
        setAttributeInternal(XPEENDDATE, value);
    }

    /**
     * Gets the attribute value for XpeIndexPrice, using the alias name XpeIndexPrice.
     * @return the value of XpeIndexPrice
     */
    public BigInteger getXpeIndexPrice() {
        return (BigInteger) getAttributeInternal(XPEINDEXPRICE);
    }

    /**
     * Sets <code>value</code> as the attribute value for XpeIndexPrice.
     * @param value value to set the XpeIndexPrice
     */
    public void setXpeIndexPrice(BigInteger value) {
        setAttributeInternal(XPEINDEXPRICE, value);
    }

    /**
     * Gets the attribute value for XpeIndexChangeId, using the alias name XpeIndexChangeId.
     * @return the value of XpeIndexChangeId
     */
    public BigDecimal getXpeIndexChangeId() {
        return (BigDecimal) getAttributeInternal(XPEINDEXCHANGEID);
    }

    /**
     * Sets <code>value</code> as the attribute value for XpeIndexChangeId.
     * @param value value to set the XpeIndexChangeId
     */
    public void setXpeIndexChangeId(BigDecimal value) {
        setAttributeInternal(XPEINDEXCHANGEID, value);
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
     * Gets the attribute value for CreationDate, using the alias name CreationDate.
     * @return the value of CreationDate
     */
    public Timestamp getCreationDate() {
        return (Timestamp) getAttributeInternal(CREATIONDATE);
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
     * Gets the attribute value for LastUpdateDate, using the alias name LastUpdateDate.
     * @return the value of LastUpdateDate
     */
    public Timestamp getLastUpdateDate() {
        return (Timestamp) getAttributeInternal(LASTUPDATEDATE);
    }

    /**
     * @return the associated entity XpeDccCfgMtlIndicesHeaderEOImpl.
     */
    public XpeDccCfgMtlIndicesHeaderEOImpl getXpeDccCfgMtlIndicesHeaderEO() {
        return (XpeDccCfgMtlIndicesHeaderEOImpl) getAttributeInternal(XPEDCCCFGMTLINDICESHEADEREO);
    }

    /**
     * Sets <code>value</code> as the associated entity XpeDccCfgMtlIndicesHeaderEOImpl.
     */
    public void setXpeDccCfgMtlIndicesHeaderEO(XpeDccCfgMtlIndicesHeaderEOImpl value) {
        setAttributeInternal(XPEDCCCFGMTLINDICESHEADEREO, value);
    }

    /**
     * @param xpeMtlIndexDtl key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(BigDecimal xpeMtlIndexDtl) {
        return new Key(new Object[] { xpeMtlIndexDtl });
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        return EntityDefImpl.findDefObject("model.entities.XpeDccCfgMtlIndicesDetailEO");
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

