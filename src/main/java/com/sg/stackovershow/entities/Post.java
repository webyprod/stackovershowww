package com.sg.stackovershow.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
public class Post {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

	@NotEmpty(message = "Subject is required")
	@Column(name="subject")
    private String subject;

	@NotEmpty(message = "Message is required")
	@Column(name="message")
    private String message;

    //private Boolean resolved;
    
    private LocalDate publishDate;

    //private List<Category> categories;

    private String username;

//    @OneToMany
//    @JoinColumn(name = "postId")
//    private List<Comment> comments;
	
    public Post() {}

	public Post(String subject, String message, String user) {
		super();
		this.subject = subject;
		this.message = message;
		this.publishDate = LocalDate.now();
		this.username = user;
		//this.comments = new ArrayList<>();
	}

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
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

	public LocalDate getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}

	public String getUser() {
		return username;
	}

	public void setUser(String user) {
		this.username = user;
	}

//	public List<Comment> getAnswers() {
//		return this.comments;
//	}
//
//	public void addAnswer(Comment comment) {
//		this.comments.add(comment);
//	}

}
