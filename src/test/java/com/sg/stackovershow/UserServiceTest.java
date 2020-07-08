package com.sg.stackovershow;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.sg.stackovershow.dtos.CreateAccountDto;
import com.sg.stackovershow.repositories.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class UserServiceTest {

	public static final String URL_POST = "/auth/registration";

	RestTemplate resttemplate;
	
	@Autowired
	UserRepository userRepo;
	
	@Test
	void createUserTest_status_ok() {
		
		CreateAccountDto user = createUser();
		
		ResponseEntity<Object> response = resttemplate.postForEntity(URL_POST, user, Object.class);
		
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		
	}
	
	@Test
	void createUserTest_user_saved() {
		
		CreateAccountDto user = createUser();
		
		resttemplate.postForEntity(URL_POST, user, Object.class);
		
		assertThat(userRepo.count()).isEqualTo(1);
	}
		
	
	public CreateAccountDto createUser() {
		Set<String> roles = new HashSet<>();
		roles.add("user");
		return new CreateAccountDto("foxfox", "foxfox", "foxfox@gmail.com", "foxPWD", "JAVA",  roles);
		
	}
	

}
