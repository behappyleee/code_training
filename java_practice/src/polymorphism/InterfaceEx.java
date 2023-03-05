package polymorphism;

public class InterfaceEx {
	
	// 인터페이스를 사용하기 위하여서는 다음을 이해
	// 클래스를 사용하는 쪽 (User) 과 클래스를 제공 (Provider) 하는 쪽이 있음
	// 메서드를 사용 (호출) 하는 쪽(User) 에서는 사용하려는 메서드 (Provider) 의 선언부만 알면 됨 (내용은 몰라도 됨) 
	
	public static void main(String[] args) {
		// 이러한 경우는 A 클래스를 작성하기 위하여서는 클래스 B가 이미 작성이 되어 있어야 함
		// 클래스 A 는 클래스 B 의 인스턴스를 생성 후 메서드를 호출 이 두 클래스는 서로 직접전인 관계가 있음
		// 직접적인 관계는 두 클래스 중 한쪽만 변경이 되어도 다른 쪽도 변경이 이루어져야 한다
		A a = new A();
		a.methodA(new B());
	}
	
}

//------------------------------------- 인터페이스를 사용하여 간접적으로 연결 한 예제

// Class B 에 정의 된 메서드를 추상 메서드로 정의하는 인터페이스 IB 로 정의
interface IB {
	public abstract void methodB();
}

class B_ex implements IB {
	public void methodB() {
		System.out.println("method B in Class B !!");
	}
}

class A_ex {
	// 클래스 A 를 작성하는데 있어 클래스 B가 사용되지 않음 A-B 직접적인 관계에서 A-I-B 간접적인 관계로 바뀜
	// 인터페이스를 사용하여 간접적으로 호출이 가능
	public void methodA(IB i) {
		i.methodB();
	}
}






// ------------------------------------- 두 클래스가 직접적으로 연결 된 예제

class A {
	public void methodA(B b) {
		b.methodB();
	}
}

class B {
	public void methodB() {
		System.out.println("Class B method B() !!");
	}
}


