package com.dnr.brrts.web.service;

import com.dnr.brrts.web.model.*;
import com.dnr.brrts.web.repository.NfReportRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.AutoConfigurationReportEndpoint;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
public class NfReportServiceImplTest {

    @TestConfiguration
    static class NfReportServiceImplTestConfiguration {
        @Bean
        public NfReportService nfRReportService(){
            return  new NfReportServiceImpl();
        }
    }
    @Autowired
    private NfReportService reportService;

    @MockBean
    private NfReportRepository reportRepository;

    @Before
    public void setup(){
        //Test 1

        NfReport report = ReportTestFactory.createTestReport();
        Mockito.when(reportRepository.save(report))
                .thenReturn(report);
    }



    @Test
    public void saveNfReport() {
        NfReport report = new NfReport();
        report.setReportId(1L);
        NfFacility facility = new NfFacility();
        report.setFacility(facility);
        NfPerson person = new NfPerson();
     //   report.setReportedBy(person);
        report.setCreatedDate(LocalDateTime.now());
        report.setReportType("Test");

        NfReport returnedValue = reportRepository.save(report);
        assertThat(report.getReportType()).isEqualTo("Test");
        assertThat(report.getReportId()).isEqualTo(1L);

    }
}