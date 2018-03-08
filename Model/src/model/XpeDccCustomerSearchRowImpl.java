package model;

import java.math.BigDecimal;

import oracle.jbo.RowIterator;
import oracle.jbo.RowSet;
import oracle.jbo.domain.Date;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Feb 28 23:58:27 EST 2018
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class XpeDccCustomerSearchRowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        XpeContractId,
        XpeContractVersion,
        XpeContractDesc,
        XpeContractLine,
        Setid,
        CustId,
        Name1,
        Descr,
        Country,
        AddressSeqNum,
        Address1,
        Address2,
        City,
        State,
        Postal,
        BusinessUnitGl,
        XpeFacility,
        XpeProductId,
        XpeSwApprNbr,
        XpeContractStatus,
        SalesPerson,
        XpeStartDate,
        XpeEndDate,
        XpeDccPcsname,
        XpeDccContractsView,
        XpeDccDicContractStatus1,
        XpeDccDicProducts1,
        XpeDccGeneralItemListROVO1,
        XpeDccCfgPCSShortNamesROVO1,
        XpeDccCfgPcsROVO1,
        PsSalesPersonROVO1,
        XpeDccCfgUserBusinessUnitROVO1;
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
    public static final int XPECONTRACTVERSION = AttributesEnum.XpeContractVersion.index();
    public static final int XPECONTRACTDESC = AttributesEnum.XpeContractDesc.index();
    public static final int XPECONTRACTLINE = AttributesEnum.XpeContractLine.index();
    public static final int SETID = AttributesEnum.Setid.index();
    public static final int CUSTID = AttributesEnum.CustId.index();
    public static final int NAME1 = AttributesEnum.Name1.index();
    public static final int DESCR = AttributesEnum.Descr.index();
    public static final int COUNTRY = AttributesEnum.Country.index();
    public static final int ADDRESSSEQNUM = AttributesEnum.AddressSeqNum.index();
    public static final int ADDRESS1 = AttributesEnum.Address1.index();
    public static final int ADDRESS2 = AttributesEnum.Address2.index();
    public static final int CITY = AttributesEnum.City.index();
    public static final int STATE = AttributesEnum.State.index();
    public static final int POSTAL = AttributesEnum.Postal.index();
    public static final int BUSINESSUNITGL = AttributesEnum.BusinessUnitGl.index();
    public static final int XPEFACILITY = AttributesEnum.XpeFacility.index();
    public static final int XPEPRODUCTID = AttributesEnum.XpeProductId.index();
    public static final int XPESWAPPRNBR = AttributesEnum.XpeSwApprNbr.index();
    public static final int XPECONTRACTSTATUS = AttributesEnum.XpeContractStatus.index();
    public static final int SALESPERSON = AttributesEnum.SalesPerson.index();
    public static final int XPESTARTDATE = AttributesEnum.XpeStartDate.index();
    public static final int XPEENDDATE = AttributesEnum.XpeEndDate.index();
    public static final int XPEDCCPCSNAME = AttributesEnum.XpeDccPcsname.index();
    public static final int XPEDCCCONTRACTSVIEW = AttributesEnum.XpeDccContractsView.index();
    public static final int XPEDCCDICCONTRACTSTATUS1 = AttributesEnum.XpeDccDicContractStatus1.index();
    public static final int XPEDCCDICPRODUCTS1 = AttributesEnum.XpeDccDicProducts1.index();
    public static final int XPEDCCGENERALITEMLISTROVO1 = AttributesEnum.XpeDccGeneralItemListROVO1.index();
    public static final int XPEDCCCFGPCSSHORTNAMESROVO1 = AttributesEnum.XpeDccCfgPCSShortNamesROVO1.index();
    public static final int XPEDCCCFGPCSROVO1 = AttributesEnum.XpeDccCfgPcsROVO1.index();
    public static final int PSSALESPERSONROVO1 = AttributesEnum.PsSalesPersonROVO1.index();
    public static final int XPEDCCCFGUSERBUSINESSUNITROVO1 = AttributesEnum.XpeDccCfgUserBusinessUnitROVO1.index();

    /**
     * This is the default constructor (do not remove).
     */
    public XpeDccCustomerSearchRowImpl() {
    }

    /**
     * Gets the attribute value for the calculated attribute XpeContractId.
     * @return the XpeContractId
     */
    public String getXpeContractId() {
        return (String) getAttributeInternal(XPECONTRACTID);
    }

    /**
     * Gets the attribute value for the calculated attribute XpeContractVersion.
     * @return the XpeContractVersion
     */
    public String getXpeContractVersion() {
        return (String) getAttributeInternal(XPECONTRACTVERSION);
    }

    /**
     * Gets the attribute value for the calculated attribute XpeContractDesc.
     * @return the XpeContractDesc
     */
    public String getXpeContractDesc() {
        return (String) getAttributeInternal(XPECONTRACTDESC);
    }

    /**
     * Gets the attribute value for the calculated attribute XpeContractLine.
     * @return the XpeContractLine
     */
    public String getXpeContractLine() {
        return (String) getAttributeInternal(XPECONTRACTLINE);
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
     * Gets the attribute value for the calculated attribute AddressSeqNum.
     * @return the AddressSeqNum
     */
    public BigDecimal getAddressSeqNum() {
        return (BigDecimal) getAttributeInternal(ADDRESSSEQNUM);
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
     * Gets the attribute value for the calculated attribute BusinessUnitGl.
     * @return the BusinessUnitGl
     */
    public String getBusinessUnitGl() {
        return (String) getAttributeInternal(BUSINESSUNITGL);
    }

    /**
     * Gets the attribute value for the calculated attribute XpeFacility.
     * @return the XpeFacility
     */
    public String getXpeFacility() {
        return (String) getAttributeInternal(XPEFACILITY);
    }

    /**
     * Gets the attribute value for the calculated attribute XpeProductId.
     * @return the XpeProductId
     */
    public String getXpeProductId() {
        return (String) getAttributeInternal(XPEPRODUCTID);
    }

    /**
     * Gets the attribute value for the calculated attribute XpeSwApprNbr.
     * @return the XpeSwApprNbr
     */
    public String getXpeSwApprNbr() {
        return (String) getAttributeInternal(XPESWAPPRNBR);
    }

    /**
     * Gets the attribute value for the calculated attribute XpeContractStatus.
     * @return the XpeContractStatus
     */
    public String getXpeContractStatus() {
        return (String) getAttributeInternal(XPECONTRACTSTATUS);
    }

    /**
     * Gets the attribute value for the calculated attribute SalesPerson.
     * @return the SalesPerson
     */
    public String getSalesPerson() {
        return (String) getAttributeInternal(SALESPERSON);
    }

    /**
     * Gets the attribute value for the calculated attribute XpeStartDate.
     * @return the XpeStartDate
     */
    public Date getXpeStartDate() {
        return (Date) getAttributeInternal(XPESTARTDATE);
    }

    /**
     * Gets the attribute value for the calculated attribute XpeEndDate.
     * @return the XpeEndDate
     */
    public Date getXpeEndDate() {
        return (Date) getAttributeInternal(XPEENDDATE);
    }

    /**
     * Gets the attribute value for the calculated attribute XpeDccPcsname.
     * @return the XpeDccPcsname
     */
    public String getXpeDccPcsname() {
        return (String) getAttributeInternal(XPEDCCPCSNAME);
    }

    /**
     * Gets the associated <code>RowIterator</code> using master-detail link XpeDccContractsView.
     */
    public RowIterator getXpeDccContractsView() {
        return (RowIterator) getAttributeInternal(XPEDCCCONTRACTSVIEW);
    }

    /**
     * Gets the view accessor <code>RowSet</code> XpeDccDicContractStatus1.
     */
    public RowSet getXpeDccDicContractStatus1() {
        return (RowSet) getAttributeInternal(XPEDCCDICCONTRACTSTATUS1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> XpeDccDicProducts1.
     */
    public RowSet getXpeDccDicProducts1() {
        return (RowSet) getAttributeInternal(XPEDCCDICPRODUCTS1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> XpeDccGeneralItemListROVO1.
     */
    public RowSet getXpeDccGeneralItemListROVO1() {
        return (RowSet) getAttributeInternal(XPEDCCGENERALITEMLISTROVO1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> XpeDccCfgPCSShortNamesROVO1.
     */
    public RowSet getXpeDccCfgPCSShortNamesROVO1() {
        return (RowSet) getAttributeInternal(XPEDCCCFGPCSSHORTNAMESROVO1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> XpeDccCfgPcsROVO1.
     */
    public RowSet getXpeDccCfgPcsROVO1() {
        return (RowSet) getAttributeInternal(XPEDCCCFGPCSROVO1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> PsSalesPersonROVO1.
     */
    public RowSet getPsSalesPersonROVO1() {
        return (RowSet) getAttributeInternal(PSSALESPERSONROVO1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> XpeDccCfgUserBusinessUnitROVO1.
     */
    public RowSet getXpeDccCfgUserBusinessUnitROVO1() {
        return (RowSet) getAttributeInternal(XPEDCCCFGUSERBUSINESSUNITROVO1);
    }
}
