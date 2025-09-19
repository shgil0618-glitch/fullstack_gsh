package com.company.java007_ex;

import java.util.Scanner;

public class Bank_Test_Method {
    static final int MAX_USERS = 3;

    static String[] ids = new String[MAX_USERS];
    static String[] pws = new String[MAX_USERS];
    static double[] weight = new double[MAX_USERS];
    static int[] age = new int[MAX_USERS];
    static int[] height = new int[MAX_USERS];
    static String[] rank = new String[MAX_USERS];

    static boolean login = false;
    static int loginuser = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int level = 0;
        int old_level = 0;
        int userCount = 0;

        System.out.println("🍽️ [야미] 환영합니다! GSH_COOK 스마트 헬스 레시피 시스템입니다!");

        while (true) {
            switch (level) {
                case 0:
                    System.out.println("\n===== 🍱 GSH_COOK MENU =====");
                    System.out.println("1. 회원가입");
                    System.out.println("2. 내 건강 정보 조회");
                    System.out.println("3. 식단 추천 (칼로리 기반)");
                    System.out.println("9. 종료");
                    System.out.print("입력 : ");

                    if (!scanner.hasNextInt()) {
                        System.out.println("⚠ 올바른 입력을 선택해주세요.");
                        scanner.nextLine();
                        level = 0;
                        continue;
                    }
                    level = scanner.nextInt();
                    scanner.nextLine();

                    if ((level >= 1 && level <= 3) || level == 9) {
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

                case 1: // 회원가입
                    if (userCount >= MAX_USERS) {
                        System.out.println("⚠ 회원 공간이 가득 찼습니다.");
                        level = 0;
                        break;
                    }
                    if (registerUser(scanner)) {
                        userCount++;
                    }
                    level = 0;
                    break;

                case 2: // 건강 정보 조회
                    if (!login) {
                        old_level = level;
                        login(scanner);
                        level = old_level;
                        break;
                    }
                    showHealthInfo();
                    login = false;  // 조회 후 로그아웃 처리 (필요에 따라 삭제 가능)
                    level = 0;
                    break;

                case 3: // 식단 추천
                    if (!login) {
                        old_level = level;
                        login(scanner);
                        level = old_level;
                        break;
                    }
                    recommendDiet(scanner);
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

    // 회원가입 메서드
    private static boolean registerUser(Scanner scanner) {
        System.out.println("\n👤 회원가입");

        System.out.print("ID : ");
        String newId = scanner.nextLine();
        for (int i = 0; i < MAX_USERS; i++) {
            if (ids[i] != null && ids[i].equals(newId)) {
                System.out.println("⚠ 이미 존재하는 ID입니다.");
                return false;
            }
        }

        System.out.print("PW : ");
        String newPw = scanner.nextLine();

        System.out.print("나이 : ");
        Integer newAge = inputInt(scanner);
        if (newAge == null) {
            System.out.println("⚠ 나이는 숫자로 입력해주세요.");
            return false;
        }
        if (newAge <= 18) {
            System.out.println("⚠ 만 19세 이상만 이용 가능합니다.");
            return false;
        }

        System.out.print("체중 (kg): ");
        Double newWeight = inputDouble(scanner);
        if (newWeight == null) {
            System.out.println("⚠ 체중은 숫자로 입력해주세요.");
            return false;
        }

        System.out.print("키 (cm): ");
        Integer newHeight = inputInt(scanner);
        if (newHeight == null) {
            System.out.println("⚠ 키는 숫자로 입력해주세요.");
            return false;
        }

        // 빈 자리 찾아 저장
        for (int i = 0; i < MAX_USERS; i++) {
            if (ids[i] == null) {
                ids[i] = newId;
                pws[i] = newPw;
                age[i] = newAge;
                weight[i] = newWeight;
                height[i] = newHeight;
                System.out.println("🎉 환영합니다, " + newId + "님!");
                return true;
            }
        }
        // 공간 없으면 false
        return false;
    }

    // 로그인 메서드
    private static void login(Scanner scanner) {
        System.out.println("\n🔐 로그인");
        System.out.print("ID: ");
        String inputId = scanner.nextLine();

        System.out.print("PW: ");
        String inputPw = scanner.nextLine();

        login = false;
        loginuser = -1;

        for (int i = 0; i < MAX_USERS; i++) {
            if (ids[i] != null && ids[i].equals(inputId) && pws[i].equals(inputPw)) {
                login = true;
                loginuser = i;
                System.out.println("✅ 로그인 성공! " + ids[i] + "님 환영합니다.");
                return;
            }
        }
        System.out.println("❌ 로그인 실패. ID 또는 PW가 올바르지 않습니다.");
    }

    // 건강 정보 조회 메서드
    private static void showHealthInfo() {
        double bmi = calculateBMI(weight[loginuser], height[loginuser]);

        System.out.println("\n📋 [건강 정보]");
        System.out.println("ID: " + ids[loginuser]);
        System.out.println("나이: " + age[loginuser] + "세");
        System.out.printf("체중: %.2f kg\n", weight[loginuser]);
        System.out.println("키: " + height[loginuser] + " cm");
        System.out.printf("BMI: %.2f\n", bmi);

        String rankStr = "";
        double nextGoalWeight;
        double heightM = height[loginuser] / 100.0;

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
    }

    // 식단 추천 메서드
    private static void recommendDiet(Scanner scanner) {
        System.out.println("\n🍽️ [식단 추천]");

        System.out.print("하루 권장 칼로리를 입력해주세요 (숫자만): ");
        Integer calories = inputInt(scanner);
        if (calories == null) {
            System.out.println("⚠ 숫자만 입력 가능합니다.");
            return;
        }

        System.out.println(calories + " kcal에 맞는 식단 추천 중...");
        // 추천 로직은 임의 예시입니다.
        if (calories < 1500) {
            System.out.println("🥗 저칼로리 식단: 샐러드, 닭가슴살, 현미밥");
        } else if (calories < 2500) {
            System.out.println("🍲 표준 식단: 불고기, 채소, 밥");
        } else {
            System.out.println("🍖 고칼로리 식단: 스테이크, 감자튀김, 크림소스 파스타");
        }
    }

    // BMI 계산 메서드
    private static double calculateBMI(double weightKg, int heightCm) {
        double heightM = heightCm / 100.0;
        return weightKg / (heightM * heightM);
    }

    // 정수 입력 검증 및 입력 메서드
    private static Integer inputInt(Scanner scanner) {
        if (!scanner.hasNextInt()) {
            scanner.nextLine();
            return null;
        }
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }

    // 실수 입력 검증 및 입력 메서드
    private static Double inputDouble(Scanner scanner) {
        if (!scanner.hasNextDouble()) {
            scanner.nextLine();
            return null;
        }
        double value = scanner.nextDouble();
        scanner.nextLine();
        return value;
    }
}
