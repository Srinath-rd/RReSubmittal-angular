package com.dnr.brrts.web.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "SW_RRESUBM_SUBSTANCE")
public class NfSubstance extends Auditable {


    @Id
    //  @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nfsubstanceid_generator")
    @SequenceGenerator(name = "nfsubstanceid_generator", sequenceName = "sw_rresubm_substanceid_seq", allocationSize = 1)
    private Long substanceId;

    private String substanceName;


    public NfSubstance() {
    }

    public NfSubstance(String substanceName) {
        this.substanceName = substanceName;

    }

    public Long getSubstanceId() {
        return substanceId;
    }

    public void setSubstanceId(Long substanceId) {
        this.substanceId = substanceId;
    }

    public String getSubstanceName() {
        return substanceName;
    }

    public void setSubstanceName(String substanceName) {
        this.substanceName = substanceName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NfSubstance)) return false;
        NfSubstance substance = (NfSubstance) o;
        return Objects.equals(substanceId, substance.substanceId) &&
                Objects.equals(substanceName, substance.substanceName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(substanceId, substanceName);
    }
}

