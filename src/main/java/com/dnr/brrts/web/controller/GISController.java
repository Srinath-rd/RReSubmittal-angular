package com.dnr.brrts.web.controller;

import com.dnr.brrts.web.service.GISService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GISController {

    @Autowired
    private GISService gisService;

    @GetMapping("/municipality")
    public String  getMunicipalityFromXY(@RequestParam(name = "latitude") String latitude, @RequestParam(name = "longitude") String longitude) {

        return gisService.getMunicipalityFromXY(Double.valueOf(latitude), Double.valueOf(longitude));
    }
}
