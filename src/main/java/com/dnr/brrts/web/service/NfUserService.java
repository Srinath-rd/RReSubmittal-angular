package com.dnr.brrts.web.service;


import com.dnr.brrts.web.model.NfUser;

public interface NfUserService {
    NfUser findUserByEmail(String email);
    void saveUser(NfUser user);
    NfUser findUserByUsername(String username);
}