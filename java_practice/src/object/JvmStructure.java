package object;

public class JvmStructure {
	
	// JVM�� ���� �޸� ����
	// JVM �� �޸𸮸� ������ ���� ���� �������� ������ ����
	// Method Area / Call Stack / Heap
	
	// 1. Method Area �޼��� ����
	// ���α׷� ���� �� � Ŭ������ ����� �Ǹ� JVM �� �ش� Ŭ���� ���� (.class) �� �о �м��Ͽ�
	// Ŭ������ ���� ������ �̰��� ����
	
	// 2. Heap
	// �ν��Ͻ��� ������ �Ǵ� ����, ���α׷� ���� �� �����Ǵ� �ν��Ͻ��� ��� �� ���� ����
	// �ν��Ͻ� ����(instance variable) ���� �����Ǵ� ����
	
	// 3. Call Stack
	// ȣ�⽺���� �޼����� �۾��� �ʿ��� �޸� ������ ����, �޼��尡 ȣ���� �Ǹ� ȣ�⽺�ÿ� ȣ�� �� �޼��带 ���� �޸𸮰� �Ҵ�
	// �� �޸𸮴� �۾��� �����ϴ� ���� ����������� ������ �߰���� ���� �����ϴµ� ���, �޼��尡 �۾��� ��ġ�� �Ҵ� �Ǿ��� �޸� 
	// ������ ��ȯ�� ��
	
	
	public static void main(String[] args) {
		TestParam t = new TestParam();
		t.x = 7;
		// �ٲ��� ����
		System.out.println("BEFORE T : " + t.x);
		changeNum(t.x);
		System.out.println("AFTER T : " + t.x);
		
		// �Ű������� ���� �����Ͽ� ������ �ϹǷ� �ּҰ��� ���� �� ���� ��ü�� ���� �ٲ�
		changeObjectNum(t);
		System.out.println("CHANGE OBJECT TX NUM :  " + t.x);
	}
	
	public static void changeNum(int a) {
		a = 10;
		System.out.println("PARAM a : " + a);
	}
	
	public static void changeObjectNum(TestParam p) {
		p.x = 20;
		System.out.println("P.X : " + p.x);
	}
	
	
}


class TestParam {
	int x;
}