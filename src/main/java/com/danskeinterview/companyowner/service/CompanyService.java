package com.danskeinterview.companyowner.service;

import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danskeinterview.companyowner.entity.Company;
import com.danskeinterview.companyowner.entity.Owner;
import com.danskeinterview.companyowner.exception.CompanyNotFoundException;
import com.danskeinterview.companyowner.exception.InvalidOwnerException;
import com.danskeinterview.companyowner.repository.CompanyRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CompanyService {

	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private OwnerService ownerService;
	
	public Company createCompany(Company company) {
		log.info("Inside CompanyService >> createCompany");
		return companyRepository.save(company);
	}
	
	public List<Company> getAllCompanies() {
		log.info("Inside CompanyService >> getAllCompanies ");
		return companyRepository.findAll();
	}
	public Company getCompanyById(Long companyId) {
		log.info("Inside CompanyService >> getAllCompanies ");
		return companyRepository.findById(companyId).orElseThrow(
				()->new CompanyNotFoundException(companyId)
				);
	}
	
	public Company updateCompany(Company company, Long companyId) {
		log.info("Inside CompanyService >> updateCompany ");
		return companyRepository.findById(companyId).map(comp -> {
			comp.setName(company.getName());
			comp.setCountry(company.getCountry());
			comp.setPhoneNbr(company.getPhoneNbr());
			return companyRepository.save(comp);
		}).orElseGet(() -> {
			return companyRepository.save(company);
		});
		 
	}
	
	@Transactional
	public Company addOwnerToCompany(Long companyId, Long ownerId) {
		log.info("Inside CompanyService >> addOwnerToCompany ");
		Company company = getCompanyById(companyId)	;
		Owner owner = ownerService.getOwnerById(ownerId);
		if(Objects.nonNull(owner.getCompany())){
            throw new InvalidOwnerException(owner.getName(), owner.getCompany().getName());
        }
		company.addOwner(owner);
		owner.setCompany(company);
		//companyRepository.save(company);
		return company;
	}
	
	@Transactional
	public Company removeOwnerFromCompany(Long companyId, Long ownerId) {
		log.info("Inside CompanyService >> removeOwnerFromCompany ");
		Company company = getCompanyById(companyId)	;
		Owner owner = ownerService.getOwnerById(ownerId);
		company.removeOwner(owner);
		//companyRepository.save(company);
		return company;
	}
	
	
	
	
}
