package com.sg.stackovershow.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sg.stackovershow.entities.Post;
import com.sg.stackovershow.entities.User;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
	
	@Query("SELECT p FROM Post p order by p.publishDate desc")
    public List<Post> findAll();
	
	@Query("SELECT p FROM Post p where p.postId=:id")
    public Post findPostById(@Param("id") Long id);
	
	@Query("SELECT p FROM Post p where p.username=:username order by p.publishDate desc")
    public List<Post> findByUsername(@Param("username")String username);
	
	@Query("DELETE Post where postId=:id")
    public void deletePostById(@Param("id") Long id);
	
	//List<Post> findByUserId(User user);

}
