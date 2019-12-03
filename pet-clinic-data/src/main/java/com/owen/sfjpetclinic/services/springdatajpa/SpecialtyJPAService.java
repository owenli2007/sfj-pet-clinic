package com.owen.sfjpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.owen.sfjpetclinic.model.Specialty;
import com.owen.sfjpetclinic.repositories.SpecialtyRepository;
import com.owen.sfjpetclinic.services.SpecialtyService;

@Service
@Profile("springdatajpa")
public class SpecialtyJPAService implements  SpecialtyService{

	private final SpecialtyRepository specialtyRepository;
	
	
	public SpecialtyJPAService(SpecialtyRepository specialtyRepository) {
		super();
		this.specialtyRepository = specialtyRepository;
	}

	@Override
	public Set<Specialty> findAll() {
		Set<Specialty> specialties = new HashSet<>();
		specialtyRepository.findAll().forEach(specialties::add);;
		
		return specialties;
	}

	@Override
	public Specialty findById(Long id) {
		Optional<Specialty> specialtyOptional = specialtyRepository.findById(id);
		if (specialtyOptional.isPresent()) {
			return specialtyOptional.get();
		}
		else {
			return null;
		}
	}

	@Override
	public Specialty save(Specialty object) {
		return specialtyRepository.save(object);
	}

	@Override
	public void delete(Specialty object) {
		specialtyRepository.delete(object);
		
	}

	@Override
	public void deleteById(Long id) {
		specialtyRepository.deleteById(id);
		
	}

}
