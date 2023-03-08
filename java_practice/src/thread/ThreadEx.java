package thread;

import javax.swing.JOptionPane;

public class ThreadEx {
	
	public static void main(String[] args) {
		
		// 하나의 쓰레드로 작업을 하기에 사용자가 값을 입력하기 전까지는 밑에 for 문이 실행 되지 않는다.
//		String input = JOptionPane.showInputDialog("아무 값 이나 입력하세요. ");
//		System.out.println("Input Number is :  " + input);
//		for(int i = 10; i > 0; i--) {
//			System.out.println(i);
//			try {
//				System.out.println(Thread.currentThread().getName());
//				System.out.println(Thread.currentThread());
//				Thread.sleep(100);
//			} catch(Exception e) {
//				e.printStackTrace();
//			}
//		}
		
		// 위에 예문은 싱글 쓰레드로 작동하기에 input에 아무값을 입력하지 않을 시 밑에 for 문이 실행 되지가 않았다.
		
		MultiTest mt = new MultiTest();	// 새로운 쓰레드를 만들어 실행
		mt.start();
		
		// 다 끝나고 실행 하는 것이 아닌 쓰레드를 새로 만들었으므로 새로운 쓰레드에서 실행이 된다.
		String input = JOptionPane.showInputDialog("아무 값 이나 입력하세요. ");
		System.out.println("Input Number is :  " + input);
		
	}
	
}

class MultiTest extends Thread {
	public void run() {
		for(int i=10; i>0; i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}

