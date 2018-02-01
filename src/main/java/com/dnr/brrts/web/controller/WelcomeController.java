package com.dnr.brrts.web.controller;

import com.dnr.brrts.web.Utility.UserLoginUtility;
import com.dnr.brrts.web.model.FormName;
import com.dnr.brrts.web.model.FormStatus;
import com.dnr.brrts.web.model.NfUser;
import com.dnr.brrts.web.service.NfReportService;
import com.dnr.brrts.web.service.NfUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private UserLoginUtility userLoginUtility;

    @Autowired
    private NfReportService reportService;

    @Autowired
    private NfUserService userService;


    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String showWelcomePage(ModelMap model) {
        logger.info("*************Inside showWelcomePage method***************");
        String username = userLoginUtility.getLoggedinUserName();
        logger.debug("User name is" + " " +  username);
        NfUser user = userService.findUserByUsername(username);
        model.put("allReports", reportService.findReportsByUserName(user.getUsername()));
        model.put("pendingReports", reportService.findReportsByUserNameAndStatus(user.getUsername(), FormStatus.PENDING));
        model.put("completedReports", reportService.findReportsByUserNameAndStatus(user.getUsername(), FormStatus.COMPLETED));
        model.addAttribute("name", user.getFirstName());
        model.addAttribute("username" , username);
        model.addAttribute("useremail" , user.getEmail());
        return "home";
    }



}
