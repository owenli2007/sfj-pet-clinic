package com.owen.sfjpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.owen.sfjpetclinic.model.Vet;
import com.owen.sfjpetclinic.repositories.VetRepository;
import com.owen.sfjpetclinic.services.VetService;

@Service
@Profile("springdatajpa")
public class VetJPAService implements  VetService{

	private final VetRepository vetRepository;
	
	
	public VetJPAService(VetRepository vetRepository) {
		super();
		this.vetRepository = vetRepository;
	}

	@Override
	public Set<Vet> findAll() {
		Set<Vet> vets = new HashSet<>();
		vetRepository.findAll().forEach(vets::add);;
		
		return vets;
	}

	@Override
	public Vet findById(Long id) {
		Optional<Vet> vetOptional = vetRepository.findById(id);
		if (vetOptional.isPresent()) {
			return vetOptional.get();
		}
		else {
			return null;
		}
	}

	@Override
	public Vet save(Vet object) {
		return vetRepository.save(object);
	}

	@Override
	public void delete(Vet object) {
		vetRepository.delete(object);
		
	}

	@Override
	public void deleteById(Long id) {
		vetRepository.deleteById(id);
		
	}

}
