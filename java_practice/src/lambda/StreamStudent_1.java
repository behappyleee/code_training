package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamStudent_1 {
	
	public static void main(String[] args) {
		
		Stream<Student> studentStream = Stream.of(
				new Student("이자바", 3, 300),
				new Student("김자바", 1, 200),
				new Student("안자바", 2, 100),
				new Student("박자바", 2, 150),
				new Student("소자바", 1, 200),
				new Student("나자바", 3, 290),
				new Student("감자바", 3, 180)
				);
		
		studentStream.sorted(Comparator.comparing(Student::getBan)		// 반변 정렬
				.thenComparing(Comparator.naturalOrder()))				// 기본 정렬
				.forEach(System.out::println);
		
		File[] fileArr = {new File("Ex1.java"), new File("Ex2.java"), new File("Ex3.java"), new File("Ex4.java")
						, new File("Ex5.java"), new File("Ex6.java"), new File("Test.txt")
		};
		
		Stream<File> fileStream = Stream.of(fileArr);
		
		Stream<String> fileNameStream = fileStream.map(File::getFileName);	
		fileNameStream.forEach(System.out::println);	// 모든 파일 이름을 출력
		
		fileStream = Stream.of(fileArr);	// 스트림을 다시 생성 Stream 을 다시 생성 하지 않으면 ERROR 발생
		
		// map() --> 스트림의 요소에 저장 된 값 중에 원하는 필드만 뽑아내거나 특정 형태로 변환해야 할 떄가 있다.
		fileStream.map(File::getFileName)
				.filter(s -> s.indexOf('.') != -1)
				.map(s -> s.substring(s.indexOf('.')+1))	// 확장자만 추출
				.map(String::toUpperCase)	// 모두 대문자로 변환
				.distinct()
				.forEach(System.out::println);	// 모두 출력
		
		System.out.println();
		
		// peek() --> 연산과 연산 사이에 올바르게 처리되었는 지 확인하고 싶다면 peek() 을 사용
		
		
		int[] numTest = {1,2,5,8,3,6,9,11,14,17};
		ArrayList<Integer> numList = new ArrayList<>();
		numList.add(3);
		numList.add(7);
		numList.add(5);
		numList.add(9);
		numList.add(13);
		numList.add(15);
		
		// Stream<ArrayList<Integer>> intStream = Stream.of(numList);
		
		IntStream intStream = IntStream.range(3, 23);
		intStream.forEach(System.out::println);
		
		intStream = IntStream.range(3, 23);
		intStream.map(s -> s + 5);
		
		System.out.println("INT STREAM TEST :  " + intStream);
		
		Stream<TestClassLambda> testLambda = Stream.of(new TestClassLambda(3), new TestClassLambda(5)
				, new TestClassLambda(7), new TestClassLambda(9), new TestClassLambda(1)
				, new TestClassLambda(2), new TestClassLambda(6), new TestClassLambda(12)
				);
		
		
		
	
	}
	
}

class TestClassLambda {
	
	int testNum;
	
	TestClassLambda(int testNum) {
		this.testNum = testNum;
	}
	
	public void setTestNum(int testNum) {
		this.testNum = testNum;
	}
	
	public int getTestNum() {
		return this.testNum;
	}
}



class File {
	
	String fileName;
	
	File(String fileName) {
		this.fileName = fileName;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public String getFileName() {
		return this.fileName;
	}
}


class Student implements Comparable<Student>{
	String name;
	int ban;
	int totalScore;
	
	Student(String name, int ban, int totalScore) {
		this.name = name;
		this.ban = ban;
		this.totalScore = totalScore;
	}
	
	public String toString() {
		return String.format("[%s, $d, $d]", name, ban, totalScore);
	}
	
	String getName() {
		return name;
	}
	
	int getBan() {
		return ban;
	}
	
	int getTotalScore() {
		return totalScore;
	}
	
	// 총점 내림 차순을 기본 정렬로 함
	public int compareTo(Student s) {
		return s.totalScore - this.totalScore;
	}
	
}
