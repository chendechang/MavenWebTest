package org.test.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.test.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:springmvc/springMVC-servlet.xml"})
public class TestUserService {
	
	@Autowired
	private UserService userService;
	
	@Test
	public void TestSelectUserById(){
		User user = userService.selectUserById(3);
		if(user != null){
			System.out.println(user.getUserName() + ":" + user.getUserPassword());
		}else{
			System.out.println("不存在这个用户！");
		}
		
	}
	
	@Test
	public void testSelectAllUser(){
		List<User> users = userService.selectAllUser();
		
		for (User user : users) {
			System.out.println("name:"+user.getUserName()+",password:"+user.getUserPassword());
		}
	}
	
	@Test
	public void testAddUser(){
		User newUser = new User();
		
		newUser.setUserName("王五");
		newUser.setUserPassword("123456");
		
		User inUser = userService.selectUserByName(newUser.getUserName());
		
		if(inUser == null){
			int result = userService.addUser(newUser);
			
			if(result > 0){
				System.out.println("新增人员成功！");
			}else{
				System.out.println("新增人员失败！");
			}
		}else{
			System.out.println("人员名称重复，新增失败！");
		}
	}
	
	@Test
	public void testDeleteUser(){
		int deleteId = 1;
		int result = userService.deleteUser(deleteId);
		
		if(result > 0){
			System.out.println("id为："+deleteId+"的人员删除成功！");
		}else{
			System.out.println("人员删除失败！");
		}
		
	}
}
