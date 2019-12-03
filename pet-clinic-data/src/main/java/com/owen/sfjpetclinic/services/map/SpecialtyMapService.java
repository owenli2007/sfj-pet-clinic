package com.owen.sfjpetclinic.services.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.owen.sfjpetclinic.model.Specialty;
import com.owen.sfjpetclinic.services.SpecialtyService;;

@Service
@Profile({"default", "map"})
public class SpecialtyMapService extends AbstractMapService<Specialty, Long> implements SpecialtyService {
	@Override
	public Specialty save(Specialty object) {
		// TODO Auto-generated method stub
		return super.save(object);
	}
	
	@Override
	public Set<Specialty> findAll() {
		return super.findAll();
	}
	
	@Override
	public Specialty findById(Long id) {
		return super.findById(id);
	}
	
	@Override
	public void delete(Specialty object) {
		super.delete(object);
	}
	
	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}
}
