package com.company.java006_ex;

public class ArrayEx08_3 {
	public static void main(String[] args) {

		String[] name = { "아이언맨", "헐크", "캡틴", "토르", "호크아이" };
		int[] kor = { 100, 100, 70, 100, 35 };
		int[] eng = { 100, 100, 80, 100, 100 };
		int[] mat = { 100, 100, 60, 100, 100 };
		int[] aver = new int[5];
		int total[] = new int[5];
		String pass[] = new String[5];
		String mvp[] = new String[5];
		int temp[] = new int[5];
		int rank[] = new int[5];
		int rank2[] = new int[5];
		int store = 0;
		int same=0;

		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		System.out.println("이름\t\t국어\t영어\t수학\t평균\t합격여부\t장학생\t오름차순\t등수");
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		for (int i = 0; i < name.length; i++) {
			total[i] += kor[i] + eng[i] + mat[i];
			aver[i] = total[i] / 3;
			temp[i] = aver[i];
			if (aver[i] >= 60) {
				pass[i] = "합격";
			} else {
				pass[i] = "불합격";
			}

			if (aver[i] >= 95) {
				mvp[i] = "장학생";
			} else {
				mvp[i] = "----";
			}
		}

		for (int i = 0; i < name.length - 1; i++) {
			for (int j = i; j < name.length - i - 1; j++) {
				if (temp[j] < temp[j + 1]) {
					store = temp[j];
					temp[j] = temp[j + 1];
					temp[j + 1] = store;
				}
			}
		}
		for (int i = 0; i < name.length; i++) {
			for (int z = 0; z < name.length; z++) {
				if (temp[i] == aver[z]) {
					rank2[z] = i+1;
				}
			}
		}

		for (int i = 0; i < name.length; i++) {
			rank[i] = 1;
			for (int j = 0; j < name.length; j++) {
				if (aver[i] < aver[j]) {
					for(int z=0; z<name.length-1;z++) {
						if(aver[z]==aver[z+1]) {
							same++;
						}
					}
					rank[i]++;
					
				}
				
			}
		}

		for (int i = 0; i < name.length; i++) {
			System.out.printf("%s\t\t%d\t%d\t%d\t%d\t%s\t%s\t%d\t%d", name[i], kor[i], eng[i], mat[i], aver[i], pass[i],
					mvp[i], rank2[i], rank[i]);
			System.out.println();
		}
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
	}
}
