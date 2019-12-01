package com.owen.sfjpetclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.owen.sfjpetclinic.model.Vet;
import com.owen.sfjpetclinic.services.VetService;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

	@Override
	public Vet save(Vet object) {
		// TODO Auto-generated method stub
		return super.save(object);
	}
	
	@Override
	public Set<Vet> findAll() {
		return super.findAll();
	}
	
	@Override
	public Vet findById(Long id) {
		return super.findById(id);
	}
	
	@Override
	public void delete(Vet object) {
		super.delete(object);
	}
	
	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

}
