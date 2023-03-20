package stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStreamTest {
	
	// File Input / OutputStream
	// FileInputStream / FileOutputStream �� ���Ͽ� ������� �ϱ� ���� ��Ʈ��
	
	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\dhfhf\\Desktop\\myfolder\\test\\memoTest.txt");		
		// �ش� ��ο� ������ �Ȱ��� ���簡 ��
		// ����� ���� Stream
		FileOutputStream fos = new FileOutputStream("C:\\Users\\dhfhf\\Desktop\\myfolder\\test\\memoTest_bak.txt");
		int data = 0;
		
		// Text ������ �ٷ�� ��쿡�� FileInputStream / FileOutputStream ���ٴ� FileReader / FileWriter ��ü�� ����� ����
		while((data = fis.read()) != -1) {
			fos.write(data);
		}
		
		fis.close();
		fos.close();
	}
	
}
