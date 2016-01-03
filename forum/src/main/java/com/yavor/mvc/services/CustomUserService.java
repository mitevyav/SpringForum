package com.yavor.mvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.yavor.mvc.entities.CustomUser;
import com.yavor.mvc.repositories.CustomUserRepository;

@Component("customUserService")
public class CustomUserService implements UserDetailsService {
	
	@Autowired
	private CustomUserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		CustomUser user = repo.findById(username);
		return new User(user.getUsername(), user.getPassword(), 
				AuthorityUtils.createAuthorityList(user.getRole()));
	}
	
	public void insertUser(CustomUser user) {
		user.setRole("ROLE_USER");
		repo.insert(user);
	}
	
	public boolean isExist (String username) {
		System.out.println("Service");
		boolean isExist = false;
		String user = repo.getUsername(username);
		if(user != null) isExist = true;
		return isExist;
	}
}
