import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.test.dao.CommonDao;
import org.test.util.MybatisUtil;

public class TestProcedure extends CommonDao{
	
	@Test
	public void testGetUserCount(){
		SqlSession sqlSession = this.getSqlSession();
		
		System.out.println(sqlSession);
		
        String statement = "mapper.classMapper.getUserCount";//Ó³ÉäsqlµÄ±êÊ¶×Ö·û´®
        Map<String, Integer> parameterMap = new HashMap<String, Integer>();
        parameterMap.put("sexid", 1);
        parameterMap.put("usercount", -1);
        sqlSession.selectOne(statement, parameterMap);
        Integer result = parameterMap.get("usercount");
        System.out.println(result);
        sqlSession.close();		
	}
}
