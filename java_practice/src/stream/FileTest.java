package stream;

import java.io.File;

public class FileTest {
	
	// File 은 기본적이면서도 가장 많이 사용되는 입출력 대상이다.
	
	public static void main(String[] args) {
		File f = new File("C:\\Users\\dhfhf\\Desktop\\myfolder\\test\\testJava.txt");
		String fileName = f.getName();
		int pos = fileName.lastIndexOf(".");
		
		System.out.println("경로 제외 파일 이름 : " + fileName);
		System.out.println("확장자 제외 파일 이름 : " + fileName.substring(0, pos));
		System.out.println("확장자 : " + fileName.substring(pos + 1));
		
		System.out.println("경로 포함 파일 이름 : " + f.getPath());
		
		
	}
	
}
