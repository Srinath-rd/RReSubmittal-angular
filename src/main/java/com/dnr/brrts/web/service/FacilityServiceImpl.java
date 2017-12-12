package com.dnr.brrts.web.service;

import java.util.List;

import com.dnr.brrts.web.model.NfFacility;
import com.dnr.brrts.web.repository.NfFacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class FacilityServiceImpl implements FacilityService {


    @Qualifier("facilityRepository")
    @Autowired
    NfFacilityRepository facilityRepository;

    @Override
    public List<NfFacility> getFacilitiesByName(String name) {

        return null;
    }

    @Override
    @Transactional
    public NfFacility saveFacility(NfFacility facility) {
        return facilityRepository.save(facility);
    }

}
