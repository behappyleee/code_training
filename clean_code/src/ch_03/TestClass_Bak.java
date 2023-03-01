package ch_03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TestClass_Bak {
	
	private static List <Integer> numList = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
//		����
//		���� ���� ������ ���� ������ �����ϴ� �ڷᱸ���̴�.
//
//		�迭�� ���� x (x �� 0)�� �ִ´�.
//		�迭���� ������ ���� ���� ���� ����ϰ�, �� ���� �迭���� �����Ѵ�. 
//		������ ���� ���� ���� �������� ����, ���� ���� ���� ����ϰ�, �� ���� �迭���� �����Ѵ�.
//		���α׷��� ó���� ����ִ� �迭���� �����ϰ� �ȴ�.
//
//		�Է�
//		ù° �ٿ� ������ ���� N(1��N��100,000)�� �־�����. ���� N���� �ٿ��� ���꿡 ���� ������ ��Ÿ���� ���� x�� �־�����. 
//		���� x�� 0�� �ƴ϶�� �迭�� x��� ���� �ִ�(�߰��ϴ�) �����̰�, x�� 0�̶�� �迭���� ������ ���� ���� ���� ����ϰ� 
//		�� ���� �迭���� �����ϴ� ����̴�. �ԷµǴ� ������ -231���� ũ��, 231���� �۴�.
//
//		���
//		�Է¿��� 0�� �־��� ȸ����ŭ ���� ����Ѵ�. ���� �迭�� ��� �ִ� ����ε� ������ ���� ���� ���� ����϶�� �� ��쿡�� 0�� ����ϸ� �ȴ�.
		Scanner scan = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int arrCount = Integer.parseInt(br.readLine());
		
		for(int i=0; i<arrCount; i++) {
			int getNum = Integer.parseInt(br.readLine());
			if(getNum == 0) {
				int findNumber = findNum();
				bw.write(findNumber + "\n");
			} else {
				numList.add(getNum);
			}
		}
		
		bw.flush();
		bw.close();
	}
	
	public static int findNum() {
		if(numList.isEmpty()) return 0;
		Collections.sort(numList);
		int minNum = numList.get(0);
		int findIndex = 0;
		for(int i=0; i<numList.size(); i++) {
			int getNum = numList.get(i);
			if(getNum < 0) getNum = -getNum;
			if(minNum > getNum) {
				minNum = numList.get(i);
				findIndex = i;
			}
		}
		numList.remove(findIndex);
		return minNum;
	}
	
}
