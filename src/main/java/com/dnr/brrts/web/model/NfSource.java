package com.dnr.brrts.web.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "SW_RRESUBM_SOURCE")
public class NfSource extends Auditable{

    @Id
    //  @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nfsourceid_generator")
    @SequenceGenerator(name = "nfsourceid_generator", sequenceName = "sw_rresubm_sourceid_seq", allocationSize = 1)
    private Long sourceId;

    private String sourceName;



    public NfSource() {
    }

    public NfSource(String sourceName) {
        this.sourceName = sourceName;

    }

    public Long getSourceId() {
        return sourceId;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }
}
