package com.dnr.brrts.web.controller;

import com.dnr.brrts.web.model.ImpactRO;
import com.dnr.brrts.web.repository.ImpactDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NfImpactsController {

    @Autowired
    private ImpactDetailRepository impactDetailRepository;

    @GetMapping("/impacts")
    public List<ImpactRO> getAllImpactList() {

        return impactDetailRepository.getImpactList();
    }
}
