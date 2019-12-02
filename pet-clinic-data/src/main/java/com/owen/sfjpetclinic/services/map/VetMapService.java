package com.owen.sfjpetclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.owen.sfjpetclinic.model.Specialty;
import com.owen.sfjpetclinic.model.Vet;
import com.owen.sfjpetclinic.services.SpecialtyService;
import com.owen.sfjpetclinic.services.VetService;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

	private final SpecialtyService specialtyService;
	
	
	
	public VetMapService(SpecialtyService specialtyService) {
		super();
		this.specialtyService = specialtyService;
	}

	@Override
	public Vet save(Vet object) {
		// TODO Auto-generated method stub
		
		if (object.getSpecialities().size() > 0) {
			object.getSpecialities().forEach(specialty -> {
				if (specialty.getId() == null) {
					Specialty savedSpecialty = specialtyService.save(specialty);
					specialty.setId(savedSpecialty.getId());
				}
			});
		}
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
