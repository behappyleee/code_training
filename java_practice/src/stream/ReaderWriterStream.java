package stream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class ReaderWriterStream {
	
	// 문자 기반 스트림 
	// InputStream -> Reader
	// OutputStream -> Writer
	
	// 바이트기반이라 하면 입출력의 단위가 1 byte 를 의미 한다. C 언어와 달리 Java 에서는 한 문자를 의미하는 char 형은 1 byte 가 아닌
	// 2 byte 로 이루어져 있다. 떄문에 byte 기반의 Stream 은 2 byte 문자를 처리하는데 어려움이 있었다
	// 이를 도와주는 것이 문자 기반 Stream 이다.
	
	public static void main(String[] args) {
		// 바이트 기반 Stream 		/   문자 기반 Stream
		// FileInputStream			/ 	FileReader
		// FileOutputStream 		/	FileOutputWriter
		// ByteArrayInputStream		/ 	CharArrayReader
		// ByteArrayOutputStream	/	CharArrayWriter
		// PipedInputStream			/	PipedReader
		// PipedOutputStream		/ 	PipedWriter
		// StringBufferInputStream	/	StringReader
		// StringBufferOutputStream	/ 	StringWriter
		
		// 프로그램이 종료될 때 사용하고 닫지 않은 스트림을 JVM 이 자동으로 닫아주기는 하지만 스트림을 사용하여
		// 모든 작업을 마치고 난 후에는 반드시 close() 를 호출하여 닫아준다.
		
		byte[] inSrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		byte[] outSrc = null;
		
		// Stream 종류마다 사용법은 비슷하니 다음 예제를 통하여 사용법을 익힘
		ByteArrayInputStream input = null;
		ByteArrayOutputStream output = null;
		
		input = new ByteArrayInputStream(inSrc);
		output = new ByteArrayOutputStream();
		
		int data = 0;
		
		// loop 를 돌면서 byte 를 읽음
		while((data = input.read()) != -1) {	// read() 를 호출한 반환값을 변수 data 에 저장 괄호 먼저 실행, data 에 저장 된 값이 -1 이랑 비겨
			output.write(data);		
		}
		
		outSrc = output.toByteArray();
		
		System.out.println("INPUT SRC : " + Arrays.toString(inSrc));
		System.out.println("OUTPUT SRC : " + Arrays.toString(outSrc));
		
	}
	
}
