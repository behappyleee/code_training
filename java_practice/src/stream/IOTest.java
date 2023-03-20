package stream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class IOTest {
	
	public static void main(String[] args) {
		
		byte[] inSrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		byte[] outSrc = null;
		byte[] temp = new byte[4];
		
		ByteArrayInputStream input = null;
		ByteArrayOutputStream output = null;
		
		input = new ByteArrayInputStream(inSrc);
		output = new ByteArrayOutputStream(0);
		
		System.out.println("Input Source :  " + Arrays.toString(inSrc));
		
		try {
			while(input.available() > 0) {
				input.read(temp);		// temp 배열에 값이 들어 감
				output.write(temp);
				
				System.out.println("Temp Byte Array : " + Arrays.toString(temp));
				
				outSrc = output.toByteArray();
				printArray(temp, outSrc);
			}
		} catch (IOException e) {	// read 나 write 가 IOException 을 발생시킬 수 있기에 try-catch 문으로 감싸줌
			e.printStackTrace();
		}
	}
	
	static void printArray(byte[] temp, byte[] outSrc) {
		System.out.println("Temp Print Array : " + Arrays.toString(temp));
		System.out.println("Output Source : " + Arrays.toString(outSrc));
	}
	
	
}
