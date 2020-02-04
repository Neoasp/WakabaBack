package com.formation.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.formation.persistence.entities.Session;
import com.formation.service.IInscriptionService;

@RestController
@RequestMapping(path = "api/private/inscr")
public class inscriptionController {
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private IInscriptionService service;
	
	@RequestMapping(path = "/list",method = RequestMethod.GET)
	public List<Session> getAll(){
		return service.findAll()
				.stream()
				.map(a -> mapper.map(a, Session.class) )
				.collect(Collectors.toList());
	}

}
