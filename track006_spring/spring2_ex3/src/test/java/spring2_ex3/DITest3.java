package spring2_ex3;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.thejoa703.ioc3.IceCreamShop;



@RunWith(SpringJUnit4ClassRunner.class) //spring 구동
//@ContextConfiguration(locations = "classpath:config/beans.xml")  //설정
@ContextConfiguration(locations = "classpath:config/beans3.xml")  
public class DITest3 {
	@Autowired ApplicationContext  context; // bean
	
	@Test public void test() {
		IceCreamShop bera33 = context.getBean("iceCreamShop",  IceCreamShop.class);
		//IceCreamShop bera31 = context.getBean("IceCreamShop",  IceCreamShop.class);
		bera33.open();
	}
}
