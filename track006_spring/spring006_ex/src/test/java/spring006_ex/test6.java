package spring006_ex;

import java.util.HashMap;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.thejoa703.dao.UserDao;
import com.thejoa703.dto.UserDto;
import com.thejoa703.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)		//1. spring 구동테스트
@ContextConfiguration(locations = "classpath:config/root-context.xml")	//2. 설정
public class test6 {
	
	@Autowired ApplicationContext context;	// 3. bean (스프링이 관리하는 객체) 생성~소멸
	@Autowired DataSource datasource;
	@Autowired SqlSession sqlSession;
	@Autowired UserDao dao;
	@Autowired UserService service;
	
	@Ignore	//@test
	 public void test1() {System.out.println(context);}
	
	@Test public void test2() {System.out.println(context);}		//datasource (connection)
	
	@Test public void test3() {System.out.println(sqlSession);}		// 실제 crud
	
	/*
	 * @Test public void test4() { System.out.println(dao.iddouble("qq@qq"));
	 * System.out.println(dao.iddouble("1@1")); }
	 * 
	 * @Test public void test5() { UserDto dto = new UserDto(); dto.setAppUserId(3);
	 * System.out.println(dao.deleteAdmin(dto)); }
	 * 
	 * 
	 * @Test public void test7() { UserDto dto = new UserDto(); dto.setAppUserId(3);
	 * dto.setMbtiTypeId(67); System.out.println(dao.updateAdmin(dto)); }
	 */
	
	/*
	 * @Test public void test5() { HashMap<String,Object> search = new HashMap<>();
	 * search.put("cat", service.iddouble(email));
	 * 
	 * System.out.println(dao.selectSearch(para)); }
	 */
	
	
}
