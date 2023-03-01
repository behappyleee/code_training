package ch_03;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TestClass {
	public static void main(String[] args) throws IOException {
//		문제
//		수 N개가 주어졌을 때, i번째 수부터 j번째 수까지 합을 구하는 프로그램을 작성하시오.
//
//		입력
//		첫째 줄에 수의 개수 N과 합을 구해야 하는 횟수 M이 주어진다. 
//		둘째 줄에는 N개의 수가 주어진다. 수는 1,000보다 작거나 같은 자연수이다. 
//		셋째 줄부터 M개의 줄에는 합을 구해야 하는 구간 i와 j가 주어진다.
//
//		출력
//		총 M개의 줄에 입력으로 주어진 i번째 수부터 j번째 수까지 합을 출력한다.
		
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
