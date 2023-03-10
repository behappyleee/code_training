package thread;

public class ThreadScheduling {
	
	// Thread 사용이 어려운 이유는 동기화 (Synchronized) 와 스케줄링 (Scheduliing) 떄문이다
	// 효율적인 멀티 쓰레드 프로그램을 만들기 위하여서는 보다 졍교한 스케줄링을 통하여 프로세스에게 주어진 자원과 시간을 여러 쓰레드가
	// 낭비없이 잘 사용하도록 프로그래밍을 해야 한다.
	
	// sleep -> 일정 시간 동안 쓰레드를 멈추게 한다.
	
	// TODO 750 page Thread sleep  학습 하기 !!!!
	// sleep() 에 의해 일시정지 상태가 된 쓰레드는 지저된 시간이 다 되거나 interrupt() 가 호출 되면 (InterruptException)
	// 발생하여 잠에서 깨어나 실행 대기 상태가 된다.
	
	
	
}


class ThereadSleepTest {
	public void delay(long millis) {
		try {
			Thread.sleep(10000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
