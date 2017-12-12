package com.dnr.brrts.web.service;

import com.dnr.brrts.web.model.NfReport;
import com.dnr.brrts.web.repository.NfReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("NfReportServiceImpl")
public class NfReportServiceImpl implements NfReportService {

    @Autowired
    NfReportRepository reportRepository;

    @Override
    public NfReport saveNfReport(NfReport report) {
        return reportRepository.save(report);
    }
}
