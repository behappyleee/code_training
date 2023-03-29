package lambda;

import java.util.stream.IntStream;

public class LambdaChainTest {
	
	public static void main(String[] args) {
		
		// ���ٽ� iterate() / generate()
		// Stream Ŭ������ iterate() �� generate() �� ���ٽ��� �Ű������� �޾Ƽ� �� ���ٽĿ� ���� ���Ǵ� ������
		// ��ҷ� �ϴ� ���� ��Ʈ���� ������
		IntStream intStream = IntStream.rangeClosed(1, 10);		// 1 ���� 10 ���� ��Ҹ� ���� Stream �� ����
		intStream.skip(3).limit(5).forEach(System.out::print);	// 3���� �ǳ� �ٰ� 4���� 5�� ��� ������ ���	
		
		System.out.println();
		
		// Stream�� ��� �ɷ����� - filter / distinct 
		IntStream intStream2 = IntStream.rangeClosed(1, 10);		// 1 ���� 10 ���� ��Ҹ� ���� Stream �� ����
		intStream2.distinct().forEach(System.out::print);			// distinct �� ������ �ſ� ����
		
		System.out.println();
		
		IntStream intStream3 = IntStream.rangeClosed(1, 10);			// 1 ���� 10 ���� ��Ҹ� ���� Stream �� ����
		intStream3.filter(i -> i%2 == 0).forEach(System.out::print);	// 2�� ¦���� ������
		
		
		System.out.println();
		
		IntStream intStream4 = IntStream.rangeClosed(1, 10);					// 1 ���� 10 ���� ��Ҹ� ���� Stream �� ����
		intStream4.filter(i->i%2==0).filter(i -> i>2).forEach(System.out::print);	// filter �� ������ ��ø�Ͽ� ��뵵 ����
	
	}
	
}
