/*
package com.company.java010_ex;

class User002 {
	   final String nation = "Korea";   
	   final String jumin;   
	   String name;

	   public User002() { jumin="00000"; }
	   public User002(String jumin, String name) {
	      this.jumin = jumin;
	      this.name = name;
	   }
	}
	 public class FinalEx {
	   public static void main(String[] args) {
	      User002 user1 = new User002("123456-1234567", "아이유");
	      System.out.println(user1);   
	      
	      user1.nation = "USA";      			//antion을 final로 선언했기때문에 변경할수 없다.
	      user1.jumin  = "123123-1234321"; 		////jumin을 final로 선언했기때문에 변경할수 없다.
	      user1.name = "IU"; 
	      System.out.println(user1);   
	   }
	}
	
	*/
/*
>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
연습문제1)  final
패키지명 : com.company.java011_ex
클래스명 : FinalEx
다음코드에서 오류나는 부분을 찾아 주석달고 이유를 적으시오.
class User002 {
   final String nation = "Korea";   
   final String jumin;   
   String name;

   public User002() { jumin="00000"; }
   public User002(String jumin, String name) {
      this.jumin = jumin;
      this.name = name;
   }
}
 public class FinalEx {
   public static void main(String[] args) {
      User002 user1 = new User002("123456-1234567", "아이유");
      System.out.println(user1);   
      
      user1.nation = "USA";      
      user1.jumin  = "123123-1234321"; 
      user1.name = "IU"; 
      System.out.println(user1);   
   }
}

*/