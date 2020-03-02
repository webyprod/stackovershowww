package com.sg.stackovershow.dtos;

public class CreatePostDto {
	
	
	String subject;
	
	String message;
	
	String username;
	
	String category;
	
	public CreatePostDto() {}
	
	public CreatePostDto(String subject, String message, String username, String category) {
		this.subject = subject;
		this.message = message;
		this.username = username;
		this.category = category;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	
	
	

}
