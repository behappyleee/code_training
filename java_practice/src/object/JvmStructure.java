package object;

public class JvmStructure {
	
	// JVM의 내부 메모리 구조
	// JVM 은 메모리를 영역에 따라 여러 영역으로 나누어 관리
	// Method Area / Call Stack / Heap
	
	// 1. Method Area 메서드 영역
	// 프로그램 실행 중 어떤 클래스가 사용이 되면 JVM 은 해당 클래스 파일 (.class) 을 읽어서 분석하여
	// 클래스에 대한 정보를 이곳에 저장
	
	// 2. Heap
	// 인스턴스가 생성이 되는 공간, 프로그램 실행 중 생성되는 인스턴스는 모두 이 곳에 생성
	// 인스턴스 변수(instance variable) 들이 생성되는 공간
	
	// 3. Call Stack
	// 호출스택은 메서드의 작업에 필요한 메모리 공간을 제공, 메서드가 호출이 되면 호출스택에 호출 된 메서드를 위한 메모리가 할당
	// 이 메모리는 작업을 수행하는 동안 지역변수들과 연산의 중간결과 등을 저장하는데 사용, 메서드가 작업을 마치면 할당 되었던 메모리 
	// 공간은 반환이 됨
	
	
	public static void main(String[] args) {
		TestParam t = new TestParam();
		t.x = 7;
		// 바뀌지 않음
		System.out.println("BEFORE T : " + t.x);
		changeNum(t.x);
		System.out.println("AFTER T : " + t.x);
		
		// 매개변수는 값을 복사하여 전달을 하므로 주소값을 전달 시 원본 객체의 값이 바뀜
		changeObjectNum(t);
		System.out.println("CHANGE OBJECT TX NUM :  " + t.x);
	}
	
	public static void changeNum(int a) {
		a = 10;
		System.out.println("PARAM a : " + a);
	}
	
	public static void changeObjectNum(TestParam p) {
		p.x = 20;
		System.out.println("P.X : " + p.x);
	}
	
	
}


class TestParam {
	int x;
}