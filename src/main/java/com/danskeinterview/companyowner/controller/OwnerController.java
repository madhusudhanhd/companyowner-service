package com.danskeinterview.companyowner.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danskeinterview.companyowner.entity.Owner;
import com.danskeinterview.companyowner.entity.mapper.EntityModelMapper;
import com.danskeinterview.companyowner.entity.model.OwnerDto;
import com.danskeinterview.companyowner.service.OwnerService;
import com.danskeinterview.companyowner.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/owner")
@Slf4j
public class OwnerController {

	@Autowired
	private OwnerService ownerService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/create")
	@Secured("ROLE_ADMIN")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<OwnerDto> createOwner(@Valid @RequestBody OwnerDto owner) {
		log.info("Inside createOwner >> OwnerController ");
		Owner entity =  ownerService.createOwner(EntityModelMapper.INSTANCE.convertToEntity(owner));
		return new ResponseEntity<>(EntityModelMapper.INSTANCE.convertToDto(entity), HttpStatus.OK);
	}
	
	@GetMapping("/getAllOwners")
	@Secured("ROLE_ADMIN,ROLE_USER")
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_USER')")
	public ResponseEntity<List<OwnerDto>> getAllOwners(Principal principal) {
		log.info("Inside getAllOwners >> OwnerController ");
		List<Owner> owners =  ownerService.getAllOwners();
		List<String> activeRoles = userService.getRolesByLoggedInUser(principal);
		List<OwnerDto> ownerDto = new ArrayList<OwnerDto>();
		if(activeRoles.contains("ROLE_ADMIN")) {
			ownerDto = owners.stream().map(EntityModelMapper.INSTANCE::convertToDto).collect(Collectors.toList());
		}else {
			ownerDto = owners.stream().map(EntityModelMapper.INSTANCE::convertToDto).collect(Collectors.toList());
		}
		return new ResponseEntity<>(ownerDto, HttpStatus.OK);
	}
	
	@GetMapping("/getOwnerById/{id}")
	@Secured("ROLE_ADMIN,ROLE_USER")
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_USER')")
	public ResponseEntity<OwnerDto> getOwnerById(@PathVariable("id") Long ownerId, Principal principal) {
		log.info("Inside getOwnerById >> CompanyController ");
		Owner entity =  ownerService.getOwnerById(ownerId);
		List<String> activeRoles = userService.getRolesByLoggedInUser(principal);
		return new ResponseEntity<>(OwnerDto.convertToDto(entity, activeRoles), HttpStatus.OK);			
	}
	
	@GetMapping("/isValidSSN/{ssnNumber}")
	@Secured("ROLE_ADMIN")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<String> isValidSSN(@PathVariable("ssnNumber") String ssnNumber, Principal principal) {
		log.info("Inside getOwnerById >> CompanyController ");
		return new ResponseEntity<>(ownerService.isValidSSN(ssnNumber)?"VALID":"INVALID", HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteOwner/{id}")
	@Secured("ROLE_ADMIN")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<HttpStatus> deleteOwner(@PathVariable("id") Long ownerId) {
		log.info("Inside deleteOwner >> OwnerController ");
		return new ResponseEntity<>(HttpStatus.OK);
	}	
}
