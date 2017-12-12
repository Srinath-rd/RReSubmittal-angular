package com.dnr.brrts.web.model;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "SW_RRESUBM_FACILITY")
public class NfFacility {

    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "facid_generator")
//    @SequenceGenerator(name = "facid_generator", sequenceName = "sw_eform_facilityid_seq", allocationSize = 1)
    @GeneratedValue
    private Long facilityId;
    private String facilityName;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "facility", cascade = CascadeType.ALL)
    private List<NfReport> nfReportList;

    public NfFacility() {
        super();
    }

    public Long getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(Long facilityId) {
        this.facilityId = facilityId;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }
}
