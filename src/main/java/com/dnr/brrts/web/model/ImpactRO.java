package com.dnr.brrts.web.model;

public class ImpactRO {

    private String impactCode;
    private String impactDescription;
    private String applicableRisk;

    public String getImpactCode() {
        return impactCode;
    }

    public void setImpactCode(String impactCode) {
        this.impactCode = impactCode;
    }

    public String getImpactDescription() {
        return impactDescription;
    }

    public void setImpactDescription(String impactDescription) {
        this.impactDescription = impactDescription;
    }

    public String getApplicableRisk() {
        return applicableRisk;
    }

    public void setApplicableRisk(String applicableRisk) {
        this.applicableRisk = applicableRisk;
    }

}
