package com.nttdata.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("*")
public class ApartmentController {
	
	@GetMapping("/viewApartment")
	public String addPerson() {
		return "viewApartment";
	}
	
}