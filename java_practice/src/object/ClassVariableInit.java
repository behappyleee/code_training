package object;

public class ClassVariableInit {
	
	// TODO
	// 자바의 정석 310 페이지 상속부터 학습
	
	static int count = 0;
	int serialNo;
	
	// 인스턴스가 생성 될 때 마다 인스턴스의 수를 인스턴스 변수에 저장
	{
		++count;
		serialNo = count;
	}
	
	ClassVariableInit() {
		
	}
	
	public static void main(String[] args) {
		ClassVariableInit cv = new ClassVariableInit();
		ClassVariableInit cv1 = new ClassVariableInit();
		ClassVariableInit cv2 = new ClassVariableInit();
		ClassVariableInit cv3 = new ClassVariableInit();
		
		System.out.println("인스턴스의 갯수 : " + cv2.serialNo);
		System.out.println("인스턴스의 갯수 : " + cv3.serialNo);
		
		System.out.println("생성된 인스턴스의 총 갯수 : " + ClassVariableInit.count);
		
		Document dc = new Document();
		Document dc1 = new Document("문서 테스트");
		
	}
}

class Document {
	static int count = 0;
	String name;
	
	public Document() {
		this("제목없음 " + (++count));
	}
	
	public Document(String name) {
		this.name = name;
		System.out.println("문서 " + name + " 이 생성 되었습니다.");
	}
	
}

