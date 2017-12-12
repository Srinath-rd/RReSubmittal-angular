package com.dnr.brrts.web.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "SW_RRESUBM_ADDRESS")
public class NfAddress {
    @Id
    @GeneratedValue
    private Long addressId;
    private String address1;
    private String address2;
    private String city;
    private String county;
    private String municipality;
    private Double wtmX;
    private Double wtmY;
    private Double latitude;
    private Double longitude;
    private Long zipcode;
    private String state;
    private Long phoneNumber;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

   @ManyToMany(mappedBy = "addresses")
   private List<NfPerson> personList;

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

    public List<NfPerson> getPersonList() {
        return personList;
    }

    public void setPersonList(List<NfPerson> personList) {
        this.personList = personList;
    }
}
