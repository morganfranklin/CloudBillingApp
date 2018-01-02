package model.entities;

import oracle.jbo.Key;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.SequenceImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sun Sep 10 02:47:07 EDT 2017
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class XpeDccCfgPcsEOImpl extends EntityImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        SiteId,
        SiteDesc,
        DbLink,
        PrintStage,
        Inactive,
        InactiveDate,
        Activate,
        DirectToCustomer,
        EmailNotificationGroup,
        CreatedBy,
        CreatedDate,
        LastUpdatedBy,
        LastUpdatedDate,
        FacilityId,
        XpeDccCfgPcsAssTerminalsEO,
        XpeDccCfgPcsAddressEO;
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


    public static final int SITEID = AttributesEnum.SiteId.index();
    public static final int SITEDESC = AttributesEnum.SiteDesc.index();
    public static final int DBLINK = AttributesEnum.DbLink.index();
    public static final int PRINTSTAGE = AttributesEnum.PrintStage.index();
    public static final int INACTIVE = AttributesEnum.Inactive.index();
    public static final int INACTIVEDATE = AttributesEnum.InactiveDate.index();
    public static final int ACTIVATE = AttributesEnum.Activate.index();
    public static final int DIRECTTOCUSTOMER = AttributesEnum.DirectToCustomer.index();
    public static final int EMAILNOTIFICATIONGROUP = AttributesEnum.EmailNotificationGroup.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int CREATEDDATE = AttributesEnum.CreatedDate.index();
    public static final int LASTUPDATEDBY = AttributesEnum.LastUpdatedBy.index();
    public static final int LASTUPDATEDDATE = AttributesEnum.LastUpdatedDate.index();
    public static final int FACILITYID = AttributesEnum.FacilityId.index();
    public static final int XPEDCCCFGPCSASSTERMINALSEO = AttributesEnum.XpeDccCfgPcsAssTerminalsEO.index();
    public static final int XPEDCCCFGPCSADDRESSEO = AttributesEnum.XpeDccCfgPcsAddressEO.index();

    /**
     * This is the default constructor (do not remove).
     */
    public XpeDccCfgPcsEOImpl() {
    }

    /**
     * @param siteId key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(String siteId) {
        return new Key(new Object[] { siteId });
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        return EntityDefImpl.findDefObject("model.entities.XpeDccCfgPcsEO");
    }


    protected String nextVal(String sequenceName) {
        SequenceImpl s = new SequenceImpl(sequenceName, getDBTransaction());
        return s.getSequenceNumber().toString();
    }
}

