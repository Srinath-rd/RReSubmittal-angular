package com.dnr.brrts.web.controller;

import com.dnr.brrts.web.model.NfFacility;
import com.dnr.brrts.web.model.NfPerson;
import com.dnr.brrts.web.model.NfReport;
import com.dnr.brrts.web.service.NfReportService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@WebMvcTest(NfReportController.class)
public class NfReportControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private NfReportService reportService;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testSaveNfReport() throws Exception {
        NfReport report = new NfReport();
        report.setReportId(1L);
        NfFacility facility = new NfFacility();
        report.setFacility(facility);
        NfPerson person = new NfPerson();
        report.setReportedBy(person);
        report.setCreatedDate(LocalDateTime.now());
        report.setReportType("Test");

        given(reportService.saveNfReport(report)).willReturn(report);


    }
}