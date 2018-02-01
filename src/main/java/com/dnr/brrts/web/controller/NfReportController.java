package com.dnr.brrts.web.controller;

import com.dnr.brrts.web.model.*;
import com.dnr.brrts.web.service.NfAttachmentService;
import com.dnr.brrts.web.service.NfReportService;
import com.dnr.brrts.web.service.NfUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.validator.constraints.NotBlank;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.core.io.Resource;
import javax.validation.Valid;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/*
 Report Controller provides an api to save the notification form data to the database.

 */
@RestController
@RequestMapping("/eforms")
public class NfReportController {

    private static final Logger logger = LoggerFactory.getLogger(NfReportController.class);
    /**
     *
     */
    @Autowired
    @Qualifier("NfReportServiceImpl")
    private NfReportService nfReportService;

    @Autowired
    private NfUserService userService;

    @Autowired
    private NfAttachmentService attachmentService;

    @Autowired
    ModelMapper modelMapper;

    /**
     * Saves the notification form data to the database
     *
     * @param report
     * @return
     */
    @PostMapping(value = "/saveFile")
    public NfReport saveNfReportWithFiles(@RequestPart("json") String report, @RequestPart(value = "file", required = false) @Valid @NotBlank MultipartFile file, MultipartHttpServletRequest request) {
        logger.info("Inside saveNfreport....");
        Iterator<String> itr = request.getFileNames();
        MultipartFile mpf = null;
        Set<NfAttachment> attachments = new HashSet<>();


        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        NfUser user = userService.findUserByEmail(auth.getName());

        if(user == null){
            user = userService.findUserByUsername(auth.getName());
        }
        NfReport reportObject = null;
        if (report != null) {
            try {
                reportObject = new ObjectMapper().readValue(report, NfReport.class);
            } catch (IOException e) {
                logger.error(e.getLocalizedMessage() + ": " + e);
            }
        }

        while (itr.hasNext()) {
            mpf = request.getFile(itr.next());

            if (mpf != null) {
                NfAttachment attachment = new NfAttachment();
                logger.debug("File name is: " + mpf.getOriginalFilename());
                attachment.setAttachmentFileName(mpf.getOriginalFilename().trim());
                attachment.setAttachmentFileType(mpf.getContentType());
                try {
                    attachment.setAttachment(mpf.getBytes());
                } catch (IOException e) {
                    logger.error("Exception:" + e.getMessage() + e);
                }
                attachments.add(attachment);

            }

        }
        reportObject.setUser(user);
        reportObject.setAttachments(attachments);

        if (reportObject.getReportId() == null) {
            return nfReportService.saveNfReport(reportObject, false);
        } else {
            return nfReportService.updateNfFormDetails(reportObject, false);
        }

    }

    @PostMapping(value = "/save")
    public NfReport saveNfReport(@RequestBody NfReport report , @RequestParam(name = "submit" , required = false) boolean formComplete ) {
        logger.info("Inside saveNfreport....");


        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        NfUser user = userService.findUserByEmail(auth.getName());


        report.setUser(user);



        if (report.getReportId() == null) {
            report =  nfReportService.saveNfReport(report, formComplete);
        } else {
            report = nfReportService.updateNfFormDetails(report, formComplete);
        }

        return report;
    }



    @PostMapping(value = "/update/{id}")
    public ResponseEntity<NfReport> updateNfReport(@PathVariable(name = "id") Long id, @RequestBody NfReport report, @RequestParam(name = "submit" , required = false) boolean formComplete ) {
        logger.info("Inside saveNfreport....");


        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        NfUser user = userService.findUserByEmail(auth.getName());

//
////        NfReport report = nfReportService.findReportByReportId(id);
        NfReport result = null;
        if (report != null) {
            report.setUser(user);
            result = nfReportService.updateNfFormDetails(report, formComplete);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);

    }


    @PostMapping(value = "/delete/{reportId}")
    public ResponseEntity<GenericResponse<String>> deleteNotificationForm(@PathVariable(name = "reportId") String reportId ){
        logger.info("*********Inside deleteNotificationForm method");
        logger.debug("reportId:" + reportId);
        if(reportId == null) {
            try {
                throw new Exception("Not a valid report Id");
            } catch (Exception e) {
                logger.error(e.getLocalizedMessage() + e);
            }
        }else {
            nfReportService.deleteReportById(reportId);
        }
        GenericResponse<String> response = new GenericResponse<String>();
        response.setMessage("Success");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/{reportId}")
    public NfReport getReport(@PathVariable(name = "reportId") String reportId){
        logger.info("***********Inside getReport Method********");
        logger.debug("Report ID:" + reportId);

        return nfReportService.findReportByReportId(Long.valueOf(reportId));
    }



    @PostMapping(value = "/{reportId}/deleteFile/{fileId}")
    public ResponseEntity<GenericResponse<String>> deleteAttachmentByAttachmentId(@PathVariable(name = "reportId") Long reportId , @PathVariable(name = "fileId") Long attachmentId){
        logger.info("*********Inside deleteNotificationForm method");
        logger.debug("reportId:" + reportId);
        if(reportId == null) {
            try {
                throw new Exception("Not a valid report Id");
            } catch (Exception e) {
                logger.error(e.getLocalizedMessage() + e);
            }
        }else {
            try {
                nfReportService.deleteAttachmentByAttachmentId(reportId, attachmentId);
            } catch (Exception e) {
                logger.error(e.getLocalizedMessage(), e);
            }
        }
        GenericResponse<String> response = new GenericResponse<String>();
        response.setMessage("Success");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @GetMapping(value = "/{reportId}/downloadFile/{fileId}")
    @ResponseBody
    public ResponseEntity<Resource> downloadAttachmentByAttachmentId(@PathVariable(name = "reportId") Long reportId , @PathVariable(name = "fileId") Long attachmentId){
        logger.info("*********Inside downloadAttachmentByAttachmentId method");
        logger.debug("reportId:" + reportId);
//        if(reportId == null) {
//            try {
//                throw new Exception("Not a valid report Id");
//            } catch (Exception e) {
//                logger.error(e.getLocalizedMessage() + e);
//            }
//        }else {
//            try {
//                nfReportService.deleteAttachmentByAttachmentId(reportId, attachmentId);
//            } catch (Exception e) {
//                logger.error(e.getLocalizedMessage(), e);
//            }
//        }

        NfAttachment attachment = attachmentService.findAttachmentById(attachmentId);
        Resource file = nfReportService.loadAsResource(attachment);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + attachment.getAttachmentFileName() + "\"").body(file);

    }


}
