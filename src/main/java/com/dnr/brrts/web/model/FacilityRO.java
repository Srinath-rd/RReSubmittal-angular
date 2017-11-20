package com.dnr.brrts.web.model;

public class FacilityRO {

    private String BrrtsNumber;
    private String facilityName;
    private Address address;

    public String getBrrtsNumber() {
        return BrrtsNumber;
    }

    public void setBrrtsNumber(String brrtsNumber) {
        BrrtsNumber = brrtsNumber;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
