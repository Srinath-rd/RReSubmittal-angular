package com.dnr.brrts.web;


import com.dnr.brrts.web.repository.FacActivityDetailRepository;
import com.dnr.brrts.web.repository.FacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.WebApplicationInitializer;

@SpringBootApplication
@ComponentScan("com.dnr.brrts.web")
public class DemoApplication extends SpringBootServletInitializer implements WebApplicationInitializer {
//
//	@Autowired
//	DataSource dataSource;

    @Autowired
    FacilityRepository facilityRepository;

    @Autowired
    FacActivityDetailRepository activityRepository;

    public static void main(String[] args) {


        SpringApplication.run(DemoApplication.class, args);

    }

/*	   @Transactional(readOnly = true)
        @Override
	    public void run(String... args) throws Exception {

	    //    System.out.println("DATASOURCE = " + dataSource);

       //     List<Facility> facility = facilityRepository.findByDetailSeqNo(20001L);

	    //    System.out.println(facility.get(0).getActCode() + "Detail Seq Number" + facility.get(0).getDetailSeqNo());


	       activityRepository.getFacilitiesByName("BOYS");


	    }*/

}