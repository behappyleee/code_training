package lambda;

import java.util.stream.Stream;

public class LambdaSortedTest {
	
	public static void main(String[] args) {
		
		// sorted 
		// sorted() �� ������ Comparator �� ��Ʈ���� �����ϴµ�, Comparator ��� int ���� ��ȯ�ϴ� ���ٽ��� ��� �ϴ� �͵� ����
		
		Stream<String> strStream = Stream.of("dd", "aaa", "CC", "cc", "b");
		// sorted �� �Ͽ� CCaaabccdd �� ����
		strStream.sorted().forEach(System.out::print);	// sorted �� �̿��Ͽ� ���� �� forEach �� ���鼭 ���
		
		
		
		
		
	}
	
}
