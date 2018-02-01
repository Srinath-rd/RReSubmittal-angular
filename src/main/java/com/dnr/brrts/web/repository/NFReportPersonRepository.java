package com.dnr.brrts.web.repository;

import com.dnr.brrts.web.model.NfPerson;
import com.dnr.brrts.web.model.NfReport;
import com.dnr.brrts.web.model.NfReportPerson;
import org.springframework.data.repository.CrudRepository;

public interface NFReportPersonRepository extends CrudRepository<NfReportPerson, Long> {

    @Override
    NfReportPerson save(NfReportPerson reportPerson);

    NfReportPerson findByReportAndPerson(NfReport report, NfPerson person);
}
