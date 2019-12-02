package com.owen.sfjpetclinic.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.owen.sfjpetclinic.model.Owner;
import com.owen.sfjpetclinic.model.Vet;
import com.owen.sfjpetclinic.services.VetService;

@Controller
public class VetsController {
	
	private VetService vetService;
	
	
	public VetsController(VetService vetService) {
		super();
		this.vetService = vetService;
	}



	@RequestMapping({ "/vets", "/vets/", "/vets/index", "/vets/index.html", "/vets.html"})
	public String index(Model model) {
		Set<Vet> result = vetService.findAll();
		System.out.println("Number of vets: " + result.size());
		
		List<Vet> vets = new ArrayList<>();
		vets.addAll(result);
		
		Iterator it = result.iterator();
		while (it.hasNext()) {
			Vet vet = (Vet)it.next();
			System.out.println("Owner: " + vet.getFirstName());
		}
		
		model.addAttribute("vets", vetService.findAll());
		return "vets/index";
	}
}
