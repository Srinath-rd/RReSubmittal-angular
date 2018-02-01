package com.dnr.brrts.web.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "SW_RRESUBM_REP_PER_LINK")
@IdClass(ReportPersonId.class)
public class NfReportPerson  implements Serializable{

//    @Embeddable
//    public static class ReportPersonId implements Serializable
//    {
//        @Column(name = "report_id")
//        private Long reportId;
//
//        @Column(name = "person_id")
//        private Long personId;
//
//        public ReportPersonId(Long reportId, Long personId) {
//            this.reportId = reportId;
//            this.personId = personId;
//        }
//
//        public ReportPersonId() {
//
//        }
//
//        public Long getReportId() {
//            return reportId;
//        }
//
//        public Long getPersonId() {
//            return personId;
//        }
//
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (!(o instanceof ReportPersonId)) return false;
//            ReportPersonId that = (ReportPersonId) o;
//            return Objects.equals(reportId, that.reportId) &&
//                    Objects.equals(personId, that.personId);
//        }
//
//        @Override
//        public int hashCode() {
//
//            return Objects.hash(reportId, personId);
//        }
//    }

//    @EmbeddedId
//    private ReportPersonId reportPersonId = new ReportPersonId();

    @JsonIgnore
    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "report_id")
    private NfReport report;

    @Id
    @ManyToOne(cascade =  CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private NfPerson person;

    private String personType;

    public NfReportPerson() {
    }

    public NfReportPerson(NfReport report, NfPerson person, String personType) {
        this.report = report;
        this.person = person;
        this.personType = personType;
//        this.reportPersonId.reportId = report.getReportId();
//        this.reportPersonId.personId = person.getPersonId();
//        report.getReportPersons().add(this);
//        person.getReportPersons().add(this);
    }

    public NfReport getReport() {
        return report;
    }

    public void setReport(NfReport report) {
        this.report = report;
    }

    public NfPerson getPerson() {
        return person;
    }

    public void setPerson(NfPerson person) {
        this.person = person;
    }

    public String getPersonType() {
        return personType;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }


}
