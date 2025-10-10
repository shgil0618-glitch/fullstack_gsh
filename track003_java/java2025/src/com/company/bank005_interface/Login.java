package com.company.bank005_interface;

import java.util.List;
import java.util.Scanner;

public class Login implements BankController {
	// find  - 찾은 유저번호 or 0 로그인 or 1 계좌추가
	@Override
	public int exec(List<UserInfo> users, int find) {
		//변수
		Scanner scanner = new Scanner(System.in);
		//입력 - 아이디와 비밀번호 입력받기
		System.out.print("[1]아이디 > ");   String tempid=scanner.next();
		System.out.print("[2]비밀번호 > ");  String temppass=scanner.next();
		//처리 - users에서 아이디와 비밀번호가 맞는  유저번호 찾기 - 찾았으면 나오기 / 못찾았으면 -1
		// 내가입력받은아이디와 유저0번째 users.get(0)의 아이디  , 0번이 유저번호
		//if( 내가입력받은아이디와 유저1번째 users.get(1)의 아이디 ) { 1번이 유저번호 }
		for(int i=0; i<users.size(); i++) {
			if( tempid.equals(   users.get(i).getId()  ) && temppass.equals( users.get(i).getPass())  ) { 
				return i;
			}
		}
		// users.add(  new UserInfo("id" , "pw" , 1))
		// users.get(0) 0번째유저
		// users.size()  유저의 갯수
		// users.remove(0) 0번째유저 삭제
		//출력 - x
		return -1;
	}
} 
