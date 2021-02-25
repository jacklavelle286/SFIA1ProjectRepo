package com.qa.cne.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.cne.persistence.domain.Users;
import com.qa.cne.service.Userservice;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/Users")
public class usercontroller {

	// passes things to the service.
	private Userservice service;

	@Autowired
	public usercontroller(Userservice service) {
		super();
		this.service = service;
	}

	// create
	@PostMapping("/create")
	public ResponseEntity<Users> create(@RequestBody Users users) {
		Users createdObject = this.service.create(users);
		return new ResponseEntity<>(createdObject, HttpStatus.CREATED); // 201
	}

	// readById
	@GetMapping("/read/{id}")
	public ResponseEntity<Users> readById(@PathVariable Long id) {
		Users returnedObject = this.service.readById(id);
		return ResponseEntity.ok(returnedObject);

	}

	// findByFirstName
	@GetMapping("/read/byFirstName/{FirstName}")
	public ResponseEntity<Users> findByFirstName(@PathVariable String FirstName) {
		Users found = this.service.findByFirstName(FirstName);
		return ResponseEntity.ok(found);
	}

	// findByLastName
	@GetMapping("read/byLastName/{LastName}")
	public ResponseEntity<Users> findByLastName(@PathVariable String LastName) {
		Users found = this.service.findByLastName(LastName);
		return ResponseEntity.ok(found);
	}

	// findByPassPortNumber
	@GetMapping("read/byLastName/{PassportNumber}")
	public ResponseEntity<Users> findByPassportNumber(@PathVariable String PassportNumber) {
		Users found = this.service.findByPassportNumber(PassportNumber);
		return ResponseEntity.ok(found);
	}

	// readAll
	@GetMapping("/readAll")
	public ResponseEntity<List<Users>> readAll() {
		return ResponseEntity.ok(this.service.readAll()); // 200
	}

	// updateById
	@PutMapping("/update/{id}")
	public ResponseEntity<Users> updateById(@PathVariable Long id, @RequestBody Users users) {
		Users updatedObject = null;
		updatedObject = this.service.updateById(id, updatedObject);
		return new ResponseEntity<>(updatedObject, HttpStatus.ACCEPTED); // 202
	}
//delete by id
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Users> deleteById(@PathVariable Long id) {
		if (this.service.deleteById(id)) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // 503
		}
	}
}






