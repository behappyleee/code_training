package lambda;

public class FunctionalInterfaceTest {
	
	// 함수형 인터페이스 MyFunction 을 정의
	// FunctionalInterface 어노테이션을 붙이면 컴파일러가 함수형 인터페이스를 
	@FunctionalInterface
	interface MyFunction {
		public abstract int max(int a, int b);
	}
	
	public static void main(String[] args) {
		// 람다식이 메서드와 동등한 것처럼 설명해왔지만, 사실 람다식은 익명 클래스의 객체와 동등하다.
		// 람다식은 해당 아래 인터페이스를 구현 한 익명 클래스처럼 작동하는 것으로 생각하면 편하다.
		MyFunction f = new MyFunction() {
			public int max(int a, int b) {
				return (a+b);
			}
		};
		
		int big = f.max(0, 0);	// 익명 객체의 메서드 호출
		
		MyFunction fLam = (int a, int b) -> {
			return (a > b ? a : b);
		};
		
		
	}
	
	
}
