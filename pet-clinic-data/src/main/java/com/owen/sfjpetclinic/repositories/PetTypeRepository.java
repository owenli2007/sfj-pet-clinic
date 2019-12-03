package com.owen.sfjpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.owen.sfjpetclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {

}
