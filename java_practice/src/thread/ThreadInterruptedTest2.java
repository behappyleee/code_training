package thread;

import javax.swing.JOptionPane;

public class ThreadInterruptedTest2 {
	
	public static void main(String[] args) {
		// suspend() - suspend() �� ���� ���� �� ������� resume() �� �ٽ� ȣ���� �־�� �ٽ� ���� ��� ���°� �ȴ�
		// stop() �� ȣ�� �Ǵ� ��� �����尡 ���ᰡ �ȴ�
		// suspend() resume() stop() �� �����带 �����ϱⰡ ���� ���������� deadlock �߻��� ���ɼ��� ���� ����� ���� ������ �ʴ´�.
		
		
		
		
		ThreadInt ti = new ThreadInt();
		ti.start();
		
		String input = JOptionPane.showInputDialog("Enter Any Number !");
		System.out.println("Input Number Is : " + input);
		
		ti.interrupt();	// interrupted �� ȣ�� �� true �� �� !
		System.out.println("IS CURRENT INTERRUPT THREAD : " + ti.isInterrupted());
		
	}
	
}


class ThreadInt extends Thread {
	public void run() {
		int i = 10;
		while(i!=0 && !isInterrupted()) {
			System.out.println(i--);
			for(long x=0; x<25550000000L; x++);	// �ð� ���� �ϱ� !!
		}
		System.out.println("Count End !!");
	}
}





