package model;

import java.math.BigDecimal;

import oracle.jbo.RowIterator;
import oracle.jbo.RowSet;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Aug 23 18:20:50 IST 2017
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class XpeDccContractLineViewRowImpl extends ViewRowImpl {


    public static final int ENTITY_XPEDCCCONTRACTLINE = 0;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        XpeContractId,
        XpeContractVersion,
        XpeContractLine,
        XpeFacility,
        XpeProductId,
        XpeProductUom,
        XpeQtyMin,
        XpeQtyMax,
        XpePeriodType,
        XpeSwApprNbr,
        CurrencyCd,
        BusinessUnitGl,
        XpeDccContractDocTermView,
        XpeDccContractPricingTermView,
        XpeDccContractPricingOverView,
        XpeDccDicProducts1,
        XpeDccDicPeriods1,
        XpeDccDicUnitsOfMeasure1,
        XpeDccDicCurrency1,
        XpeDccCfgPcsROVO_LOV,
        PsCurrencyCdTblROVO1,
        XpeDccGeneralItemListROVO_BusinessUintLOV,
        XpeDccCfgUserBusinessUnitROVO1;
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


    public static final int XPECONTRACTID = AttributesEnum.XpeContractId.index();
    public static final int XPECONTRACTVERSION = AttributesEnum.XpeContractVersion.index();
    public static final int XPECONTRACTLINE = AttributesEnum.XpeContractLine.index();
    public static final int XPEFACILITY = AttributesEnum.XpeFacility.index();
    public static final int XPEPRODUCTID = AttributesEnum.XpeProductId.index();
    public static final int XPEPRODUCTUOM = AttributesEnum.XpeProductUom.index();
    public static final int XPEQTYMIN = AttributesEnum.XpeQtyMin.index();
    public static final int XPEQTYMAX = AttributesEnum.XpeQtyMax.index();
    public static final int XPEPERIODTYPE = AttributesEnum.XpePeriodType.index();
    public static final int XPESWAPPRNBR = AttributesEnum.XpeSwApprNbr.index();
    public static final int CURRENCYCD = AttributesEnum.CurrencyCd.index();
    public static final int BUSINESSUNITGL = AttributesEnum.BusinessUnitGl.index();
    public static final int XPEDCCCONTRACTDOCTERMVIEW = AttributesEnum.XpeDccContractDocTermView.index();
    public static final int XPEDCCCONTRACTPRICINGTERMVIEW = AttributesEnum.XpeDccContractPricingTermView.index();
    public static final int XPEDCCCONTRACTPRICINGOVERVIEW = AttributesEnum.XpeDccContractPricingOverView.index();
    public static final int XPEDCCDICPRODUCTS1 = AttributesEnum.XpeDccDicProducts1.index();
    public static final int XPEDCCDICPERIODS1 = AttributesEnum.XpeDccDicPeriods1.index();
    public static final int XPEDCCDICUNITSOFMEASURE1 = AttributesEnum.XpeDccDicUnitsOfMeasure1.index();
    public static final int XPEDCCDICCURRENCY1 = AttributesEnum.XpeDccDicCurrency1.index();
    public static final int XPEDCCCFGPCSROVO_LOV = AttributesEnum.XpeDccCfgPcsROVO_LOV.index();
    public static final int PSCURRENCYCDTBLROVO1 = AttributesEnum.PsCurrencyCdTblROVO1.index();
    public static final int XPEDCCGENERALITEMLISTROVO_BUSINESSUINTLOV =
        AttributesEnum.XpeDccGeneralItemListROVO_BusinessUintLOV.index();
    public static final int XPEDCCCFGUSERBUSINESSUNITROVO1 = AttributesEnum.XpeDccCfgUserBusinessUnitROVO1.index();

    /**
     * This is the default constructor (do not remove).
     */
    public XpeDccContractLineViewRowImpl() {
    }

    /**
     * Gets XpeDccContractLine entity object.
     * @return the XpeDccContractLine
     */
    public XpeDccContractLineImpl getXpeDccContractLine() {
        return (XpeDccContractLineImpl) getEntity(ENTITY_XPEDCCCONTRACTLINE);
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
     * Gets the attribute value for XPE_CONTRACT_LINE using the alias name XpeContractLine.
     * @return the XPE_CONTRACT_LINE
     */
    public String getXpeContractLine() {
        return (String) getAttributeInternal(XPECONTRACTLINE);
    }


    /**
     * Sets <code>value</code> as attribute value for XPE_CONTRACT_LINE using the alias name XpeContractLine.
     * @param value value to set the XPE_CONTRACT_LINE
     */
    public void setXpeContractLine(String value) {
        setAttributeInternal(XPECONTRACTLINE, value);
    }

    /**
     * Gets the attribute value for XPE_FACILITY using the alias name XpeFacility.
     * @return the XPE_FACILITY
     */
    public String getXpeFacility() {
        return (String) getAttributeInternal(XPEFACILITY);
    }

    /**
     * Sets <code>value</code> as attribute value for XPE_FACILITY using the alias name XpeFacility.
     * @param value value to set the XPE_FACILITY
     */
    public void setXpeFacility(String value) {
        setAttributeInternal(XPEFACILITY, value);
    }

    /**
     * Gets the attribute value for XPE_PRODUCT_ID using the alias name XpeProductId.
     * @return the XPE_PRODUCT_ID
     */
    public String getXpeProductId() {
        return (String) getAttributeInternal(XPEPRODUCTID);
    }

    /**
     * Sets <code>value</code> as attribute value for XPE_PRODUCT_ID using the alias name XpeProductId.
     * @param value value to set the XPE_PRODUCT_ID
     */
    public void setXpeProductId(String value) {
        setAttributeInternal(XPEPRODUCTID, value);
    }

    /**
     * Gets the attribute value for XPE_PRODUCT_UOM using the alias name XpeProductUom.
     * @return the XPE_PRODUCT_UOM
     */
    public String getXpeProductUom() {
        return (String) getAttributeInternal(XPEPRODUCTUOM);
    }

    /**
     * Sets <code>value</code> as attribute value for XPE_PRODUCT_UOM using the alias name XpeProductUom.
     * @param value value to set the XPE_PRODUCT_UOM
     */
    public void setXpeProductUom(String value) {
        setAttributeInternal(XPEPRODUCTUOM, value);
    }

    /**
     * Gets the attribute value for XPE_QTY_MIN using the alias name XpeQtyMin.
     * @return the XPE_QTY_MIN
     */
    public BigDecimal getXpeQtyMin() {
        return (BigDecimal) getAttributeInternal(XPEQTYMIN);
    }

    /**
     * Sets <code>value</code> as attribute value for XPE_QTY_MIN using the alias name XpeQtyMin.
     * @param value value to set the XPE_QTY_MIN
     */
    public void setXpeQtyMin(BigDecimal value) {
        setAttributeInternal(XPEQTYMIN, value);
    }

    /**
     * Gets the attribute value for XPE_QTY_MAX using the alias name XpeQtyMax.
     * @return the XPE_QTY_MAX
     */
    public BigDecimal getXpeQtyMax() {
        return (BigDecimal) getAttributeInternal(XPEQTYMAX);
    }

    /**
     * Sets <code>value</code> as attribute value for XPE_QTY_MAX using the alias name XpeQtyMax.
     * @param value value to set the XPE_QTY_MAX
     */
    public void setXpeQtyMax(BigDecimal value) {
        setAttributeInternal(XPEQTYMAX, value);
    }

    /**
     * Gets the attribute value for XPE_PERIOD_TYPE using the alias name XpePeriodType.
     * @return the XPE_PERIOD_TYPE
     */
    public String getXpePeriodType() {
        return (String) getAttributeInternal(XPEPERIODTYPE);
    }

    /**
     * Sets <code>value</code> as attribute value for XPE_PERIOD_TYPE using the alias name XpePeriodType.
     * @param value value to set the XPE_PERIOD_TYPE
     */
    public void setXpePeriodType(String value) {
        setAttributeInternal(XPEPERIODTYPE, value);
    }

    /**
     * Gets the attribute value for XPE_SW_APPR_NBR using the alias name XpeSwApprNbr.
     * @return the XPE_SW_APPR_NBR
     */
    public String getXpeSwApprNbr() {
        return (String) getAttributeInternal(XPESWAPPRNBR);
    }

    /**
     * Sets <code>value</code> as attribute value for XPE_SW_APPR_NBR using the alias name XpeSwApprNbr.
     * @param value value to set the XPE_SW_APPR_NBR
     */
    public void setXpeSwApprNbr(String value) {
        setAttributeInternal(XPESWAPPRNBR, value);
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
     * Gets the attribute value for BUSINESS_UNIT_GL using the alias name BusinessUnitGl.
     * @return the BUSINESS_UNIT_GL
     */
    public String getBusinessUnitGl() {
        return (String) getAttributeInternal(BUSINESSUNITGL);
    }

    /**
     * Sets <code>value</code> as attribute value for BUSINESS_UNIT_GL using the alias name BusinessUnitGl.
     * @param value value to set the BUSINESS_UNIT_GL
     */
    public void setBusinessUnitGl(String value) {
        setAttributeInternal(BUSINESSUNITGL, value);
    }

    /**
     * Gets the associated <code>RowIterator</code> using master-detail link XpeDccContractDocTermView.
     */
    public RowIterator getXpeDccContractDocTermView() {
        return (RowIterator) getAttributeInternal(XPEDCCCONTRACTDOCTERMVIEW);
    }

    /**
     * Gets the associated <code>RowIterator</code> using master-detail link XpeDccContractPricingTermView.
     */
    public RowIterator getXpeDccContractPricingTermView() {
        return (RowIterator) getAttributeInternal(XPEDCCCONTRACTPRICINGTERMVIEW);
    }

    /**
     * Gets the associated <code>RowIterator</code> using master-detail link XpeDccContractPricingOverView.
     */
    public RowIterator getXpeDccContractPricingOverView() {
        return (RowIterator) getAttributeInternal(XPEDCCCONTRACTPRICINGOVERVIEW);
    }


    /**
     * Gets the view accessor <code>RowSet</code> XpeDccDicProducts1.
     */
    public RowSet getXpeDccDicProducts1() {
        return (RowSet) getAttributeInternal(XPEDCCDICPRODUCTS1);
    }


    /**
     * Gets the view accessor <code>RowSet</code> XpeDccDicPeriods1.
     */
    public RowSet getXpeDccDicPeriods1() {
        return (RowSet) getAttributeInternal(XPEDCCDICPERIODS1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> XpeDccDicUnitsOfMeasure1.
     */
    public RowSet getXpeDccDicUnitsOfMeasure1() {
        return (RowSet) getAttributeInternal(XPEDCCDICUNITSOFMEASURE1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> XpeDccDicCurrency1.
     */
    public RowSet getXpeDccDicCurrency1() {
        return (RowSet) getAttributeInternal(XPEDCCDICCURRENCY1);
    }


    /**
     * Gets the view accessor <code>RowSet</code> XpeDccCfgPcsROVO_LOV.
     */
    public RowSet getXpeDccCfgPcsROVO_LOV() {
        return (RowSet) getAttributeInternal(XPEDCCCFGPCSROVO_LOV);
    }


    /**
     * Gets the view accessor <code>RowSet</code> PsCurrencyCdTblROVO1.
     */
    public RowSet getPsCurrencyCdTblROVO1() {
        return (RowSet) getAttributeInternal(PSCURRENCYCDTBLROVO1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> XpeDccGeneralItemListROVO_BusinessUintLOV.
     */
    public RowSet getXpeDccGeneralItemListROVO_BusinessUintLOV() {
        return (RowSet) getAttributeInternal(XPEDCCGENERALITEMLISTROVO_BUSINESSUINTLOV);
    }

    /**
     * Gets the view accessor <code>RowSet</code> XpeDccCfgUserBusinessUnitROVO1.
     */
    public RowSet getXpeDccCfgUserBusinessUnitROVO1() {
        return (RowSet) getAttributeInternal(XPEDCCCFGUSERBUSINESSUNITROVO1);
    }
}

