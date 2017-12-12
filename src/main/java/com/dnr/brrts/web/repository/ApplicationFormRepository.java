package com.dnr.brrts.web.repository;

import com.dnr.brrts.web.model.ApplicationForm;
import com.dnr.brrts.web.model.FormName;
import org.springframework.data.repository.CrudRepository;

public interface ApplicationFormRepository  extends CrudRepository<ApplicationForm, Long> {


    ApplicationForm findByFormId(Long formId);

    ApplicationForm findByFormName(FormName formName);

    @Override
    ApplicationForm save(ApplicationForm form);
}
