package model.entities;

import java.sql.Timestamp;

import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.domain.BlobDomain;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.TransactionEvent;
import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sun Apr 01 22:55:51 CDT 2018
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class XpeDccCfgMetalsFacilityEOImpl extends EntityImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        XpeFacilityId,
        CustomerCareReview,
        LegalReview,
        FinancialReview,
        SvpReview,
        CreatedBy,
        CreationDate,
        LastUpdatedBy,
        LastUpdateDate,
        Inactive,
        InactiveDate,
        SvpSignature;
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


    public static final int XPEFACILITYID = AttributesEnum.XpeFacilityId.index();
    public static final int CUSTOMERCAREREVIEW = AttributesEnum.CustomerCareReview.index();
    public static final int LEGALREVIEW = AttributesEnum.LegalReview.index();
    public static final int FINANCIALREVIEW = AttributesEnum.FinancialReview.index();
    public static final int SVPREVIEW = AttributesEnum.SvpReview.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int CREATIONDATE = AttributesEnum.CreationDate.index();
    public static final int LASTUPDATEDBY = AttributesEnum.LastUpdatedBy.index();
    public static final int LASTUPDATEDATE = AttributesEnum.LastUpdateDate.index();
    public static final int INACTIVE = AttributesEnum.Inactive.index();
    public static final int INACTIVEDATE = AttributesEnum.InactiveDate.index();
    public static final int SVPSIGNATURE = AttributesEnum.SvpSignature.index();

    /**
     * This is the default constructor (do not remove).
     */
    public XpeDccCfgMetalsFacilityEOImpl() {
    }

    /**
     * Gets the attribute value for XpeFacilityId, using the alias name XpeFacilityId.
     * @return the value of XpeFacilityId
     */
    public String getXpeFacilityId() {
        return (String) getAttributeInternal(XPEFACILITYID);
    }

    /**
     * Sets <code>value</code> as the attribute value for XpeFacilityId.
     * @param value value to set the XpeFacilityId
     */
    public void setXpeFacilityId(String value) {
        setAttributeInternal(XPEFACILITYID, value);
    }

    /**
     * Gets the attribute value for CustomerCareReview, using the alias name CustomerCareReview.
     * @return the value of CustomerCareReview
     */
    public String getCustomerCareReview() {
        return (String) getAttributeInternal(CUSTOMERCAREREVIEW);
    }

    /**
     * Sets <code>value</code> as the attribute value for CustomerCareReview.
     * @param value value to set the CustomerCareReview
     */
    public void setCustomerCareReview(String value) {
        setAttributeInternal(CUSTOMERCAREREVIEW, value);
    }

    /**
     * Gets the attribute value for LegalReview, using the alias name LegalReview.
     * @return the value of LegalReview
     */
    public String getLegalReview() {
        return (String) getAttributeInternal(LEGALREVIEW);
    }

    /**
     * Sets <code>value</code> as the attribute value for LegalReview.
     * @param value value to set the LegalReview
     */
    public void setLegalReview(String value) {
        setAttributeInternal(LEGALREVIEW, value);
    }

    /**
     * Gets the attribute value for FinancialReview, using the alias name FinancialReview.
     * @return the value of FinancialReview
     */
    public String getFinancialReview() {
        return (String) getAttributeInternal(FINANCIALREVIEW);
    }

    /**
     * Sets <code>value</code> as the attribute value for FinancialReview.
     * @param value value to set the FinancialReview
     */
    public void setFinancialReview(String value) {
        setAttributeInternal(FINANCIALREVIEW, value);
    }

    /**
     * Gets the attribute value for SvpReview, using the alias name SvpReview.
     * @return the value of SvpReview
     */
    public String getSvpReview() {
        return (String) getAttributeInternal(SVPREVIEW);
    }

    /**
     * Sets <code>value</code> as the attribute value for SvpReview.
     * @param value value to set the SvpReview
     */
    public void setSvpReview(String value) {
        setAttributeInternal(SVPREVIEW, value);
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
     * Gets the attribute value for SvpSignature, using the alias name SvpSignature.
     * @return the value of SvpSignature
     */
    public BlobDomain getSvpSignature() {
        return (BlobDomain) getAttributeInternal(SVPSIGNATURE);
    }

    /**
     * Sets <code>value</code> as the attribute value for SvpSignature.
     * @param value value to set the SvpSignature
     */
    public void setSvpSignature(BlobDomain value) {
        setAttributeInternal(SVPSIGNATURE, value);
    }

    /**
     * @param xpeFacilityId key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(String xpeFacilityId) {
        return new Key(new Object[] { xpeFacilityId });
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        return EntityDefImpl.findDefObject("model.entities.XpeDccCfgMetalsFacilityEO");
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
