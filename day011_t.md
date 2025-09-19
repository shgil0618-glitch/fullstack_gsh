## Track001 -  github


# ■ Github   
### 12. 깃허브 협업 
---
1조 : 유희재, 한승현, 김정민, 강서현
2조 : 성태훈, 길상현, 박현주, 임경민
3조 : 최상욱, 김영민, 신준용
3i1e         : https://github.com/kyoungsjjj0211/portfolio.git
드래곤치킨     : https://github.com/taehun00/dragonchicken.git
트리플윈      : https://github.com/suda77881/triple1

# ■ Java
■ 복습문제
■1. Java  복습문제
■1. Java  복습문제
■1. Java  복습문제

>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

■ 복습문제 (1)
1. 자바 우선순위를 적으시오.
()   값( ++ , -- , + , - )  비교(>,<, == ) 조건(&& ||)   대입(=)

■ 복습문제 (2)
2. 다음코드에서 오류나는 부분을 찾아 해결하시오.
char ch = 'A';
ch = ch+32;

> 해결
ch = (char) (ch+32);

■ 복습문제 (3)
3. 다음 조건식을 작성하시오.
char형 변수 ch가 영문자(대문자 또는 소문자) 일때   true인 조건식   
if(  ch >= 'A' && ch <='Z'   ||  ch >= 'a' && ch <='z'    )  

■ 복습문제 (4)  eclipse
클래스명 :  Repeat011
출력내용 :  계산기

1. 정수를 하나 입력해주세요 > 10
2. 정수를 하나 입력해주세요 > 3
3. 연산자를 입력해주세요(+,-,*,/) > +
10+3=13 

```
package com.company.java004_ex;
import java.util.Scanner;

public class IfEx007_1 {
	public static void main(String[] args) {
		//변수
		int num1, num2; String result ="";
		char op;
		Scanner scanner = new Scanner(System.in);
		//입력
		System.out.print("1. 정수를 하나 입력해주세요 >");
		num1 = scanner.nextInt();
		System.out.print("2. 정수를 하나 입력해주세요 >");
		num2 = scanner.nextInt();
		System.out.print("3. 연산자를 입력해주세요(+,-,*,/) >");
		op = scanner.next().charAt(0);
		//처리    출력  숫자   연산자  숫자    = 
		
		result = "" + num1 + op + num2 + "=";  
 
		if(op == '+') {  result += (num1+num2);  }
		else if(op == '-') {  result += (num1-num2);  }
		else if(op == '*') {  result += (num1*num2);  }
		else if(op == '/') {  result += String.format("%.2f"  , (double)num1/num2);  }
		 
		     
		//출력
		System.out.println(result);
	}
}
```

■13. 조건문  (2)
1. 프로그램 코드 실행흐름
  - 위 → 아래, 왼쪽 → 오른쪽
  - 제어문은 개발자가 원하는 방향으로 변경할수 있도록 도와줌.

2. 제어문의 종류
    조건문      : if , switch  
    반복문      : for# , while # , do while #
    제어키워드 : break , continue


1) for( 초기문; 조건문; 증감문  ){  반복해야할 내용  }    -  반복횟수를 알고 있을때
2) while( 조건문 ){    반복해야할 내용 }  - 반복횟수 모를때   예)게시판
   
   초기문; 
   while( 조건문  ){  반복해야할 내용        증감문; } 

3) do{  반복해야할 내용  }while( 조건문  ); - 무조건 1번은 실행

   초기문; 
   do{  반복해야할 내용        증감문; }while( 조건문  ); 

4) 무한반복
for(;;){
   // 빠져나올조건
}


5) break/continue
1. for - break
// 1 2  - 3뒤로 없어짐! break           
for(int i=1; i<=10; i++) {
  if(i==3) {break;}
  System.out.print(i + "\t");
}

// for - continue - skip
// 1 2 (3) 4 5 6 7 8 9 10
for(int i=1; i<=10; i++) {
   if(i==3) {continue;}
   System.out.print(i + "\t");
}



>>>>> 진도 switch

연습문제1)  
패키지명 : com.company.java004_ex
클래스명 :  SwitchEx001
출력내용 :  switch 이용
     숫자한개 입력받아
     3이면 봄
     6이면 여름
     9이면 가을
     12이면 겨울

```java
package com.company.java004_ex;

import java.util.Scanner;

public class SwitchEx001 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num1;
		
		System.out.print("숫자 한개를 입력하시오(3,6,9,12) : ");
		num1 = scanner.nextInt();
		
		switch(num1) {
		case 3 : System.out.println("봄 입니다."); break;
		case 6 : System.out.println("여름 입니다."); break;
		case 9 : System.out.println("가을 입니다."); break;
		case 12 : System.out.println("겨울 입니다."); break;
		}
	}
}

```

연습문제2)  
패키지명 : com.company.java004_ex
클래스명 :  SwitchEx002
출력내용 :   switch 이용
     숫자한개 입력받아
     3,4,5이면 봄
     6,7,8이면 여름
     9,10,11이면 가을
     12,1,2이면 겨울

```java
package com.company.java004_ex;

import java.util.Scanner;

public class SwitchEx002 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num1;
		
		System.out.print("숫자 한개를 입력하시오 : ");
		num1 = scanner.nextInt();
		
		switch(num1) {
		case 1:case 2:case 12: System.out.println("겨울 입니다."); break;
		case 3:case 4:case 5: System.out.println("봄 입니다."); break;
		case 6:case 7:case 8: System.out.println("여름 입니다."); break;
		case 9:case 10:case 11: System.out.println("가을 입니다."); break;
		}
	}
}
```


연습문제3)  3
패키지명 : com.company.java004_ex
클래스명 :  SwtichEx003
출력내용 :  계산기

1. 정수를 하나 입력해주세요 > 10
2. 정수를 하나 입력해주세요 > 3
3. 연산자를 입력해주세요(+,-,*,/) > +
10+3=13

1. 정수를 하나 입력해주세요 > 10
2. 정수를 하나 입력해주세요 > 3
3. 연산자를 입력해주세요(+,-,*,/) > -
10-3=7 

```java
package com.company.java004_ex;

import java.util.Scanner;

public class SwitchEx003 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num1,num2;
		char ch;
		double result = 0;
		
		System.out.print("정수를 입력하시오 : ");
		num1 = scanner.nextInt();
		System.out.print("정수를 입력하시오 : ");
		num2 = scanner.nextInt();
		System.out.print("연산자를 입력하시오 : ");
		ch = scanner.next().charAt(0);
		
		switch(ch) {
		case '+' : result = num1 + num2; break;
		case '-' : result = num1 - num2; break;
		case '*' : result = num1 * num2; break;
		case '/' : result = (double)num1 / num2; break;
		default : System.out.println("올바른 연산자가 아닙니다.");
		}
		
		
		if(ch == '/') {System.out.printf("%d %s %d = %.2f",num1,ch,num2,(Object)(double)result);}
		else {System.out.printf("%d %s %d = %d",num1,ch,num2,(Object)(int)result);}
	}
}
	
```



>>>>> 진도 for
# ■ Java

■ 개념정리
```java
package com.company.java005;

public class Repeat001_For {
	public static void main(String[] args) {
	//step 1	system.out.print() 3번 사용해서 1 2 3
	System.out.println("step1");
	System.out.print(1 + "\t");	// 복사할 구문
	System.out.print(2 + "\t");	// ctrl + c , ctrl + 2번
	System.out.print(3 + "\t");	// 안에 숫자 2,3
	// for(시작;종료;변화){구문}
	
	//step 2
	System.out.println("\n\nstep2");	//{ } { 변수 } for(시작;종료;변화)
	for(int i=1;i<=3;i++){
		System.out.print(i + "\t");
	}
	
	//step 3 
	System.out.println("\n\nstep3");
	// 1~5
	for(int i=1;i<=5;i++){ System.out.print(i + "\t"); }	//ctrl+alt+j 한줄로 만들기
	System.out.println();
	
	// 11~20
	for(int i=11;i<=20;i++){ System.out.print(i + "\t"); }	//ctrl+alt+j 한줄로 만들기
	System.out.println();
	
	// 3~8
	for(int i=3;i<=8;i++){ System.out.print(i + "\t"); }	//ctrl+alt+j 한줄로 만들기
	System.out.println();
	
	// 1 3 5
	for(int i=1;i<=5;i=i+2){ System.out.print(i + "\t"); }	//ctrl+alt+j 한줄로 만들기
	System.out.println();
	
	// hello1 hello2 hello3
	for(int i=1;i<=3;i++) {System.out.print("hello" + i +"\t");}
	System.out.println();
	}
}

```

■ 연습문제

연습문제1)  
패키지명 : com.company.java005_ex
클래스명 :  ForEx001
출력내용 :   for 이용
q1  for문을 이용해서 다음과 같이 출력하시오 :   1 2 3 4 5 
q2  for문을 이용해서 다음과 같이 출력하시오 :   5 4 3 2 1 
q3  for문을 이용해서 다음과 같이 출력하시오 :   JAVA1   JAVA2  JAVA3  
q4  for문을 이용해서 다음과 같이 출력하시오 :   HAPPY3   HAPPY2  HAPPY1  
q5  for문을 이용해서 다음과 같이 출력하시오 :   0,1,2  
q6  for문을 이용해서 다음과 같이 출력하시오 :   0,1,2, ,,,중간생략 ,,, 99  
q7  for문을 이용해서 다음과 같이 출력하시오 :   10, 9,,,,중간생략 ,,, , 1 
q8  for문을 이용해서 다음과 같이 출력하시오 :   0, 2, 4, 6, 8 
q9  for문을 이용해서 다음과 같이 출력하시오 :   0, 2, 4, 6, 8 ,,,중간생략 ,,, 18 

```java
package com.company.java005_ex;

import java.util.Scanner;

public class ForEx001 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int i,j;
		for(i=1;i<=9;i++) {
			switch(i) {
			case 1 : System.out.print("q"+i + " for문을 이용해서 다음과 같이 출력하시오 : ");
			for(j=1;j<=5;j++) {System.out.print( j+"\t");}
			System.out.println();
			break;
			
			case 2 : System.out.print("q"+i + " for문을 이용해서 다음과 같이 출력하시오 : ");
			for(j=5;j>=1;j--) {System.out.print( j+"\t");}
			System.out.println();
			break;
			
			case 3 : System.out.print("q"+i + " for문을 이용해서 다음과 같이 출력하시오 : ");
			for(j=1;j<=3;j++) {System.out.print("java"+ j+"\t");}
			System.out.println();
			break;
			
			case 4 : System.out.print("q"+i + " for문을 이용해서 다음과 같이 출력하시오 : ");
			for(j=3;j>=1;j--) {System.out.print("happy"+ j+"\t");}
			System.out.println();
			break;
			
			case 5 : System.out.print("q"+i + " for문을 이용해서 다음과 같이 출력하시오 : ");
			for(j=1;j<=3;j++) {System.out.print( j+"\t");}
			System.out.println();
			break;
			
			case 6 : System.out.print("q"+i + " for문을 이용해서 다음과 같이 출력하시오 : ");
			for(j=1;j<=99;j++) {System.out.print( j+"\t");}
			System.out.println();
			break;
			
			case 7 : System.out.print("q"+i + " for문을 이용해서 다음과 같이 출력하시오 : ");
			for(j=10;j>=1;j--) {System.out.print( j+"\t");}
			System.out.println();
			break;
			
			case 8 : System.out.print("q"+i + " for문을 이용해서 다음과 같이 출력하시오 : ");
			for(j=0;j<=8;j=j+2) {System.out.print( j+"\t");}
			System.out.println();
			break;
			
			case 9 : System.out.print("q"+i + " for문을 이용해서 다음과 같이 출력하시오 : ");
			for(j=0;j<=18;j=j+2) {System.out.print( j+"\t");}
			System.out.println();
			break;
			}
		}
	}
}
```

연습문제2)  
패키지명 : com.company.java005_ex
클래스명 :  ForEx002
출력내용 :   for 이용

   사용자에게 단을 입력받아 해당하는 
   단을 출력해주는 프로그램을 작성하시오. FOR문을 이용하시오.

```java
package com.company.java005_ex;

import java.util.Scanner;

public class ForEx002 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num1;
		
		System.out.print("원하는 단을 입력하시오(구구단) : ");
		num1 = scanner.nextInt();
		
		for(int i=1;i<=9;i++) {
			System.out.print(num1+"x"+i +"="+ (num1*i) + "\t");
		}
		System.out.println();
	}
}
```

연습문제3)  
패키지명 : com.company.java005_ex
클래스명 :  ForEx003
출력내용 :   for 이용
1~10까지의 합을 구하시오.

upgrade)  시간나면 도전!
1+2+3+4+5+6+7+8+9+10=55

```java
package com.company.java005_ex;

import java.util.Scanner;

public class ForEx003 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int i,j=0,z=0;
		
		for(i=1;i<=10;i++) {
			j += i;
		}
		System.out.println(j);
		
		
		for (i=1;i<=10;i++) {
			if(i==10) { System.out.print(i); }
			else { System.out.print(i+"+"); }
			z += i;	
		}
		System.out.print("="+j);
		
		
	}
}
```

연습문제4)  
패키지명 : com.company.java005_ex
클래스명 :  ForEx004
출력내용 :   for 이용
1~10까지 3의 배수 갯수를 출력   

upgrade)  시간나면 도전!
3의배수 : 3,6,9    
갯수 : 3개

```java
package com.company.java005_ex;

import java.util.Scanner;

public class ForEx004 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int i,j=0,k=0;
		
		
		System.out.print("3의 배수 : ");		
		for(i=1;i<=10;i++) {
			if(i%3==0) {
				j++;
				if(i==9)
				{ System.out.print(i); }
				else
				{System.out.print(i+",");}	

			}
		}
		
		System.out.println();
		System.out.println("3의 배수 갯수 : " +j);
	}
}
```

연습문제5)  
패키지명 : com.company.java005_ex
클래스명 :  ForEx005
출력내용 :   for 이용
소문자 a~z까지 모음의 갯수를 출력하시오. 

```java
package com.company.java005_ex;

import java.util.Scanner;

public class ForEx005 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int i,j=0,k=0;
		
		for(i=97;i<=122;i++) {
			switch(i) {
			case 'a' : j++; break;
			case 'e' : j++; break;
			case 'i' : j++; break;
			case 'o' : j++; break;
			case 'u' : j++; break;
			default : k++;
			}
		}
		System.out.println("소문자 a~z까지 모음의 갯수는 = " +j);
		System.out.println("소문자 a~z까지 자음의 갯수는 = " +k);
		
	}
}
```

연습문제6)  
패키지명 : com.company.java005_ex
클래스명 :  Repeat_Ex006
출력내용 :  문자열 숫자 더하기
ex - 12345 -> 15

```java
package com.company.java005_ex;

import java.util.Scanner;

public class Repeat_Ex006 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String ch="";
		char val;
		int str,hap=0;
		
		System.out.print("숫자열을 입력하시오 : ");
		ch = scanner.nextLine();
		
		str = ch.length();
		for(int i=0;i<str;i++) {
		val = ch.charAt(i);
		hap += (int)val-48;
		}
		System.out.println(hap);
		
	}
}
```


연습문제7)  
패키지명 : com.company.java005_ex
클래스명 :  Repeat_Ex007
출력내용 :  회문수 판별 프로그램

```java
package com.company.java005_ex;

import java.util.Scanner;

public class Repeat_Ex007 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = "";
		int str1=0, str2=0;
		
		System.out.print("문자 혹은 숫자열을 입력하시오 : ");
		input = scanner.nextLine();
		
		str1 = input.length();
		str2 = str1/2;
		boolean ok = false;
		
		for(int i=0;i<str2;i++) {
			if(input.charAt(i) == input.charAt(str1-1-i)) {ok = true;} 	
		}
		if(ok) {
		System.out.println("입력하신 문자는 회문수 입니다. (O)");
		}
		else {
		System.out.println("입력하신 문자는 회문수가 아닙니다. (X)"); 
		}
	}
}
```




# ■ WebBasic
## 6 배치요소

■1. Web  Basic  복습문제
■1. Web  Basic  복습문제
■1. Web  Basic  복습문제
■1. Web  Basic  복습문제

1. <>
2. <h1> + validator
3. css 많이쓰는 친구들~
4. css 배치 (float , position , display)

### 1. block vs inline
1) box model  
- 콘텐츠가 자리하는 영역을 의미하며, 박스의 구성 요소는 
   content(내용)  ,  padding , border , margin 로 이루어진다.

2) block 요소  
- width/height 설정이 (O/X): O  
- 앞뒤 줄바꿈이 (O/X): O  
- 대표 태그: div , p , h3

3) inline 요소  
- width/height 설정이 (O/X): X  
- 앞뒤 줄바꿈이 (O/X): X  
- 대표 태그: a, strong , span


### 2. 배치(1) - float
- 요소를 좌우로 배치할 때 사용하는 속성은  float 이다.  
- 다음 요소의 흐름을 정리하려면 clear속성을 사용한다.  
- float를 끊는 대표적인 방법은 클래스명으로  .clear 를 사용한다.
.clear{  clear:both ; }

### 3. 배치(2) - position
- 자식 요소를 부모 기준으로 위치시키려면 부모에  relative , 자식에 absolute를 설정한다.  
- 브라우저 전체 기준으로 고정하려면 fixed 속성을 사용한다.  
- position의 주요 값 4가지는  relative , absolute , fixed , static 이다.


### 4. 배치(3) - display
- 요소의 기본 속성을 바꾸려면 display 속성을 사용한다.  
- block 요소를 inline처럼 보이게 하려면 inline,  
  inline 요소를 block처럼 보이게 하려면 block 값을 사용한다.

Q1. block요소를 inline으로,    width X , 줄바꿈 X
ul.d1  li{ display:inline; }

Q2. block요소를 inline-block으로,  width O , 줄바꿈 X
ul.d2  li{ display:inline-block;  width:100px;}

Q3. inline을 block 요소로,  링크영역확대
a.github{  display:block;  width:100px; margin:auto; }

Q4. 왼쪽, 오른쪽으로 배치시  (float) 사용해야하며 float끊을때는 (clear:both) 
div.left{  width:20%;  float:left; }
div.right{ width:20%;  float:right;}
div.clear{ clear:both; }

Q5. .space를 기준으로  .astronaut 오른쪽상단(10px 10px) 가  배치
<div class="space">
	<div class="astronaut"></div>
</div>
.space{  position:relative;  }
.astronaut { position:absolute;  top:10px; right:10px; }

Q6. 화면고정위치 브라우저에 고정( 오른쪽0 , 아래쪽:10%)
.satellite{   position:fixed;  right:0; bottom:10%;}




■ ■ ■  복습문제 DAY011
■ ■ ■  복습문제 DAY011
■ ■ ■  복습문제 DAY011

PART001) JAVA
복습문제1) 다음을 if로 작성하시오.
클래스명 :  Repeat012_1
출력내용 : 숫자한개를 입력받아    
	만약 1을 입력했다면   one ,	
	만약 2을 입력했다면   two ,
	만약 3을 입력했다면   three ,
	1,2,3이 아니라면  1,2,3이 아니다를 출력하는 프로그램을 작성하시오.


복습문제2) 다음을  switch로 작성하시오.
클래스명 :  Repeat012_2
출력내용 : 숫자한개를 입력받아    
	만약 1을 입력했다면   one ,	
	만약 2을 입력했다면   two ,
	만약 3을 입력했다면   three ,
	1,2,3이 아니라면  1,2,3이 아니다를 출력하는 프로그램을 작성하시오.


복습문제3) 다음을 for로 작성하시오.
클래스명 :  Repeat012_3
출력내용 : 
q1  for문을 이용해서 다음과 같이 출력하시오 :   1 2 3 4 5 
q2  for문을 이용해서 다음과 같이 출력하시오 :   5 4 3 2 1 
q3  for문을 이용해서 다음과 같이 출력하시오 :   JAVA1   JAVA2  JAVA3  




>>>> CSS
CSS 다음 빈칸에 알맞은 코드를 채우시오.
Q1. block요소를 inline으로,    width X , 줄바꿈 X
ul.d1  li{    ①   }

Q2. block요소를 inline-block으로,  width O , 줄바꿈 X
ul.d2  li{ ②   width:100px;}

Q3. inline을 block 요소로,  링크영역확대
a.github{  ③    width:100px; margin:auto; }

Q4. 왼쪽, 오른쪽으로 배치시     (  ④    )     사용해야하며 float끊을때는 (   ⑤    ) 
div.left{  width:20%;    ⑥ }   왼쪽배치
div.right{ width:20%;  ⑦  }  오른쪽배치
div.clear{ ⑧ }    float끊기

Q5. .space를 기준으로  .astronaut 오른쪽상단(10px 10px) 가  배치
<div class="space">
   <div class="astronaut"></div>
</div>
.space{  ⑨  }
.astronaut { ⑩   }    오른쪽상단(10px 10px)

Q6. 화면고정위치 브라우저에 고정( 오른쪽0 , 아래쪽:10%)
.satellite{  ⑪   }    브라우저에 고정( 오른쪽0 , 아래쪽:10%)





■ ■ ■  복습문제 DAY011 - ANSWER
■ ■ ■  복습문제 DAY011 - ANSWER
■ ■ ■  복습문제 DAY011 - ANSWER

>>>> JAVA

복습문제1) 다음을 if로 작성하시오.
클래스명 :  Repeat012_1
출력내용 : 숫자한개를 입력받아    
	만약 1을 입력했다면   one ,	
	만약 2을 입력했다면   two ,
	만약 3을 입력했다면   three ,
	1,2,3이 아니라면  1,2,3이 아니다를 출력하는 프로그램을 작성하시오.

```
package com.company.java004;
import java.util.Scanner;

public class Repeat012_1 {
	public static void main(String [] args) {
		// 변수
		int  a=0;
		Scanner scanner = new Scanner(System.in);
		// 입력
		System.out.print("숫자 한개 입력 > ");
		a = scanner.nextInt();
		// 처리+출력 (1)  if (조건식이 복잡하고 여러개일때  && >= )
		     if( a == 1) {  System.out.println("1이다");}  //else 부분 안봄
		else if( a == 2) {  System.out.println("2이다");}
		else if( a == 3) {  System.out.println("3이다");}
 
	}
}
```



복습문제2) 다음을  switch로 작성하시오.
클래스명 :  Repeat012_2
출력내용 : 숫자한개를 입력받아    
	만약 1을 입력했다면   one ,	
	만약 2을 입력했다면   two ,
	만약 3을 입력했다면   three ,
	1,2,3이 아니라면  1,2,3이 아니다를 출력하는 프로그램을 작성하시오.

```
package com.company.java004;
import java.util.Scanner;

public class Repeat012_1 {
	public static void main(String [] args) {
		// 변수
		int  a=0;
		Scanner scanner = new Scanner(System.in);
		// 입력
		System.out.print("숫자 한개 입력 > ");
		a = scanner.nextInt();
		// 처리+출력 (2)  switch case  break (처리대상 1,2,3)
		     switch(a) {  // 처리대상 
		     case 1 : /* a==1 */System.out.println("1이다"); break;
		     case 2 : /* a==2 */System.out.println("2이다"); break; 
		     case 3 : /* a==3 */System.out.println("3이다"); break;
	     }  
	}
}
```




복습문제3) 다음을 for로 작성하시오.
클래스명 :  Repeat012_3
출력내용 :  
q1  for문을 이용해서 다음과 같이 출력하시오 :   1 2 3 4 5 
q2  for문을 이용해서 다음과 같이 출력하시오 :   5 4 3 2 1 
q3  for문을 이용해서 다음과 같이 출력하시오 :   JAVA1   JAVA2  JAVA3  

```
package com.company.java004;
import java.util.Scanner;

public class Repeat012_3 {
	public static void main(String [] args) {
 		System.out.println("\nq1 : 1 2 3 4 5 ");
		for(int i=1; i<=5; i++) {  System.out.print(i+ "\t"); }
		

		System.out.println("\nq2 : 5 4 3 2 1  ");
		for(int i=5; i>=1; i--) {  System.out.print(i+ "\t"); }
		

		System.out.println("\nq3 : JAVA1   JAVA2  JAVA3   "); 
		for(int i=1; i<=3; i++){System.out.print(" JAVA" + i );  }  //{}  {변수}  for()
	}
}
```



>>>> CSS
CSS 다음 빈칸에 알맞은 코드를 채우시오.
Q1. block요소를 inline으로,    width X , 줄바꿈 X
ul.d1  li{ display:inline; }

Q2. block요소를 inline-block으로,  width O , 줄바꿈 X
ul.d2  li{ display:inline-block;  width:100px;}

Q3. inline을 block 요소로,  링크영역확대
a.github{  display:block;  width:100px; margin:auto; }

Q4. 왼쪽, 오른쪽으로 배치시  (float) 사용해야하며 float끊을때는 (clear:both) 
div.left{  width:20%;  float:left; }
div.right{ width:20%;  float:right;}
div.clear{ clear:both; }

Q5. .space를 기준으로  .astronaut 오른쪽상단(10px 10px) 가  배치
<div class="space">
   <div class="astronaut"></div>
</div>
.space{  position:relative;  }
.astronaut { position:absolute;  top:10px; right:10px; }

Q6. 화면고정위치 브라우저에 고정( 오른쪽0 , 아래쪽:10%)
.satellite{   position:fixed;  right:0; bottom:10%;}