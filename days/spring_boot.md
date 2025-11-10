1. jsp(mvc1,mvc2) + oracle
2. spring
3. spring boot

■
---------------------
#1. SPRING 특징
---------------------
▶ STEP0. JSP
1. MVC1 - JSP (CONTROLLER) 스파게티
2. MVC2 - SERVLET (CONTROLLER) 부품조립

▶ STEP1. SW 재사용 방안들
Q. SW 재사용
- COPY & PASTE , 복붙
- 메서드
- 클래스의 사용
 <<INTERFACE>>
    BoardService - exec()
        △.....BList
        △.....BInsert

STEP2. 프레임워크
프레임워크? ★
[디자인패턴 + 라이브러리 = 프레임워크]
1. 디자인패턴 (가이드라인)
2. 라이브러리 (특정기술구현을 라이브러리의 형태) $("#id").on("click",); , $.ajax()

- 소프트웨어 개발의 뼈대역할
- 애플리케이션들의 최소한의 공통점을 찾아서 하부구조를 제공
    개발자들은 개발에 집중
- 제공되는 유틸의 모음, 레시피들의 모음

2-2 프레임워크의 주체
프레임워크는 [프레임워크]에서 실행흐름을 담당.
※ 라이브러리는 [개발자]가 실행흐름을 담당.

3. 프레임워크의 특징
★ IOC (Inversion Of Control) 제어의 역전
- 인스턴스의 생성~소멸까지 개발자가 아닌 컨테이너가 하는것
- POJO (Plain Old Java Object)
   필요에 따라 재활용 될 수 있는 방식으로 설계된 객체

Class A{
A a1 = new A();
}
생성 -> 초기화 -> 서비스 -> 소멸
※ IOC 아닌 경우 [개발자 생성 -> CLASS ALIST -> ] 컨테이너
※ IOC 일 경우 [개발자 사용 <- CLASS ALIST <- ] 컨테이너

★ IOC 분류
DI ( Dependency Injection : 의존성 주입 )
 - 각 클래스 간의 의존관계 [설정파일]을 통해 [컨테이너]가 자동으로 연결


4. 프레임워크 구성기능 요소
[ AOP ] [ ORM-DAO-MyBatis,Jpa ] [ Spring Web MVC ] ... 
[ Spring Core  ]



실습1)  spring1     [◎ 프로젝트명 : spring001]
  1. 스프링 3버젼 다운로드
  2. 다운로드 경로
      https://github.com/spring-attic/toolsuite-distribution/wiki/Spring-Tool-Suite-3
  3. 압축풀기
  4.  E:\hyojung\6_spring\sts-bundle\sts-3.9.18.RELEASE
      > STS.exe
  5.  순수 스프링버젼
    1. dynamic web project - spring001
    2. configure  - [Convert to Maven Project]
    3. spring      - add Spring project Nature
    4. java se-11 / project facts, build path
    5. junit - 4


실습2) spring2 
> 1. 롬복 셋팅
> 2. IOC + DI 관계

1. 프로젝트 만들기
2. 롬복 다운로드
3. 롬복 설치
4. 스프링에서 사용하기


---
5. ioc + di
DI : 각 클래스간의 의존관계

    [AnimalFarm]  (사용)→    [<<interface>>Animal]   
   ↑(삽입)           ↑(구현)          ↑ (구현)   
    [beans.xml ]  (생성)→     [Cat                /                  Dog]


```
<!-- 수정 -->
<!-- 수정 -->
<dependencies>
   <!-- https://mvnrepository.com/artifact/junit/junit -->
   <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.12</version>
      <scope>test</scope>
   </dependency>
   <!-- https://mvnrepository.com/artifact/org.springframework/spring-context -->
   <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-context</artifactId>
      <version>4.3.27.RELEASE</version>
   </dependency>
   <!-- https://mvnrepository.com/artifact/org.springframework/spring-test -->
   <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-test</artifactId>
      <version>4.3.27.RELEASE</version>
      <scope>test</scope>
   </dependency>
   
   <!--  MYSQL + CONNECTOR-J       -->
   <dependency>
      <groupId>com.oracle.database.jdbc</groupId>
      <artifactId>ojdbc11</artifactId>
      <version>21.9.0.0</version>
   </dependency>
   <!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
   <dependency>
       <groupId>mysql</groupId>
       <artifactId>mysql-connector-java</artifactId>
       <version>8.0.28</version>
   </dependency>
   <!-- https://mvnrepository.com/artifact/org.springframework/spring-jdbc -->
   <dependency>
       <groupId>org.springframework</groupId>
       <artifactId>spring-jdbc</artifactId>
       <version>4.3.20.RELEASE</version>
   </dependency>
         
   <!-- MYBATIS -->
   <!-- https://mvnrepository.com/artifact/org.mybatis/mybatis -->
   <dependency>
       <groupId>org.mybatis</groupId>
       <artifactId>mybatis</artifactId>
       <version>3.5.6</version>
   </dependency>
   <!-- https://mvnrepository.com/artifact/org.mybatis/mybatis-spring -->
   <dependency>
       <groupId>org.mybatis</groupId>
       <artifactId>mybatis-spring</artifactId>
       <version>2.0.6</version>
   </dependency>
   
   <!-- webmvc -->
   <!-- webmvc -->
   <!-- webmvc -->
      <!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
   <dependency>
       <groupId>org.springframework</groupId>
       <artifactId>spring-webmvc</artifactId>
       <version>3.2.17.RELEASE</version>
   </dependency>
   
    <!-- https://mvnrepository.com/artifact/javax.servlet/jstl -->
    <!-- https://mvnrepository.com/artifact/javax.servlet/jstl -->
   <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>jstl</artifactId>
      <version>1.2</version>
   </dependency>
         
   <!-- LOMBOK  -->      
   <!-- https://mvnrepository.com/artifact/org.projectlombok/lombok -->
   <dependency>
       <groupId>org.projectlombok</groupId>
       <artifactId>lombok</artifactId>
       <version>1.18.18</version>
       <scope>provided</scope>
   </dependency>            
         
   <!-- AOP -->   
   <!-- AOP -->      
   <!-- https://mvnrepository.com/artifact/org.aspectj/aspectjrt -->
   <dependency>
       <groupId>org.aspectj</groupId>
       <artifactId>aspectjrt</artifactId>
       <version>1.7.3</version>
      <!-- <scope>runtime</scope> -->
   </dependency>
   <!-- https://mvnrepository.com/artifact/org.aspectj/aspectjweaver -->
   <dependency>
       <groupId>org.aspectj</groupId>
       <artifactId>aspectjweaver</artifactId>
       <version>1.7.3</version>
       <!-- <scope>runtime</scope> -->
   </dependency>
   <!-- https://mvnrepository.com/artifact/org.springframework/spring-aop -->
   <dependency>
       <groupId>org.springframework</groupId>
       <artifactId>spring-aop</artifactId>
       <version>4.3.28.RELEASE</version>
   </dependency>
         
         
   <!-- HikariCP -->
   <!-- HikariCP -->
   <!-- https://mvnrepository.com/artifact/com.zaxxer/HikariCP -->
   <dependency>
       <groupId>com.zaxxer</groupId>
       <artifactId>HikariCP</artifactId>
       <version>2.7.4</version>
   </dependency>
      
   <!-- https://mvnrepository.com/artifact/org.bgee.log4jdbc-log4j2/log4jdbc-log4j2-jdbc4 -->
   <dependency>
       <groupId>org.bgee.log4jdbc-log4j2</groupId>
       <artifactId>log4jdbc-log4j2-jdbc4</artifactId>
       <version>1.16</version>
   </dependency>
   <!-- HikariCP -->
   <!-- HikariCP -->
   <!-- HikariCP -->          
         
</dependencies>
<!-- 수정 -->
<!-- 수정 -->  
```



1. 구성확인
    [AnimalFarm]  (사용)→    [<<interface>>Animal]   
   ↑(삽입)        ↑(구현)       ↑ (구현)   
    [beans.xml ]  (생성)→     [Cat     /   Dog]

    >> di? 각클래스의 의존관계를 [설정파일]을통해서 컨테이너가 자동연결


  1) 인터페이스
     com.company.ioctest  
   interface Animal
   ----------------------------------
   public interface Animal {
      public String eat();
      public String sleep();
      public String poo();
   }
   ----------------------------------

   2) 구현클래스  
      com.company.ioctest  
      Cat 
      Dog  
   
   package com.company.ioc;
   public class Cat  implements Animal{
      @Override public String eat() { return "Cat-eat"; }
      @Override public String sleep() { return "Cat-sleep"; }
      @Override public String poo() { return "Cat-poo"; }
   } 


   3) 사용클래스 - AnimalFarm 
   package com.company.ioc;

   public class AnimalFarm {
      private String name;
      private Animal ani;
   
      public AnimalFarm() { super(); }
      public String getName() { return name; }
      public void setName(String name) { this.name = name; }
      public Animal getani() { return ani; }
      public void setani(Animal ani) { this.ani = ani; }
   
      public String aniSleep() { return name + ">" + ani.sleep(); }
      public String aniEat()   { return name + ">" + ani.eat(); }
      public String aniPoo()   { return name + ">" + ani.poo(); }
   
      public void print() { 
         System.out.println(  aniSleep()); 
         System.out.println(  aniEat()); 
         System.out.println(  aniPoo()); 
      }

   }


QUESTION1)  DI -   property 를 이용하여 셋팅하고 JUnit Test를 하시오
--1-1 com.company.test1  [ AnimalFarm ]
public class AnimalFarm1 {
   private String name;
   private Animal1 ani;  
}

--1-2 com.company.config   [ test1.xml] 
<!-- Cat  cat = new Cat() -->
<!-- Dog  dog = new Dog() -->
      
<!-- AnimalFarm animalFarm = new AnimalFram() 
          animalFarm.setName("sally");
          animalFarm.setAni(    cat );
-->


public void test1() {
   AnimalFarm1 farm = (AnimalFarm1) context.getBean("animalFarm1"); 
   farm.print();
}



QUESTION2)  DI -   component-scan , properties 을 이용해서 셋팅하고 JUnit Test를 하시오



