package exception;

import java.io.IOException;

public class ExceptionTest {
	
	// TODO !!
	// 2023-03-06 �� !!!!!!!!!!
	// 424 ���� �߻� ��Ű�� ���� �н� �ϱ� !!!!
	
	
	
	// ���� ó�� (Exception Handling)
	// ���α׷��� ���� �� � ���ο� ���ؼ� ���۵��� �ϰų� ������������ ����Ǵ� ��찡 ����
	// �̷��� ����� �ʷ��ϴ� ������ ���α׷� ���� �Ǵ� ������� ��
	
	// �߻� ������ ���� ������ ���� (������ �ÿ� �߻�), ��Ÿ�� ����(���� �ÿ� �߻�), ���� ������ ���� (������ ������ �ǵ��� �ٸ��� �۵�)
	
	// �ڹٿ����� ���� �� Runtime ���� �߻� �� �� �ִ� Error �� Exception �� ������ ����
	
	// Error - ���α׷� �ڵ忡 ���ؼ� ���� �� �� ���� �ɰ��� ����
	// Exception - ���α׷� �ڵ忡 ���ؼ� ���� �� �� �ִ� �ټ� �̾��� ����
	
	// ��� ������ �ְ� ������ Exception Ŭ���� ��
	
	// Exception Ŭ������ - ������� �Ǽ��� ���� ������ ���ο� ���� �߻��ϴ� ����
	// RuntimeException Ŭ������ - ���α׷����� �Ǽ��� �߻��ϴ� ����
	
	
	// ���� ó�� �ϱ�
	// 1. try-catch ��
	// ���α׷� ���� ���߿� �߻��ϴ� ������ ��¿ �� ������ ���ܴ� ���α׷��Ӱ� �̿� ���� ó���� �̸� ���־�� ��
	// ���� ó���� ���α׷� ���� �� �߻��� �� �ִ� ����ġ ���� ������ �߻��� ����� �ڵ带 �ۼ��ϴ� �� ����ó�� ������
	// ������ �߻����� ���� ���� ���� ���α׷��� ���۽��� ������ ���Ḧ ���� �������� ������¸� ������ �� �ֵ��� �ϴ� ��
	
	// ���� ó���� ���� ���ϸ� ���α׷��� ������ ������ ���ᰡ �Ǹ� ó������ ���� ���ܴ� JVM �� ���� ó���Ⱑ �޾Ƽ� ������ ������ ȭ�鿡 ���
	
	public static void withOutException() {
		int number = 100;
		int result = 0;
		for(int i=0; i<10; i++) {
			result = number / (int)(Math.random() * 10);
			System.out.println("RESULT : " + result);
		}
		
		// try catch ���� ���� �� Error �߻� �� �ش� �Ʒ� ������ ���� ���� ���� !!
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
		// ��� ���� Ŭ������ Exception Ŭ������ �ڼ� �̹Ƿ� catch ���� ��ȣ () �� Exception Ŭ���� Ÿ���� ���������� ������ �� ������
		// � ������ ���ܰ� �߻��ϴ��� �� catch ���� ���ؼ� ó���� ��
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Exception �߻� !");
		}
		
		// try catch ���� ���� �Ͽ� Error �߻� �Ͽ��� �ش� �Ʒ� ������ ������ �� !!!!
		System.out.println("withException Exception After !!");
	}
	
	public static void main(String[] args) {
		// ���� ó�� ������ �߰��Ͽ� ���ܰ� �߻��ϴ��� ������������ ������� �ʵ��� ������ ����
		// withException();
		
		// ���� �߻� �� �׳� ���� ���α׷��� ���� �Ǿ� ������
		withOutException();
		
		try {
			System.out.println("Exception TEST");
		
		// ���ܰ� �߻��Ͽ��� �� ���� �Ǵ� ���� Ŭ������ �ν��Ͻ� ���� �߻��� ���ܿ� ���� ������ ����� ������
		// getMessage() �� printStackTrace() �� ���Ͽ��� �� �������� ���� �� ����
		} catch (Exception e1) {
			// Exception ��¿� ���� ���Ǵ� �ΰ��� �޼���
			e1.getMessage();
			e1.printStackTrace();
		} 
		
		
		// JDK 1.7 ���� �̻���ʹ� | �� Exception �� �ϳ��� ��ĥ �� �ְ� ���־���
		try {
			int a = 3;
			int b = 7;
			int c = a + b;
		// catch ���� | ��ȣ�� �̿��Ͽ� �ϳ��� catch ������ ��ĥ �� �ְ� ���� ��Ƽ catch ���̶�� ��
		// ���� catch �� Exception Ŭ���� �θ� - �ڼ� ���� Ŭ������ �ϳ��� �ۼ� �� Compile Error �߻� �ֳ��ϸ� �θ� Exception Class �ϳ� �ۼ��ϴ� �Ͱ� ������ ȿ���̱� ����
		} catch(ArithmeticException | NullPointerException e) {
			e.printStackTrace();
		}
	}
	
}



