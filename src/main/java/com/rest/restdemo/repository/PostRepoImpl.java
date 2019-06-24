package com.rest.restdemo.repository;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rest.restdemo.entity.Comment;
import com.rest.restdemo.entity.Post;


@Component
public class PostRepoImpl {	
		@PersistenceContext
		private EntityManager entityManager;	  
	  
		public ArrayList  getAllPost(String search){
			List<Object[]> results = entityManager
					.createNativeQuery("SELECT p.id as id,user_id as user_id,p.txt as txt,p.datetime as datetime "
							+ "FROM post p WHERE p.txt LIKE :search ORDER BY p.datetime DESC", "OrderResults" )
					.setParameter("search", "%"+search+"%")
					.getResultList();
			

				
				
				return (ArrayList) results;
			}	
		
		
		public List<Comment> getpostComments(Integer id){
			List<Comment> results = entityManager
					.createQuery("SELECT c FROM Comment c WHERE c.post.id=:id" )
					.setParameter("id", id)
					.getResultList();
			
			return results;
		}			
		
		


}
