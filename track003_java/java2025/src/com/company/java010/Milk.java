package com.company.java010;

public class Milk{  // java011_ex에 설정해주세요!
	   private int  mno;   
	   private String mname;  
	   private  int mprice;
	   
	   
	   public Milk() {
		super();
		// TODO Auto-generated constructor stub
	}
	   
	   public Milk(int mprice) {
		super();
		this.mprice = mprice;
	}

	   public int getMprice() {
		   return mprice;
	   }
	   public void setMprice(int mprice) {
		   this.mprice = mprice;
	   }
	   @Override
	   public String toString() {
		return "Milk [mno=" + mno + ", mname=" + mname + ", mprice=" + mprice + "]";
	   }  
	  
	}