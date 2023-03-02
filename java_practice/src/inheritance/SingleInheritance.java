package inheritance;

public class SingleInheritance {
	
	// 단일 상속
	// 자바는 다중 상속에 장점을 포기하고 오직 단일 상속만 허용 한다.
	// 다중 상속을 할 시 부모에게서 같은 메서드가 존재 시 구별이 어려움 (인스턴스 메서드 일 시 클래스 메서드는 클래스 명으로 구분이 가능)

	// Object 클래스는 모든 클래스에 조상일 컴파일 할 시 자동으로 컴파일러가 extends Object 를 붙여준다.
	// 만일 다른 클래스를 상속 받는다 하여도 모든 클래스 상위가 Object 이므로 따라따라 가면은 결국에는 Object 가 최상위 클래스 이다.
	
	
	
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
	// VCR 클래스를 포함하여 사용 할 시 다중 상속 같은 효과를 가져올 수 있다.
	Vcr vcr = new Vcr();
	int counter = 0;
	
	void play() {
		vcr.play();
	}
	
	void stop() {
		vcr.stop();
	}
	
}



