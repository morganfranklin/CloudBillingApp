package model.entities;

import java.sql.Timestamp;

import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.domain.ClobDomain;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.TransactionEvent;
import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu Feb 01 03:02:28 EST 2018
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class XpeDccTermsEOImpl extends EntityImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        XpeDccTerm,
        XpeDccClause,
        XpeDccSeq,
        XpeDccTermTemplate,
        CreatedBy,
        LastUpdatedBy,
        CreatedDate,
        LastUpdatedDate,
        XpeDccTermMaster;
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
    public static final int XPEDCCTERM = AttributesEnum.XpeDccTerm.index();
    public static final int XPEDCCCLAUSE = AttributesEnum.XpeDccClause.index();
    public static final int XPEDCCSEQ = AttributesEnum.XpeDccSeq.index();
    public static final int XPEDCCTERMTEMPLATE = AttributesEnum.XpeDccTermTemplate.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int LASTUPDATEDBY = AttributesEnum.LastUpdatedBy.index();
    public static final int CREATEDDATE = AttributesEnum.CreatedDate.index();
    public static final int LASTUPDATEDDATE = AttributesEnum.LastUpdatedDate.index();
    public static final int XPEDCCTERMMASTER = AttributesEnum.XpeDccTermMaster.index();

    /**
     * This is the default constructor (do not remove).
     */
    public XpeDccTermsEOImpl() {
    }

    /**
     * Gets the attribute value for XpeDccTerm, using the alias name XpeDccTerm.
     * @return the value of XpeDccTerm
     */
    public String getXpeDccTerm() {
        return (String) getAttributeInternal(XPEDCCTERM);
    }

    /**
     * Sets <code>value</code> as the attribute value for XpeDccTerm.
     * @param value value to set the XpeDccTerm
     */
    public void setXpeDccTerm(String value) {
        setAttributeInternal(XPEDCCTERM, value);
    }

    /**
     * Gets the attribute value for XpeDccClause, using the alias name XpeDccClause.
     * @return the value of XpeDccClause
     */
    public String getXpeDccClause() {
        return (String) getAttributeInternal(XPEDCCCLAUSE);
    }

    /**
     * Sets <code>value</code> as the attribute value for XpeDccClause.
     * @param value value to set the XpeDccClause
     */
    public void setXpeDccClause(String value) {
        setAttributeInternal(XPEDCCCLAUSE, value);
    }

    /**
     * Gets the attribute value for XpeDccSeq, using the alias name XpeDccSeq.
     * @return the value of XpeDccSeq
     */
    public Integer getXpeDccSeq() {
        return (Integer) getAttributeInternal(XPEDCCSEQ);
    }

    /**
     * Sets <code>value</code> as the attribute value for XpeDccSeq.
     * @param value value to set the XpeDccSeq
     */
    public void setXpeDccSeq(Integer value) {
        setAttributeInternal(XPEDCCSEQ, value);
    }

    /**
     * Gets the attribute value for XpeDccTermTemplate, using the alias name XpeDccTermTemplate.
     * @return the value of XpeDccTermTemplate
     */
    public ClobDomain getXpeDccTermTemplate() {
        return (ClobDomain) getAttributeInternal(XPEDCCTERMTEMPLATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for XpeDccTermTemplate.
     * @param value value to set the XpeDccTermTemplate
     */
    public void setXpeDccTermTemplate(ClobDomain value) {
        setAttributeInternal(XPEDCCTERMTEMPLATE, value);
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
     * @return the associated entity XpeDccTermMasterEOImpl.
     */
    public XpeDccTermMasterEOImpl getXpeDccTermMaster() {
        return (XpeDccTermMasterEOImpl) getAttributeInternal(XPEDCCTERMMASTER);
    }

    /**
     * Sets <code>value</code> as the associated entity XpeDccTermMasterEOImpl.
     */
    public void setXpeDccTermMaster(XpeDccTermMasterEOImpl value) {
        setAttributeInternal(XPEDCCTERMMASTER, value);
    }

    /**
     * @param xpeDccClause key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(String xpeDccClause) {
        return new Key(new Object[] { xpeDccClause });
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        return EntityDefImpl.findDefObject("model.entities.XpeDccTermsEO");
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

