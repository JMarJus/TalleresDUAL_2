package com.nttdata.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nttdata.persistence.Apartment;
import com.nttdata.persistence.Floor;
import com.nttdata.services.ApartmentServiceImpl;
import com.nttdata.services.FloorServiceImpl;

@Controller
@RequestMapping("*")
public class GeneralController {
	
	@Autowired
	public FloorServiceImpl floorService;
	
	@Autowired
	public ApartmentServiceImpl apartmentService;
	
	@GetMapping("/")
	public String testMethod() {
		return "index.html";
	}
	
	@GetMapping("/getIndex")
	public String getIndex() {
		return "index";
	}
	
	@GetMapping("/postBuildingSchema")
	public String buildSchema(Model floorModel, Model apartmentModel) {
		final List<Floor> floors = new ArrayList<>();
		final List<Apartment> apartments = new ArrayList<>();
		floors.addAll(floorService.getAllFloorsSortByLevel());
		apartments.addAll(apartmentService.getAllApartmentsSortByLetter());
		floorModel.addAttribute("floors", floors);
		apartmentModel.addAttribute("apartments", apartments);
		return "building";
	}
}
