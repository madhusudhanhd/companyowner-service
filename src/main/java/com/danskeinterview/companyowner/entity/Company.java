package com.danskeinterview.companyowner.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author mtegurhu
 *
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String country;
	private String phoneNbr;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "company_id", referencedColumnName = "id")
	private List<Owner> owners = new ArrayList<Owner>();
	
	public void addOwner(Owner owner) {
		owners.add(owner);
	}
	
	public void removeOwner(Owner owner) {
		owners.remove(owner);
	}
	
}
