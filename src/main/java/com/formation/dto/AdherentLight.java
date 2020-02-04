package com.formation.dto;



public class AdherentLight {
	
	
	private Long id;
	
	private String lastName;
	
	private String firstName;
	
	public AdherentLight() {
		
	}

	public AdherentLight(Long id, String lastName, String firstName) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	

}
