package stream;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutputTest {
	
	// BufferedInputStream / BufferedOutputSteram �� ��Ʈ���� ����� ȿ���� ���̱� ���Ͽ� ���۸� ����ϴ� ���� ��Ʈ��
	// 1 byte �� �ٷ� ������� �ǽ��ϴ� �� ���� Buffer �� ����Ͽ� ���� ����Ʈ�� ������� �ϴ°� �ξ� ������ ����
	
	public static void main(String[] args) {
		try {
			FileOutputStream fos = new FileOutputStream("C:\\Users\\dhfhf\\Desktop\\myfolder\\test\\123.txt");
			// BufferedOutputStream �� ���� ũ�⸦ 5�� ��
			// BufferedOutputStream �� Buffer �� ���� á�� ���� ����ϱ⿡ �ݵ�� flush �� ���־�� �Ѵ�.
			BufferedOutputStream bos = new BufferedOutputStream(fos, 5);
			for(int i = '0'; i <= '9'; i++) {
				bos.write(i);
			}
			
			// 1 ���� 9 ���� ����� �Ͽ��� ������ 5�� ����ϰ� ���ᰡ �Ǿ��⿡ 01234 �� ��µ� �� ���� ��
			// bos.close() �� ���ָ� 9���� ���ۿ� ����ִ� ������ ��� �ȴ�.
			
			
			fos.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
