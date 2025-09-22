package com.company.java009_ex;

class Student001 {
	//멤버 변수
	String name;
	int no, kor, eng, math;
	int total;
	double avg;
	//멤버 함수
	void info() {
		System.out.println("이름 : " + this.name);
		System.out.println("총점 : " + this.total);
		System.out.printf("이름 : %.2f", this.avg);
		System.out.println();
	}
}

public class ClassEx001_oop {
	public static void main(String[] args) {
		Student001 s1 = new Student001();
		//1) new (1번지-객체생성) 2)student001() 초기화 3) s1 주소
		s1.name = "first";
		s1.no = 11;
		s1.kor = 100;
		s1.eng = 100;
		s1.math = 99;
		s1.total = s1.kor + s1.eng + s1.math;
		s1.avg = s1.total / 3.0;
		s1.info();
	}
}
/*
연습문제1)  class
패키지명 : com.company.java009_ex
클래스명 :  ClassEx001
class Student001{
  멤버변수 : String name;  int no, kor, eng, math;
  멤버함수 : void info()
}

public class ClassEx001{
   public static void main(String[] args) {
      Student001   s1 = new Student003();
     s1.name="first";  s1.no=11; s1.kor=100; s1.eng=100; s1.math=99;
     s1.info();
   }
}
출력내용 : 
  이름: first
  총점 : 299
  평균 : 99.67

*/
