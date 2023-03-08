package thread;

public class ThreadPriority {
	
	// ������� �켱 ���� (Priority) ��� �Ӽ� (��� ����)�� ������ ����
	// �� �켱 ������ ���� ���� �����尡 ��� ���� �ð��� �޶�����.
	//  �����尡 �����ϴ� �۾��� �߿䵵�� ���� �����尡 �켱 ������ ���� �ٸ��� �����Ͽ� Ư�� �����尡 �� ���� �۾��ð���
	// ������ �� �� �ִ�.
	
	// ex) ���� ���� ����� �ִ� �޽����� ��� ���� �ٿ�ε带 ó���ϴ� �����庸�� ä�ó����� �����ϴ� �������� �켱������ �� ���ƾ�
	// ����ڰ� ä���ϴµ� �������� ���� ���̴�. ��� ���� �ٿ�ε� �۾��� �ɸ��� �ð��� �� ����� ���̴�.
	
	public static void main(String[] args) {
		ThreadPriorityTest tt = new ThreadPriorityTest();
		ThreadPriorityTest2 tt2 = new ThreadPriorityTest2();
		
		tt2.setPriority(7);
		
		System.out.println("TT Prirority :  " + tt.getPriority());		// main �޼��忡�� ���� �Ͽ����Ƿ� �⺻ main ������ �켱���� 5�� �Ҵ� ����
		System.out.println("TT2 Prirority :  " + tt2.getPriority());	// 7 �� �����Ͽ� tt ���� priority �� ���� ���� �� ����
		
		// �������� �켱���� ������ ���� ���� �ð��� �־������� �켱 ������ �ٸ��ٸ� �켱 ������ ���� tt2 ���� ���� �� ���� �ð��� �ְ� �� ���� ���� �� �ְ� ���ش�.
		// �������� �켱������ ����Ͽ� ������ �Ϸ��� � OS �����ٷ��� �������̹Ƿ� OS �� ���� �ٸ� ���� �ִ�. ���� Thread �� �켱 ������ �ο��ϴ� PrioriryQueue �� �����س��� ó���ϴ� ���� ���� �� �ִ�.
		
		
		// tt2 �� �߿䵵�� �� ���� ������ �Ͽ����Ƿ� �۾��� �� ���� ����
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
