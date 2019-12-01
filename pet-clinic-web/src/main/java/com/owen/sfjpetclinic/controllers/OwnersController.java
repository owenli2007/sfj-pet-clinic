package com.owen.sfjpetclinic.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.owen.sfjpetclinic.model.Owner;
import com.owen.sfjpetclinic.services.OwnerService;

@Controller
public class OwnersController {

	private final OwnerService ownerService;
	
	
	public OwnersController(OwnerService ownerService) {
		super();
		this.ownerService = ownerService;
	}



	@RequestMapping({ "/owners", "/owners/", "/owners/index", "/owners/index.html"})
	public String listOwners(Model model) {
		Set<Owner> result = ownerService.findAll();
		System.out.println("Number of owners: " + result.size());
		
		List<Owner> owners = new ArrayList<>();
		owners.addAll(result);
		
		Iterator it = result.iterator();
		while (it.hasNext()) {
			Owner owner = (Owner)it.next();
			System.out.println("Owner: " + owner.getFirstName());
		}
		model.addAttribute("student", "All students");
		model.addAttribute("owners", ownerService.findAll());
		return "owners/index";
	}
}
