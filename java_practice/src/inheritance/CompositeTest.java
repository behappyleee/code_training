package inheritance;

public class CompositeTest {
	
	// 상속을 통하여 클래스 간에 관계를 맺어주고 클래스를 재사용 하는 방법이 있었지만
	// 상속 이외에도 클래스를 재 사용 하는 방법은 클래스간에 포함 (Composite) 관계를 맺어주는 것임
	
	/// 클래스 간에 포함 관계를 맺어 주는 것은 한 클래스의 멤버변수로 다른 클래스 타입의 참조변수를
	// 선언하는 것을 뜻 함
	
	// 조상 클래스에 정의 된 메서드의 같은 메서드를 자손 클래스에 정의하는 것을 오버라이딩이라고 함
	
	
	
}

// 포함은 has
// extends 는 is 와 비슷한 개념임

class Circle {
	// int x;
	// int y;
	// 포함 (Composite) 를 이용시 다음과 같이 사용이 가능함
	Point c = new Point();	
	int z;
}

class Point {
	int x;
	int y;
	
}

// 아예 extends 를 하여 사용도 가능함
class CircleExtends extends Point {
	
	int r;
}

