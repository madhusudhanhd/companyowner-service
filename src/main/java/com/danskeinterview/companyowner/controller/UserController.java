package com.danskeinterview.companyowner.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danskeinterview.companyowner.entity.User;
import com.danskeinterview.companyowner.service.UserService;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/create")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		log.info("Inside createUser >> UserController ");
		User userCreated = userService.createUser(user);
		log.info("User Created Successfully");
		return new ResponseEntity<>(userCreated, HttpStatus.OK);
	}
}
