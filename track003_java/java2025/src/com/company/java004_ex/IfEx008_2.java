package com.company.java004_ex;

import java.util.Scanner;

public class IfEx008_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int kor, eng, mat, total;
        double avg;
        String ch, a, level, b;

        System.out.print("학번 입력 : ");
        ch = scanner.nextLine();
        System.out.print("국어 점수 입력 : ");
        kor = scanner.nextInt();
        System.out.print("영어 점수 입력 : ");
        eng = scanner.nextInt();
        System.out.print("수학 점수 입력 : ");
        mat = scanner.nextInt();

        total = kor + eng + mat;
        avg = total / 3.0;

        a = ( avg < 60 ? "불합격" : kor>=40 && eng>=40 && mat>=40 ? "합격" : "" );

        b = ( (avg >= 95) ? "장학생" : "X" );

   
        level =  ( (avg >= 90) ? "수" : (avg >= 80) ? "우" :
                   (avg >= 70) ? "미" : (avg >= 60) ? "양" : "가" );

        System.out.println("=================================================================================== ");
        System.out.println("학번\t국어\t영어\t수학\t총점\t평균\t합격여부\t레벨\t레벨장학생 ");
        System.out.println("=================================================================================== ");
        System.out.printf("%s\t%d\t%d\t%d\t%d\t%.2f\t%s\t%s\t%s",
                ch, kor, eng, mat, total, avg, a, level, b);

    }
}
