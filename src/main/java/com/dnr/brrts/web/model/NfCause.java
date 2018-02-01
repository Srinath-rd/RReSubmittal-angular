package com.dnr.brrts.web.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name= "SW_RRESUBM_CAUSE")
public class NfCause extends  Auditable{

    @Id
    //  @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nfcauseid_generator")
    @SequenceGenerator(name = "nfcauseid_generator", sequenceName = "sw_rresubm_causeid_seq", allocationSize = 1)
    private Long causeId;

    private String causeName;


    public NfCause(String causeName) {
        this.causeName = causeName;
    }

    public NfCause() {
    }

    public Long getCauseId() {
        return causeId;
    }

    public void setCauseId(Long causeId) {
        this.causeId = causeId;
    }

    public String getCauseName() {
        return causeName;
    }

    public void setCauseName(String causeName) {
        this.causeName = causeName;
    }


}
