package com.example.cne.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cne.persistence.domain.Users;
import com.example.cne.persistence.repository.UserRepository;
import com.example.cne.rest.controller.DTO.UsersDTO;
import com.example.cne.service.exceptions.UserNotFoundException;

@Service
public class UserService {

	private UserRepository repo;
	private ModelMapper mapper;
	
	

	@Autowired
	public UserService(UserRepository repo, ModelMapper mapper) {
		super();
		this.repo = repo; 
		this.mapper = mapper; 
	}

	
	

	public UsersDTO create(Users users) {
		Users created = this.repo.save(users);
		UsersDTO converted = this.mapper.map(created,  UsersDTO.class);
		return converted;

	}	

	public UsersDTO  readById(Long id) {
		Users thingReadFromDb = this.repo.findById(id).orElseThrow(UserNotFoundException::new);
		UsersDTO converted = this.mapper.map(thingReadFromDb, UsersDTO.class); 
		return converted;

	}

	public List<UsersDTO> readAll() {
		List<Users> thingsReadFromDb = this.repo.findAll();
		List<UsersDTO> convertedList = thingsReadFromDb
				.stream()
				.map(x -> this.mapper.map(Users.class, UsersDTO.class))
				.collect(Collectors.toList());
		return convertedList; 
	}

	public UsersDTO updateById(Long id, UsersDTO newThing) {

		// grabs the thing we want to change from the db
		Users oldThing = this.repo.getOne(id);

		// here's the obect we want to plug in instead:
		oldThing.setfirstName(newThing.getFirstName());
		oldThing.setLastName(newThing.getLastName());
		oldThing.setPassportNumber(newThing.getPassportNumber());

		// saves changed object to db
		
		return this.mapper.map(this.repo.save(oldThing),UsersDTO.class);
	}

	public boolean deleteById(Long id) {
		// tries to delete object first
		this.repo.deleteById(id);

		// check if the delete worked
		return !this.repo.existsById(id);
	}

	 //findbyLastName
	public UsersDTO findByLastName(String lastName) {
		return this.mapper.map(this.repo.findUsersByLastName(lastName), UsersDTO.class);
	}
	//findbyLastname
	public UsersDTO findByFirstName(String firstName) {
		return this.mapper.map(this.repo.findUsersByFirstName(firstName), UsersDTO.class);
		
	}
	//findbyPassportNumber
	public UsersDTO findByPassportNumber(String passportNumber) {
		return this.mapper.map(this.repo.findUsersByPassportNumber(passportNumber), UsersDTO.class);
	}
	

	
}