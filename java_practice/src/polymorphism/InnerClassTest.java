package polymorphism;

public class InnerClassTest {
	
	// InnerClass - ���� Ŭ������ AWT �� Swing �� ���� GUI ���ø����̼� �̺��� ó�� �ܿ��� �� ������� ���� ������ �󵵰� ������ ����
	// ���� Ŭ������ Ŭ���� ���� �����
	class Inner {
		// ���� Ŭ������ ����
		// ���� Ŭ�������� �ܺ� Ŭ������ ��� �� ���� ����
		// �ڵ��� ���⼺�� ���� �� ���� (���⼺)
		
		// ���� Ŭ���� ���� (instance class, static class, local class, anonymous class)
		
	}
	
	class InstanceInner {}
	static class StaticInner {}
	
	private class PrivateInstanceInner {}
	private static class PrivateStaticInner {}
	
	static int cc = 0;
	int a = 3;
	
	// �͸� Ŭ���� - �͸� Ŭ������ Ư���ϰԵ� �ٸ� ���� Ŭ������� �ٸ��� �̸��� ���� ����� ��ü�� ������ ���ÿ� �Ͽ� �� �ѹ��� ����� �����ϰ�
	// ���� �ϳ��� ��ü�� �� ������ �� �ִ� ��ȸ�� Ŭ������
	// �͸� Ŭ������ ��ȸ�� ó�� �ѹ��� ����ϰ� ���� ��
	Object ob = new Object() { void method() {};};
	
	
	class InnerConstructor {
		public InnerConstructor() {
			
		}
	}
	
	void myMethod() {
		
		
	}
	
	
}
