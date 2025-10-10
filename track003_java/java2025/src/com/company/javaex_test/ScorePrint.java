package com.company.javaex_test;

public class ScorePrint {
    
	
    public ScorePrint() {
    }

    public void show(Score[] std) {
    	System.out.println("이름\t국어\t영어\t수학\t평균\t합격여부");
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::");
        for (Score s : std) {
        System.out.printf("%s\t%d\t%d\t%d\t%.2f\t%s\n",
                s.name, s.kor, s.eng, s.math, s.avg, s.pass);
        }
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::");
        
    }


}
