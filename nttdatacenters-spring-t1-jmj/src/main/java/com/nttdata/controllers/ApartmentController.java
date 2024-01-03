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

import com.nttdata.persistence.Apartment;
import com.nttdata.services.ApartmentServiceImpl;
import com.nttdata.services.FloorServiceImpl;

@Controller
@RequestMapping("*")
public class ApartmentController {
	
	@Autowired
	public ApartmentServiceImpl apartmentService;
	
	@Autowired
	public FloorServiceImpl floorService;
	
	@GetMapping("/getAddApartment")
	public String addApartment() {
		return "addApartment";
	}
	
	@GetMapping("/getApartments")
	public String showApartments(Model model) {
		final List<Apartment> apartments = apartmentService.getAllApartments();
		model.addAttribute("apartments", apartments);
		return "apartments";
	}
	
	@GetMapping("/getApartmentSearch")
	public String apartmentFilters() {
		return "filterApartments";
	}
	
	@PostMapping("/postAddApartment")
	public String newApartment(Integer level, Character letter, Model model) {
		if (floorService.getFloorByLevel(level) != null) {
			if (apartmentService.getApartmentByFloorLevelAndLetter(level, letter) == null) {
				Apartment newApartment = new Apartment();
				newApartment.setFloorId(floorService.getFloorByLevel(level).getId());
				newApartment.setLetter(letter);
				apartmentService.newApartment(newApartment);
				return showApartments(model);
			} else {
				return errorScreen("There is already an apartment \'" + letter + "\' for \'Floor " + level + "\'", model);
			}
		} else {
			return errorScreen("There is no \'Floor " + level + "\'", model);
		}
	}
	
	@PostMapping("/postRemoveApartment")
	@Transactional
	public String removeApartment(@RequestParam(value="id") Long id, Model model) {
		apartmentService.removeApartmentById(id);
		return showApartments(model);
	}
	
	@GetMapping("/getFilterApartments")
	public String filterApartments(Model model, Integer level, Character letter, String identityDoc) {
		final Set<Apartment> apartments = new HashSet<>();
		boolean init = false;
		if(level != null) {
			init = apartmentsInitChecker(init, apartments, apartmentService.getApartmentByFloorLevel(level));
		}
		if(letter != null) {
			init = apartmentsInitChecker(init, apartments, apartmentService.getApartmentByLetter(letter));
		}
		if(identityDoc != null && !identityDoc.isBlank()) {
			apartmentInitChecker(init, apartments, apartmentService.getApartmentByPersonIdentityDoc(identityDoc));
		}
		model.addAttribute("apartments", apartments);
		return "apartments";
	}
	
	private boolean apartmentsInitChecker(boolean init, Set<Apartment> apartments, List<Apartment> newApartments) {
		if (init) {
			for (Apartment apartment: newApartments) {
				if (!apartments.contains(apartment)) {
					apartments.remove(apartment);
				}
			}
		} else {
			apartments.addAll(newApartments);
		}
		return true;
	}
	
	private boolean apartmentInitChecker(boolean init, Set<Apartment> apartments, Apartment apartment) {
		if (apartment == null) {
			if (init) {
				if (!apartments.contains(apartment)) {
					apartments.remove(apartment);
				}
			} else {
				apartments.add(apartment);
			}
		}
		return true;
	}
	
	private String errorScreen(String message, Model model) {
		model.addAttribute("message", message);
		return "error";
	}
	
}
