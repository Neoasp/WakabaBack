package com.formation.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.formation.persistence.entities.Session;
import com.formation.service.common.IServiceActions;

@Transactional
public interface ISessionService extends IServiceActions<Session> {
	public List<Session> findByActivity(Long id);
	

}
