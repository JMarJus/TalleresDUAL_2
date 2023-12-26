package com.nttdata.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("*")
public class AssignmentController {
	
	@GetMapping("/")
	public String testMethod() {
		return "index.html";
	}
	
	@GetMapping("/getIndex")
	public String getIndex() {
		return "index";
	}
}