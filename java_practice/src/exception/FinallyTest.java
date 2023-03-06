package exception;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;

public class FinallyTest {
	
	// JDK 1.7 부터 try-with-resources 문이라는 try-catch 문의 변형이 새롭게 추가 됨
	// 이 구문은 주로 I/O 와 관련된 클래스를 사용시 유용
	public void withResources() {
		// try - with -resources 문
		// try 괄호 안에 문장을 넣음 괄호 안에 여러개 문장 넣을 시에는 ; 로 구분
		// try 괄호안에 생성 된 문장은 try 이 구문 안에서만 사용 이 가능하며 try 를 벗어나는 순간 자동으로 close 가 호출이 된다
		// 그 다음에 catch 문과 finally 문이 수행이 된다.
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
//			// 작업 중에 예외가 발생 하더라도 dis 가 닫히도록 finally 블럭에 넣음 !
//			// 하지만 dis.close() 를 실행 중에 예외가 발생할 수 있으므로 try-catch 로 감싸주는 것이 맞지만 코드가 너무 복잡해진다.
//			// 이를 방지 하기 위하여 try-with-resources 문을 사용 한다.
//			if(dis != null) {
//				dis.close();
//			}
//		}
		
	}
	
	// 예외가 발생 시 실행 순서 try -> catch -> finally
	// finally 블럭은 예외의 발생여부 상관없이 무조건 실행이 됨
	public static void method1() {
		try {
			// try 구문에 return 문이 존재하여도 finally 문은 반드시 실행 한다 !!!
			System.out.println("method 1 !!");
			return;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Method1 Finally !");
			// finally 블럭은 try-catch 구문 맨 마지막에 위치하여야 함 
		}
	}
	
	public static void main(String[] args) {
		method1();
	}
	
	
	
	
	
}
