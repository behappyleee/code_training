package exception;

public class ThrowTest {
	
	// �޼��� ���� ����
	void exceptionMethod() throws Exception, RuntimeException {
		// ������ ���� ���� ������ �޼��忡 ���� ������ ���� �ʱ⿡ ���� ���� ���α׷��� �ƴϰ��� � ������
		// ���ܰ� �߻� �� ���ɼ��� �ִ��� ����� �����ϱⰡ �������
		// ������ �ڹٿ����� ���� �߻� ���ɼ� �ִ� �޼������ ���ܸ� ������Ű�� �ִ� ���� �߰��� ���α׷� ����� ���� ����������
		
		
	}
	
	
	public static void main(String[] args) {
		try {
			// ������ ���� �߻� ��Ű��
			Exception e = new Exception("Exception !!!!");
			throw e;
			
		} catch(Exception ex) {
			System.out.println("Exception message : " + ex.getMessage());
			System.out.println("Exception Catch !!");
			ex.printStackTrace();
		}
		
		//�����Ϸ��� ���� ó���� Ȯ�� ���� �ʴ� RuntimeException Ŭ�������� unchecked ���� ��� �ϰ�
		// ���� ó���� Ȯ���ϴ� Exception Ŭ�������� checked ���ܶ�� �Ѵ�.
		
		
		System.out.println("Program End !");
	}
	
}
