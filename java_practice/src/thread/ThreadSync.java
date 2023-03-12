package thread;

public class ThreadSync {
	
	// 쓰레드의 동기화
	// 싱글 쓰레드 프로세스의 경우 프로세스 내에서 단 하나의 쓰레드만 작업하기에 프로세스 자원을 가지고 별 문제가 되지 않지만
	// 멀티 쓰레드 프로세스의 경우 여러 쓰레드가 같은 프로세스 내의 자원을 공유해서 작업하기 때문에 서로의 작업에 영향을 주게 된다.
	
	// 만일 Thread A 가 작업하던 도중 Thread B 에게 제우권이 넘어 갔을 시 Thread A 가 작업 하던 공유 데이터를 Thread B 가 임의로 
	// 변경 하였을 시 원래 의도 하였던 것 과 다른 결과를 얻을 수 도 있다.
	
	// 이러한 상황을 방지하기 위하여 한 Thread 가 특정 작업을 끝 마치기 전까지 다른 쓰레드에 의해 방해 받지 않도록 할 수 있게 해주는 것이
	// 쓰레드 동기화 이다. (synchronized)
	
	public static void main(String[] args) {
		Thread tr1 = new Thread(new RunnableTest2());
		Thread tr2 = new Thread(new RunnableTest2());
		
		tr1.start();
		tr2.start();
		
	}
	
}

class Account {
	private int balance = 1000;
	public int getBalance() {
		return this.balance;
	}
	
	// 방법 1. 메서드 이름 앞에 synchronized 키워드를 붙여 준다.
	public synchronized void withdraw(int money) {
	// public void withdraw(int money) {
		// Thread 가 여러개 생성이 될 시 음수가 될 확률 이 있음 한 Thread 가 진행 시 다른 Thread 가 들어와 메서드를 진행 할 확률이 있음
		// 방법이 2가지가 있음
		
		// 방법 2. 코드 영역 직접 설정 하여 주기
		
		// 예제에서 어떤 것을 선택하든지 동일하므로 현재는 메서드 이름 앞에 synchronized 를 붙이는 것을 사용
		// synchronized(this) {
			if(this.balance >= money) {
				try {
					Thread.sleep(1000);
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
				this.balance -= money;
			} 
		// }	
	}
	
}

class RunnableTest2 implements Runnable {
	Account acc = new Account();
	public void run() {
		while(acc.getBalance() > 0) {
			int money = (int)((Math.random() * 3 )+ 1) * 100;
			System.out.println("Current Thread Name" + Thread.currentThread().getName() + " Current Money : " + money);
			acc.withdraw(money);
			System.out.println("Current Thread Name" + Thread.currentThread().getName() + " Current Balance : " + acc.getBalance());
		}
	}
}





