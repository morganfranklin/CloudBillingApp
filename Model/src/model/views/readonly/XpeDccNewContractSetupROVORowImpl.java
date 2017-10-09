package model.views.readonly;

import java.math.BigDecimal;

import oracle.jbo.RowSet;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Fri Sep 08 01:23:25 EDT 2017
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class XpeDccNewContractSetupROVORowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        Id,
        Customer_Type,
        Business_Type,
        MailBillAddress,
        RFF_TAG,
        LookupSharedAppModule_XpeDccDicCustomerTypeLOV,
        LookupSharedAppModule_XpeDccDicBusinessTypeLOV,
        LookupSharedAppModule_XpeDccDicYORNLOV,
        LookupSharedAppModule_RFFTagLOV;
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


    public static final int ID = AttributesEnum.Id.index();
    public static final int CUSTOMER_TYPE = AttributesEnum.Customer_Type.index();
    public static final int BUSINESS_TYPE = AttributesEnum.Business_Type.index();
    public static final int MAILBILLADDRESS = AttributesEnum.MailBillAddress.index();
    public static final int RFF_TAG = AttributesEnum.RFF_TAG.index();
    public static final int LOOKUPSHAREDAPPMODULE_XPEDCCDICCUSTOMERTYPELOV =
        AttributesEnum.LookupSharedAppModule_XpeDccDicCustomerTypeLOV.index();
    public static final int LOOKUPSHAREDAPPMODULE_XPEDCCDICBUSINESSTYPELOV =
        AttributesEnum.LookupSharedAppModule_XpeDccDicBusinessTypeLOV.index();
    public static final int LOOKUPSHAREDAPPMODULE_XPEDCCDICYORNLOV =
        AttributesEnum.LookupSharedAppModule_XpeDccDicYORNLOV.index();
    public static final int LOOKUPSHAREDAPPMODULE_RFFTAGLOV = AttributesEnum.LookupSharedAppModule_RFFTagLOV.index();

    /**
     * This is the default constructor (do not remove).
     */
    public XpeDccNewContractSetupROVORowImpl() {
    }

    /**
     * Gets the attribute value for the calculated attribute Id.
     * @return the Id
     */
    public BigDecimal getId() {
        return (BigDecimal) getAttributeInternal(ID);
    }

    /**
     * Gets the attribute value for the calculated attribute Customer_Type.
     * @return the Customer_Type
     */
    public String getCustomer_Type() {
        return (String) getAttributeInternal(CUSTOMER_TYPE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute Customer_Type.
     * @param value value to set the  Customer_Type
     */
    public void setCustomer_Type(String value) {
        setAttributeInternal(CUSTOMER_TYPE, value);
    }

    /**
     * Gets the attribute value for the calculated attribute Business_Type.
     * @return the Business_Type
     */
    public String getBusiness_Type() {
        return (String) getAttributeInternal(BUSINESS_TYPE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute Business_Type.
     * @param value value to set the  Business_Type
     */
    public void setBusiness_Type(String value) {
        setAttributeInternal(BUSINESS_TYPE, value);
    }

    /**
     * Gets the attribute value for the calculated attribute MailBillAddress.
     * @return the MailBillAddress
     */
    public String getMailBillAddress() {
        return (String) getAttributeInternal(MAILBILLADDRESS);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute MailBillAddress.
     * @param value value to set the  MailBillAddress
     */
    public void setMailBillAddress(String value) {
        setAttributeInternal(MAILBILLADDRESS, value);
    }

    /**
     * Gets the attribute value for the calculated attribute RFF_TAG.
     * @return the RFF_TAG
     */
    public String getRFF_TAG() {
        return (String) getAttributeInternal(RFF_TAG);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute RFF_TAG.
     * @param value value to set the  RFF_TAG
     */
    public void setRFF_TAG(String value) {
        setAttributeInternal(RFF_TAG, value);
    }

    /**
     * Gets the view accessor <code>RowSet</code> LookupSharedAppModule_XpeDccDicCustomerTypeLOV.
     */
    public RowSet getLookupSharedAppModule_XpeDccDicCustomerTypeLOV() {
        return (RowSet) getAttributeInternal(LOOKUPSHAREDAPPMODULE_XPEDCCDICCUSTOMERTYPELOV);
    }

    /**
     * Gets the view accessor <code>RowSet</code> LookupSharedAppModule_XpeDccDicBusinessTypeLOV.
     */
    public RowSet getLookupSharedAppModule_XpeDccDicBusinessTypeLOV() {
        return (RowSet) getAttributeInternal(LOOKUPSHAREDAPPMODULE_XPEDCCDICBUSINESSTYPELOV);
    }

    /**
     * Gets the view accessor <code>RowSet</code> LookupSharedAppModule_XpeDccDicYORNLOV.
     */
    public RowSet getLookupSharedAppModule_XpeDccDicYORNLOV() {
        return (RowSet) getAttributeInternal(LOOKUPSHAREDAPPMODULE_XPEDCCDICYORNLOV);
    }

    /**
     * Gets the view accessor <code>RowSet</code> LookupSharedAppModule_RFFTagLOV.
     */
    public RowSet getLookupSharedAppModule_RFFTagLOV() {
        return (RowSet) getAttributeInternal(LOOKUPSHAREDAPPMODULE_RFFTAGLOV);
    }
}

