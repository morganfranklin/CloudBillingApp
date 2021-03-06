package model.entities;

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
// ---    Sun Apr 01 23:37:37 CDT 2018
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class XpeDccCfgProductserviceEOImpl extends EntityImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        ItemId,
        ItemType,
        Inoutbound,
        Description,
        Category,
        ClassType,
        ClassId,
        Inactive,
        InactiveDate,
        CreatedBy,
        CreatedDate,
        LastUpdatedBy,
        LastUpdatedDate,
        WeightClass,
        XpeDccCfgUomEO;
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
    public static final int ITEMID = AttributesEnum.ItemId.index();
    public static final int ITEMTYPE = AttributesEnum.ItemType.index();
    public static final int INOUTBOUND = AttributesEnum.Inoutbound.index();
    public static final int DESCRIPTION = AttributesEnum.Description.index();
    public static final int CATEGORY = AttributesEnum.Category.index();
    public static final int CLASSTYPE = AttributesEnum.ClassType.index();
    public static final int CLASSID = AttributesEnum.ClassId.index();
    public static final int INACTIVE = AttributesEnum.Inactive.index();
    public static final int INACTIVEDATE = AttributesEnum.InactiveDate.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int CREATEDDATE = AttributesEnum.CreatedDate.index();
    public static final int LASTUPDATEDBY = AttributesEnum.LastUpdatedBy.index();
    public static final int LASTUPDATEDDATE = AttributesEnum.LastUpdatedDate.index();
    public static final int WEIGHTCLASS = AttributesEnum.WeightClass.index();
    public static final int XPEDCCCFGUOMEO = AttributesEnum.XpeDccCfgUomEO.index();

    /**
     * This is the default constructor (do not remove).
     */
    public XpeDccCfgProductserviceEOImpl() {
    }

    /**
     * Gets the attribute value for ItemId, using the alias name ItemId.
     * @return the value of ItemId
     */
    public String getItemId() {
        return (String) getAttributeInternal(ITEMID);
    }

    /**
     * Sets <code>value</code> as the attribute value for ItemId.
     * @param value value to set the ItemId
     */
    public void setItemId(String value) {
        setAttributeInternal(ITEMID, value);
    }

    /**
     * Gets the attribute value for ItemType, using the alias name ItemType.
     * @return the value of ItemType
     */
    public String getItemType() {
        return (String) getAttributeInternal(ITEMTYPE);
    }

    /**
     * Sets <code>value</code> as the attribute value for ItemType.
     * @param value value to set the ItemType
     */
    public void setItemType(String value) {
        setAttributeInternal(ITEMTYPE, value);
    }

    /**
     * Gets the attribute value for Inoutbound, using the alias name Inoutbound.
     * @return the value of Inoutbound
     */
    public String getInoutbound() {
        return (String) getAttributeInternal(INOUTBOUND);
    }

    /**
     * Sets <code>value</code> as the attribute value for Inoutbound.
     * @param value value to set the Inoutbound
     */
    public void setInoutbound(String value) {
        setAttributeInternal(INOUTBOUND, value);
    }

    /**
     * Gets the attribute value for Description, using the alias name Description.
     * @return the value of Description
     */
    public String getDescription() {
        return (String) getAttributeInternal(DESCRIPTION);
    }

    /**
     * Sets <code>value</code> as the attribute value for Description.
     * @param value value to set the Description
     */
    public void setDescription(String value) {
        setAttributeInternal(DESCRIPTION, value);
    }

    /**
     * Gets the attribute value for Category, using the alias name Category.
     * @return the value of Category
     */
    public String getCategory() {
        return (String) getAttributeInternal(CATEGORY);
    }

    /**
     * Sets <code>value</code> as the attribute value for Category.
     * @param value value to set the Category
     */
    public void setCategory(String value) {
        setAttributeInternal(CATEGORY, value);
    }

    /**
     * Gets the attribute value for ClassType, using the alias name ClassType.
     * @return the value of ClassType
     */
    public String getClassType() {
        return (String) getAttributeInternal(CLASSTYPE);
    }

    /**
     * Sets <code>value</code> as the attribute value for ClassType.
     * @param value value to set the ClassType
     */
    public void setClassType(String value) {
        setAttributeInternal(CLASSTYPE, value);
    }

    /**
     * Gets the attribute value for ClassId, using the alias name ClassId.
     * @return the value of ClassId
     */
    public String getClassId() {
        return (String) getAttributeInternal(CLASSID);
    }

    /**
     * Sets <code>value</code> as the attribute value for ClassId.
     * @param value value to set the ClassId
     */
    public void setClassId(String value) {
        setAttributeInternal(CLASSID, value);
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
     * Gets the attribute value for WeightClass, using the alias name WeightClass.
     * @return the value of WeightClass
     */
    public String getWeightClass() {
        return (String) getAttributeInternal(WEIGHTCLASS);
    }

    /**
     * Sets <code>value</code> as the attribute value for WeightClass.
     * @param value value to set the WeightClass
     */
    public void setWeightClass(String value) {
        setAttributeInternal(WEIGHTCLASS, value);
    }

    /**
     * @return the associated entity oracle.jbo.RowIterator.
     */
    public RowIterator getXpeDccCfgUomEO() {
        return (RowIterator) getAttributeInternal(XPEDCCCFGUOMEO);
    }

    /**
     * @param itemId key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(String itemId) {
        return new Key(new Object[] { itemId });
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        return EntityDefImpl.findDefObject("model.entities.XpeDccCfgProductserviceEO");
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

