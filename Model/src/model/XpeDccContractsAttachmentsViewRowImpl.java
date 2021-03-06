package model;

import java.math.BigDecimal;

import java.sql.Timestamp;

import oracle.jbo.domain.BlobDomain;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Jan 03 17:32:12 EST 2018
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class XpeDccContractsAttachmentsViewRowImpl extends ViewRowImpl {

    public static final int ENTITY_XPEDCCCONTRACTSATTACHMENTS = 0;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        AttachmentId,
        XpeContractId,
        XpeContractVersion,
        Name,
        UploadFile,
        CreatedBy,
        CreatedOn,
        LastUpdatedBy,
        LastUpdatedOn,
        Identifier;
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

    public static final int ATTACHMENTID = AttributesEnum.AttachmentId.index();
    public static final int XPECONTRACTID = AttributesEnum.XpeContractId.index();
    public static final int XPECONTRACTVERSION = AttributesEnum.XpeContractVersion.index();
    public static final int NAME = AttributesEnum.Name.index();
    public static final int UPLOADFILE = AttributesEnum.UploadFile.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int CREATEDON = AttributesEnum.CreatedOn.index();
    public static final int LASTUPDATEDBY = AttributesEnum.LastUpdatedBy.index();
    public static final int LASTUPDATEDON = AttributesEnum.LastUpdatedOn.index();
    public static final int IDENTIFIER = AttributesEnum.Identifier.index();

    /**
     * This is the default constructor (do not remove).
     */
    public XpeDccContractsAttachmentsViewRowImpl() {
    }

    /**
     * Gets XpeDccContractsAttachments entity object.
     * @return the XpeDccContractsAttachments
     */
    public EntityImpl getXpeDccContractsAttachments() {
        return (EntityImpl) getEntity(ENTITY_XPEDCCCONTRACTSATTACHMENTS);
    }

    /**
     * Gets the attribute value for ATTACHMENT_ID using the alias name AttachmentId.
     * @return the ATTACHMENT_ID
     */
    public BigDecimal getAttachmentId() {
        return (BigDecimal) getAttributeInternal(ATTACHMENTID);
    }

    /**
     * Sets <code>value</code> as attribute value for ATTACHMENT_ID using the alias name AttachmentId.
     * @param value value to set the ATTACHMENT_ID
     */
    public void setAttachmentId(BigDecimal value) {
        setAttributeInternal(ATTACHMENTID, value);
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
     * Gets the attribute value for NAME using the alias name Name.
     * @return the NAME
     */
    public String getName() {
        return (String) getAttributeInternal(NAME);
    }

    /**
     * Sets <code>value</code> as attribute value for NAME using the alias name Name.
     * @param value value to set the NAME
     */
    public void setName(String value) {
        setAttributeInternal(NAME, value);
    }

    /**
     * Gets the attribute value for UPLOAD_FILE using the alias name UploadFile.
     * @return the UPLOAD_FILE
     */
    public BlobDomain getUploadFile() {
        return (BlobDomain) getAttributeInternal(UPLOADFILE);
    }

    /**
     * Sets <code>value</code> as attribute value for UPLOAD_FILE using the alias name UploadFile.
     * @param value value to set the UPLOAD_FILE
     */
    public void setUploadFile(BlobDomain value) {
        setAttributeInternal(UPLOADFILE, value);
    }

    /**
     * Gets the attribute value for CREATED_BY using the alias name CreatedBy.
     * @return the CREATED_BY
     */
    public String getCreatedBy() {
        return (String) getAttributeInternal(CREATEDBY);
    }


    /**
     * Gets the attribute value for CREATED_ON using the alias name CreatedOn.
     * @return the CREATED_ON
     */
    public Timestamp getCreatedOn() {
        return (Timestamp) getAttributeInternal(CREATEDON);
    }


    /**
     * Gets the attribute value for LAST_UPDATED_BY using the alias name LastUpdatedBy.
     * @return the LAST_UPDATED_BY
     */
    public String getLastUpdatedBy() {
        return (String) getAttributeInternal(LASTUPDATEDBY);
    }


    /**
     * Gets the attribute value for LAST_UPDATED_ON using the alias name LastUpdatedOn.
     * @return the LAST_UPDATED_ON
     */
    public Timestamp getLastUpdatedOn() {
        return (Timestamp) getAttributeInternal(LASTUPDATEDON);
    }

    /**
     * Gets the attribute value for IDENTIFIER using the alias name Identifier.
     * @return the IDENTIFIER
     */
    public String getIdentifier() {
        return (String) getAttributeInternal(IDENTIFIER);
    }

    /**
     * Sets <code>value</code> as attribute value for IDENTIFIER using the alias name Identifier.
     * @param value value to set the IDENTIFIER
     */
    public void setIdentifier(String value) {
        setAttributeInternal(IDENTIFIER, value);
    }

}

