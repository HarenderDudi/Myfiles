package com.dudi.twitter.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dudi.twitter.documents.User;
import com.dudi.twitter.user.interactors.UserInteractor;

/*
 * @RestController combines 
 * 		@Controller and 
 * 		@ResponseBody, 
 * two annotations that results in web requests returning data  rather than a view*/

@RestController
public class UserController {

	@Autowired
	UserInteractor userInteractor;
	
	@PutMapping("/user")
	public User createUser(@RequestBody User user) {
		return userInteractor.createUser(user);
	}
	
	@PostMapping("/users")
	public List<User> createUsers(@RequestBody List<User> users) {
		return userInteractor.createUsers(users);
	}
	
	@PostMapping("/user")
	public Boolean updateUser(@RequestBody User user) {
		userInteractor.updateUser(user);
		return true;
	}
	
	@GetMapping("/user")
	public List<User> getAllUsers() {
		return userInteractor.getAllUsers();
	}
	
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable String id) {
		return userInteractor.getUserById(id);
	}
	
	@GetMapping("/user/{name}")
	public User getUserByName(@PathVariable String name) {
		return userInteractor.getUserByName(name);
	}
	
	
}
