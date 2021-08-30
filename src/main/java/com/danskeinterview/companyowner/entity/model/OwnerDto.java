package com.danskeinterview.companyowner.entity.model;




import java.util.List;

import javax.validation.constraints.NotBlank;

import com.danskeinterview.companyowner.entity.Owner;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
public class OwnerDto {
	private Long id;
	
	@NotBlank(message = "Owner Name can not be blank")
	private String name;
	
	@NotBlank(message = "Social Security Number can not be blank")
	@JsonInclude(value = Include.NON_NULL)
	private String socialSecurityNumber;
	
	
	public static OwnerDto convertToDto(Owner entity, List<String> activeRoles) {
		if(entity == null) {
			return null;
		}
		
		OwnerDto dto = new OwnerDto();
		if (activeRoles.contains("ROLE_ADMIN")) {
			dto.setId(entity.getId());
			dto.setName(entity.getName());
			dto.setSocialSecurityNumber(entity.getSocialSecurityNumber());
		}else {
			dto.setId(entity.getId());
			dto.setName(entity.getName());
		}
		
		return dto;
	}
}
