package lambda;

import java.util.Arrays;

public class LambdaTest {
	
	// 람다식
	// 자바가 등장 후 큰 변화들이 있는데 
	// 한번은 Generic 이고 다른 하나는 Lambda 이다.
	// 람다식의 도입으로 인하여 자바는 객체지향 언어인 동시에 함수형 언어가 되었다.
	
	
	public static void main(String[] args) {
		
		// 람다식은 간단히 말해서 메서드를 하나의 식(Expression) 으로 표현한 것이다.
		// 메서드를 람다식으로 표현하면 메서드의 이름과 반환값이 없어지므로 람다식을 익명 함수 (Anonymous Function) 이라고 한다.
		int[] arr = new int[5];
		Arrays.setAll(arr, (i) ->(int)(Math.random() * 5 ) + 1);
		
		//  (i) ->(int)(Math.random() * 5 ) + 1  이 부분이 바로 람다식이다.
		// 람다식은 메서드의 매개변수로 전달 되어지는 것이 가능하고 메서드의 결과로 반환도 가능하다.
		// 람다식으로 인하여 메서드를 변수처럼 다루는 것이 가능해진 것이다.
		// 람다식의 선언 된 매개변수의 타입은 추론이 가능한 경우에는 생략도 가능, 대부분의 경우에 생략이 가능
		
	}
	
	
	
	
	
}
