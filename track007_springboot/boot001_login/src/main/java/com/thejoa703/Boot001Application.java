package com.thejoa703;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Boot001Application { 
	public static void main(String[] args) {
		SpringApplication.run(Boot001Application.class, args);
	}

}


/*
  insert into sboard2 ( ID    , APP_USER_ID , btitle, bcontent, bpass, bfile,  bip )
  select  sboard2_seq.nextval , APP_USER_ID , btitle, bcontent, bpass, bfile,  bip   from sboard2;

*/