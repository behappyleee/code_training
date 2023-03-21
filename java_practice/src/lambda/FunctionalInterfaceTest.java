package lambda;

public class FunctionalInterfaceTest {
	
	// �Լ��� �������̽�
	interface MyFunction {
		public abstract int max(int a, int b);
	}
	
	public static void main(String[] args) {
		// ���ٽ��� �޼���� ������ ��ó�� �����ؿ�����, ��� ���ٽ��� �͸� Ŭ������ ��ü�� �����ϴ�.
		// ���ٽ��� �ش� �Ʒ� �������̽��� ���� �� �͸� Ŭ����ó�� �۵��ϴ� ������ �����ϸ� ���ϴ�.
		MyFunction f = new MyFunction() {
			public int max(int a, int b) {
				return (a+b);
			}
		};
		
		int big = f.max(0, 0);	// �͸� ��ü�� �޼��� ȣ��
		
		MyFunction fLam = (int a, int b) -> {
			return (a > b ? a : b);
		};
		
		// �͸� ��ü�� ���ٽ����� ��ü�� ������ ������ ���ٽĵ� �����δ� �͸� ��ü�̰�, MyFunction �������̽��� ������ �͸�
		// ��ü�� 
		
		
		
		
		
	}
	
	
	
}
