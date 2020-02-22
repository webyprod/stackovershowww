package com.sg.stackovershow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sg.stackovershow.dtos.CreateCommentDto;
import com.sg.stackovershow.dtos.CreatePostDto;
import com.sg.stackovershow.entities.Comment;
import com.sg.stackovershow.entities.Post;
import com.sg.stackovershow.repositories.PostRepository;

@Service
public class PostService {
	
	@Autowired
    private PostRepository postRepo;
	
	public void savePost(CreatePostDto postDto) {
		Post newPost = new Post();
		newPost.setMessage(postDto.getMessage());
		newPost.setSubject(postDto.getSubject());
		newPost.setUser(postDto.getUsername());
		postRepo.save(newPost);
	}
	
	public void saveComment(CreateCommentDto commentDto, Post post) {
		Post newPost = post;
		Comment newComment = new Comment(commentDto.getTexte(), commentDto.getUsername());
		newPost.addAnswer(newComment);
		postRepo.save(newPost);
	}
	
	public List<Post> getPosts() {
        return postRepo.findAll();
    }
	
	public Post getPostById(Long id) {
        return postRepo.findPostById(id);
    }
	
	public List<Post> getPostByUsername(String username) {
        return postRepo.findByUsername(username);
    }
	
	public Post deletePost(Post post) {
        postRepo.deletePostById(post.getPostId());
        return post;
    }

}
