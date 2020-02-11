package com.sg.stackovershow.dtos;

public class LoginDto {
	
	
	private String username;
    
    private String password;
    
    public LoginDto() {}
    
    public LoginDto(String username, String password) {
    	super();
    	this.password = password;
    	this.username = username;
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
    
    
    

}
