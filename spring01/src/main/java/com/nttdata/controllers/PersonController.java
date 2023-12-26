package com.nttdata.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nttdata.persistence.Person;
import com.nttdata.services.ApartmentServiceImpl;
import com.nttdata.services.PersonServiceImpl;

@Controller
@RequestMapping("*")
public class PersonController {
	
	@Autowired
	public PersonServiceImpl personService;
	
	@Autowired
	public ApartmentServiceImpl apartmentService;
	
	@GetMapping("/getAddPerson")
	public String addPerson() {
		return "addPerson";
	}
	
	@GetMapping("/getPeople")
	public String showPeople(Model model) {
		final List<Person> people = personService.getAllPeople();
		model.addAttribute("people", people);
		return "people";
	}
	
	@PostMapping("/postAddPerson")
	public String newPerson(Person person, Model model) {
		if (apartmentService.getApartmentById(person.getApartmentId()).isPresent()) {
			personService.newPerson(person);
			return showPeople(model);
		} else {
			return showPeople(model);
		}
	}
	
	@PostMapping("/postRemovePerson")
	@Transactional
	public String removePerson(@RequestParam(value="id") Long id, Model model) {
		personService.removePersonById(id);
		return showPeople(model);
	}
	
}
