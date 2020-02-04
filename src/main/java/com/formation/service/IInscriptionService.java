package com.formation.service;

import org.springframework.transaction.annotation.Transactional;

import com.formation.persistence.entities.Inscription;
import com.formation.service.common.IServiceActions;

@Transactional
public interface IInscriptionService extends IServiceActions<Inscription> {

}
