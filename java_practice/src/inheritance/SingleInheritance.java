package inheritance;

public class SingleInheritance {
	
	// ���� ���
	// �ڹٴ� ���� ��ӿ� ������ �����ϰ� ���� ���� ��Ӹ� ��� �Ѵ�.
	// ���� ����� �� �� �θ𿡰Լ� ���� �޼��尡 ���� �� ������ ����� (�ν��Ͻ� �޼��� �� �� Ŭ���� �޼���� Ŭ���� ������ ������ ����)

	// Object Ŭ������ ��� Ŭ������ ������ ������ �� �� �ڵ����� �����Ϸ��� extends Object �� �ٿ��ش�.
	// ���� �ٸ� Ŭ������ ��� �޴´� �Ͽ��� ��� Ŭ���� ������ Object �̹Ƿ� ������� ������ �ᱹ���� Object �� �ֻ��� Ŭ���� �̴�.
	
	
	
}

class ObjectTest extends Object {
	
}

class TvTest {
	boolean power;
	int channel;
	
	void power() { power = !power; } 
	void channelUp() { channel++; }
	void channelDown() { channel--; }
	
}


class Vcr {
	boolean power;
	int counter = 0;
	
	void power() { power = !power;}
	void play() {}
	void stop() {}
	void rew() {}
	void ff() {}
}

class Tvcr {
	// VCR Ŭ������ �����Ͽ� ��� �� �� ���� ��� ���� ȿ���� ������ �� �ִ�.
	Vcr vcr = new Vcr();
	int counter = 0;
	
	void play() {
		vcr.play();
	}
	
	void stop() {
		vcr.stop();
	}
	
}



