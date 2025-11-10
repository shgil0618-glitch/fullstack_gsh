package com.thejoa703.ioc;

import lombok.Data;

@Data
public class IceCreamShop {
	private String   name;
    private IceCream iceCream;
    
    public void open() {
       System.out.print("아이스크림 가게 오픈! 오늘의 맛은: ");
       iceCream.taste();
    }
}
