package model.views.entitybased;

import java.sql.Timestamp;

import model.entities.XpeDccWfEventEOImpl;

import oracle.jbo.RowIterator;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Oct 18 15:48:24 EDT 2017
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class XpeDccWfEventEOVORowImpl extends ViewRowImpl {

    public static final int ENTITY_XPEDCCWFEVENTEO = 0;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        CreatedBy,
        CreatedDate,
        LastUpdatedBy,
        LastUpdatedDate,
        XpeContractId,
        XpeContractVersion,
        XpeEventNumber,
        XpeEventStatus,
        XpeEventType,
        XpeDccWfActionEOVO;
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

    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int CREATEDDATE = AttributesEnum.CreatedDate.index();
    public static final int LASTUPDATEDBY = AttributesEnum.LastUpdatedBy.index();
    public static final int LASTUPDATEDDATE = AttributesEnum.LastUpdatedDate.index();
    public static final int XPECONTRACTID = AttributesEnum.XpeContractId.index();
    public static final int XPECONTRACTVERSION = AttributesEnum.XpeContractVersion.index();
    public static final int XPEEVENTNUMBER = AttributesEnum.XpeEventNumber.index();
    public static final int XPEEVENTSTATUS = AttributesEnum.XpeEventStatus.index();
    public static final int XPEEVENTTYPE = AttributesEnum.XpeEventType.index();
    public static final int XPEDCCWFACTIONEOVO = AttributesEnum.XpeDccWfActionEOVO.index();

    /**
     * This is the default constructor (do not remove).
     */
    public XpeDccWfEventEOVORowImpl() {
    }

    /**
     * Gets XpeDccWfEventEO entity object.
     * @return the XpeDccWfEventEO
     */
    public XpeDccWfEventEOImpl getXpeDccWfEventEO() {
        return (XpeDccWfEventEOImpl) getEntity(ENTITY_XPEDCCWFEVENTEO);
    }

    /**
     * Gets the attribute value for CREATED_BY using the alias name CreatedBy.
     * @return the CREATED_BY
     */
    public String getCreatedBy() {
        return (String) getAttributeInternal(CREATEDBY);
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
     * Gets the attribute value for LAST_UPDATED_DATE using the alias name LastUpdatedDate.
     * @return the LAST_UPDATED_DATE
     */
    public Timestamp getLastUpdatedDate() {
        return (Timestamp) getAttributeInternal(LASTUPDATEDDATE);
    }

    /**
     * Gets the attribute value for XPE_CONTRACT_ID using the alias name XpeContractId.
     * @return the XPE_CONTRACT_ID
     */
    public String getXpeContractId() {
        return (String) getAttributeInternal(XPECONTRACTID);
    }

    /**
     * Sets <code>value</code> as attribute value for XPE_CONTRACT_ID using the alias name XpeContractId.
     * @param value value to set the XPE_CONTRACT_ID
     */
    public void setXpeContractId(String value) {
        setAttributeInternal(XPECONTRACTID, value);
    }

    /**
     * Gets the attribute value for XPE_CONTRACT_VERSION using the alias name XpeContractVersion.
     * @return the XPE_CONTRACT_VERSION
     */
    public String getXpeContractVersion() {
        return (String) getAttributeInternal(XPECONTRACTVERSION);
    }

    /**
     * Sets <code>value</code> as attribute value for XPE_CONTRACT_VERSION using the alias name XpeContractVersion.
     * @param value value to set the XPE_CONTRACT_VERSION
     */
    public void setXpeContractVersion(String value) {
        setAttributeInternal(XPECONTRACTVERSION, value);
    }

    /**
     * Gets the attribute value for XPE_EVENT_NUMBER using the alias name XpeEventNumber.
     * @return the XPE_EVENT_NUMBER
     */
    public String getXpeEventNumber() {
        return (String) getAttributeInternal(XPEEVENTNUMBER);
    }

    /**
     * Sets <code>value</code> as attribute value for XPE_EVENT_NUMBER using the alias name XpeEventNumber.
     * @param value value to set the XPE_EVENT_NUMBER
     */
    public void setXpeEventNumber(String value) {
        setAttributeInternal(XPEEVENTNUMBER, value);
    }

    /**
     * Gets the attribute value for XPE_EVENT_STATUS using the alias name XpeEventStatus.
     * @return the XPE_EVENT_STATUS
     */
    public String getXpeEventStatus() {
        return (String) getAttributeInternal(XPEEVENTSTATUS);
    }

    /**
     * Sets <code>value</code> as attribute value for XPE_EVENT_STATUS using the alias name XpeEventStatus.
     * @param value value to set the XPE_EVENT_STATUS
     */
    public void setXpeEventStatus(String value) {
        setAttributeInternal(XPEEVENTSTATUS, value);
    }

    /**
     * Gets the attribute value for XPE_EVENT_TYPE using the alias name XpeEventType.
     * @return the XPE_EVENT_TYPE
     */
    public String getXpeEventType() {
        return (String) getAttributeInternal(XPEEVENTTYPE);
    }

    /**
     * Sets <code>value</code> as attribute value for XPE_EVENT_TYPE using the alias name XpeEventType.
     * @param value value to set the XPE_EVENT_TYPE
     */
    public void setXpeEventType(String value) {
        setAttributeInternal(XPEEVENTTYPE, value);
    }

    /**
     * Gets the associated <code>RowIterator</code> using master-detail link XpeDccWfActionEOVO.
     */
    public RowIterator getXpeDccWfActionEOVO() {
        return (RowIterator) getAttributeInternal(XPEDCCWFACTIONEOVO);
    }
}

