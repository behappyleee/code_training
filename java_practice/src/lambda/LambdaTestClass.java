package lambda;

import java.util.stream.Stream;

public class LambdaTestClass {
	
	
	public static void main(String[] args) {
		
		Stream<String[]> strArrStream = Stream.of(
				new String[] {"abc", "def", "jkl"},
				new String[] {"ABC", "GHI" ,"JKL"}
			);
		
		Stream<Stream<String>> strStreamTest = strArrStream.flatMap(Arrays::stream);
		
		
		
	}
	
}
