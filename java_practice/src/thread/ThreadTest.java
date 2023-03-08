package thread;

public class ThreadTest {
	
	// Thread (������)
	// ���μ����� ������ ���� ���� ���α׷���, ���α׷��� ���� �� OS �κ��� ���࿡ �ʿ��� �ڿ� (�޸�)�� �Ҵ� ����
	// ���μ����� ���α׷��� �����ϴ� �� �ʿ��� �����Ϳ� �޸� ���� �ڿ� �׸��� ������� ���� �Ǿ� ����
	// ���� �츮�� ����ϰ� �ִ� �����쳪 ���н��� ������ ��κ��� OS �� ��Ƽ�½�ŷ�� ���� �Ͽ� ���� ���� ���μ��� ���� ������ ����
	
	// CPU �� �ھ �� ���� �� �ϳ��� �۾��� ������ �����ϹǷ� ������ ���ÿ� ó�� �Ǵ� �۾��� ������ �ھ��� ������ ��ġ
	
	// ��Ƽ �������� ����
	// 1. CPU �� ������ ���
	// 2. �ڿ��� ���� ȿ�������� ���
	// 3. ����ڿ� ���� ���伺 ����
	// 4. �۾��� �и��Ǿ� �ڵ尡 ��������
	
	// ��Ƽ �������� ������ �ִ� ���� �ƴ� ��Ƽ ������ ���μ����� ����ȭ�� ���� ���� (deadlock) �� ���� �������� ����ؼ� �����ϰ� ���α׷����� �ؾ���
	
	// Thread ���� ��� 
	// 1. Runnable �������̽��� ����
	
	public static void main(String[] args) {
		// Thread �� ����� Thread ���� ��� run ���
		Thread1 t1 = new Thread1();
		
		// Runnable �������̽��� ������ Thread ���� ���
		Runnable r = new Thread2();
		Thread t2 = new Thread(r);
		
		// start ��� �Ͽ��� �ٷ� ���� �Ǵ� ���� �ƴ� �ϴ� ���� ��� ���¿� �ִٰ� �ڽ� ���ʰ� �Ǹ� �׶� ������ ��
		
		// ������ Thread ����
		t1.start();
		t2.start();
		
		Thread_Ex_1 te1 = new Thread_Ex_1();
		
//		Runnable tr = new Thread_Ex_2();
//		Thread te2 = new Thread(tr);
		
		// Runnable 2 ���� ���ٷ� ��Ÿ�� �� ����
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



// Thread Ŭ������ ��� �޾� ����
class Thread1 extends Thread {
	public void run() {
		System.out.println("CUURENT THREAD : " + getName());
	}
}

// Thread Runnable �������̽��� implements �Ͽ� Thread �� ����
// Runnalbe �������̽��� ���� run �� ���� �Ǿ� �ִ� �������̽���
class Thread2 implements Runnable {
	public void run() {
		System.out.println("CURRENT THREAD : " +  Thread.currentThread().getName());
	}
}


