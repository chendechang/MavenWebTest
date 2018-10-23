package org.test.service;

import java.util.List;

import org.test.model.User;

public interface UserService {
	
	User selectUserById(Integer userId);
	
	User selectUserByName(String name);
	
	List<User> selectAllUser();
	
	int addUser(User user);
	
	int deleteUser(Integer userId);
}
