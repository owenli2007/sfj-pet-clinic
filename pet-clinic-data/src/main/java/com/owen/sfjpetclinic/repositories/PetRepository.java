package com.owen.sfjpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.owen.sfjpetclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {

}
