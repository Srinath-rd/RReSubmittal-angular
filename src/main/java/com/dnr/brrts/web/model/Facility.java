package com.dnr.brrts.web.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "SW_FAC_ACT_DETAIL")
public class Facility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long detailSeqNo;
    private String activityDetailName;
    private String actCode;

    public Long getDetailSeqNo() {
        return detailSeqNo;
    }

    public void setDetailSeqNo(Long detailSeqNo) {
        this.detailSeqNo = detailSeqNo;
    }

    public String getActCode() {
        return actCode;
    }

    public void setActCode(String actCode) {
        this.actCode = actCode;
    }

    public String getActivityDetailName() {
        return activityDetailName;
    }

    public void setActivityDetailName(String activityDetailName) {
        this.activityDetailName = activityDetailName;
    }


}
