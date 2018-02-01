package com.dnr.brrts.web.repository;
import com.dnr.brrts.web.model.FormStatus;
import com.dnr.brrts.web.model.NfReport;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NfReportRepository extends CrudRepository<NfReport, Long> {


    NfReport findByReportId(Long reportId);

    @Override
    NfReport save(NfReport report);

    @Override
    List<NfReport> findAll();


    List<NfReport> findByUser_UserId(Long userId);

    List<NfReport> findByUser_UserIdAndStatus(Long userId, FormStatus formstatus);

    @Override
    void delete(Long reportId);

}
