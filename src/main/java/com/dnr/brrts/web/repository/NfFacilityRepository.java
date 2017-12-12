package com.dnr.brrts.web.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import com.dnr.brrts.web.model.NfFacility;

@Qualifier("facilityRepository")
public interface NfFacilityRepository extends CrudRepository<NfFacility, Long> {


    List<NfFacility> findByFacilityId(Long facilityId);


    List<NfFacility> findByFacilityName(String facilityName);


    NfFacility save(NfFacility facility);
}
