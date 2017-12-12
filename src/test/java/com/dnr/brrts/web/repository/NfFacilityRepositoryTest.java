package com.dnr.brrts.web.repository;

import com.dnr.brrts.web.DemoApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@TestPropertySource(locations = "classpath:application-test.properties")
@DataJpaTest
public class NfFacilityRepositoryTest {


    private final static Logger logger = LoggerFactory.getLogger(DemoApplication.class);

    @Autowired
    @Qualifier("facilityRepository")
    NfFacilityRepository facilityRepository;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void testSave() throws Exception {


    }

}