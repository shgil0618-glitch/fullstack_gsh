/*
- 문제 1. 다음 코드에서 인스턴스변수, 클래스변수, 지역변수를 구분하시오.  ( 보관되는 영역도 추가 )
- 문제 2. 인스턴스메서드와 클래스메서드를 구분하시오.  
- 문제 3. 오류가 발생하는 이유를 설명하시오.
- 문제 4. runtime data area 위치영역 그림그리기
*/
/*
class Student {
    String name = "홍길동";        //인스턴스 변수
    int kor = 90;                //인스턴스 변수
    int eng = 85;                //인스턴스 변수
    static int studentCount = 0; //클래스 변수

    static int total = kor + eng;  //클래스 변수	//static변수에 인스턴스 변수가 들어감 (static / this관련)

    static int maxScore = 100;     //클래스 변수

    public Student() {				// 생성자
        studentCount++;             // static 사용가능
    }

    public int getTotalScore() {	// 인스턴스 메서드
        return this.kor + this.eng;        
    }

    public static void showStudentCount() {	//클래스 메서드
        System.out.println("전체 학생 수: " + studentCount);  
    }

   public static void showName() {		//클래스 메서드
         System.out.println(name);  	//클래스 메서드에 인스턴스 변수가 들어감 (static / this관련)
   }

    public void showInfo() {			//인스턴스 메서드
        System.out.println("이름: " + name);            
        System.out.println("총점: " + getTotalScore());    
    }
}

public class MemberVarEx002 {
    public static void main(String[] args) {	//args 지역변수
        Student s1 = new Student();     		//인스턴스변수 이면서 지역변수
        Student s2 = new Student();     		//인스턴스변수 이면서 지역변수

        s1.showInfo();                  		
        Student.showStudentCount();    			
    }
}
*/
/*
초기화 :			 기본값			명시적초기화			초기화블록				생성자
studentcount	0				= 0					x 					0	
maxscore		0				= 100				x 					100
s1{name,kor,eng}		{name="홍",kor=90,eng=85}	x					{name="홍",kor=90,eng=85}
s2{name,kor,eng}		{name="홍",kor=90,eng=85}	x					{name="홍",kor=90,eng=85}
------------------------[ runtime data area]
[method: 정보, static, final : 공용정보]
> Sawon3.class / StaticEx003.class
>MemberVarEx002.class / Student.class
> static : student.studentcount, student.total, student.maxscore,  student.showstudentcount(), student.showname()
>
------------------------------------
[heap: 동적]           			 | [stack : 잠깐빌리기]
2번지{studentCount=0, showInfo()}		<-	s2[2번지]
1번지{studentCount=0, showInfo()}		<-	s1[1번지]
									main
------------------------------------

*/
