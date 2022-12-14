package com.boydlever.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boydlever.dojosandninjas.models.Dojo;
import com.boydlever.dojosandninjas.repositories.DojoRepository;

@Service
public class DojoService {
	
	@Autowired
	private DojoRepository dojoRepo;
	
	//create dojo
	public Dojo createDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
	//find one dojo
		public Dojo oneDojo(Long id) {
			Optional<Dojo> optionalDojo = dojoRepo.findById(id);
			if(optionalDojo.isPresent()) {
				return optionalDojo.get();
			} else {
				return null;
			}
		}
		//find all dojos
		public List<Dojo> allDojos(){
			return dojoRepo.findAll();
		}
}
