package com.sg.stackovershow.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Entity
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	@NotEmpty(message = "Name is required")
	@Column(name="name")
	private String name;
	
	@NotEmpty(message = "Username is required")
	@Column(name="username")
	private String username;
	
	@Email
	@NotEmpty(message = "Email is required")
	@Column(name="email")
	private String email;
	
	@NotEmpty(message = "Password is required")
	@Column(name="password")
	private String password;
	
	@Enumerated(EnumType.STRING)
	@Column(name="role")
	private Role role;
	
	@OneToMany
	@JoinColumn(name = "userId")
	private List<Post> posts;
	
	@OneToMany
	private List<Comment> comments;
	
//	private Boolean account_non_expired=false;
//	private Boolean account_non_locked=false;
//	private Boolean credentials_non_expired=false;
//	private Boolean enabled=false;
	
	
	@Transient
    private String token;
	
	
	public User() {}


	public User(String name, String username, String email,String password, Role role) {
		super();
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
		posts = new ArrayList<>();
		comments = new ArrayList<>();
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


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	public List<Post> getPosts() {
		return posts;
	}


	public void addPosts(Post post) {
		this.posts.add(post);
	}


	public List<Comment> getComments() {
		return comments;
	}


	public void addComments(Comment comment) {
		this.comments.add(comment);
	}


	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}
	
	
	
	
	
}
