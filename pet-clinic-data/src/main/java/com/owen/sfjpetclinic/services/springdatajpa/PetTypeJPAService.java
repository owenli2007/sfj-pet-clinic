package com.owen.sfjpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.owen.sfjpetclinic.model.PetType;
import com.owen.sfjpetclinic.repositories.PetTypeRepository;
import com.owen.sfjpetclinic.services.PetTypeService;

@Service
@Profile("springdatajpa")
public class PetTypeJPAService implements PetTypeService{

	private final PetTypeRepository petTypeRepository;
	
	
	public PetTypeJPAService(PetTypeRepository petTypeRepository) {
		this.petTypeRepository = petTypeRepository;
	}

	@Override
	public Set<PetType> findAll() {
		Set<PetType> petTypes = new HashSet<>();
		petTypeRepository.findAll().forEach(petTypes::add);
		
		return petTypes;
	}

	@Override
	public PetType findById(Long id) {
		Optional<PetType> petTypeOptional = petTypeRepository.findById(id);
		if (petTypeOptional.isPresent()) {
			return petTypeOptional.get();
		}
		else {
			return null;
		}
	}

	@Override
	public PetType save(PetType object) {
		return petTypeRepository.save(object);
	}

	@Override
	public void delete(PetType object) {
		petTypeRepository.delete(object);
		
	}

	@Override
	public void deleteById(Long id) {
		petTypeRepository.deleteById(id);
		
	}

}
