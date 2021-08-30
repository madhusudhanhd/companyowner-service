package com.danskeinterview.companyowner.entity.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class CompanyDto {
	private Long id;
	
	@NotBlank(message = "Company Name can not be blank")
	private String name;
	
	private String country;
	
	@NotBlank(message = "Phone Number can not be blank")
	private String phoneNbr;
	
	private List<OwnerDto> owners = new ArrayList<OwnerDto>();
}
