package model.entities;

import java.sql.Timestamp;

import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.TransactionEvent;
import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sat Feb 24 15:26:12 CST 2018
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class XpeDccCfgRolesEOImpl extends EntityImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        PeoplesoftRole,
        CpeRole,
        CreatedBy,
        LastUpdatedBy,
        CreatedDate,
        LastUpdatedDate,
        XpeDccCfgRoleSecurityEO;
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

    public static final int PEOPLESOFTROLE = AttributesEnum.PeoplesoftRole.index();
    public static final int CPEROLE = AttributesEnum.CpeRole.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int LASTUPDATEDBY = AttributesEnum.LastUpdatedBy.index();
    public static final int CREATEDDATE = AttributesEnum.CreatedDate.index();
    public static final int LASTUPDATEDDATE = AttributesEnum.LastUpdatedDate.index();
    public static final int XPEDCCCFGROLESECURITYEO = AttributesEnum.XpeDccCfgRoleSecurityEO.index();

    /**
     * This is the default constructor (do not remove).
     */
    public XpeDccCfgRolesEOImpl() {
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        return EntityDefImpl.findDefObject("model.entities.XpeDccCfgRolesEO");
    }

    /**
     * Gets the attribute value for PeoplesoftRole, using the alias name PeoplesoftRole.
     * @return the value of PeoplesoftRole
     */
    public String getPeoplesoftRole() {
        return (String) getAttributeInternal(PEOPLESOFTROLE);
    }

    /**
     * Sets <code>value</code> as the attribute value for PeoplesoftRole.
     * @param value value to set the PeoplesoftRole
     */
    public void setPeoplesoftRole(String value) {
        setAttributeInternal(PEOPLESOFTROLE, value);
    }

    /**
     * Gets the attribute value for CpeRole, using the alias name CpeRole.
     * @return the value of CpeRole
     */
    public String getCpeRole() {
        return (String) getAttributeInternal(CPEROLE);
    }

    /**
     * Sets <code>value</code> as the attribute value for CpeRole.
     * @param value value to set the CpeRole
     */
    public void setCpeRole(String value) {
        setAttributeInternal(CPEROLE, value);
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
     * @return the associated entity XpeDccCfgRoleSecurityEOImpl.
     */
    public XpeDccCfgRoleSecurityEOImpl getXpeDccCfgRoleSecurityEO() {
        return (XpeDccCfgRoleSecurityEOImpl) getAttributeInternal(XPEDCCCFGROLESECURITYEO);
    }

    /**
     * Sets <code>value</code> as the associated entity XpeDccCfgRoleSecurityEOImpl.
     */
    public void setXpeDccCfgRoleSecurityEO(XpeDccCfgRoleSecurityEOImpl value) {
        setAttributeInternal(XPEDCCCFGROLESECURITYEO, value);
    }

    /**
     * @param cpeRole key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(String cpeRole) {
        return new Key(new Object[] { cpeRole });
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

