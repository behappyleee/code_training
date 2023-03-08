package thread;

public class ThreadTest {
	
	// Thread (쓰레드)
	// 프로세스는 간단히 실행 중인 프로그램임, 프로그램을 실행 시 OS 로부터 실행에 필요한 자원 (메모리)를 할당 받음
	// 프로세스는 프로그램을 수행하는 데 필요한 데이터와 메모리 등의 자원 그리고 쓰레드로 구성 되어 있음
	// 현재 우리가 사용하고 있는 윈도우나 유닉스를 포함한 대부분의 OS 는 멀티태스킹을 지원 하여 여러 개의 프로세스 동시 실행이 가능
	
	// CPU 의 코어가 한 번에 단 하나의 작업만 수행이 가능하므로 실제로 동시에 처리 되는 작업의 갯수는 코어의 갯수와 일치
	
	// 멀티 쓰레드의 장점
	// 1. CPU 의 사용률을 향상
	// 2. 자원을 보다 효츌적으로 사용
	// 3. 사용자에 대한 응답성 증가
	// 4. 작업이 분리되어 코드가 간결해짐
	
	// 멀티 쓰레딩의 장점만 있는 것은 아님 멀티 쓰레드 프로세스는 동기화와 교착 상태 (deadlock) 와 같은 문제들을 고려해서 신중하게 프로그래밍을 해야함
	
	// Thread 구현 방법 
	// 1. Runnable 인터페이스를 구현
	
	public static void main(String[] args) {
		// Thread 를 상속한 Thread 실행 방법 run 방법
		Thread1 t1 = new Thread1();
		
		// Runnable 인터페이스를 구현한 Thread 실행 방법
		Runnable r = new Thread2();
		Thread t2 = new Thread(r);
		
		// start 라고 하여도 바로 실행 되는 것이 아닌 일단 실행 대기 상태에 있다가 자신 차례가 되면 그때 실해이 됨
		
		// 생성한 Thread 실행
		t1.start();
		t2.start();
		
		Thread_Ex_1 te1 = new Thread_Ex_1();
		
//		Runnable tr = new Thread_Ex_2();
//		Thread te2 = new Thread(tr);
		
		// Runnable 2 줄을 한줄로 나타낼 수 있음
		Thread te2 = new Thread(new Thread_Ex_2());
		
		te2.start();
		te1.start();
		
	}
	
}

class Thread_Ex_1 extends Thread {
	public void run() {
		for(int i=0; i<5; i++) {
			System.out.println("CUURENT THREAD : " + getName());
		}
	}
}

class Thread_Ex_2 implements Runnable {
	public void run() {
		for(int i=0; i<5; i++) {
			System.out.println("CURRENT THREAD : " +  Thread.currentThread().getName());
		}
	}
}



// Thread 클래스를 상속 받아 구현
class Thread1 extends Thread {
	public void run() {
		System.out.println("CUURENT THREAD : " + getName());
	}
}

// Thread Runnable 인터페이스를 implements 하여 Thread 를 구현
// Runnalbe 인터페이스는 오직 run 만 정의 되어 있는 인터페이스임
class Thread2 implements Runnable {
	public void run() {
		System.out.println("CURRENT THREAD : " +  Thread.currentThread().getName());
	}
}


