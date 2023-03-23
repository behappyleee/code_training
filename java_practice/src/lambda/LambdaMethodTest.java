package lambda;


// 하나의 메서드가 선언 된 인터페이스를 정의하여 람다식을 다루는 것은 기존의 자바의 규칙들을 어기지 않으면서도 자연스러움
// 그래서 인터페이스를 통해 람다식을 다루기로 결정 되었으며 람다식을 다루기 위한 인터페이스를 함수형 인터페이스라고 부름
@FunctionalInterface
interface MyFunctionInterface {
	void run();	// public abstract void run();
}

public class LambdaMethodTest {
	
	static void execute(MyFunctionInterface mfi) {
		mfi.run();
	}
	
	static MyFunctionInterface getMyFunction() {
		MyFunctionInterface mf = () -> System.out.println("getMyFunction mf run()");
		return mf;
	}
	
	
	public static void main(String[] args) {
		// 람다식으로 MyFunctionInterface 의 run 을 구현
		MyFunctionInterface mf1 = () ->  System.out.println("Test Mf1 Run !");
		
		MyFunctionInterface mf2 = () -> new MyFunctionInterface() {
			@Override
			
			public void run() {	// public 을 반드시 붙여야 함
				System.out.println("tEST Mf2 Run !");
			}
		};
		
		MyFunctionInterface mf3 = getMyFunction();
		
		mf1.run();
		mf2.run();
		mf3.run();
		
		execute(mf1);
		execute(() -> System.out.println("Direct Function !!!"));
	
	}
	
}
