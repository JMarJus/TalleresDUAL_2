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

import com.nttdata.persistence.Floor;
import com.nttdata.services.FloorServiceImpl;

@Controller
@RequestMapping("*")
public class FloorController {
	
	@Autowired
	public FloorServiceImpl floorService;
	
	@GetMapping("/getAddFloor")
	public String addFloor() {
		return "addFloor";
	}
	
	@GetMapping("/getFloors")
	public String showFloors(Model model) {
		final List<Floor> floors = floorService.getAllFloors();
		model.addAttribute("floors", floors);
		return "floors";
	}
	
	@PostMapping("/postAddFloor")
	public String newFloor(Floor floor, Model model) {
		floorService.newFloor(floor);
		return showFloors(model);
	}
	
	@PostMapping("/postRemoveFloor")
	@Transactional
	public String removeFloor(@RequestParam(value="id") Long id, Model model) {
		floorService.removeFloorById(id);
		return showFloors(model);
	}
	
}
