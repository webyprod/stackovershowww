package com.sg.stackovershow.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

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
	
	@Size(max = 20)
	@NotEmpty(message = "Username is required")
	@Column(name="username")
	private String username;
	
	@Email
	@Size(max = 50)
	@NotEmpty(message = "Email is required")
	@Column(name="email")
	private String email;
	
	@Size(max = 120)
	@NotEmpty(message = "Password is required")
	@Column(name="password")
	private String password;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL )
	@JoinTable(	name = "user_roles", 
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Roles> roles = new HashSet<>();
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name = "userId")
	private List<Post> posts;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name = "userId")
	private List<Comment> comments;
	
	private String skill;

	
	public User() {}

	public User(String name, String username, String email,String password, String skill) {
		super();
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.skill = skill;
		posts = new ArrayList<>();
		comments = new ArrayList<>();
	}
	
	public Long getId() {
		return userId;
	}

	public void setId(Long id) {
		this.userId = id;
	}


	public String getNames() {
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


	public Set<Roles> getRoles() {
		return roles;
	}

	public void setRoles(Set<Roles> roles2) {
		this.roles = roles2;
	}


	public List<Post> getPosts() {
		return posts;
	}


	public void addPosts(Post post) {
		this.posts.add(post);
	}
	
	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public List<Comment> getComments() {
		return comments;
	}


	public void addComments(Comment comment) {
	this.comments.add(comment);
	}	
}
