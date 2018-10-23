package org.test.dao;

import java.util.Map;

import org.test.model.Classes;

public interface ClassDao {

	Classes getClass(Integer id);
	
	void getUserCount(Map<String,Integer> paramMap);
}
