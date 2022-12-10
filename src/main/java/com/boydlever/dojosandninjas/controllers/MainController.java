package com.boydlever.dojosandninjas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.boydlever.dojosandninjas.models.Dojo;
import com.boydlever.dojosandninjas.services.DojoService;
import com.boydlever.dojosandninjas.services.NinjaService;

@Controller
public class MainController {

	@Autowired
	private NinjaService ninjaService;
	
	@Autowired
	private DojoService dojoService;
	
	//create dojo
	//display dojo form
	@GetMapping("/dojos/new")
	public String newDojoForm(@ModelAttribute("newDojo")Dojo newDojo) {
		return "createDojoForm.jsp";
	}
	//Process dojo form
}
