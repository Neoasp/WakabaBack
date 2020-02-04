package com.formation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formation.persistence.entities.Adherent;
import com.formation.persistence.repositories.IAdherentRepository;
import com.formation.service.IAdherentService;
import com.formation.service.common.AbstractService;


@Service
@Transactional
public class AdherentService extends AbstractService<Adherent> implements IAdherentService{

		@Autowired
		private IAdherentRepository repo;
		
		public JpaRepository<Adherent, Long> getRepo() {
			return repo;
		}

		@Override
		public List<Adherent> findByName(String name ) {
			return repo.findByName(name);
		}
		
		@Override
		public Adherent findByMail(String username) {
			return repo.findByMail(username);
		}
		}
