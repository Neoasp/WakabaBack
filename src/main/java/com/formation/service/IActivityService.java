package com.formation.service;

import org.springframework.transaction.annotation.Transactional;

import com.formation.persistence.entities.Activity;
import com.formation.service.common.IServiceActions;

@Transactional
public interface IActivityService extends IServiceActions<Activity> {

}
