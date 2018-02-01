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

    @GetMapping("/users/{userId}/applications/pending")
   List<NfReport> getPendingApplicationByUser(@PathVariable String userId){

        return  reportService.findReportsByUserNameAndStatus(userId, FormStatus.PENDING);

   }

   @GetMapping("/users/{userId}/applications/completed")
   List<NfReport> getCompletedAppsByUser(@PathVariable String userId){
       return reportService.findReportsByUserNameAndStatus(userId, FormStatus.COMPLETED);
   }

    @GetMapping("/users/{userId}/applications/submitted")
    List<NfReport> getSubmittedAppsByUser(@PathVariable String userId){
        return reportService.findReportsByUserNameAndStatus(userId, FormStatus.SUBMITTED);
    }

   @GetMapping("/users/applications/all")
   List<NfApplicationForm> getAllApplicationForms(){
       return formService.getApplicationFormTypes();
   }







}
