package model.entities;

import oracle.jbo.Key;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.SequenceImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Sep 13 00:22:34 EDT 2017
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class XpeDccCfgCarriersEOImpl extends EntityImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        CarrierId,
        CarrierName,
        State,
        Inactive,
        InactiveDate,
        CreatedBy,
        CreatedDate,
        LastUpdatedBy,
        LastUpdatedDate;
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

    public static final int CARRIERID = AttributesEnum.CarrierId.index();
    public static final int CARRIERNAME = AttributesEnum.CarrierName.index();
    public static final int STATE = AttributesEnum.State.index();
    public static final int INACTIVE = AttributesEnum.Inactive.index();
    public static final int INACTIVEDATE = AttributesEnum.InactiveDate.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int CREATEDDATE = AttributesEnum.CreatedDate.index();
    public static final int LASTUPDATEDBY = AttributesEnum.LastUpdatedBy.index();
    public static final int LASTUPDATEDDATE = AttributesEnum.LastUpdatedDate.index();

    /**
     * This is the default constructor (do not remove).
     */
    public XpeDccCfgCarriersEOImpl() {
    }

    /**
     * @param carrierId key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(String carrierId) {
        return new Key(new Object[] { carrierId });
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        return EntityDefImpl.findDefObject("model.entities.XpeDccCfgCarriersEO");
    }


    protected String nextVal(String sequenceName) {
        SequenceImpl s = new SequenceImpl(sequenceName, getDBTransaction());
        return s.getSequenceNumber().toString();
    }
}

