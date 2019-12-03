package com.owen.sfjpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.owen.sfjpetclinic.model.Owner;
import com.owen.sfjpetclinic.repositories.OwnerRepository;
import com.owen.sfjpetclinic.repositories.PetRepository;
import com.owen.sfjpetclinic.repositories.PetTypeRepository;
import com.owen.sfjpetclinic.services.OwnerService;

@Service
@Profile("springdatajpa")
public class OwnerJPAService implements OwnerService {

	private final OwnerRepository ownerRepository;
	private final PetRepository petRepository;
	private final PetTypeRepository petTypeRepository;
	
	public OwnerJPAService(OwnerRepository ownerRepository, PetRepository petRepository,
			PetTypeRepository petTypeRepository) {
		super();
		this.ownerRepository = ownerRepository;
		this.petRepository = petRepository;
		this.petTypeRepository = petTypeRepository;
	}

	@Override
	public Set<Owner> findAll() {
		Set<Owner> owners = new HashSet<>();
		ownerRepository.findAll().forEach(owners::add);;
		
		return owners;
	}

	@Override
	public Owner findById(Long id) {
		
		Optional<Owner> ownerOptional = ownerRepository.findById(id);
		if (ownerOptional.isPresent()) {
			return ownerOptional.get();
		}
		else {
			return null;
		}
	}

	@Override
	public Owner save(Owner object) {
		
		return ownerRepository.save(object);
	}

	@Override
	public void delete(Owner object) {
		ownerRepository.delete(object);
		
	}

	@Override
	public void deleteById(Long id) {
		ownerRepository.deleteById(id);
		
	}

	@Override
	public Owner findByLastName(String lastName) {
		return ownerRepository.findByLastName(lastName);
		
	}

}
