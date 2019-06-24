package com.rest.restdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.restdemo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>
{

}
