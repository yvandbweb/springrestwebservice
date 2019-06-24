package com.rest.restdemo.entity;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "user")
@SqlResultSetMapping(
        name = "userResult",
        entities = @EntityResult(
                entityClass = User.class,
                fields = {
                    @FieldResult(name = "id", column = "id"),
                    @FieldResult(name = "nameuser", column = "nameuser"),
                    @FieldResult(name = "dateCreated", column = "datetime")})    
                
        		)
public class User
{
    @Id 
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    private String nameuser;
    
    @Column(name="datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date dateCreated;
    
    @Transient
    private List<Comment> comments;    
    
    @Transient
    private List<Post> posts;     
    

    
	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
    
	public Integer getId() {
		return id;
	}       

	public String getNameuser() {
		return nameuser;
	}

	public void setNameuser(String nameuser) {
		this.nameuser = nameuser;
	}

	public java.util.Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(java.util.Date dateCreated) {
		this.dateCreated = dateCreated;
	}    
}