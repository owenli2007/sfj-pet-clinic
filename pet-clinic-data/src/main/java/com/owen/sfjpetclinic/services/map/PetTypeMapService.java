package com.owen.sfjpetclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.owen.sfjpetclinic.model.Pet;
import com.owen.sfjpetclinic.model.PetType;
import com.owen.sfjpetclinic.services.PetTypeService;

@Service
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {
	@Override
	public PetType save(PetType object) {
		// TODO Auto-generated method stub
		return super.save(object);
	}
	
	@Override
	public Set<PetType> findAll() {
		return super.findAll();
	}
	
	@Override
	public PetType findById(Long id) {
		return super.findById(id);
	}
	
	@Override
	public void delete(PetType object) {
		super.delete(object);
	}
	
	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

}
