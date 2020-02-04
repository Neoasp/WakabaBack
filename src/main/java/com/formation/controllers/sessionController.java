package com.formation.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.formation.exceptions.UnknownException;
import com.formation.persistence.entities.Session;
import com.formation.service.ISessionService;

@RestController
@RequestMapping(path ="api/private/session")
public class sessionController {
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private ISessionService service;
	
	@RequestMapping(path = "/list",method = RequestMethod.GET)
	public List<Session> getAll(){
		return service.findAll()
				.stream()
				.map(a -> mapper.map(a, Session.class) )
				.collect(Collectors.toList());
	}
	
	@GetMapping(path= "/{activity}")
	public List<Session> findByActivity(@PathVariable(name= "activity")Long id){
		try {
			return service.findByActivity(id);
		} catch (Exception e) {
			throw new UnknownException(e.getMessage());
		}
	}
	
}
