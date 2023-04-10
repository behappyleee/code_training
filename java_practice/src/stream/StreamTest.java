package stream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class StreamTest {
	
	// I/O 란 Input 과 Output 의 약자로 간단히 입출력 이라고 함
	// 입출력은 컴퓨터 내부 또는 외부의 장치와 프로그램간의 데이터를 주고 받는 것
	
	// Stream (데이터를 운반 하는데 사용 되는 연결 통로)
	// 자바에서 입출력을 수행하려면 즉 어느 한 쪽에서 다른 쪽으로 데이터를 전달하려면, 두 대상을 연결을 하고
	// 데이터를 전송할 수 있는 무언가가 필요한데 이것을 Stream 이라고 한다.
	
	// Stream 은 단방향 통신만 가능하기에 하나의 스트림으로 입력과 출력을 동시에 사용하지 못함
	// 그래서 입출력을 동시에 수행 하기 위하여서는 InputStream / OutputStream 2 개의 Stream 이 필요
	// Stream 은 byte 단위로 데이터를 전송
	
	// 보조 스트림 - Stream 에 기능을 보완하기 위하여 보조 스트림이 제공됨
	// 보조 스트림은 실제 데이터를 주고 받는 스트림이 아니기 때문에 데이터를 입출력을 할 수 없지만 스트림의 기능을 향상 시키거나
	// 개로운 기능을 추가가 가능, 그래서 보조 스트림 만으로는 사용이 안돼고 스트림을 먼저 생성 한 후 보조스트림을 이용
	
	public static void main(String[] args) {
		try {
			// 코드 상으로는 보조 스트림은 BufferedInputStream 이 입력 기능을 수행하는 것 처럼 보이지만, 실제 입력 기능은 BufferedInputStream 과
			// 연결 된 FileInputStream 이 수행을 하고 보조 스트림은 BufferedInputStream 은 Buffer 만을 제공 한다. Buffer 를 사용한
			// 입출력과 사용 하지 않은 입출력 간의 성능차이는 상당하기 때문에 대부분의 경우에 버퍼를 이용하여 입출력을 사용한다.

			// 1. File 을 읽기 위하여 먼저 기반 FileInputStream 을 생성
			FileInputStream fis = new FileInputStream("test.txt");
			
			// 2. 기반 Stream 을 이용하여 보조 스트림을 생성
			BufferedInputStream bis = new BufferedInputStream(fis);
			
			// 3. 보조 스트림은 BufferedInputStream 으로 부터 데이터를 읽음
			bis.read();	

		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
}
