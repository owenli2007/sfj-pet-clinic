package com.owen.sfjpetclinic.services;

import java.util.Set;

import com.owen.sfjpetclinic.model.Pet;

public interface PetService {

	public Set<Pet> findAll();
	
	public Pet findById(Long id);
	
	public Pet save(Pet pet);
	
}
