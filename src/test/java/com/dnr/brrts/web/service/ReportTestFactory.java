package com.dnr.brrts.web.service;

import com.dnr.brrts.web.model.*;

import java.io.*;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReportTestFactory {

    public static  NfReport createTestReport() {
        NfReport report = new NfReport();
        report.setReportId(1L);
      //  report.setCreatedDate(LocalDateTime.now());
        report.setReportType("Test");
     //   report.setUpdatedDate(LocalDateTime.now());

        //Setting up personal Details



      //  report.setReportedBy(person);



        NfApplicationForm form = new NfApplicationForm();
        form.setFormName(FormName.NOTIFICATION_FORM);
        form.setType("Form");
        report.setForm(form);

        NfUser user = new NfUser();
       // user.setUserId("Joey123");
        user.setFirstName("Joe");
        user.setLastName("Rogers");
        report.setUser(user);

        report.setReleaseFrom("Underground Petroleum Storage Tank System.");

        //Setting up facility Details
        NfFacility facility = new NfFacility();
        facility.setFacilityName("Test Site");
        facility.setCreatedDate(LocalDateTime.now());
        facility.setUpdatedDate(LocalDateTime.now());
        NfAddress facilityAddress = new NfAddress();
        facilityAddress.setAddress1("Nowhere land");
        facilityAddress.setAddress2("apt 13");
        facilityAddress.setCity("Middelton");
        facilityAddress.setState("WI");
        facilityAddress.setZipcode(53412L);
        facilityAddress.setCounty("Dane");
        facilityAddress.setMunicipality("Nowhereland");
        facilityAddress.setLatitude(50.12);
        facilityAddress.setLongitude(34.12);
        facilityAddress.setPhoneNumber(6081231234L);

        report.setFacility(facility);




        //Adding Substance information
        Set<NfSubstance> substances = new HashSet<>();
        NfSubstance substance = new NfSubstance();
        substance.setSubstanceName("TestSubstance");
        substance.setCreatedDate(LocalDateTime.now());
        substance.setUpdatedDate(LocalDateTime.now());

        substances.add(substance);
        report.setSubstances(substances);


        //Adding Impacts information
        Set<NfImpact> impactList = new HashSet<>();
        NfImpact impact = new NfImpact();
        impact.setImpactName("TestImpact");
        impact.setCreatedDate(LocalDateTime.now());
        impact.setUpdatedDate(LocalDateTime.now());
        impactList.add(impact);
        report.setImpacts(impactList);

        //Adding Attachment Information
//        Set<NfAttachment> attachments = new HashSet<>();
//        NfAttachment attachment = new NfAttachment();
//        byte[] bytesArray = new byte[0];
//        File file = null;
//        try {
//            FileInputStream is = new FileInputStream("C:\\Users\\pullas\\workspace\\RREsubmittalApp\\src\\test\\resources\\testUpload.txt");
//            file = new File("C:\\Users\\pullas\\workspace\\RREsubmittalApp\\src\\test\\resources\\testUpload.txt");
//           bytesArray = new byte[is.available()];
//            is.read(bytesArray);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        attachment.setAttachmentFileName(file.getName());
//        attachment.setAttachmentFileType(file.getName().substring(file.getName().indexOf('.')));
//        attachment.setAttachment(bytesArray);
//        attachments.add(attachment);
//        report.setAttachments(attachments);


        //adding source information
        Set<NfSource> sources = new HashSet<>();
        NfSource source = new NfSource();
        source.setSourceName("TestSource");
        source.setCreatedDate(LocalDateTime.now());
        source.setUpdatedDate(LocalDateTime.now());
        sources.add(source);
        report.setSources(sources);

        //adding cause information
        Set<NfCause> causes = new HashSet<>();
        NfCause cause = new NfCause();
        cause.setCauseName("TestCause");
        cause.setCreatedDate(LocalDateTime.now());
        cause.setUpdatedDate(LocalDateTime.now());
        causes.add(cause);
        report.setCauses(causes);
        return report;
    }
}
