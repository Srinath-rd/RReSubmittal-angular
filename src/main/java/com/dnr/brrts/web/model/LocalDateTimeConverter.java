package com.dnr.brrts.web.model;


import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

@Converter(autoApply = true)
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, Date> {
    @Override
    public Date convertToDatabaseColumn(LocalDateTime localDateTime) {

        Timestamp timestamp  =  Optional.ofNullable(localDateTime)
                .map(Timestamp::valueOf)
                .orElse(null);
        return new Date(timestamp.getTime());
    }
    @Override
    public LocalDateTime convertToEntityAttribute(Date date) {
        return Optional.ofNullable(date)
                .map(newDate -> LocalDateTime.ofInstant(newDate.toInstant(), ZoneId.systemDefault()))
                .orElse(null);
    }
}