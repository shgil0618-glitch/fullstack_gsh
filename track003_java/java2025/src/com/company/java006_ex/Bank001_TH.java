package com.company.java006_ex;
import java.util.Scanner;

public class Bank001_TH {
   public static void main(String[] args) {
      String id = " ";
      String newid = " ";
      String pw = " ";
      String findid;
      String findpw;
      int age = 0;
      int money = 0;     // 잔액
      int a = 0;         //switch 선택
      int putmoney = 0;    // 입금
      int getmoney = 0;    // 출금
      String confirm;    // 계좌 삭제 여부
      Scanner sc = new Scanner(System.in);
         
      for(;;) {
         System.out.println("======BANK======");
         System.out.println("1.추가");
         System.out.println("2.조회");
         System.out.println("3.입금");
         System.out.println("4.출금");
         System.out.println("5.삭제");
         System.out.println("9.종료");
         System.out.println("입력>>> ");
         a = sc.nextInt();
         
         switch(a) { // 1번째 switch
            
            case 1 :
               System.out.print("아이디 입력 : ");
               newid = sc.next();
               
               if (!id.equals("") && id.equals(newid)) {
                    System.out.println("이미 존재하는 아이디입니다.");
                    break;
                }
               id = newid;
               
               System.out.print("비밀번호 입력 : ");
               pw = sc.next();
               System.out.print("나이 입력 : ");
               age = sc.nextInt();
               System.out.print("잔액 입력 : ");
               money = sc.nextInt();
               if (money<0) {System.out.println("초기잔액이 음수가 나올 수 없습니다.");
                  id = "";
                  pw = "";
                  age = 0;
                  money = 0;
               }
               break;
               
            case 2 : case 3 : case 4 : case 5 :
               System.out.print("아이디 입력 : ");
               findid = sc.next();
               System.out.print("비밀번호 입력 : ");
               findpw = sc.next();
               
               if (!(id.equals(findid) && pw.equals(findpw))){
                  System.out.println("다시 확인해주세요.");
                  break;
               }
               
               switch(a) { // 2번째 swithch
                  case 2 :
                     System.out.println("==계좌조회");
                     System.out.println("id : " + id);
                     System.out.println("pw : " + pw);
                     System.out.println("나이 : " + age);
                     System.out.println("잔액 : " + money);
                     
                     break;
                     
                  case 3 :
                     System.out.print("입금 : ");
                     putmoney = sc.nextInt();
                     if(putmoney<0) {System.out.println("입금을 할 수 없습니다.(음수 금지)"); break;}
                     
                     System.out.println("==입금완료");
                     money += putmoney;
                     System.out.println("잔액 : " + money);
                     
                     break;
                  
                  case 4 :
                     System.out.print("출금 : ");
                     getmoney = sc.nextInt();
                     if(getmoney<0) {System.out.println("출금을 할 수 없습니다.(음수 금지)"); break;}
                     
                     if(money<getmoney) {System.out.println("출금할 돈이 없습니다.");}
                     else {
                        money -= getmoney;
                     }
                     
                     System.out.println("==출금완료");
                     System.out.println("잔액 : " + money);
                     
                     break;
                     
                  case 5 :
                     System.out.println("계좌를 삭제하시겠습니까? (Y/N)");
                     confirm = sc.next();
                     
                     if (confirm.equals("Y") || confirm.equals("y")) {
                        id = "";
                        pw = "";
                        age = 0;
                        money = 0;
                        System.out.println("계좌가 삭제되었습니다.");
                     }
                     else System.out.println("처음으로 돌아갑니다.");
                     
                     break;
               } // 2번째 switch
               
               break;
               
            case 9 :
               System.out.println("종료");
               System.exit(0);
               break;
               
            default :
               System.out.println("잘못된 메뉴번호입니다.");
               break;
            
         } // 1번째 switch
         
      }
   }
}