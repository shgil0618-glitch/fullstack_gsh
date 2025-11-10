package com.company.ioctest;

public class Cat implements Animal {

	@Override
	public String eat() {
		return "cat-eat";
	}

	@Override
	public String sleep() {
		return "cat-sleep";
	}

	@Override
	public String poo() {
		return "cat-poo";
	}

}
