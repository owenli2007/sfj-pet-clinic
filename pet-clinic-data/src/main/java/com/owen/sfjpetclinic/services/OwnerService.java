package com.owen.sfjpetclinic.services;

import java.util.Set;

import com.owen.sfjpetclinic.model.Owner;

public interface OwnerService {

	public Owner findByLastName(String lastName);
	
	public Owner findById(Long id);
	
	public Owner save(Owner owner);
	
	public Set<Owner> findAll();
}
