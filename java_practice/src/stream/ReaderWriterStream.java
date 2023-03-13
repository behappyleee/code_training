package stream;

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
		
		// 문자기반 스트림의 이름은 Byte 기반 스트림의 이름에서 InputStream 은 Reader 로 OutputStream 은 Wrtier 로 이름만 바꾸어 주면 된다.
		
		// TODO 874 page (Byte 기반 Stream) 학습 하기 !!!!!
		
		
	}
	
}
