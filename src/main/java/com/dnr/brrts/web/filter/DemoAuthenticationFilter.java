package com.dnr.brrts.web.filter;

import java.io.IOException;
import java.util.List;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dnr.brrts.web.Utility.UserLoginUtility;
import com.dnr.brrts.web.model.DemoAuthenticationToken;
import com.dnr.brrts.web.model.NfUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.web.filter.OncePerRequestFilter;

public class DemoAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    UserLoginUtility loginHelper;

    private static final String ID_KEY = "AUTHORIZATION";

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String xAuth = request.getHeader(ID_KEY);

        // validate the value in xAuth
        if (isValid(xAuth) == false) {
            throw new SecurityException();
        }

        // The token is 'valid' so magically get a user id from it

        String id = getUserIdFromToken(xAuth);

        if (id != null) {

            // Create our Authentication and let Spring know about it
            Authentication auth = createAuthentication(id);
            //  Authentication auth = new NfUser(id);
            SecurityContextHolder.getContext().setAuthentication(auth);

        }

        filterChain.doFilter(request, response);
    }

    private String getUserIdFromToken(String xAuth) {

        logger.debug("Inside getUserIdFromToken: " + xAuth);
        return loginHelper.getUserName(xAuth);
    }

    private boolean isValid(String xAuth) {
        if (xAuth == null)
            return false;
        else
            return  true;
    }

    private Authentication createAuthentication(String token) {
        // Validate the token and figure out the user information
        // You could use some sort of external API to determine this

        String username = token;
        List<GrantedAuthority> authorities =
                AuthorityUtils.createAuthorityList("ROLE_USER");
        return new PreAuthenticatedAuthenticationToken(username, "na", authorities);
    }

}