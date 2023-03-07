package generic;

public class GenericTest {
	
	// 제네릭
	// JDK 1.8 부터 도입 되었으며 람다식 만큼 큰 변화
	// 타입 안정성을 높인다는 것은 의도하지 않은 타입의 객체가 저장되는 것을 막고, 저장 된 객체를 꺼내 올 때 원래의 타입과
	// 다른 타입으로 잘못 형벼환 되어 발생할 수 있는 오류를 줄여 줌
	
	// 제네릭 장점
	// 1. 타입 안정성을 제공
	// 2. 타입체크와 형 변환을 생략할 수 있으므로 코드가 간결
	public static void main(String[] args) {
		Box b = new Box();	// 일반 클래스 객체 생성
		// 제네릭이 도입되기 전 이전의 코드 호환을 위하여 제네릭 클래스이지만 예전의 방식으로도 생성 가능하게 해줌
		GenericBox<String> bg = new GenericBox<>();	// Generic 에 일반 타입을 지정
		// 이전 코드와 호환을 위하여 막아 놓지는 않음 경고만 발생
		GenericBox bgTest= new GenericBox();
		bgTest.setItem(new Object());
		bgTest.setItem("TEST !");
		
	}
	
}

// 제네릭 클래스 선언
class Box {
	Object item;
	
	void setItem(Object item) {
		this.item = item;
	}
	
	Object getitem() {
		return this.item;
	}
	
}

// 제네릭 클래스로 변환
// T 임의의 참조형 타입
class GenericBox<T> {
	T item;
	
	void setItem(T item) {
		this.item = item;
	}
	
	T getItem() {
		return this.item;
	};
	
}

// 제네릭 으로는 static 변수를 사용할 수 없다
class StaticGeneric<T> {
	// 해당 static 에러 발생 static 은 인스턴스 변수를 참조할 수 없기에 에러가 발생
	// public static T time;
	
}





