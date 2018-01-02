package model.entities;

import oracle.jbo.Key;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.SequenceImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Sep 20 07:25:53 EDT 2017
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class XpeDccCfgGeneralCnvEOImpl extends EntityImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        GeneralCnvId,
        CarrierId,
        OriginId,
        DestinationId,
        MaterialId,
        PcsShortNameId,
        TranslationConsumer,
        ConversionValue,
        CreatedBy,
        CreatedDate,
        LastUpdatedBy,
        LastUpdatedDate,
        Inactive,
        InactiveDate,
        TohBusinessType,
        TohPayType,
        Country;
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


    public static final int GENERALCNVID = AttributesEnum.GeneralCnvId.index();
    public static final int CARRIERID = AttributesEnum.CarrierId.index();
    public static final int ORIGINID = AttributesEnum.OriginId.index();
    public static final int DESTINATIONID = AttributesEnum.DestinationId.index();
    public static final int MATERIALID = AttributesEnum.MaterialId.index();
    public static final int PCSSHORTNAMEID = AttributesEnum.PcsShortNameId.index();
    public static final int TRANSLATIONCONSUMER = AttributesEnum.TranslationConsumer.index();
    public static final int CONVERSIONVALUE = AttributesEnum.ConversionValue.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int CREATEDDATE = AttributesEnum.CreatedDate.index();
    public static final int LASTUPDATEDBY = AttributesEnum.LastUpdatedBy.index();
    public static final int LASTUPDATEDDATE = AttributesEnum.LastUpdatedDate.index();
    public static final int INACTIVE = AttributesEnum.Inactive.index();
    public static final int INACTIVEDATE = AttributesEnum.InactiveDate.index();
    public static final int TOHBUSINESSTYPE = AttributesEnum.TohBusinessType.index();
    public static final int TOHPAYTYPE = AttributesEnum.TohPayType.index();
    public static final int COUNTRY = AttributesEnum.Country.index();

    /**
     * This is the default constructor (do not remove).
     */
    public XpeDccCfgGeneralCnvEOImpl() {
    }

    /**
     * @param generalCnvId key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(String generalCnvId) {
        return new Key(new Object[] { generalCnvId });
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        return EntityDefImpl.findDefObject("model.entities.XpeDccCfgGeneralCnvEO");
    }


    protected String nextVal(String sequenceName) {
        SequenceImpl s = new SequenceImpl(sequenceName, getDBTransaction());
        return s.getSequenceNumber().toString();
    }
}

