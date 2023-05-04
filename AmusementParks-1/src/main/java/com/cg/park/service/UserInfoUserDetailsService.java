package com.cg.park.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.cg.park.model.User;
import com.cg.park.repository.UserRepository;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	Optional<User> users = repo.findByEmail(email);
	return users.map(UserInfoUserDetails::new)
               .orElseThrow(() -> new UsernameNotFoundException("user not found " + email));
	
	
	}
	}

