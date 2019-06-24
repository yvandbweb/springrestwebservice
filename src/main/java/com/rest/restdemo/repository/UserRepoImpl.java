package com.rest.restdemo.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rest.restdemo.entity.Comment;
import com.rest.restdemo.entity.Post;
import com.rest.restdemo.entity.User;

@Component
public class UserRepoImpl {
	
	  @Autowired
	  private UserRepository repository;
	  
		
		@PersistenceContext
		private EntityManager entityManager;		

		public ArrayList  userlist(String search){
			List<Object[]> results = entityManager
					.createNativeQuery("SELECT u.id as id,u.nameuser as nameuser,u.datetime as datetime "
							+ "FROM user u WHERE u.nameuser LIKE :search ORDER BY u.nameuser ASC", "userResult" )
					.setParameter("search", "%"+search+"%")
					.getResultList();
			
			return (ArrayList) results;
		}
		
		public List<Comment> getUserComments(Integer id){
			List<Comment> results = entityManager
					.createQuery("SELECT c FROM Comment c WHERE c.user.id=:id" )
					.setParameter("id", id)
					.getResultList();
			
			return results;
		}			
		
		public List<Post> getUserPosts(Integer id){
			List<Post> results = entityManager
					.createQuery("SELECT p FROM Post p WHERE p.user.id=:id" )
					.setParameter("id", id)
					.getResultList();
			
			return results;
		}			
	
}
