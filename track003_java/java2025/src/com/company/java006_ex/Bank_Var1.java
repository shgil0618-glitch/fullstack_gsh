package com.company.java006_ex;

import java.util.Scanner;


public class Bank_Var1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num, level=0,age=0,left=0,come=0,out=0;
		char id=' ', pw=' ', id_ok=' ', pw_ok = ' ';
		boolean check=false;
		
		System.out.println("WELCOME (주)GSH_BANK");
		for(;;) {
			switch(level) {
			case 0 : 
				System.out.println("=====BACK=====");
				System.out.println("* 1.추가");
				System.out.println("* 2.조회");
				System.out.println("* 3.입금");
				System.out.println("* 4.출금");
				System.out.println("* 5.삭제");
				System.out.println("* 9.종료");
				System.out.print("입력 : ");
				level = scanner.nextInt();
				if(level>=1 && level <=5 || level ==9) {break;}
				else {System.out.println("올바른 메뉴를 눌러주세요"); level=0; continue;}
			case 1 : 
				System.out.println("추가 기능입니다.");
				System.out.print("id : ");
				id = scanner.next().charAt(0);
				System.out.print("pw : ");
				pw = scanner.next().charAt(0);
				System.out.print("나이 : ");
				age = scanner.nextInt();
				System.out.print("잔액 : ");
				left = scanner.nextInt();
				id_ok = id; pw_ok = pw;
				level = 0;
				break;
			case 2 : 
				System.out.println("조회 기능입니다.");
				for(;;) {
					System.out.print("id : ");
					id = scanner.next().charAt(0);
					System.out.print("pw : ");
					pw = scanner.next().charAt(0);
					if(id==id_ok && pw == pw_ok) {
					System.out.println("잔액 : "+left ); break;}
					else {System.out.println("id,pw가 다릅니다."); continue;}
				}
				level = 0;
				break;
			case 3 : 
				System.out.println("입금 기능입니다.");
				for(;;) {
					System.out.print("id : ");
					id = scanner.next().charAt(0);
					System.out.print("pw : ");
					pw = scanner.next().charAt(0);
					if(id==id_ok && pw == pw_ok) {
					System.out.println("잔액 : "+left ); break;}
					else {System.out.println("id,pw가 다릅니다."); continue;}
				}
				System.out.print("입금 금액을 입력하시오 : ");
				come = scanner.nextInt();
				left += come;
				System.out.println("잔액 : "+left);
				level = 0;
				break;
			case 4 :
				System.out.println("출금 기능입니다.");
				for(;;) {
					System.out.print("id : ");
					id = scanner.next().charAt(0);
					System.out.print("pw : ");
					pw = scanner.next().charAt(0);
					if(id==id_ok && pw == pw_ok) {
					System.out.println("잔액 : "+left ); break;}
					else {System.out.println("id,pw가 다릅니다."); continue;}
				}
				System.out.print("출금 금액을 입력하시오 : ");
				out = scanner.nextInt();
				left -= out;
				System.out.println("잔액 : "+left);
				level = 0;
				break;
			case 5 :
				System.out.println("삭제 기능입니다.");
				for(;;) {
					System.out.print("id : ");
					id = scanner.next().charAt(0);
					System.out.print("pw : ");
					pw = scanner.next().charAt(0);
					if(id==id_ok && pw == pw_ok) {id_ok=' '; pw_ok=' '; left=0; age=0;  break;}
					else {System.out.println("id,pw가 다릅니다."); continue;}
				}
				level = 0;
				break;
			case 6 : 
			case 9 : 
				System.out.println("종료 기능입니다.");;
				check = true; break;
					
			} // end switch
			
			
		if(check == true) {break;}	
		}// end 반복
		
			
	}
}

/*

 1.겹치는 부분 통일, 2.마이너스 통장 안되게

*/