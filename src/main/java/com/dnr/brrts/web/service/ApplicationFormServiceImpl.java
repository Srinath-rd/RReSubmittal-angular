package com.dnr.brrts.web.service;

import com.dnr.brrts.web.model.ApplicationForm;
import com.dnr.brrts.web.repository.ApplicationFormRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ApplicationFormServiceImpl implements ApplicationFormService {

    @Autowired
    ApplicationFormRepository formRepository;

    @Override
    public List<ApplicationForm> getApplicationFormTypes() {
        return null;
    }
}
