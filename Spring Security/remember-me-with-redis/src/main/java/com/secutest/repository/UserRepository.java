package com.secutest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.secutest.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findFirstByUsername(String username);
	User findOne(int id);

}