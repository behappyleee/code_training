package stream;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStreamTest {
	
	// DataInputStream / DataOutputSteram 
	
	public static void main(String[] args) {
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		
		try {
			// File 을 열어봐도 문자 text data 가 아니므로 파일을 16 진수로 볼 수 있는 UltraEdit 이나 ByteArrayOutputStream 을 사용하여 이진데이터를 확인 한다.
			fos = new FileOutputStream("C:\\Users\\dhfhf\\Desktop\\myfolder\\test\\dataOutput.dat");
			dos = new DataOutputStream(fos);
			dos.writeInt(10);
			dos.writeFloat(20.0f);
			dos.writeBoolean(true);
			
			dos.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
