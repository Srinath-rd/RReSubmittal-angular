package com.dnr.brrts.web.model;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "SW_RRESUBM_IMPACT")
public class NfImpact extends Auditable{

    @Id
    //  @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nfimpactid_generator")
    @SequenceGenerator(name = "nfimpactid_generator", sequenceName = "sw_rresubm_impactid_seq", allocationSize = 1)
    private Long impactId;

    private String impactName;



    public NfImpact(String impactName) {
        this.impactName = impactName;
    }

    public NfImpact() {
    }

    public Long getImpactId() {
        return impactId;
    }

    public void setImpactId(Long impactId) {
        this.impactId = impactId;
    }

    public String getImpactName() {
        return impactName;
    }

    public void setImpactName(String impactName) {
        this.impactName = impactName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NfImpact)) return false;
        NfImpact nfImpact = (NfImpact) o;
        return Objects.equals(impactId, nfImpact.impactId) &&
                Objects.equals(impactName, nfImpact.impactName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(impactId, impactName);
    }
}
