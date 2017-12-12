package com.dnr.brrts.web.repository;

import com.dnr.brrts.web.model.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class NfReportRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private NfReportRepository reportRepository;

    @Test
    public void testSave() throws Exception {
        NfFacility facility = new NfFacility();
        facility.setFacilityName("MY_FACILITY");
        NfPerson person = new NfPerson();
        person.setFirstName("Rob");
        person.setLastName("Moses");
        ApplicationForm form = new ApplicationForm();
        User user = new User();
        this.entityManager.persist(new NfReport( LocalDateTime.now(), "Test", LocalDateTime.now(), facility, person, form, user));
        NfReport report = this.reportRepository.findByReportId(1L);
        assertNotNull(report.getReportId());
        System.out.println(report.getReportId());
        assertTrue(report.getFacility().getFacilityName().equals("MY_FACILITY"));
        assertTrue(report.getReportedBy().getFirstName().equals("Rob"));
        assertTrue(report.getReportedBy().getLastName().equals("Moses"));
    }



}