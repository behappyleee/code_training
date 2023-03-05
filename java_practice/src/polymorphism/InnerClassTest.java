package polymorphism;

public class InnerClassTest {
	
	// InnerClass - 내부 클래스는 AWT 나 Swing 과 같은 GUI 어플리케이션 이벤츠 처리 외에는 잘 사용하지 않을 정도로 빈도가 높지는 않음
	// 내부 클래스는 클래스 내에 선언됨
	class Inner {
		// 내부 클래스의 장점
		// 내부 클래스에서 외부 클래스의 멤버 들 쉽게 제공
		// 코드의 복잡성을 줄일 수 있음 (복잡성)
		
		// 내부 클래스 선언 (instance class, static class, local class, anonymous class)
		
	}
	
	class InstanceInner {}
	static class StaticInner {}
	
	private class PrivateInstanceInner {}
	private static class PrivateStaticInner {}
	
	static int cc = 0;
	int a = 3;
	
	// 익명 클래스 - 익맹 클래스는 특이하게도 다른 내부 클래스들과 다르게 이름이 없음 선언과 객체의 생성을 동시에 하여 단 한번만 사용이 가능하고
	// 오직 하나의 객체만 을 생성할 수 있는 일회용 클래스임
	// 익명 클래스는 일회용 처럼 한번만 사용하고 없어 짐
	Object ob = new Object() { void method() {};};
	
	
	class InnerConstructor {
		public InnerConstructor() {
			
		}
	}
	
	void myMethod() {
		
		
	}
	
	
}
