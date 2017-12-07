package model.entities;

import oracle.jbo.Key;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.SequenceImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Oct 18 17:37:57 EDT 2017
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class XpeDccWfActionEOImpl extends EntityImpl {
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
        XpeActionStatus,
        CreatedBy,
        CreatedDate,
        LastUpdatedBy,
        LastUpdatedDate,
        XpeApproverLevel,
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
    public static final int XPEEVENTNUMBER = AttributesEnum.XpeEventNumber.index();
    public static final int XPEAPPROVERSEQUENCE = AttributesEnum.XpeApproverSequence.index();
    public static final int XPEUUID = AttributesEnum.XpeUuid.index();
    public static final int XPEAPPROVEREMAIL = AttributesEnum.XpeApproverEmail.index();
    public static final int XPEACTIONSTATUS = AttributesEnum.XpeActionStatus.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int CREATEDDATE = AttributesEnum.CreatedDate.index();
    public static final int LASTUPDATEDBY = AttributesEnum.LastUpdatedBy.index();
    public static final int LASTUPDATEDDATE = AttributesEnum.LastUpdatedDate.index();
    public static final int XPEAPPROVERLEVEL = AttributesEnum.XpeApproverLevel.index();
    public static final int XPEDCCWFEVENTEO = AttributesEnum.XpeDccWfEventEO.index();

    /**
     * This is the default constructor (do not remove).
     */
    public XpeDccWfActionEOImpl() {
    }

    /**
     * @param xpeApproverSequence key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(String xpeApproverSequence) {
        return new Key(new Object[] { xpeApproverSequence });
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        return EntityDefImpl.findDefObject("model.entities.XpeDccWfActionEO");
    }


    protected String nextVal(String sequenceName) {
        SequenceImpl s = new SequenceImpl(sequenceName, getDBTransaction());
        return s.getSequenceNumber().toString();
    }
}

