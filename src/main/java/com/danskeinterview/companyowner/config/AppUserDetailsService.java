package com.danskeinterview.companyowner.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.danskeinterview.companyowner.entity.User;
import com.danskeinterview.companyowner.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AppUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("AppUserDetailsService >> loadUserByUsername");
		Optional<User> user = repository.findByUserName(username);
		return user.map(AppUserDetails::new).orElseThrow(()->new UsernameNotFoundException(username+" - Does not exist"));
	}

}
