package com.dnr.brrts.web.model;

import javax.persistence.AttributeConverter;

import static com.dnr.brrts.web.model.FormStatus.COMPLETED;
import static com.dnr.brrts.web.model.FormStatus.PENDING;
import static com.dnr.brrts.web.model.FormStatus.SUBMITTED;


public class FormStatusEnumConverter implements AttributeConverter<FormStatus, String> {


    @Override
    public String convertToDatabaseColumn(FormStatus formStatus) {
        switch (formStatus) {
            case PENDING:
                return "PENDING";
            case COMPLETED:
                return "COMPLETED";
            case SUBMITTED:
                return "SUBMITTED";
            default:
                throw new IllegalArgumentException("Unknown " + formStatus);
        }
    }

    @Override
    public FormStatus convertToEntityAttribute(String dbData) {
        switch (dbData) {
            case "PENDING":
                return PENDING;
            case "COMPLETED":
                return COMPLETED;
            case "SUBMITTED":
                return SUBMITTED;
            default:
                throw new IllegalArgumentException("Unknown " + dbData);
        }
    }
}
