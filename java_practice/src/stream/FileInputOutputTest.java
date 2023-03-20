package stream;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutputTest {
	
	// BufferedInputStream / BufferedOutputSteram 은 스트림의 입출력 효율을 높이기 위하여 버퍼를 사용하는 보조 스트림
	// 1 byte 씩 바로 입출력을 실시하는 것 보다 Buffer 를 사용하여 여러 바이트를 입출력을 하는게 훨씬 성능이 좋음
	
	public static void main(String[] args) {
		try {
			FileOutputStream fos = new FileOutputStream("C:\\Users\\dhfhf\\Desktop\\myfolder\\test\\123.txt");
			// BufferedOutputStream 의 버퍼 크기를 5로 함
			// BufferedOutputStream 은 Buffer 가 가득 찼을 때만 출력하기에 반드시 flush 를 해주어야 한다.
			BufferedOutputStream bos = new BufferedOutputStream(fos, 5);
			for(int i = '0'; i <= '9'; i++) {
				bos.write(i);
			}
			
			// 1 부터 9 까지 출력을 하여야 하지만 5만 출력하고 종료가 되었기에 01234 만 출력된 후 종료 됨
			// bos.close() 를 해주면 9까지 버퍼에 들어있던 모든것이 출력 된다.
			
			
			fos.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
