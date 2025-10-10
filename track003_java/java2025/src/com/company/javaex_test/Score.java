package com.company.javaex_test;

import java.util.Arrays;

public class Score {
    String name;
    int kor, eng, math;
    double avg;
    String pass;
    
    public Score() {
		super();
		// TODO Auto-generated constructor stub
	}

    
	


	@Override
	public String toString() {
		return "Score [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", avg=" + avg + ", pass="
				+ pass + "]";
	}





	public Score(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }
}

