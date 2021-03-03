package com.example.cne.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Repository;

import com.example.cne.persistence.domain.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

	//select * from Users where FirstName/LastName/passportnumber = "?"
	
	Users findUsersByLastName(String lastName);
	 
	Users  findUsersByFirstName (String firstName);
	
	Users findUsersByPassportNumber (String passportNumber);
}
