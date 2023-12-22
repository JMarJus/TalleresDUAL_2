package com.nttdata.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("*")
public class PersonController {
	
	@GetMapping("/getAddPerson")
	public String addPerson() {
		return "addPerson";
	}
	
	@GetMapping("/getPeople")
	public String showPeople() {
		return "people";
	}
	
	@PostMapping("postAddPerson")
	public String newPerson() {
		return "people";
	}
	
}
