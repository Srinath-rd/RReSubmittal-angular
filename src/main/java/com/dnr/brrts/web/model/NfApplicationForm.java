package com.dnr.brrts.web.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="SW_RRESUBM_APPLICATIONFORM")
public class NfApplicationForm {

    @Id
    //  @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long formId;
    private String type;

    //@Enumerated(EnumType.STRING)
    @Convert(converter = ApplicationFormEnumConverter.class)
    private FormName formName;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "form")
//   // private NfReport report;


    public Long getFormId() {
        return formId;
    }

    public void setFormId(Long formId) {
        this.formId = formId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public NfApplicationForm(String type, com.dnr.brrts.web.model.FormName formName) {
        this.type = type;
        this.formName = formName;
    }

    public NfApplicationForm() {
    }

    public FormName getFormName() {
        return formName;
    }

    public void setFormName(FormName formName) {
        this.formName = formName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NfApplicationForm)) return false;
        NfApplicationForm that = (NfApplicationForm) o;
        return Objects.equals(formId, that.formId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(formId);
    }
}
