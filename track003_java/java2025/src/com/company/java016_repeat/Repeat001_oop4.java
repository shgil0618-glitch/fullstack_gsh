package com.company.java016_repeat;

//public > protected (extends) > package(default) > private

class User004 {
	final char division;
	final String jumin;

	public User004(char division, String jumin) {
		this.division = division;
		this.jumin = jumin;
	}

	public User004() {
		division = 'A';
		jumin = "123456-1234567";
	}

	@Override
	public String toString() {
		return "User004 [division=" + division + ", jumin=" + jumin + "]";
	}
}

public class Repeat001_oop4 {
	public static void main(String[] args) {

		User004 c1 = new User004();
		System.out.println(c1);
		
		User004 c2 = new User004('B', "200101-1234567");
		System.out.println(c2);

		User004 c3 = new User004('C', "202510-1234567");
		System.out.println(c3);

		User004 c4 = new User004('D', "202602-1234567");
		System.out.println(c4);
	}
}