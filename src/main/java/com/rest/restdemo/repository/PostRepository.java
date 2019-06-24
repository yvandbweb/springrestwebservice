package com.rest.restdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rest.restdemo.entity.Post;
import com.rest.restdemo.entity.Comment;


@Repository
public interface PostRepository extends JpaRepository<Post, Integer>
{
	@Query(value="SELECT post from Post post")
	List <Post> findAllpostsAndComments();

}