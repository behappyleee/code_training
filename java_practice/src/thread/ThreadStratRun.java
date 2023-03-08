package thread;

import java.rmi.ServerException;

public class ThreadStratRun {
	
	// start 와 run
	// 쓰레드를 실행 시킬 시 run() 이 아닌 start() 를 호출한다는 것에 대해 다소 의문이지만
	// run() 을 호출 하는 것은 쓰레드를 실행 시키는 것이 아닌 단순히 클래스에 선언 된 메서드를 호출하는 것임
	
	// 반면에 start() 는 새로운 쓰레드가 작업을 실행하는데 필요한 호출 스택 (call stack) 을 생성한 다음에 run 을 호출해서 생성된
	// 호출 스택에 run() 이 첫번쨰로 올라감
	
	// 스케줄러는 실행 대기 중인 쓰레드들을 우선 순위를 고려하여 실행 순서와 실행 시간을 결정하고 각 쓰레드들을
	// 작성 된 스케줄에 따라 자신의 순서가 되면 지정 된 시간 동안 작업을 수행
	
	public static void main(String[] args) {
		// 한 쓰레드가 예외가 발생하여 종료되어도 다른 쓰레드의 실행에는 영향을 미치지 않는다.
		Thread3 t = new Thread3();
		t.start();
		
		System.out.println(Thread.currentThread().getName());
		System.out.println(Thread.currentThread().getName());
		System.out.println(Thread.activeCount());
	
		// 아래는 쓰레드를 생성하여 실행 한 것이 아닌 그냥 run() 메서드가 호출 된 것 뿐임
		Thread4 t4 = new Thread4();
		t4.run();
		
		System.out.println(Thread.currentThread().getName());
		System.out.println(Thread.activeCount());
		
		
	}
	
}

class Thread4 extends Thread {
	public void run() {
		throwException();
	}
	public void throwException() {
		try {
			throw new Exception();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}



class Thread3 extends Thread{
	public void run() {
		throwException();
	}
	
	public void throwException() {
		try {
			throw new IllegalAccessError();
		} catch(IndexOutOfBoundsException ie) {
			ie.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("TRY - CATCH FINALLY !!");
		}
	}
}

