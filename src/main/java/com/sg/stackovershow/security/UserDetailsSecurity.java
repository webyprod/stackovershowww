package com.sg.stackovershow.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sg.stackovershow.entities.ERole;
import com.sg.stackovershow.entities.User;
import com.sg.stackovershow.repositories.UserRepository;

import java.util.Objects;

public class UserDetailsSecurity implements UserDetails{
	
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String name;

	private String username;

	private String email;
	
	private String skill;

	@JsonIgnore
	private String password;

	private Collection<? extends GrantedAuthority> authorities;

	public UserDetailsSecurity(Long id, String name, String username, String email, String password, String skill,
			Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.skill = skill;
		this.authorities = authorities;
	}

	public static UserDetailsSecurity build(User user) {
		List<GrantedAuthority> authorities = user.getRoles().stream()
				.map(roles -> new SimpleGrantedAuthority(roles.getName().name()))
				.collect(Collectors.toList());

		return new UserDetailsSecurity(
				user.getId(), 
				user.getNames(),
				user.getUsername(), 
				user.getEmail(),
				user.getPassword(), 
				user.getSkill(),
				authorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public String getPassword() {
		return password;
	}

	public String getSkill() {
		return skill;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsSecurity user = (UserDetailsSecurity) o;
		return Objects.equals(id, user.id);
	}
	
}
