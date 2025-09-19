package com.company.javaex_test;

public class TestEx020_7 {
	   public static void main(String[] args) {
		      int arr[] = {1,2,3};
		      System.out.println( print(arr[1]) );
		      print(arr);
		      System.out.println(Arrays.toString(arr));
		   }
		   public static void print(int arr[]) {
		      for(int i =0; i<arr.length;i++) {
		         arr[i] +=10;
		      }
		   }
		   public static int print(int num) {
			   return num+10;
		   }
		   
		   /* 
		    ##1. 저자리는 뭔가의 반환값이 있어야 하는데 메서드가 void형으로 아무 자료형값도 반환하지 않게 떄문에 오류발생
		    ##2. 재대로 print매서드 대로 계산된 후 {11,12,13} 출력
		    */
}
