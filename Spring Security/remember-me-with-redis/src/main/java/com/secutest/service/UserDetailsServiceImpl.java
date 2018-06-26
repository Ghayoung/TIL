package com.secutest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.secutest.repository.RolePermissionRepository;
import com.secutest.repository.UserRepository;

//UserDetailsService를 구현하는 클래스

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository; //생성해야함

    @Autowired
    private RolePermissionRepository rolePermissionRepository; //생성해야함

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

	}

}