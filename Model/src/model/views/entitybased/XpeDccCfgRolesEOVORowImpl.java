package model.views.entitybased;

import java.sql.Timestamp;

import model.entities.XpeDccCfgRolesEOImpl;

import oracle.jbo.Row;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sat Feb 24 15:29:54 CST 2018
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class XpeDccCfgRolesEOVORowImpl extends ViewRowImpl {

    public static final int ENTITY_XPEDCCCFGROLESEO = 0;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        CpeRole,
        CreatedBy,
        CreatedDate,
        LastUpdatedBy,
        LastUpdatedDate,
        PeoplesoftRole,
        XpeDccCfgRoleSecurityEOVO;
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

    public static final int CPEROLE = AttributesEnum.CpeRole.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int CREATEDDATE = AttributesEnum.CreatedDate.index();
    public static final int LASTUPDATEDBY = AttributesEnum.LastUpdatedBy.index();
    public static final int LASTUPDATEDDATE = AttributesEnum.LastUpdatedDate.index();
    public static final int PEOPLESOFTROLE = AttributesEnum.PeoplesoftRole.index();
    public static final int XPEDCCCFGROLESECURITYEOVO = AttributesEnum.XpeDccCfgRoleSecurityEOVO.index();

    /**
     * This is the default constructor (do not remove).
     */
    public XpeDccCfgRolesEOVORowImpl() {
    }

    /**
     * Gets XpeDccCfgRolesEO entity object.
     * @return the XpeDccCfgRolesEO
     */
    public XpeDccCfgRolesEOImpl getXpeDccCfgRolesEO() {
        return (XpeDccCfgRolesEOImpl) getEntity(ENTITY_XPEDCCCFGROLESEO);
    }

    /**
     * Gets the attribute value for CPE_ROLE using the alias name CpeRole.
     * @return the CPE_ROLE
     */
    public String getCpeRole() {
        return (String) getAttributeInternal(CPEROLE);
    }

    /**
     * Sets <code>value</code> as attribute value for CPE_ROLE using the alias name CpeRole.
     * @param value value to set the CPE_ROLE
     */
    public void setCpeRole(String value) {
        setAttributeInternal(CPEROLE, value);
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
     * Gets the attribute value for PEOPLESOFT_ROLE using the alias name PeoplesoftRole.
     * @return the PEOPLESOFT_ROLE
     */
    public String getPeoplesoftRole() {
        return (String) getAttributeInternal(PEOPLESOFTROLE);
    }

    /**
     * Sets <code>value</code> as attribute value for PEOPLESOFT_ROLE using the alias name PeoplesoftRole.
     * @param value value to set the PEOPLESOFT_ROLE
     */
    public void setPeoplesoftRole(String value) {
        setAttributeInternal(PEOPLESOFTROLE, value);
    }

    /**
     * Gets the associated <code>Row</code> using master-detail link XpeDccCfgRoleSecurityEOVO.
     */
    public Row getXpeDccCfgRoleSecurityEOVO() {
        return (Row) getAttributeInternal(XPEDCCCFGROLESECURITYEOVO);
    }

    /**
     * Sets the master-detail link XpeDccCfgRoleSecurityEOVO between this object and <code>value</code>.
     */
    public void setXpeDccCfgRoleSecurityEOVO(Row value) {
        setAttributeInternal(XPEDCCCFGROLESECURITYEOVO, value);
    }
}
