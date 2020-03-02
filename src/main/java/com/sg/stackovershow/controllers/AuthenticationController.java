package com.sg.stackovershow.controllers;

import java.security.Principal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.authentication.AuthenticationManager;

import com.sg.stackovershow.dtos.CreateAccountDto;
import com.sg.stackovershow.dtos.JwtResponseDto;
import com.sg.stackovershow.dtos.LoginDto;
import com.sg.stackovershow.dtos.MessageResponseDto;
import com.sg.stackovershow.entities.ERole;
import com.sg.stackovershow.entities.Roles;
import com.sg.stackovershow.entities.User;
import com.sg.stackovershow.jwt.JwtTokenProvider;
import com.sg.stackovershow.repositories.RoleRepository;
import com.sg.stackovershow.repositories.UserRepository;
import com.sg.stackovershow.security.UserDetailsSecurity;
import com.sg.stackovershow.services.UserService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class AuthenticationController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
    private JwtTokenProvider tokenProvider;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	private UserService userService;
	 
    @PostMapping("/auth/registration")
    public ResponseEntity signup(@Valid @RequestBody CreateAccountDto create) {
    	
    	if (userService.existsByUsername(create.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponseDto("Error: Username is already taken!"));
		}

		if (userService.existsByEmail(create.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponseDto("Error: Email is already in use!"));
		}
		
		// Create new user's account
		User user = new User(create.getName(), create.getUsername(), create.getEmail(),encoder.encode(create.getPassword()), create.getSkill());
		
		Set<String> strRoles = create.getRole();
		Set<Roles> roles = new HashSet<>();

		if (strRoles == null) {
			Roles userRole = new Roles(ERole.USER);
			roles.add(userRole);
		} 		
		user.setRoles(roles);
		userRepo.save(user);

		return ResponseEntity.ok(new MessageResponseDto("User registered successfully!"));
				
    }
    
    @PostMapping("/auth/login")
    public ResponseEntity login (@Valid @RequestBody LoginDto loginRequest) {
    	
    	Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

    	SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = tokenProvider.generateJwtToken(authentication);
		
		
		UserDetailsSecurity userDetails = (UserDetailsSecurity) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());
		
    	
		return ResponseEntity.ok(new JwtResponseDto(jwt, 
				 userDetails.getId(), 
				 userDetails.getUsername(), 
				 userDetails.getEmail(), 
				 userDetails.getName(),
				 userDetails.getSkill(),
				 roles));
    }

}
