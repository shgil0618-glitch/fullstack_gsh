package com.company.javaex_test;


public class TestEx015_4 {
	public static void main(String[] args) {
		
		int nums[] = new int[4];
		int data=10;
		
		for(int i=1; i<nums.length; i++) {
			nums[0] = 0;
			nums[i] = 10 + nums[i-1];
			System.out.print(nums[i] + " ");
		}
	}
}

