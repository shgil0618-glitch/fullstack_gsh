package com.company.javaex_test;

public class ScoreProcess {
	
	
    public ScoreProcess() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void process_avg(Score[] std) {
        for (Score s : std) {
            s.avg = (s.kor + s.eng + s.math) / 3.0;
        }
        
    }

    public void process_pass(Score[] std) {
        for (Score s : std) {
            if (s.avg >= 60 && s.kor >= 40 && s.eng >= 40 && s.math >= 40) {
                s.pass = "합격";
            } else {
                s.pass = "불합격";
            }
        }
    }
}
