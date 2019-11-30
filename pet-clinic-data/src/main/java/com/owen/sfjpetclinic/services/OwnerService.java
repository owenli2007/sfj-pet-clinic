package com.owen.sfjpetclinic.services;

import java.util.Set;

import com.owen.sfjpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

	public Owner findByLastName(String lastName);
	

}
