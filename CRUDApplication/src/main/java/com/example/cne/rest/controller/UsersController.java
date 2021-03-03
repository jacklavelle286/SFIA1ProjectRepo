package com.example.cne.rest.controller;

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

import com.example.cne.persistence.domain.Users;
import com.example.cne.service.UserService;

@RestController
@RequestMapping("/users")
public class UsersController {
	
	//@Autowired 
	// passes things to the service.
	public UserService service;

	@Autowired
	public UsersController(UserService service) {
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
	public ResponseEntity<Users> read(@PathVariable Long id) {
		Users returnedObject = this.service.readById(id);
		return ResponseEntity.ok(returnedObject);

	}
	// findbyLastName
	@GetMapping("/read/bylastName/{lastName}")
	public ResponseEntity<Users> findByLastName(@PathVariable String lastName) {
		Users found = this.service.findByLastName(lastName);
		return ResponseEntity.ok(found);
		
	}
	//findbyFirstName
	@GetMapping("/read/byfirstName/{firstName}")
	public ResponseEntity<Users> findByFirstName(@PathVariable String firstName) {
		Users found = this.service.findByFirstName(firstName); 
		return ResponseEntity.ok(found);
	
}
	
	//findByPassportNumber
	@GetMapping("/read/bypassportNumber/{passportNumber}")
	public ResponseEntity<Users> findByPassportNumber(@PathVariable String passportNumber) {
		Users found = this.service.findByPassportNumber(passportNumber);
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
		Users updatedObject = this.service.updateById(id, users);
		return new ResponseEntity<>(updatedObject, HttpStatus.ACCEPTED); // 202
	}

	// deleteById
	@DeleteMapping("/delete{id}")
	public ResponseEntity<Users> deleteById(@PathVariable Long id) {
		if (this.service.deleteById(id)) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
		}
	}
