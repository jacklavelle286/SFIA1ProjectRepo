package com.qa.cne.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.cne.persistence.domain.Users;

public interface UsersRepository extends JpaRepository<Users, String> {

	Optional<Users> findById(Long id);

	Users deleteById(Long id);

	boolean existsById(Long id);

	Users findUsersbyFirstName(String firstName);

	Users findUsersbyLastName(String lastName);

	Users findUsersbyPassportNumber(String PassportNumber);
}
