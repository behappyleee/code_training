package com.study.test;

public class GarbageCollectorTest {

    // 참조자 or Pointer
    // 를 이용하여 접근하여 사용을 하거나
    // c++ 은 개발자가 직접 관리를 하나 자바 에서는 new 만 사용을 함

    // 자바에서는 객체를 직접 지우지 않고 Garbage Collector 가 해 줌 (개발자가 직접 못하도록 함)

    // c 나 c++ 은 Native 코드임 CPU 나 OS 에 직접적으로 의존을 하게 됨
    // Native 언어는 OS 랑 CPU 만 잘 알면 되지만

    // Java 는 JVM 이 하나 더 붙어 있음
    // JVM Heap dump 분석 ... ? 장애 대응 능력 있는 지 ..... ??

    // GC 를 논하는 것이 관리자 Infra 관리자 일 수 있음
    // 서비스 지연 -> 장애 -> 대응
    // 구글 도움이 될 수 도 있는 Java Memory Leak 읽어보기 -> 우하한 기술 블로그
    // JVM Heap dump 를 분석한다고 해서

    // JVM 안에도 Thread 가 있음

    // c 나 c++ 은 Native Thread 가 있음

    // Full GC 가 있음
    // Scouter 까지 알고 있어야 함
    // 기본적으로 웹 어플리케이션은 3TO 임
    // Web Server -> WAS -> DB 가 있음

    // 웹 쪽 장애는 웹서버 쪽에서 에러는 생각 보다 많지 않고
    // Service Login WAS 쪽에서 보통 에러가 많이 발생
    // Spring - Java 는 JVM 위에서 작동을 하게 됨 
    
    // APM 이 WebServer 는 모니터링을 잘 안하고 DB 응답시간등을 모니터링을 함
    // Scouter 는 Open Source Jennifer 는 유료임



}
