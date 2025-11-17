package spring006_ex;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)		//1. spring 구동테스트
@ContextConfiguration(locations = "classpath:config/root-context.xml")	//2. 설정
public class test6 {
	
	@Autowired ApplicationContext context;	// 3. bean (스프링이 관리하는 객체) 생성~소멸
	@Autowired DataSource datasource;
	@Autowired SqlSession sqlSession;
	
	@Ignore	//@test
	 public void test1() {System.out.println(context);}
	
	@Test public void test2() {System.out.println(context);}		//datasource (connection)
	
	@Test public void test3() {System.out.println(sqlSession);}		// 실제 crud
}
