package com.dnr.brrts.web.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.dnr.brrts.web.model.NotificationForm;

@Controller
public class NotificationFormController {


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
        return "list-todosa4";
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
