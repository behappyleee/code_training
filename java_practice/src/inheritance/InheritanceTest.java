package inheritance;

public class InheritanceTest {
	
	// 상속 (Inheritance)
	// 상속이란 기존의 클래스를 재사용하여 새로운 클래스를 작성하는 것
	// 상속을 통하여 클래스를 작성하다 보면 적은 양의 코드로 새로운 클래스 작성도 가능
	// 자바에서 상속을 구현하는 방법은 extends 만 사용하면 됨
	// 코드의 중복이 많아 지면 유지보수가 어려워지고 일관성을 유지하기 어려움
	
	// 전체 프로그램을 구성하는 클래스 들을 면밀히 설계 분석하여
	// 클래스 간의 상속 관계를 적절히 맺어주는 것이 객체지향 프로그램의 중요한 부분임
	
	// 조상 클래스만 변경 하여도 모든 자손 클래스에 손자 클래스까지 영향을 미치므로 주의 필요
	
	// 자손 클래스의 인스턴스를 생성할 시 조상 클래스의 멤버와 자손 클래스의 멤버가 합쳐진 하나의 인스턴스로 생성이 됨
	
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
	boolean caption; // 캡션 상태 on / off
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


// 자손 클래스는 조상 클래스의 모든 멤버를 상속 받으므로 항상 조상 클래스보다 같거나 많은 멤버들 가짐
class Parents {
	
}
// Child 클래스는  Parents 클래스의 모든 멤버들을 포함함
class Child extends Parents {
	
}