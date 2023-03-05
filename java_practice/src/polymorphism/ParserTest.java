package polymorphism;

public class ParserTest {
	
	public static void main(String[] args) {
		Parseable p = ParserManager.getParser("XML");
		p.parse("document.xml");
		Parseable p1 = ParserManager.getParser("HTML");
		p1.parse("document.html");
	
		// 인터페이스의 장점
		// 1. 개발시간을 단축시킬 수 있음
		// 2. 표준화가 가능
		// 3. 서로 관계 없는 클래스들에게 관계를 맺어 줄 수 있음
		// 4. 독립적인 프로그래밍이 가능
		
	}
	
}

interface Parseable {
	// 구문 분석 작업을 함
	public abstract void parse(String fileName);
}


class ParserManager {
	// 타입이 인터페이스를 반환하는 것은 인터페이스를 구현한 인스턴스를 반환하는 것
	public static Parseable getParser(String type) {
		if(type.equals("XML")) {
			return new XMLParser();
		} else {
			Parseable p = new HTMLParser();
			return p;
		}
	}
}

class XMLParser implements Parseable {
	public void parse(String fileName) {
		
	}
}

class HTMLParser implements Parseable {
	public void parse(String fileName) {
		
	}
}

