package org.test.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.test.dao.ClassDao;
import org.test.model.Classes;
import org.test.service.ClassService;

@Service
public class ClassServiceImpl implements ClassService {
	
	@Autowired
	private ClassDao classDao;

	public Classes getClass(Integer id) {
		// TODO Auto-generated method stub
		return classDao.getClass(id);
	}

	public void getUserCount(Map<String, Integer> paramMap) {
		// TODO Auto-generated method stub
		classDao.getUserCount(paramMap);
	}

}
