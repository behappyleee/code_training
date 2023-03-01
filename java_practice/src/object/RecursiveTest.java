package object;

public class RecursiveTest {
	
	// ��� �Լ�
	// ��� ȣ�� (Recursive Call)
	
	// ��� ȣ���� ���ǹ��� �ݵ�� �־�� �� (���ǹ��� ���� �� ���� ���� �߻� ��)
	// �ݺ����� ���ȣ�⺸�� ����� �ξ� ���� ������ ���ȣ���� ����ϴ� ������ ���� ������ ������
	public static void main(String[] args) {
		int testNum = factorial(4);
		System.out.println(testNum);
	}
	
	// ���ȣ���� ���� �� ���丮��
	static int factorial(int num) {
		if(num == 1) return 1;
		return num * factorial(--num);
	}
	
	// �ν��Ͻ� �޼��忡�� static �޼���� �ν��Ͻ� �޼��尡 ����� ����������
	// static �޼��忡���� static �޼��常 ����� ���� static �޼��尡 ȣ�� �Ǵ� ������
	// �ν��Ͻ� �޼��尡 ���� ������ �ƴϹǷ� (�ν��Ͻ� �޼���� �ν��Ͻ� �����ÿ� �޼��尡 ����� ����)
	// �׿� ���Ͽ� static �޼���� ���α׷� �ε��ÿ� �ٷ� ����� ������
	
	// Ŭ���� �޼���� ������ ���� �Ǵ� ȣ���� ����
	void instanceMethod() {}
	static void staticMethod() {}
	void instanceMethod2() {
		instanceMethod();
		staticMethod();
	}
	static void staticMethod2() {
		// instanceMethod();
		staticMethod();
	}
	
}
