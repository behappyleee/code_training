package generic;

public class GenericWildCard {
	
	// 와일드 카드
	// <? extends T> 와일드 카드의 상한 제한 T의 자손들만 타입 지정이 가능
	// <? super T> 와일드 카드의 하한 제한, T의 조상들만 타입 지정이 가능
	// <?> 제한 없음 모든 타입 지정이 가능 <? extends Object> 와 동일
	
	
	
}

class Juiec {
	
}

class Juicer {
	// Juicer 클래스는 제네릭 클래스도 아니고 제네릭이라 하뎌여도 static 메서드에는 타입 매개변수 T를 매개변수에 사용할 수 없으므로
	// 아예 제네릭스를 사용하지 않던가 아예 제네릭에 타입을 타입이 아닌 클래스로 지정 하여야 한다.
//	static Juice makeJuice(FruitBox<Fruit> box) {
//		
//	}
	// 만약 만든다면 이렇게 모든 클래스를 일일이 지정을 해줄 수 밖에 없다 (하지만 컴파일 에러 발생 제네릭 타입이 다른것만 으로는 오버로딩이 안됨) 
//	static Juice makeJuice(FruitBox<Apple> box) {
//	
//}
	
	// 이러한 상황 일 떄는 와일드 카드 ? 를 사용한다
	
	
	
}