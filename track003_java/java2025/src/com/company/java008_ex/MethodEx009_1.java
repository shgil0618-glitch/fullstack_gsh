package com.company.java008_ex;

import java.util.Arrays;
import java.util.Scanner;

public class MethodEx009_1 {
	public static void  who_are_you(String [][] users){  //	아이디를입력받아서 나라조회   
		//변수
		String tempid="";  String result ="유저를 확인해주세요!";
		Scanner scanner = new Scanner(System.in);
		
		//입력  아이디를 입력해주세요>aaa
		System.out.print("아이디를 입력해주세요>");  tempid= scanner.next();
		
		//처리  if(만약 tempid가 aaa라면){ 한국사람입니다.}
		//     if(만약 tempid가 bbb라면){ 호주사람입니다.}
		//처리  if( tempid.equals(users[0][0])){ result =  users[0][2]+ "사람입니다.";}
		//     if( tempid.equals(users[1][0])){ result =  users[1][2]+ "사람입니다.";}
		for (int i = 0; i < users.length; i++) {
			if (tempid.equals(users[i][0])) {
				result = users[i][2] + "사람입니다.";
				break;
			}
		}
		
		//출력  aaa는 한국사람입니다.  / 유저를 확인해주세요!
		System.out.println(result);
	}
	
	/////////////////////////////////////////////////
	public static void main(String[] args) {
	   // 변수
	   String [][] users = {{ "aaa"  , "111"   , "한국"     } ,     // 00 01 02
	                        { "bbb" , "222"   , "호주"       } ,    // 10 11 12
	                        { "ccc"  , "333"   , "중국"      }};    // 20 21 22
	   // 입력
	   who_are_you(users);    // 아이디를입력받아서 나라조회
	   //public static void  who_are_you(String [][] users){  아이디를입력받아서 나라조회  }
	   who_pass_change(users); // 아이디,비밀번호가 맞으면 비밀번호 바꾸기
	   //public static void  who_pass_change(String [][] users){ 아이디,비밀번호가 맞으면 비밀번호 바꾸기  }
	}
	/////////////////////////////////////////////////
	public static void  who_pass_change(String [][] users){ 
		// 아이디,비밀번호가 맞으면 비밀번호 바꾸기  
		// 변수
		String tempid="", temppass="";
		Scanner scanner = new Scanner(System.in);
		// 입력
		System.out.print("아이디를 입력해주세요>");  tempid= scanner.next();
		System.out.print("비밀번호를 입력해주세요>");  temppass= scanner.next();
		
		int findIndex=-1;  // 유저의 번호를 찾아서 findIndex 담기 , 못찾았다라고 하면 -1
		// 처리 if( 아이디와 비번이 맞으면 ) {  변경하실 비밀번호를 입력해주세요123 - 비번바꾸기}
		//     if(tempid와 users[0][0] && temppass와 users[0][1] ) {01 변경하실 비밀번호를 입력해주세요123 - 비번바꾸기}
		//     if(tempid와 users[1][0] && temppass와 users[1][1] ) {11 변경하실 비밀번호를 입력해주세요123 - 비번바꾸기}
		for(int i=0; i<users.length; i++) {
			if(tempid.equals(users[i][0]) && temppass.equals( users[i][1] )) { 
				System.out.print("변경하실 비밀번호를 입력해주세요");
				users[i][1] =  scanner.next();
				findIndex= i;
				break;  //찾았으면 나오기!
			}
		}
		// 출력  - 정보확인 : [bbb, 123, 호주] / 정보를 확인해주세요
		if(findIndex != -1) {
			System.out.println("정보확인 : " + Arrays.toString( users[findIndex]) );
		}else { 	System.out.println("정보를 확인해주세요");   }
	}
	 
}

/*
	   // 변수
	   String [][] users = {{ "aaa"  , "111"   , "한국"     } ,     // 00 01 02
	                        { "bbb" , "222"   , "호주"       } ,    // 10 11 12
	                        { "ccc"  , "333"   , "중국"      }};    // 20 21 22

연습문제9)  method
패키지명 : com.company.java008_ex
클래스명 :  MethodEx009

public class MethodEx009{ 
   // 변수
   String [][] users = {{ "aaa"  , "111"   , "한국"     } ,     // 00 01 02
                      { "bbb" , "222"   , "호주"       } ,       // 10 11 12
                      { "ccc"  , "333"   , "중국"      }};      // 20 21 22
   // 입력
   who_are_you(users);    
   //  public static void who_are_you(String [][] users){  아이디를입력받아서 나라조회 }
   who_pass_change(users); 
   //  public static void who_pass_change(String [][] users){ 아이디,비밀번호가 맞으면 비밀번호 바꾸기}
}

출력내용) who_are_you(users);    
//  public static void who_are_you(String [][] users){  아이디를입력받아서 나라조회 }
아이디를 입력해주세요>aaa
aaa는 한국사람입니다.


출력내용)
who_pass_change(users); 
//  public static void who_pass_change(String [][] users){ 아이디,비밀번호가 맞으면 비밀번호 바꾸기}

아이디를 입력해 주세요 > bbb
비밀번호를 입력해 주세요 > 123
유저를 확인해주세요!

아이디를 입력해 주세요 > bbb
비밀번호를 입력해 주세요 > 222
변경하실 비밀번호를 입력해주세요123
정보확인 : [bbb, 123, 호주]

*/