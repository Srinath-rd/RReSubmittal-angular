package com.dnr.brrts.web.repository;

import com.dnr.brrts.web.model.NfFacility;
import com.dnr.brrts.web.model.NfReport;
import org.springframework.data.repository.CrudRepository;

public interface NfReportRepository extends CrudRepository<NfReport, Long> {


    NfReport findByReportId(Long reportId);

    @Override
    NfReport save(NfReport report);
}
