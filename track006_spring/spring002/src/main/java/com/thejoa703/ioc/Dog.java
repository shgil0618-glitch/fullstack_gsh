package com.thejoa703.ioc;

public class Dog implements Animal {

	@Override
	public String eat() {
		return "....dog";
	}

	@Override
	public String sleep() {
		return "zzzz...dog";
	}

	@Override
	public String poo() {
		return "pppp...dog";
	}

}
