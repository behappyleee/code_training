package object;

public class ClassVariableInit {
	
	// TODO
	// �ڹ��� ���� 310 ������ ��Ӻ��� �н�
	
	static int count = 0;
	int serialNo;
	
	// �ν��Ͻ��� ���� �� �� ���� �ν��Ͻ��� ���� �ν��Ͻ� ������ ����
	{
		++count;
		serialNo = count;
	}
	
	ClassVariableInit() {
		
	}
	
	public static void main(String[] args) {
		ClassVariableInit cv = new ClassVariableInit();
		ClassVariableInit cv1 = new ClassVariableInit();
		ClassVariableInit cv2 = new ClassVariableInit();
		ClassVariableInit cv3 = new ClassVariableInit();
		
		System.out.println("�ν��Ͻ��� ���� : " + cv2.serialNo);
		System.out.println("�ν��Ͻ��� ���� : " + cv3.serialNo);
		
		System.out.println("������ �ν��Ͻ��� �� ���� : " + ClassVariableInit.count);
		
		Document dc = new Document();
		Document dc1 = new Document("���� �׽�Ʈ");
		
	}
}

class Document {
	static int count = 0;
	String name;
	
	public Document() {
		this("������� " + (++count));
	}
	
	public Document(String name) {
		this.name = name;
		System.out.println("���� " + name + " �� ���� �Ǿ����ϴ�.");
	}
	
}

