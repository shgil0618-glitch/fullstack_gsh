package spring002_ex3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.ioctest.AnimalFarm;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/beans.xml")
public class test1 {
	@Autowired ApplicationContext context;
	
    @Test public void test1() {
		   AnimalFarm farm = context.getBean("farm",AnimalFarm.class); 
		   farm.print();
		}
}
