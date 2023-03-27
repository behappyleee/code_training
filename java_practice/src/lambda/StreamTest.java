package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
	
	public static void main(String[] args) {
		
		// 지금까지 우리는 많은 데이터를 다룰 때 컬렉션이나 배열에 데이터를 담고 원하는 결과를 얻기 위해 for 문과 Iterator 를 이용하여
		// 코드를 작성하였었다. 이러한 방식은 코드가 너무 길고 재사용성도 떨어진다.
		
		// Stream 은 데이터를 추상화하였고 데이터를 자주 사용 되는 메서드들을 정의해 놓았다.
		// 데이터를 추상화 하였다는 것은 데이터 소스가 무엇이던 간에 같은 방식으로 다룰 수 있게 되었다는 것과 코드의 재사용성이 높아진 것이다.
		
		// 스트림을 이용하면 배열이나 컬렉션 뿐만 아니라 파일에 저장 된 데이터도 모두 같은 방식으로 다룰 수 있다.
		
		String[] strArr = {"aaa", "ddd", "ccc"};		
		List<String> strList = Arrays.asList(strArr);	
		
		Stream <String> strStream1 = strList.stream();		// 스트림을 생성
		Stream <String> strStream2 = Arrays.stream(strArr);	// 스트림을 생성
		
		// 데이터 소스의 데이터를 읽어서 정렬 후 화면에 출력
		strStream1.sorted().forEach(System.out::print);	// 각 데이터를 읽어서 화면에 출력
		System.out.println();
		strStream2.sorted().forEach(System.out::print);	
		
		// Stream 은 Iterator 처럼 일회용이다. Iterator 컬렉션 처럼 컬렉션의 요소를 모두 읽고나면 다시 사용할 수 없는 것처럼 Stream 도
		// 다시 사용하기 위하여서는 Stream 을 다시 생성하여야 한다.
		
		// 정렬 된 결과를 다시 새로운 List 에 담아 서 반환 한다
		// List<String> sortedList = strStream2.sorted().collect(Collectors.toList());
		
		
		// Stream 은 데이터 소스를 변경 하지 않는다
		// Stream 은 일회용이다 다시 재사용이 안된다.
		// strStream1.sorted().forEach(System.out::println);
		
		// Stream 이 제공하는 다양한 연산을 이용하여 복잡한 작업들을 간단히 처리할 수 있다.
		// 마치 데이터 베이스에 SELECT 문으로 질의 하는 것과 같다.
		
		// 스트림이 제공하는 연산은 중간 연산과 최종 연산으로 분류가 되는데 중간 연산은 연산 결과를 스트림으로 반환하기 때문에
		// 중간 연산을 연속해서 연결할 수 있다.
		// 반면에 최종 연산은 스트림의 요소를 모두 소모하면서 연산을 수행하므로 단 한번만 연산이 가능하다.
		
		// 중간 연산 - 연산 결과가 스트림인 연산, 스트림에 연속해서 중간 연산할 수 있음
		// 최종 연산 - 연산 결과가 스트림이 아닌 연산, 스트림의 요소를 소모하므로 단 한번만 사용이 가능
		String[] streamArr = {"dd", "aaa", "CC", "cc", "b"};
		Stream <String> stream = Stream.of(strArr);		// 문자열 배열이 소스인 스트림
		
		Stream<String> filteredStream = stream.filter(null);	// 걸러 내기 (중간 연산)
		Stream<String> distinctedStream = stream.distinct();	// 중복 제거 (중간 연산)
		Stream<String> sortedStream = stream.sorted();	// 정렬 (중간 연산)
		Stream<String> limitedStream = stream.limit(5);	// 스트림 자르기 (중간 연산)
		long total = stream.count();		// 요수 갯수 새기 (최종 연산)
		
		// 지연 된 연산
		// 스트림 연산에서 한가지 중요한 점은 최종 연산이 수행 되기 전 까지는 중간 연산이 수행 되지 않는 다는 것이다.
		// stream 에 대하여 distinct() 나 sort() 같은 중간 연산을 호출해도 즉각적인 연산이 수행 되는 것은 아니라는 것이다.
		
		// 병렬 Stream
		// 스트림으로 데이터를 다룰 떄에 장점 중 하나가 바로 병렬 처리가 쉽다는 것이다.
		// parallel() 를 호출 시 병렬로 연산이 가능하다
		// 반대로 병렬을 원하지 않을 시 sequential() 을 호출 하면 된다.
		
		int sum = stream.parallel()
						.mapToInt(s -> s.length())
						.sum();
		
		// TODO 스트림 만들기 부터 학습 하기 !!!
		
		
		
	}
}
