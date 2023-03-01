package object;

public class Tv {

	String color;
	boolean power;
	int channel;
	
	void power() {
		power = !power;
	};
	
	void channelUp() {
		channel++;
	};
	
	void channelDown() {
		channel--;
	};
	
	public static void main(String[] args) {
		// 클래스를 사용하려면 인스턴스를 생성을 하여야 함
		// 인스턴스는 참조변수를 통하여서만 다룰 수 있으며, 참조변수의 타입은 인스턴스의 타입과 일치하여야 함
		Tv tv = new Tv();
		tv.channel = 7;
		tv.channelDown();
		tv.power();
		
		// tv 에 저장 되어있는 참조변수 주소 값으로 tv 인스턴스에 접근하여 channel 속성 값을 가져옴
		System.out.println("현재 채널은 : " + tv.channel);
		
		// tv2 는 아직 인스턴스를 생성하기 전 이라 사용이 불가
		Tv tv2 ;
		
		Tv t3 = new Tv();
		Tv t4 = new Tv();
		
		// t3 는 참조변수 이므로 인스턴수 주소값을 저장을 하고 있음
		// t4 역시 가지고 있던 참조변수 값을 잃어버리므로 t4 가 참조하고있던 인스턴스는
		// 더 이상 사용할 수 없게 됨 (자신을 참조하고 있는 하나도 없는 인스턴스는 가비지 컬렉터에의해
		// 자동적으로 메모리에서 제거 됨
		
		// 참조변수에는 하나의 값 만이 저장 될 수 있음, 하나의 참조변수 값이 둘 이상의
		// 인스턴스를 가르키는 것은 불가능 함 
		t4 = t3;
		
		// 많은 수의 객체를 다루어야 할 때 객체 배열로 다루는 것이 편한 방법중 하나임
		Tv tv5, tv6, tv7;
		Tv [] tvArr = new Tv[3];
		tvArr[0] = new Tv();
		tvArr[1] = new Tv();
		tvArr[2] = new Tv();
		
	}
	
}


