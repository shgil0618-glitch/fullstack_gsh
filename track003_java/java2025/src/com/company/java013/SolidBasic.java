package com.company.java013;

/*

원칙   설명
S - SRP (단일 책임 원칙)   클래스는 하나의 책임만 가져야 함. 즉, 변경의 이유가 하나여야 함.
O - OCP (개방-폐쇄 원칙)   확장에는 열려 있고, 변경에는 닫혀 있어야 함. 기존 코드를 수정하지 않고 기능을 추가할 수 있어야 함.
L - LSP (리스코프 치환 원칙)   하위 클래스는 상위 클래스의 기능을 대체할 수 있어야 함. 즉, 다형성을 지켜야 함.
I - ISP (인터페이스 분리 원칙)   클라이언트는 자신이 사용하지 않는 메서드에 의존하면 안 됨. 인터페이스는 작고 명확하게 분리해야 함.
D - DIP (의존 역전 원칙)   고수준 모듈은 저수준 모듈에 의존하면 안 되고, 추상화에 의존해야 함. 즉, 인터페이스에 의존하라는 뜻.

1. S : (한클래스는 하나만) 한 클래스는 한가지 일만 (쿠키반죽 반죽만, 쿠키굽기는 쿠키굽기만)
2. O : (수정말고 추가만) 새로운 쿠키 쉽게 추가 
3. L : (다형성 : 같은방식으로 처리) 모든쿠키는 같은 방식으로 만들기  
4. I : (필요한 기능만 딱!) 인터페이스 나누기 
5. D : (추상적인 쿠키의존) 
 
 */

// 1. S: 단일책임의 원칙
class CookieMaker{
	public void bakeCookie(String type) {System.out.println(type + "쿠키를 구워요!");}
}

// 2. O : 개방-폐쇄의 원칙 (새로운쿠키를 추가할수 있지만, 기존코드 건들지 마세요!)
interface Cookie{ void make(); }
class ChocoCookie implements Cookie { @Override public void make() {System.out.println("초코쿠키");  } }
class DeepChocoCookie implements Cookie { @Override public void make() {System.out.println("딥초코쿠키");  } }
class BananaCookie implements Cookie { @Override public void make() {System.out.println("바나나쿠키");  } }

// 3. L : 리스코프 치환 (어떤 쿠키든 Cookie 인터페이스로 바꿔서도 문제 없어요! 		부모 = 자식 )
class CookieFactory{
	public void makeCookie(Cookie cookie) {	// Cookie cookie = 각종 자식들(쿠키종류)
		cookie.make();						// 어떤 쿠키든 여기서 만들수 있어요~!
	}
}

// 4. I : 인터페이스 - 너무 많은 기능을 강요하지 말 것 /  꼭 필요한 기능만 (절차)
interface SimpleCookie {void make();}
class SimpleCookieMake implements SimpleCookie {
	@Override public void make() { System.out.println("쿠키 만드는 방법은 간단하게."); }
}

// 5. D : 의존역전원칙 - CookieFactory는 귀체적인 쿠키가 아니라 추상적인 Cookie에 의존
class CookieShop{
	private Cookie cookie;
	
	public CookieShop(Cookie cookie) { super(); this.cookie = cookie; }	// 쿠키종류는 외부에서 넣어줘요!
	public CookieShop() { super(); }
	
	public void sell() {System.out.println("cookie 가게에서...."); cookie.make();}	// 어떤 쿠키든 팔수 있음!
}

public class SolidBasic {
	public static void main(String[] args) {
		
		//5. D 의존역전 - 어떤 쿠키든 가게에서 팔 수있어요.
		System.out.println("5. D 의존역전");
		CookieShop shop = new CookieShop(new DeepChocoCookie());
		shop.sell();
		
		System.out.println();
		//1. s : 단일책임의 원칙
		System.out.println("1. S : 단일책임의 원칙 - 쿠키굽기(기계)");
		CookieMaker maker = new CookieMaker();
		maker.bakeCookie("초코");	 maker.bakeCookie("오트밀"); 	maker.bakeCookie("라즈베리");
		
		System.out.println();
		//2+3. O,L
		System.out.println("2,3. O,L : 개방폐쇄(레시피/추가) + 리스코프(공장/어떤쿠키든 굽기가능) 치환");
		CookieFactory factory = new CookieFactory();
		factory.makeCookie(new ChocoCookie());
		factory.makeCookie(new DeepChocoCookie());
		factory.makeCookie(new BananaCookie());
		
		System.out.println();
		//4. I 인터페이스 분리
		System.out.println("4. I : 인터페이스 분리");
		SimpleCookie making = new SimpleCookieMake(); making.make();
		
		
	}
}
