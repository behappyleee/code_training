package object;

public class VariableInit {
	
	// 변수 초기화
	// 변수를 선언 후 처음으로 값을 저장 하는 것을 변수의 초기화 라고 함
	// 멤버변수는 초기화 하지 않아도 자동적으로 변수의 자료형에 맞는 기본값으로 초기화가 이루어 지지만
	// 지역변수는 사용 하기 전에 반드시 초기화를 하여야 함
	
	public static void main(String[] args) {
		// 멤버변수를 변수를 초기화 하지 않아도 타입에 맞게 기본값 셋팅이 되지만 지역변수는 안됨
		Init i = new Init();
		System.out.println("INIT A : " + i.a);
		System.out.println("INIT B : " + i.b);
		System.out.println("INIT C : " + i.c);
	}
	
	public static void testMethod (int c) {
		// 컴파일 오류 발생 지역변수 사용시에는 반드시 초기화를 해주어야 함 !!!
		int j;
		// c = j;
	}
	
	
}

class InitWays {
	// 변수 초기화 방법
	// 1. 명시적
	int a =3;
	
	// 302 페이지 명시적 초기화 부터 시작
	// 명시적 초기화가 간단하고 명료하지만 보다 복잡한 초기화가 필요 시에는 초기화 블럭 or 생성자를 사용
	// 2. 초기화 블럭 (initialization block) 
	
	// 클래스 초기화 블럭 - 클래스변수의 복잡한 초기화에 사용
	// 인스턴스 초기화 블럭 - 인스턴스 변수의 복잡한 초기화에 사용
	
	
}


class Init {
	int a;
	String b;
	char c;
}