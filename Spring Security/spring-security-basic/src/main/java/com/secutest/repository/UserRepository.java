package com.secutest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.secutest.domain.User;

public interface UserRepository extends JpaRepository<User, Integer>  {

	//User 테이블에서 loginId 필드로 레코드를 조회하는 메소드이다.
    User findOneByLoginId(String loginId);

}