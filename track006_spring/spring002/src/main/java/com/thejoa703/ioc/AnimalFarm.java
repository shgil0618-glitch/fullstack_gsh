package com.thejoa703.ioc;

import java.util.List;

import lombok.Data;

@Data
public class AnimalFarm {
	private String name;
	private Animal ani;
	private List<String> skills;
	
	public void show() {
		System.out.println(name + ">" + ani.eat());
		System.out.println(name + ">" + ani.sleep());
		System.out.println(name + ">" + ani.poo());
	}
}
