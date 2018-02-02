package model;

import java.math.BigDecimal;

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
// ---    Thu Feb 01 02:55:29 EST 2018
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class XpeDccContractLineImpl extends EntityImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        XpeContractId,
        XpeContractVersion,
        XpeContractLine,
        XpeFacility,
        XpeProductId,
        XpeProductUom,
        XpeQtyMin,
        XpeQtyMax,
        XpePeriodType,
        XpeIcon,
        XpeSwApprNbr,
        CurrencyCd,
        BusinessUnitGl,
        CreatedBy,
        LastUpdatedBy,
        CreatedDate,
        LastUpdatedDate,
        XpeDccContractDocTerm,
        XpeDccContractPricingTerm,
        XpeDccContractVersion,
        XpeDccContractPricingOver;
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
    public static final int XPECONTRACTLINE = AttributesEnum.XpeContractLine.index();
    public static final int XPEFACILITY = AttributesEnum.XpeFacility.index();
    public static final int XPEPRODUCTID = AttributesEnum.XpeProductId.index();
    public static final int XPEPRODUCTUOM = AttributesEnum.XpeProductUom.index();
    public static final int XPEQTYMIN = AttributesEnum.XpeQtyMin.index();
    public static final int XPEQTYMAX = AttributesEnum.XpeQtyMax.index();
    public static final int XPEPERIODTYPE = AttributesEnum.XpePeriodType.index();
    public static final int XPEICON = AttributesEnum.XpeIcon.index();
    public static final int XPESWAPPRNBR = AttributesEnum.XpeSwApprNbr.index();
    public static final int CURRENCYCD = AttributesEnum.CurrencyCd.index();
    public static final int BUSINESSUNITGL = AttributesEnum.BusinessUnitGl.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int LASTUPDATEDBY = AttributesEnum.LastUpdatedBy.index();
    public static final int CREATEDDATE = AttributesEnum.CreatedDate.index();
    public static final int LASTUPDATEDDATE = AttributesEnum.LastUpdatedDate.index();
    public static final int XPEDCCCONTRACTDOCTERM = AttributesEnum.XpeDccContractDocTerm.index();
    public static final int XPEDCCCONTRACTPRICINGTERM = AttributesEnum.XpeDccContractPricingTerm.index();
    public static final int XPEDCCCONTRACTVERSION = AttributesEnum.XpeDccContractVersion.index();
    public static final int XPEDCCCONTRACTPRICINGOVER = AttributesEnum.XpeDccContractPricingOver.index();

    /**
     * This is the default constructor (do not remove).
     */
    public XpeDccContractLineImpl() {
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
     * Gets the attribute value for XpeContractLine, using the alias name XpeContractLine.
     * @return the value of XpeContractLine
     */
    public String getXpeContractLine() {
        return (String) getAttributeInternal(XPECONTRACTLINE);
    }

    /**
     * Sets <code>value</code> as the attribute value for XpeContractLine.
     * @param value value to set the XpeContractLine
     */
    public void setXpeContractLine(String value) {
        setAttributeInternal(XPECONTRACTLINE, value);
    }

    /**
     * Gets the attribute value for XpeFacility, using the alias name XpeFacility.
     * @return the value of XpeFacility
     */
    public String getXpeFacility() {
        return (String) getAttributeInternal(XPEFACILITY);
    }

    /**
     * Sets <code>value</code> as the attribute value for XpeFacility.
     * @param value value to set the XpeFacility
     */
    public void setXpeFacility(String value) {
        setAttributeInternal(XPEFACILITY, value);
    }

    /**
     * Gets the attribute value for XpeProductId, using the alias name XpeProductId.
     * @return the value of XpeProductId
     */
    public String getXpeProductId() {
        return (String) getAttributeInternal(XPEPRODUCTID);
    }

    /**
     * Sets <code>value</code> as the attribute value for XpeProductId.
     * @param value value to set the XpeProductId
     */
    public void setXpeProductId(String value) {
        setAttributeInternal(XPEPRODUCTID, value);
    }

    /**
     * Gets the attribute value for XpeProductUom, using the alias name XpeProductUom.
     * @return the value of XpeProductUom
     */
    public String getXpeProductUom() {
        return (String) getAttributeInternal(XPEPRODUCTUOM);
    }

    /**
     * Sets <code>value</code> as the attribute value for XpeProductUom.
     * @param value value to set the XpeProductUom
     */
    public void setXpeProductUom(String value) {
        setAttributeInternal(XPEPRODUCTUOM, value);
    }

    /**
     * Gets the attribute value for XpeQtyMin, using the alias name XpeQtyMin.
     * @return the value of XpeQtyMin
     */
    public BigDecimal getXpeQtyMin() {
        return (BigDecimal) getAttributeInternal(XPEQTYMIN);
    }

    /**
     * Sets <code>value</code> as the attribute value for XpeQtyMin.
     * @param value value to set the XpeQtyMin
     */
    public void setXpeQtyMin(BigDecimal value) {
        setAttributeInternal(XPEQTYMIN, value);
    }

    /**
     * Gets the attribute value for XpeQtyMax, using the alias name XpeQtyMax.
     * @return the value of XpeQtyMax
     */
    public BigDecimal getXpeQtyMax() {
        return (BigDecimal) getAttributeInternal(XPEQTYMAX);
    }

    /**
     * Sets <code>value</code> as the attribute value for XpeQtyMax.
     * @param value value to set the XpeQtyMax
     */
    public void setXpeQtyMax(BigDecimal value) {
        setAttributeInternal(XPEQTYMAX, value);
    }

    /**
     * Gets the attribute value for XpePeriodType, using the alias name XpePeriodType.
     * @return the value of XpePeriodType
     */
    public String getXpePeriodType() {
        return (String) getAttributeInternal(XPEPERIODTYPE);
    }

    /**
     * Sets <code>value</code> as the attribute value for XpePeriodType.
     * @param value value to set the XpePeriodType
     */
    public void setXpePeriodType(String value) {
        setAttributeInternal(XPEPERIODTYPE, value);
    }

    /**
     * Gets the attribute value for XpeIcon, using the alias name XpeIcon.
     * @return the value of XpeIcon
     */
    public String getXpeIcon() {
        return (String) getAttributeInternal(XPEICON);
    }

    /**
     * Sets <code>value</code> as the attribute value for XpeIcon.
     * @param value value to set the XpeIcon
     */
    public void setXpeIcon(String value) {
        setAttributeInternal(XPEICON, value);
    }

    /**
     * Gets the attribute value for XpeSwApprNbr, using the alias name XpeSwApprNbr.
     * @return the value of XpeSwApprNbr
     */
    public String getXpeSwApprNbr() {
        return (String) getAttributeInternal(XPESWAPPRNBR);
    }

    /**
     * Sets <code>value</code> as the attribute value for XpeSwApprNbr.
     * @param value value to set the XpeSwApprNbr
     */
    public void setXpeSwApprNbr(String value) {
        setAttributeInternal(XPESWAPPRNBR, value);
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
     * Gets the attribute value for BusinessUnitGl, using the alias name BusinessUnitGl.
     * @return the value of BusinessUnitGl
     */
    public String getBusinessUnitGl() {
        return (String) getAttributeInternal(BUSINESSUNITGL);
    }

    /**
     * Sets <code>value</code> as the attribute value for BusinessUnitGl.
     * @param value value to set the BusinessUnitGl
     */
    public void setBusinessUnitGl(String value) {
        setAttributeInternal(BUSINESSUNITGL, value);
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
    public RowIterator getXpeDccContractDocTerm() {
        return (RowIterator) getAttributeInternal(XPEDCCCONTRACTDOCTERM);
    }

    /**
     * @return the associated entity oracle.jbo.RowIterator.
     */
    public RowIterator getXpeDccContractPricingTerm() {
        return (RowIterator) getAttributeInternal(XPEDCCCONTRACTPRICINGTERM);
    }

    /**
     * @return the associated entity XpeDccContractVersionImpl.
     */
    public XpeDccContractVersionImpl getXpeDccContractVersion() {
        return (XpeDccContractVersionImpl) getAttributeInternal(XPEDCCCONTRACTVERSION);
    }

    /**
     * Sets <code>value</code> as the associated entity XpeDccContractVersionImpl.
     */
    public void setXpeDccContractVersion(XpeDccContractVersionImpl value) {
        setAttributeInternal(XPEDCCCONTRACTVERSION, value);
    }

    /**
     * @return the associated entity oracle.jbo.RowIterator.
     */
    public RowIterator getXpeDccContractPricingOver() {
        return (RowIterator) getAttributeInternal(XPEDCCCONTRACTPRICINGOVER);
    }

    /**
     * @param xpeContractId key constituent
     * @param xpeContractVersion key constituent
     * @param xpeContractLine key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(String xpeContractId, String xpeContractVersion, String xpeContractLine) {
        return new Key(new Object[] { xpeContractId, xpeContractVersion, xpeContractLine });
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        return EntityDefImpl.findDefObject("model.XpeDccContractLine");
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
