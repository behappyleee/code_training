package inheritance;

public class ModifierTest {
	
	// 제어자 (Modifier)
	
	// 제어자는 클래스나 멤버변수나 메서드에 주로 사용 됨
	
	// 접근 제어자 - public / protected / default / private
	// 그 외 - static / final / abstract / native / transient / synchronized / volatile / strictfp
	
	// static - 인스턴스 변수는 하나의 클래스 로부터 생성 되었더라도 각기 다른 값을 유지하지만 클래스 변수는 인스턴스에 관계 없이 같은 값을 가짐
	// 그 이유는 하나의 변수를 모든 인스턴스가 공유
	// static 키워드 사용 될 수 있는 곳 - 멤버 변수, 메서드, 초기화 블럭
	 
	// final - final 은 마지막 변경 될 수 없는 의미, 거의 모든 대상에 사용이 가능
	// final 사용 가능 한 곳 - 클래스, 메서드, 멤버변수, 지역변수
	// 메서드에 사용시 오버라이딩 안되고 클래스에 사용할 시 상속이 안됨
	// final 이 붙은 변수는 상수이므로 일반적으로 선언과 초기화를 동시에 하지만 인스턴스 변수일 경우 생성자에서 초기화가 가능
	
	// abstarct - 메서드의 선언부만 작성 하고 실제 수행 내용은 구현하지 않은 추상 메서드의 의미 
	// ex ) WindowsAdapter 클래스는 완성 된 클래스이지만 아무 역할도 안하여 Abstract 키워드를 붙여 인스턴스 생성을 못하게 함
	
	// 접근 제어자 (Access Modifier)
	// private - 같은 클래스 내에서만 접근이 가능
	// default - 같은 패키지 내에서만 접근이 가능
	// protected - 같은 패키지 내에서 or 자손 클래스에서만 접근이 가능
	// public - 접근 제한이 전혀 없음
	
	// 클래스나 멤버, 주로 멤버에 접근 제한자를 두는 이유는 클래스에 내부에 선언 된 데이터를 보호 하기 위함
	// 외부에서 접근할 필요가 없는 멤버 들을 private 으로 지정하여 외부에 노출 시키지 않음으로써 복잡성을 줄일 수 있음
	
	// 생정자의 접근 제어자 - 생성자에 접근 제어자를 사용함으로써 인스턴스의 사용 제한이 가능
	
	
	public static void main(String[] args) {
		// Abstract 클래스는 인스턴스 생성이 안 됨
		// testAbs t = new testAbs();
		
	}
	
}

class ExClass extends testAbs {
	// testAbs 클래스이 메서드를 오버라이딩 (추상 메서드를 오버라이딩)
	public void test() {
		
	}
}

abstract class  testAbs {
	String test = "abc";
	abstract public void test();	// 추상 클래스
}