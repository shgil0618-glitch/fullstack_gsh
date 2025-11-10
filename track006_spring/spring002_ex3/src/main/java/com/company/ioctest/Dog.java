package com.company.ioctest;

public class Dog implements Animal {

	@Override
	public String eat() {
		return "dog-eat";
	}

	@Override
	public String sleep() {
		return "dog-sleep";
	}

	@Override
	public String poo() {
		return "dog-poo";
	}

}
