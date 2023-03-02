package inheritance;

public class SuperTest {
	
	// Super - 자손 클래스에서 조상 클래스 로부터 상속받은 멤버를 참조하는데 사용 되는 참조 변수
	// 멤버 변수와 지역 변수의 이름이 같을 시 this 를 사용하여 구별하였듯이 상속 받은 멤버와 자신의 클래스의 정의된
	// 이름이 같을 시에는 super 를 붙여 구별이 가능
	
	// 자손 클래스와 부모 클래스의 변수 값이 같을 시 this 와 super 로 변수 구별이 가능
	// super.x 는 부모 클래스에서 x 변수를 찾으며 this.x 는 자식 클래스에서 x 변수를 찾는다.
	// super.메서드명 으로 부모클래스에 메서드도 호출이 가능 하다.
	
	// this() 와 마찬가지로 super() 도 부모 생성자를 호출한다.
	
	// 자손 클래스의 인스턴스를 생성 시 자손의 멤버와 조상의 멤버가 모두 합쳐진 하나의 인스턴스가 생성이 됨
	// 그래서 자손 클래스의 인스턴스가 조상 클래스의 멤버들을 사용이 가능
	
	// 생성자의 첫 줄에서 조상 클래스의 생성자를 호출해야 하는 이유는 자손 클래스의 멤버가 조상 클래스의 멤버를 사용 할 수도 있으므로
	// 조상의 멤버들이 먼저 초기화가 되어 있어야 함
	
	// 이와 같이 조상 클래스 생성자의 호출은 클래스의 상속 관계를 거슬러 올라가면서 계속 반복 되므로 마지막으로 모든 클래스의 최고 조상인
	// Object 클래스의 생성자인 Object() 까지 가서야 끝이 난다.
	
	// 그래서 Object 를 제외한 모든 클래스의 생성자는 첫 줄에 반드시 자신의 다른 생성자 또는 조상의 생성자를 호출하여야 함
	// 그렇지 않으면 컴파일러는 생성자의 첫줄에 super() 를 자동적으로 추가함
	
	// 클래스 - 어떤 클래스의 인스턴스를 생성할 것인가 ?
	// 생성자 - 선택한 클래스의 어떤 생성자를 이용하여 인스턴스를 생성할 것인가 ?
	
	// 어떤 클래스의 인스턴스를 생성하면 클래스 상속 관계의 최고 조상인 Object 클래스 까지 거슬러 올라가면서 모든 조상 클래스의
	// 생성자가 순서대로 호출 된다는 것을 알 수 있다.
	
	
}

class Parent {
	int x = 10;
}

class ChildTest extends Parent {
	// x / this.x / super.x ==> 모두 같은 값을 의미하므로 같은 값이 출력 됨
	void method() {
		System.out.println("X : " + x);
		System.out.println("this.x : " + this.x);
		System.out.println("super.x : " + super.x);
	}
}

class Super2 {
	
}

class Parent2 {
	int x = 10;
}

class Child2 extends Parent2 {
	// 생성자 첫줄에 super() 를 컴파일러가 자동으로 붙여 준다
	// 자손 클래스에서 부모 클래스 멤버 변수와 메서드를 그대로 사용하므로 부모 클래스도 초기화가 필수 이다.
	int x = 20;
	void method() {
		System.out.println("x : " + x);				// 20
		System.out.println("this.x : " + this.x);	// 20
		System.out.println("super.x : " + super.x);	// 10
	}
}

class PointReTest {
	int x;
	int y;
	PointReTest(int x, int y) {
		this.x = x;
		this.y = y;
	}
	String getLocation() {
		return "x : " + x + " y : " + y;
	}
}

class Point3DTest extends PointReTest {
	int z;
	Point3DTest(int x, int y, int z) {
		// 생성자가 정의 되어 있는 클래스는 컴파일러가 자동으로 생성자를 추가 생성해 주지 않는다 !!! 
		// 부모 클래스 중 super() 가 없기에 컴파일 에러가 발생
		// 부모 클래스에 기본 생성자를 추가해 주던가 super(x, y) 를 자식 클래스 생성자 첫줄에 추가하여 준다 !
		// super();
		this.x = x;
		this.y = y;
		this.z = z;
	}
	String getLocation() {
		return "x : " + x + " y : " + y + " z : " + z;
	}
	
}






