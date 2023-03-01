package object;

public class OverloadingEx {
	
	// Overloading 
	// 오버로딩은 자바에서는 이름이 같더라도
	// 매개변수 개수 및 타입이 다르면 같은 이름을 가지더라도 정의 가가능
	
	// 오버로딩 조건
	// 1. 메서드 이름이 같아야 함
	// 2. 매개변수의 개수 또는 타입이 달라야 함
	
	// 주의 !
	// 반환 return 타입은 오버로딩에 아무런 영향도 없음
	
	// 오버로딩의 장점은 같은 기능을 하지만 서로 다른 이름을 가져야 할 때 이름 명명이 어렵고 메서드를 사용하는 쪽에서도 부담이 됨
	// 하지만 오버로딩을 통하면 메서드 이름을 기억하기도 쉽고 오류의 가능성을 많이 줄일 수 있음 
	
	public int test() {
		return 1;
	}
	public int test(int a) {
		return 2;
	}
	
	// varargs(가변인자 variable arguments) 와 overloading
	public void somethid(String  a, Object ...test) {
		
	}
	// 가변인자는 항상 매개변수 순서 중 맨 마지막 번째에 선언이 필요
//	public void somethid( Object ...test, String  a) {
//		
//	}
	
	public static void print(String ...test) {
		// 매개변수 출력 시 다음과 같이 사용이 가능 !!
		System.out.println("TEST : " + test[0]);
		System.out.println("TEST : " + test[1]);
		System.out.println("test : " + test.toString());
	}
	public static  void print(Object ...test) {
		
	}
	
	public static void main(String[] args) {
		// 가변인자 이기에 갯수와 상관없이 매개변수를 받을 수 있음 
		print("10", "2");
		// 가변인자 일 시에 배열 선언도 가능
		print(new String[]{"3", "7"});
	
		
	
	}
}
