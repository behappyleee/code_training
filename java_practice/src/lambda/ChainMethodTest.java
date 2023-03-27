package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class ChainMethodTest {
	
	public static void main(String[] args) {
		
		// 메서드 참조
		// 람다식이 메서드 하나의 메서드만 호출하는 경우에는 메서드 참조 (Method Reference) 라는 방법으로 람다식을 간략히 할 수 있다.
		 
		// Function <String, Integer> f = (String s) -> Integer.parseInt(s);
		// Function <String, Integer> f = (String s) -> Integer::parseInt;	// 이처럼 메서드 참조로 간략하게 변환하여 사용할 수 도 있다.
		
		// 람다식을 메서드 참조로 변환하는 방법
		// (1) static 메서드 ==> ClassName.method (x) ==> ClassName::method
		// (2) 인스턴스 메서드 참조 ==> (obj, x) -> obj.method (x) ==> ClassName::method
		// (3) 특정 객체 인스턴스 메서드 참조 ==> (x) -> obj.method (x) ==> obj::method
		
		// 하나의 메서드만 호출하는 람다식은 클래스이름::(메서드이름 or 참조 변수)::메서드 이름으로 변경이 가능
		
		Supplier <ReferenceTest> s = () -> new ReferenceTest();	// 람다식
		Supplier <ReferenceTest> ss = ReferenceTest::new;		// 람다식을 메서드 참조로 변경을 함 !
		List<Integer> intList = new ArrayList<Integer>();
		
		
	}
	
}

class ReferenceTest {
	
}
