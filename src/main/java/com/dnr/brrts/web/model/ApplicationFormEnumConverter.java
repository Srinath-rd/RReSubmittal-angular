package com.dnr.brrts.web.model;

import javax.persistence.AttributeConverter;

import static com.dnr.brrts.web.model.FormName.CLOSURE_FORM;
import static com.dnr.brrts.web.model.FormName.NOTIFICATION_FORM;
import static com.dnr.brrts.web.model.FormName.TECHNICAL_ASSISTANCE_FORM;

public class ApplicationFormEnumConverter implements AttributeConverter<FormName, String> {


    @Override
    public String convertToDatabaseColumn(FormName formName) {
        switch (formName) {
            case NOTIFICATION_FORM:
                return "NOTIFICATION FORM";
            case CLOSURE_FORM:
                return "CLOSURE FOR<";
            case TECHNICAL_ASSISTANCE_FORM:
                return "TECHNICAL ASSISTANCE FORM";
            default:
                throw new IllegalArgumentException("Unknown " + formName);
        }
    }

    @Override
    public FormName convertToEntityAttribute(String dbData) {
        switch (dbData) {
            case "NOTIFICATION FORM":
                return NOTIFICATION_FORM;
            case "TECHNICAL ASSISTANCE FORM":
                return TECHNICAL_ASSISTANCE_FORM;
            case "CLOSURE FORM":
                return CLOSURE_FORM;
            default:
                throw new IllegalArgumentException("Unknown " + dbData);
        }
    }
}
