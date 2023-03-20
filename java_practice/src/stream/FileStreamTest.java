package stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStreamTest {
	
	// File Input / OutputStream
	// FileInputStream / FileOutputStream 은 파일에 입출력을 하기 위한 스트림
	
	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\dhfhf\\Desktop\\myfolder\\test\\memoTest.txt");		
		// 해당 경로에 파일이 똑같이 복사가 됨
		// 출력을 위한 Stream
		FileOutputStream fos = new FileOutputStream("C:\\Users\\dhfhf\\Desktop\\myfolder\\test\\memoTest_bak.txt");
		int data = 0;
		
		// Text 파일을 다루는 경우에는 FileInputStream / FileOutputStream 보다는 FileReader / FileWriter 객체를 사용을 권장
		while((data = fis.read()) != -1) {
			fos.write(data);
		}
		
		fis.close();
		fos.close();
	}
	
}
