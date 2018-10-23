package org.test.dao;

import java.util.List;

import org.test.model.User;

public interface UserDao {
	
	public User selectUserById(Integer userId);
	
	public User selectUserByName(String name);
	
	public List<User> selectAllUser();
	
	public int addUser(User user);
	
	public int deleteUser(Integer userId);
}
