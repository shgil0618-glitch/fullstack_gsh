package com.company.jsp009servlet;

public class javaBasic {
	private int a;
	private int b;
	
	//생성자 / toString/ getters + setters	// alt+shift+s
	public javaBasic() { super(); }
	public javaBasic(int a, int b) { super(); this.a = a; this.b = b; }
	public int getA() { return a; }
	public void setA(int a) { this.a = a; }
	public int getB() { return b; }
	public void setB(int b) { this.b = b; }
	@Override public String toString() { return "javaBasic [a=" + a + ", b=" + b + "]"; }
	
	public int add() {return a+b;}
	
}
