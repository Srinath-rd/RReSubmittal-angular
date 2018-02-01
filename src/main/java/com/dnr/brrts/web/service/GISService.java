package com.dnr.brrts.web.service;

import com.dnr.brrts.web.repository.GISRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GISService {

    @Autowired
    GISRepository gisRepository;

    public String getMunicipalityFromXY(double x, double y){
        return gisRepository.getMunicipalityFromInputxy(x, y);
    }

}
