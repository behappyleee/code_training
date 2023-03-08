package thread;

public class ThreadPriority {
	
	// 쓰레드는 우선 순위 (Priority) 라는 속성 (멤버 변수)를 가지고 있음
	// 이 우선 순위에 값에 따라 쓰레드가 얻는 실행 시간이 달라진다.
	//  쓰레드가 수행하는 작업의 중요도에 따라 쓰레드가 우선 순위를 서로 다르게 지정하여 특정 쓰레드가 더 많은 작업시간을
	// 갖도록 할 수 있다.
	
	// ex) 파일 전송 기능이 있는 메신저의 경우 파일 다운로드를 처리하는 쓰레드보다 채팅내용을 전송하는 쓰레드의 우선순위가 더 높아야
	// 사용자가 채팅하는데 불편함이 없을 것이다. 대신 파일 다운로드 작업에 걸리는 시간은 더 길어질 것이다.
	
	public static void main(String[] args) {
		ThreadPriorityTest tt = new ThreadPriorityTest();
		ThreadPriorityTest2 tt2 = new ThreadPriorityTest2();
		
		tt2.setPriority(7);
		
		System.out.println("TT Prirority :  " + tt.getPriority());		// main 메서드에서 실행 하였으므로 기본 main 쓰레드 우선순위 5를 할당 받음
		System.out.println("TT2 Prirority :  " + tt2.getPriority());	// 7 로 세팅하여 tt 보다 priority 를 높게 설정 해 놓음
		
		// 쓰레드의 우선순위 같으면 같은 실행 시간이 주어지지만 우선 순위가 다르다면 우선 순위가 높은 tt2 에게 보다 더 많은 시간을 주고 더 빨리 끝낼 수 있게 해준다.
		// 쓰레드의 우선순위를 고려하여 구현을 하려면 어떤 OS 스케줄러에 종속적이므로 OS 에 따라 다를 수가 있다. 차라리 Thread 에 우선 순위를 부여하는 PrioriryQueue 에 저장해놓고 처리하는 것이 나을 수 있다.
		
		
		// tt2 가 중요도가 더 높게 설정을 하였으므로 작업이 더 빨리 끝남
		tt.start();
		tt2.start();
		
	}
}


class ThreadPriorityTest extends Thread{
	public void run() {
		for(int i=0; i<300; i++) {
			System.out.print("-");
			for(int x=0; x< 10000; x++);
		}
	}
}

class ThreadPriorityTest2 extends Thread{
	public void run() {
		for(int i=0; i<300; i++) {
			System.out.print("|");
			for(int x=0; x< 10000; x++);
		}
	}
}
