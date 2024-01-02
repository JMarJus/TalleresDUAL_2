package com.nttdata.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	
	@GetMapping("/getPersonSearch")
	public String personFilters() {
		return "filterPeople";
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
	
	@GetMapping("/postFilterPeople")
	public String filterPeople(Model model, Integer level, Character letter, String identityDoc, String name, String surname) {
		final Set<Person> people = new HashSet<>();
		boolean init = false;
		if (level != null) {
			init = peopleInitChecker(init, people, personService.getPersonByFloorLevel(level));
		}
		if (letter != null) {
			init = peopleInitChecker(init, people, personService.getPersonByApartmentLetter(letter));
		}
		if (identityDoc != null && !identityDoc.isBlank()) {
			init = personInitChecker(init, people, personService.getPersonByIdentityDoc(identityDoc));
		}
		if (name != null && !name.isBlank()) {
			init = peopleInitChecker(init, people, personService.getPersonByName(name));
		}
		if(surname != null && !surname.isBlank()) {
			peopleInitChecker(init, people, personService.getPersonBySurname(surname));
		}
		model.addAttribute("people", people);
		return "people";
	}
	
	private <Optional>boolean peopleInitChecker(boolean init, Set<Person> people, List<Person> newPeople) {
		if (init) {
			for (Person person: newPeople) {
				if (!people.contains(person)) {
					people.remove(person);
				}
			}
		} else {
			people.addAll(newPeople);
		}
		return true;
	}
	
	private <Optional>boolean personInitChecker(boolean init, Set<Person> people, Person person) {
		if (person == null) {
			return true;
		}
		if (init) {
			if (!people.contains(person)) {
				people.remove(person);
			}
		} else {
			people.add(person);
		}
		return true;
	}
	
}
