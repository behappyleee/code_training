package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPractice {
	
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>(Arrays.asList("a", "b", "c", "d"));
		list.forEach(System.out::println);
		
		// 자바에서 스트림을 사용하려면 무조건 처음 스트림 객체를 생성
		// 자바 코드에서 자주 사용하는 Collection 객체들은 Stream 을 지원
		List<String> listTest = Arrays.asList("a", "b", "c", "d");
		Stream<String> stream = listTest.stream();	// Stream 객체를 생성
		
		// 배열의 경우 정적 메서드를 사용
		String[] strArr = new String[] {"a", "b", "c"};
		Stream<String> strStream = Arrays.stream(strArr);
		
		// Filter - filter 는 말 그대로 조건에 맞춰 필터링하여 컬렉션을 만들어냄
		List<String> list2 = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j");
		list2.stream().filter(s ->  
			s.equals("test")
		);
		
		// Map - Map 은 기존에 Stream 에 있던 데이터를 변경하여 새로운 Stream 을 만들어 내는 연산 방식
		List<String> list3 = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j");
		list3.stream().map(s -> 
			s + "x "
		).forEach(System.out::print);
		
		System.out.println();
		// streamTestMake.forEach(System.out::print);
		
		Stream <String> newStreamTest = list3.stream();
		newStreamTest.forEach(System.out::print);
		
		// Stream 을 다시 List 로
		// List<String> streamToList = streamTestMake.collect(Collectors.toList());
		System.out.println();
		
		// Peek --> Peek 은 Stream 에 특정 영향을 미치지 않고 단순하게 확인을 위한 함수
		IntStream.of(1, 2, 3, 5, 7, 12, 14 ,16).peek(System.out::print);
		
		List<String> lis4 = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j");
		Stream<String> stream4 = Stream.of("a", "b");
		
		IntStream strIntStream = IntStream.of(1, 7, 3, 5, 11, 14, 16);
		strIntStream.distinct();	// 중복 값을 제거
		
		
		LambdaEx le = new LambdaEx();
		le.hi(new Say() {
			public int something(int a, int b) {
				return a + b;
			};
		});
		
		// Lambda Interface 라 해당 함수 형식을 사용이 가능
		le.hi((s, b) -> {
			return (s + b);
		});
		
		le.hi(null);
		
		
		
	}
	
}

@FunctionalInterface
interface Say {
	int something(int a, int b);
}

class LambdaEx {
	public void hi(Say say) {
		if(say == null) {
			System.out.println("ITS SAY NULL RETURN !");
			return;
		}
		say.something(3, 5);
		System.out.println("LambdaEx Hi Test !");
	}
}




