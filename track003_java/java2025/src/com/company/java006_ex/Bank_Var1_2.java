package com.company.java006_ex;

import java.util.Scanner;


public class Bank_Var1_2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int level=0,age=0,left=0,come=0,out=0;
		String ids =" ", pws=" ", id_oks=" ",pw_oks=" " ;
		boolean check=false;
		boolean add = false;
		
		System.out.println("WELCOME (주)GSH_BANK");
		for(;;) {
			switch(level) {
			case 0 : 
				System.out.println("=====BANK=====");
				System.out.println("* 1.추가");
				System.out.println("* 2.조회");
				System.out.println("* 3.입금");
				System.out.println("* 4.출금");
				System.out.println("* 5.삭제");
				System.out.println("* 9.종료");
				System.out.print("입력 : ");
				level = scanner.nextInt();
				scanner.nextLine();
				if(level>=1 && level <=5 || level ==9) {
					if(add==false && level != 1) {System.out.println("로그인 혹은 회원가입 부탁드립니다. (1번)"); level=0; continue;}
					else {break;}}
				else {System.out.println("올바른 메뉴를 눌러주세요"); level=0; continue;}
			case 1 : 
				System.out.println("추가 기능입니다.");
				System.out.print("id : ");
				ids = scanner.nextLine();
				System.out.print("pw : ");
				pws = scanner.nextLine();
				System.out.print("나이 : ");
				age = scanner.nextInt();		
				System.out.print("잔액 : ");
				left = scanner.nextInt();
				scanner.nextLine();						//트러블슈팅(2) - nextline과 nextint가 같이 사용될때는 nextline를 사용하여 개행문자(엔터)를 먼저 처리해야한다.
				id_oks = ids; pw_oks = pws;
				add = true;
				level = 0;
				break;
			case 2 : 
				System.out.println("조회 기능입니다.");
				for(;;) {
					System.out.print("id : ");
					ids = scanner.nextLine();
					System.out.print("pw : ");
					pws = scanner.nextLine();			
					if(ids.equals(id_oks) && pws.equals(pw_oks)) {		//트러블슈팅(1) - 문자열 비교는 == 안되고, equals 사용
					System.out.println("잔액 : "+left ); break;}
					else {System.out.println("id,pw가 다릅니다."); continue;}		
				}
				level = 0;
				break;
			case 3 : 
				System.out.println("입금 기능입니다.");
				for(;;) {
					System.out.print("id : ");
					ids = scanner.nextLine();
					System.out.print("pw : ");
					pws = scanner.nextLine();
					if(ids.equals(id_oks) && pws.equals(pw_oks)) {
					System.out.println("잔액 : "+left ); break;}
					else {System.out.println("id,pw가 다릅니다."); continue;}
				}
				for(;;) {
				System.out.print("입금 금액을 입력하시오 : ");
				come = scanner.nextInt();
				scanner.nextLine();
				if(come>0) {left += come; System.out.println("잔액 : "+left); level = 0; break;}
				else {System.out.println("0또는 음수의 값은 허용하지 않습니다."); continue;}
				}
				break;
			case 4 :
				System.out.println("출금 기능입니다.");
				for(;;) {
					System.out.print("id : ");
					ids = scanner.nextLine();
					System.out.print("pw : ");
					pws = scanner.nextLine();
					if(ids.equals(id_oks) && pws.equals(pw_oks)) {
					System.out.println("잔액 : "+left ); break;}
					else {System.out.println("id,pw가 다릅니다."); continue;}
				}
				for(;;) {
				System.out.print("출금 금액을 입력하시오 : ");
				out = scanner.nextInt();
				scanner.nextLine();
				if(out>left) {left -= out; System.out.println("잔액 : "+left); level = 0; break;}
				else {System.out.println("출금 금액은 잔액보다 클 수 업습니다.");}
				}
				break;
			case 5 :
				System.out.println("삭제 기능입니다.");
				for(;;) {
					System.out.print("id : ");
					ids = scanner.nextLine();
					System.out.print("pw : ");
					pws = scanner.nextLine();
					if(ids.equals(id_oks) && pws.equals(pw_oks)) {id_oks=" "; pw_oks=" "; left=0; age=0;  break;}
					else {System.out.println("id,pw가 다릅니다."); continue;}
				}
				add = false;
				level = 0;
				break;
			
			case 9 : 
				System.out.println("종료 기능입니다.");;
				check = true; break;
					
			} // end switch
				
		if(check == true) {System.out.println("프로그램이 종료되었습니다."); break;}	
		}// end 반복
		
			
	}
}
/*

1.겹치는 부분 통일, 2.애초에 마이너스 통장 안되게

*/
