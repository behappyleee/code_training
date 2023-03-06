package exception;

public class ThrowTest {
	
	// 메서드 예외 선언
	void exceptionMethod() throws Exception, RuntimeException {
		// 기존의 많은 언어들 에서는 메서드에 예외 선언을 하지 않기에 경험 많은 프로그래머 아니고서는 어떤 종류의
		// 예외가 발생 할 가능성이 있는지 충분히 예측하기가 힘들었다
		// 하지만 자바에서는 에러 발생 가능성 있는 메서드들을 예외를 강제시키고 있다 보다 견고한 프로그램 만드는 것이 가능해졌다
		
		
	}
	
	
	public static void main(String[] args) {
		try {
			// 강제로 예외 발생 시키기
			Exception e = new Exception("Exception !!!!");
			throw e;
			
		} catch(Exception ex) {
			System.out.println("Exception message : " + ex.getMessage());
			System.out.println("Exception Catch !!");
			ex.printStackTrace();
		}
		
		//컴파일러가 예외 처리를 확인 하지 않는 RuntimeException 클래스들은 unchecked 예외 라고 하고
		// 예외 처리를 확인하는 Exception 클래스드은 checked 예외라고 한다.
		
		
		System.out.println("Program End !");
	}
	
}
