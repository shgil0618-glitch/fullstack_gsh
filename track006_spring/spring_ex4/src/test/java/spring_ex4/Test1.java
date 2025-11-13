package spring_ex4;


import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.thejoa703.dao.MilkDao;
import com.thejoa703.dao.TestDao;
import com.thejoa703.dao.UserInfoDao;
import com.thejoa703.dto.MilkDto;
import com.thejoa703.dto.UserInfoDto;



@RunWith(SpringJUnit4ClassRunner.class)		//1. spring 구동테스트
@ContextConfiguration(locations = "classpath:config/root-context.xml")	//2. 설정
public class Test1 {
	
	@Autowired ApplicationContext context;	// 3. bean (스프링이 관리하는 객체) 생성~소멸
	@Autowired DataSource datasource;
	@Autowired SqlSession sqlSession;
	@Autowired TestDao testdao;
	@Autowired UserInfoDao userdao;
	@Autowired MilkDao milkdao;
	
	@Ignore	//@Test
	 public void test1() {System.out.println(context);}
	
	@Ignore //@Test
	 public void test2() {System.out.println(datasource);}		//datasource (connection)
	
	@Ignore public void test3() {System.out.println(sqlSession);}		// 실제 crud
	
	@Ignore public void test4() {System.out.println(testdao);}
	
	@Ignore public void test5() {
		UserInfoDto dto = new UserInfoDto();
		dto.setEmail("asdasd@asd"); dto.setAge(10);
		System.out.println(userdao.insert(dto));
		System.out.println(userdao.delete(22));
		System.out.println(userdao.select(23));
		System.out.println(userdao.update(dto));
		System.out.println(userdao.selectAll());
		}
	
	@Test public void test6() {
		MilkDto dto = new MilkDto();
		 dto.setMname("한승현"); dto.setMnum(20); dto.setMtotal(20);
		System.out.println(milkdao.insert(dto));
		System.out.println(milkdao.delete(10));
		System.out.println(milkdao.select(20));
		System.out.println(milkdao.update(dto));
		System.out.println(milkdao.selectAll());
	}
	
	
	
}
