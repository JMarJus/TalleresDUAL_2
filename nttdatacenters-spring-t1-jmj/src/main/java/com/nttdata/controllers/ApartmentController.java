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
	
	@PostMapping("/postAddApartment")
	public String newApartment(Apartment apartment, Model model) {
		apartmentService.newApartment(apartment);
		return showApartments(model);
	}
	
	@PostMapping("/postRemoveApartment")
	@Transactional
	public String removeApartment(@RequestParam(value="id") Long id, Model model) {
		apartmentService.removeApartmentById(id);
		return showApartments(model);
	}
	
}