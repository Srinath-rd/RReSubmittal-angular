package com.dnr.brrts.web.security;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


@Component("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        return null;
    }
/*
    @Autowired
	private AutoUserRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AutoUser user = repo.findByUsername(username);
		
		return new User(user.getUsername(), user.getPassword(),
				AuthorityUtils.createAuthorityList(user.getRole()));
	}*/

}
