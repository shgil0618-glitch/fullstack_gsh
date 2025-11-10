package com.thejoa703.ioc3;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component("iceCreamShop")
public class IceCreamShop {
	@Value("${name}") String name;
   // @Autowired @Qualifier("white") private IceCream iceCream;
	@Resource(name="${iceCream}") private IceCream iceCream;
	
    public void open() {
       System.out.print("æ∆¿ÃΩ∫≈©∏≤ ∞°∞‘ ø¿«¬! ø¿¥√¿« ∏¿¿∫: ");
       iceCream.taste();
    }
}
