package com.formation.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.formation.persistence.entities.Activity;
import com.formation.persistence.repositories.IActivityRepository;

@RestController
@RequestMapping(path = "api/private/activity")
public class activityController {
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private IActivityRepository service;
	
	@RequestMapping(path = "/list",method = RequestMethod.GET)
	public List<Activity> getAll(){
		return service.findAll()
				.stream()
				.map(a -> mapper.map(a, Activity.class) )
				.collect(Collectors.toList());
	}

}
