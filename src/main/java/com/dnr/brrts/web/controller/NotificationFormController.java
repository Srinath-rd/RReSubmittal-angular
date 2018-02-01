package com.dnr.brrts.web.controller;

import javax.validation.Valid;

import com.dnr.brrts.web.Utility.UserLoginUtility;
import com.dnr.brrts.web.model.FormStatus;
import com.dnr.brrts.web.model.NfReport;
import com.dnr.brrts.web.model.NfUser;
import com.dnr.brrts.web.service.NfReportService;
import com.dnr.brrts.web.service.NfUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.dnr.brrts.web.model.NotificationForm;

@Controller
public class NotificationFormController {

    @Autowired
    NfReportService reportService;

    @Autowired
    UserLoginUtility userLoginUtility;

    @Autowired
    NfUserService userService;

    @RequestMapping(value = "/nform", method = RequestMethod.GET)
    public String getNotificationForm(ModelMap model , @RequestParam(name = "reportId" , required = false) String reportId ) {
        logger.info("..............Inside showTodosAlt3 method..................");
        String name = userLoginUtility.getLoggedinUserName();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        NfUser user = userService.findUserByEmail(auth.getName());
        if ((auth instanceof AnonymousAuthenticationToken)) {
            return "forward:/login";
        }else {
          //  model.put("report", report);
            model.put("user", user);
            if(reportId != null){
                NfReport reportFound = reportService.findReportByReportId(Long.valueOf(reportId));
                model.put("report", reportFound);
                if(reportFound.getStatus().equals(FormStatus.SUBMITTED)){
                    return "nformpagereadonly";
                }
            }
            return "nformpage";
        }

    }



    /**
     * First step handler (if you want to map each step individually to a method). You should probably either use this
     * approach or the one below (mapping all pages to the same method and getting the
     * <p>
     * 576********page number as parameter).
     */
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @RequestMapping(value = "/wizardform1", method = RequestMethod.POST)
    public String processFirstStep(@Valid @ModelAttribute("notificationForm") NotificationForm notificationForm,
                                   BindingResult result, ModelMap model) {
        // do something with command, errors, request, response,
        // model map or whatever you include among the method
        // parameters. See the documentation for @RequestMapping
        // to get the full picture.
        return "list-todos1";
    }


    /**
     * First step handler (if you want to map each step individually to a method). You should probably either use this
     * approach or the one below (mapping all pages to the same method and getting the page number as parameter).
     */
    @RequestMapping(value = "/wizardform2", method = RequestMethod.POST)
    public String processFirstStep2(final @ModelAttribute("notificationForm") NotificationForm notificatioNForm,
                                    BindingResult result, ModelMap model) {
        // do something with command, errors, request, response,
        // model map or whatever you include among the method
        // parameters. See the documentation for @RequestMapping
        // to get the full picture.
        return "list-todos2";
    }


    @RequestMapping(value = "/wizardform3", method = RequestMethod.POST)
    public String processFirstStep3(final @ModelAttribute("notificationForm") NotificationForm notificatioNForm,
                                    BindingResult result, ModelMap model) {
        // do something with command, errors, request, response,
        // model map or whatever you include among the method
        // parameters. See the documentation for @RequestMapping
        // to get the full picture.
        return "list-todos3";
    }

    @RequestMapping(value = "/wizardform4", method = RequestMethod.POST)
    public String processFirstStep4(final @ModelAttribute("notificationForm") NotificationForm notificatioNForm,
                                    BindingResult result, ModelMap model) {
        // do something with command, errors, request, response,
        // model map or whatever you include among the method
        // parameters. See the documentation for @RequestMapping
        // to get the full picture.
        logger.debug("Inside ProcessFirstStep5");
        return "nfimpactsinfo";
    }

    @RequestMapping(value = "/wizardform5", method = RequestMethod.POST)
    public String processFirstStep5(final @ModelAttribute("notificationForm") NotificationForm notificatioNForm,
                                    BindingResult result, ModelMap model) {
        // do something with command, errors, request, response,
        // model map or whatever you include among the method
        // parameters. See the documentation fo

        return "list-todos5";
    }

    @RequestMapping(value = "/wizardform6", method = RequestMethod.POST)
    public String processFirstStep6(final @ModelAttribute("notificationForm") NotificationForm notificatioNForm,
                                    BindingResult result, ModelMap model) {
        // do something with command, errors, request, response,
        // model map or whatever you include among the method
        // parameters. See the documentation for @RequestMapping
        // to get the full picture.
        return "list-todos6";
    }

    @RequestMapping(value = "/wizardform7", method = RequestMethod.POST)
    public String processFirstStep7(final @ModelAttribute("notificationForm") NotificationForm notificatioNForm,
                                    BindingResult result, ModelMap model) {
        // do something with command, errors, request, response,
        // model map or whatever you include among the method
        // parameters. See the documentation for @RequestMapping
        // to get the full picture.
        return "notificationFormFinish";
    }


}
