package com.formation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.formation.exceptions.NotAuthorizedException;
import com.formation.persistence.entities.Adherent;
import com.formation.service.IAdherentService;
import com.formation.service.IAuthChecker;

@Component
public class AuthChecker implements IAuthChecker {

	@Autowired
	private IAdherentService adherentService;
	
	@Override
	public Adherent getCurrentUser() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			UserDetails ud = (UserDetails)principal;
			return adherentService.findByMail(ud.getUsername());
		} else {
			throw new NotAuthorizedException("NO CURRENT USER");
		}
	}
}
