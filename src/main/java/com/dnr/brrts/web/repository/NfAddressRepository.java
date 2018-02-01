package com.dnr.brrts.web.repository;

import com.dnr.brrts.web.model.NfAddress;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NfAddressRepository extends CrudRepository<NfAddress, Long> {


    @Override
    NfAddress save(NfAddress address);

    @Override
    List<NfAddress> findAll();
}

