package com.dnr.brrts.web.dto;

import com.dnr.brrts.web.model.*;

import java.time.LocalDateTime;
import java.util.Set;

public class NfReportDTO {


    private Long reportId;

    private String reportType;


    private NfFacility facility;

    private NfApplicationForm form;


    private NfUser user;

    private Set<NfReportPerson> reportPersons;

    private Set<NfSubstance> substances;

    private Set<NfImpact> impacts;

    private Set<NfAttachment> attachments;

    private Set<NfSource> sources;

    private Set<NfCause> causes;

    private FormStatus status;

    private String releaseFrom;

    private LocalDateTime notifiedDate;

    private boolean attachmentExists;

    public Long getReportId() {
        return reportId;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public NfFacility getFacility() {
        return facility;
    }

    public void setFacility(NfFacility facility) {
        this.facility = facility;
    }

    public NfApplicationForm getForm() {
        return form;
    }

    public void setForm(NfApplicationForm form) {
        this.form = form;
    }

    public NfUser getUser() {
        return user;
    }

    public void setUser(NfUser user) {
        this.user = user;
    }

    public Set<NfReportPerson> getReportPersons() {
        return reportPersons;
    }

    public void setReportPersons(Set<NfReportPerson> reportPersons) {
        this.reportPersons = reportPersons;
    }

    public Set<NfSubstance> getSubstances() {
        return substances;
    }

    public void setSubstances(Set<NfSubstance> substances) {
        this.substances = substances;
    }

    public Set<NfImpact> getImpacts() {
        return impacts;
    }

    public void setImpacts(Set<NfImpact> impacts) {
        this.impacts = impacts;
    }

    public Set<NfAttachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(Set<NfAttachment> attachments) {
        this.attachments = attachments;
    }

    public Set<NfSource> getSources() {
        return sources;
    }

    public void setSources(Set<NfSource> sources) {
        this.sources = sources;
    }

    public Set<NfCause> getCauses() {
        return causes;
    }

    public void setCauses(Set<NfCause> causes) {
        this.causes = causes;
    }

    public FormStatus getStatus() {
        return status;
    }

    public void setStatus(FormStatus status) {
        this.status = status;
    }

    public String getReleaseFrom() {
        return releaseFrom;
    }

    public void setReleaseFrom(String releaseFrom) {
        this.releaseFrom = releaseFrom;
    }

    public LocalDateTime getNotifiedDate() {
        return notifiedDate;
    }

    public void setNotifiedDate(LocalDateTime notifiedDate) {
        this.notifiedDate = notifiedDate;
    }

    public boolean isAttachmentExists() {
        return attachmentExists;
    }

    public void setAttachmentExists(boolean attachmentExists) {
        this.attachmentExists = attachmentExists;
    }
}
