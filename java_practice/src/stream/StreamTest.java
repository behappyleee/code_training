package stream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class StreamTest {
	
	// I/O �� Input �� Output �� ���ڷ� ������ ����� �̶�� ��
	// ������� ��ǻ�� ���� �Ǵ� �ܺ��� ��ġ�� ���α׷����� �����͸� �ְ� �޴� ��
	
	// Stream (�����͸� ��� �ϴµ� ��� �Ǵ� ���� ���)
	// �ڹٿ��� ������� �����Ϸ��� �� ��� �� �ʿ��� �ٸ� ������ �����͸� �����Ϸ���, �� ����� ������ �ϰ�
	// �����͸� ������ �� �ִ� ���𰡰� �ʿ��ѵ� �̰��� Stream �̶�� �Ѵ�.
	
	// Stream �� �ܹ��� ��Ÿ� �����ϱ⿡ �ϳ��� ��Ʈ������ �Է°� ����� ���ÿ� ������� ����
	// �׷��� ������� ���ÿ� ���� �ϱ� ���Ͽ����� InputStream / OutputStream 2 ���� Stream �� �ʿ�
	// Stream �� byte ������ �����͸� ����
	
	// ���� ��Ʈ�� - Stream �� ����� �����ϱ� ���Ͽ� ���� ��Ʈ���� ������
	// ���� ��Ʈ���� ���� �����͸� �ְ� �޴� ��Ʈ���� �ƴϱ� ������ �����͸� ������� �� �� ������ ��Ʈ���� ����� ��� ��Ű�ų�
	// ���ο� ����� �߰��� ����, �׷��� ���� ��Ʈ�� �����δ� ����� �ȵŰ� ��Ʈ���� ���� ���� �� �� ������Ʈ���� �̿�
	
	public static void main(String[] args) {
		try {
			// �ڵ� �����δ� ���� ��Ʈ���� BufferedInputStream �� �Է� ����� �����ϴ� �� ó�� ��������, ���� �Է� ����� BufferedInputStream ��
			// ���� �� FileInputStream �� ������ �ϰ� ���� ��Ʈ���� BufferedInputStream �� Buffer ���� ���� �Ѵ�. Buffer �� �����
			// ����°� ��� ���� ���� ����� ���� �������̴� ����ϱ� ������ ��κ��� ��쿡 ���۸� �̿��Ͽ� ������� ����Ѵ�.

			// 1. File �� �б� ���Ͽ� ���� ��� FileInputStream �� ����
			FileInputStream fis = new FileInputStream("test.txt");
			
			// 2. ��� Stream �� �̿��Ͽ� ���� ��Ʈ���� ����
			BufferedInputStream bis = new BufferedInputStream(fis);
			
			// 3. ���� ��Ʈ���� BufferedInputStream ���� ���� �����͸� ����
			bis.read();	

		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
}
