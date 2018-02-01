package com.dnr.brrts.web.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "SW_RRESUBM_FACILITY")
public class NfFacility extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "facid_generator")
   @SequenceGenerator(name = "facid_generator", sequenceName = "sw_rresubm_facilityid_seq", allocationSize = 1)
    private Long facilityId;
    private String facilityName;

//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "facility", cascade = CascadeType.ALL)
//    private Set<NfReport> nfReportList;

    @OneToMany(fetch = FetchType.LAZY ,mappedBy = "facility", cascade = CascadeType.ALL)
    private Set<NfAddress> addresses = new HashSet<>();

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

    public boolean addAddress(NfAddress address){
        address.setFacility(this);
        return this.getAddresses().add(address);
    }


//    public Set<NfReport> getNfReportList() {
//        return nfReportList;
//    }
//
//    public void setNfReportList(Set<NfReport> nfReportList) {
//        this.nfReportList = nfReportList;
//    }

    public Set<NfAddress> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<NfAddress> addresses) {
        this.addresses = addresses;
    }
}
