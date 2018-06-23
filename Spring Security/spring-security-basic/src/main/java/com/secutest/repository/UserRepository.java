package com.secutest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.secutest.domain.User;

public interface UserRepository extends JpaRepository<User, Integer>  {

    User findOneByLoginId(String loginId);

}