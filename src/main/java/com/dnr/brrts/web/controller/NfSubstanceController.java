package com.dnr.brrts.web.controller;

import com.dnr.brrts.web.model.SubstanceRO;
import com.dnr.brrts.web.repository.SubstanceDetailRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NfSubstanceController {


    @Autowired
    private SubstanceDetailRepository substanceDetailRepository;

    private static Logger logger = LoggerFactory.getLogger(NfSubstanceController.class);

    @GetMapping("/substances")
    public List<SubstanceRO> getAllSubstances() {
        logger.info("Inside the method getAllSubstances" + "**********");
        return substanceDetailRepository.getAllSubstances();
    }

    @GetMapping("/substances/sublist")
    public List<SubstanceRO> getSubstancesSublist(@RequestParam(name = "substance1") String substance1, @RequestParam(name = "substance2", required = false) String substance2) {

        logger.info("Inside the method getSubstancesSublist" + "**********");
        return substanceDetailRepository.getSubstanceSublist(substance1, substance2);
    }

}
