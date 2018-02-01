package com.dnr.brrts.web.controller;

import java.util.List;

import com.dnr.brrts.web.model.NfFacility;
import com.dnr.brrts.web.repository.NfFacilityRepository;
import com.dnr.brrts.web.service.FacilityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.dnr.brrts.web.model.FacilityRO;
import com.dnr.brrts.web.model.ImpactRO;
import com.dnr.brrts.web.model.SubstanceRO;
import com.dnr.brrts.web.repository.FacActivityDetailRepository;
import com.dnr.brrts.web.repository.ImpactDetailRepository;
import com.dnr.brrts.web.repository.SubstanceDetailRepository;

@RestController
public class FacilityController {

    @Autowired
    NfFacilityRepository facilityRepository;

    @Autowired
    FacActivityDetailRepository activityDetailRepository;

    @Autowired
    SubstanceDetailRepository substanceDetailRepository;

    @Autowired
    ImpactDetailRepository impactDetailRepository;

    @Autowired
    FacilityService facilityService;

    private static final Logger logger = LoggerFactory.getLogger(FacilityController.class);

    @GetMapping("/facilities")
    public List<FacilityRO> getFacilitiesByName(@RequestParam("name") String name) {

        logger.info("request params:" + "name:" + name);
        return activityDetailRepository.getFacilitiesByName(name);

    }


    @PostMapping("/facility")
    public void saveFacility(NfFacility facility){
        facilityService.saveFacility(facility);
    }
}
