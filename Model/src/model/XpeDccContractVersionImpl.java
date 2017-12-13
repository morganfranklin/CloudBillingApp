package model;

import java.sql.Timestamp;

import oracle.jbo.AttributeList;
import oracle.jbo.Key;
import oracle.jbo.RowIterator;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.SequenceImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Aug 23 17:40:07 IST 2017
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class XpeDccContractVersionImpl extends EntityImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        XpeContractId,
        XpeContractVersion,
        XpeContractStatus,
        XpeStartDate,
        XpeEndDate,
        XpeNewTermMode,
        CreatedBy,
        UpdatedBy,
        XpeBillOptionsSet,
        XpeAcctgOptionsSet,
        XpeContractTemplate,
        BusinessUnitGl,
        CurrencyCd,
        XpeWasteType,
        XpeContractSubType,
        XpeAgreementType,
        XpeAsOfDate,
        SalesPerson,
        XpeContractDirection,
        XpeTermAgreement,
        XpeVarianceBudget,
        XpeEstDisposalVol,
        XpeValueTransaction,
        XpeJustification,
        XpeExistingCustomer,
        XpePaymentMethod,
        XpePaymentHistory,
        XpeCreditLimit,
        XpeDccContractNotes,
        XpeDccContractLine,
        XpeDccContracts,
        XpeDccContractsAttachments,
        XpeDccTermsContractEO,
        XpeDccWfEventEO;
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
    public static final int XPECONTRACTSTATUS = AttributesEnum.XpeContractStatus.index();
    public static final int XPESTARTDATE = AttributesEnum.XpeStartDate.index();
    public static final int XPEENDDATE = AttributesEnum.XpeEndDate.index();
    public static final int XPENEWTERMMODE = AttributesEnum.XpeNewTermMode.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int UPDATEDBY = AttributesEnum.UpdatedBy.index();
    public static final int XPEBILLOPTIONSSET = AttributesEnum.XpeBillOptionsSet.index();
    public static final int XPEACCTGOPTIONSSET = AttributesEnum.XpeAcctgOptionsSet.index();
    public static final int XPECONTRACTTEMPLATE = AttributesEnum.XpeContractTemplate.index();
    public static final int BUSINESSUNITGL = AttributesEnum.BusinessUnitGl.index();
    public static final int CURRENCYCD = AttributesEnum.CurrencyCd.index();
    public static final int XPEWASTETYPE = AttributesEnum.XpeWasteType.index();
    public static final int XPECONTRACTSUBTYPE = AttributesEnum.XpeContractSubType.index();
    public static final int XPEAGREEMENTTYPE = AttributesEnum.XpeAgreementType.index();
    public static final int XPEASOFDATE = AttributesEnum.XpeAsOfDate.index();
    public static final int SALESPERSON = AttributesEnum.SalesPerson.index();
    public static final int XPECONTRACTDIRECTION = AttributesEnum.XpeContractDirection.index();
    public static final int XPETERMAGREEMENT = AttributesEnum.XpeTermAgreement.index();
    public static final int XPEVARIANCEBUDGET = AttributesEnum.XpeVarianceBudget.index();
    public static final int XPEESTDISPOSALVOL = AttributesEnum.XpeEstDisposalVol.index();
    public static final int XPEVALUETRANSACTION = AttributesEnum.XpeValueTransaction.index();
    public static final int XPEJUSTIFICATION = AttributesEnum.XpeJustification.index();
    public static final int XPEEXISTINGCUSTOMER = AttributesEnum.XpeExistingCustomer.index();
    public static final int XPEPAYMENTMETHOD = AttributesEnum.XpePaymentMethod.index();
    public static final int XPEPAYMENTHISTORY = AttributesEnum.XpePaymentHistory.index();
    public static final int XPECREDITLIMIT = AttributesEnum.XpeCreditLimit.index();
    public static final int XPEDCCCONTRACTNOTES = AttributesEnum.XpeDccContractNotes.index();
    public static final int XPEDCCCONTRACTLINE = AttributesEnum.XpeDccContractLine.index();
    public static final int XPEDCCCONTRACTS = AttributesEnum.XpeDccContracts.index();
    public static final int XPEDCCCONTRACTSATTACHMENTS = AttributesEnum.XpeDccContractsAttachments.index();
    public static final int XPEDCCTERMSCONTRACTEO = AttributesEnum.XpeDccTermsContractEO.index();
    public static final int XPEDCCWFEVENTEO = AttributesEnum.XpeDccWfEventEO.index();

    /**
     * This is the default constructor (do not remove).
     */
    public XpeDccContractVersionImpl() {
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        return EntityDefImpl.findDefObject("model.XpeDccContractVersion");
    }


    /**
     * Gets the attribute value for XpeContractId, using the alias name XpeContractId.
     * @return the value of XpeContractId
     */
    public String getXpeContractId() {
        return (String) getAttributeInternal(XPECONTRACTID);
    }

    /**
     * Sets <code>value</code> as the attribute value for XpeContractId.
     * @param value value to set the XpeContractId
     */
    public void setXpeContractId(String value) {
        setAttributeInternal(XPECONTRACTID, value);
    }

    /**
     * Gets the attribute value for XpeContractVersion, using the alias name XpeContractVersion.
     * @return the value of XpeContractVersion
     */
    public String getXpeContractVersion() {
        return (String) getAttributeInternal(XPECONTRACTVERSION);
    }

    /**
     * Sets <code>value</code> as the attribute value for XpeContractVersion.
     * @param value value to set the XpeContractVersion
     */
    public void setXpeContractVersion(String value) {
        setAttributeInternal(XPECONTRACTVERSION, value);
    }

    /**
     * Gets the attribute value for XpeContractStatus, using the alias name XpeContractStatus.
     * @return the value of XpeContractStatus
     */
    public String getXpeContractStatus() {
        return (String) getAttributeInternal(XPECONTRACTSTATUS);
    }

    /**
     * Sets <code>value</code> as the attribute value for XpeContractStatus.
     * @param value value to set the XpeContractStatus
     */
    public void setXpeContractStatus(String value) {
        setAttributeInternal(XPECONTRACTSTATUS, value);
    }

    /**
     * Gets the attribute value for XpeStartDate, using the alias name XpeStartDate.
     * @return the value of XpeStartDate
     */
    public Timestamp getXpeStartDate() {
        return (Timestamp) getAttributeInternal(XPESTARTDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for XpeStartDate.
     * @param value value to set the XpeStartDate
     */
    public void setXpeStartDate(Timestamp value) {
        setAttributeInternal(XPESTARTDATE, value);
    }

    /**
     * Gets the attribute value for XpeEndDate, using the alias name XpeEndDate.
     * @return the value of XpeEndDate
     */
    public Timestamp getXpeEndDate() {
        return (Timestamp) getAttributeInternal(XPEENDDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for XpeEndDate.
     * @param value value to set the XpeEndDate
     */
    public void setXpeEndDate(Timestamp value) {
        setAttributeInternal(XPEENDDATE, value);
    }

    /**
     * Gets the attribute value for XpeNewTermMode, using the alias name XpeNewTermMode.
     * @return the value of XpeNewTermMode
     */
    public String getXpeNewTermMode() {
        return (String) getAttributeInternal(XPENEWTERMMODE);
    }

    /**
     * Sets <code>value</code> as the attribute value for XpeNewTermMode.
     * @param value value to set the XpeNewTermMode
     */
    public void setXpeNewTermMode(String value) {
        setAttributeInternal(XPENEWTERMMODE, value);
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
     * Gets the attribute value for UpdatedBy, using the alias name UpdatedBy.
     * @return the value of UpdatedBy
     */
    public String getUpdatedBy() {
        return (String) getAttributeInternal(UPDATEDBY);
    }

    /**
     * Sets <code>value</code> as the attribute value for UpdatedBy.
     * @param value value to set the UpdatedBy
     */
    public void setUpdatedBy(String value) {
        setAttributeInternal(UPDATEDBY, value);
    }

    /**
     * Gets the attribute value for XpeBillOptionsSet, using the alias name XpeBillOptionsSet.
     * @return the value of XpeBillOptionsSet
     */
    public String getXpeBillOptionsSet() {
        return (String) getAttributeInternal(XPEBILLOPTIONSSET);
    }

    /**
     * Sets <code>value</code> as the attribute value for XpeBillOptionsSet.
     * @param value value to set the XpeBillOptionsSet
     */
    public void setXpeBillOptionsSet(String value) {
        setAttributeInternal(XPEBILLOPTIONSSET, value);
    }

    /**
     * Gets the attribute value for XpeAcctgOptionsSet, using the alias name XpeAcctgOptionsSet.
     * @return the value of XpeAcctgOptionsSet
     */
    public String getXpeAcctgOptionsSet() {
        return (String) getAttributeInternal(XPEACCTGOPTIONSSET);
    }

    /**
     * Sets <code>value</code> as the attribute value for XpeAcctgOptionsSet.
     * @param value value to set the XpeAcctgOptionsSet
     */
    public void setXpeAcctgOptionsSet(String value) {
        setAttributeInternal(XPEACCTGOPTIONSSET, value);
    }

    /**
     * Gets the attribute value for XpeContractTemplate, using the alias name XpeContractTemplate.
     * @return the value of XpeContractTemplate
     */
    public String getXpeContractTemplate() {
        return (String) getAttributeInternal(XPECONTRACTTEMPLATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for XpeContractTemplate.
     * @param value value to set the XpeContractTemplate
     */
    public void setXpeContractTemplate(String value) {
        setAttributeInternal(XPECONTRACTTEMPLATE, value);
    }

    /**
     * Gets the attribute value for BusinessUnitGl, using the alias name BusinessUnitGl.
     * @return the value of BusinessUnitGl
     */
    public String getBusinessUnitGl() {
        return (String) getAttributeInternal(BUSINESSUNITGL);
    }

    /**
     * Sets <code>value</code> as the attribute value for BusinessUnitGl.
     * @param value value to set the BusinessUnitGl
     */
    public void setBusinessUnitGl(String value) {
        setAttributeInternal(BUSINESSUNITGL, value);
    }

    /**
     * Gets the attribute value for CurrencyCd, using the alias name CurrencyCd.
     * @return the value of CurrencyCd
     */
    public String getCurrencyCd() {
        return (String) getAttributeInternal(CURRENCYCD);
    }

    /**
     * Sets <code>value</code> as the attribute value for CurrencyCd.
     * @param value value to set the CurrencyCd
     */
    public void setCurrencyCd(String value) {
        setAttributeInternal(CURRENCYCD, value);
    }

    /**
     * Gets the attribute value for XpeWasteType, using the alias name XpeWasteType.
     * @return the value of XpeWasteType
     */
    public String getXpeWasteType() {
        return (String) getAttributeInternal(XPEWASTETYPE);
    }

    /**
     * Sets <code>value</code> as the attribute value for XpeWasteType.
     * @param value value to set the XpeWasteType
     */
    public void setXpeWasteType(String value) {
        setAttributeInternal(XPEWASTETYPE, value);
    }

    /**
     * Gets the attribute value for XpeContractSubType, using the alias name XpeContractSubType.
     * @return the value of XpeContractSubType
     */
    public String getXpeContractSubType() {
        return (String) getAttributeInternal(XPECONTRACTSUBTYPE);
    }

    /**
     * Sets <code>value</code> as the attribute value for XpeContractSubType.
     * @param value value to set the XpeContractSubType
     */
    public void setXpeContractSubType(String value) {
        setAttributeInternal(XPECONTRACTSUBTYPE, value);
    }

    /**
     * Gets the attribute value for XpeAgreementType, using the alias name XpeAgreementType.
     * @return the value of XpeAgreementType
     */
    public String getXpeAgreementType() {
        return (String) getAttributeInternal(XPEAGREEMENTTYPE);
    }

    /**
     * Sets <code>value</code> as the attribute value for XpeAgreementType.
     * @param value value to set the XpeAgreementType
     */
    public void setXpeAgreementType(String value) {
        setAttributeInternal(XPEAGREEMENTTYPE, value);
    }

    /**
     * Gets the attribute value for XpeAsOfDate, using the alias name XpeAsOfDate.
     * @return the value of XpeAsOfDate
     */
    public Timestamp getXpeAsOfDate() {
        return (Timestamp) getAttributeInternal(XPEASOFDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for XpeAsOfDate.
     * @param value value to set the XpeAsOfDate
     */
    public void setXpeAsOfDate(Timestamp value) {
        setAttributeInternal(XPEASOFDATE, value);
    }

    /**
     * Gets the attribute value for SalesPerson, using the alias name SalesPerson.
     * @return the value of SalesPerson
     */
    public String getSalesPerson() {
        return (String) getAttributeInternal(SALESPERSON);
    }

    /**
     * Sets <code>value</code> as the attribute value for SalesPerson.
     * @param value value to set the SalesPerson
     */
    public void setSalesPerson(String value) {
        setAttributeInternal(SALESPERSON, value);
    }

    /**
     * Gets the attribute value for XpeContractDirection, using the alias name XpeContractDirection.
     * @return the value of XpeContractDirection
     */
    public String getXpeContractDirection() {
        return (String) getAttributeInternal(XPECONTRACTDIRECTION);
    }

    /**
     * Sets <code>value</code> as the attribute value for XpeContractDirection.
     * @param value value to set the XpeContractDirection
     */
    public void setXpeContractDirection(String value) {
        setAttributeInternal(XPECONTRACTDIRECTION, value);
    }

    /**
     * Gets the attribute value for XpeTermAgreement, using the alias name XpeTermAgreement.
     * @return the value of XpeTermAgreement
     */
    public String getXpeTermAgreement() {
        return (String) getAttributeInternal(XPETERMAGREEMENT);
    }

    /**
     * Sets <code>value</code> as the attribute value for XpeTermAgreement.
     * @param value value to set the XpeTermAgreement
     */
    public void setXpeTermAgreement(String value) {
        setAttributeInternal(XPETERMAGREEMENT, value);
    }

    /**
     * Gets the attribute value for XpeVarianceBudget, using the alias name XpeVarianceBudget.
     * @return the value of XpeVarianceBudget
     */
    public String getXpeVarianceBudget() {
        return (String) getAttributeInternal(XPEVARIANCEBUDGET);
    }

    /**
     * Sets <code>value</code> as the attribute value for XpeVarianceBudget.
     * @param value value to set the XpeVarianceBudget
     */
    public void setXpeVarianceBudget(String value) {
        setAttributeInternal(XPEVARIANCEBUDGET, value);
    }

    /**
     * Gets the attribute value for XpeEstDisposalVol, using the alias name XpeEstDisposalVol.
     * @return the value of XpeEstDisposalVol
     */
    public String getXpeEstDisposalVol() {
        return (String) getAttributeInternal(XPEESTDISPOSALVOL);
    }

    /**
     * Sets <code>value</code> as the attribute value for XpeEstDisposalVol.
     * @param value value to set the XpeEstDisposalVol
     */
    public void setXpeEstDisposalVol(String value) {
        setAttributeInternal(XPEESTDISPOSALVOL, value);
    }

    /**
     * Gets the attribute value for XpeValueTransaction, using the alias name XpeValueTransaction.
     * @return the value of XpeValueTransaction
     */
    public String getXpeValueTransaction() {
        return (String) getAttributeInternal(XPEVALUETRANSACTION);
    }

    /**
     * Sets <code>value</code> as the attribute value for XpeValueTransaction.
     * @param value value to set the XpeValueTransaction
     */
    public void setXpeValueTransaction(String value) {
        setAttributeInternal(XPEVALUETRANSACTION, value);
    }

    /**
     * Gets the attribute value for XpeJustification, using the alias name XpeJustification.
     * @return the value of XpeJustification
     */
    public String getXpeJustification() {
        return (String) getAttributeInternal(XPEJUSTIFICATION);
    }

    /**
     * Sets <code>value</code> as the attribute value for XpeJustification.
     * @param value value to set the XpeJustification
     */
    public void setXpeJustification(String value) {
        setAttributeInternal(XPEJUSTIFICATION, value);
    }

    /**
     * Gets the attribute value for XpeExistingCustomer, using the alias name XpeExistingCustomer.
     * @return the value of XpeExistingCustomer
     */
    public String getXpeExistingCustomer() {
        return (String) getAttributeInternal(XPEEXISTINGCUSTOMER);
    }

    /**
     * Sets <code>value</code> as the attribute value for XpeExistingCustomer.
     * @param value value to set the XpeExistingCustomer
     */
    public void setXpeExistingCustomer(String value) {
        setAttributeInternal(XPEEXISTINGCUSTOMER, value);
    }

    /**
     * Gets the attribute value for XpePaymentMethod, using the alias name XpePaymentMethod.
     * @return the value of XpePaymentMethod
     */
    public String getXpePaymentMethod() {
        return (String) getAttributeInternal(XPEPAYMENTMETHOD);
    }

    /**
     * Sets <code>value</code> as the attribute value for XpePaymentMethod.
     * @param value value to set the XpePaymentMethod
     */
    public void setXpePaymentMethod(String value) {
        setAttributeInternal(XPEPAYMENTMETHOD, value);
    }

    /**
     * Gets the attribute value for XpePaymentHistory, using the alias name XpePaymentHistory.
     * @return the value of XpePaymentHistory
     */
    public String getXpePaymentHistory() {
        return (String) getAttributeInternal(XPEPAYMENTHISTORY);
    }

    /**
     * Sets <code>value</code> as the attribute value for XpePaymentHistory.
     * @param value value to set the XpePaymentHistory
     */
    public void setXpePaymentHistory(String value) {
        setAttributeInternal(XPEPAYMENTHISTORY, value);
    }

    /**
     * Gets the attribute value for XpeCreditLimit, using the alias name XpeCreditLimit.
     * @return the value of XpeCreditLimit
     */
    public String getXpeCreditLimit() {
        return (String) getAttributeInternal(XPECREDITLIMIT);
    }

    /**
     * Sets <code>value</code> as the attribute value for XpeCreditLimit.
     * @param value value to set the XpeCreditLimit
     */
    public void setXpeCreditLimit(String value) {
        setAttributeInternal(XPECREDITLIMIT, value);
    }

    /**
     * @return the associated entity oracle.jbo.RowIterator.
     */
    public RowIterator getXpeDccContractNotes() {
        return (RowIterator) getAttributeInternal(XPEDCCCONTRACTNOTES);
    }

    /**
     * @return the associated entity oracle.jbo.RowIterator.
     */
    public RowIterator getXpeDccContractLine() {
        return (RowIterator) getAttributeInternal(XPEDCCCONTRACTLINE);
    }

    /**
     * @return the associated entity XpeDccContractsImpl.
     */
    public XpeDccContractsImpl getXpeDccContracts() {
        return (XpeDccContractsImpl) getAttributeInternal(XPEDCCCONTRACTS);
    }

    /**
     * Sets <code>value</code> as the associated entity XpeDccContractsImpl.
     */
    public void setXpeDccContracts(XpeDccContractsImpl value) {
        setAttributeInternal(XPEDCCCONTRACTS, value);
    }


    /**
     * @return the associated entity oracle.jbo.RowIterator.
     */
    public RowIterator getXpeDccContractsAttachments() {
        return (RowIterator) getAttributeInternal(XPEDCCCONTRACTSATTACHMENTS);
    }


    /**
     * @return the associated entity oracle.jbo.RowIterator.
     */
    public RowIterator getXpeDccTermsContractEO() {
        return (RowIterator) getAttributeInternal(XPEDCCTERMSCONTRACTEO);
    }


    /**
     * @return the associated entity oracle.jbo.RowIterator.
     */
    public RowIterator getXpeDccWfEventEO() {
        return (RowIterator) getAttributeInternal(XPEDCCWFEVENTEO);
    }


    /**
     * @param xpeContractId key constituent
     * @param xpeContractVersion key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(String xpeContractId, String xpeContractVersion) {
        return new Key(new Object[] { xpeContractId, xpeContractVersion });
    }

    /**
     * Add attribute defaulting logic in this method.
     * @param attributeList list of attribute names/values to initialize the row
     */
    protected void create(AttributeList attributeList) {
        super.create(attributeList);
    }
    protected String nextVal(String sequenceName) {
        SequenceImpl s = new SequenceImpl(sequenceName, getDBTransaction());
        return "V"+s.getSequenceNumber().toString();
    }
}

