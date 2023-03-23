package lambda;


// �ϳ��� �޼��尡 ���� �� �������̽��� �����Ͽ� ���ٽ��� �ٷ�� ���� ������ �ڹ��� ��Ģ���� ����� �����鼭�� �ڿ�������
// �׷��� �������̽��� ���� ���ٽ��� �ٷ��� ���� �Ǿ����� ���ٽ��� �ٷ�� ���� �������̽��� �Լ��� �������̽���� �θ�
@FunctionalInterface
interface MyFunctionInterface {
	void run();	// public abstract void run();
}

public class LambdaMethodTest {
	
	static void execute(MyFunctionInterface mfi) {
		mfi.run();
	}
	
	static MyFunctionInterface getMyFunction() {
		MyFunctionInterface mf = () -> System.out.println("getMyFunction mf run()");
		return mf;
	}
	
	
	public static void main(String[] args) {
		// ���ٽ����� MyFunctionInterface �� run �� ����
		MyFunctionInterface mf1 = () ->  System.out.println("Test Mf1 Run !");
		
		MyFunctionInterface mf2 = () -> new MyFunctionInterface() {
			@Override
			
			public void run() {	// public �� �ݵ�� �ٿ��� ��
				System.out.println("tEST Mf2 Run !");
			}
		};
		
		MyFunctionInterface mf3 = getMyFunction();
		
		mf1.run();
		mf2.run();
		mf3.run();
		
		execute(mf1);
		execute(() -> System.out.println("Direct Function !!!"));
	
	}
	
}
