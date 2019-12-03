package com.owen.sfjpetclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.owen.sfjpetclinic.model.Owner;
import com.owen.sfjpetclinic.model.Pet;
import com.owen.sfjpetclinic.model.PetType;
import com.owen.sfjpetclinic.model.Specialty;
import com.owen.sfjpetclinic.model.Vet;
import com.owen.sfjpetclinic.model.Visit;
import com.owen.sfjpetclinic.services.OwnerService;
import com.owen.sfjpetclinic.services.PetTypeService;
import com.owen.sfjpetclinic.services.SpecialtyService;
import com.owen.sfjpetclinic.services.VetService;
import com.owen.sfjpetclinic.services.VisitService;
import com.owen.sfjpetclinic.services.map.OwnerMapService;
import com.owen.sfjpetclinic.services.map.VetMapService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final SpecialtyService specialtyService;
	private final VisitService visitService;
	
	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, 
			SpecialtyService specialtyService, VisitService visitService) {

		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialtyService = specialtyService;
		this.visitService = visitService;
	}



	@Override
	public void run(String... args) throws Exception {
		
		int count = petTypeService.findAll().size();
		
		if (count == 0) {
			loadData();
		}
	}



	private void loadData() {
		PetType dog = new PetType();
		dog.setName("Dog");
		PetType savedDogType = petTypeService.save(dog);
		
		PetType cat = new PetType();
		dog.setName("Cat");
		PetType savedCatType = petTypeService.save(cat);
		
		System.out.println("Loaded PetTypes...");
		
		Specialty radiologySpecialty = new Specialty();
		radiologySpecialty.setDescription("Radiology");
		Specialty savedRadiology = specialtyService.save(radiologySpecialty);
		
		Specialty surgerySpecialty = new Specialty();
		surgerySpecialty.setDescription("Surgery");
		Specialty savedSurgery = specialtyService.save(surgerySpecialty);
		
		Specialty dentistrySpecialty = new Specialty();
		dentistrySpecialty.setDescription("Dentistry");
		Specialty savedDentistry = specialtyService.save(dentistrySpecialty);
		
		System.out.println("Loaded Specialties...");
		
		Owner owner1 = new Owner();
		owner1.setFirstName("Michael");
		owner1.setLastName("Weston");
		owner1.setAddress("123 Brickerel");
		owner1.setCity("Miami");
		owner1.setTelephone("1231231234");
		
		Pet mikesPet = new Pet();
		mikesPet.setPetType(savedDogType);
		mikesPet.setOwner(owner1);
		mikesPet.setBirthDate(LocalDate.now());
		mikesPet.setName("Rosco");
		owner1.getPets().add(mikesPet);
		
		ownerService.save(owner1);
		
		Owner owner2 = new Owner();
		owner2.setFirstName("Fiona");
		owner2.setLastName("Glenanne");
		owner1.setAddress("123 Brickerel");
		owner1.setCity("Miami");
		owner1.setTelephone("1231231234");
		
		Pet fionaPet = new Pet();
		fionaPet.setPetType(savedCatType);
		fionaPet.setOwner(owner2);
		fionaPet.setBirthDate(LocalDate.now());
		fionaPet.setName("Just Cat");
		owner2.getPets().add(fionaPet);
		
		ownerService.save(owner2);
		
		System.out.println("Loaded Owners...");
		
		Vet vet1 = new Vet();
		vet1.setFirstName("Sam");
		vet1.setLastName("Axe");
		vet1.getSpecialities().add(savedRadiology);
		vetService.save(vet1);
		
		Vet vet2 = new Vet();
		vet2.setFirstName("Jessie");
		vet2.setLastName("Porter");
		vet2.getSpecialities().add(savedDentistry);
		vetService.save(vet2);
		
		System.out.println("Loaded Vets...");
		
		Visit visit1 = new Visit();
		visit1.setPet(mikesPet);
		visit1.setDate(LocalDate.now());
		visit1.setDescription("Tiger");
		visitService.save(visit1);
		
		Visit visit2 = new Visit();
		visit2.setPet(fionaPet);
		visit2.setDate(LocalDate.now());
		visit2.setDescription("Sneezy Kitty");
		visitService.save(visit2);
		
		System.out.println("Loaded Visits...");
	}

}
