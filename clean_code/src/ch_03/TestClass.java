package ch_03;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TestClass {
	public static void main(String[] args) throws IOException {
//		����
//		�� N���� �־����� ��, i��° ������ j��° ������ ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
//
//		�Է�
//		ù° �ٿ� ���� ���� N�� ���� ���ؾ� �ϴ� Ƚ�� M�� �־�����. 
//		��° �ٿ��� N���� ���� �־�����. ���� 1,000���� �۰ų� ���� �ڿ����̴�. 
//		��° �ٺ��� M���� �ٿ��� ���� ���ؾ� �ϴ� ���� i�� j�� �־�����.
//
//		���
//		�� M���� �ٿ� �Է����� �־��� i��° ������ j��° ������ ���� ����Ѵ�.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String[] getNum = br.readLine().split(" ");
		
		int numCount = Integer.parseInt(getNum[0]);
		int getCount = Integer.parseInt(getNum[1]);
		
		String[] numArr = br.readLine().split(" ");
		
		for(int i=0; i<getCount; i++) {
			int sum = 0;
			String[] indexNum = br.readLine().split(" ");
			int firstIndex = Integer.parseInt(indexNum[0]);
			int secondIndex = Integer.parseInt(indexNum[1]);
			for(int j=(firstIndex-1); j<secondIndex; j++) {
				sum += Integer.parseInt(numArr[(j)]);
			}
			bw.write(sum + "\n");
		}
		bw.flush();
		bw.close();
	}
	
}
