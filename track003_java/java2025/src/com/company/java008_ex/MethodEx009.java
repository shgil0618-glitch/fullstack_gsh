package com.company.java008_ex;

import java.util.Arrays;
import java.util.Scanner;

public class MethodEx009 {
	public static void main(String[] args) {
		String[][] users = { { "aaa", "111", "한국" }, // 00 01 02
				{ "bbb", "222", "호주" }, // 10 11 12
				{ "ccc", "333", "중국" } }; // 20 21 22
// 입력

		who_are_you(users);
		who_pass_change(users);
	}

	public static void who_are_you(String[][] users) {
		Scanner scanner = new Scanner(System.in);
		String name = "";
		System.out.print("아이디를 입력하시오 : ");
		name = scanner.nextLine();
		for (int i = 0; i < users.length; i++) {
			if (name.equals(users[i][0])) {
				System.out.println("유저의 나라는 : " + users[i][2]);
				break;
			}
		}
	}

	public static void who_pass_change(String[][] users) {
		Scanner scanner = new Scanner(System.in);
		String id = "";
		String pw = "";
		String pw_chg = "";
		boolean check = false;
		System.out.print("id를 입력하시오 : ");
		id = scanner.nextLine();
		System.out.print("pw를 입력하시오 : ");
		pw = scanner.nextLine();
		
		int findindex = -1;

		for (int i = 0; i < users.length; i++) {
			if (id.equals(users[i][0]) && pw.equals(users[i][1])) {
				System.out.print("변경하실 비밀번호를 입력하시오 : ");
				pw_chg = scanner.nextLine();
				users[i][1] = pw_chg;
				findindex = i;
				check =true;
				break;
			} 
		}
		if(findindex != -1) {System.out.println("정보확인 : " + Arrays.deepToString(users[findindex]));}
		else {System.out.println("정보를 확인해 주세요");}
	}
}
/*
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