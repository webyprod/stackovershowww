package com.sg.stackovershow.controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sg.stackovershow.dtos.CreatePostDto;
import com.sg.stackovershow.entities.Post;
import com.sg.stackovershow.entities.User;
import com.sg.stackovershow.services.PostService;
import com.sg.stackovershow.services.UserService;

@RestController
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllPosts(){
		List<Post> posts = postService.getPosts();
		return new ResponseEntity<>(posts, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getPostById(@PathVariable("id") Long id){
		Post post = postService.getPostById(id);
		if (post.equals(null)){
            return new ResponseEntity<>("No post found for this id", HttpStatus.BAD_REQUEST);
        }
		return new ResponseEntity<>(post, HttpStatus.OK);
	}
	
	@PostMapping("/new")
	public ResponseEntity<?> savePost(@RequestBody HashMap<String, String> data){
		CreatePostDto postDto = new CreatePostDto(data.get("subject"), data.get("message"), data.get("username"));
		User user = userService.findUserByUsername(data.get("username"));
		Post newPost = new Post(data.get("subject"), data.get("message"), data.get("username"));
		userService.savePost(user, newPost);
		postService.savePost(postDto);
		return new ResponseEntity<>(postDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletePostById(@PathVariable("id") Long id){
		Post post = postService.getPostById(id);
		if (post.equals(null)){
            return new ResponseEntity<>("No post found for this username", HttpStatus.BAD_REQUEST);
        }
		postService.deletePost(post);
		return new ResponseEntity<>(post, HttpStatus.OK);
	}
}
