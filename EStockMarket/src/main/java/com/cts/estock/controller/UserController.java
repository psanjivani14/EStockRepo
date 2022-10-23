package com.cts.estock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.estock.interfaces.UserService;
import com.cts.estock.model.User;

@RestController
@RequestMapping("api/v1")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/getAllUsers")
	public ResponseEntity<?> getAllUser(){
		
		List<User> users= userService.getAllUsers();
		if(users!= null && !users.isEmpty()) {
			
			return new ResponseEntity<List<User>>(users, HttpStatus.OK);
		}
		
		return new ResponseEntity<String>("Userlist is empty", HttpStatus.NO_CONTENT);
			}
	
	@PostMapping("/addUser")
	public ResponseEntity<?> addUser(@RequestBody User user){
		
	
		return null;
		
	}
	

}
