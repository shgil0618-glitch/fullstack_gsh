package com.company.java008_ex;

import java.util.Scanner;

public class MethodEx006_2 {
	public static void main(String[] args) {
		/*
		int maxuser = 3;
		String name[] =new String[maxuser];
		int attack[] = new int[maxuser];
		int defense[] =new int[maxuser];
		int speed[] = new int[maxuser];
		int total[] = new int[maxuser];
		float avg[] = new float[maxuser];
		String grade[] = new String[maxuser], star[] = new String[maxuser], quest[] = new String[maxuser], type[] = new String[maxuser];
		Scanner scanner = new Scanner(System.in);

		name = process_name(scanner);
		attack = process_int("공격력");
		defense = process_int("방어력");
		speed = process_int("민첩성");

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
	
	public static int process_int(String std) {
		Scanner scanner = new Scanner(System.in);
		System.out.printf("%s을 설정하시오 : ",std);
		return scanner.nextInt();
	}
	
	
	
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
				*/
	}
}