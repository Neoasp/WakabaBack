package com.formation.service;

import com.formation.persistence.entities.Adherent;

public interface IAuthChecker {

	Adherent getCurrentUser();

}
