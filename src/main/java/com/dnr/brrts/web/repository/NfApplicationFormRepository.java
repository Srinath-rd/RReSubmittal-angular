package com.dnr.brrts.web.repository;

import com.dnr.brrts.web.model.NfApplicationForm;
import com.dnr.brrts.web.model.FormName;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NfApplicationFormRepository extends CrudRepository<NfApplicationForm, Long> {


    NfApplicationForm findByFormId(Long formId);

    NfApplicationForm findByFormName(FormName formName);

    @Override
    NfApplicationForm save(NfApplicationForm form);

    @Override
    List<NfApplicationForm> findAll();
}
