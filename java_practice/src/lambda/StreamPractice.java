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
		
		// �ڹٿ��� ��Ʈ���� ����Ϸ��� ������ ó�� ��Ʈ�� ��ü�� ����
		// �ڹ� �ڵ忡�� ���� ����ϴ� Collection ��ü���� Stream �� ����
		List<String> listTest = Arrays.asList("a", "b", "c", "d");
		Stream<String> stream = listTest.stream();	// Stream ��ü�� ����
		
		// �迭�� ��� ���� �޼��带 ���
		String[] strArr = new String[] {"a", "b", "c"};
		Stream<String> strStream = Arrays.stream(strArr);
		
		// Filter - filter �� �� �״�� ���ǿ� ���� ���͸��Ͽ� �÷����� ����
		List<String> list2 = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j");
		list2.stream().filter(s ->  
			s.equals("test")
		);
		
		// Map - Map �� ������ Stream �� �ִ� �����͸� �����Ͽ� ���ο� Stream �� ����� ���� ���� ���
		List<String> list3 = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j");
		list3.stream().map(s -> 
			s + "x "
		).forEach(System.out::print);
		
		System.out.println();
		// streamTestMake.forEach(System.out::print);
		
		Stream <String> newStreamTest = list3.stream();
		newStreamTest.forEach(System.out::print);
		
		// Stream �� �ٽ� List ��
		// List<String> streamToList = streamTestMake.collect(Collectors.toList());
		System.out.println();
		
		// Peek --> Peek �� Stream �� Ư�� ������ ��ġ�� �ʰ� �ܼ��ϰ� Ȯ���� ���� �Լ�
		IntStream.of(1, 2, 3, 5, 7, 12, 14 ,16).peek(System.out::print);
		
		List<String> lis4 = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j");
		Stream<String> stream4 = Stream.of("a", "b");
		
		IntStream strIntStream = IntStream.of(1, 7, 3, 5, 11, 14, 16);
		strIntStream.distinct();	// �ߺ� ���� ����
		
		
		LambdaEx le = new LambdaEx();
		le.hi(new Say() {
			public int something(int a, int b) {
				return a + b;
			};
		});
		
		// Lambda Interface �� �ش� �Լ� ������ ����� ����
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




