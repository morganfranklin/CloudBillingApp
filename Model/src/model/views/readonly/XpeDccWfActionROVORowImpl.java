package model.views.readonly;

import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sun Oct 22 23:10:18 EDT 2017
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class XpeDccWfActionROVORowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        XpeContractId,
        XpeContractVersion,
        XpeEventNumber,
        XpeApproverSequence,
        XpeUuid,
        XpeApproverEmail,
        XpeActionStatus;
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
    public static final int XPEEVENTNUMBER = AttributesEnum.XpeEventNumber.index();
    public static final int XPEAPPROVERSEQUENCE = AttributesEnum.XpeApproverSequence.index();
    public static final int XPEUUID = AttributesEnum.XpeUuid.index();
    public static final int XPEAPPROVEREMAIL = AttributesEnum.XpeApproverEmail.index();
    public static final int XPEACTIONSTATUS = AttributesEnum.XpeActionStatus.index();

    /**
     * This is the default constructor (do not remove).
     */
    public XpeDccWfActionROVORowImpl() {
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
     * Gets the attribute value for the calculated attribute XpeEventNumber.
     * @return the XpeEventNumber
     */
    public String getXpeEventNumber() {
        return (String) getAttributeInternal(XPEEVENTNUMBER);
    }

    /**
     * Gets the attribute value for the calculated attribute XpeApproverSequence.
     * @return the XpeApproverSequence
     */
    public String getXpeApproverSequence() {
        return (String) getAttributeInternal(XPEAPPROVERSEQUENCE);
    }

    /**
     * Gets the attribute value for the calculated attribute XpeUuid.
     * @return the XpeUuid
     */
    public String getXpeUuid() {
        return (String) getAttributeInternal(XPEUUID);
    }

    /**
     * Gets the attribute value for the calculated attribute XpeApproverEmail.
     * @return the XpeApproverEmail
     */
    public String getXpeApproverEmail() {
        return (String) getAttributeInternal(XPEAPPROVEREMAIL);
    }

    /**
     * Gets the attribute value for the calculated attribute XpeActionStatus.
     * @return the XpeActionStatus
     */
    public String getXpeActionStatus() {
        return (String) getAttributeInternal(XPEACTIONSTATUS);
    }
}
