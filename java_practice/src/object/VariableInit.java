package object;

public class VariableInit {
	
	// ���� �ʱ�ȭ
	// ������ ���� �� ó������ ���� ���� �ϴ� ���� ������ �ʱ�ȭ ��� ��
	// ��������� �ʱ�ȭ ���� �ʾƵ� �ڵ������� ������ �ڷ����� �´� �⺻������ �ʱ�ȭ�� �̷�� ������
	// ���������� ��� �ϱ� ���� �ݵ�� �ʱ�ȭ�� �Ͽ��� ��
	
	public static void main(String[] args) {
		// ��������� ������ �ʱ�ȭ ���� �ʾƵ� Ÿ�Կ� �°� �⺻�� ������ ������ ���������� �ȵ�
		Init i = new Init();
		System.out.println("INIT A : " + i.a);
		System.out.println("INIT B : " + i.b);
		System.out.println("INIT C : " + i.c);
	}
	
	public static void testMethod (int c) {
		// ������ ���� �߻� �������� ���ÿ��� �ݵ�� �ʱ�ȭ�� ���־�� �� !!!
		int j;
		// c = j;
	}
	
	
}

class InitWays {
	// ���� �ʱ�ȭ ���
	// 1. �����
	int a =3;
	
	// 302 ������ ����� �ʱ�ȭ ���� ����
	// ����� �ʱ�ȭ�� �����ϰ� ��������� ���� ������ �ʱ�ȭ�� �ʿ� �ÿ��� �ʱ�ȭ �� or �����ڸ� ���
	// 2. �ʱ�ȭ �� (initialization block) 
	
	// Ŭ���� �ʱ�ȭ �� - Ŭ���������� ������ �ʱ�ȭ�� ���
	// �ν��Ͻ� �ʱ�ȭ �� - �ν��Ͻ� ������ ������ �ʱ�ȭ�� ���
	
	
}


class Init {
	int a;
	String b;
	char c;
}