package com.dnr.brrts.web.service;

import com.dnr.brrts.web.model.NfApplicationForm;
import com.dnr.brrts.web.repository.NfApplicationFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationFormServiceImpl implements ApplicationFormService {

    @Autowired
    NfApplicationFormRepository formRepository;

    @Override
    public List<NfApplicationForm> getApplicationFormTypes() {
        return formRepository.findAll();
    }
}
