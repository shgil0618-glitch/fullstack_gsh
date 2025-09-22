package com.company.java009_ex;

class Score {
	String stdid;
	int kor, eng, math, total, avg;

	public Score(String stdid, int kor, int eng, int math) {
		this.stdid = stdid;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	void total() {
		this.total = this.kor + this.eng + this.eng;
	}

	void avg() {
		this.avg = this.total / 3;
	}

	void info() {
		total();
		avg();
		System.out.println("학번\t국어\t영어\t수학\t총합\t평균");
		System.out.printf("%s\t%d\t%d\t%d\t%d\t%d",this.stdid,this.kor,this.eng,this.math,this.total,this.avg);
	}

}

public class ClassEx006 {
	public static void main(String[] args) {
		Score s1 = new Score("std1234", 100, 100, 99);
		s1.info();
	}
}
/*
연습문제6)  class
패키지명 : com.company.java009_ex
클래스명 :  ClassEx006
-- 생성자 작성하시오.
class Score{
   //상태-멤버변수  :  String stdid; int kor,eng,math,total,avg;   
   //행위-멤버함수  :  void total() 총점구해주기
   //               void avg()  평균구하기
   //                      void info()   학생정보출력  ※힌트2)  info(){    total();  avg();     }  다른메서드에서 메서드 사용가능  
   //※ 힌트1) 생성자 :   Score() / Score(stdid, kor, eng, math)
}
public class ClassEx006{
   public static void main(String[] args) {
   Score  s1= new Score("std1234" , 100, 100 , 99 ); 
   s1.info();
   }
}

출력내용 :
학번   kor   eng   math   total   avg
std1234   100   100   99   299   99.67
*/