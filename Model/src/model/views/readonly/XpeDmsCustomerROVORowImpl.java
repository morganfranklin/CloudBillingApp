package model.views.readonly;

import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Nov 01 18:05:02 EDT 2017
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class XpeDmsCustomerROVORowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        CustId,
        SetId,
        CompanyName,
        BillingAddress1,
        BillingAddress2,
        City,
        State,
        Country,
        Postal,
        MailingAddress1,
        MailingAddress2,
        MailingCity,
        MailingState,
        MailingCountry,
        MailingPostal,
        Email,
        PhoneNum,
        ContactType,
        ContactName,
        Title,
        BusinessType,
        ProductTier,
        CustomerTier;
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
    public static final int CUSTID = AttributesEnum.CustId.index();
    public static final int SETID = AttributesEnum.SetId.index();
    public static final int COMPANYNAME = AttributesEnum.CompanyName.index();
    public static final int BILLINGADDRESS1 = AttributesEnum.BillingAddress1.index();
    public static final int BILLINGADDRESS2 = AttributesEnum.BillingAddress2.index();
    public static final int CITY = AttributesEnum.City.index();
    public static final int STATE = AttributesEnum.State.index();
    public static final int COUNTRY = AttributesEnum.Country.index();
    public static final int POSTAL = AttributesEnum.Postal.index();
    public static final int MAILINGADDRESS1 = AttributesEnum.MailingAddress1.index();
    public static final int MAILINGADDRESS2 = AttributesEnum.MailingAddress2.index();
    public static final int MAILINGCITY = AttributesEnum.MailingCity.index();
    public static final int MAILINGSTATE = AttributesEnum.MailingState.index();
    public static final int MAILINGCOUNTRY = AttributesEnum.MailingCountry.index();
    public static final int MAILINGPOSTAL = AttributesEnum.MailingPostal.index();
    public static final int EMAIL = AttributesEnum.Email.index();
    public static final int PHONENUM = AttributesEnum.PhoneNum.index();
    public static final int CONTACTTYPE = AttributesEnum.ContactType.index();
    public static final int CONTACTNAME = AttributesEnum.ContactName.index();
    public static final int TITLE = AttributesEnum.Title.index();
    public static final int BUSINESSTYPE = AttributesEnum.BusinessType.index();
    public static final int PRODUCTTIER = AttributesEnum.ProductTier.index();
    public static final int CUSTOMERTIER = AttributesEnum.CustomerTier.index();

    /**
     * This is the default constructor (do not remove).
     */
    public XpeDmsCustomerROVORowImpl() {
    }

    /**
     * Gets the attribute value for the calculated attribute CustId.
     * @return the CustId
     */
    public String getCustId() {
        return (String) getAttributeInternal(CUSTID);
    }

    /**
     * Gets the attribute value for the calculated attribute SetId.
     * @return the SetId
     */
    public String getSetId() {
        return (String) getAttributeInternal(SETID);
    }

    /**
     * Gets the attribute value for the calculated attribute CompanyName.
     * @return the CompanyName
     */
    public String getCompanyName() {
        return (String) getAttributeInternal(COMPANYNAME);
    }

    /**
     * Gets the attribute value for the calculated attribute BillingAddress1.
     * @return the BillingAddress1
     */
    public String getBillingAddress1() {
        return (String) getAttributeInternal(BILLINGADDRESS1);
    }

    /**
     * Gets the attribute value for the calculated attribute BillingAddress2.
     * @return the BillingAddress2
     */
    public String getBillingAddress2() {
        return (String) getAttributeInternal(BILLINGADDRESS2);
    }

    /**
     * Gets the attribute value for the calculated attribute City.
     * @return the City
     */
    public String getCity() {
        return (String) getAttributeInternal(CITY);
    }

    /**
     * Gets the attribute value for the calculated attribute State.
     * @return the State
     */
    public String getState() {
        return (String) getAttributeInternal(STATE);
    }

    /**
     * Gets the attribute value for the calculated attribute Country.
     * @return the Country
     */
    public String getCountry() {
        return (String) getAttributeInternal(COUNTRY);
    }

    /**
     * Gets the attribute value for the calculated attribute Postal.
     * @return the Postal
     */
    public String getPostal() {
        return (String) getAttributeInternal(POSTAL);
    }

    /**
     * Gets the attribute value for the calculated attribute MailingAddress1.
     * @return the MailingAddress1
     */
    public String getMailingAddress1() {
        return (String) getAttributeInternal(MAILINGADDRESS1);
    }

    /**
     * Gets the attribute value for the calculated attribute MailingAddress2.
     * @return the MailingAddress2
     */
    public String getMailingAddress2() {
        return (String) getAttributeInternal(MAILINGADDRESS2);
    }

    /**
     * Gets the attribute value for the calculated attribute MailingCity.
     * @return the MailingCity
     */
    public String getMailingCity() {
        return (String) getAttributeInternal(MAILINGCITY);
    }

    /**
     * Gets the attribute value for the calculated attribute MailingState.
     * @return the MailingState
     */
    public String getMailingState() {
        return (String) getAttributeInternal(MAILINGSTATE);
    }

    /**
     * Gets the attribute value for the calculated attribute MailingCountry.
     * @return the MailingCountry
     */
    public String getMailingCountry() {
        return (String) getAttributeInternal(MAILINGCOUNTRY);
    }

    /**
     * Gets the attribute value for the calculated attribute MailingPostal.
     * @return the MailingPostal
     */
    public String getMailingPostal() {
        return (String) getAttributeInternal(MAILINGPOSTAL);
    }

    /**
     * Gets the attribute value for the calculated attribute Email.
     * @return the Email
     */
    public String getEmail() {
        return (String) getAttributeInternal(EMAIL);
    }

    /**
     * Gets the attribute value for the calculated attribute PhoneNum.
     * @return the PhoneNum
     */
    public String getPhoneNum() {
        return (String) getAttributeInternal(PHONENUM);
    }

    /**
     * Gets the attribute value for the calculated attribute ContactType.
     * @return the ContactType
     */
    public String getContactType() {
        return (String) getAttributeInternal(CONTACTTYPE);
    }

    /**
     * Gets the attribute value for the calculated attribute ContactName.
     * @return the ContactName
     */
    public String getContactName() {
        return (String) getAttributeInternal(CONTACTNAME);
    }

    /**
     * Gets the attribute value for the calculated attribute Title.
     * @return the Title
     */
    public String getTitle() {
        return (String) getAttributeInternal(TITLE);
    }

    /**
     * Gets the attribute value for the calculated attribute BusinessType.
     * @return the BusinessType
     */
    public String getBusinessType() {
        return (String) getAttributeInternal(BUSINESSTYPE);
    }

    /**
     * Gets the attribute value for the calculated attribute ProductTier.
     * @return the ProductTier
     */
    public String getProductTier() {
        return (String) getAttributeInternal(PRODUCTTIER);
    }

    /**
     * Gets the attribute value for the calculated attribute CustomerTier.
     * @return the CustomerTier
     */
    public String getCustomerTier() {
        return (String) getAttributeInternal(CUSTOMERTIER);
    }
}

