package ch_03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TestClassBak_01 {
	
	
	public static void main(String[] args) throws IOException {
//		문제
//		두 자연수 A와 B에 대해서, A의 배수이면서 B의 배수인 자연수를 A와 B의 공배수라고 한다. 
//		이런 공배수 중에서 가장 작은 수를 최소공배수라고 한다. 예를 들어, 6과 15의 공배수는 30, 60, 90등이 있으며, 최소 공배수는 30이다.
//
//		두 자연수 A와 B가 주어졌을 때, A와 B의 최소공배수를 구하는 프로그램을 작성하시오.
//
//		입력
//		첫째 줄에 테스트 케이스의 개수 T(1 ≤ T ≤ 1,000)가 주어진다. 둘째 줄부터 T개의 줄에 걸쳐서 A와 B가 주어진다. (1 ≤ A, B ≤ 45,000)
//
//		출력
//		첫째 줄부터 T개의 줄에 A와 B의 최소공배수를 입력받은 순서대로 한 줄에 하나씩 출력한다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int countCase = Integer.parseInt(br.readLine());
		
		for(int i=0; i<countCase; i++) {
			String[] nums = br.readLine().split(" ");
			int a = Integer.parseInt(nums[0]);
			int b = Integer.parseInt(nums[1]);
			int minMulNum = mulNum(a, b);
			bw.write(minMulNum + "\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	private static int mulNum(int a, int b) {
		int selectNum = (a > b) ? b : a;
		for(int i=selectNum; i>0; i--) {
			if((i != 1) && (a % i == 0) && (b % i == 0)) {
				for(int j=1; ; j++) {
					int mul = (i * j);
					if((mul % a == 0) && (mul % b == 0)) {
						return mul;
					}
				}
			}
		}
		return (a*b);
	}

}
