package com.sg.stackovershow.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sg.stackovershow.entities.Post;
import com.sg.stackovershow.entities.User;
import com.sg.stackovershow.repositories.UserRepository;
import com.sg.stackovershow.services.PostService;
import com.sg.stackovershow.services.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/users/all")
	public Page<User> getAll(@RequestParam(defaultValue="0") int page) {
		return userRepo.findAll(PageRequest.of(page, 5));
	}
	
	@GetMapping("/admin/users/all")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> getAllForAdmin() {
		List<User> users = userService.getUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	
	@GetMapping("/user/{username}")
	//@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?> getUserByUsername(@PathVariable("username") String username){
		User newUser = new User();
		newUser = userService.findUserByUsername(username);
		if (newUser.equals(null)){
            return new ResponseEntity<>("No user found for this username", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(newUser, HttpStatus.OK);
	}
	
	@DeleteMapping("/user/{username}")
	public ResponseEntity<?> deleteUser(@PathVariable("username") String username){
		
		User user = userService.findUserByUsername(username);
		if (user.equals(null)){
            return new ResponseEntity<>("No user found for this username", HttpStatus.BAD_REQUEST);
        }
		userService.deleteUser(user);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	
	
	
}