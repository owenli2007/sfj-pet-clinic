package com.owen.sfjpetclinic.services;

import java.util.Set;

import com.owen.sfjpetclinic.model.Vet;

public interface VetService {

	public Set<Vet> findAll();
	
	public Vet findById(Long id);
	
	public Vet save(Vet pet);
}
