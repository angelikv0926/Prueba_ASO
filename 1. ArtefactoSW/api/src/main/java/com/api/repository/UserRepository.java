package com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	@Query("select u from User u where u.nombre = ?1")
	public User findByNameWithQuery(String name);
	
}
