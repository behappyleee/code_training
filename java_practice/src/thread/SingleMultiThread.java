package thread;

public class SingleMultiThread {
	
	// 싱글 / 멀티 쓰레드
	// 두 개의 작업을 하나의 쓰레드와 두개 의 쓰레드로 처리 하는 경우
	
	// 하나의 쓰레드로 처리를 할 경우 한 작업을 마친 후 다른 작업을 시작 하지만 
	// 두 개의 쓰레드로 작업 하는 경우에는 짧은 시간 동안 2개의 쓰레드 t1, t2 가 번갈아 가면서 작업을 수행하여 동시에 두 작업이 처리 되는 것과 같이 느끼게 함
	
	// 가끔 싱글 쓰레드보다 멀티 쓰레드랑 작업 시간은 거의 같음 (쓰레드 스위칭 시간이 소비됨)
	
	public static void main(String[] args) {
		
		// 싱글 코어에서는 싱글 쓰레드로 처리하는 것이 더 효율 적임
		long startTime = System.currentTimeMillis();	
		for(int i=0; i<300; i++) {
			System.out.print("-");
		}
		System.out.println("\n Not Make Thread Take Time 1 : " + (System.currentTimeMillis() - startTime));
		for(int i=0; i<300; i++) {
			System.out.print("|");
		}
		System.out.println("\n Not Make Thread Take Time 2 : " + (System.currentTimeMillis() - startTime));
	
		
		// Thread 를 생성하여 해도 싱글 쓰레드와 큰 차이가 없을 멀티 쓰레드는 Thread 스위칭 시간이 존재함
		
		// 싱글 코어인 경우 멀티쓰레드라도 하나의 코어가 번갈아가면서 작업을 수행하는 것 이므로 두 작업이 절대 겹치지 않는다.
		// 그러나 멀티 코어에서는 멀티쓰레드로 두 작업을 수행하면 동시에 두 쓰레드가 수행 될 수 있으므로 겹치는 부분이 발생 한다.
		
		// 프로그램 실행 시 쓰레드 실행 이 다른것은 OS 스케줄러가 조절을 해주어서 그때그때 다르다.
		// 자바가 OS (플랫폼) 독립적 이라고 하지만 실제로는 OS 종속적인 부분이 몇가지 있는데 그 중 하나가 쓰레드이다.
		
		// 두 쓰레드가 서로 다른 자원을 사용하는 작업의 경우에는 싱글 쓰레드 프로세스 보다 멀티 쓰레드가 더 효율적이다.
		// 예를 들면 사용자 로부터 입력을 받는 작업 네트워크로 파일을 주고 받는 작업, 프린터로 파일을 출력하는 작업과 같이
		// 외부 기기와의 입출력을 필요로 하는 경우가 이에 해당한다.
		
		
		long t5StartTime = System.currentTimeMillis();
		Thread5 t5 = new Thread5();
		t5.start();
		System.out.println("t5 START TIME :  "  + (System.currentTimeMillis() - t5StartTime));
		
	}
	
}



class Thread5 extends Thread{
	public void run() {
		for(int i=0; i<300; i++) {
			System.out.print("-");
		}
	}
}



