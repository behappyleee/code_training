package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class ChainMethodTest {
	
	public static void main(String[] args) {
		
		// �޼��� ����
		// ���ٽ��� �޼��� �ϳ��� �޼��常 ȣ���ϴ� ��쿡�� �޼��� ���� (Method Reference) ��� ������� ���ٽ��� ������ �� �� �ִ�.
		 
		// Function <String, Integer> f = (String s) -> Integer.parseInt(s);
		// Function <String, Integer> f = (String s) -> Integer::parseInt;	// ��ó�� �޼��� ������ �����ϰ� ��ȯ�Ͽ� ����� �� �� �ִ�.
		
		// ���ٽ��� �޼��� ������ ��ȯ�ϴ� ���
		// (1) static �޼��� ==> ClassName.method (x) ==> ClassName::method
		// (2) �ν��Ͻ� �޼��� ���� ==> (obj, x) -> obj.method (x) ==> ClassName::method
		// (3) Ư�� ��ü �ν��Ͻ� �޼��� ���� ==> (x) -> obj.method (x) ==> obj::method
		
		// �ϳ��� �޼��常 ȣ���ϴ� ���ٽ��� Ŭ�����̸�::(�޼����̸� or ���� ����)::�޼��� �̸����� ������ ����
		
		Supplier <ReferenceTest> s = () -> new ReferenceTest();	// ���ٽ�
		Supplier <ReferenceTest> ss = ReferenceTest::new;		// ���ٽ��� �޼��� ������ ������ �� !
		List<Integer> intList = new ArrayList<Integer>();
		
		
	}
	
}

class ReferenceTest {
	
}
