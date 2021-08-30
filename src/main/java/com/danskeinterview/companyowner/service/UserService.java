package com.danskeinterview.companyowner.service;

import java.security.Principal;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.danskeinterview.companyowner.entity.User;
import com.danskeinterview.companyowner.repository.UserRepository;
import com.danskeinterview.owner.util.AppConstants;


@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
    private BCryptPasswordEncoder passwordEncoder;
	
	public User createUser(User user) {
		String encryptedPwd = passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPwd);
		return userRepository.save(user);
	}
	
	public User getLoggedInUser(Principal principal) {
		return userRepository.findByUserName(principal.getName()).get();
	}
	
	public List<String> getRolesByLoggedInUser(Principal principal) {
		String roles = getLoggedInUser(principal).getRoles();
		List<String> assignRoles = Arrays.stream(roles.split(",")).collect(Collectors.toList());
		
		if(assignRoles.contains("ROLE_ADMIN")) {
			return Arrays.stream(AppConstants.ADMIN_ROLE).collect(Collectors.toList());
		}
		
		return Arrays.stream(AppConstants.DEFAULT_ROLE).collect(Collectors.toList());
		
	}
	
}
