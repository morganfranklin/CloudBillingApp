package model.views.readonly;

import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Tue Nov 28 16:53:44 EST 2017
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class XpeDccCfgPcsAddressROVORowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        SiteId,
        SiteAddress1,
        SiteAddress2,
        SiteCity,
        SiteState,
        SitePostal,
        SiteOperatingHours;
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
    public static final int SITEADDRESS1 = AttributesEnum.SiteAddress1.index();
    public static final int SITEADDRESS2 = AttributesEnum.SiteAddress2.index();
    public static final int SITECITY = AttributesEnum.SiteCity.index();
    public static final int SITESTATE = AttributesEnum.SiteState.index();
    public static final int SITEPOSTAL = AttributesEnum.SitePostal.index();
    public static final int SITEOPERATINGHOURS = AttributesEnum.SiteOperatingHours.index();

    /**
     * This is the default constructor (do not remove).
     */
    public XpeDccCfgPcsAddressROVORowImpl() {
    }

    /**
     * Gets the attribute value for the calculated attribute SiteId.
     * @return the SiteId
     */
    public String getSiteId() {
        return (String) getAttributeInternal(SITEID);
    }

    /**
     * Gets the attribute value for the calculated attribute SiteAddress1.
     * @return the SiteAddress1
     */
    public String getSiteAddress1() {
        return (String) getAttributeInternal(SITEADDRESS1);
    }

    /**
     * Gets the attribute value for the calculated attribute SiteAddress2.
     * @return the SiteAddress2
     */
    public String getSiteAddress2() {
        return (String) getAttributeInternal(SITEADDRESS2);
    }

    /**
     * Gets the attribute value for the calculated attribute SiteCity.
     * @return the SiteCity
     */
    public String getSiteCity() {
        return (String) getAttributeInternal(SITECITY);
    }

    /**
     * Gets the attribute value for the calculated attribute SiteState.
     * @return the SiteState
     */
    public String getSiteState() {
        return (String) getAttributeInternal(SITESTATE);
    }

    /**
     * Gets the attribute value for the calculated attribute SitePostal.
     * @return the SitePostal
     */
    public String getSitePostal() {
        return (String) getAttributeInternal(SITEPOSTAL);
    }

    /**
     * Gets the attribute value for the calculated attribute SiteOperatingHours.
     * @return the SiteOperatingHours
     */
    public String getSiteOperatingHours() {
        return (String) getAttributeInternal(SITEOPERATINGHOURS);
    }
}

