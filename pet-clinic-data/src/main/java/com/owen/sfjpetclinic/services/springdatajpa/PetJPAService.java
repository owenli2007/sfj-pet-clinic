package com.owen.sfjpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.owen.sfjpetclinic.model.Pet;
import com.owen.sfjpetclinic.repositories.PetRepository;
import com.owen.sfjpetclinic.services.PetService;

@Service
@Profile("springdatajpa")
public class PetJPAService implements  PetService{

	private final PetRepository petRepository;
	
	
	public PetJPAService(PetRepository petRepository) {
		super();
		this.petRepository = petRepository;
	}

	@Override
	public Set<Pet> findAll() {
		Set<Pet> pets = new HashSet<>();
		petRepository.findAll().forEach(pets::add);;
		
		return pets;
	}

	@Override
	public Pet findById(Long id) {
		Optional<Pet> petOptional = petRepository.findById(id);
		if (petOptional.isPresent()) {
			return petOptional.get();
		}
		else {
			return null;
		}
	}

	@Override
	public Pet save(Pet object) {
		return petRepository.save(object);
	}

	@Override
	public void delete(Pet object) {
		petRepository.delete(object);
		
	}

	@Override
	public void deleteById(Long id) {
		petRepository.deleteById(id);
		
	}

}
