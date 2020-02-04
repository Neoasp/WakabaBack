package com.formation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formation.persistence.entities.Inscription;
import com.formation.persistence.repositories.IInscriptionRepository;
import com.formation.service.IInscriptionService;
import com.formation.service.common.AbstractService;

@Service
@Transactional
public class InscriptionService extends AbstractService<Inscription> implements IInscriptionService {
	
	@Autowired
	private IInscriptionRepository repo;
	
	public JpaRepository<Inscription, Long> getRepo() {
		return repo;
	}

	public Inscription findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(Inscription t) {
		// TODO Auto-generated method stub
		return false;
	}

	public Inscription save(Inscription t) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
