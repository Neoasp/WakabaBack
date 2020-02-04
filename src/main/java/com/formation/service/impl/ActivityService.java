package com.formation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formation.persistence.entities.Activity;
import com.formation.persistence.repositories.IActivityRepository;
import com.formation.service.IActivityService;
import com.formation.service.common.AbstractService;

@Service
@Transactional
public class ActivityService extends AbstractService<Activity> implements IActivityService{
	
	@Autowired
	private IActivityRepository repo;
	
	public JpaRepository<Activity, Long> getRepo() {
		return repo;
	}

}
