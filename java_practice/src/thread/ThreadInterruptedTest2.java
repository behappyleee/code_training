package thread;

import javax.swing.JOptionPane;

public class ThreadInterruptedTest2 {
	
	public static void main(String[] args) {
		// suspend() - suspend() 에 의해 정지 된 쓰레드는 resume() 을 다시 호출해 주어야 다시 실행 대기 상태가 된다
		// stop() 은 호출 되는 즉시 쓰레드가 종료가 된다
		// suspend() resume() stop() 은 쓰레드를 제어하기가 가장 간단하지만 deadlock 발생할 가능성이 높아 사용이 권장 되지는 않는다.
		
		
		
		
		ThreadInt ti = new ThreadInt();
		ti.start();
		
		String input = JOptionPane.showInputDialog("Enter Any Number !");
		System.out.println("Input Number Is : " + input);
		
		ti.interrupt();	// interrupted 를 호출 시 true 로 됨 !
		System.out.println("IS CURRENT INTERRUPT THREAD : " + ti.isInterrupted());
		
	}
	
}


class ThreadInt extends Thread {
	public void run() {
		int i = 10;
		while(i!=0 && !isInterrupted()) {
			System.out.println(i--);
			for(long x=0; x<25550000000L; x++);	// 시간 지연 하기 !!
		}
		System.out.println("Count End !!");
	}
}





