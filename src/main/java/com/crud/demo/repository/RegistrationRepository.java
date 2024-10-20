package com.crud.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.demo.model.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {
	boolean existsByUsername(String username);
	}
