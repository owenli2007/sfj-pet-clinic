package com.owen.sfjpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OwnersController {

	@RequestMapping({ "/owners", "/owners/", "/owners/index", "/owners/index.html"})
	public String index() {
		return "owners/index";
	}
}
