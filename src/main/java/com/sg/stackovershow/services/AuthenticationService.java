package com.sg.stackovershow.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sg.stackovershow.dtos.CreateAccountDto;
import com.sg.stackovershow.entities.Role;
import com.sg.stackovershow.entities.User;
import com.sg.stackovershow.repositories.UserRepository;

@Service
public class AuthenticationService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
    private PasswordEncoder encoder;
	
    
    @Transactional
    public void signup(CreateAccountDto createDto) {
        User user = new User();
        user.setName(createDto.getName());
        user.setUsername(createDto.getUsername());
        user.setEmail(createDto.getEmail());
        user.setPassword(encode(createDto.getPassword()));
        user.setRole(Role.USER);
        userRepository.save(user);
    }
    
        
    private String encode(String password) {
        return encoder.encode(password);
    }
}
