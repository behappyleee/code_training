package generic;

import java.util.ArrayList;

public class FruitGeneric {
	
	public static void main(String[] args) {
		
		// 에러 발생 제네릭 객체 생성시 상속 관계여도 다형성 관계가 불가능 하다
		// FruitTest<Fruit> fTest = new FruitTest<Grape>() ;
		
		FruitTest<Fruit> fTest = new FruitTest<Fruit>() ;
		// 제네릭에 다형성 관계를 적용하고 싶을 시 객체 생성 후에 상속받은 자식 관계에 객체를 넣어준다.
		fTest.add(new Apple());
		
		// Fruit 을 상속 받은 객체만 타입으로 지정이 가능하다
		LimitGeneric<Apple> liA = new LimitGeneric<Apple>();
		
		// 에러 발생 Toy 는 Fruit 과 상속 관계가 아니다
		// LimitGeneric<Toy> toyTest = new LimitGeneric<Toy>();
		
		
		
		
	}
	
}

// 타입 문자로 사용 할 타입을 명시하여 한 타입만 저장할 수 있도록 제한을 할 수 있지만 그래도 여전히 모든 종류의 타입을 지정 할 수 있다는 것은 변한이 없다.
// 타입 매개변수 T 에 지정할 수 있는 타입의 종류를 제한하는 방법 .. ?

interface Eatable {
	
	public void eat();
}

// Fruit 으로 제네릭 타입을 제한 하면서 Eatable 인터페이스를 구현 필요시에는  & 로 묶어줄 수 있다.
class InterfaceClassGeneric <T extends Fruit & Eatable> {
	
}


// Fruit 과 상속 관계인 타입만 지정할 수 있도록 제한 이 가능하다
// 제네릭 타입 제한을 원할 시 클래스나 인터페이스도 가능하며 둘다 extends 키워드를 사용하여 제네릭 타입 지정 제한이 가능하다.
class LimitGeneric<T extends Fruit> {
	
}


class Fruit {
	public String toString() {
		return "Fruit";
	}
}

class Apple extends Fruit {
	public String toString() {
		return "Apple";
	}
}

class Grape extends Fruit {
	public String toString() {
		return "Grape";
	}
}

class Toy {
	public String toString() {
		return "Toy";
	}
}

class FruitTest<T> {
	// T[] testAr = new T[10]; 에러 발생 Generic 타입으로 배열 객체 생성 불가
	ArrayList<T> list = new ArrayList<T>();
	
	void add(T item) {
		list.add(item);
	}
	
	T get(int i) {
		return list.get(i);
	}
	
	int size() {
		return list.size();
	}
	
	public String toString() {
		return list.toString();
	}
	
}



