package com.dnr.brrts.web.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "SW_RRESUBM_PERSON")
public class NfPerson  extends Auditable{
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nfpersonid_generator")
    @SequenceGenerator(name = "nfpersonid_generator", sequenceName = "sw_rresubm_personid_seq", allocationSize = 1)
    private Long personId;
    private String companyName;
    private String firstName;
    private String lastName;
    private String email;
    private Long phoneNumber;
    //private LocalDateTime createdDate;
    //private LocalDateTime updatedDate;

    @JsonIgnore
    @OneToMany(mappedBy = "person")
    private Set<NfReportPerson> reportPersons = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name="SW_RRESUBM_PER_ADDR_LNK", joinColumns = {@JoinColumn(name="PERSON_ID")},
                                         inverseJoinColumns = {@JoinColumn(name = "ADDRESS_ID")})
    private Set<NfAddress> addresses;

    public NfPerson() {
        super();
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


//    public Set<NfReportPerson> getReportPersons() {
//        return reportPersons;
//    }
//
//    public void setReportPersons(Set<NfReportPerson> reportPersons) {
//        this.reportPersons = reportPersons;
//    }

    public Set<NfReportPerson> getReportPersons() {
        return reportPersons;
    }

    public void setReportPersons(Set<NfReportPerson> reportPersons) {
        this.reportPersons = reportPersons;
    }

    public Set<NfAddress> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<NfAddress> addresses) {
        this.addresses = addresses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NfPerson)) return false;
        NfPerson nfPerson = (NfPerson) o;
        return Objects.equals(personId, nfPerson.personId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(personId);
    }
}
