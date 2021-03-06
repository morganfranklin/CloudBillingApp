package model.entities;

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
// ---    Sun Sep 10 02:47:07 EDT 2017
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class XpeDccCfgPcsEOImpl extends EntityImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        SiteId,
        SiteDesc,
        DbLink,
        Inactive,
        InactiveDate,
        Activate,
        DirectToCustomer,
        EmailNotificationGroup,
        CreatedBy,
        CreatedDate,
        LastUpdatedBy,
        LastUpdatedDate,
        FacilityId,
        SiteOverride,
        PrintStage,
        XpeDccCfgPcsAssTerminalsEO,
        XpeDccCfgPcsAddressEO;
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


    public static final int SITEID = AttributesEnum.SiteId.index();
    public static final int SITEDESC = AttributesEnum.SiteDesc.index();
    public static final int DBLINK = AttributesEnum.DbLink.index();
    public static final int INACTIVE = AttributesEnum.Inactive.index();
    public static final int INACTIVEDATE = AttributesEnum.InactiveDate.index();
    public static final int ACTIVATE = AttributesEnum.Activate.index();
    public static final int DIRECTTOCUSTOMER = AttributesEnum.DirectToCustomer.index();
    public static final int EMAILNOTIFICATIONGROUP = AttributesEnum.EmailNotificationGroup.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int CREATEDDATE = AttributesEnum.CreatedDate.index();
    public static final int LASTUPDATEDBY = AttributesEnum.LastUpdatedBy.index();
    public static final int LASTUPDATEDDATE = AttributesEnum.LastUpdatedDate.index();
    public static final int FACILITYID = AttributesEnum.FacilityId.index();
    public static final int SITEOVERRIDE = AttributesEnum.SiteOverride.index();
    public static final int PRINTSTAGE = AttributesEnum.PrintStage.index();
    public static final int XPEDCCCFGPCSASSTERMINALSEO = AttributesEnum.XpeDccCfgPcsAssTerminalsEO.index();
    public static final int XPEDCCCFGPCSADDRESSEO = AttributesEnum.XpeDccCfgPcsAddressEO.index();

    /**
     * This is the default constructor (do not remove).
     */
    public XpeDccCfgPcsEOImpl() {
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        return EntityDefImpl.findDefObject("model.entities.XpeDccCfgPcsEO");
    }


    /**
     * Gets the attribute value for SiteId, using the alias name SiteId.
     * @return the value of SiteId
     */
    public String getSiteId() {
        return (String) getAttributeInternal(SITEID);
    }

    /**
     * Sets <code>value</code> as the attribute value for SiteId.
     * @param value value to set the SiteId
     */
    public void setSiteId(String value) {
        setAttributeInternal(SITEID, value);
    }

    /**
     * Gets the attribute value for SiteDesc, using the alias name SiteDesc.
     * @return the value of SiteDesc
     */
    public String getSiteDesc() {
        return (String) getAttributeInternal(SITEDESC);
    }

    /**
     * Sets <code>value</code> as the attribute value for SiteDesc.
     * @param value value to set the SiteDesc
     */
    public void setSiteDesc(String value) {
        setAttributeInternal(SITEDESC, value);
    }

    /**
     * Gets the attribute value for DbLink, using the alias name DbLink.
     * @return the value of DbLink
     */
    public String getDbLink() {
        return (String) getAttributeInternal(DBLINK);
    }

    /**
     * Sets <code>value</code> as the attribute value for DbLink.
     * @param value value to set the DbLink
     */
    public void setDbLink(String value) {
        setAttributeInternal(DBLINK, value);
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
     * Gets the attribute value for Activate, using the alias name Activate.
     * @return the value of Activate
     */
    public String getActivate() {
        return (String) getAttributeInternal(ACTIVATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for Activate.
     * @param value value to set the Activate
     */
    public void setActivate(String value) {
        setAttributeInternal(ACTIVATE, value);
    }

    /**
     * Gets the attribute value for DirectToCustomer, using the alias name DirectToCustomer.
     * @return the value of DirectToCustomer
     */
    public String getDirectToCustomer() {
        return (String) getAttributeInternal(DIRECTTOCUSTOMER);
    }

    /**
     * Sets <code>value</code> as the attribute value for DirectToCustomer.
     * @param value value to set the DirectToCustomer
     */
    public void setDirectToCustomer(String value) {
        setAttributeInternal(DIRECTTOCUSTOMER, value);
    }

    /**
     * Gets the attribute value for EmailNotificationGroup, using the alias name EmailNotificationGroup.
     * @return the value of EmailNotificationGroup
     */
    public String getEmailNotificationGroup() {
        return (String) getAttributeInternal(EMAILNOTIFICATIONGROUP);
    }

    /**
     * Sets <code>value</code> as the attribute value for EmailNotificationGroup.
     * @param value value to set the EmailNotificationGroup
     */
    public void setEmailNotificationGroup(String value) {
        setAttributeInternal(EMAILNOTIFICATIONGROUP, value);
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
     * Gets the attribute value for FacilityId, using the alias name FacilityId.
     * @return the value of FacilityId
     */
    public String getFacilityId() {
        return (String) getAttributeInternal(FACILITYID);
    }

    /**
     * Sets <code>value</code> as the attribute value for FacilityId.
     * @param value value to set the FacilityId
     */
    public void setFacilityId(String value) {
        setAttributeInternal(FACILITYID, value);
    }

    /**
     * Gets the attribute value for SiteOverride, using the alias name SiteOverride.
     * @return the value of SiteOverride
     */
    public String getSiteOverride() {
        return (String) getAttributeInternal(SITEOVERRIDE);
    }

    /**
     * Sets <code>value</code> as the attribute value for SiteOverride.
     * @param value value to set the SiteOverride
     */
    public void setSiteOverride(String value) {
        setAttributeInternal(SITEOVERRIDE, value);
    }

    /**
     * Gets the attribute value for PrintStage, using the alias name PrintStage.
     * @return the value of PrintStage
     */
    public String getPrintStage() {
        return (String) getAttributeInternal(PRINTSTAGE);
    }

    /**
     * Sets <code>value</code> as the attribute value for PrintStage.
     * @param value value to set the PrintStage
     */
    public void setPrintStage(String value) {
        setAttributeInternal(PRINTSTAGE, value);
    }

    /**
     * @return the associated entity oracle.jbo.RowIterator.
     */
    public RowIterator getXpeDccCfgPcsAssTerminalsEO() {
        return (RowIterator) getAttributeInternal(XPEDCCCFGPCSASSTERMINALSEO);
    }

    /**
     * @return the associated entity oracle.jbo.RowIterator.
     */
    public RowIterator getXpeDccCfgPcsAddressEO() {
        return (RowIterator) getAttributeInternal(XPEDCCCFGPCSADDRESSEO);
    }


    /**
     * @param siteId key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(String siteId) {
        return new Key(new Object[] { siteId });
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
            this.setCreatedBy(userName);
            this.setLastUpdatedBy(userName);
        }
        //UPDATE
        if(i==this.DML_UPDATE) 
            this.setLastUpdatedBy(userName);
        
        super.doDML(i, transactionEvent);
    }
}

