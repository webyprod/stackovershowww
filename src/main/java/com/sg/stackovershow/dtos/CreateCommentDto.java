package com.sg.stackovershow.dtos;

public class CreateCommentDto {
	
	String texte;
	
	String username;
	
	public CreateCommentDto() {}
	
	public CreateCommentDto(String texte, String username) {
		this.texte = texte;
		this.username = username;
	}

	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	

}
