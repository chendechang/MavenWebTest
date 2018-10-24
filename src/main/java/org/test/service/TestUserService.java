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
			System.out.println("����������û���");
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
		
		newUser.setUserName("����");
		newUser.setUserPassword("123456");
		
		User inUser = userService.selectUserByName(newUser.getUserName());
		
		if(inUser == null){
			int result = userService.addUser(newUser);
			
			if(result > 0){
				System.out.println("������Ա�ɹ���");
			}else{
				System.out.println("������Աʧ�ܣ�");
			}
		}else{
			System.out.println("��Ա�����ظ�������ʧ�ܣ�");
		}
	}
	
	@Test
	public void testDeleteUser(){
		int deleteId = 1;
		int result = userService.deleteUser(deleteId);
		
		if(result > 0){
			System.out.println("idΪ��"+deleteId+"����Աɾ���ɹ���");
		}else{
			System.out.println("��Աɾ��ʧ�ܣ�");
		}
		
	}
}
