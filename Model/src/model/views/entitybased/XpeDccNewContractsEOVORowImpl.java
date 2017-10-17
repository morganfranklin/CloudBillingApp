package model.views.entitybased;

import model.XpeDccContractsImpl;

import oracle.jbo.RowIterator;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu Sep 07 23:55:06 EDT 2017
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class XpeDccNewContractsEOVORowImpl extends ViewRowImpl {


    public static final int ENTITY_XPEDCCCONTRACTS = 0;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        CreatedBy,
        CurrencyCd,
        CustId,
        Setid,
        XpeContractDesc,
        XpeContractId,
        XpeDccPcsname,
        XpeDccContractVersionView;
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
    public static final int CURRENCYCD = AttributesEnum.CurrencyCd.index();
    public static final int CUSTID = AttributesEnum.CustId.index();
    public static final int SETID = AttributesEnum.Setid.index();
    public static final int XPECONTRACTDESC = AttributesEnum.XpeContractDesc.index();
    public static final int XPECONTRACTID = AttributesEnum.XpeContractId.index();
    public static final int XPEDCCPCSNAME = AttributesEnum.XpeDccPcsname.index();
    public static final int XPEDCCCONTRACTVERSIONVIEW = AttributesEnum.XpeDccContractVersionView.index();

    /**
     * This is the default constructor (do not remove).
     */
    public XpeDccNewContractsEOVORowImpl() {
    }

    /**
     * Gets XpeDccContracts entity object.
     * @return the XpeDccContracts
     */
    public XpeDccContractsImpl getXpeDccContracts() {
        return (XpeDccContractsImpl) getEntity(ENTITY_XPEDCCCONTRACTS);
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
     * Gets the attribute value for CURRENCY_CD using the alias name CurrencyCd.
     * @return the CURRENCY_CD
     */
    public String getCurrencyCd() {
        return (String) getAttributeInternal(CURRENCYCD);
    }

    /**
     * Sets <code>value</code> as attribute value for CURRENCY_CD using the alias name CurrencyCd.
     * @param value value to set the CURRENCY_CD
     */
    public void setCurrencyCd(String value) {
        setAttributeInternal(CURRENCYCD, value);
    }

    /**
     * Gets the attribute value for CUST_ID using the alias name CustId.
     * @return the CUST_ID
     */
    public String getCustId() {
        return (String) getAttributeInternal(CUSTID);
    }

    /**
     * Sets <code>value</code> as attribute value for CUST_ID using the alias name CustId.
     * @param value value to set the CUST_ID
     */
    public void setCustId(String value) {
        setAttributeInternal(CUSTID, value);
    }

    /**
     * Gets the attribute value for SETID using the alias name Setid.
     * @return the SETID
     */
    public String getSetid() {
        return (String) getAttributeInternal(SETID);
    }

    /**
     * Sets <code>value</code> as attribute value for SETID using the alias name Setid.
     * @param value value to set the SETID
     */
    public void setSetid(String value) {
        setAttributeInternal(SETID, value);
    }

    /**
     * Gets the attribute value for XPE_CONTRACT_DESC using the alias name XpeContractDesc.
     * @return the XPE_CONTRACT_DESC
     */
    public String getXpeContractDesc() {
        return (String) getAttributeInternal(XPECONTRACTDESC);
    }

    /**
     * Sets <code>value</code> as attribute value for XPE_CONTRACT_DESC using the alias name XpeContractDesc.
     * @param value value to set the XPE_CONTRACT_DESC
     */
    public void setXpeContractDesc(String value) {
        setAttributeInternal(XPECONTRACTDESC, value);
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
     * Gets the attribute value for XPE_DCC_PCSNAME using the alias name XpeDccPcsname.
     * @return the XPE_DCC_PCSNAME
     */
    public String getXpeDccPcsname() {
        return (String) getAttributeInternal(XPEDCCPCSNAME);
    }

    /**
     * Sets <code>value</code> as attribute value for XPE_DCC_PCSNAME using the alias name XpeDccPcsname.
     * @param value value to set the XPE_DCC_PCSNAME
     */
    public void setXpeDccPcsname(String value) {
        setAttributeInternal(XPEDCCPCSNAME, value);
    }

    /**
     * Gets the associated <code>RowIterator</code> using master-detail link XpeDccContractVersionView.
     */
    public RowIterator getXpeDccContractVersionView() {
        return (RowIterator) getAttributeInternal(XPEDCCCONTRACTVERSIONVIEW);
    }


}

