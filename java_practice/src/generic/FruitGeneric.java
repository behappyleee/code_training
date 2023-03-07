package generic;

import java.util.ArrayList;

public class FruitGeneric {
	
	public static void main(String[] args) {
		
		// ���� �߻� ���׸� ��ü ������ ��� ���迩�� ������ ���谡 �Ұ��� �ϴ�
		// FruitTest<Fruit> fTest = new FruitTest<Grape>() ;
		
		FruitTest<Fruit> fTest = new FruitTest<Fruit>() ;
		// ���׸��� ������ ���踦 �����ϰ� ���� �� ��ü ���� �Ŀ� ��ӹ��� �ڽ� ���迡 ��ü�� �־��ش�.
		fTest.add(new Apple());
		
		// Fruit �� ��� ���� ��ü�� Ÿ������ ������ �����ϴ�
		LimitGeneric<Apple> liA = new LimitGeneric<Apple>();
		
		// ���� �߻� Toy �� Fruit �� ��� ���谡 �ƴϴ�
		// LimitGeneric<Toy> toyTest = new LimitGeneric<Toy>();
		
		
		
		
	}
	
}

// Ÿ�� ���ڷ� ��� �� Ÿ���� ����Ͽ� �� Ÿ�Ը� ������ �� �ֵ��� ������ �� �� ������ �׷��� ������ ��� ������ Ÿ���� ���� �� �� �ִٴ� ���� ������ ����.
// Ÿ�� �Ű����� T �� ������ �� �ִ� Ÿ���� ������ �����ϴ� ��� .. ?

interface Eatable {
	
	public void eat();
}

// Fruit ���� ���׸� Ÿ���� ���� �ϸ鼭 Eatable �������̽��� ���� �ʿ�ÿ���  & �� ������ �� �ִ�.
class InterfaceClassGeneric <T extends Fruit & Eatable> {
	
}


// Fruit �� ��� ������ Ÿ�Ը� ������ �� �ֵ��� ���� �� �����ϴ�
// ���׸� Ÿ�� ������ ���� �� Ŭ������ �������̽��� �����ϸ� �Ѵ� extends Ű���带 ����Ͽ� ���׸� Ÿ�� ���� ������ �����ϴ�.
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
	// T[] testAr = new T[10]; ���� �߻� Generic Ÿ������ �迭 ��ü ���� �Ұ�
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



