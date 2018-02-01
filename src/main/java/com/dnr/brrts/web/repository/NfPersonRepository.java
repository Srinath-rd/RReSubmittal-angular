package com.dnr.brrts.web.repository;

import com.dnr.brrts.web.model.NfPerson;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface NfPersonRepository extends CrudRepository<NfPerson, Long> {
    NfPerson findByPersonId(Long personId);

    @Override
    NfPerson save(NfPerson person);

//    @Query("select nfperson0_.person_id as person_id1_7_2_, nfperson0_.created_date as created_date2_7_2_, nfperson0_.updated_date as updated_date3_7_2_, nfperson0_.company_name as company_name4_7_2_, nfperson0_.email as email5_7_2_, nfperson0_.first_name as first_name6_7_2_, nfperson0_.last_name as last_name7_7_2_, nfperson0_.phone_number as phone_number8_7_2_ from sw_rresubm_person nfperson0_ where  nfperson0_.person_id = :personId")
//    NfPerson findByPersonIdCustom(@Param("personId") Long personId);
}
