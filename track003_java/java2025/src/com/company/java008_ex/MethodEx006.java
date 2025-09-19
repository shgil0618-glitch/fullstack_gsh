package com.company.java008_ex;

import java.util.Scanner;

public class MethodEx006 {
	public static void main(String[] args) {
		String name = "";
		int attack = 0;
		int defense = 0;
		int speed = 0;
		int total = 0;
		float avg = 0.0f;
		String grade = "", star = "", quest = "", type = "";
		Scanner scanner = new Scanner(System.in);

		name = process_name(scanner);
		attack = process_int(scanner,0);
		defense = process_int(scanner,1);
		speed = process_int(scanner,2);
		/*
		attack = process_attack(scanner);
		defense = process_defense(scanner);
		speed = process_speed(scanner);
		process_input(scanner);z
		*/
		
		total = process_total(attack, defense, speed);
		avg = process_avg(total); 
		grade = process_grade(avg); 
		star = process_star(avg); 
		quest = process_quest(avg); 
		type = process_type(attack, defense, speed); 

		process_show(name, attack, defense, speed, total, avg, grade, star, quest, type);
	}
	
	public static String process_name(Scanner scanner) {
		String name = "";
		System.out.print("캐릭터 이름을 설정하시오 : ");
		name = scanner.nextLine();
		return name;
	}
	
	public static int process_int(Scanner scanner,int i) {
		String std[] = {"공격력","방어력","민첩성"};
		int num = 0;
		System.out.printf("%s을 설정하시오 : ",std[i]);
		num = scanner.nextInt();
		return num;
	}
	
	/*
	public static void process_input(Scanner scanner) {
		String name = "";
		int attack = 0;
		int defense = 0;
		int speed = 0;
		System.out.print("캐릭터 이름을 설정하시오 : ");
		name = scanner.nextLine();
		System.out.print("공격력을 설정하시오 : ");
		attack = scanner.nextInt();
		System.out.print("방어력을 설정하시오 : ");
		defense = scanner.nextInt();
		System.out.print("민첩성을 설정하시오 : ");
		speed = scanner.nextInt();
	}
	
	
	public static int process_attack(Scanner scanner) {
		int attack = 0;
		System.out.print("공격력을 설정하시오 : ");
		attack = scanner.nextInt();
		return attack;
	}
	public static int process_defense(Scanner scanner) {
		int defense = 0;
		System.out.print("방어력을 설정하시오 : ");
		defense = scanner.nextInt();
		return defense;
	}
	public static int process_speed(Scanner scanner) {
		int speed = 0;
		System.out.print("민첩성을 설정하시오 : ");
		speed = scanner.nextInt();
		return speed;
	}
	*/
	
	
	public static int process_total(int attack, int defense, int speed) {
		int total = 0;
		total = attack + defense + speed;
		return total;
	}

	public static float process_avg(int total) {
		float avg = 0.0f;
		avg = (float)total / 3;	//소수점 나오게
		return avg;
	}

	public static String process_grade(float avg) {
		String grade = "";
		if (avg == 100) {
			grade = "S랭크";
		} else if (avg > 90) {
			grade = "A랭크";
		} else if (avg > 80) {
			grade = "B랭크";
		} else if (avg > 70) {
			grade = "C랭크";
		} else {
			grade = "F랭크";
		}
		return grade;
	}

	public static String process_star(float avg) {
		String star = "";
		for (int i = 0; i < (int)avg/10; i++) {
			star += '*';
		}
		return star;
	}

	public static String process_quest(float avg) {
		String quest = "";
		if (avg == 100) {
			quest = "[S]전설의 용 퇴치";
		} else if (avg > 90) {
			quest = "[A]와이번 퇴치";
		} else if (avg > 80) {
			quest = "[B]트롤 퇴치";
		} else if (avg > 70) {
			quest = "[C]고블린 퇴치";
		} else {
			quest = "[F]슬라임 퇴치";
		}
		return quest;
	}

	public static String process_type(int attack, int defense, int speed) {
		String type = " ";
		if (attack > defense && attack > speed) {
			type = "전사형";
		}
		if (defense > attack && defense > speed) {
			type = "탱커형";
		}
		if (speed > defense && speed > attack) {
			type = "도적형";
		} else {
			type = "다재다능형";
		}
		return type;
	}

	public static void process_show(String name, int attack, int defense, int speed, int total, float avg, String grade,
			String star, String quest, String type) {
		System.out.println(
				":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		System.out.println("캐릭터\t공격력\t방어력\t민첩성\t총합\t평균\t등급\t랭킹\t\t추천퀘스트\t\t캐릭터타입");
		System.out.println(
				"-------------------------------------------------------------------------------------------------");
		System.out.printf("%s\t%d\t%d\t%d\t%d\t%.1f\t%s\t%s\t%s\t%s\n", name, attack, defense, speed, total, avg, grade,
				star, quest, type);
		System.out.println(
				"-------------------------------------------------------------------------------------------------");
	}
}
/*
 * 연습문제6) 패키지명: com.company.java008_ex 클래스명: MethodEx006 1. 당신은 게임 캐릭터의 능력치를
 * 분석하는 프로그램을 만들려고 합니다. 사용자로부터 캐릭터 (이름과 공격력, 방어력, 민첩성)을 입력받아 (총합, 평균, 등급, 별표 랭킹,
 * 추천 퀘스트, 캐릭터 타입)을 출력하는 프로그램을 작성하세요.
 * 
 * 
 * 1 (1단계) 변수 선언 아래와 같은 변수를 선언하세요: - `String name` : 캐릭터 이름 - `int attack,
 * defense, speed` : 능력치 - `int total` : 능력치 총합 - `float avg` : 평균 - `String
 * grade, star, quest, type` : 등급, 별표, 퀘스트, 캐릭터 타입 - `Scanner scanner` : 입력 도구
 * 
 * 2 (2단계) 입력 처리 사용자로부터 다음 정보를 입력받으세요: - 캐릭터 이름 - 공격력 (0~100) - 방어력 (0~100) -
 * 민첩성 (0~100)
 * 
 * 3 (3단계) 메서드 작성 및 호출 아래 기능을 각각 메서드로 작성하고, main 메서드에서 호출하세요:
 * 
 * | 기능 | 메서드명 | 설명 | |------|----------|------| | 총합 계산 | `process_total()` |
 * 공격력 + 방어력 + 민첩성 | | 평균 계산 | `process_avg()` | 총합 ÷ 3 | | 등급 처리 |
 * `process_grade()` | 평균에 따라 S~D 등급 | | 별표 처리 | `process_star()` | 평균 점수대별 별 개수
 * | | 퀘스트 추천 | `process_quest()` | 평균에 따라 추천 퀘스트 | | 캐릭터 타입 | `process_type()`
 * | 가장 높은 능력치 기준 |
 * 
 * 
 * 4 (4단계) 출력 메서드 작성 `process_show()` 메서드를 만들어 다음 정보를 출력하세요:
 * 
 * :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
 * :::::::::::::::::::: 캐릭터 공격력 방어력 민첩성 총합 평균 등급 랭킹 추천퀘스트 캐릭터타입
 * -----------------------------------------------------------------------------
 * -------------------- 피카츄 85 90 95 270 90.0 S등급 ********* 전설의 용 퇴치 도적형
 * -----------------------------------------------------------------------------
 * --------------------
 * 
 * 5 보너스 과제 (선택) - 평균이 100점이면 “전설의 영웅” 칭호를 부여해보세요. - 여러 캐릭터를 배열로 입력받아 비교하는 기능으로
 * 확장해보세요.
 * 
 * 
 */
