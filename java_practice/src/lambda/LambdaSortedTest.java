package lambda;

import java.util.stream.Stream;

public class LambdaSortedTest {
	
	public static void main(String[] args) {
		
		// sorted 
		// sorted() 는 지정된 Comparator 로 스트림을 정렬하는데, Comparator 대신 int 값을 반환하는 람다식을 사용 하는 것도 가능
		
		Stream<String> strStream = Stream.of("dd", "aaa", "CC", "cc", "b");
		// sorted 를 하여 CCaaabccdd 로 정렬
		strStream.sorted().forEach(System.out::print);	// sorted 를 이용하여 정렬 후 forEach 문 돌면서 출력
		
		
		
		
		
	}
	
}
