package object;

public class VariableInit {
	
	// 변수 초기화
	// 변수를 선언 후 처음으로 값을 저장 하는 것을 변수의 초기화 라고 함
	// 멤버변수는 초기화 하지 않아도 자동적으로 변수의 자료형에 맞는 기본값으로 초기화가 이루어 지지만
	// 지역변수는 사용 하기 전에 반드시 초기화를 하여야 함
	
	// 클래스 변수는 인스턴스 변수보다 항상 먼저 초기화가 되고 먼저 생성
	// 클래스 변수 초기화 생성 순서
	// 1. 기본 값 -> 2. 명시적 초기화 -> 3. 클래스 초기화 블럭
	
	// 인스턴스 변수 초기화 생성 순서
	// 1. 기본 값 -> 2. 명시적 초기화 -> 3. 인스턴스 초기화 블럭 -> 4. 생성자
	
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
	
	String b;
	static String c;
	
	// 명시적 초기화가 간단하고 명료하지만 보다 복잡한 초기화가 필요 시에는 초기화 블럭 or 생성자를 사용
	// 2. 초기화 블럭 (initialization block) 
	
	// 클래스 초기화 블럭 - 클래스변수의 복잡한 초기화에 사용
	// 인스턴스 초기화 블럭 - 인스턴스 변수의 복잡한 초기화에 사용
	
	// 클래스 초기화 블럭은 클래스가 메모리에 올라갈 때 딱 한번만 수행이 됨
	// 클래스 변수 초기화 (ex - static 붙은 변수 들 ..)
	static {
		// 초기화 불가 static 이 붙지 않았기 때문에 static 붙은 변수만 초기화 가능
		// b = "test";
		c = "test";
	}
	
	// 인스턴스 변수 초기화는 주로 생성자를 사용을 하고 인스턴스 초기화 블럭은 모든 생성자에서
	// 공통으로 사용되어야 하는 코드를 넣는데 사용
	// 인스턴스 초기화 블럭은 생성자와 같이 인스턴스를 생성할 때 마다 실행이 됨
	// 인스턴스 변수 초기화 일반 변수들 초기화 
	{
		// 클래스 변수 일반변수 모두 초기화가 가능
		b = "test";
		c = "test";
	}
}

class InitTest {
	int count = 0;
	{
		// 이처럼 모든 생성자에 count++; 을 사용하여야 하는 경우 초기화 블럭을 이용하여 위로 하나로 뻄
		// 코드가 훨씬 간결해 짐 중복을 제거하여 주고 코드의 신뢰성을 높여줌
		// 객체지향 프로그래밍이 추구하는 궁극적인 목표임 프로그래머는 최대한 객체지향 언어의 요소 들을 
		// 잘 이해하여야 함
		System.out.println("일반 초기화 블럭");
		count++;
	}
	// 프로그램 로딩 시 딱 한번만 로딩이 됨 !!!
	static {
		System.out.println("STATIC 초기화 블럭");
	}
	
	InitTest() {
		// count++;
	}
	InitTest(String a) {
		// count++;
	}
}


class Init {
	int a;
	String b;
	char c;
}