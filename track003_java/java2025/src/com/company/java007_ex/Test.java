 
package com.company.java007_ex;

import java.util.Scanner;

public class Test {
   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      final int MAX_USERS = 3; 

      //#### 개선 제안: 배열 선언 시 타입을 앞에 두는 것이 가독성과 일관성에 좋습니다.
      String[] ids = new String[MAX_USERS];
      String[] pws = new String[MAX_USERS];
      double[] balance = new double[MAX_USERS];
      int[] age = new int[MAX_USERS];
      int[] exp = new int[MAX_USERS];
      String[] rank = new String[MAX_USERS];

      int userCount = 0; 

      int level = 0, old_level = 0;

      int come = 0, out = 0;

      boolean check = false;
      boolean login = false;
      boolean level_up = false;
      boolean rank_check = false;
      int loginuser = -1; 

      System.out.println("🧠 [뱅키] 안녕하세요! GSH_BANK에 오신 것을 환영합니다!");
      System.out.println("🎮 뱅키와 함께하는 은행 시스템을 즐겨보세요!");

      for (;;) { //  while(true)  추천
         switch (level) {
         case 0:
            System.out.println("\n===== GSH_BANK MENU =====");
            System.out.println("1. 회원가입");
            System.out.println("2. 조회");
            System.out.println("3. 입금");
            System.out.println("4. 출금");
            System.out.println("5. 삭제");
            System.out.println("9. 종료");
            System.out.print("입력 : ");
            level = scanner.nextInt();
            scanner.nextLine();

            if ((level >= 1 && level <= 5) || level == 9) {
               if (userCount == 0 && level != 1 && level != 9) { 
                  System.out.println("🧠 [뱅키] 먼저 회원가입 해주세요! (1번)");
                  level = 0;
                  continue;
               }
            } else {
               System.out.println("⚠ 올바른 메뉴를 선택해주세요.");
               level = 0;
               continue;
            }
            break;

         case 1: // 회원가입
            if (userCount >= MAX_USERS) {
               System.out.println("⚠ 회원 공간이 가득 찼습니다. 더 이상 가입할 수 없습니다.");
               level = 0;
               break;
            }

            int newUserIndex = -1;
            for (int i = 0; i < MAX_USERS; i++) {
               if (ids[i] == null) { 
                  newUserIndex = i;
                  break;
               }
            }

            System.out.println("\n👤 회원가입 ");
            System.out.print("ID : ");
            String newId = scanner.nextLine();

            boolean idExists = false;
            for (int i = 0; i < MAX_USERS; i++) {
               if (ids[i] != null && ids[i].equals(newId)) {
                  idExists = true;
                  break;
               }
            }
            if (idExists) {
               System.out.println("⚠ 이미 사용 중인 ID입니다.");
               level = 0;
               break;
            }

            System.out.print("PW : ");
            String newPw = scanner.nextLine();
            System.out.print("나이 : ");
            int newAge = scanner.nextInt();
            if (newAge <= 18) {
               System.out.println("⚠ 만 19세 미만은 해당 서비스를 이용하실 수 없습니다.");
               scanner.nextLine();
               level = 0;
               break;
            }
            System.out.print("초기 잔액 : ");
            double newBalance = scanner.nextDouble();
            scanner.nextLine();

            ids[newUserIndex] = newId;
            pws[newUserIndex] = newPw;
            age[newUserIndex] = newAge;
            balance[newUserIndex] = newBalance;
            exp[newUserIndex] = 0;
            userCount++; 
            
            System.out.println("🎉 [뱅키] 환영합니다, " + newId + "님!");
            level = 0;
            break;

         case 2: // 조회
            if (!login) {
               System.out.println("\n🔒 [조회 기능] 로그인이 필요합니다.");
               old_level = level;
               level = 6;
               break;
            }
            if (!rank_check) {
               old_level = level;
               level = 7;
               break;
            }

            System.out.println("\n📊 [잔액 조회]");
            System.out.printf("현재 잔액: %.2f원\n", balance[loginuser]);
            System.out.println("🏅 고객 등급: " + rank[loginuser]);
            rank_check = false;
            login = false;
            level = 0;
            break;

         case 3: // 입금
        	    if (!login) {
        	        System.out.println("\n🔒 [입금 기능] 로그인이 필요합니다.");
        	        old_level = level;
        	        level = 6;
        	        break;
        	    }

        	    if (!rank_check) {
        	        System.out.println("\n💰 [입금 기능]");
        	        System.out.printf("현재 잔액: %.2f원\n", balance[loginuser]);
        	        System.out.print("입금 금액 입력: ");
        	        come = scanner.nextInt();
        	        scanner.nextLine();

        	        if (come <= 0) {
        	            System.out.println("❌ 음수나 0은 입금할 수 없습니다.");
        	            level = 0;
        	            break;
        	        }

        	        balance[loginuser] += come;
        	        exp[loginuser] += (come / 10);
        	        old_level = level;
        	        level = 7; // 랭크 업데이트 후 후처리 진행
        	        break;
        	    }

        	    // rank_check가 true인 경우 후처리
        	    System.out.printf("✅ 입금 완료! 현재 잔액: %.2f원\n", balance[loginuser]);
        	    System.out.println("✨ 경험치 +10 ▶ 현재 경험치: " + exp[loginuser]);
        	    System.out.println("🏅 고객 등급: " + rank[loginuser]);
        	    rank_check = false;
        	    login = false;

        	    if (exp[loginuser] >= 100) {
        	        System.out.println("🎉 레벨업! 보너스 지급 예정!");
        	        exp[loginuser] = 0;
        	        level_up = true;
        	    }

        	    if (level_up) {
        	        int bonus = (int) (Math.random() * 3000);
        	        System.out.println("🎉 [레벨업 복권 보너스] 보너스 " + bonus + "원 당첨!");
        	        System.out.println("[묻고 떠블로가!] 주사위 숫자가 50미만일 경우 - 보너스*2 / 50이상일경우 - 0원");
        	        System.out.println("[묻고 떠블로가!] 이벤트에 도전하시겠습니까? (Y / N)");
        	        char yes = scanner.next().charAt(0);
        	        scanner.nextLine();
        	        if (yes == 'Y' || yes == 'y') {
        	            int chance = (int) (Math.random() * 100);
        	            if (chance < 50) {
        	                bonus *= 2;
        	                balance[loginuser] += bonus;
        	                System.out.println("🎉 축하드립니다!");
        	                System.out.println("🎉 [묻고 떠블로가!] 이벤트 당첨! " + bonus + "원 지급!");
        	            } else {
        	                System.out.println("주사위의 숫자는 " + chance + " 입니다.");
        	                System.out.println("😢 아깝네요. 다음 기회에!");
        	            }
        	        } else {
        	            System.out.println("🎉 [레벨업 복권 보너스] 보너스 " + bonus + "원 지급!");
        	            balance[loginuser] += bonus;
        	        }
        	        level_up = false;
        	    }

        	    if (balance[loginuser] == 77777) {
        	        System.out.println("🎰 [럭키세븐 이벤트]");
        	        System.out.print("주사위를 선택하세요 (1~6): ");
        	        int choice = scanner.nextInt();
        	        scanner.nextLine();
        	        int rolled = (int) (Math.random() * 6) + 1;
        	        if (choice == rolled) {
        	            System.out.println("🎊 주사위 대성공! 보너스 50000원 지급!");
        	            balance[loginuser] += 50000;
        	        } else {
        	            System.out.println("주사위의 숫자는 " + rolled + " 입니다.");
        	            System.out.println("😢 아깝네요. 다음 기회에!");
        	        }
        	    }
        	    level = 0;
        	    break;
    
            
         case 4: // 출금
        	    if (!login) {
        	        System.out.println("\n🔒 [출금 기능] 로그인이 필요합니다.");
        	        old_level = level;
        	        level = 6;
        	        break;
        	    }

        	    if (!rank_check) {
        	        System.out.println("\n🏧 [출금 기능]");
        	        System.out.print("출금 금액 입력: ");
        	        out = scanner.nextInt();
        	        scanner.nextLine();

        	        if (out <= 0) {
        	            System.out.println("❌ 음수나 0은 출금할 수 없습니다.");
        	            level = 0;
        	            break;
        	        }

        	        if (out > balance[loginuser]) {
        	            System.out.println("❌ 출금 금액이 잔액보다 많습니다!");
        	            level = 0;
        	            break;
        	        }

        	        balance[loginuser] -= out;
        	        exp[loginuser] += 10;
        	        old_level = level;
        	        level = 7;
        	        break;
        	    }

        	    // rank_check가 true인 경우 후처리
        	    System.out.printf("✅ 출금 완료! 현재 잔액: %.2f원\n", balance[loginuser]);
        	    System.out.println("✨ 경험치 +10 ▶ 현재 경험치: " + exp[loginuser]);
        	    System.out.println("🏅 고객 등급: " + rank[loginuser]);
        	    rank_check = false;
        	    login = false;

        	    if (exp[loginuser] >= 100) {
        	        System.out.println("🎉 레벨업! 보너스 지급 예정!");
        	        exp[loginuser] = 0;
        	        // level_up 등의 추가 기능이 있다면 여기에 넣을 수 있음
        	    }

        	    level = 0;
        	    break;

         case 5: // 삭제
            if (!login) {
               System.out.println("\n🔒 [삭제 기능] 로그인이 필요합니다.");
               old_level = level;
               level = 6;
               break;
            }

            System.out.println("\n🗑️ [계정 삭제]");
            ids[loginuser] = null;
            pws[loginuser] = null;
            balance[loginuser] = 0;
            age[loginuser] = 0;
            exp[loginuser] = 0;
            rank[loginuser] = null;

            userCount--;
            loginuser = -1;
            login = false;
            System.out.println("👋 계정이 성공적으로 삭제되었습니다.");
            level = 0;
            break;

         case 6: // 로그인
            System.out.println("\n🔐 [로그인]");
            System.out.print("ID : ");
            String inputId = scanner.nextLine();
            System.out.print("PW : ");
            String inputPw = scanner.nextLine();

            boolean found = false;
            for (int i = 0; i < MAX_USERS; i++) {
               if (ids[i] != null && ids[i].equals(inputId) && pws[i].equals(inputPw)) {
                  loginuser = i;
                  level = old_level;
                  login = true;
                  found = true;
                  System.out.println("✅ 로그인 성공!");
                  break;
               }
            }
            if (!found) {
               System.out.println("❌ ID 또는 PW가 틀렸습니다.");
               level = 0;
            }
            break;

         case 7: // 랭크 기능
            if (balance[loginuser] >= 1000000) {
               rank[loginuser] = "💎 Diamond VIP";
            } else if (balance[loginuser] >= 500000) {
               rank[loginuser] = "🥇 Gold 고객";
            } else if (balance[loginuser] >= 100000) {
               rank[loginuser] = "🥈 Silver 고객";
            } else {
               rank[loginuser] = "🥉 Bronze 고객";
            }

            rank_check = true;
            level = old_level;
            break;

         case 9: // 종료
            System.out.println("👋 이용해주셔서 감사합니다. 프로그램을 종료합니다.");
            scanner.close();
            return;

         default:
            System.out.println("⚠ 알 수 없는 명령입니다.");
            level = 0;
            break;
         }
      }
   }
}

              