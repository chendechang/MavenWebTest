package org.test.util;

import java.io.InputStream;

import javax.websocket.Session;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {
	
	public static SqlSession getSqlSession(){
		
		String resource = "mybatis/mybatis-config.xml";
		
		InputStream is = MybatisUtil.class.getClassLoader().getResourceAsStream(resource);
		
		System.out.println("is");
		System.out.println(is);
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

		SqlSession session = factory.openSession();
		System.out.println("session");
		System.out.println(session);
		return session;
	}

}
