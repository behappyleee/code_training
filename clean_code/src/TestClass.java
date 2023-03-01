import java.util.Scanner;

public class TestClass {
	public static void main(String[] args) {
//		문제
//		N*M크기의 두 행렬 A와 B가 주어졌을 때, 두 행렬을 더하는 프로그램을 작성하시오.
//
//		입력
//		첫째 줄에 행렬의 크기 N 과 M이 주어진다. 둘째 줄부터 N개의 줄에 행렬 A의 원소 M개가 차례대로 주어진다. 
//		이어서 N개의 줄에 행렬 B의 원소 M개가 차례대로 주어진다. N과 M은 100보다 작거나 같고, 
//		행렬의 원소는 절댓값이 100보다 작거나 같은 정수이다.
//
//		출력
//		첫째 줄부터 N개의 줄에 행렬 A와 B를 더한 행렬을 출력한다. 행렬의 각 원소는 공백으로 구분한다.
		
		Scanner scan = new Scanner(System.in);
		
		int getArrI = Integer.parseInt(scan.nextLine());
		int getArrJ = Integer.parseInt(scan.nextLine());
		
		int[][] arr_1 = new int[getArrI][getArrJ];
		int[][] arr_2 = new int[getArrI][getArrJ];
		int[][] sumArr = new int[getArrI][getArrJ];
		
		for(int i = 0; i<arr_1.length; i++) {
			String[] getStrArr = scan.nextLine().split(" ");
			for(int j=0; j<getStrArr.length; j++) {
				arr_1[i][j] = Integer.parseInt(getStrArr[j]);	
			}
		}
		
		for(int i=0; i<arr_2.length; i++) {
			String[] getArr = scan.nextLine().split(" ");
			for(int j=0; j<getArr.length; j++) {
				arr_2[i][j] = Integer.parseInt(getArr[j]);
				System.out.print((arr_1[i][j] + arr_2[i][j]) + " ");
			}
			System.out.println();
		}
		
	}
}
