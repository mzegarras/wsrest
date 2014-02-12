package com.demo.dao;

import com.demo.entidades.User;

public interface UserDAO {
	
	 public void insertUser(User user);
	 public User getUser(String username);

}
