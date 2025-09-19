package com.company.java006_ex;

import java.util.Scanner;

public class Bank002_Array_2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		final int MAX_USERS = 3; // 최대 회원 수

		String ids[] = new String[MAX_USERS];
		String pws[] = new String[MAX_USERS];
		double balance[] = new double[MAX_USERS];
		int age[] = new int[MAX_USERS];
		int exp[] = new int[MAX_USERS];
		String rank[] = new String[MAX_USERS];

		boolean add[] = new boolean[MAX_USERS]; // 가입여부 확인
		int userCount = 0; // 현재 가입한 회원 수

		int level = 0, old_level = 0;
		int come = 0, out = 0;
		boolean check = false;
		boolean login = false;
		boolean level_up = false;
		boolean rank_check = false;
		int loginuser = -1; // 로그인 된 사용자의 MAX_USERSR값 저장

		System.out.println("🧠 [뱅키] 안녕하세요! GSH_BANK에 오신 것을 환영합니다!");
		System.out.println("🎮 뱅키와 함께하는 은행 시스템을 즐겨보세요!");

		for (;;) {
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
					if (userCount == 0 && level != 1) {
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
				if (userCount >= MAX_USERS) {
					System.out.println("⚠ 더 이상 회원가입 할 수 없습니다.");
					level = 0;
					break;
				}

				System.out.println("\n👤 회원가입 ");
				System.out.print("ID : ");
				String newId = scanner.nextLine();

				// 중복 ID 체크
				boolean idExists = false;
				for (int i = 0; i < userCount; i++) {
					if (ids[i].equals(newId)) {
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

				// 회원정보 저장
				ids[userCount] = newId;
				pws[userCount] = newPw;
				age[userCount] = newAge;
				balance[userCount] = newBalance;
				exp[userCount] = 0;
				add[userCount] = true;
				userCount++;
				loginuser = userCount - 1;

				System.out.println("🎉 [뱅키] 환영합니다, " + newId + "님!");
				level = 0;
				break;

			case 2:
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

			case 3:
				if (!login) {
					System.out.println("\n🔒 [입금 기능] 로그인이 필요합니다.");
					old_level = level;
					level = 6;
					break;
				}

				if (!rank_check) {
					System.out.println("\n💰 [입금 기능]");
					System.out.printf("현재 잔액: %.2f원\n", balance[loginuser]);
				}
				for (;;) {
					if (!rank_check) {
						System.out.print("입금 금액 입력: ");
						come = scanner.nextInt();
						scanner.nextLine();
					}

					if (come > 0) {
						if (!rank_check) {
							balance[loginuser] += come;
							exp[loginuser] += (come / 10);
							old_level = level;
							level = 7;
							break;
						}
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

				System.out.println("\n🏧 [출금 기능]");
				for (;;) {
					if (rank_check) {
						System.out.print("출금 금액 입력: ");
						out = scanner.nextInt();
						scanner.nextLine();
					}
					if (out <= balance[loginuser]) {

						if (!rank_check) {
							balance[loginuser] -= out;
							exp[loginuser] += 10;
							old_level = level;
							level = 7;
							break;
						}
						System.out.printf("✅ 출금 완료! 현재 잔액: %.2f원\n", balance[loginuser]);
						System.out.println("✨ 경험치 +10 ▶ 현재 경험치: " + exp[loginuser]);
						System.out.println("🏅 고객 등급: " + rank[loginuser]);
						rank_check = false;
						login = false;

						if (exp[loginuser] >= 100) {
							System.out.println("🎉 레벨업! 보너스 지급 예정!");
							exp[loginuser] = 0;
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
				for (int i = loginuser; i < userCount - 1; i++) {
					ids[i] = ids[i + 1];
					pws[i] = pws[i + 1];
					balance[i] = balance[i + 1];
					age[i] = age[i + 1];
					exp[i] = exp[i + 1];
					add[i] = add[i + 1];
				}
				userCount--;
				loginuser = -1;
				System.out.println("👋 계정이 성공적으로 삭제되었습니다.");
				level = 0;
				break;

			case 6:	//로그인 기능
				System.out.println("\n🔐 [로그인]");
				for (;;) {
					System.out.print("ID : ");
					String inputId = scanner.nextLine();
					System.out.print("PW : ");
					String inputPw = scanner.nextLine();

					boolean found = false;
					for (int i = 0; i < userCount; i++) {
						if (ids[i].equals(inputId) && pws[i].equals(inputPw)) {
							loginuser = i;
							level = old_level;
							login = true;
							found = true;
							System.out.println("✅ 로그인 성공!");
							break;
						}
					}
					if (found)
						break;
					else
						System.out.println("❌ ID 또는 PW가 틀렸습니다.");
				}
				break;

			case 7:	//랭크 기능
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

			case 9:
				if (loginuser != -1) {
					System.out.println("\n👋 [뱅키] 이용해주셔서 감사합니다, " + ids[loginuser] + "님!");
				} else {
					System.out.println("\n👋 [뱅키] 이용해주셔서 감사합니다!");
				}
				check = true;
				break;
			}

			if (check) {
				System.out.println("프로그램이 종료되었습니다.");

				break;
			}
		}
		scanner.close();
	}

}
