package enums;

public class EnumTest {
	
	// 열거형 (Enums)
	// 열거형은 서로 관련 된 상수를 편리하게 선언하기 위한 것 여러 상수를 정의하여 사용시 편리
	// JDK 1.5 버전 부터 추가 되었음
	
	enum Kind {CLOVER, HEART, DIAMOND, SPADE}	// 열거형 Kind 를 정의
	enum Value {TWO, THREE, FOUR}
		
	final Kind kind = Kind.CLOVER;
	final Value value = Value.TWO;
	
	// 열거형 정의 방법
	// enum 열거형 이름 {상수이름1, 상수이름2}
	
	public static void main(String[] args) {
		
	}
}

enum Direction {
	EAST, SOUTH, WEST, NORTH
}

enum DirectionTest {
	EAST_TEST(1), SOUTH_TEST(5), WEST_TEST(-1), NORTH_TEST(10);
	
	// 열거형 상수의 값을 임의로 넣고 싶을시 불 연속적일 떄
	
	// 정수를 저장할 필드를 추가
	private final int value;
	
	// 열거형의 생성자는 외부에서 생성 불가이고 내부에서만 생성자 생성이 가능하다.
	DirectionTest(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
}


class Unit {
	int x,y ;
	Direction dir = Direction.NORTH;
	// 열거형의 모든 value 를 배열로 가져온다.
	Direction[] dArr = Direction.values();
	
	void init() {
		// 열거형 상수간 비교에는 == 를 이용하여 비교가 가능, < > 와 같은 비교 연산자는 사용이 불가
		dir = Direction.EAST;
	}
	
	void move() {
		// case 문에서 주의할 점은 열거형의 이름은 명시하지 않고 상수의 이름만 적어주어야 한다.
		switch(dir) {
			case EAST: x++;
			break;
			case WEST: x--;
			break;
		}
	}
	
}

