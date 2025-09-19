package com.company.java007_ex;

import java.util.Scanner;

public class Bank_Test_2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		final int MAX_USERS = 3;

		String[] ids = new String[MAX_USERS];
		String[] pws = new String[MAX_USERS];
		double[] weight = new double[MAX_USERS];
		int[] age = new int[MAX_USERS];
		int[] height = new int[MAX_USERS];
		String[] rank = new String[MAX_USERS];
		String[][] favorites = new String[MAX_USERS][5];

		int userCount = 0;
		int level = 0, old_level = 0;
		boolean login = false;
		boolean rank_check = false;
		int loginuser = -1;
		boolean found = false;
		boolean idExists = false;
		boolean foundRecipe = false;

		System.out.println("🍽️ [야미] 환영합니다! GSH_COOK 스마트 헬스 레시피 시스템입니다!");

		while (true) {
			switch (level) {
			case 0:
				System.out.println("\n===== 🍱 GSH_COOK MENU =====");
				System.out.println("1. 회원가입");
				System.out.println("2. 내 건강 정보 조회");
				System.out.println("3. 식단 추천 (칼로리 기반)");
				System.out.println("4. 요리 레시피 보기");
				System.out.println("5. 사용자 맞춤 식단 저장/조회");
				System.out.println("8. 회원 탈퇴");
				System.out.println("9. 종료");
				System.out.print("입력 : ");

				if (!scanner.hasNextInt()) {
					System.out.println("⚠ 올바른 메뉴를 선택해주세요.");
					scanner.nextLine();
					level = 0;
					continue;
				}

				level = scanner.nextInt();
				scanner.nextLine();

				if ((level >= 1 && level <= 5) || level == 9 || level == 8) {
					if (userCount == 0 && level != 1 && level != 9) {
						System.out.println("🧠 먼저 회원가입 해주세요! (1번)");
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
					System.out.println("⚠ 회원 공간이 가득 찼습니다.");
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

				System.out.println("\n👤 회원가입");
				System.out.print("ID : ");
				String newId = scanner.nextLine();

				idExists = false;
				for (int i = 0; i < MAX_USERS; i++) {
					if (ids[i] != null && ids[i].equals(newId)) {
						idExists = true;
						break;
					}
				}

				if (idExists) {
					System.out.println("⚠ 이미 존재하는 ID입니다.");
					level = 0;
					break;
				}

				System.out.print("PW : ");
				String newPw = scanner.nextLine();
				System.out.print("나이 : ");
				if (!scanner.hasNextInt()) {
					System.out.println("⚠ 나이는 숫자로 입력해주세요.");
					scanner.nextLine();
					level = 0;
					break;
				}
				int newAge = scanner.nextInt();

				if (newAge <= 18) {
					System.out.println("⚠ 만 19세 이상만 이용 가능합니다.");
					scanner.nextLine();
					level = 0;
					break;
				}

				System.out.print("체중 (kg): ");
				if (!scanner.hasNextDouble()) {
					System.out.println("⚠ 체중은 숫자로 입력해주세요.");
					scanner.nextLine();
					level = 0;
					break;
				}
				double newWeight = scanner.nextDouble();

				System.out.print("키 (cm): ");
				if (!scanner.hasNextInt()) {
					System.out.println("⚠ 키는 숫자로 입력해주세요.");
					scanner.nextLine();
					level = 0;
					break;
				}
				int newHeight = scanner.nextInt();
				scanner.nextLine();

				ids[newUserIndex] = newId;
				pws[newUserIndex] = newPw;
				age[newUserIndex] = newAge;
				weight[newUserIndex] = newWeight;
				height[newUserIndex] = newHeight;
				userCount++;

				System.out.println("🎉 환영합니다, " + newId + "님!");
				level = 0;
				break;

			case 2:
				if (!login) {
					System.out.println("\n🔐 [로그인 필요]");
					old_level = level;
					level = 6;
					break;
				}

				double heightM = height[loginuser] / 100.0;
				double bmi = weight[loginuser] / (heightM * heightM);

				System.out.println("\n📋 [건강 정보]");
				System.out.println("ID: " + ids[loginuser]);
				System.out.println("나이: " + age[loginuser] + "세");
				System.out.printf("체중: %.2f kg\n", weight[loginuser]);
				System.out.println("키: " + height[loginuser] + " cm");
				System.out.printf("BMI: %.2f\n", bmi);

				String rankStr = "";
				double nextGoalWeight = weight[loginuser];

				if (bmi < 18.5) {
					rankStr = "🍃 Underweight";
					nextGoalWeight = 18.5 * heightM * heightM;
					System.out.printf("등급: %s\n", rankStr);
					System.out.printf("건강 체중 이상이 되려면 최소 %.2f kg 증가가 필요합니다.\n", nextGoalWeight - weight[loginuser]);
				} else if (bmi < 23) {
					rankStr = "💪 Healthy";
					System.out.printf("등급: %s\n", rankStr);
					System.out.println("현재 건강한 상태입니다! 계속 유지하세요.");
				} else if (bmi < 25) {
					rankStr = "🍔 Overweight";
					nextGoalWeight = 23 * heightM * heightM;
					System.out.printf("등급: %s\n", rankStr);
					System.out.printf("다음 단계인 Healthy가 되려면 최소 %.2f kg 감량이 필요합니다.\n",
							weight[loginuser] - nextGoalWeight);
				} else {
					rankStr = "⚠ Obese";
					nextGoalWeight = 25 * heightM * heightM;
					System.out.printf("등급: %s\n", rankStr);
					System.out.printf("다음 단계인 Overweight가 되려면 최소 %.2f kg 감량이 필요합니다.\n",
							weight[loginuser] - nextGoalWeight);
				}

				rank[loginuser] = rankStr;

				rank_check = false;
				login = false;
				level = 0;
				break;

			case 3:
				if (!login) {
					System.out.println("\n🔐 [로그인 필요]");
					old_level = level;
					level = 6;
					break;
				}

				System.out.println("\n🥗 [식단 추천 - 칼로리 기반, 추가 영양소 검색 가능]");

				System.out.print("목표 칼로리 입력 (kcal): ");
				if (!scanner.hasNextInt()) {
					System.out.println("⚠ 숫자로 입력해주세요.");
					scanner.nextLine();
					level = 0;
					break;
				}
				int targetCalorie = scanner.nextInt();
				scanner.nextLine();

				System.out.print("단백질 기준으로 검색할까요? (y/n): ");
				boolean searchProtein = scanner.nextLine().equalsIgnoreCase("y");
				int targetProtein = 0;
				if (searchProtein) {
					System.out.print("목표 단백질량 입력 (g): ");
					if (!scanner.hasNextInt()) {
						System.out.println("⚠ 숫자로 입력해주세요.");
						scanner.nextLine();
						level = 0;
						break;
					}
					targetProtein = scanner.nextInt();
					scanner.nextLine();
				}

				System.out.print("탄수화물 기준으로 검색할까요? (y/n): ");
				boolean searchCarb = scanner.nextLine().equalsIgnoreCase("y");
				int targetCarb = 0;
				if (searchCarb) {
					System.out.print("목표 탄수화물 입력 (g): ");
					if (!scanner.hasNextInt()) {
						System.out.println("⚠ 숫자로 입력해주세요.");
						scanner.nextLine();
						level = 0;
						break;
					}
					targetCarb = scanner.nextInt();
					scanner.nextLine();
				}

				System.out.print("지방 기준으로 검색할까요? (y/n): ");
				boolean searchFat = scanner.nextLine().equalsIgnoreCase("y");
				int targetFat = 0;
				if (searchFat) {
					System.out.print("목표 지방 입력 (g): ");
					if (!scanner.hasNextInt()) {
						System.out.println("⚠ 숫자로 입력해주세요.");
						scanner.nextLine();
						level = 0;
						break;
					}
					targetFat = scanner.nextInt();
					scanner.nextLine();
				}

				System.out.println("\n🔍 조건에 맞는 레시피 검색 중...");

				String[][] recipes = {

						{ "닭가슴살 샐러드", "40", "10", "8", "350" }, { "두부 스테이크", "30", "15", "10", "300" },
						{ "연어구이", "45", "0", "25", "500" }, { "계란볶음밥", "20", "60", "15", "450" },
						{ "그릭요거트볼", "18", "30", "5", "250" }, { "닭가슴살 김치볶음밥", "35", "40", "10", "420" },
						{ "단호박 죽", "10", "50", "3", "280" }, { "닭죽", "20", "35", "5", "300" },
						{ "계란 샌드위치", "15", "20", "4", "200" }, { "닭가슴살 오트밀죽", "12", "35", "7", "320" } };

				for (int i = 0; i < recipes.length; i++) {
					int p = Integer.parseInt(recipes[i][1]);
					int c = Integer.parseInt(recipes[i][2]);
					int f = Integer.parseInt(recipes[i][3]);
					int kcal = Integer.parseInt(recipes[i][4]);

					if (Math.abs(targetCalorie - kcal) > 100)
						continue;

					if (searchProtein && Math.abs(targetProtein - p) > 10)
						continue;
					if (searchCarb && Math.abs(targetCarb - c) > 10)
						continue;
					if (searchFat && Math.abs(targetFat - f) > 10)
						continue;

					double runHours = kcal / 600.0;
					double swimHours = kcal / 480.0;

					System.out.println("🍱 추천 메뉴: " + recipes[i][0]);
					System.out.printf("  ▶ 단백질: %dg, 탄수화물: %dg, 지방: %dg, 총 칼로리: %dkcal\n", p, c, f, kcal);
					System.out.printf("  💨 소모하려면 ▶ 달리기: %.1f시간 / 수영: %.1f시간 필요\n", runHours, swimHours);
					System.out.println("--------------------------------------------------");
					foundRecipe = true;
				}

				if (!foundRecipe) {
					System.out.println("❌ 조건에 맞는 레시피가 없습니다.");
				}

				login = false;
				level = 0;
				break;

			case 4:
				if (!login) {
					System.out.println("\n🔐 [로그인 필요]");
					old_level = level;
					level = 6;
					break;
				}

				System.out.print("\n🍳 알고 싶은 요리명을 입력하세요: ");
				String inputMenu = scanner.nextLine();

				switch (inputMenu) {
				case "닭가슴살 샐러드":
					System.out.println("\n📘 [닭가슴살 샐러드 레시피]");
					System.out.println("재료: 닭가슴살, 로메인, 방울토마토, 오이, 발사믹 소스");
					System.out.println("1. 닭가슴살을 삶아 식힌 후, 얇게 찢는다.");
					System.out.println("2. 채소를 깨끗이 씻고 한 입 크기로 자른다.");
					System.out.println("3. 모든 재료를 볼에 담고 발사믹 소스를 뿌린다.");
					System.out.println("4. 가볍게 섞어 접시에 담아 완성한다.");
					break;

				case "두부 스테이크":
					System.out.println("\n📘 [두부 스테이크 레시피]");
					System.out.println("재료: 두부, 양파, 마늘, 간장, 밀가루");
					System.out.println("1. 두부는 물기를 제거하고 으깬다.");
					System.out.println("2. 잘게 썬 양파, 마늘과 섞고 간장으로 간을 한다.");
					System.out.println("3. 밀가루를 넣어 반죽한 후 스테이크 모양으로 만든다.");
					System.out.println("4. 팬에 노릇하게 구워 완성한다.");
					break;

				case "연어구이":
					System.out.println("\n📘 [연어구이 레시피]");
					System.out.println("재료: 연어, 올리브유, 소금, 후추, 레몬");
					System.out.println("1. 연어에 소금과 후추로 간을 한다.");
					System.out.println("2. 팬에 올리브유를 두르고 연어를 구운다.");
					System.out.println("3. 앞뒤로 노릇하게 익힌다.");
					System.out.println("4. 레몬즙을 뿌려 상큼하게 마무리한다.");
					break;

				case "계란볶음밥":
					System.out.println("\n📘 [계란볶음밥 레시피]");
					System.out.println("재료: 밥, 계란, 대파, 간장, 참기름");
					System.out.println("1. 팬에 기름을 두르고 파를 볶아 파기름을 만든다.");
					System.out.println("2. 계란을 풀어 스크램블을 만든다.");
					System.out.println("3. 밥을 넣고 잘 섞으며 볶는다.");
					System.out.println("4. 간장과 참기름을 넣어 간을 맞춘다.");
					break;

				case "그릭요거트볼":
					System.out.println("\n📘 [그릭요거트볼 레시피]");
					System.out.println("재료: 그릭요거트, 그래놀라, 꿀, 제철과일");
					System.out.println("1. 볼에 그릭요거트를 담는다.");
					System.out.println("2. 그래놀라를 올리고 과일을 올린다.");
					System.out.println("3. 꿀을 한 바퀴 두른다.");
					System.out.println("4. 숟가락으로 잘 섞어 즐긴다.");
					break;

				case "닭가슴살 김치볶음밥":
					System.out.println("\n📘 [닭가슴살 김치볶음밥 레시피]");
					System.out.println("재료: 닭가슴살, 김치, 밥, 간장, 참기름");
					System.out.println("1. 닭가슴살을 잘게 찢어 볶는다.");
					System.out.println("2. 김치를 넣고 함께 볶는다.");
					System.out.println("3. 밥을 넣고 간장으로 간을 한다.");
					System.out.println("4. 마지막에 참기름을 넣고 섞는다.");
					break;

				case "단호박 죽":
					System.out.println("\n📘 [단호박 죽 레시피]");
					System.out.println("재료: 단호박, 쌀, 소금, 우유");
					System.out.println("1. 단호박은 찐 후 껍질을 벗긴다.");
					System.out.println("2. 쌀은 불려서 준비한다.");
					System.out.println("3. 단호박과 쌀을 함께 끓이며 으깨준다.");
					System.out.println("4. 농도 조절을 위해 우유를 추가하고 간을 맞춘다.");
					break;

				case "닭죽":
					System.out.println("\n📘 [닭죽 레시피]");
					System.out.println("재료: 닭가슴살, 쌀, 마늘, 생강, 소금");
					System.out.println("1. 닭가슴살을 삶고 육수를 만든다.");
					System.out.println("2. 쌀은 불려서 준비한다.");
					System.out.println("3. 육수에 쌀과 닭가슴살을 넣고 끓인다.");
					System.out.println("4. 간을 하고 마늘과 생강으로 맛을 더한다.");
					break;

				case "계란 샌드위치":
					System.out.println("\n📘 [계란 샌드위치 레시피]");
					System.out.println("재료: 식빵, 삶은계란, 마요네즈, 머스타드, 소금");
					System.out.println("1. 삶은 계란을 으깬 후 마요네즈와 섞는다.");
					System.out.println("2. 소금과 머스타드로 간을 맞춘다.");
					System.out.println("3. 식빵에 속재료를 올린다.");
					System.out.println("4. 다른 식빵으로 덮어 반으로 자른다.");
					break;

				case "닭가슴살 오트밀죽":
					System.out.println("\n📘 [닭가슴살 오트밀죽 레시피]");
					System.out.println("재료: 오트밀, 닭가슴살, 우유, 소금, 후추");
					System.out.println("1. 닭가슴살을 익혀 잘게 찢는다.");
					System.out.println("2. 냄비에 오트밀과 우유를 넣고 끓인다.");
					System.out.println("3. 닭가슴살을 넣고 섞으며 끓인다.");
					System.out.println("4. 간을 맞추고 부드럽게 끓이면 완성.");
					break;

				default:
					System.out.println("⚠ 해당 요리는 등록되어 있지 않습니다.");
					break;
				}

			case 5:
				if (!login) {
					System.out.println("\n🔐 [로그인 필요]");
					old_level = level;
					level = 6;
					break;
				}

				System.out.println("\n⭐ 사용자 맞춤 식단 저장/조회");
				System.out.println("1. 식단 저장");
				System.out.println("2. 저장된 식단 조회");
				System.out.print("선택: ");
				int favOption = scanner.nextInt();
				scanner.nextLine();

				if (favOption == 1) {
					System.out.print("저장할 식단 이름을 입력하세요: ");
					String favMenu = scanner.nextLine();

					boolean alreadySaved = false;
					for (int i = 0; i < 5; i++) {
						if (favorites[loginuser][i] != null && favorites[loginuser][i].equals(favMenu)) {
							alreadySaved = true;
							break;
						}
					}

					if (alreadySaved) {
						System.out.println("⚠ 이미 저장된 식단입니다.");
					} else {
						boolean saved = false;
						for (int i = 0; i < 5; i++) {
							if (favorites[loginuser][i] == null) {
								favorites[loginuser][i] = favMenu;
								System.out.println("✅ 식단이 저장되었습니다: " + favMenu);
								saved = true;
								break;
							}
						}
						if (!saved) {
							System.out.println("❌ 저장 공간이 부족합니다. 최대 5개까지 저장 가능합니다.");
						}
					}

				} else if (favOption == 2) {
					System.out.println("📦 저장된 식단 목록:");
					boolean hasFavorites = false;
					for (int i = 0; i < 5; i++) {
						if (favorites[loginuser][i] != null) {
							System.out.println("- " + favorites[loginuser][i]);
							hasFavorites = true;
						}
					}
					if (!hasFavorites) {
						System.out.println("❌ 저장된 식단이 없습니다.");
					}
				} else {
					System.out.println("⚠ 올바른 번호를 선택해주세요.");
				}

				login = false;
				level = 0;
				break;

			case 6:

				System.out.println("\n🔐 로그인");
				System.out.print("ID: ");
				String inputId = scanner.nextLine();

				System.out.print("PW: ");
				String inputPw = scanner.nextLine();

				found = false;
				for (int i = 0; i < MAX_USERS; i++) {
					if (ids[i] != null && ids[i].equals(inputId) && pws[i].equals(inputPw)) {
						found = true;
						loginuser = i;
						login = true;
						System.out.println("✅ 로그인 성공! " + ids[i] + "님 환영합니다.");
						break;
					}
				}

				if (!found) {
					System.out.println("❌ 로그인 실패. ID 또는 PW가 올바르지 않습니다.");
					login = false;
				}
				level = old_level;
				break;
			case 8:
				if (!login) {
					System.out.println("\n🔐 [로그인 필요]");
					old_level = level;
					level = 6;
					break;
				}

				System.out.println("\n🗑️ 회원 탈퇴를 진행합니다.");
				ids[loginuser] = null;
				pws[loginuser] = null;
				age[loginuser] = 0;
				weight[loginuser] = 0;
				height[loginuser] = 0;
				rank[loginuser] = null;

				System.out.println("회원 탈퇴 완료.");
				userCount--;
				login = false;
				level = 0;
				break;

			case 9:
				System.out.println("프로그램 종료합니다. 감사합니다!");
				scanner.close();
				System.exit(0);

			default:
				System.out.println("⚠ 올바른 메뉴를 선택해주세요.");
				level = 0;
				break;
			}
		}
	}
}
