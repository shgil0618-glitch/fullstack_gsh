package com.company.java008;

public class Method001 {
	//(1) 마법상자 - 코드 재사용
	//public static 리턴값 메서드명(파라미터){   }
	public static void hello() {System.out.println("Hello"); }
	public static void line() {System.out.println();}
	public static void smile() {System.out.print(":)");}
	
	//////////////////////////////////////////
	public static void main(String[] args) {
		//(2) 마법상자 사용
		smile(); hello();
		hello();
		line();
		smile(); hello();
		line();
		hello();
		smile(); hello();
		
	}
	//////////////////////////////////////////


}

