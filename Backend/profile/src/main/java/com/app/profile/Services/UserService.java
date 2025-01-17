package com.app.profile.Services;

import org.springframework.stereotype.Service;

import com.app.profile.Models.User;
import com.app.profile.Repositories.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRepo;
	
	public UserService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	
	public User findUserByEmail(String email) {
		
		User user = userRepo.findUserByEmail(email).orElse(null);
		
		
		return user;
		
		
	}
	
	
	public User addUser(User user) {
		return userRepo.save(user);
	}
	
	
	
	
	public User findUserById(Long id ) {
	User user = userRepo.findById(id).orElse(null);
		
		
		return user;
		
	}
	
	
	public User updateUser (Long id , User user) {
		 
		User updatedUser =  findUserById(id);
		
		updatedUser.setEmail(user.getEmail());
		updatedUser.setPassword(user.getPassword());
		updatedUser.setUsername(user.getUsername());
		return userRepo.save(updatedUser);
		
		
	}
	
	
	

}
