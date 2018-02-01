package com.dnr.brrts.web.repository;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest
public class GISRepositoryTest {

    @Autowired
    GISRepository gisRepository;

    @Test
    public void testGetMunicipalityFromInputxy(){
        String  result = gisRepository.getMunicipalityFromInputxy(0, 0);
        assertEquals(result, "RIETBROCK");
    }

}