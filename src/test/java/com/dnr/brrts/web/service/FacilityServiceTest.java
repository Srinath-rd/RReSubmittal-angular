package com.dnr.brrts.web.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dnr.brrts.web.model.Facility;
import com.dnr.brrts.web.repository.FacilityRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class FacilityServiceTest {

    @Configuration
    static class AccountServiceTestContextConfiguration {
        @Bean
        public FacilityServiceImpl facilityService() {
            return new FacilityServiceImpl();
        }

        @Bean
        public FacilityRepository accountRepository() {
            return Mockito.mock(FacilityRepository.class);
        }
    }

    @Before
    public void setup() {
        //Facility facility = new Facility("", "", "");
    }

    @Test
    public void testGetFacilitiesByName() {
        fail("Not yet implemented");
    }


    @Autowired
    private FacilityService facilityService;

    @Autowired
    private FacilityRepository facilityRepository;

}
