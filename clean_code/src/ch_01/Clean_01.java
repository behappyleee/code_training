package ch_01;

import java.util.ArrayList;
import java.util.List;

public class Clean_01 {
	
	class Test {
		
		// 1. 이름을 잘 짓도록 많은 노력을 기울일 것 (변수명, 소스파일, ear, war, jar ...)
		
		// ex
		int d; // 경과 시간 (단위 : 날짜)
		// 이름 d 는 아무런 의미가 들어나지 않는다.
		
		int elapsedTimeInDays;
		int daysSinceCreation;
		int daysSinceModification;
		int fileAgeInDays;
		
		public List<int []> getThem() {
			List<int []> list1 = new ArrayList<int []>();
			List<int []> theList = new ArrayList<>();
			
			for(int[] x : theList) {
				if(x[0] ==4)
					list1.add(x);
			}
			return list1;
		}
		
	// 2. 문제의 코드는 단순함이 아닌 함축성 (좋은 이름을 줄 시 함수하 하는 일을 이해하기 쉬워짐)
	public List<int []> getFlaggedCells() {
		
		final int STATUS_VALUE = 0;	
		final int FLAGGED = 4;
		List<int []> gameBoard = new ArrayList<>();
		List<int []> flaggedCells = new ArrayList<int []>();
		
		for(int[] cell : gameBoard) {
			if(cell[STATUS_VALUE] == FLAGGED) {
				flaggedCells.add(cell);
			}
		}
		return flaggedCells;
	}
		
	
	
	}
	
	
	
	
	

	public static void main(String[] args) {

		System.out.println("Hello Clean Code World !");
			
		// 1. 이름을 잘 짓도록 많은 노력을 기울일 것 (변수명, 소스파일, ear, war, jar ...)
		
		
		
		
	}
	
}
