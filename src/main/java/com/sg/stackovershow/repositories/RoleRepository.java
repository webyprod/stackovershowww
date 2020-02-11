package com.sg.stackovershow.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sg.stackovershow.entities.ERole;
import com.sg.stackovershow.entities.Roles;

public interface RoleRepository extends JpaRepository<Roles, Long> {

	Optional<Roles> findByName(ERole name);
	
}
