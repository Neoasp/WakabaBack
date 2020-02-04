package com.formation.service;

import java.util.List;

import com.formation.persistence.entities.Adherent;
import com.formation.service.common.IServiceActions;

public interface IAdherentService extends IServiceActions<Adherent> {

	public List<Adherent> findByName(String name);
	Adherent findByMail(String userName);
}
