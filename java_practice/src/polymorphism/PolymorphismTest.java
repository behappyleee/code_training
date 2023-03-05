package polymorphism;

public class PolymorphismTest {
	
	// 다형성 (Polymorphism)
	// 조상클래스 타입의 참조 변수로 자손클래스의 인스턴스를 참조할 수 있도록 함
	// 생성된 인스턴스를 다루기 위하여 인스턴스의 타입과 일치하는 타입의 참조변수를 사용하였지만 
	// 조상 클래스 타입의 참조 변수로 자손 클래스의 인스턴스를 참조하는 것 도 가능 
	
	public static void main(String[] args) {
		
		// Caption Tv 를 2개를 생성
		// 참조 변수 c 와 t 가 생성 된 인스턴스를 하나씩 참조하도록 함
		CaptionTv c = new CaptionTv();
		Tv t = new CaptionTv();
		
		// 참조변수 c 로는 CaptionTv 의 모든 멤버가 접근이 가능하지만
		// 참조변수 t 로는 CaptionTv 의 모든 멤버가 접근이 불가능하다.
		
		// 참조변수 t 로는 CaptionTv 중 상속받은 Tv 에 데이터에 관하여서만 접근이 가능하다.
		// t.text / t.caption() 이 접근이 불가능 하다.
		
		// 두 개다 같은 타입의 참조 변수 이지만 참조 변수의 타입에 따라 사용할 수 있는 멤버의 갯수가 달라진다.
		
		// 아래처럼 자손 타입의 클래스로 참조변수로 조상타입의 인스턴스를 생성하는 것은 불가능 하다.
		// 실제 인스턴스인 Tv 의 멤버 갯수보가 참조변수 ct 가 사용할 수 있는 멤버 갯수가 더 많아서 이다.
		// CaptionTv ct = new Tv();
		// 참조변수가 사용할 수 있는 멤버의 갯수는 인스턴스의 멤버 갯수보다 같거나 작아야 한다.
		
		// 조상타입의 참조변수로 자손타입의 인스턴스를 참조 할 수 있다.
		// 반대로 자손 타입의 참조변수로 조상타입의 인스턴스를 참조할 수 없다.
		
		// 자손 타입 -> 조상 타입 (Up -> Down) : 형변환 생략 가능
		// 조상 타입 -> 자손 타입 (Down -> Up) : 형변환 생략 불가
		
		FireEngine f;
		Ambulance a;
		
		// Car 클래스는 FireEngine / Ambulance 클래스의 조상 임
		// Err 발생
		// 상속 관계가 아닌 이상 형변환이 불가능 !!!!
		// f = (Ambulance)a;
		// a = (FireEngine)f;
		
		// 형 변환은 참조변수의 타입을 변환 하는 것이지 인스턴스를 변환 하는 것이 아니기 때문에 참조변수의 형 변환은
		// 인스턴스에 아무런 영향도 미치지 않음
		// 단치 참조 변수의 형 변환을 통하여서 참조하고 있는 인스턴스에서 사용할 수 있는 멤버의 갯수를 조절하는 것 뿐임
		
		Car car = null;
		FireEngine fe = new FireEngine();
		FireEngine fe2 = null;
		
		car = fe;	// car = (Car)fe 에서 형 변환은 생략이 됨 업 캐스탱
		fe2 = (FireEngine)car;	// 형 변환을 생략 불가 다운 캐스팅
		
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
