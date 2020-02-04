package com.formation.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.formation.dto.AdherentLight;
import com.formation.exceptions.UnknownException;
import com.formation.persistence.entities.Adherent;
import com.formation.service.IAdherentService;
import com.formation.service.IAuthChecker;

@RestController

@RequestMapping(path = "api/private/adherent")
public class adherentController {
	
	@Autowired
	private IAuthChecker authChecker;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private IAdherentService service;
	
	@RequestMapping(path = "/list",method = RequestMethod.GET)
	public List<AdherentLight> getAll(){
		//Adherent me = authChecker.getCurrentUser();
		
		//System.out.println("Called by " + me.getLastName() + " " + me.getFirstName());
		return service.findAll()
				.stream()
				.map(a -> mapper.map(a, AdherentLight.class) )
				.collect(Collectors.toList());
	}

	@GetMapping(path="/nom/{nom}")
	public List<Adherent> findByName(@PathVariable(name = "nom") String name) {
		try {
			return service.findByName(name);
		} catch (Exception e) {
			throw new UnknownException(e.getMessage());
		}

}
}