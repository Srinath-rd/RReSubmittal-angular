package com.dnr.brrts.web.model;

import javax.persistence.*;

@Entity
@Table(name="SW_RRESUBM_APPLICATIONFORM")
public class ApplicationForm {

    @Id
    @GeneratedValue
    private String formId;
    private String type;

    @Enumerated(EnumType.STRING)
    private FormName FormName;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "form")
//   // private NfReport report;

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ApplicationForm(String type, com.dnr.brrts.web.model.FormName formName) {
        this.type = type;
        FormName = formName;
    }

    public ApplicationForm() {
    }

    public FormName getFormName() {
        return FormName;
    }

    public void setFormName(FormName formName) {
        FormName = formName;
    }

}
