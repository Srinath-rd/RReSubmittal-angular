package com.dnr.brrts.web.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "SW_RRESUBM_ATTACHMENT")
public class NfAttachment  {

    @Id
    //  @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nfattachmentid_generator")
    @SequenceGenerator(name = "nfattachmentid_generator", sequenceName = "sw_rresubm_attachmentid_seq", allocationSize = 1)
    private Long attachmentId;

    private String attachmentFileName;

    private byte [] attachment;

    private String attachmentFileType;

    public NfAttachment(Long attachmentId, String attachmentFileName, byte[] attachment, String attachmentFileType) {
        this.attachmentId = attachmentId;
        this.attachmentFileName = attachmentFileName;
        this.attachment = attachment;
        this.attachmentFileType = attachmentFileType;
    }

    public NfAttachment() {
    }

    public Long getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(Long attachmentId) {
        this.attachmentId = attachmentId;
    }

    public String getAttachmentFileName() {
        return attachmentFileName;
    }

    public void setAttachmentFileName(String attachmentFileName) {
        this.attachmentFileName = attachmentFileName;
    }

    public byte[] getAttachment() {
        return attachment;
    }

    public void setAttachment(byte[] attachment) {
        this.attachment = attachment;
    }

    public String getAttachmentFileType() {
        return attachmentFileType;
    }

    public void setAttachmentFileType(String attachmentFileType) {
        this.attachmentFileType = attachmentFileType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NfAttachment)) return false;
        NfAttachment that = (NfAttachment) o;
        return Objects.equals(attachmentId, that.attachmentId) &&
                Objects.equals(attachmentFileName, that.attachmentFileName) &&
                Objects.equals(attachmentFileType, that.attachmentFileType);
    }

    @Override
    public int hashCode() {

        return Objects.hash(attachmentId, attachmentFileName, attachmentFileType);
    }
}
