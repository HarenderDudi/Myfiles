package com.dudi.twitter.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.dudi.twitter.documents.User;

public interface UserRepository 
		extends MongoRepository<User, String>{

	
	@Query("{'name': ?0}")
	Optional<User> findByName(String name);

}
