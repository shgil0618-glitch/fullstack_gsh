package com.company.java014;

import java.util.ArrayList;
import java.util.List;

// 0. 저장단위 : 변수 < 배열(내가(같은 자료형 여러개) < 클래스(내가 원하는 자료형 + 매서드) < 콜렉션 프레임워크 < 파일입출력 < DB
// 1. 배열 단점 : 한가지 자료형 사이즈 고정 String arr[] = new String[3] (정적)
// 2. 콜렉션프레임워크 : 동적배열 (List ★, set, map)
// 3. List[기차] : 순서 O, 중복 O , (add, get, size, remove, contains)
// 4. Set[주머니] : 순서 X, 중복 X , (add, X get(번호) → iterator, size, remove, contains)
// 5. Map[사전] : Key:Value (entry) (add, get(key) / iterator, size, remove, contains)

public class List002 {
	   public static void main(String[] args) {
	       //1. List - 원하는 자료형 원하는 갯수만큼 
	      List list1 = new ArrayList();  // ctrl + shift + o
	      list1.add("one"); list1.add(1);// ★무분별한 데이터
	      System.out.println(list1);   
	      
	      //2. List - <> ★제네릭스
	      List<String> list2 = new ArrayList<>(); 
	      list2.add("apple");  list2.add("banana"); list2.add("coconut");  //list2.add(3);
	      System.out.println(list2);
	      
	      //3. List - 활용 (add, get(번호), size, remove(번호), contains)
	      List<UserDto>  users = new ArrayList<>();
	      users.add(new UserDto("aaa@gmail.com"));
	      users.add(new UserDto("bbb@gmail.com"));
	      
	      System.out.println("1. get : " + users.get(0));
	      System.out.println("2. size : " + users.size());
	      System.out.println("3. remove : " + users.remove(0));
	      System.out.println("4. contains : " + users.contains(new UserDto("aaa@gamil.com")));
	      System.out.println("4. contains : " + users.contains(new UserDto("ccc@gamil.com")));
	      
	      System.out.println(users);
	   }
	}
	class UserDto{
	   private static int cnt=0;  // static(공용) 유저가 생기는만큼 자동카운트
	   private final  int    no;  // final(수정x)
	   private String email;      // 사용자가 입력하는 email 
	   // 기본생성자, 필드생성자, toString, getters/setters
	   
	   public UserDto() { this.no = cnt++; }// 유저번호 = 값; 값넣고 1개증가
	   public UserDto(int no, String email) { super(); this.no = no; this.email = email; }
	   public UserDto(String email) {  this(); this.email = email; }	//	UserDti
	   
	   
	   @Override public String toString() { return "UserDto [no=" + no + ", email=" + email + "]"; }
	   
	   public static int getCnt() { return cnt; }
	   public static void setCnt(int cnt) { UserDto.cnt = cnt; } 
	   
	   public String getEmail() { return email; } 
	   public void setEmail(String email) { this.email = email; } 
	   
	   public int getNo() { return no; } 
	}



