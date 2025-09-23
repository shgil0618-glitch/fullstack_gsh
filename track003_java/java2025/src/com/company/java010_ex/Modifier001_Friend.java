package com.company.java010_ex;


class ToyBox {
    public String sharedToy = "블록";
    private String secretToy = "로봇";
    		String familyToy = "퍼즐";
}


public class Modifier001_Friend{
	public static void main(String[] args) {
		ToyBox box = new ToyBox();
        System.out.println(box.sharedToy);
 //       System.out.println(box.secretToy);
        System.out.println(box.familyToy);
	}
}
