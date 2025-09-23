
/*
class Sawon3{ 
	
	
	 1. 인스턴스변수, 클래스변수, 지역변수 를 구분하시오.
	 2. 인스턴스메서드, 클래스메서드 구분하시오.
	 3. 오류나는 이유는?
	 
	 
    int pay      =10000;    		// 인스턴스변수 - heap area - new o - 생성자
    static int su=10;     			// 클래스변수 - method area - new x - 생성자 x > 바로사용가능
    static int basicpay=pay;    	// 클래스변수		//static은 this사용 불가 / 당장사용해야하는데 this를 쓰려면 new하고 난다음에 사용되야함.
    static int basicpay2;    		// 클래스변수
    
    
    
    public static void showSu() 	{   System.out.println(su);  }		
    // 클래스 메서드  - method area - new x - 생성자 x - Sawon3.showSu() > 바로사용가능      
    
    //public static void showPay() 	{   System.out.println(this.pay);  } 		
    // 클래스 메서드 // static은 this사용 불가 / this. (각각) new 사용 
  
    
    // 인스턴스 메서드 - heap area - new o - 생성자
    public  void  showAll001() {   			
       System.out.println(su);  			// 클래스변수	//static 사용가능 - new 전에 메모리상에 static 올라가 있어서
       System.out.println(this.pay);		// 인스턴스변수 // this 사용가능
    } 
    
    // 클래스 메서드 - method area - new x - 생성자 x - Sawon3.showAll002()
    public static  void  showAll002() {   	
        showAll001();    					// 인스턴스메서드 // static은 this사용(인스턴스)불가
       System.out.println(this.pay);		// 인스턴스변수
    } 
}

public class StaticEx003 {
	public static void main(String[] args) {		//args 지역변수
		Sawon3 sola = new Sawon3(); // 인스턴스 1)new 번지,객세생성 2) 생성자초기화 3) sola번지 (지역변수)
		sola.showAll001(); // 인스턴스
	}
}

*/
/*
  
  
 
------------------------[ runtime data area]
[method: 정보, static, final : 공용정보]
> Sawon3.class / StaticEx003.class
> static : sawon3.su, sawon3.basicpay2, sawon3.showsu(), sawon3.showall002()
------------------------------------
[heap: 동적]           			 | [stack : 잠깐빌리기]

1번지{pay=0, showall001()}		<-	sola[1번지]
									main
------------------------------------


 _ex
클래스명 :  MemberVarEx001
-- class Sawon3작성해주세요 
1. 인스턴스변수, 클래스변수, 지역변수 를 구분하시오.
2. 인스턴스메서드, 클래스메서드 구분하시오.
3. 오류나는 이유는?
class Sawon3{ 
    int pay      =10000;    
    static int su=10;     
    static int basicpay=pay;    
    static int basicpay2;    
    
    public static void showSu() {   System.out.println(su);  }          
    public static void showPay() {   System.out.println(this.pay);  }    
  
    public  void  showAll001() {   
       System.out.println(su);  
       System.out.println(this.pay);  
    } 
    public static  void  showAll002() {   
        showAll001();    
       System.out.println(this.pay);
    } 
} 
public class MemberVarEx001{
  public static void main(String[] args) {
   Sawon3   sola = new Sawon3();  
   sola.showAll001();
  }
}



 */
