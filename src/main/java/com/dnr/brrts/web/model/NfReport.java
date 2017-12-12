package com.dnr.brrts.web.model;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "SW_RRESUBM_REPORT")
public class NfReport {

    @Id
    @GeneratedValue
    private Long reportId;
    private LocalDateTime updatedDate;
    private String reportType;
    private LocalDateTime createdDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "facility_id")
    private NfFacility facility;

    @OneToOne(mappedBy = "report", cascade = CascadeType.ALL)
    private NfPerson reportedBy;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "formId")
    private ApplicationForm form;

//    @OneToOne(mappedBy = "report", cascade = CascadeType.ALL)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private User user;

    private String status;


    public NfReport() {
    }

    public NfReport(LocalDateTime updatedDate, String reportType, LocalDateTime createdDate, NfFacility facility, NfPerson reportedBy, ApplicationForm form, User user) {
        this.updatedDate = updatedDate;
        this.reportType = reportType;
        this.createdDate = createdDate;
        this.facility = facility;
        this.reportedBy = reportedBy;
        this.form = form;
        this.user = user;
    }


    public Long getReportId() {
        return reportId;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }


    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public NfFacility getFacility() {
        return facility;
    }

    public void setFacility(NfFacility facility) {
        this.facility = facility;
    }

    public NfPerson getReportedBy() {
        return reportedBy;
    }

    public void setReportedBy(NfPerson reportedBy) {
        this.reportedBy = reportedBy;
    }

    public ApplicationForm getForm() {
        return form;
    }

    public void setForm(ApplicationForm form) {
        this.form = form;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
