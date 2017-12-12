package com.dnr.brrts.web.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "SW_RRESUBM_PERSON")
public class NfPerson {
    @Id
    @GeneratedValue
    private Long personId;
    private String companyName;
    private String firstName;
    private String lastName;
    private String email;
    private Long phoneNumber;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reported_by")
    private NfReport report;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name="SW_PERSON_ADDRESS_LNK", joinColumns = {@JoinColumn(name="PERSON_ID")},
                                         inverseJoinColumns = {@JoinColumn(name = "ADDRESS_ID")})
    private List<NfAddress> addresses;

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

    public NfReport getReport() {
        return report;
    }

    public void setReport(NfReport report) {
        this.report = report;
    }

    public List<NfAddress> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<NfAddress> addresses) {
        this.addresses = addresses;
    }
}
