package stream;

import java.io.File;

public class FileTest {
	
	// File �� �⺻���̸鼭�� ���� ���� ���Ǵ� ����� ����̴�.
	
	public static void main(String[] args) {
		File f = new File("C:\\Users\\dhfhf\\Desktop\\myfolder\\test\\testJava.txt");
		String fileName = f.getName();
		int pos = fileName.lastIndexOf(".");
		
		System.out.println("��� ���� ���� �̸� : " + fileName);
		System.out.println("Ȯ���� ���� ���� �̸� : " + fileName.substring(0, pos));
		System.out.println("Ȯ���� : " + fileName.substring(pos + 1));
		
		System.out.println("��� ���� ���� �̸� : " + f.getPath());
		
		
	}
	
}
