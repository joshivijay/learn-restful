package com.learn.springboot.rest.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.learn.springboot.rest.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query(value = "select * from user where name like %:name%", nativeQuery = true)
	Iterable<User> findByName(@Param("name") String name);

}
