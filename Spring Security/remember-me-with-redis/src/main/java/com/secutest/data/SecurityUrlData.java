package com.secutest.data;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix="security.url")
public class SecurityUrlData {

	private String login;

	private String logout;

	private String mypage;

    private String accessdenied;

    private String refreshToken;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getLogout() {
		return logout;
	}

	public void setLogout(String logout) {
		this.logout = logout;
	}

	public String getMypage() {
		return mypage;
	}

	public void setMypage(String mypage) {
		this.mypage = mypage;
	}

	public String getAccessdenied() {
		return accessdenied;
	}

	public void setAccessdenied(String accessdenied) {
		this.accessdenied = accessdenied;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

}
