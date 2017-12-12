package com.dnr.brrts.web.controller;

import com.dnr.brrts.web.model.NfReport;
import com.dnr.brrts.web.service.NfReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/*
 Report Controller provides an api to save the notification form data to the database.

 */
@RestController
@RequestMapping("/nfform")
public class NfReportController {

    @Autowired
    @Qualifier("NfReportServiceImpl")
    private NfReportService nfReportService;

    @PostMapping("/save")
    public NfReport saveNfReport(NfReport report) {
        return nfReportService.saveNfReport(report);


    }
}
