package com.sg.stackovershow.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sg.stackovershow.dtos.CreateAccountDto;
import com.sg.stackovershow.entities.User;
import com.sg.stackovershow.jwt.JwtTokenProvider;
import com.sg.stackovershow.services.AuthenticationService;
import com.sg.stackovershow.services.UserService;

@RestController
public class AuthenticationController {
	
	@Autowired
    private JwtTokenProvider tokenProvider;
	
	@Autowired
	private AuthenticationService authService;
	
	@Autowired
	private UserService userService;
	 
    @PostMapping("/api/user/registration")
    public ResponseEntity signup(@RequestBody CreateAccountDto create) {
        authService.signup(create);
        return new ResponseEntity(HttpStatus.OK);
    }
    
    @PostMapping("/api/user/login")
    public ResponseEntity login (Principal p) {
    	if(p==null || p.getName()==null) {
			return ResponseEntity.ok(p);
		}
    	UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) p;
        User user = userService.findUserByUsername(authenticationToken.getName());
        user.setToken(tokenProvider.generateToken(authenticationToken));

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
