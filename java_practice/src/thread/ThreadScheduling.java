package thread;

public class ThreadScheduling {
	
	// Thread 사용이 어려운 이유는 동기화 (Synchronized) 와 스케줄링 (Scheduliing) 떄문이다
	// 효율적인 멀티 쓰레드 프로그램을 만들기 위하여서는 보다 졍교한 스케줄링을 통하여 프로세스에게 주어진 자원과 시간을 여러 쓰레드가
	// 낭비없이 잘 사용하도록 프로그래밍을 해야 한다.
	
	// sleep -> 일정 시간 동안 쓰레드를 멈추게 한다.
	// sleep() 에 의해 일시정지 상태가 된 쓰레드는 지저된 시간이 다 되거나 interrupt() 가 호출 되면 (InterruptException)
	// 발생하여 잠에서 깨어나 실행 대기 상태가 된다.
	
	public static void main(String[] args) {
		ThreadInterruptTest ti = new ThreadInterruptTest();
		ti.start();
		for(int i=0; i<50000; i++) {
			// 시간 끌기 !
		}
		// Thread 를 종료 시킴 !!
		ti.interrupt();
	}
	
}

// Thread 강제로 끝내기
// 진행 중인 쓰레드의 작업이 끝나기 전에 취소 시켜야 할 때가 있음 ex) 큰 파일을 다운 시 너무 오래 걸리는 작업이라 든지. ..
// 하지만 단지 멈추라고 요청하는 것 일뿐 쓰레드를 강제로 종료시키지는 못함
class ThreadInterruptTest extends Thread {
	public void run() {
		while(!interrupted()) {
			System.out.println("Thread Keep Ruuning !!");
		}
	}
}


class ThereadSleepTest {
	public void delay(long millis) {
		try {
			Thread.sleep(10000);
			Thread.sleep(1, 500000);	// Thread 를 0.0015 초 동안 멈추게 해줌
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
