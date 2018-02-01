package com.dnr.brrts.web.repository;

import com.dnr.brrts.web.model.*;
import com.dnr.brrts.web.service.ReportTestFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@TestPropertySource("classpath:application-test.properties")
public class NfReportRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private NfReportRepository reportRepository;

    @Autowired
    private NfPersonRepository personRepository;

    @Test
    public void testSave() throws Exception {

        NfApplicationForm form = new NfApplicationForm();
        form.setFormId(1L);
        form.setFormName(FormName.NOTIFICATION_FORM);
        form.setType("Form");
        this.entityManager.persist(form);

        NfApplicationForm form1 = new NfApplicationForm();
        form1.setFormId(2L);
        form.setFormName(FormName.CLOSURE_FORM);
        form.setType("Form");
        this.entityManager.persist(form);

        NfApplicationForm form2 = new NfApplicationForm();
        form2.setFormId(3L);
        form.setFormName(FormName.TECHNICAL_ASSISTANCE_FORM);
        form.setType("Form");
        this.entityManager.persist(form);

        NfReport reportInp = ReportTestFactory.createTestReport();

//        //setting up person
        NfPerson person = new NfPerson();
        person.setFirstName("Joe");
        person.setLastName("Rogers");
        person.setCompanyName("Noone owns it company");
        person.setPhoneNumber(6081231234L);
        person.setEmail("iamnotjoe@gmail.com");

//
        Set<NfAddress> addresses = new HashSet<>();
        NfAddress personalAddress = new NfAddress();
        personalAddress.setAddress1("Jacob Street");
        personalAddress.setAddress2("Apt 113");
        personalAddress.setCity("Middleton");
        personalAddress.setState("WI");
        personalAddress.setZipcode(53546L);

        addresses.add(personalAddress);

        //  person.setAddresses(addresses);


        NfPerson rp1 = new NfPerson();
        rp1.setFirstName("Rob");
        rp1.setLastName("Jr");
        rp1.setCompanyName("CompanyName");
        rp1.setPhoneNumber(6081231234L);
        rp1.setEmail("robjr@gmail.com");
        Set<NfAddress> rp1Addresses = new HashSet<>();
        NfAddress rp1Address = new NfAddress();
        rp1Address.setAddress1("Nowhere street");
        rp1Address.setAddress2("Apt 13");
        rp1Address.setCity("Middleton");
        rp1Address.setState("WI");
        rp1Address.setZipcode(56123L);
        // rp1.setAddresses(rp1Addresses);


        NfReportPerson responsibleParty = new NfReportPerson();
        responsibleParty.setPerson(rp1);
        responsibleParty.setReport(reportInp);
        responsibleParty.setPersonType("responsibleParty");
//
        reportInp.setStatus(FormStatus.PENDING);
        NfReportPerson reportedBy = new NfReportPerson();
        reportedBy.setReport(reportInp);
        reportedBy.setPerson(person);
        reportedBy.setPersonType("reporter");
//
        reportInp.getReportPersons().add(reportedBy);
        reportInp.getReportPersons().add(responsibleParty);
//        reportInp.getReportPersons().add(responsibleParty);

//
        this.personRepository.save(person);
        this.personRepository.save(rp1);
//       this.personRepository.save(rp1);

        //this.entityManager.persist(reportInp);
        this.reportRepository.save(reportInp);
        System.out.println("Size: " + reportInp.getReportPersons().size());
        System.out.println("Id: " + reportInp.getReportId());

        NfReport report1 = this.entityManager.find(NfReport.class, 1L);
        assertNotNull(report1);
        assertEquals(report1.getReportPersons().size(), 2);
        NfReport reportR = this.reportRepository.findByReportId(1L);
        assertNotNull(reportR);
        assertTrue(reportR.getFacility().getFacilityName().equals("Test Site"));

        //check for substances
        assertNotNull(reportR.getSubstances());
        assertTrue(reportR.getSubstances().iterator().next().getSubstanceName().equals("TestSubstance"));

        //check for impacts
        assertNotNull(reportR.getImpacts());
        assertTrue(reportR.getImpacts().iterator().next().getImpactName().equals("TestImpact"));

        //check for source
        assertNotNull(reportR.getSources());
        assertTrue(reportR.getSources().iterator().next().getSourceName().equals("TestSource"));

        //check for cause
        assertNotNull(reportR.getCauses());
        assertTrue(reportR.getCauses().iterator().next().getCauseName().equals("TestCause"));

        assertNotNull(reportR.getCreatedDate() != null);

    }



}