package com.cts.estock.interfaces;

import java.util.List;

import com.cts.estock.model.User;

public interface UserService {

	public List<User> getAllUsers();
	
	public User addUser(User user);
	
	public Boolean validateUser(String username, String password);
	

}
