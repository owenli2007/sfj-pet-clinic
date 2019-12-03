package com.owen.sfjpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.owen.sfjpetclinic.model.Pet;

public interface PetTypeRepository extends CrudRepository<Pet, Long> {

}
