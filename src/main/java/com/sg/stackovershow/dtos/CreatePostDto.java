package com.sg.stackovershow.dtos;

public class CreatePostDto {
	
	
	String subject;
	
	String message;
	
	String username;
	
	public CreatePostDto() {}
	
	public CreatePostDto(String subject, String message, String username) {
		this.subject = subject;
		this.message = message;
		this.username = username;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	

}
