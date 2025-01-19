package com.app.profile.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.app.profile.Models.User;
import com.app.profile.Services.UserService;



@CrossOrigin("*")
@RestController

public class UserController {
	
	private final UserService userService;
	
    
	
	public UserController(UserService userService) {
		this.userService= userService;
	}
	
	
	
	
	@PostMapping("/login")
	public ResponseEntity<String> getUser(@RequestBody User user){

       User userdb =  userService.findUserByEmail(user.getEmail());
       if(userdb!=null) {
        if(userdb.getPassword().equals(user.getPassword())) {
        	return ResponseEntity.ok("hello");
        }else {
        	return  ResponseEntity.ok("Bye");
        }
       }
        else {
        	return ResponseEntity.ok("not found");
        }
		
	}
	
	
	@PostMapping("/register")
	public ResponseEntity<String> addUser(@RequestBody User user){
		userService.addUser(user);
		
		return ResponseEntity.ok("added");
	}
	
	
	

}
