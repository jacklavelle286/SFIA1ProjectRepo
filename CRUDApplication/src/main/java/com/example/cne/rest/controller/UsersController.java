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
import com.example.cne.rest.controller.DTO.UsersDTO;
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
	public ResponseEntity<UsersDTO> create(@RequestBody Users users) {
		UsersDTO createdObject = this.service.create(users);
		return new ResponseEntity<>(createdObject, HttpStatus.CREATED); // 201
	}

	// readById
	@GetMapping("/read/{id}")
	public ResponseEntity<UsersDTO> read(@PathVariable Long id) {
		UsersDTO returnedObject = this.service.readById(id);
		return ResponseEntity.ok(returnedObject);

	}
	// findbyLastName
	@GetMapping("/read/bylastName/{lastName}")
	public ResponseEntity<UsersDTO> findByLastName(@PathVariable String lastName) {
		UsersDTO found = this.service.findByLastName(lastName);
		return ResponseEntity.ok(found);
		
	}
	//findbyFirstName
	@GetMapping("/read/byfirstName/{firstName}")
	public ResponseEntity<UsersDTO> findByFirstName(@PathVariable String firstName) {
		UsersDTO found = this.service.findByFirstName(firstName); 
		return ResponseEntity.ok(found);
	
}
	
	//findByPassportNumber
	@GetMapping("/read/bypassportNumber/{passportNumber}")
	public ResponseEntity<UsersDTO> findByPassportNumber(@PathVariable String passportNumber) {
		UsersDTO found = this.service.findByPassportNumber(passportNumber);
		return ResponseEntity.ok(found);
		
	}
	// readAll
	@GetMapping("/readAll")
	public ResponseEntity<List<UsersDTO>> readAll() {
		return ResponseEntity.ok(this.service.readAll()); // 200
	}

	// updateById
	@PutMapping("/update/{id}")
	public ResponseEntity<UsersDTO> updateById(@PathVariable Long id, @RequestBody UsersDTO usersDto) {
		UsersDTO updatedObject = this.service.updateById(id, usersDto);
		return new ResponseEntity<>(updatedObject, HttpStatus.ACCEPTED); // 202
	}

	// deleteById		
	@DeleteMapping("/delete{id}")
	public ResponseEntity<UsersDTO> deleteById(@PathVariable Long id) {
		if (this.service.deleteById(id)) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
		}
	}
