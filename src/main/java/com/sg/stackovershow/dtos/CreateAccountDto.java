package com.sg.stackovershow.dtos;

import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CreateAccountDto {

	private String name;
	
	@NotBlank
    @Size(min = 3, max = 20)
    private String username;
 
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
    
    private Set<String> roles;
    
    @NotBlank
    @Size(min = 6, max = 40)
    private String password;
    
    public CreateAccountDto() {}

	public CreateAccountDto(String name, String username, String email, String password, Set<String> role) {
		super();
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.roles = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<String> getRole() {
		return this.roles;
	}
	
	public void setRole(Set<String> role) {
		this.roles = role;
	}
	
	
	
	
	
}
