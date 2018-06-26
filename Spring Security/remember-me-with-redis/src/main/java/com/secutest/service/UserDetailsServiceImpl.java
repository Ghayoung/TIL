package com.secutest.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
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
		//DB에서 username으로 검색해서 user를 찾는다
        User user = userRepository.findFirstByUsername(username);

        //user를 찾지 못하면 예외를 발생시킨다
        if(user == null){
            throw new UsernameNotFoundException("User is not exist!");
        }

        String password = user.getPassword();

        //user의 role을 가져온다
        List<Role> roles = user.getRoles();

        //role이 없으면 예외를 발생시킨다
        if (roles.isEmpty()) {
            throw new BadCredentialsException("Authentication Failed. User granted authority is empty.");
        }

        //role 아이디를 리스트로 만든다
        List<Long> roleIds = roles.stream()
                                  .map(Role::getId)
                                  .collect(Collectors.toList());

        //roleIds를 통해 permission 리스트를 만든다
        List<String> permissions = rolePermissionRepository.permissions(roleIds);
	}

}