package com.company.java006_ex;

import java.util.Scanner;

public class Bank_Var1_Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int level = 0, age = 0, left = 0, come = 0, out = 0, old_level = 0, exp = 0;
        String ids = " ", pws = " ", id_oks = " ", pw_oks = " ", past_id = "";
        char yes = ' ';
        boolean check = false;
        boolean add = false;
        boolean login = false;
        boolean level_up = false;

        System.out.println("🧠 [뱅키] 안녕하세요! GSH_BANK에 오신 것을 환영합니다!");
        System.out.println("🎮 뱅키와 함께하는 게임형 은행 시스템을 즐겨보세요!");

        for (;;) {
            switch (level) {
                case 0:
                    System.out.println("\n===== GSH_BANK MENU =====");
                    System.out.println("1. 추가 (회원가입)");
                    System.out.println("2. 조회");
                    System.out.println("3. 입금");
                    System.out.println("4. 출금");
                    System.out.println("5. 삭제");
                    System.out.println("9. 종료");
                    System.out.print("입력 : ");
                    level = scanner.nextInt();
                    scanner.nextLine();

                    if (level >= 1 && level <= 5 || level == 9) {
                        if (!add && level != 1) {
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

                case 1:
                    System.out.println("\n👤 [회원가입]");
                    System.out.print("ID : ");
                    ids = scanner.nextLine();
                    if (past_id.equals(ids)) {
                        System.out.println("⚠ 이전과 같은 ID는 사용할 수 없습니다.");
                        continue;
                    }
                    System.out.print("PW : ");
                    pws = scanner.nextLine();
                    System.out.print("나이 : ");
                    age = scanner.nextInt();
                    System.out.print("초기 잔액 : ");
                    left = scanner.nextInt();
                    scanner.nextLine();

                    id_oks = ids;
                    pw_oks = pws;
                    add = true;

                    System.out.println("🎉 [뱅키] 환영합니다, " + ids + "님!");
                    level = 0;
                    break;

                case 2:
                    if (!login) {
                        System.out.println("\n🔒 [조회 기능] 로그인이 필요합니다.");
                        old_level = level;
                        level = 6;
                        break;
                    }
                    login = false;

                    System.out.println("\n📊 [잔액 조회]");
                    System.out.println("현재 잔액: " + left + "원");
                    printRank(left);
                    level = 0;
                    break;

                case 3:
                    if (!login) {
                        System.out.println("\n🔒 [입금 기능] 로그인이 필요합니다.");
                        old_level = level;
                        level = 6;
                        break;
                    }
                    login = false;

                    System.out.println("\n💰 [입금 기능]");
                    System.out.println("현재 잔액: " + left + "원");

                    while (true) {
                        System.out.print("입금 금액 입력: ");
                        come = scanner.nextInt();
                        scanner.nextLine();

                        if (come > 0) {
                            left += come;
                            exp += (come/10);
                            System.out.println("✅ 입금 완료! 현재 잔액: " + left + "원");
                            System.out.println("✨ 경험치 +10 ▶ 현재 경험치: " + exp);
                            printRank(left);
                            if (exp >= 100) {
                                System.out.println("🎉 레벨업! 보너스 지급 예정!");
                                exp = 0;
                                level_up = true;
                            }

                            // 🎁 복권 이벤트
							if (level_up == true) {
								int bonus = (int) (Math.random() * 3000);
								System.out.println("🎉 [레벨업 복권 보너스] 보너스 " + bonus + "원 당첨!");
								System.out.println("[묻고 떠블로가!] 주사위 숫자가 50미만일 경우 - 보너스*2 / 50이상일경우 - 0원");
								System.out.println("[묻고 떠블로가!] 이벤트에 도전하시겠습니까? (Y / N)");
								yes = scanner.next().charAt(0);
								if (yes == 'Y') {
									int chance = (int) (Math.random() * 100);
									if (chance < 50) {
										bonus *= 2;
										left += bonus;
										System.out.println("🎉 축하드립니다!");
										System.out.println("🎉 [묻고 떠블로가!] 이벤트 당첨! " + bonus + "원 지급!");
									} else {
										System.out.println("주사위의 숫자는 " + chance + " 입니다.");
										System.out.println("😢 아깝네요. 다음 기회에!");
									}
								} else {
									System.out.println("🎉 [레벨업 복권 보너스] 보너스 " + bonus + "원 지급!");
									left += bonus;
								}

								level_up = false;
							}

                            // 🎲 잔액 이스터에그
                            if (left == 77777) {
                                System.out.println("🎰 [럭키세븐 이벤트]");
                                System.out.print("주사위를 선택하세요 (1~6): ");
                                int choice = scanner.nextInt();
                                scanner.nextLine();
                                int rolled = (int)(Math.random() * 6) + 1;
                                if (choice == rolled) {
                                    System.out.println("🎊 주사위 대성공! 보너스 50000원 지급!");
                                    left += 50000;
                                } else {
                                	System.out.println("주사위의 숫자는 "+rolled+" 입니다.");
                                    System.out.println("😢 아깝네요. 다음 기회에!");
                                }
                            }

                            level = 0;
                            break;
                        } else {
                            System.out.println("❌ 음수나 0은 입금할 수 없습니다.");
                        }
                    }
                    break;

                case 4:
                    if (!login) {
                        System.out.println("\n🔒 [출금 기능] 로그인이 필요합니다.");
                        old_level = level;
                        level = 6;
                        break;
                    }
                    login = false;

                    System.out.println("\n🏧 [출금 기능]");
                    while (true) {
                        System.out.print("출금 금액 입력: ");
                        out = scanner.nextInt();
                        scanner.nextLine();
                        if (out <= left) {
                            left -= out;
                            exp += 10;
                            System.out.println("✅ 출금 완료! 현재 잔액: " + left + "원");
                            System.out.println("✨ 경험치 +10 ▶ 현재 경험치: " + exp);
                            printRank(left);
                            if (exp >= 100) {
                                System.out.println("🎉 레벨업! 보너스 지급 예정!");
                                exp = 0;
                            }
                            level = 0;
                            break;
                        } else {
                            System.out.println("❌ 출금 금액이 잔액보다 많습니다!");
                        }
                    }
                    break;

                case 5:
                    if (!login) {
                        System.out.println("\n🔒 [삭제 기능] 로그인이 필요합니다.");
                        old_level = level;
                        level = 6;
                        break;
                    }
                    login = false;

                    System.out.println("\n🗑️ [계정 삭제]");
                    past_id = id_oks;
                    id_oks = " ";
                    pw_oks = " ";
                    left = 0;
                    age = 0;
                    add = false;
                    exp = 0;
                    System.out.println("👋 계정이 성공적으로 삭제되었습니다.");
                    level = 0;
                    break;

                case 6:
                    System.out.println("\n🔐 [로그인]");
                    while (true) {
                        System.out.print("ID : ");
                        ids = scanner.nextLine();
                        System.out.print("PW : ");
                        pws = scanner.nextLine();
                        if (ids.equals(id_oks) && pws.equals(pw_oks)) {
                            level = old_level;
                            login = true;
                            System.out.println("✅ 로그인 성공!");
                            break;
                        } else {
                            System.out.println("❌ ID 또는 PW가 틀렸습니다.");
                        }
                    }
                    break;

                case 9:
                    System.out.println("\n👋 [뱅키] 이용해주셔서 감사합니다, " + id_oks + "님!");
                    check = true;
                    break;
            }

            if (check) {
                System.out.println("프로그램이 종료되었습니다.");
                break;
            }
        }
    }

    // 등급 출력 메서드
	public static void printRank(int balance) {
        String rank;
		if (balance >= 1000000) {
            rank = "💎 Diamond VIP";
        } else if (balance >= 500000) {
            rank = "🥇 Gold 고객";
        } else if (balance >= 100000) {
            rank = "🥈 Silver 고객";
        } else {
            rank = "🥉 Bronze 고객";
        }
        System.out.println("🏅 고객 등급: " + rank);
    }
}
