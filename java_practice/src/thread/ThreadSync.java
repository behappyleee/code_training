package thread;

public class ThreadSync {
	
	// �������� ����ȭ
	// �̱� ������ ���μ����� ��� ���μ��� ������ �� �ϳ��� �����常 �۾��ϱ⿡ ���μ��� �ڿ��� ������ �� ������ ���� ������
	// ��Ƽ ������ ���μ����� ��� ���� �����尡 ���� ���μ��� ���� �ڿ��� �����ؼ� �۾��ϱ� ������ ������ �۾��� ������ �ְ� �ȴ�.
	
	// ���� Thread A �� �۾��ϴ� ���� Thread B ���� ������� �Ѿ� ���� �� Thread A �� �۾� �ϴ� ���� �����͸� Thread B �� ���Ƿ� 
	// ���� �Ͽ��� �� ���� �ǵ� �Ͽ��� �� �� �ٸ� ����� ���� �� �� �ִ�.
	
	// �̷��� ��Ȳ�� �����ϱ� ���Ͽ� �� Thread �� Ư�� �۾��� �� ��ġ�� ������ �ٸ� �����忡 ���� ���� ���� �ʵ��� �� �� �ְ� ���ִ� ����
	// ������ ����ȭ �̴�. (synchronized)
	
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
	
	// ��� 1. �޼��� �̸� �տ� synchronized Ű���带 �ٿ� �ش�.
	public synchronized void withdraw(int money) {
	// public void withdraw(int money) {
		// Thread �� ������ ������ �� �� ������ �� Ȯ�� �� ���� �� Thread �� ���� �� �ٸ� Thread �� ���� �޼��带 ���� �� Ȯ���� ����
		// ����� 2������ ����
		
		// ��� 2. �ڵ� ���� ���� ���� �Ͽ� �ֱ�
		
		// �������� � ���� �����ϵ��� �����ϹǷ� ����� �޼��� �̸� �տ� synchronized �� ���̴� ���� ���
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





