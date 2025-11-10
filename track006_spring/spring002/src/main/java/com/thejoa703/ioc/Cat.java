package com.thejoa703.ioc;

public class Cat implements Animal {

	@Override
	public String eat() {
		return "...cat";
	}

	@Override
	public String sleep() {
		return "zzzz...cat";
	}

	@Override
	public String poo() {
		return "ppp...cat";
	}

}
