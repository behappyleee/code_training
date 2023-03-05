package polymorphism;

public class PolymorphismTest {
	
	// ������ (Polymorphism)
	// ����Ŭ���� Ÿ���� ���� ������ �ڼ�Ŭ������ �ν��Ͻ��� ������ �� �ֵ��� ��
	// ������ �ν��Ͻ��� �ٷ�� ���Ͽ� �ν��Ͻ��� Ÿ�԰� ��ġ�ϴ� Ÿ���� ���������� ����Ͽ����� 
	// ���� Ŭ���� Ÿ���� ���� ������ �ڼ� Ŭ������ �ν��Ͻ��� �����ϴ� �� �� ���� 
	
	public static void main(String[] args) {
		
		// Caption Tv �� 2���� ����
		// ���� ���� c �� t �� ���� �� �ν��Ͻ��� �ϳ��� �����ϵ��� ��
		CaptionTv c = new CaptionTv();
		Tv t = new CaptionTv();
		
		// �������� c �δ� CaptionTv �� ��� ����� ������ ����������
		// �������� t �δ� CaptionTv �� ��� ����� ������ �Ұ����ϴ�.
		
		// �������� t �δ� CaptionTv �� ��ӹ��� Tv �� �����Ϳ� ���Ͽ����� ������ �����ϴ�.
		// t.text / t.caption() �� ������ �Ұ��� �ϴ�.
		
		// �� ���� ���� Ÿ���� ���� ���� ������ ���� ������ Ÿ�Կ� ���� ����� �� �ִ� ����� ������ �޶�����.
		
		// �Ʒ�ó�� �ڼ� Ÿ���� Ŭ������ ���������� ����Ÿ���� �ν��Ͻ��� �����ϴ� ���� �Ұ��� �ϴ�.
		// ���� �ν��Ͻ��� Tv �� ��� �������� �������� ct �� ����� �� �ִ� ��� ������ �� ���Ƽ� �̴�.
		// CaptionTv ct = new Tv();
		// ���������� ����� �� �ִ� ����� ������ �ν��Ͻ��� ��� �������� ���ų� �۾ƾ� �Ѵ�.
		
		// ����Ÿ���� ���������� �ڼ�Ÿ���� �ν��Ͻ��� ���� �� �� �ִ�.
		// �ݴ�� �ڼ� Ÿ���� ���������� ����Ÿ���� �ν��Ͻ��� ������ �� ����.
		
		// �ڼ� Ÿ�� -> ���� Ÿ�� (Up -> Down) : ����ȯ ���� ����
		// ���� Ÿ�� -> �ڼ� Ÿ�� (Down -> Up) : ����ȯ ���� �Ұ�
		
		FireEngine f;
		Ambulance a;
		
		// Car Ŭ������ FireEngine / Ambulance Ŭ������ ���� ��
		// Err �߻�
		// ��� ���谡 �ƴ� �̻� ����ȯ�� �Ұ��� !!!!
		// f = (Ambulance)a;
		// a = (FireEngine)f;
		
		// �� ��ȯ�� ���������� Ÿ���� ��ȯ �ϴ� ������ �ν��Ͻ��� ��ȯ �ϴ� ���� �ƴϱ� ������ ���������� �� ��ȯ��
		// �ν��Ͻ��� �ƹ��� ���⵵ ��ġ�� ����
		// ��ġ ���� ������ �� ��ȯ�� ���Ͽ��� �����ϰ� �ִ� �ν��Ͻ����� ����� �� �ִ� ����� ������ �����ϴ� �� ����
		
		Car car = null;
		FireEngine fe = new FireEngine();
		FireEngine fe2 = null;
		
		car = fe;	// car = (Car)fe ���� �� ��ȯ�� ������ �� �� ĳ����
		fe2 = (FireEngine)car;	// �� ��ȯ�� ���� �Ұ� �ٿ� ĳ����
		
		Car c3 = new FireEngine();
		c3.drive();
		c3.stop();
		
		
	}
}

class Car {
	String color;
	int door;
	void drive() {
		System.out.println("Drive Brr ~~ !!");
	}
	void stop() {
		System.out.println("Drive Stop ~~ !!");
	}
}

class FireEngine extends Car {
	void water() {
		System.out.println("FireEngineCar Water ~~ !!");
	}
}

class Ambulance extends Car {
	void siren() {
		System.out.println("Ambulance Siren ~~ !!");
	}
}


class Tv {
	boolean power;
	int channel;
	
	void power() { channel++;};
	void channelUp() {++channel;}
	void channelDown() {--channel;}
}

class CaptionTv extends Tv {
	String text;
	void caption() {}
}
