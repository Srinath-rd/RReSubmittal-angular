package com.dnr.brrts.web.service;

import java.util.List;

import com.dnr.brrts.web.model.Facility;

public interface FacilityService {

    List<Facility> getFacilitiesByName(String name);


}