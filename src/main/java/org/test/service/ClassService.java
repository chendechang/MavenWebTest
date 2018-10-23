package org.test.service;

import java.util.Map;

import org.test.model.Classes;

public interface ClassService {
	
	Classes getClass(Integer id);
	
	void getUserCount(Map<String,Integer> paramMap);
}
