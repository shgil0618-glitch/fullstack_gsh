package com.thejoa703.ioc;

public interface Animal {
	public String eat();
	public String sleep();
	public String poo();
	
}

/*
  [AnimalFarm]  (사용)→    [<<interface>>Animal]   
   ↑(삽입)           ↑(구현)          ↑ (구현)   
  [beans.xml ]  (생성)→     [Cat                /                  Dog]
*/