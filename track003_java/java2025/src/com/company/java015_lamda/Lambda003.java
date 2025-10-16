package com.company.java015_lamda;

import com.company.java015_lamda.RefClass.InterUsing;


class RefClass{void method(String str){System.out.println(str);}
interface InterUsing{void inter(RefClass c, String str);}
}

public class Lambda003 {
   public static void main(String[] args) {
      //#1. 익명클래스
      InterUsing a1 = new InterUsing() {
         @Override public void inter(RefClass c, String str) {c.method(str);}   
      };
      a1.inter(new RefClass(), "Hello :)");
      
      //#2. 람다()->{}
      InterUsing a2 = (c,str) -> {c.method(str);};
      a2.inter(new RefClass(), "Hello :):)"); //RefClassd의 method 사용
      
      //#3. :: 표현식(참조)
      InterUsing a3 = RefClass::method;
      a3.inter(new RefClass(), "Hello :):):)"); // 자동연결 1) RefClass 2) method 3)
      
      //#4. interface InterBasic{int method(int a, int b);}
      InterBasic basic = (int a, int b) -> {return Math.max(a,b);};
      System.out.println(basic.method(10, 3));
      
      InterBasic basic2 = (a, b) -> Math.max(a,b);
      System.out.println(basic.method(100, 3));
      
      InterBasic basic3 = Math::max;
      System.out.println(basic.method(1000, 3));
      
      InterBasic basic4 = (a, b) -> Math.min(a, b);
      System.out.println(basic4.method(10, 3));
      
      InterBasic basic5 = (a, b) -> Math.min(a, b);
      System.out.println(basic4.method(10, 3));
      
      // #4. interface					// 순서2) 어떤 클래스 갖고선 어떤거 사용했다
      InterString basic6 = (a,b) -> a.compareTo(b);					//java.lang.String.compareTo
      System.out.println(basic6.compare("apple", "banana"));		// 음수
      // 문자열이 같으면 0, (음수) a<b	a가 b보다 앞에옴, (양수) a>b a가 b보다 뒤에옴.
      
      InterString basic7 = String::compareTo;				//java.lang.String.compareTo 순서3)
      System.out.println(basic7.compare("coconut", "banana"));		// 음수
      // 문자열이 같으면 0, (음수) a<b	a가 b보다 앞에옴, (양수) a>b a가 b보다 뒤에옴.
      
      //  InterParse basic8 = (s) -> {return 0;};
      
      InterParse basic8 = s -> Integer.parseInt(s);	// Integer ParseInt 사용 (문자열 -> 정수형)
      System.out.println(basic8.parse("9")+3);		//12
      
      InterParse basic9 = Integer::parseInt;	// Integer ParseInt 사용 (문자열 -> 정수형)
      System.out.println(basic9.parse("9")+3);		//12
      
      //      InterAbs basic10 = (a) -> {return Math.abs(a);};
      //      System.out.println(basic10.apply(-10));		//abs 절댓값만들어주기
      InterAbs basic10 = Math::abs;
      System.out.println(basic10.apply(-10));		//abs 절댓값만들어주기
      
      //InterPring basic11 = (s) -> {System.out.println(s);};
      //InterPring basic11 = s -> System.out.println(s);	// System.out 의 println 사용
      
      InterPring basic11 = System.out::println;
      basic11.print("hello lambda");
      
      
      // ex1) 람다식을 구현해주세요
      // hi.length();
      //System.out.println(ex1.getLength("hello")); 출력시 5
      //EX1 ex1 = (s) -> s.length();
      EX1 ex1 = String::length;
      System.out.println(ex1.getLength("hello"));
      
      // ex2) 람다식을 구현해주세요
      // print("lambda");				결과 lambda
      //EX2 ex2 = (s) -> System.out.print(s);
      EX2 ex2 = System.out::print;
      ex2.print("lambda");
   }

}

interface InterBasic{int method(int a, int b);}			// (a,b) -> return
interface InterString{int compare(String a, String b);}	// 순서1) (a,b) -> return
interface InterParse {int parse(String s);}				// (s) -> return
interface InterAbs { int apply(int a);} 				// (a) -> return
interface InterPring {void print(String s);}			// (s) -> x

interface EX1 {int getLength(String s);}				// (String s) -> return int
interface EX2 {void print(String s);}					// (String s) -> x


