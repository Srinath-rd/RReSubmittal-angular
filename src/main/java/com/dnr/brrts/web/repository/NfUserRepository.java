package com.dnr.brrts.web.repository;


import com.dnr.brrts.web.model.NfUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NfUserRepository extends JpaRepository<NfUser, Long> {
    NfUser findByEmail(String email);

    NfUser findByUsername(String username);
}
