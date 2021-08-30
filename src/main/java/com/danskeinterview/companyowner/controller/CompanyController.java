package com.danskeinterview.companyowner.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danskeinterview.companyowner.entity.Company;
import com.danskeinterview.companyowner.entity.mapper.EntityModelMapper;
import com.danskeinterview.companyowner.entity.model.CompanyDto;
import com.danskeinterview.companyowner.service.CompanyService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/company")
@Slf4j
public class CompanyController {

	@Autowired
	private CompanyService companyService;
	
	@PostMapping("/create")
	public ResponseEntity<CompanyDto> createCompany(@Valid @RequestBody CompanyDto company) {
		log.info("Inside createCompany >> CompanyController ");
		Company entity =  companyService.createCompany(EntityModelMapper.INSTANCE.convertToEntity(company));
		return new ResponseEntity<>(EntityModelMapper.INSTANCE.convertToDto(entity), HttpStatus.OK);
	}
	
	@GetMapping("/getAllCompanies")
	public ResponseEntity<List<CompanyDto>> getAllCompanies() {
		log.info("Inside getAllCompanies >> CompanyController ");
		List<Company> companies =  companyService.getAllCompanies();
		List<CompanyDto> companyDto = companies.stream().map(EntityModelMapper.INSTANCE::convertToDto).collect(Collectors.toList());
		return new ResponseEntity<>(companyDto, HttpStatus.OK);
	}
	
	@GetMapping("/getCompanyById/{id}")
	public ResponseEntity<CompanyDto> getCompanyById(@PathVariable("id") Long companyId) {
		log.info("Inside getCompanyById >> CompanyController ");
		Company entity =  companyService.getCompanyById(companyId);
		return new ResponseEntity<>(EntityModelMapper.INSTANCE.convertToDto(entity), HttpStatus.OK);
	}
	
    @PutMapping("/updateCompany/{id}")
    public ResponseEntity<CompanyDto> updateCompany(@RequestBody CompanyDto company, @PathVariable Long id) {
    	log.info("Inside updateCompany >> CompanyController ");
    	Company entity = companyService.updateCompany(EntityModelMapper.INSTANCE.convertToEntity(company), id);
    	return new ResponseEntity<>(EntityModelMapper.INSTANCE.convertToDto(entity), HttpStatus.OK);
    }
    
    @PostMapping("/{companyId}/owner/{ownerId}/add")
    public ResponseEntity<CompanyDto> addOwnerToCompany(@PathVariable("companyId") Long companyId, @PathVariable("ownerId") Long ownerId) {
    	log.info("Inside addOwnerToCompany >> CompanyController ");
    	Company entity = companyService.addOwnerToCompany(companyId, ownerId);
    	return new ResponseEntity<>(EntityModelMapper.INSTANCE.convertToDto(entity), HttpStatus.OK);
    }
    
    @DeleteMapping("/{companyId}/owner/{ownerId}/remove")
    public ResponseEntity<CompanyDto> removeOwnerFromCompany(@PathVariable("companyId") Long companyId, @PathVariable("ownerId") Long ownerId) {
    	log.info("Inside addOwnerToCompany >> CompanyController ");
    	Company entity = companyService.removeOwnerFromCompany(companyId, ownerId);
    	return new ResponseEntity<>(EntityModelMapper.INSTANCE.convertToDto(entity), HttpStatus.OK);
    }
    
    
}
