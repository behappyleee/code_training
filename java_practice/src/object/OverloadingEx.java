package object;

public class OverloadingEx {
	
	// Overloading 
	// �����ε��� �ڹٿ����� �̸��� ������
	// �Ű����� ���� �� Ÿ���� �ٸ��� ���� �̸��� �������� ���� ������
	
	// �����ε� ����
	// 1. �޼��� �̸��� ���ƾ� ��
	// 2. �Ű������� ���� �Ǵ� Ÿ���� �޶�� ��
	
	// ���� !
	// ��ȯ return Ÿ���� �����ε��� �ƹ��� ���⵵ ����
	
	// �����ε��� ������ ���� ����� ������ ���� �ٸ� �̸��� ������ �� �� �̸� ����� ��ư� �޼��带 ����ϴ� �ʿ����� �δ��� ��
	// ������ �����ε��� ���ϸ� �޼��� �̸��� ����ϱ⵵ ���� ������ ���ɼ��� ���� ���� �� ���� 
	
	public int test() {
		return 1;
	}
	public int test(int a) {
		return 2;
	}
	
	// varargs(�������� variable arguments) �� overloading
	public void somethid(String  a, Object ...test) {
		
	}
	// �������ڴ� �׻� �Ű����� ���� �� �� ������ ��°�� ������ �ʿ�
//	public void somethid( Object ...test, String  a) {
//		
//	}
	
	public static void print(String ...test) {
		// �Ű����� ��� �� ������ ���� ����� ���� !!
		System.out.println("TEST : " + test[0]);
		System.out.println("TEST : " + test[1]);
		System.out.println("test : " + test.toString());
	}
	public static  void print(Object ...test) {
		
	}
	
	public static void main(String[] args) {
		// �������� �̱⿡ ������ ������� �Ű������� ���� �� ���� 
		print("10", "2");
		// �������� �� �ÿ� �迭 ���� ����
		print(new String[]{"3", "7"});
	
		
	
	}
}
