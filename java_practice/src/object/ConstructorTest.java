package object;

public class ConstructorTest {
	
	// 생성자 (Constructor)
	// 생성자를 잘 활용 시 보다 간결하고 직관적인 객체지향적인 코드 작성이 가능
	// 생성자는 인스턴스가 생성 될 시 에 호출되는 인스턴스 초기화 메서드임
	// 주로 인스턴스 초기화 작업에 주로 사용이 되며 인스턴스 실행 시에 사용 되어야 할 작업에도 사용이 됨
	
	// 생성자 조건
	// 1. 생성자 이름은 클래스의 이름과 같아야 함ㅇ
	// 2. 생성자는 리턴값이 없음
	
	// 연산자 new 가 인스턴스를 생성하는 것이지 생성자가 인스턴스를 생성하는 건 아님
	// 생성자는 단순히 인스턴스 변수들의 초기화에 사용되는 조금 특별한 메서드임 
	public ConstructorTest() {
		
	}
	
	public static void main(String[] args) {
		// new 라는 연산자에 의하여 인스턴스가 생성이 됨
		// 모든 클래스에는 반드시 하나 이상의 생성자가 정의 되어 있어야 함
		ConstructorTest ct = new ConstructorTest();
		
		// 기본 생성자가 컴파일러에 의해서 자동 추가 되는 경우는 생성자가 하나도 없을 때만 생성이 됨
		
		// 생성자가 매개변수가 존재하지 않을 시 아래처럼 그냥 default 생성자로 생성이 가능
		Test t = new Test();
		
		// 기본 생성자에 매개 변수가 필요 할 시 반드시 매개변수를 넣어주어야 함
		// ArgsTest at = new ArgsTest();
		
	}
	
}

class Car {
	String color;
	Car() {
		
	}
	Car(String color) {
		// 만약 this 를 적지 않으면 둘 다 지역변수로 간주 됨
		// default 생성자 호출 맨 앞에 적어주어야 함
		this();
		color = color;		 // 이렇게 적을 시 인스턴스 변수 color 와 지역변수 color 가 구분이 안됨
		this.color = color;	 // 이런식으로 this 를 적어주면서 본인 인스턴스 변수를 가르쳐주어야 함
	}
	// this 키워드를 사용할 수 있는 메서드는 인스턴스 메서드 뿐임
	// static 메서드는 this 가 사용이 불가 
	// static 메서드는 this 사용 시점에 해당 인스턴스가 생성이 되었는 지 불확실 하기에 사용이 불가
	public void paintCar() {
		System.out.println("PAINT THIS CAR : " + this.color);
	}
	public static void printCar() {
		// System.out.println("PAINT STATIC THIS CAR : " + this.color);
	}
}

// 생성자에서 다른 생성자를 호출하여야 할 시 this 를 사용
class ThisTest {
	ThisTest() {
		// ThisTest("a");
		//  한 클래스에서 다른 생성자를 호출 할 시 위에 처럼 생성자를 적은 뒤 매개변수를 넣어주는 것이 아닌
		// this 를 사용하여 한 클래스내에서 다른 생성자를 호출 함
		
		// 한 클래스에 생성자 내에서 다른 생성자를 호출 시 반드시 첫줄에 적어야 함
		// 첫줄에 적지 않을 시 생성자에서 다른 생성자를 호출 시 이전 작업들이 의미가 없어지기 때문임
		// String test = "7";
		
		this("a");
		String test = "7";
	}
	
	ThisTest(String a) {
		
	}
	
	
	
}

class ArgsTest {
	ArgsTest (int a) {
	}
}

class Test {
	Test() {
	}
}

