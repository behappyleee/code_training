package lambda;

import java.util.stream.IntStream;

public class LambdaChainTest {
	
	public static void main(String[] args) {
		
		// 람다식 iterate() / generate()
		// Stream 클래스의 iterate() 와 generate() 는 람다식을 매개변수로 받아서 이 람다식에 의해 계산되는 값들을
		// 요소로 하는 무한 스트림을 생성함
		IntStream intStream = IntStream.rangeClosed(1, 10);		// 1 부터 10 까지 요소를 가진 Stream 을 생성
		intStream.skip(3).limit(5).forEach(System.out::print);	// 3까지 건너 뛰고 4부터 5개 요소 까지만 출력	
		
		System.out.println();
		
		// Stream의 요소 걸러내기 - filter / distinct 
		IntStream intStream2 = IntStream.rangeClosed(1, 10);		// 1 부터 10 까지 요소를 가진 Stream 을 생성
		intStream2.distinct().forEach(System.out::print);			// distinct 의 사용법은 매우 간단
		
		System.out.println();
		
		IntStream intStream3 = IntStream.rangeClosed(1, 10);			// 1 부터 10 까지 요소를 가진 Stream 을 생성
		intStream3.filter(i -> i%2 == 0).forEach(System.out::print);	// 2의 짝수만 가져옴
		
		
		System.out.println();
		
		IntStream intStream4 = IntStream.rangeClosed(1, 10);					// 1 부터 10 까지 요소를 가진 Stream 을 생성
		intStream4.filter(i->i%2==0).filter(i -> i>2).forEach(System.out::print);	// filter 를 여러번 중첩하여 사용도 가능
	
	}
	
}
