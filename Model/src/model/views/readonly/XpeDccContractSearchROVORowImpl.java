package model.views.readonly;

import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sat Oct 07 20:01:38 EDT 2017
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class XpeDccContractSearchROVORowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        XpeContractId,
        XpeContractDesc,
        Setid,
        CustId,
        Name1,
        Descr,
        Country,
        Address1,
        Address2,
        City,
        State,
        Postal,
        XpeSwApprNbr,
        XpeContractVersion;
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
    public static final int XPECONTRACTDESC = AttributesEnum.XpeContractDesc.index();
    public static final int SETID = AttributesEnum.Setid.index();
    public static final int CUSTID = AttributesEnum.CustId.index();
    public static final int NAME1 = AttributesEnum.Name1.index();
    public static final int DESCR = AttributesEnum.Descr.index();
    public static final int COUNTRY = AttributesEnum.Country.index();
    public static final int ADDRESS1 = AttributesEnum.Address1.index();
    public static final int ADDRESS2 = AttributesEnum.Address2.index();
    public static final int CITY = AttributesEnum.City.index();
    public static final int STATE = AttributesEnum.State.index();
    public static final int POSTAL = AttributesEnum.Postal.index();
    public static final int XPESWAPPRNBR = AttributesEnum.XpeSwApprNbr.index();
    public static final int XPECONTRACTVERSION = AttributesEnum.XpeContractVersion.index();

    /**
     * This is the default constructor (do not remove).
     */
    public XpeDccContractSearchROVORowImpl() {
    }

    /**
     * Gets the attribute value for the calculated attribute XpeContractId.
     * @return the XpeContractId
     */
    public String getXpeContractId() {
        return (String) getAttributeInternal(XPECONTRACTID);
    }

    /**
     * Gets the attribute value for the calculated attribute XpeContractDesc.
     * @return the XpeContractDesc
     */
    public String getXpeContractDesc() {
        return (String) getAttributeInternal(XPECONTRACTDESC);
    }

    /**
     * Gets the attribute value for the calculated attribute Setid.
     * @return the Setid
     */
    public String getSetid() {
        return (String) getAttributeInternal(SETID);
    }

    /**
     * Gets the attribute value for the calculated attribute CustId.
     * @return the CustId
     */
    public String getCustId() {
        return (String) getAttributeInternal(CUSTID);
    }

    /**
     * Gets the attribute value for the calculated attribute Name1.
     * @return the Name1
     */
    public String getName1() {
        return (String) getAttributeInternal(NAME1);
    }

    /**
     * Gets the attribute value for the calculated attribute Descr.
     * @return the Descr
     */
    public String getDescr() {
        return (String) getAttributeInternal(DESCR);
    }

    /**
     * Gets the attribute value for the calculated attribute Country.
     * @return the Country
     */
    public String getCountry() {
        return (String) getAttributeInternal(COUNTRY);
    }

    /**
     * Gets the attribute value for the calculated attribute Address1.
     * @return the Address1
     */
    public String getAddress1() {
        return (String) getAttributeInternal(ADDRESS1);
    }

    /**
     * Gets the attribute value for the calculated attribute Address2.
     * @return the Address2
     */
    public String getAddress2() {
        return (String) getAttributeInternal(ADDRESS2);
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
     * Gets the attribute value for the calculated attribute Postal.
     * @return the Postal
     */
    public String getPostal() {
        return (String) getAttributeInternal(POSTAL);
    }

    /**
     * Gets the attribute value for the calculated attribute XpeSwApprNbr.
     * @return the XpeSwApprNbr
     */
    public String getXpeSwApprNbr() {
        return (String) getAttributeInternal(XPESWAPPRNBR);
    }

    /**
     * Gets the attribute value for the calculated attribute XpeContractVersion.
     * @return the XpeContractVersion
     */
    public String getXpeContractVersion() {
        return (String) getAttributeInternal(XPECONTRACTVERSION);
    }


}

