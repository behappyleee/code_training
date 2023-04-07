package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class LambdaTestClass {
	
	public static void main(String[] args) {
		
		Stream<String[]> strArrStream = Stream.of(
				new String[] {"abc", "def", "jkl"},
				new String[] {"ABC", "GHI" ,"JKL"}
			);
		
		ArrayList<String> arrList = new ArrayList<String>(Arrays.asList("a", "b", "c", "d", "e", "f")); 
		
		// ArrayList<String> afterFilterStream = arrList.stream().filter((s) -> {return s;});	
			
		// .forEach(System.out::println);
		
		
		
	}
	
}
