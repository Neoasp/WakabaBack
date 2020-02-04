package com.formation.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formation.config.JwtTokenUtil;
import com.formation.dto.AdherentLight;
import com.formation.dto.JwtRequest;
import com.formation.dto.JwtResponse;
import com.formation.exceptions.NotAuthorizedException;
import com.formation.service.IAdherentService;

@RestController
@RequestMapping(path ="api/public")
public class publicController {
	
	@Autowired
	private IAdherentService adherentService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private ModelMapper mapper;
	
	@PostMapping(value = "/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
			final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
			final String token = jwtTokenUtil.generateToken(userDetails);
			return ResponseEntity.ok(new JwtResponse(token));
		} catch (DisabledException | BadCredentialsException e) {
			throw new NotAuthorizedException(e.getMessage());
		}		
	}
	@GetMapping(path = "/adherent")
	public List<AdherentLight> findAll() {
		return adherentService.findAll()
				.stream()
				.map(u -> mapper.map(u, AdherentLight.class))
				.collect(Collectors.toList());
	}

}
