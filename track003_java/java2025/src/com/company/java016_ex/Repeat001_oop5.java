package com.company.java016_ex;
import com.company.javaex_test.Score;
import com.company.javaex_test.ScorePrint;
import com.company.javaex_test.ScoreProcess;

public class Repeat001_oop5 {
	  public static void main(String[] args) {
			Score[] std = new Score[3]; 
			std[0] = new Score("아이언맨", 100, 100, 100);  
			std[1] = new Score("헐크", 90, 60, 80);        
			std[2] = new Score("블랙팬서", 20, 60, 90);  
			
			ScoreProcess process = new ScoreProcess();
			process.process_avg(std);
			process.process_pass(std);
			
			ScorePrint  print = new ScorePrint();
			print.show(std); 
	
	  }
}
