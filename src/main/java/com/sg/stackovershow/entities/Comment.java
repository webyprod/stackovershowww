package com.sg.stackovershow.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;



public class Comment {
	
//	@Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long commentId;
//
//	@NotEmpty(message = "Text is required")
//	@Column(name="texte")
//    private String texte;
//	
//	private String username;
//
//    private LocalDate published;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "userId")
//    private User user;
    
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "postId")
//    private Post post;
	
    public Comment() {}

//	public Comment(String texte, String username) {
//		super();
//		this.texte = texte;
//		this.username = username;
//		this.published = LocalDate.now();
//	}
//
//	public String getTexte() {
//		return texte;
//	}
//
//	public void setTexte(String texte) {
//		this.texte = texte;
//	}
//	
//	
//
//	public String getUsername() {
//		return username;
//	}
//
//	public void setUsername(String username) {
//		this.username = username;
//	}
    
    
    
}
