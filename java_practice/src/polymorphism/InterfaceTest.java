package polymorphism;

public class InterfaceTest {
	
	// 인터페이스 (Interface)
	// 인터페이스는 일종의 추상 클래스 인터페이스는 추상 클래스 처럼 추상 메서드를 갖지만 추상 클래스 보다 추상화 정도가 높아서
	// 추상 클래스와 달리 몸통을 갖춘 일반 메서드 또는 멤버변수를 구성원으로 가질 수 없다
	
	// 인터페이스는 오직 추상 메서드와 상수만을 멤버로 가질 수 있음
	// 추상 클래스를 부분적으로만 미완성 된 미완성 설계도라고 한다면 
	// 인터페이스는 구현 된 것은 아무것도 없고 밑그림만 그려져 있는 기본 설계도임
	// 인터페이스는 추상 클래스처럼 완성 되지 않은 불완전한 것이기 때문에 그 자체만으로 사용 되기 보다는
	// 다른 클래스를 작성하는데 도움 줄 목적으로 작성이 됨
	
	// 인터페이스를 이용한 다형성
	// 다형성은 자손 클래스의 인스턴스를 조상타입의 참조변수로 참조하는 것
	
	
	
	
	
	public static void main(String[] args) {
		InterTest.stop();
		// 인터페이스의 모든 멤버 변수는 final 이기에 변경이 불가 상수 취급을 함
		// InterTest.a = "10";
		
	}
}

class InterfaceClassTest implements InterTest{
	// 인터페이스는 접근 제어자를 생략하였더라도 구현 시에는 반드시 public 붙여주어야 함
	// override 시에는 자손클래스에서 작성 된 메서드보다는 접근제어자가 더 넓은 범위를 붙어주어야 함
	public void play() {
		
	}
	public String getKind() {
		return null;
	}
}

// 인터페이스를 implements 하였지만 인터페이스의 모든 메서드를 구현할 것이 아니면 abstract 키워드를 붙어주어야 함
abstract class InterImplTest implements InterTest {
	// abstract 클래스는 인터페이스의 모든 메서드를 구현하지 않아도 에러가 발생하지 않음
	public void play() {
		
	}
}

// 인터페이스도 추상 클래스 처럼 그 자체로는 인스터스를 생성할 수 없음
// 인터페이스도 자신에 정의 된 추상 메서드의 몸통을 만들어조는 클래스를 작성하여야 함
interface InterTest {
	// 인터페이스의 모든 메서드는 추상 메서드여야 하지만 JDK 1.8 버전 부터 인터페이스 static 메서드와 default 메서드의 추가를 허용하는 방향으로 변경됨
	// 인터페이스는 모든 멤버에 예외없이 적용 되는 사항이여서 제어자 생략도 많이 함
	// 인터페이스에 멤버 변수는 public static final 이여야 하며 생략이 가능
	// 모든 메서드는 public abstract 이여야 하며 이를 생략 가능 (단 static 메서드와 default 메서드는 예외)
	String a = "3";		// 실제로는 public static final a = "3" 임
	final String b = "7"; // 실제로는 public static final b = "7" 임
	
	abstract void play();
	String getKind();	// 실제로는 public abstract String getKind() {} 임
	
	public static void stop() {
		
	}
	private void test() {
		
	}
	default void move() {
		
	}
	
}