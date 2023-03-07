package generic;

public class GenericTest {
	
	// ���׸�
	// JDK 1.8 ���� ���� �Ǿ����� ���ٽ� ��ŭ ū ��ȭ
	// Ÿ�� �������� ���δٴ� ���� �ǵ����� ���� Ÿ���� ��ü�� ����Ǵ� ���� ����, ���� �� ��ü�� ���� �� �� ������ Ÿ�԰�
	// �ٸ� Ÿ������ �߸� ����ȯ �Ǿ� �߻��� �� �ִ� ������ �ٿ� ��
	
	// ���׸� ����
	// 1. Ÿ�� �������� ����
	// 2. Ÿ��üũ�� �� ��ȯ�� ������ �� �����Ƿ� �ڵ尡 ����
	public static void main(String[] args) {
		Box b = new Box();	// �Ϲ� Ŭ���� ��ü ����
		// ���׸��� ���ԵǱ� �� ������ �ڵ� ȣȯ�� ���Ͽ� ���׸� Ŭ���������� ������ ������ε� ���� �����ϰ� ����
		GenericBox<String> bg = new GenericBox<>();	// Generic �� �Ϲ� Ÿ���� ����
		// ���� �ڵ�� ȣȯ�� ���Ͽ� ���� ������ ���� ��� �߻�
		GenericBox bgTest= new GenericBox();
		bgTest.setItem(new Object());
		bgTest.setItem("TEST !");
		
	}
	
}

// ���׸� Ŭ���� ����
class Box {
	Object item;
	
	void setItem(Object item) {
		this.item = item;
	}
	
	Object getitem() {
		return this.item;
	}
	
}

// ���׸� Ŭ������ ��ȯ
// T ������ ������ Ÿ��
class GenericBox<T> {
	T item;
	
	void setItem(T item) {
		this.item = item;
	}
	
	T getItem() {
		return this.item;
	};
	
}

// ���׸� ���δ� static ������ ����� �� ����
class StaticGeneric<T> {
	// �ش� static ���� �߻� static �� �ν��Ͻ� ������ ������ �� ���⿡ ������ �߻�
	// public static T time;
	
}





