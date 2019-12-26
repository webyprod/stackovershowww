package com.sg.stackovershow.dtos;

public class CreateAccountDto {

	private String name;
	
	private String username;
	
    private String email;
    
    private String password;
    
    public CreateAccountDto() {}

	public CreateAccountDto(String name, String username, String email, String password) {
		super();
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
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

	@Override
	public String toString() {
		return "createAccountDto [username=" + username + ", email=" + email + ", password=" + password + "]";
	}
	
	
	
	
	
}
