package polymorphism;

public class InterfaceEx {
	
	// �������̽��� ����ϱ� ���Ͽ����� ������ ����
	// Ŭ������ ����ϴ� �� (User) �� Ŭ������ ���� (Provider) �ϴ� ���� ����
	// �޼��带 ��� (ȣ��) �ϴ� ��(User) ������ ����Ϸ��� �޼��� (Provider) �� ����θ� �˸� �� (������ ���� ��) 
	
	public static void main(String[] args) {
		// �̷��� ���� A Ŭ������ �ۼ��ϱ� ���Ͽ����� Ŭ���� B�� �̹� �ۼ��� �Ǿ� �־�� ��
		// Ŭ���� A �� Ŭ���� B �� �ν��Ͻ��� ���� �� �޼��带 ȣ�� �� �� Ŭ������ ���� �������� ���谡 ����
		// �������� ����� �� Ŭ���� �� ���ʸ� ������ �Ǿ �ٸ� �ʵ� ������ �̷������ �Ѵ�
		A a = new A();
		a.methodA(new B());
	}
	
}

//------------------------------------- �������̽��� ����Ͽ� ���������� ���� �� ����

// Class B �� ���� �� �޼��带 �߻� �޼���� �����ϴ� �������̽� IB �� ����
interface IB {
	public abstract void methodB();
}

class B_ex implements IB {
	public void methodB() {
		System.out.println("method B in Class B !!");
	}
}

class A_ex {
	// Ŭ���� A �� �ۼ��ϴµ� �־� Ŭ���� B�� ������ ���� A-B �������� ���迡�� A-I-B �������� ����� �ٲ�
	// �������̽��� ����Ͽ� ���������� ȣ���� ����
	public void methodA(IB i) {
		i.methodB();
	}
}






// ------------------------------------- �� Ŭ������ ���������� ���� �� ����

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


