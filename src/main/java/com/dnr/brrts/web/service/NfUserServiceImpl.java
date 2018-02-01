package com.dnr.brrts.web.service;

import com.dnr.brrts.web.model.NfRole;
import com.dnr.brrts.web.model.NfUser;
import com.dnr.brrts.web.repository.NfRoleRepository;
import com.dnr.brrts.web.repository.NfUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;


@Service("userService")
public class NfUserServiceImpl implements NfUserService{

    @Autowired
    private NfUserRepository userRepository;
    @Autowired
    private NfRoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public NfUser findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    private static  final Logger logger = LoggerFactory.getLogger(NfUserServiceImpl.class);

    @Override
    public void saveUser(NfUser user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        NfRole userRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<NfRole>(Arrays.asList(userRole)));
        userRepository.save(user);
    }

    @Override
    public NfUser findUserByUsername(String username) {
        return  userRepository.findByUsername(username);
    }


}