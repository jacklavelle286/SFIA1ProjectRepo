package com.example.cne.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cne.persistence.domain.Users;
import com.example.cne.persistence.repository.UserRepository;

@Service
public class UserService {

	public UserRepository repo;

	@Autowired
	public UserService(UserRepository repo) {
		super();
		this.repo = repo;
	}

	// methods
	
	

	public Users create(Users users) {
		Users created = this.repo.save(users);
		return created;

	}

	public Users readById(Long id) {
		Users thingReadFromDb = this.repo.getOne(id);
		return thingReadFromDb;

	}

	public List<Users> readAll() {
		List<Users> thingsReadFromDb = this.repo.findAll();
		return thingsReadFromDb;
	}

	public Users updateById(Long id, Users newThing) {

		// grabs the thing we want to change from the db
		Users oldThing = this.repo.getOne(id);

		// here's the obect we want to plug in instead:
		oldThing.setfirstName(newThing.getfirstName());
		oldThing.setLastName(newThing.getLastName());
		oldThing.setPassportNumber(newThing.getPassportNumber());

		// saves changed object to db
		return this.repo.save(oldThing);
	}

	public boolean deleteById(Long id) {
		// tries to delete object first
		this.repo.deleteById(id);

		// check if the delete worked
		return !this.repo.existsById(id);
	}

	 //findbyLastName
	public Users findByLastName(String lastName) {
		return this.repo.findUsersByLastName(lastName);
	}
	//findbyLastname
	public Users findByFirstName(String firstName) {
		return this.repo.findUsersByFirstName(firstName);
		
	}
	//findbyPassportNumber
	public Users findByPassportNumber(String passportNumber) {
		return this.repo.findUsersByPassportNumber(passportNumber);
	}
	

	
}