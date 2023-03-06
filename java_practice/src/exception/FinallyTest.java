package exception;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;

public class FinallyTest {
	
	// JDK 1.7 ���� try-with-resources ���̶�� try-catch ���� ������ ���Ӱ� �߰� ��
	// �� ������ �ַ� I/O �� ���õ� Ŭ������ ���� ����
	public void withResources() {
		// try - with -resources ��
		// try ��ȣ �ȿ� ������ ���� ��ȣ �ȿ� ������ ���� ���� �ÿ��� ; �� ����
		// try ��ȣ�ȿ� ���� �� ������ try �� ���� �ȿ����� ��� �� �����ϸ� try �� ����� ���� �ڵ����� close �� ȣ���� �ȴ�
		// �� ������ catch ���� finally ���� ������ �ȴ�.
		try (FileInputStream fis = new FileInputStream("score.dat"); 
			 DataInputStream dis = new DataInputStream(fis);	
				) {
			
		} catch(EOFException e) {
			e.printStackTrace();
		} catch(IOException ie) {
			ie.printStackTrace();
		}
		
//		FileInputStream fis;
//		DataInputStream dis;
//		try {
//			fis = new FileInputStream("score.data");
//			dis = new DataInputStream(fis);
//			
//		} catch(IOException e) {
//			e.printStackTrace();
//		} finally {
//			// �۾� �߿� ���ܰ� �߻� �ϴ��� dis �� �������� finally ���� ���� !
//			// ������ dis.close() �� ���� �߿� ���ܰ� �߻��� �� �����Ƿ� try-catch �� �����ִ� ���� ������ �ڵ尡 �ʹ� ����������.
//			// �̸� ���� �ϱ� ���Ͽ� try-with-resources ���� ��� �Ѵ�.
//			if(dis != null) {
//				dis.close();
//			}
//		}
		
	}
	
	// ���ܰ� �߻� �� ���� ���� try -> catch -> finally
	// finally ���� ������ �߻����� ������� ������ ������ ��
	public static void method1() {
		try {
			// try ������ return ���� �����Ͽ��� finally ���� �ݵ�� ���� �Ѵ� !!!
			System.out.println("method 1 !!");
			return;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Method1 Finally !");
			// finally ���� try-catch ���� �� �������� ��ġ�Ͽ��� �� 
		}
	}
	
	public static void main(String[] args) {
		method1();
	}
	
	
	
	
	
}
