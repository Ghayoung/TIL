package com.secutest.repository;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RememberToken {

	private final String username; //유저명

	private String series; //코드

	private String tokenValue; //토큰값

	private Date date; //토큰생성일

	public RememberToken(String username, String series, String tokenValue, Date date) {
		super();
		this.username = username;
		this.series = series;
		this.tokenValue = tokenValue;
		this.date = date;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public String getTokenValue() {
		return tokenValue;
	}

	public void setTokenValue(String tokenValue) {
		this.tokenValue = tokenValue;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getUsername() {
		return username;
	}

}