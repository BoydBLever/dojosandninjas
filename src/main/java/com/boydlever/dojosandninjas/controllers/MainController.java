package com.boydlever.dojosandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.boydlever.dojosandninjas.models.Dojo;
import com.boydlever.dojosandninjas.models.Ninja;
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
	@PostMapping("/dojos/new")
	public String processDojoForm(
			@Valid @ModelAttribute("newDojo")Dojo newDojo, BindingResult result) {
		if(result.hasErrors()) {
			return "createDojoForm.jsp";
		}else {
			dojoService.createDojo(newDojo);
			return "redirect:/";
		}
	}
	//create Ninjas
	//Display form
	@GetMapping("/ninjas/new")
	public String newNinjaForm(@ModelAttribute("newNinja")Ninja newNinja,
			Model model) {
		List<Dojo> dojoList = dojoService.allDojos();
		model.addAttribute("dojoList", dojoList);
 		return "createNinjaForm.jsp";
	}
	//Process ninja form
	@PostMapping("/ninjas/new")
	public String processNinjaForm(@Valid @ModelAttribute("newNinja")Ninja newNinja,
		BindingResult result, Model model){
			if(result.hasErrors()) {
				List<Dojo> dojoList = dojoService.allDojos();
				model.addAttribute("dojoList", dojoList);
				return "createNinjaForm.jsp";
			} else {
				ninjaService.createNinja(newNinja);
				return "redirect:/";
			}
		}
	//oneDojo
	@GetMapping("/")
	public String ninjaDashboard(Model model) {
		model.addAttribute("dojoList", dojoService.allDojos());
		model.addAttribute("ninjaList", ninjaService.allNinjas());
		return "oneDojo.jsp";
	}
}

