package com.company.java010_ex;

public class Score{
	   private String name;
	   private int kor, eng, math , total;
	   private double aver;
	   private String p  , s  , rank="";
	   
	   
	   
	   @Override
	public String toString() {
		return "Score [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", total=" + total
				+ ", aver=" + aver + ", p=" + p + ", s=" + s + ", rank=" + rank + "]";
	}
	   public String getName() {
		   return name;
	   }
	   public void setName(String name) {
		   this.name = name;
	   }
	   public int getKor() {
		   return kor;
	   }
	   public void setKor(int kor) {
		   this.kor = kor;
	   }
	   public int getEng() {
		   return eng;
	   }
	   public void setEng(int eng) {
		   this.eng = eng;
	   }
	   public int getMath() {
		   return math;
	   }
	   public void setMath(int math) {
		   this.math = math;
	   }
	   public int getTotal() {				//트러블 슈팅 - private로 만들었을때 get,set안만들어놓으면 외부에서 접근을 못하니깐 만들어놓는게 좋다?
		return total;
	}
	   public void setTotal(int total) {
		   this.total = total;
	   }
	   public double getAver() {
		   return aver;
	   }
	   public void setAver(double aver) {
		   this.aver = aver;
	   }
	   public String getP() {
		   return p;
	   }
	   public void setP(String p) {
		   this.p = p;
	   }
	   public String getS() {
		   return s;
	   }
	   public void setS(String s) {
		   this.s = s;
	   }
	   public String getRank() {
		   return rank;
	   }
	   public void setRank(String rank) {
		   this.rank = rank;
	   }
	   public Score() {
		 super();
		this.name = "iron";
		this.kor = 100;
		this.eng = 100;
		this.math = 100;
	}
	   public Score(String name, int kor, int eng, int math) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;	
	}
	   
	   public void total() {
		   this.total = this.kor+this.eng+this.math;
	   } 
	   public void aver() {
		   this.aver = this.total/3.0;
	   }
	   public void p() {
		   if(this.aver >70) {this.p = "합격";}
			else {this.p = "불합격";}
	   }
	   public void s() {
		   if(this.aver >95) {this.s = "장학생";}
			else {this.s = "X";}
	   }
	   public void rank() {
		   for(int i=0;i<aver/10;i++) {
				this.rank += "*";
			}
	   }
	   
	   public static void info(){			
		   System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		   System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t합격여부\t장학생\t랭킹\t");
		   System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
	   }
	   public void show(){
		   total();
		   aver();
		   p();
		   s();
		   rank();
		  System.out.printf("%s\t%d\t%d\t%d\t%d\t%.2f\t%s\t%s\t%s \n",this.name,this.kor,this.eng,this.math,this.total,this.aver,this.p,this.s,this.rank);
	   }         

	} // java011_ex에 설정해주세요!

