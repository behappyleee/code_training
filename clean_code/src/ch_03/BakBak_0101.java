package ch_03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class BakBak_0101 {
	
	private static ArrayList<Integer> arrList = new ArrayList<Integer>();
	
	public static void main(String[] args) throws IOException {
		
		// 
		
		
//		문제
//		절댓값 힙은 다음과 같은 연산을 지원하는 자료구조이다.
//
//		배열에 정수 x (x ≠ 0)를 넣는다.
//		배열에서 절댓값이 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다. 
//		절댓값이 가장 작은 값이 여러개일 때는, 가장 작은 수를 출력하고, 그 값을 배열에서 제거한다.
//		프로그램은 처음에 비어있는 배열에서 시작하게 된다.
//
//		입력
//		첫째 줄에 연산의 개수 N(1≤N≤100,000)이 주어진다. 다음 N개의 줄에는 연산에 대한 정보를 나타내는 정수 x가 주어진다. 
//		만약 x가 0이 아니라면 배열에 x라는 값을 넣는(추가하는) 연산이고, x가 0이라면 배열에서 절댓값이 가장 작은 값을 출력하고 
//		그 값을 배열에서 제거하는 경우이다. 입력되는 정수는 -231보다 크고, 231보다 작다.
//
//		출력
//		입력에서 0이 주어진 회수만큼 답을 출력한다. 만약 배열이 비어 있는 경우인데 절댓값이 가장 작은 값을 출력하라고 
//		한 경우에는 0을 출력하면 된다.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int count = Integer.parseInt(br.readLine());
		
		for(int i=0; i<count; i++) {
			int inputNum = Integer.parseInt(br.readLine());
			if(inputNum == 0) {
				if(arrList.isEmpty()) {
					bw.write(0 + "\n");
					continue;
				}
				int minIndex = checkMinIndex();
				bw.write(arrList.get(minIndex)+ "\n");
				arrList.remove(minIndex);
				continue;
			}
			arrList.add(inputNum);
		}
		
		bw.flush();
		bw.close();
	}
	
	private static int checkMinIndex() {
		int minNum = Collections.max(arrList);
		
		
		System.out.println("CHECK MIN INDEX : " + minNum);
		
		
		int minIndex = 0;
		for(int i=0; i<arrList.size(); i++) {
			int currentNum = arrList.get(i);
			if(currentNum < 0) {
				if((-currentNum) < minNum) {
					minNum = currentNum;
					minIndex = i;
					continue;
				}
			} else {
				if(currentNum < minNum) {
					minNum = currentNum;
					minIndex = i;
				}
			}
		}
		
		return minIndex;
	}
	
	
	
}
