package inheritance;

public class OverridingTest {
	
	// 오버라이딩
	// 조상 클래스로부터 상속 받은 메서드의 내용을 변경하는 것을 오버라이딩 이라고 한다.
	// 상속 받은 메서드를 그대로 사용하기도 하지만 자손 클래스 자신에 맞게 변경해야 하는 경우도 있다.
	
	// 오버라이딩 조건
	// 1. 이름이 같아야 한다.
	// 2. 매개 변수가 같아야 한다.
	// 3. 반환 타입이 같아야 한다.
	
	// 선언부가 같아야 하지만 접근 제어자와 예외 Exception 은 제한 된 조건 한에서만 다르게 변경이 가능
	
	// 접근제어자를 조상 클래스 메서드 보다 좁은 범위로 변경이 불가능
	// 예외는 조상 클래스의 메서드보다 많이 선언 할 수 없음
	// 인스턴스 메서드를 static 메서드 또는 그 반대로 변경이 안됨
	
	
	// Overloading - 기존에 없는 메서드를 새로 작성 new
	// Overriding - 상속 받은 메서드를 재 정의 change / modifiy
	
	// Super - 자손 클래스에서 조상 클래스 로부터 상속받은 멤버를 참조하는데 사용 되는 참조 변수
	// 멤버 변수와 지역 변수의 이름이 같을 시 this 를 사용하여 구별하였듯이 상속 받은 멤버와 자신의 클래스의 정의된
	// 이름이 같을 시에는 super 를 붙여 구별이 가능

}


class PointTest {
	int x;
	int y;
	int k;
	String getLocation() {
		return "x : " + x +" , y : " + y;
	}
}

class Point3D extends PointTest {
	int z;
	String getLocation() {	// Overriding
		return "x : " + x + " , y : " + y + ", z : " + z;
	}
}



