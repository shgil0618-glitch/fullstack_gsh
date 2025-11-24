package spring005;


import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.Provider.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.thejoa703.dao.EmpDao;
import com.thejoa703.dto.AppUserAuthDto;
import com.thejoa703.dto.EmpDto;




@RunWith(SpringJUnit4ClassRunner.class)		//1. spring 구동테스트
@ContextConfiguration(locations = "classpath:config/root-context.xml")	//2. 설정
public class Test2_emp {
	
	@Autowired  ApplicationContext context; //3. ioc - Bean (스프링이 관리하는 객체) 생성~소멸
	@Autowired  DataSource   ds;
	@Autowired  SqlSession   session;
	@Autowired EmpDao dao;
	
	@Ignore @Test public void test1() { System.out.println(context); }
	@Ignore @Test public void test2() { System.out.println(ds);      }
	@Ignore @Test public void test3() { System.out.println(session);      }
	
	
	@Ignore @Test public void test4() {
		HashMap<String,String> para = new HashMap<>();
		para.put("searchType", "ename");
		para.put("keyword", "SMITH");
		
		System.out.println(dao.test1(para));
	}
	
	@Ignore @Test public void test5() {
		EmpDto dto = new EmpDto();
		dto.setEname("SMITH");
		dto.setJob("CLERK");
		System.out.println(dao.test2(dto));
	}
	
	@Ignore @Test public void test6() {
		List<Integer> list = new ArrayList<>();
		list.add(7369); list.add(7499); list.add(7521);
		
		System.out.println(dao.test6(list));
	}
	
	@Test public void test7() {
		AppUserAuthDto dto = new AppUserAuthDto();
		dto.setEmail("q3@q3");
		System.out.println(dao.readAuth(dto));
	}

}
