package com.dnr.brrts.web.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "SW_RRESUBM_ADDRESS")
public class NfAddress extends Auditable{
    @Id
    //@GeneratedValue
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nfaddressid_generator")
    @SequenceGenerator(name = "nfaddressid_generator", sequenceName = "sw_rresubm_addressid_seq", allocationSize = 1)
    private Long addressId;

    private String address1;
    private String address2;
    private String city;
    private String county;
    private String municipality;
    @Column(name = "wtm_x")
    private Double wtmX;

    @Column(name = "wtm_y")
    private Double wtmY;

    @Column(name = "LAT_X")
    private Double latitude;

    @Column(name ="LONG_Y")
    private Double longitude;
    private Long zipcode;
    private String state;
    private Long phoneNumber;
  //  private LocalDateTime createdDate;
  //  private LocalDateTime updatedDate;

    public NfAddress() {
    }

    @ManyToMany(mappedBy = "addresses")
    @JsonIgnore
   private Set<NfPerson> personList;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "FACILITY_ID")
   @JsonIgnore
   private NfFacility facility;

    public NfAddress(String address1, String address2, String city, String county, String municipality, Double wtmX, Double wtmY, Double latitude, Double longitude, Long zipcode, String state, Long phoneNumber, Set<NfPerson> personList, NfFacility facility) {
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.county = county;
        this.municipality = municipality;
        this.wtmX = wtmX;
        this.wtmY = wtmY;
        this.latitude = latitude;
        this.longitude = longitude;
        this.zipcode = zipcode;
        this.state = state;
        this.phoneNumber = phoneNumber;
        this.personList = personList;
        this.facility = facility;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public Double getWtmX() {
        return wtmX;
    }

    public void setWtmX(Double wtmX) {
        this.wtmX = wtmX;
    }

    public Double getWtmY() {
        return wtmY;
    }

    public void setWtmY(Double wtmY) {
        this.wtmY = wtmY;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Long getZipcode() {
        return zipcode;
    }

    public void setZipcode(Long zipcode) {
        this.zipcode = zipcode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<NfPerson> getPersonList() {
        return personList;
    }

    public void setPersonList(Set<NfPerson> personList) {
        this.personList = personList;
    }

    public NfFacility getFacility() {
        return facility;
    }

    public void setFacility(NfFacility facility) {
        this.facility = facility;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NfAddress)) return false;
        NfAddress address = (NfAddress) o;
        return Objects.equals(addressId, address.addressId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(addressId);
    }
}
