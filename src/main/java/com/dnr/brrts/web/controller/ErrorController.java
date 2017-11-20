package com.dnr.brrts.web.controller;

import javax.servlet.http.HttpServletRequest;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@Controller("error")
public class ErrorController {


    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException
            (HttpServletRequest request, Exception ex) {
        logger.info("Start of a message");
        ModelAndView mv = new ModelAndView();

        try {
            throw new Exception();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("This is a message" + ex.getMessage());
        logger.info("This is an imp message" + request.getRequestURI());
        logger.warn("This is a warning" + ex.getCause());
        logger.error("This is an error" + ex.getMessage());
        logger.debug("exception" + ex.getLocalizedMessage());
        mv.addObject("exception", ex.getLocalizedMessage());
        mv.addObject("url", request.getRequestURL());

        mv.setViewName("error");
        return mv;
    }

}
