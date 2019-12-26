package com.sg.stackovershow.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sg.stackovershow.entities.Comment;
import com.sg.stackovershow.entities.Post;
import com.sg.stackovershow.entities.User;


@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

//	List<Comment> findByPost(Post post);
//	
//	
//	List<Comment> findAllByUser(User user);
	
}
