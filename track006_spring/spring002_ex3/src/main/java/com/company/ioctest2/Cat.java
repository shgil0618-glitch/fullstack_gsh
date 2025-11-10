package com.company.ioctest2;

import org.springframework.stereotype.Component;

@Component("cat")
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
