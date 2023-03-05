package polymorphism;

public class ParserTest {
	
	public static void main(String[] args) {
		Parseable p = ParserManager.getParser("XML");
		p.parse("document.xml");
		Parseable p1 = ParserManager.getParser("HTML");
		p1.parse("document.html");
	
		// �������̽��� ����
		// 1. ���߽ð��� �����ų �� ����
		// 2. ǥ��ȭ�� ����
		// 3. ���� ���� ���� Ŭ�����鿡�� ���踦 �ξ� �� �� ����
		// 4. �������� ���α׷����� ����
		
	}
	
}

interface Parseable {
	// ���� �м� �۾��� ��
	public abstract void parse(String fileName);
}


class ParserManager {
	// Ÿ���� �������̽��� ��ȯ�ϴ� ���� �������̽��� ������ �ν��Ͻ��� ��ȯ�ϴ� ��
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

