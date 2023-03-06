package exception;

import java.io.IOException;

public class ExceptionTest {
	
	// TODO !!
	// 2023-03-06 날 !!!!!!!!!!
	// 424 예외 발생 시키기 부터 학습 하기 !!!!
	
	
	
	// 예외 처리 (Exception Handling)
	// 프로그램이 실행 중 어떤 원인에 의해서 오작동을 하거나 비정상적으로 종료되는 경우가 있음
	// 이러한 결과를 초래하는 원인은 프로그램 오류 또는 에러라고 함
	
	// 발생 시점에 따라 컴파일 에러 (컴파일 시에 발생), 런타임 에러(실행 시에 발생), 논리적 에러가 있음 (실행은 되지만 의도와 다르게 작동)
	
	// 자바에서는 실행 시 Runtime 에서 발생 할 수 있는 Error 와 Exception 두 가지로 구분
	
	// Error - 프로그램 코드에 의해서 수습 될 수 없는 심각한 오루
	// Exception - 프로그램 코드에 의해서 수습 될 수 있는 다소 미약한 오류
	
	// 모든 예외의 최고 조상은 Exception 클래스 임
	
	// Exception 클래스들 - 사용자의 실수와 같은 외적인 요인에 의해 발생하는 예외
	// RuntimeException 클래스들 - 프로그래머의 실수로 발생하는 예외
	
	
	// 예외 처리 하기
	// 1. try-catch 문
	// 프로그램 실행 도중에 발생하는 에러는 어쩔 수 없지만 예외는 프로그래머가 이에 대한 처리를 미리 해주어야 함
	// 예외 처리란 프로그램 실행 시 발생할 수 있는 예기치 못한 예외의 발생에 대비한 코드를 작성하는 것 예외처리 목적은
	// 예외의 발생으로 인한 실행 중인 프로그램의 갑작스런 비정상 종료를 막고 정상적인 실행상태를 유지할 수 있도록 하는 것
	
	// 예외 처리를 하지 못하면 프로그램은 비정상 적으로 종료가 되며 처리되지 못한 예외는 JVM 의 예외 처리기가 받아서 예외의 원인을 화면에 출력
	
	public static void withOutException() {
		int number = 100;
		int result = 0;
		for(int i=0; i<10; i++) {
			result = number / (int)(Math.random() * 10);
			System.out.println("RESULT : " + result);
		}
		
		// try catch 문이 없을 시 Error 발생 시 해당 아래 구문은 실행 되지 않음 !!
		System.out.println("withOutException Exception After !!");
	}
	
	public static void withException() {
		try {
			int number = 100;
			int result = 0;
			for(int i=0; i<10; i++) {
				result = number / (int)(Math.random() * 10);
				System.out.println("RESULT : " + result);
			}
		// 모든 예외 클래스는 Exception 클래스의 자손 이므로 catch 블럭의 괄호 () 에 Exception 클래스 타입의 참조변수를 선언을 해 놓으면
		// 어떤 종류의 예외가 발생하더라도 이 catch 블럭에 의해서 처리가 됨
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Exception 발생 !");
		}
		
		// try catch 문이 존재 하여 Error 발생 하여도 해당 아래 구문은 실행이 됨 !!!!
		System.out.println("withException Exception After !!");
	}
	
	public static void main(String[] args) {
		// 예외 처리 구문을 추가하여 예외가 발생하더라도 비정상적으로 종료되지 않도록 구현이 가능
		// withException();
		
		// 예외 발생 시 그냥 종료 프로그램이 종료 되어 버림ㅈ
		withOutException();
		
		try {
			System.out.println("Exception TEST");
		
		// 예외가 발생하였을 시 생성 되는 예외 클래스의 인스턴스 에는 발생한 예외에 대한 정보가 담겨져 있으며
		// getMessage() 와 printStackTrace() 를 통하여서 이 정보들을 얻을 수 있음
		} catch (Exception e1) {
			// Exception 출력에 자주 사용되는 두개의 메서드
			e1.getMessage();
			e1.printStackTrace();
		} 
		
		
		// JDK 1.7 버전 이상부터는 | 로 Exception 을 하나로 합칠 수 있게 해주었음
		try {
			int a = 3;
			int b = 7;
			int c = a + b;
		// catch 블럭을 | 기호를 이용하여 하나의 catch 블럭으로 합칠 수 있게 해줌 멀티 catch 블럭이라고 함
		// 만약 catch 블럭 Exception 클래스 부모 - 자손 관계 클래스를 하나로 작성 시 Compile Error 발생 왜냐하면 부모 Exception Class 하나 작성하는 것과 동일한 효과이기 때문
		} catch(ArithmeticException | NullPointerException e) {
			e.printStackTrace();
		}
	}
	
}



