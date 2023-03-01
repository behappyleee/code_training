package object;

public class Card {
	
	// 인스턴스 변수
	String kind; 	// 무늬
	int number;		// tntwk
	
	// 클래스 변수 (모든 인스턴스가 같은 값)
	static int width  = 100;	// 폭
	static int height = 250;	// 높이
	
	public static void main(String[] args) {
		
		System.out.println("CARD WIDTH : " + Card.width);
		System.out.println("CARD HEIGHT : " + Card.height);
		
		Card c1 = new Card();
		c1.kind = "Heart";
		c1.number = 7;
		
		Card c2 = new Card();
		c2.kind = "spade";
		c2.number = 4;
		
		c1.width = 50;
		c1.height = 80;
		
		// c1 참조 변수만 값을 변경 하였지만 클래스  변수라 값을 공유하여 c1 c2 width height 값이 모두 바뀜
		System.out.println("C1 : " + c1.width + " , " + c1.height);
		System.out.println("C1 : " + c2.width + " , " + c2.height);
	
		
		// TODO
		// 249 page 메서드 부터 보기 !!!!
		// 메서드 내부는 몰라도 상관이 없다
		
		// 메서드 사용이유는 1. 높은 재 사용성 (re-usability) 2. 중복 된 코드의 제거
		// 메서드는 선언부와 구현 부가 있음
		// 메서드 이름만으로도 기능을 쉽게 알 수 있도록 함축적이면서 의미 있는 이름을 지을 수 있도록 노력
		// 메서드를 작성할 시 에는 반드시 매개변수를 유효성 검사 코드를 추가를 하여야 함 
		
		
	}
	
	
}
