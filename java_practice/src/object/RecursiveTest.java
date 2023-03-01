package object;

public class RecursiveTest {
	
	// 재귀 함수
	// 재귀 호출 (Recursive Call)
	
	// 재귀 호출은 조건문이 반드시 있어야 함 (조건문이 없을 시 무한 루프 발생 함)
	// 반복문이 재귀호출보다 비용이 훨씬 적게 들지만 재귀호출을 사용하는 이유는 논리적 간결함 때문임
	public static void main(String[] args) {
		int testNum = factorial(4);
		System.out.println(testNum);
	}
	
	// 재귀호출의 좋은 예 팩토리얼
	static int factorial(int num) {
		if(num == 1) return 1;
		return num * factorial(--num);
	}
	
	// 인스턴스 메서드에서 static 메서드와 인스턴스 메서드가 사용이 가능하지만
	// static 메서드에서는 static 메서드만 사용이 가능 static 메서드가 호출 되는 시점에
	// 인스턴스 메서드가 생성 시점이 아니므로 (인스턴스 메서드는 인스턴스 생성시에 메서드가 사용이 가능)
	// 그에 반하여 static 메서드는 프로그램 로딩시에 바로 사용이 가능함
	
	// 클래스 메서드는 언제나 참조 또는 호출이 가능
	void instanceMethod() {}
	static void staticMethod() {}
	void instanceMethod2() {
		instanceMethod();
		staticMethod();
	}
	static void staticMethod2() {
		// instanceMethod();
		staticMethod();
	}
	
}
