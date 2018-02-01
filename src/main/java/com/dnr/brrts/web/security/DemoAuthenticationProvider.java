package com.dnr.brrts.web.security;

import com.dnr.brrts.web.model.DemoAuthenticationToken;
import com.dnr.brrts.web.model.NfUser;
import com.dnr.brrts.web.repository.NfUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Component;

@Component
public class DemoAuthenticationProvider implements AuthenticationProvider {

    // This would be a JPA repository to snag your user entities
    private final NfUserRepository userRepository;

    @Autowired
    public DemoAuthenticationProvider(NfUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        PreAuthenticatedAuthenticationToken demoAuthentication = (PreAuthenticatedAuthenticationToken) authentication;
        NfUser user = userRepository.findByUsername(demoAuthentication.getName());

        if(user == null){
            //create new user
            user = new NfUser(demoAuthentication.getName());
            user.setFirstName("Unknown");
            user.setLastName("Unknown");
            user.setPassword("na");
            user.setEmail("unknown");
            userRepository.save(user);
           // throw new Exception("Could not find user with ID: " + demoAuthentication.getId());
        }

        return demoAuthentication;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return PreAuthenticatedAuthenticationToken.class.isAssignableFrom(authentication);
    }

}