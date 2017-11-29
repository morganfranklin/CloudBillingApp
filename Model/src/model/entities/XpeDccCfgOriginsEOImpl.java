package model.entities;

import oracle.jbo.Key;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.SequenceImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Sep 11 21:30:02 EDT 2017
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class XpeDccCfgOriginsEOImpl extends EntityImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        OriginId,
        OriginDesc,
        State,
        Inactive,
        InactiveDate,
        CreatedBy,
        CreatedDate,
        LastUpdatedBy,
        LastUpdatedDate,
        County,
        XpeDccNycDosDistrict,
        Country,
        XpeDccCfgOgnAssTerminalsEO;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public int index() {
            return XpeDccCfgOriginsEOImpl.AttributesEnum.firstIndex() + ordinal();
        }

        public static final int firstIndex() {
            return firstIndex;
        }

        public static int count() {
            return XpeDccCfgOriginsEOImpl.AttributesEnum.firstIndex() +
                   XpeDccCfgOriginsEOImpl.AttributesEnum.staticValues().length;
        }

        public static final AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = XpeDccCfgOriginsEOImpl.AttributesEnum.values();
            }
            return vals;
        }
    }


    public static final int ORIGINID = AttributesEnum.OriginId.index();
    public static final int ORIGINDESC = AttributesEnum.OriginDesc.index();
    public static final int STATE = AttributesEnum.State.index();
    public static final int INACTIVE = AttributesEnum.Inactive.index();
    public static final int INACTIVEDATE = AttributesEnum.InactiveDate.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int CREATEDDATE = AttributesEnum.CreatedDate.index();
    public static final int LASTUPDATEDBY = AttributesEnum.LastUpdatedBy.index();
    public static final int LASTUPDATEDDATE = AttributesEnum.LastUpdatedDate.index();
    public static final int COUNTY = AttributesEnum.County.index();
    public static final int XPEDCCNYCDOSDISTRICT = AttributesEnum.XpeDccNycDosDistrict.index();
    public static final int COUNTRY = AttributesEnum.Country.index();
    public static final int XPEDCCCFGOGNASSTERMINALSEO = AttributesEnum.XpeDccCfgOgnAssTerminalsEO.index();

    /**
     * This is the default constructor (do not remove).
     */
    public XpeDccCfgOriginsEOImpl() {
    }

    /**
     * @param originId key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(String originId) {
        return new Key(new Object[] { originId });
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        return EntityDefImpl.findDefObject("model.entities.XpeDccCfgOriginsEO");
    }


    protected String nextVal(String sequenceName) {
        SequenceImpl s = new SequenceImpl(sequenceName, getDBTransaction());
        return s.getSequenceNumber().toString();
    }

}

