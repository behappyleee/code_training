package inheritance;

public class CompositeTest {
	
	// ����� ���Ͽ� Ŭ���� ���� ���踦 �ξ��ְ� Ŭ������ ���� �ϴ� ����� �־�����
	// ��� �̿ܿ��� Ŭ������ �� ��� �ϴ� ����� Ŭ�������� ���� (Composite) ���踦 �ξ��ִ� ����
	
	/// Ŭ���� ���� ���� ���踦 �ξ� �ִ� ���� �� Ŭ������ ��������� �ٸ� Ŭ���� Ÿ���� ����������
	// �����ϴ� ���� �� ��
	
	// ���� Ŭ������ ���� �� �޼����� ���� �޼��带 �ڼ� Ŭ������ �����ϴ� ���� �������̵��̶�� ��
	
	
	
}

// ������ has
// extends �� is �� ����� ������

class Circle {
	// int x;
	// int y;
	// ���� (Composite) �� �̿�� ������ ���� ����� ������
	Point c = new Point();	
	int z;
}

class Point {
	int x;
	int y;
	
}

// �ƿ� extends �� �Ͽ� ��뵵 ������
class CircleExtends extends Point {
	
	int r;
}

