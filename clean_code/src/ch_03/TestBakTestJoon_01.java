package ch_03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.Stack;

public class TestBakTestJoon_01 {
	
	public static void main(String[] args) throws IOException {
//		문제
//		과거 이집트인들은 각 변들의 길이가 3, 4, 5인 삼각형이 직각 삼각형인것을 알아냈다. 
//		주어진 세변의 길이로 삼각형이 직각인지 아닌지 구분하시오.
//
//		입력
//		입력은 여러개의 테스트케이스로 주어지며 마지막줄에는 0 0 0이 입력된다. 
//		각 테스트케이스는 모두 30,000보다 작은 양의 정수로 주어지며, 각 입력은 변의 길이를 의미한다.
//
//		출력
//		각 입력에 대해 직각 삼각형이 맞다면 "right", 아니라면 "wrong"을 출력한다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int countCase = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < countCase; i++) {
			String[] data = br.readLine().split("");
			boolean isRight = checkIsRight(data);
			if(isRight) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
		
		
		
	}
	
	private static boolean checkIsRight(String[] strData) {
		boolean isRight = false;
		if(strData.length == 0) return isRight;
		if(strData[0].equals(")")) return isRight;
		if(strData.length % 2 != 0) return isRight;
		if(strData[strData.length-1].equals("(")) return isRight;
		
		Stack <String> stackData = new Stack<>();
		
		for(int i=0; i<strData.length; i++) {
			if(!stackData.isEmpty() && strData[i].equals(")") && stackData.lastElement().equals("(")) {
				stackData.pop();
				continue;
			}
			if(strData[i].equals("(") || strData[i].equals(")")) {
				stackData.add(strData[i]);
			} 	
		}
		
		if(stackData.isEmpty()) {
			isRight = true;
		}
		return isRight;
	}
	
}
