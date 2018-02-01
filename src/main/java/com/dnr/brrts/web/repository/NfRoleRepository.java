package com.dnr.brrts.web.repository;

import com.dnr.brrts.web.model.NfRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NfRoleRepository extends JpaRepository<NfRole, Integer>{
    NfRole findByRole(String role);

}
