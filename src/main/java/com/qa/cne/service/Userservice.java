package com.qa.cne.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.cne.persistence.domain.Users;
import com.qa.cne.persistence.repository.UsersRepository;
import com.qa.cne.service.exceptions.Usernotfoundexception;


@SuppressWarnings("unused")
@Service
public class Userservice {

	private UsersRepository repo;

	@Autowired
	public Userservice(UsersRepository repo) {
		super();
		this.repo = repo;
	}

	// methods

	public Users create(Users users) {
		Users created = this.repo.save(users);
		return created;
	}

	public Users readById(Long id) {
		Users thingReadFromDb = this.repo.findById(id).orElseThrow(Usernotfoundexception::new);
		return thingReadFromDb;
	}

	public List<Users> readAll() {
		List<Users> thingsReadFromDb = this.repo.findAll();
		return thingsReadFromDb;
	}

	public Users updateById(Long id, Users newThing) {

		// grabs the thing we want to change from the db
		Users oldThing = this.repo.findById(id).orElseThrow(Usernotfoundexception::new);

		// here's the object we want to plug in instead:
		oldThing.setFirstName(newThing.getFirstName());
		oldThing.setLastName(newThing.getLastName());
		oldThing.setPassportNumber(newThing.getPassportNumber());

		// saves the changed object to the db
		return this.repo.save(oldThing);
	}
	public boolean deleteById(Long id) {
        // tries to delete the object first
        this.repo.deleteById(id);

        // checks if that object we tried to delete still exists
        return !this.repo.existsById(id);
        

	    }
	
	   // readById
   // @GetMapping("/read/{id}")
   // public ResponseEntity<Users> readById(@PathVariable Long id) {
     //   Users returnedObject = this.service.readById(id);
       // return ResponseEntity.ok(returnedObject);
  //  }

    // find by FirstName
    public Users findByFirstName(String FirstName) {
        return this.repo.findUsersbyFirstName(FirstName);
    }
    
    // find by LastName
    public Users findByLastName(String LastName) {
        return this.repo.findUsersbyFirstName(LastName);
    }

    // find by PassportNumber
    public Users findByPassportNumber(String PassportNumber) {
        return this.repo.findUsersbyPassportNumber(PassportNumber);
    }

	}



