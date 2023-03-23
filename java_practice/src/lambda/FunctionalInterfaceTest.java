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
		
		
//		MyFunction mf = () -> {
//			System.out.println("MyFunction Lambda Test")
//		};
		
		// 람다식을 참조변수로 다룰 수 있다는 것은 메서드를 통해 람다식을 주고받을 수 있다는 것을 의미
		// 즉 변수 처럼 메서드를 주고 받을 수 있다는 것을 의미
		// 사실상 메서드가 아닌 객체를 주고 받는 것이므로 근본적으로 달라진 것은 아무것도 없다.
		// 람다식 덕분에 예전보다 코드가 더 간결하고 이해하기 더 쉬워졌다.
		
		
	}
	
	
}
