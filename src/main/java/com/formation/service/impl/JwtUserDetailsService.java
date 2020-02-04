package com.formation.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.formation.service.IAdherentService;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private IAdherentService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) {
		com.formation.persistence.entities.Adherent u = userService.findByMail(username);
		
		if (u != null) {
			return new User(u.getEmail(), u.getPassword(), new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
}