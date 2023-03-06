package exception;

import java.io.FileInputStream;

public class CustomException {
	
	public static void makeException() {
		try {
			throw new Exception("Exception Happen !!!");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 사용자 정의 예외
	// 기존에 정의 된 예외 클래스 외에 필요에 따라 프로그래머가 새로운 예외 클래스를 정의할 수 있다.
	// 보통 Exception 클래스 로부터 상속받는 클래스를 만들지만 필요에 따라 알맞은 예외 클래스를 선택 할 수 있다.
	public static void main(String[] args) {
		try {
			makeException();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			
		}
	}
	
}

class CoustomExceptionTest extends Exception {
	
	private final int ERR_CODE;	// 생성자를 통하여 초기화
	
	// 사용자 정의 Exception 구현
	CoustomExceptionTest(String msg, int errCode){
		super(msg);
		this.ERR_CODE = errCode;
	}
	
	CoustomExceptionTest(String msg){
		this(msg, 100);
	}
	
	public int getErrCode() {
		return this.ERR_CODE;
	}
}

class NotEnoughException extends Exception {
	NotEnoughException(String msg) {
		super(msg);
	}
}

