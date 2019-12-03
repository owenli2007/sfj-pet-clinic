package com.owen.sfjpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.owen.sfjpetclinic.model.Visit;
import com.owen.sfjpetclinic.repositories.VisitRepository;
import com.owen.sfjpetclinic.services.VisitService;

@Service
@Profile("springdatajpa")
public class VisitJPAService implements  VisitService{

	private final VisitRepository visitRepository;
	
	
	public VisitJPAService(VisitRepository visitRepository) {
		super();
		this.visitRepository = visitRepository;
	}

	@Override
	public Set<Visit> findAll() {
		Set<Visit> vets = new HashSet<>();
		visitRepository.findAll().forEach(vets::add);;
		
		return vets;
	}

	@Override
	public Visit findById(Long id) {
		Optional<Visit> visitOptional = visitRepository.findById(id);
		if (visitOptional.isPresent()) {
			return visitOptional.get();
		}
		else {
			return null;
		}
	}

	@Override
	public Visit save(Visit object) {
		return visitRepository.save(object);
	}

	@Override
	public void delete(Visit object) {
		visitRepository.delete(object);
		
	}

	@Override
	public void deleteById(Long id) {
		visitRepository.deleteById(id);
		
	}

}
