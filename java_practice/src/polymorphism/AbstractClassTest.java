package polymorphism;

public class AbstractClassTest {
	
	// 추상 클래스
	// 추상 클래스는 미완성 설계도임
	// 추상 클래스는 미완성 메서드를 포함하고 있다는 의미
	// 추상 클래스는 인스턴스를 생성할 수 없고 추상 클래스는 상속을 통하여서만 인스턴스 생성이 가능함
	
	// 추상 클래스는 class 앞에 abstract 만 붙여주면 됨
	
	// 상속이 자손 클래스를 만드는 데 조상 클래스를 사용 하는 것이라면 이와 반대로 추상화는 기존의 클래스의 공통 부분을
	// 뽑아내서 조상 클래스를 만드는 것
	// 추상화를 구체화의 반대로 의미하면 쉬움 (상속 계층도를 따라 올라갈수록 추상화가 심해지며 상속 계층도를 따라 내려갈수록 구체화가 심해짐)
	
	public static void main(String[] args) {
		
		
		
	}
	
}

class CDPlayer extends Player {
	
	// 만약 조상의 모든 추상 메서드를 구현 하지 않을 시 class 를 abstract 키워드를 붙여주어야 함
	void play(int currentPos) {
		// 조상의 추상 메서드를 구현 
	}
	
	void stop() {
		// 조상의 추상 메서드를 구현
	}
	
	int currentTrack;	// 현재 재생 중인 트랙
	
	void nextTrack() {
		currentTrack++;
	}
	
	void preTrack() {
		if(currentTrack > 1) {
			currentTrack--;
		}
	}
	
}


abstract class Player {
	boolean pause;
	int currentPos;
	
	Player() {
		pause = false;
		currentPos = 0;
	}
	
	// 만약 abstract 키워드 없이 빈 몸통만 선언 하여도 상관 없지만 abstract 키워드를 붙여줌으로써 자손 클래스에서 구현을 강제화
	abstract void play(int pos);
	abstract void stop();
	
	// 지정 된 위치 (pos) 에서 재생을 시작하는 기능이 수행 되도록 작성
	void play() {
		play(currentPos);
	}
	
	void pause() {
		if(pause) {			// pause 가 true 일 떄 (정지상태) 에서 pause 가 호출 되면 
			pause = false;	// pause 상태를 false 로 바꿈
			play(currentPos);	// 현재의 위치에서 play 를 함
		} else {			// pause 가 false 일 때 pause 호출 시
			pause = true;	// pause 상태를 true 로 바꿈
			stop();			// paly 를 멈춤
		}
	}
	
	
}



// 추상 클래스는 추상 메서드를 포함하고 있다는 것 이외에는 모든 것이 클래스와 동일
abstract class abClass {

	// 추상 메서드 - 선언부만 작성을 하고 구현부는 작성 하지 않은 채로 남겨 둔 것
	// 즉 설계만 해놓은 후 실제 수행 될 내용은 작성 되어 있지 않아 미완성 메서드임
	
	// 주석을 통하여 어떤 기능을 수행할 목적으로 작성하였는지 설명 필요
	// 만일 조상으로 부터 상속 받은 추상 메서드 중 하나라도 구현하지 않는다면 역시 추상 클래스로 지정해 주어야 함
	abstract void play();
	
	
}




