package com.example.cne.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Users {
	
	//variables
	
	@Id // primary key 
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment 
	private Long id;

	@Column(nullable = false, unique = true)
	private String passportNumber;
	
	@Column
	@NotNull
	private String firstName;
	
	@Column  
	@NotNull
	private String lastName;
	 
	//constructors
	public Users(String passportNumber, String firstName, String lastName) {
		super();
		this.passportNumber = passportNumber;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	// getters / setters  
	public void setId(Long id) {
		this.id = id;	
	}
	public Users() {
	}

	public Long getId() {
		return id;
	}
	
	public String getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	public String getfirstName() {
		return firstName;
	}
	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
//to string 
	@Override
	public String toString() {
		return "Users [id=" + id + ", PassportNumber=" + passportNumber + ", FirstName=" + firstName + ", LastName="
				+ lastName + "]";
	}

	
}