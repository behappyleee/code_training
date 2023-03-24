package lambda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CollectionFramework {
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0; i<10; i++) {
			list.add(i);
		}
			
		list.forEach((i) -> {
			System.out.print(i+ " ,");
		});
		
		System.out.println();
		
		list.removeIf(x -> x % 2 == 0 || x % 3 == 0);
		System.out.println(list);
		
		list.replaceAll((i) -> i * 10);	// list 의 모든 요소에 10 을 곱함
		System.out.println(list);
		
		Map<String, String> map = new HashMap<>();
		map.put("1", "1");
		map.put("2", "2");
		map.put("3", "3");
		map.put("4", "4");
		
		// Map 의 모든 요소를 {k ,v} 로 출력
		map.forEach((k ,v) -> {
			System.out.println("{" + k + ", " + v + "}");
		});
		System.out.println();
		
	}
	
}
