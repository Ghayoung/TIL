package com.secutest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.secutest.service.MyAuthenticationProvider;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    @Autowired MyAuthenticationProvider myAuthenticationProvider;

    @Override
    public void configure(WebSecurity web) throws Exception
    {
        web.ignoring().antMatchers("/res/**"); //리소스 파일 보안 검사 하지 않음
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.authorizeRequests() //권한 설정 시작
            .antMatchers("/admin/**").access("ROLE_ADMIN") //admin만 허용
            .antMatchers("/professor/**").access("ROLE_PROFESSOR") //professor만 허용
            .antMatchers("/guest/**").permitAll() //모든 사용자에게 허용
            .antMatchers("/").permitAll()
            .antMatchers("/**").authenticated(); //로그인된 사용자에게만 허용
        	//권한 설정 우선순위: 앞>뒤

        http.csrf().disable(); //csrf 공격 검사를 하지 않는다. (예제를 간단하게 구현하기 위함)

        http.formLogin() //로그인 페이지 설정 시작
            .loginPage("/guest/login") //로그인 페이지 url
            .loginProcessingUrl("/guest/login_processing") //authenticate 메소드 호출
            .failureUrl("/guest/login?error") //로그인 실패 url
            .defaultSuccessUrl("/user/index", true) //로그인 성공 url
            .usernameParameter("loginId") //로그인 아이디 input 태그의 name 값
            .passwordParameter("passwd"); //비밀번호 input 태그의 name 값

        http.logout() //로그아웃 설정 시작
            .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout_processing")) //로그아웃
            .logoutSuccessUrl("/guest/login") //로그아웃 후 url
            .invalidateHttpSession(true); //세션에 들어있는 데이터 삭제

        http.authenticationProvider(myAuthenticationProvider);
    }
}