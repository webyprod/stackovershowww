package com.sg.stackovershow.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sg.stackovershow.dtos.CreateAccountDto;
import com.sg.stackovershow.dtos.LoginDto;
import com.sg.stackovershow.services.AuthenticationService;
import com.sg.stackovershow.services.UserService;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationService authService;
	
	@Autowired
	private UserService userService;
	 
    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody CreateAccountDto create) {
        authService.signup(create);
        return new ResponseEntity(HttpStatus.OK);
    }
    
    @PostMapping("/login")
    public ResponseEntity login (Principal p) {
    	if(p==null || p.getName()==null) {
			return ResponseEntity.ok(p);
		}
		return new ResponseEntity<>(userService.findUserByUsername(p.getName()), HttpStatus.OK);
    }

}
