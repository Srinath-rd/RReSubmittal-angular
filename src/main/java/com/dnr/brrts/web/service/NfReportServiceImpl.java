package com.dnr.brrts.web.service;

import com.dnr.brrts.web.model.*;
import com.dnr.brrts.web.repository.*;
import org.apache.commons.codec.digest.DigestUtils;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Qualifier("NfReportServiceImpl")
public class NfReportServiceImpl implements NfReportService {

    private static final Logger logger = LoggerFactory.getLogger(NfReportServiceImpl.class);
    @Autowired
    NfReportRepository reportRepository;

    @Autowired
    NfPersonRepository personRepository;

    @Autowired
    NfApplicationFormRepository formRepository;

    @Autowired
    NfUserRepository userRepository;

    @Autowired
    NFReportPersonRepository reportPersonRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    NfAddressRepository addressRepository;

    @Autowired
    NfFacilityRepository facilityRepository;

    @Autowired
    NfAttachmentRepository attachmentRepository;

    @Autowired
    GISService gisService;

    /**
     * Saves notification form details to the database
     *
     * @param report
     * @param formComplete
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public NfReport saveNfReport(NfReport report, boolean formComplete) {
        logger.info("Inside saveNFReport.....");

        //setting status to pending
        report.setStatus(FormStatus.PENDING);

        //initializing values for some of elements for save feature.
        report.setReleaseFrom("test");
        report.setNotifiedDate(LocalDateTime.now());


        if (report.getAttachments() != null && !report.getAttachments().isEmpty())
            report.setAttachmentExists(true);
        else
            report.setAttachmentExists(false);

        //saving Notification details part of the form
        if (report.getForm() == null) {
            NfApplicationForm form = formRepository.findByFormName(FormName.NOTIFICATION_FORM);
            report.setForm(form);
        } else {
            NfApplicationForm form = report.getForm();
            form.setFormId(1L);
            report.setForm(form);
        }

        if (formComplete) {
            String confirmationId = createUniqueConfirmationNumber();
            report.setConfirmationNumber(confirmationId);
            report.setStatus(FormStatus.SUBMITTED);
        }

        //saving new application
        report = updateNfReportPersons(report);

        // saving site information to the database. //mapping many to one relationship side of address to facility
        report = saveNfFacilities(report);

        return reportRepository.save(report);

    }

    private NfReport saveNfFacilities(NfReport report) {
        if (report.getFacility() != null && report.getFacility().getAddresses() != null) {
            Set<NfAddress> facilityAddresses = report.getFacility().getAddresses().stream().map(
                    address -> {
                        address.setFacility(report.getFacility());
                        return address;
                    }
            ).collect(Collectors.toSet());
            NfFacility facility = report.getFacility();
            facility.setAddresses(facilityAddresses);
            report.setFacility(facility);
        }

        return report;
    }

    @Override
    public List<NfReport> findReportsByUserName(String username) {
        NfUser user = userRepository.findByUsername(username);
        return reportRepository.findByUser_UserId(user.getUserId());
    }

    @Override
    public NfReport buildNewReport(NfUser user, FormName formName) {
        NfReport report = new NfReport();
        NfPerson person = new NfPerson();
        person.setFirstName(user.getFirstName());
        person.setLastName(user.getLastName());
        person.setEmail(user.getEmail());
        personRepository.save(person);


        Set<NfReportPerson> reportPersons = new HashSet<>();
        NfReportPerson reportPerson = new NfReportPerson();
        reportPerson.setReport(report);
        reportPerson.setPerson(person);
        reportPersons.add(reportPerson);
        report.setReportPersons(reportPersons);
        report.setReleaseFrom("NONE");
        report.setStatus(FormStatus.PENDING);
        report.setReportType("NONE");
        report.setAttachmentExists(false);
        report.setNotifiedDate(LocalDateTime.now());
        report.setUser(user);

        report.setForm(formRepository.findByFormName(formName));
        return reportRepository.save(report);
    }

    @Override
    public List<NfReport> findReportsByUserNameAndStatus(String username, FormStatus pending) {
        NfUser user = userRepository.findByUsername(username);
        List<NfReport> result = reportRepository.findByUser_UserIdAndStatus(user.getUserId(), pending);
        return result;
    }

    @Override
    public NfReport findReportByReportId(Long reportId) {

        return reportRepository.findByReportId(reportId);
    }

    @Override
    public void deleteReportById(String reportId) {
        reportRepository.delete(Long.valueOf(reportId));
    }

    @Override
    @Transactional
    public NfReport updateNfFormDetails(NfReport reportInp, boolean formComplete) {
        logger.info("Inside saveNFReport.....");
        NfReport report = null;
        if (reportInp != null) {
            report = reportRepository.findOne(reportInp.getReportId());
            //modelMapper.map(reportInp, report);
        }
        //setting status to pending
        report.setStatus(FormStatus.PENDING);

        //updating releaseFrom information
        report.setAttachmentExists(false);


        report.setReportType(reportInp.getReportType());

        report.getReportPersons().clear();
        report.getReportPersons().addAll(reportInp.getReportPersons());

        report = updateNfReportPersons(report);
        report.setReportPersons(reportInp.getReportPersons());

        if (formComplete) {
            String confirmationId = createUniqueConfirmationNumber();
            report.setConfirmationNumber(confirmationId);
            report.setStatus(FormStatus.SUBMITTED);
        }

        report = updateNfFacilities(reportInp, report);

        //update substances
        report.getSubstances().clear();
        report.getSubstances().addAll(reportInp.getSubstances());

        //update sources
        report.getImpacts().clear();
        report.getImpacts().addAll(reportInp.getImpacts());

        //update sources
        report.getSources().clear();
        report.getSources().addAll(reportInp.getSources());

        //update causes
        report.getCauses().clear();
        report.getCauses().addAll(reportInp.getCauses());

        //update attachments
        // report.getAttachments().clear();
        report.getAttachments().addAll(reportInp.getAttachments());

        return reportRepository.save(report);

    }

    @Override
    public NfReport deleteAttachmentByAttachmentId(Long reportId, Long attachmentId) throws Exception {
        NfReport reportFound = reportRepository.findOne(reportId);
        if(reportFound == null){
            throw new Exception("Not a valid Report Id");
        }else {
            Set<NfAttachment> attachmentsFound = reportFound.getAttachments();
            NfAttachment attachmentFound = attachmentRepository.findOne(attachmentId);
            if(attachmentFound == null){
                throw new Exception("Not a valid attachment ID");
            }
            if(attachmentsFound.contains(attachmentFound)){
                attachmentsFound.remove(attachmentFound);
                reportFound.setAttachments(attachmentsFound);
                reportRepository.save(reportFound);
            }
        }
        return  reportFound;
    }


    @Override
    public Resource loadAsResource(NfAttachment attachment) {

        return  new ByteArrayResource(attachment.getAttachment());
    }

    private NfReport updateNfReportPersons(NfReport report) {

        Set<NfReportPerson> reportPersons = report.getReportPersons().stream().map(
                reportPerson -> {
                    NfPerson personFound = null;
                    if (reportPerson.getPerson().getPersonId() != null) {
                        personFound = personRepository.findOne(reportPerson.getPerson().getPersonId());
                        personFound = updateNfPerson(reportPerson.getPerson(), personFound);
                    } else {
                        personFound = reportPerson.getPerson();

                    }
                    personRepository.save(personFound);
                    reportPerson.setReport(report);
                    personFound.getReportPersons().add(reportPerson);
                    reportPerson.setPerson(personFound);
                    return reportPerson;
                }
        ).collect(Collectors.toSet());
        report.setReportPersons(reportPersons);
        return report;
    }

    private NfPerson updateNfPerson(NfPerson personSrc, NfPerson personFound) {
        personFound.setFirstName(personSrc.getFirstName());
        personFound.setLastName(personSrc.getLastName());
        personFound.setEmail(personSrc.getEmail());
        personFound.setCompanyName(personSrc.getCompanyName());
        NfAddress addressSrc = personSrc.getAddresses().iterator().hasNext() ? personSrc.getAddresses().iterator().next() : null;
        if (addressSrc.getAddressId() != null) {
            NfAddress addressFound = addressRepository.findOne(addressSrc.getAddressId());
            if (addressFound != null)
                updateNfAddress(addressSrc, addressFound);
            else {
                updateNfAddress(addressSrc, new NfAddress());
            }
        }
        return personFound;
    }


    private NfAddress updateNfAddress(NfAddress addressSrc, NfAddress addressFound) {
        addressFound.setAddress1(addressSrc.getAddress1());
        addressFound.setAddress2(addressSrc.getAddress2());
        addressFound.setZipcode(addressSrc.getZipcode());
        addressFound.setCity(addressSrc.getCity());
        addressFound.setState(addressSrc.getState());
        addressFound.setPhoneNumber(addressSrc.getPhoneNumber());
        addressFound.setLongitude(addressSrc.getLongitude());
        addressFound.setLatitude(addressSrc.getLatitude());
        addressFound.setMunicipality(addressSrc.getMunicipality());
        return addressFound;
    }

    private NfReport updateNfFacilities(NfReport reportsource, NfReport reportDest) {
        // saving site information to the database. //mapping many to one relationship side of address to facility
        NfFacility facility = null;
        if (reportsource.getFacility() != null) {

            if (reportsource.getFacility().getFacilityId() != null) {
                facility = facilityRepository.findOne(reportsource.getFacility().getFacilityId());

            } else {
                facility = new NfFacility();
            }
            facility.setFacilityName(reportsource.getFacility().getFacilityName());
            reportDest.setFacility(facility);
            for (NfAddress address : reportsource.getFacility().getAddresses()) {
                NfAddress addressFound = null;
                if (address.getAddressId() != null) {
                    addressFound = addressRepository.findOne(address.getAddressId());
                } else {
                    addressFound = new NfAddress();
                }
                addressFound = updateNfAddress(address, addressFound);
                facility.addAddress(addressFound);
            }
        }
        reportDest.setFacility(facility);
        return reportDest;
    }

    private String createUniqueConfirmationNumber() {
        String currentTimeMillis = String.valueOf(System.currentTimeMillis());
        UUID randomUUID = UUID.randomUUID();

        String uuid = randomUUID.toString();

        return DigestUtils.sha1Hex(currentTimeMillis + uuid);
    }




}
