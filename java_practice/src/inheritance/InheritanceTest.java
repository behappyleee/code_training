package inheritance;

public class InheritanceTest {
	
	// ��� (Inheritance)
	// ����̶� ������ Ŭ������ �����Ͽ� ���ο� Ŭ������ �ۼ��ϴ� ��
	// ����� ���Ͽ� Ŭ������ �ۼ��ϴ� ���� ���� ���� �ڵ�� ���ο� Ŭ���� �ۼ��� ����
	// �ڹٿ��� ����� �����ϴ� ����� extends �� ����ϸ� ��
	// �ڵ��� �ߺ��� ���� ���� ���������� ��������� �ϰ����� �����ϱ� �����
	
	// ��ü ���α׷��� �����ϴ� Ŭ���� ���� ����� ���� �м��Ͽ�
	// Ŭ���� ���� ��� ���踦 ������ �ξ��ִ� ���� ��ü���� ���α׷��� �߿��� �κ���
	
	// ���� Ŭ������ ���� �Ͽ��� ��� �ڼ� Ŭ������ ���� Ŭ�������� ������ ��ġ�Ƿ� ���� �ʿ�
	
	// �ڼ� Ŭ������ �ν��Ͻ��� ������ �� ���� Ŭ������ ����� �ڼ� Ŭ������ ����� ������ �ϳ��� �ν��Ͻ��� ������ ��
	
	public static void main(String[] args) {
		CaptionTv ctv = new CaptionTv();
		ctv.channel = 10;		
		ctv.channelUp();
		System.out.println("CTV CHANNEL :  " + ctv.channel);

		ctv.displayCaption("Hello, World");
		ctv.caption = true;
		ctv.displayCaption("Hello, World");
	}
	
}

class Tv {
	boolean power;
	int channel;
	
	void power() { 
		power = !power;
	}
	
	void channelUp() {  
		++channel;
	}
	
	void channelDown() {
		--channel;
	}
}

class CaptionTv extends Tv {
	boolean caption; // ĸ�� ���� on / off
	void displayCaption(String text) {
		if(caption) {
			System.out.println(text);
		}
	}
}

class CaptionTvTest {
	public static void main(String[] args) {
		CaptionTv ctv = new CaptionTv();
		ctv.channel = 10;		
		ctv.channelUp();
		System.out.println("CTV CHANNEL :  " + ctv.channel);

		ctv.displayCaption("Hello, World");
		ctv.caption = true;
		ctv.displayCaption("Hello, World");
		
	}
}


// �ڼ� Ŭ������ ���� Ŭ������ ��� ����� ��� �����Ƿ� �׻� ���� Ŭ�������� ���ų� ���� ����� ����
class Parents {
	
}
// Child Ŭ������  Parents Ŭ������ ��� ������� ������
class Child extends Parents {
	
}