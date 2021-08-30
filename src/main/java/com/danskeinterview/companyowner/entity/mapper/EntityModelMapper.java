package com.danskeinterview.companyowner.entity.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.danskeinterview.companyowner.entity.Company;
import com.danskeinterview.companyowner.entity.Owner;
import com.danskeinterview.companyowner.entity.model.CompanyDto;
import com.danskeinterview.companyowner.entity.model.OwnerDto;


@Mapper
public interface EntityModelMapper {
	EntityModelMapper INSTANCE = Mappers.getMapper(EntityModelMapper.class);	
	
	@Mapping(target = "company", ignore = true)
	Owner convertToEntity(OwnerDto dto);
	
	//@Mapping(target = "socialSecurityNumber", ignore = true)
	OwnerDto convertToDto(Owner entity);
	
	CompanyDto convertToDto(Company entity);
	Company convertToEntity(CompanyDto dto);

	//OwnerDto convertToDto(Owner entity, List<String> activeRoles);

	
	
}