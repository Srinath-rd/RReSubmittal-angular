package com.dnr.brrts.web.controller;

import com.dnr.brrts.web.model.FormStatus;
import com.dnr.brrts.web.model.NfApplicationForm;
import com.dnr.brrts.web.model.NfReport;
import com.dnr.brrts.web.service.ApplicationFormService;
import com.dnr.brrts.web.service.NfReportService;
import com.dnr.brrts.web.service.NfUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    NfUserService userService;

    @Autowired
    NfReportService reportService;

    @Autowired
    private ApplicationFormService formService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @GetMapping("/users/{username}/applications/pending")
   List<NfReport> getPendingApplicationByUser(@PathVariable String username){

        return  reportService.findReportsByUserNameAndStatus(username, FormStatus.PENDING);

   }

   @GetMapping("/users/{username}/applications/completed")
   List<NfReport> getCompletedAppsByUser(@PathVariable String username){
       return reportService.findReportsByUserNameAndStatus(username, FormStatus.COMPLETED);
   }

    @GetMapping("/users/{username}/applications/submitted")
    List<NfReport> getSubmittedAppsByUser(@PathVariable String username){
        return reportService.findReportsByUserNameAndStatus(username, FormStatus.SUBMITTED);
    }

   @GetMapping("/users/applications/all")
   List<NfApplicationForm> getAllApplicationForms(){
       return formService.getApplicationFormTypes();
   }







}
