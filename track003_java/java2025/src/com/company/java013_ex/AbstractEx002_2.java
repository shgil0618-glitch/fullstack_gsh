package com.company.java013_ex;

abstract class Astronaut2 {
    protected String name;
    protected int stamina;
    protected int change;

    public void setName(String name) { this.name = name; }
    public void setStamina(int stamina) { this.stamina = stamina; }
    public int getStamina() { return stamina; }
    
    public int getChange() { return change; }
	public void setChange(int change) { this.change = change; }
	public String getName() { return name; }
	
	abstract void explore();
    abstract void report();
    abstract void rest();
}

class Engineer2 extends Astronaut2 {
    @Override void explore() { System.out.println(name + " 엔지니어 탐사: 기계 장치 점검 완료!  체력 - " + change); }
    @Override void report() { System.out.println(name + " 보고서: 에너지 시스템 안정적  체력 +"+change); }
    @Override void rest() { System.out.println(name + " 휴식: 공구 정리하며 재충전 중...  체력 +"+change  ); }
}

class Biologist2 extends Astronaut2 {
    @Override void explore() { System.out.println(name + " 생물학자 탐사: 외계 식물 샘플 채취!  체력 - "+change); }
    @Override void report() { System.out.println(name + " 보고서: 생명체 흔적 발견  체력 + "+change); }
    @Override void rest() { System.out.println(name + " 휴식: 생체 리듬 조절 중...  체력 + "+change); }
}

class Pilot2 extends Astronaut2 {
    @Override void explore() { System.out.println(name + " 파일럿 탐사: 항로 재설정 및 우주선 조종!  체력 - "+change); }
    @Override void report() { System.out.println(name + " 보고서: 궤도 진입 성공  체력 + "+change); }
    @Override void rest() { System.out.println(name + " 휴식: 조종석에서 짧은 명상...  체력 + "+change); }
}

public class AbstractEx002_2 {
    public static void main(String[] args) {
        // Astronaut astro = new Astronaut();  // Q1. 왜 객체 생성이 불가능한가? 
    	// Astronaut는 설계만 있을뿐 구현부가 없기때문에

        System.out.println("\n--- 우주 탐사 대원 시뮬레이션 ---");
        Astronaut2[] crew = { new Engineer2(), new Biologist2(), new Pilot2() };
        String[] names = { "Nova", "Flora", "Jet" };
        int[] stamina = { 75, 60, 85 };
        int change[] = {0,0,0};
        
        int cnt = 0;
        for(Astronaut2 c : crew ) {
        	c.name = names[cnt];
        	c.change = change[cnt];
        	c.stamina = stamina[cnt];
        	
        	
        	
        	int num = (int)(Math.random() * 20 + 5);
        	if(c.stamina >= num) {c.stamina -= num; c.change = num; c.explore();}
        	else {System.out.println(c.name = names[cnt] +"의 체력이 부족합니다.");}
        	
        	
        	c.stamina +=10;
        	c.change = 10;
        	c.report();
        	
        	
        	
            if(c.stamina<70) {
            	c.change = 20;
            	c.stamina += 20;
            		c.rest();
            }
            else {}
            System.out.println("-> 현재 체력 : "+ c.stamina);
            System.out.println();

            cnt++;
        }
    }
}
/*
 > 주어진조건: 
1. explore() 시 체력 감소: stamina -= (int)(Math.random() * 20 + 5); → 5~24 사이의 랜덤한 체력 소모
2. report() 시 체력 회복: stamina += 10;
3. 체력이 70 미만이면 rest() 호출
4. 체력은 0 미만으로 떨어지지 않도록 제한


> 결과 예시 (실행 시마다 달라짐)
코드
Nova 엔지니어 탐사: 기계 장치 점검 완료! 체력 -18
Nova 보고서: 에너지 시스템 안정적. 체력 +10
→ 현재 체력: 67

Flora 생물학자 탐사: 외계 식물 샘플 채취! 체력 -12
Flora 보고서: 생명체 흔적 발견. 체력 +8
Flora 휴식: 생체 리듬 조절 중... 체력 +20
→ 현재 체력: 76

Jet 파일럿 탐사: 항로 재설정 및 우주선 조종! 체력 -23
Jet 보고서: 궤도 진입 성공. 체력 +12
→ 현재 체력: 74
 */

/*
연습문제2)
패키지명 : com.company.java013_ex 
클래스명 : AbstractEx002.java
다음과 같이 출력되게 main 코드를 작성하시오.
주어진 조건
1) 상속도 구조 
            Object
              ↑
        Astronaut { abstract explore(), report(), rest() }
   ↑            ↑               ↑ 
Engineer     Biologist       Pilot
{ @explore(), @explore(),    @explore(),
  @report(),  @report(),     @report(),
  @rest() }   @rest() }      @rest() }
  
- Astronaut는 추상 클래스이며, 모든 대원이 공통적으로 수행해야 할 기능을 설계함
- 각 대원 클래스는 Astronaut를 상속받아 기능을 구체적으로 구현함
- rest() 메서드는 각 대원의 고유한 휴식 방식 출력  

2) 코드
출력화면
--- 우주 탐사 대원 시뮬레이션 ---
Nova 엔지니어 탐사: 기계 장치 점검 완료!
Nova 보고서: 에너지 시스템 안정적
Nova는 충분한 체력을 유지 중입니다.

Flora 생물학자 탐사: 외계 식물 샘플 채취!
Flora 보고서: 생명체 흔적 발견
Flora 휴식: 생체 리듬 조절 중...

Jet 파일럿 탐사: 항로 재설정 및 우주선 조종!
Jet 보고서: 궤도 진입 성공
Jet는 충분한 체력을 유지 중입니다.


*/