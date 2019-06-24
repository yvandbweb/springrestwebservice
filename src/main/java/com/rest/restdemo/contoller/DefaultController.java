package com.rest.restdemo.contoller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.rest.restdemo.entity.Comment;
import com.rest.restdemo.entity.Post;
import com.rest.restdemo.entity.User;
import com.rest.restdemo.repository.PostRepoImpl;
import com.rest.restdemo.repository.UserRepoImpl;



@RestController
@CrossOrigin(origins = {"https://www.ydbweb.com","https://ydbweb.com"} , allowedHeaders = "*")
public class DefaultController {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	PostRepoImpl posts;
	
	@Autowired
	UserRepoImpl users;	
	
	
	
	@GetMapping(value = "/commentswithposts")
	ArrayList postlist(@RequestParam(value="search", required=false, defaultValue = "") String search){
    	
		List<Post> results = posts.getAllPost(search);

		List a = new ArrayList();
    	results.stream().forEach((record) -> {
    		record.setComments(posts.getpostComments(record.getId()));
	        
	        a.add(record);  
	        
    	});
	
	
    	return (ArrayList) a;
	}    	
        
	
	@GetMapping(value = "/userandcomsandposts")
    List<User> userlist(@RequestParam(value="search", required=false, defaultValue = "") String search){
    	List<User> results = users.userlist(search);
    	

		List a = new ArrayList();
    	results.stream().forEach((record) -> {
    		record.setComments(users.getUserComments(record.getId()));
    		record.setPosts(users.getUserPosts(record.getId()));
	        
	        a.add(record);  
	        
    	});
    	
    	return (ArrayList) a;
    }	

}
