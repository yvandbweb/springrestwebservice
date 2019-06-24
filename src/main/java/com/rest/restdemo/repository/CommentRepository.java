package com.rest.restdemo.repository;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rest.restdemo.entity.Comment;


public interface CommentRepository extends JpaRepository<Comment, Integer>
{
    @Query(value="SELECT c FROM Comment c WHERE c.post.id=:id")
    public List <Comment> findAllComments1(Integer id);

    @Query(name="orderlist5",value="SELECT count(p.id) as cnt,user_id as user_id FROM comment p GROUP BY user_id ORDER BY cnt DESC limit 0,3", nativeQuery = true)
    public List<Object[]> topcommenters();    
}
