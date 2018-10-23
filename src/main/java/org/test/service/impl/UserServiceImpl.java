package org.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.test.dao.UserDao;
import org.test.model.User;
import org.test.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	public User selectUserById(Integer userId) {
		// TODO Auto-generated method stub
		return userDao.selectUserById(userId);
	}

	public List<User> selectAllUser() {
		// TODO Auto-generated method stub
		return userDao.selectAllUser();
	}

	public int addUser(User user) {
		// TODO Auto-generated method stub
		return userDao.addUser(user);
	}

	public User selectUserByName(String name) {
		// TODO Auto-generated method stub
		return userDao.selectUserByName(name);
	}

	public int deleteUser(Integer userId) {
		// TODO Auto-generated method stub
		return userDao.deleteUser(userId);
	}

}
