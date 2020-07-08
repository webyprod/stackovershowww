package com.sg.stackovershow;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.sg.stackovershow.dtos.CreateAccountDto;
import com.sg.stackovershow.repositories.PostRepository;

class PostServiceTest {
	
	TestRestTemplate resttemplate;
	
	@Autowired
	PostRepository postRepo;
	
	public static final String URL_POST_USER = "/auth/registration";
	public static final String URL_POST = "/post/new";
	
	@Test
	void createPostTest_status_ok() {
		
		CreateAccountDto user = createUser();
		resttemplate.postForEntity(URL_POST_USER, user, Object.class);
		
		HashMap<String, String> message = createMessage(user.getUsername());
		
		ResponseEntity<Object> response = resttemplate.postForEntity(URL_POST, message, Object.class);
		
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		
	}
	
	@Test
	void createPostTest_post_saved() {
		
		CreateAccountDto user = createUser();
		resttemplate.postForEntity(URL_POST_USER, user, Object.class);
		
		HashMap<String, String> message = createMessage(user.getUsername());
		
		resttemplate.postForEntity(URL_POST, message, Object.class);
		
		assertThat(postRepo.count()).isEqualTo(1);
		
	}
	
	public CreateAccountDto createUser() {
		Set<String> roles = new HashSet<>();
		roles.add("user");
		return new CreateAccountDto("foxfox", "foxfox", "foxfox@gmail.com", "foxPWD", "JAVA",  roles);
		
	}
	
	public HashMap<String, String> createMessage (String username){
		HashMap<String, String> message = new HashMap<>();
		message.put("subject", "Subject1");
		message.put("message", "Message1");
		message.put("username", username);
		message.put("category", "JAVA");
		return message;
	}

}
