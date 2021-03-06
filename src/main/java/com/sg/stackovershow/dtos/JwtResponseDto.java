package com.sg.stackovershow.dtos;

import java.util.List;
import java.util.Set;

import com.sg.stackovershow.entities.ERole;

public class JwtResponseDto {
		
	private String token;
	private String type = "Bearer";
	private Long id;
	private String username;
	private String email;
	private String name;
	private String skill;
	private List<String> roles;

	public JwtResponseDto(String accessToken, Long id, String username, String email, String name, String skill, List<String> roles) {
		this.token = accessToken;
		this.id = id;
		this.username = username;
		this.email = email;
		this.name = name;
		this.skill = skill;
		this.roles = roles;
	}

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<String> getRoles() {
		return roles;
	}

}
