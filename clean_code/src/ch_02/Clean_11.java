package ch_02;

public class Clean_11 {

	// 권장 - 사항 동기화하는 부분을 최대한 적게 만들어라
	// 문제를 노출하는 테스트 케이스를 작성
	// 다중 스레드를 고려하지 않은 순차 코드부터 제대로 돌게 만듦
	// 프로세스 수보다 많은 스레드 수 돌려 보기
	// 흔히 스레드 코드는 오류를 찾기 쉽지 않음, 
	
	public static void main(String[] args) {
		System.out.println("5+2=34 "+3 + 4);
		System.out.println("5+2=34 "+(3+4));
		System.out.println(6 + 1+2);
		
		System.out.println("Hello World !");
	
		Thread a = new Thread();
		
		
		
	}
}
