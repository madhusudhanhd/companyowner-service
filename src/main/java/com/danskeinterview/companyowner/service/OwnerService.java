package com.danskeinterview.companyowner.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danskeinterview.companyowner.entity.Owner;
import com.danskeinterview.companyowner.exception.OwnerNotFoundException;
import com.danskeinterview.companyowner.repository.OwnerRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OwnerService {


	@Autowired
	private OwnerRepository ownerRepository;
	
	public Owner createOwner(Owner owner) {
		log.info("Inside OwnerService >> createOwner");
		return ownerRepository.save(owner);
	}
	
	public List<Owner> getAllOwners() {
		log.info("Inside OwnerService >> getAllOwners");
		return ownerRepository.findAll();
	}
	
	public Owner getOwnerById(Long ownerId) {
		log.info("Inside OwnerService >> getOwnerById ");
		return ownerRepository.findById(ownerId).orElseThrow(
				()->new OwnerNotFoundException(ownerId)
				);
	}
	
	public void deleteOwner(Long ownerId) {
		log.info("Inside OwnerService >> deleteOwner");
		Owner owner = getOwnerById(ownerId);
		ownerRepository.delete(owner);
	}
	
	public boolean isValidSSN(String ssnNumber) {
		log.info("Inside OwnerService >> isValidSSN");
		Random rd = new Random();
	    return rd.nextBoolean();
	}
	
	
}
