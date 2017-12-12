package com.dnr.brrts.web.service;

import java.util.List;

import com.dnr.brrts.web.model.NfFacility;
import org.springframework.stereotype.Service;

@Service
public interface FacilityService {

    List<NfFacility> getFacilitiesByName(String name);

    NfFacility saveFacility(NfFacility facility);
}