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
	
	// ����� ���� ����
	// ������ ���� �� ���� Ŭ���� �ܿ� �ʿ信 ���� ���α׷��Ӱ� ���ο� ���� Ŭ������ ������ �� �ִ�.
	// ���� Exception Ŭ���� �κ��� ��ӹ޴� Ŭ������ �������� �ʿ信 ���� �˸��� ���� Ŭ������ ���� �� �� �ִ�.
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
	
	private final int ERR_CODE;	// �����ڸ� ���Ͽ� �ʱ�ȭ
	
	// ����� ���� Exception ����
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

