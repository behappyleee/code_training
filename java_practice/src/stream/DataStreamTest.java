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
			// File �� ������� ���� text data �� �ƴϹǷ� ������ 16 ������ �� �� �ִ� UltraEdit �̳� ByteArrayOutputStream �� ����Ͽ� ���������͸� Ȯ�� �Ѵ�.
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
