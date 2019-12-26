package com.sg.stackovershow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sg.stackovershow.entities.User;
import com.sg.stackovershow.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
    private UserRepository userRepo;
	
	
	public User findUserByUsername(String username) {
        return userRepo.findByUsername(username);
    }
	
	public List<User> getUsers() {
        return userRepo.findAll();
    }
	
	public User findById(Long id) {
        return userRepo.findById(id).get();
    }
	
	public void deleteUser(User user) {
        userRepo.delete(user);
    }

}
