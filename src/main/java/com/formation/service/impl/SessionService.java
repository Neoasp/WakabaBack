package com.formation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formation.persistence.entities.Adherent;
import com.formation.persistence.entities.Session;
import com.formation.persistence.repositories.ISessionRepository;
import com.formation.service.ISessionService;
import com.formation.service.common.AbstractService;

@Service
@Transactional
public class SessionService extends AbstractService<Session> implements ISessionService {
	
	@Autowired
	private ISessionRepository repo;
	
	public JpaRepository<Session, Long> getRepo() {
		return repo;
	}
	
	@Override
	public List<Session> findByActivity(Long id ) {
		return repo.findByActivity(id);
	}

}
