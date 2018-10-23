package org.test.service;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.test.model.Classes;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:springmvc/springMVC-servlet.xml"})
public class TestClassService {
	
	@Autowired
	private ClassService classService;
	
	@Test
	public void testGetClass(){
		Classes result = classService.getClass(1);
		
		System.out.println(result);
	}
	
	@Test
	public void testGetUserCount(){
        Map<String, Integer> paramMap = new HashMap<String, Integer>();
        paramMap.put("sexid", 1);
        paramMap.put("usercount", -1);		
		classService.getUserCount(paramMap);
	}
}
