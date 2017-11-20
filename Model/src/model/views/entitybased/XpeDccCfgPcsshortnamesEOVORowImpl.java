package model.views.entitybased;

import java.math.BigDecimal;
import java.math.BigInteger;

import java.sql.Timestamp;

import model.entities.XpeDccCfgPcsshortnamesEOImpl;

import oracle.jbo.RowSet;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu Oct 12 15:50:49 EDT 2017
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class XpeDccCfgPcsshortnamesEOVORowImpl extends ViewRowImpl {


    public static final int ENTITY_XPEDCCCFGPCSSHORTNAMESEO = 0;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        CovId,
        PcsshortnameId,
        PcsshortName,
        AccountClass,
        CustId,
        CustomerName,
        Setid,
        BillCycleId,
        InvSupress,
        CovSoldId,
        CovSoldLocNum,
        CovBillId,
        CovBillLocNum,
        CreatedBy,
        CreatedDate,
        Inactive,
        InactiveDate,
        LastUpdatedBy,
        LastUpdatedDate,
        COV_Sold_Address1,
        COV_Sold_Address2,
        COV_Sold_City,
        COV_Sold_State,
        COV_Sold_Zip,
        COV_Bill_Address1,
        COV_Bill_Address2,
        COV_Bill_City,
        COV_Bill_State,
        COV_Bill_Zip,
        XpeDccShortNameCustomerSearchROVO_LOV,
        XpeDccShortNameSoldLocSearchROVO_LOV,
        XpeDccShortNameBillLocSearchROVO_LOV,
        LookupSharedAppModule_XpeDccDicNewContractSetupROVO1,
        PsBiCycleROVO1;
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


    public static final int COVID = AttributesEnum.CovId.index();
    public static final int PCSSHORTNAMEID = AttributesEnum.PcsshortnameId.index();
    public static final int PCSSHORTNAME = AttributesEnum.PcsshortName.index();
    public static final int ACCOUNTCLASS = AttributesEnum.AccountClass.index();
    public static final int CUSTID = AttributesEnum.CustId.index();
    public static final int CUSTOMERNAME = AttributesEnum.CustomerName.index();
    public static final int SETID = AttributesEnum.Setid.index();
    public static final int BILLCYCLEID = AttributesEnum.BillCycleId.index();
    public static final int INVSUPRESS = AttributesEnum.InvSupress.index();
    public static final int COVSOLDID = AttributesEnum.CovSoldId.index();
    public static final int COVSOLDLOCNUM = AttributesEnum.CovSoldLocNum.index();
    public static final int COVBILLID = AttributesEnum.CovBillId.index();
    public static final int COVBILLLOCNUM = AttributesEnum.CovBillLocNum.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int CREATEDDATE = AttributesEnum.CreatedDate.index();
    public static final int INACTIVE = AttributesEnum.Inactive.index();
    public static final int INACTIVEDATE = AttributesEnum.InactiveDate.index();
    public static final int LASTUPDATEDBY = AttributesEnum.LastUpdatedBy.index();
    public static final int LASTUPDATEDDATE = AttributesEnum.LastUpdatedDate.index();
    public static final int COV_SOLD_ADDRESS1 = AttributesEnum.COV_Sold_Address1.index();
    public static final int COV_SOLD_ADDRESS2 = AttributesEnum.COV_Sold_Address2.index();
    public static final int COV_SOLD_CITY = AttributesEnum.COV_Sold_City.index();
    public static final int COV_SOLD_STATE = AttributesEnum.COV_Sold_State.index();
    public static final int COV_SOLD_ZIP = AttributesEnum.COV_Sold_Zip.index();
    public static final int COV_BILL_ADDRESS1 = AttributesEnum.COV_Bill_Address1.index();
    public static final int COV_BILL_ADDRESS2 = AttributesEnum.COV_Bill_Address2.index();
    public static final int COV_BILL_CITY = AttributesEnum.COV_Bill_City.index();
    public static final int COV_BILL_STATE = AttributesEnum.COV_Bill_State.index();
    public static final int COV_BILL_ZIP = AttributesEnum.COV_Bill_Zip.index();
    public static final int XPEDCCSHORTNAMECUSTOMERSEARCHROVO_LOV =
        AttributesEnum.XpeDccShortNameCustomerSearchROVO_LOV.index();
    public static final int XPEDCCSHORTNAMESOLDLOCSEARCHROVO_LOV =
        AttributesEnum.XpeDccShortNameSoldLocSearchROVO_LOV.index();
    public static final int XPEDCCSHORTNAMEBILLLOCSEARCHROVO_LOV =
        AttributesEnum.XpeDccShortNameBillLocSearchROVO_LOV.index();
    public static final int LOOKUPSHAREDAPPMODULE_XPEDCCDICNEWCONTRACTSETUPROVO1 =
        AttributesEnum.LookupSharedAppModule_XpeDccDicNewContractSetupROVO1.index();
    public static final int PSBICYCLEROVO1 = AttributesEnum.PsBiCycleROVO1.index();

    /**
     * This is the default constructor (do not remove).
     */
    public XpeDccCfgPcsshortnamesEOVORowImpl() {
    }

    /**
     * Gets XpeDccCfgPcsshortnamesEO entity object.
     * @return the XpeDccCfgPcsshortnamesEO
     */
    public XpeDccCfgPcsshortnamesEOImpl getXpeDccCfgPcsshortnamesEO() {
        return (XpeDccCfgPcsshortnamesEOImpl) getEntity(ENTITY_XPEDCCCFGPCSSHORTNAMESEO);
    }

    /**
     * Gets the attribute value for ACCOUNT_CLASS using the alias name AccountClass.
     * @return the ACCOUNT_CLASS
     */
    public String getAccountClass() {
        return (String) getAttributeInternal(ACCOUNTCLASS);
    }

    /**
     * Sets <code>value</code> as attribute value for ACCOUNT_CLASS using the alias name AccountClass.
     * @param value value to set the ACCOUNT_CLASS
     */
    public void setAccountClass(String value) {
        setAttributeInternal(ACCOUNTCLASS, value);
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
     * Sets <code>value</code> as attribute value for CREATED_DATE using the alias name CreatedDate.
     * @param value value to set the CREATED_DATE
     */
    public void setCreatedDate(Timestamp value) {
        setAttributeInternal(CREATEDDATE, value);
    }

    /**
     * Gets the attribute value for INACTIVE using the alias name Inactive.
     * @return the INACTIVE
     */
    public String getInactive() {
        return (String) getAttributeInternal(INACTIVE);
    }

    /**
     * Sets <code>value</code> as attribute value for INACTIVE using the alias name Inactive.
     * @param value value to set the INACTIVE
     */
    public void setInactive(String value) {
        setAttributeInternal(INACTIVE, value);
    }

    /**
     * Gets the attribute value for INACTIVE_DATE using the alias name InactiveDate.
     * @return the INACTIVE_DATE
     */
    public Timestamp getInactiveDate() {
        return (Timestamp) getAttributeInternal(INACTIVEDATE);
    }

    /**
     * Sets <code>value</code> as attribute value for INACTIVE_DATE using the alias name InactiveDate.
     * @param value value to set the INACTIVE_DATE
     */
    public void setInactiveDate(Timestamp value) {
        setAttributeInternal(INACTIVEDATE, value);
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
     * Sets <code>value</code> as attribute value for LAST_UPDATED_DATE using the alias name LastUpdatedDate.
     * @param value value to set the LAST_UPDATED_DATE
     */
    public void setLastUpdatedDate(Timestamp value) {
        setAttributeInternal(LASTUPDATEDDATE, value);
    }

    /**
     * Gets the attribute value for PCSSHORT_NAME using the alias name PcsshortName.
     * @return the PCSSHORT_NAME
     */
    public String getPcsshortName() {
        return (String) getAttributeInternal(PCSSHORTNAME);
    }

    /**
     * Sets <code>value</code> as attribute value for PCSSHORT_NAME using the alias name PcsshortName.
     * @param value value to set the PCSSHORT_NAME
     */
    public void setPcsshortName(String value) {
        if (null != value) {
            setAttributeInternal(PCSSHORTNAME, value.toUpperCase());
        } else {
            setAttributeInternal(PCSSHORTNAME, value);
        }
    }

    /**
     * Gets the attribute value for PCSSHORTNAME_ID using the alias name PcsshortnameId.
     * @return the PCSSHORTNAME_ID
     */
    public String getPcsshortnameId() {
        return (String) getAttributeInternal(PCSSHORTNAMEID);
    }

    /**
     * Sets <code>value</code> as attribute value for PCSSHORTNAME_ID using the alias name PcsshortnameId.
     * @param value value to set the PCSSHORTNAME_ID
     */
    public void setPcsshortnameId(String value) {
        setAttributeInternal(PCSSHORTNAMEID, value);
    }

    /**
     * Gets the attribute value for COV_ID using the alias name CovId.
     * @return the COV_ID
     */
    public String getCovId() {
        return (String) getAttributeInternal(COVID);
    }

    /**
     * Sets <code>value</code> as attribute value for COV_ID using the alias name CovId.
     * @param value value to set the COV_ID
     */
    public void setCovId(String value) {
        setAttributeInternal(COVID, value);
    }

    /**
     * Gets the attribute value for COV_SOLD_ID using the alias name CovSoldId.
     * @return the COV_SOLD_ID
     */
    public String getCovSoldId() {
        return (String) getAttributeInternal(COVSOLDID);
    }

    /**
     * Sets <code>value</code> as attribute value for COV_SOLD_ID using the alias name CovSoldId.
     * @param value value to set the COV_SOLD_ID
     */
    public void setCovSoldId(String value) {
        setAttributeInternal(COVSOLDID, value);
    }

    /**
     * Gets the attribute value for COV_BILL_ID using the alias name CovBillId.
     * @return the COV_BILL_ID
     */
    public String getCovBillId() {
        return (String) getAttributeInternal(COVBILLID);
    }

    /**
     * Sets <code>value</code> as attribute value for COV_BILL_ID using the alias name CovBillId.
     * @param value value to set the COV_BILL_ID
     */
    public void setCovBillId(String value) {
        setAttributeInternal(COVBILLID, value);
    }

    /**
     * Gets the attribute value for COV_SOLD_LOC_NUM using the alias name CovSoldLocNum.
     * @return the COV_SOLD_LOC_NUM
     */
    public BigDecimal getCovSoldLocNum() {
        return (BigDecimal) getAttributeInternal(COVSOLDLOCNUM);
    }

    /**
     * Sets <code>value</code> as attribute value for COV_SOLD_LOC_NUM using the alias name CovSoldLocNum.
     * @param value value to set the COV_SOLD_LOC_NUM
     */
    public void setCovSoldLocNum(BigDecimal value) {
        setAttributeInternal(COVSOLDLOCNUM, value);
    }

    /**
     * Gets the attribute value for COV_BILL_LOC_NUM using the alias name CovBillLocNum.
     * @return the COV_BILL_LOC_NUM
     */
    public BigDecimal getCovBillLocNum() {
        return (BigDecimal) getAttributeInternal(COVBILLLOCNUM);
    }

    /**
     * Sets <code>value</code> as attribute value for COV_BILL_LOC_NUM using the alias name CovBillLocNum.
     * @param value value to set the COV_BILL_LOC_NUM
     */
    public void setCovBillLocNum(BigDecimal value) {
        setAttributeInternal(COVBILLLOCNUM, value);
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
     * Gets the attribute value for the calculated attribute CustomerName.
     * @return the CustomerName
     */
    public String getCustomerName() {
        return (String) getAttributeInternal(CUSTOMERNAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute CustomerName.
     * @param value value to set the  CustomerName
     */
    public void setCustomerName(String value) {
        setAttributeInternal(CUSTOMERNAME, value);
    }

    /**
     * Gets the attribute value for the calculated attribute COV_Sold_Address1.
     * @return the COV_Sold_Address1
     */
    public String getCOV_Sold_Address1() {
        return (String) getAttributeInternal(COV_SOLD_ADDRESS1);
    }


    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute COV_Sold_Address1.
     * @param value value to set the  COV_Sold_Address1
     */
    public void setCOV_Sold_Address1(String value) {
        setAttributeInternal(COV_SOLD_ADDRESS1, value);
    }

    /**
     * Gets the attribute value for the calculated attribute COV_Sold_Address2.
     * @return the COV_Sold_Address2
     */
    public String getCOV_Sold_Address2() {
        return (String) getAttributeInternal(COV_SOLD_ADDRESS2);
    }


    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute COV_Sold_Address2.
     * @param value value to set the  COV_Sold_Address2
     */
    public void setCOV_Sold_Address2(String value) {
        setAttributeInternal(COV_SOLD_ADDRESS2, value);
    }

    /**
     * Gets the attribute value for the calculated attribute COV_Sold_City.
     * @return the COV_Sold_City
     */
    public String getCOV_Sold_City() {
        return (String) getAttributeInternal(COV_SOLD_CITY);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute COV_Sold_City.
     * @param value value to set the  COV_Sold_City
     */
    public void setCOV_Sold_City(String value) {
        setAttributeInternal(COV_SOLD_CITY, value);
    }

    /**
     * Gets the attribute value for the calculated attribute COV_Sold_State.
     * @return the COV_Sold_State
     */
    public String getCOV_Sold_State() {
        return (String) getAttributeInternal(COV_SOLD_STATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute COV_Sold_State.
     * @param value value to set the  COV_Sold_State
     */
    public void setCOV_Sold_State(String value) {
        setAttributeInternal(COV_SOLD_STATE, value);
    }

    /**
     * Gets the attribute value for the calculated attribute COV_Sold_Zip.
     * @return the COV_Sold_Zip
     */
    public String getCOV_Sold_Zip() {
        return (String) getAttributeInternal(COV_SOLD_ZIP);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute COV_Sold_Zip.
     * @param value value to set the  COV_Sold_Zip
     */
    public void setCOV_Sold_Zip(String value) {
        setAttributeInternal(COV_SOLD_ZIP, value);
    }

    /**
     * Gets the attribute value for the calculated attribute COV_Bill_Address1.
     * @return the COV_Bill_Address1
     */
    public String getCOV_Bill_Address1() {
        return (String) getAttributeInternal(COV_BILL_ADDRESS1);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute COV_Bill_Address1.
     * @param value value to set the  COV_Bill_Address1
     */
    public void setCOV_Bill_Address1(String value) {
        setAttributeInternal(COV_BILL_ADDRESS1, value);
    }

    /**
     * Gets the attribute value for the calculated attribute COV_Bill_Address2.
     * @return the COV_Bill_Address2
     */
    public String getCOV_Bill_Address2() {
        return (String) getAttributeInternal(COV_BILL_ADDRESS2);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute COV_Bill_Address2.
     * @param value value to set the  COV_Bill_Address2
     */
    public void setCOV_Bill_Address2(String value) {
        setAttributeInternal(COV_BILL_ADDRESS2, value);
    }

    /**
     * Gets the attribute value for the calculated attribute COV_Bill_City.
     * @return the COV_Bill_City
     */
    public String getCOV_Bill_City() {
        return (String) getAttributeInternal(COV_BILL_CITY);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute COV_Bill_City.
     * @param value value to set the  COV_Bill_City
     */
    public void setCOV_Bill_City(String value) {
        setAttributeInternal(COV_BILL_CITY, value);
    }

    /**
     * Gets the attribute value for the calculated attribute COV_Bill_State.
     * @return the COV_Bill_State
     */
    public String getCOV_Bill_State() {
        return (String) getAttributeInternal(COV_BILL_STATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute COV_Bill_State.
     * @param value value to set the  COV_Bill_State
     */
    public void setCOV_Bill_State(String value) {
        setAttributeInternal(COV_BILL_STATE, value);
    }

    /**
     * Gets the attribute value for the calculated attribute COV_Bill_Zip.
     * @return the COV_Bill_Zip
     */
    public String getCOV_Bill_Zip() {
        return (String) getAttributeInternal(COV_BILL_ZIP);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute COV_Bill_Zip.
     * @param value value to set the  COV_Bill_Zip
     */
    public void setCOV_Bill_Zip(String value) {
        setAttributeInternal(COV_BILL_ZIP, value);
    }


    /**
     * Gets the attribute value for BILL_CYCLE_ID using the alias name BillCycleId1.
     * @return the BILL_CYCLE_ID
     */
    public String getBillCycleId() {
        return (String) getAttributeInternal(BILLCYCLEID);
    }

    /**
     * Sets <code>value</code> as attribute value for BILL_CYCLE_ID using the alias name BillCycleId1.
     * @param value value to set the BILL_CYCLE_ID
     */
    public void setBillCycleId(String value) {
        setAttributeInternal(BILLCYCLEID, value);
    }

    /**
     * Gets the attribute value for INV_SUPRESS using the alias name InvSupress1.
     * @return the INV_SUPRESS
     */
    public String getInvSupress() {
        return (String) getAttributeInternal(INVSUPRESS);
    }

    /**
     * Sets <code>value</code> as attribute value for INV_SUPRESS using the alias name InvSupress1.
     * @param value value to set the INV_SUPRESS
     */
    public void setInvSupress(String value) {
        setAttributeInternal(INVSUPRESS, value);
    }

    /**
     * Gets the view accessor <code>RowSet</code> XpeDccShortNameCustomerSearchROVO_LOV.
     */
    public RowSet getXpeDccShortNameCustomerSearchROVO_LOV() {
        return (RowSet) getAttributeInternal(XPEDCCSHORTNAMECUSTOMERSEARCHROVO_LOV);
    }

    /**
     * Gets the view accessor <code>RowSet</code> XpeDccShortNameSoldLocSearchROVO_LOV.
     */
    public RowSet getXpeDccShortNameSoldLocSearchROVO_LOV() {
        return (RowSet) getAttributeInternal(XPEDCCSHORTNAMESOLDLOCSEARCHROVO_LOV);
    }

    /**
     * Gets the view accessor <code>RowSet</code> XpeDccShortNameBillLocSearchROVO_LOV.
     */
    public RowSet getXpeDccShortNameBillLocSearchROVO_LOV() {
        return (RowSet) getAttributeInternal(XPEDCCSHORTNAMEBILLLOCSEARCHROVO_LOV);
    }

    /**
     * Gets the view accessor <code>RowSet</code> LookupSharedAppModule_XpeDccDicNewContractSetupROVO1.
     */
    public RowSet getLookupSharedAppModule_XpeDccDicNewContractSetupROVO1() {
        return (RowSet) getAttributeInternal(LOOKUPSHAREDAPPMODULE_XPEDCCDICNEWCONTRACTSETUPROVO1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> PsBiCycleROVO1.
     */
    public RowSet getPsBiCycleROVO1() {
        return (RowSet) getAttributeInternal(PSBICYCLEROVO1);
    }
}

