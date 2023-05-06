package com.study.toby_spring;

public interface HelloRepository {

    // 이름으로 검색 후 데이터가 존재 시 Hello Object 로 return
    Hello findHello(String name);

    // 이름을 찾아서 Count 를 올려 줌
    void increaseCount(String name);
    
    // JAVA 8 에 추가 된 default 메서드 추가
    // 만약 interface 에서 default 메서드를 어떤걸로 잘 설정하여야 할지 헷갈릿마면
    // Comparator 인터페이스 참고 해당 인터페이스에 굉장히 default 메서드들이 많음
    // 잘 활용시 굉장히 용이 default 메서드를 잘 활용 시 구현하여야 할 메서드 갯수가 줄어들어 편리함
    // 이름을 주면 count 값을 가져 옴
    default int countOf(String name) {
        Hello hello = findHello(name);
        return hello == null ? 0 : hello.getCount();
    }

}
