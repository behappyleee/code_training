package ch_02;

import java.util.Arrays;

public class Test {
	
	public static void main(String[] args) {
		SingleTest t1 = SingleTest.getInstance();
		SingleTest t2 = SingleTest.getInstance();
		t1.getHello("CH");
		t1.getHello("MJ");
		t2.getHello("AS");
		t2.getHello("Hello !!");
		
		System.out.println("3 +4  : " + 3  + 4);	
		System.out.println("(3 + 4 ) : " + (3+4));
		args = new String[2];
		TestMain testMain = new TestMain();
		args[0] = "Hello Method !";
		args[1] = "Hello SecondArgs !";
		testMain.main(args);
	}
}

class SingleTest {
	
	private static SingleTest singleTest;
	private SingleTest() {}
	private String setString;
	
	public static SingleTest getInstance() {
		if(singleTest == null) {
			singleTest = new SingleTest();
			return singleTest;
		}
		return singleTest;
	}
	
	public String getHello(String a) {
		System.out.println(a + " Hello");
		return a + "Hello";
	}
	
	
	
	
}