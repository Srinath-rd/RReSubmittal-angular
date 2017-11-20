package com.dnr.brrts.web.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.dnr.brrts.web.model.Facility;

public interface FacilityRepository extends CrudRepository<Facility, Long> {


    List<Facility> findByDetailSeqNo(Long detailSeqNo);


    List<Facility> findByActivityDetailName(String activityDetailName);

}
