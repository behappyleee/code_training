import java.util.Scanner;

public class TestClass {
	public static void main(String[] args) {
//		����
//		N*Mũ���� �� ��� A�� B�� �־����� ��, �� ����� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
//
//		�Է�
//		ù° �ٿ� ����� ũ�� N �� M�� �־�����. ��° �ٺ��� N���� �ٿ� ��� A�� ���� M���� ���ʴ�� �־�����. 
//		�̾ N���� �ٿ� ��� B�� ���� M���� ���ʴ�� �־�����. N�� M�� 100���� �۰ų� ����, 
//		����� ���Ҵ� ������ 100���� �۰ų� ���� �����̴�.
//
//		���
//		ù° �ٺ��� N���� �ٿ� ��� A�� B�� ���� ����� ����Ѵ�. ����� �� ���Ҵ� �������� �����Ѵ�.
		
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
