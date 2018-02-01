package com.dnr.brrts.web.model;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "SW_RRESUBM_REPORT")
public class NfReport extends Auditable {

    @Id
  //  @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nfreportid_generator")
    @SequenceGenerator(name = "nfreportid_generator", sequenceName = "sw_rresubm_reportid_seq", allocationSize = 1)
    private Long reportId;
//    private LocalDateTime updatedDate;
    private String reportType;
  //  private LocalDateTime createdDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FACILITY_ID")
    private NfFacility facility;

//    @OneToOne(mappedBy = "report", cascade = CascadeType.ALL)
//    private Set<NfPerson> persons;


    @ManyToOne
    @JoinColumn(name = "FORM_ID")
    private NfApplicationForm form;

//    @OneToOne(mappedBy = "report", cascade = CascadeType.ALL)
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private NfUser user;

    @OneToMany(mappedBy = "report", cascade = CascadeType.ALL)
    private Set<NfReportPerson> reportPersons;





   // private List<NfPerson> responsibleParties;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "SW_RRESUBM_REPORT_SUB_LINK" ,  joinColumns = {@JoinColumn(name = "REPORT_ID")}, inverseJoinColumns = {@JoinColumn(name = "SUBSTANCE_ID")})
    private Set<NfSubstance> substances = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "SW_RRESUBM_REPORT_IMP_LINK" ,  joinColumns = {@JoinColumn(name = "REPORT_ID")}, inverseJoinColumns = {@JoinColumn(name = "IMPACT_ID")})
    private Set<NfImpact> impacts = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "SW_RRESUBM_REPORT_ATTMNT_LNK" ,  joinColumns = {@JoinColumn(name = "REPORT_ID")}, inverseJoinColumns = {@JoinColumn(name = "ATTACHMENT_ID")})
    private Set<NfAttachment> attachments = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "SW_RRESUBM_REPORT_SOURCE_LINK" ,  joinColumns = {@JoinColumn(name = "REPORT_ID")}, inverseJoinColumns = {@JoinColumn(name = "SOURCE_ID")})
    private Set<NfSource> sources = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "SW_RRESUBM_REPORT_CAUSE_LINK" ,  joinColumns = {@JoinColumn(name = "REPORT_ID")}, inverseJoinColumns = {@JoinColumn(name = "CAUSE_ID")})
    private Set<NfCause> causes = new HashSet<>();

    @Convert(converter = FormStatusEnumConverter.class)
    private FormStatus status;

    private String releaseFrom;

    private LocalDateTime notifiedDate;

    @Column(name = "ISATTACHMENT")
    private boolean attachmentExists;


    private String confirmationNumber;

    public NfReport() {

    }

    public NfReport( String reportType,  NfFacility facility, NfApplicationForm form, NfUser user, String releaseFrom,
                     Set<NfReportPerson> reportPersons, Set<NfSubstance> substances) {
        this.reportType = reportType;
        this.facility = facility;
        this.reportPersons = reportPersons;
        this.form = form;
        this.user = user;
        this.releaseFrom = releaseFrom;
        this.substances = substances;
    }


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

    public Set<NfReportPerson> getReportPersons() {
        return reportPersons;
    }

    public void setReportPersons(Set<NfReportPerson> reportPersons) {
        this.reportPersons = reportPersons;
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

    public String getConfirmationNumber() {
        return confirmationNumber;
    }

    public void setConfirmationNumber(String confirmationNumber) {
        this.confirmationNumber = confirmationNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NfReport)) return false;
        NfReport report = (NfReport) o;
        return Objects.equals(reportId, report.reportId);
    }

    public void addPerson(NfPerson person, String personType){
        NfReportPerson reportPerson = new NfReportPerson(this, person, personType);
        reportPersons.add(reportPerson);
        person.getReportPersons().add(reportPerson);
    }

    public void removePerson(NfPerson person){
        for (Iterator<NfReportPerson> iterator = reportPersons.iterator();
             iterator.hasNext(); ) {
            NfReportPerson reportPerson = iterator.next();

            if (reportPerson.getReport().equals(this) &&
                    reportPerson.getPerson().equals(person)) {
                iterator.remove();
                reportPerson.getPerson().getReportPersons().remove(reportPerson);

                reportPerson.setPerson(null);
                reportPerson.setReport(null);
            }
        }
    }

    @Override
    public int hashCode() {

        return Objects.hash(reportId);
    }
}
