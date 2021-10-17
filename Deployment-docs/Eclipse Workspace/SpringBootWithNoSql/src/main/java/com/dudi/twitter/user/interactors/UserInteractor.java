package com.dudi.twitter.user.interactors;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dudi.twitter.documents.User;
import com.dudi.twitter.repositories.UserRepository;

@Component
public class UserInteractor {

	@Autowired
	UserRepository userRepository;
	
	public User createUser(User user) {
		return userRepository.insert(user);
	}
	
	public List<User> createUsers(List<User> users) {
//		users.stream().forEach(u -> u.setId(UUID.randomUUID().toString()));
		return userRepository.insert(users);
	}
	
	public void updateUser(User user) {
		User savedUser = userRepository.findById(user.getId()).orElseThrow(() -> new RuntimeException("no user found with id :" + user.getId()));
		
		savedUser.setDob(user.getDob());
		savedUser.setName(user.getName());
		
		userRepository.save(savedUser);
	}
	
	public User getUserById(String id) {
		return userRepository.findById(id).orElseThrow(() -> new RuntimeException("no user found with id :" + id));
	}
	
	public User getUserByName(String name) {
		return userRepository.findByName(name).orElseThrow(() -> new RuntimeException("no user found with name :" + name));
	}
	
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
}
