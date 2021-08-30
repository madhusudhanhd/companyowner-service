package com.danskeinterview.companyowner.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danskeinterview.companyowner.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByUserName(String userName);
	
}
