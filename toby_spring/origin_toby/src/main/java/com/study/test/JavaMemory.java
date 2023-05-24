package com.study.test;

public class JavaMemory {

    // 자바 메모리 구조
    // 애플리케이션 - 일반 사용자가 사용할 기능을 제공하는 컴퓨터가 실행할 수 있는 명령어들의 집합
    // 메모리 - 실행 된 애플리케이션이 상주 하는 곳
    // CPU - 명령어를 실행하는 주체
    public static void main(String[] args) {
        // main 메서드는 애플리케이션이 실행할 떄 시작 출발 점임
        // 프로그램 실행 시 변수 Memory 에 a b c 값이 저장 이 됨
        // 메모리에 CPU 에 의하여 값이 Memory 에 저장이 됨

        // Runtime -> 어프리케이션이 메모리에 올라가서 실행 되는 시간임
        int a = 7;
        int b = 3;
        int c = a + b;

        // 메모리 구조
        // 가장 중요한 것은
        
        // Stack Memory : 함수나 메서드의 지역 변수 (local variable) and 매개 변수 (parameter) 가 저장 됨
        // 함수나 메서드가 호출 될 때 마다 스택 프레임 (Stack Frame) 에 쌓임

        // Heap Memory : 객체가 저장이 됨

        // Stack Memory 에
        // 함수나 메서드가 호출 시에 Stack Memory 에 쌓임 제일 처음 실행 시 Stack Frame 안에 제일 처음 main 메서드가 쌓임
        // Stack Frame 에 1 2 에 쌓임

        int ab = 1;
        int bc = 2;
        int cd = ab + bc;


    }

}

class MemoryTest {
    // Stack 메모리에
    // 프로그램 실행 시 제일 처음에 Stack main 메서드 Stack Frame 에 쌓이며
    // 그다음 args 값이 저장이 되고, a 100 이 저장 이 된 후 그 다음 wow 메서드에 대한 Stack Frame 이 생김
    // wow 메서드 Stack Frame 에 num 이 저장이 되고 100 값이 저장이 됨, 그다움 b 에 400 이 저장 이 됨
    // 그 다음 return 을 하는 데 wow 메서드에서 return 하면서 wow 에 대한 stack frame 이 사라지며
    // 400 을 return 을 하며 main 메서드 Stack Frame 에 변수 a 에 저장 된 값이 400 으로 저장이 됨
    
    // Stack Memory 영역은 딱히 개발자가 크게 관리를 해줄 필요가 없음
    // 다만 메서드를 끝나지 않고 함수를 계속 호출 하는 방식은 Stack Memory 가 초과 되어 애플리케이션이 죽어 버림
    
    public static void main(String[] args) {
        int a = 100;
        a = wow(a);
    }
    
    public static int wow(int num) {
        int b = num * 4;
        return b;
    }
}


// 프로그램 실행 시
// Stack 에 메인 메서드 Stack Frame 이 생기고 안에 args 값이 저장후 new Counter() 를 실행하는 순간 객체가 생성이 됨
// Counter 도 Counter 에 Stack Frame 이 생김

// Heap 에 객체가 생성이 됨new Counter() 하여 객체가 생성이 되는 순간 Heap 메모리에 저장이 됨
// new Counter() 생성 된 힙 객체에 state = 0 도 저장 이 됨

// Counter 에 생성자에 대한 처리가 끝나면 Stack Frame 에서 Counter Stack Frame 이 사라 짐
// c 라는 값에 객체 변수가 저장 되므로 main 메서드 Stack Frame 에 객체를 가르키는 c 값이 저장이 됨
// 이 c (메인 메서드 Stack Frame) 에 저장이 된 값은 Heap 메모리에 저장 된 new Counter() 객체를 가르키는 주소 값이 저장이 됨
// 이 c 값은 counter 객체를 가르키는 것임 c 는 객체 그 값이 아니라 객체를 주소하는 메모리 주소 값을 가르 침

class HeapTest {
    // 매개 변수 args 지역변수는 c

    public static void main(String[] args) {
        Counter c = new Counter();
    }
}

class Counter {
    // 몇번 카운트를 하였는 지 저장하는 state 값
    // state 는 instance variable 인스턴스 변수 임
    
    private int state = 0;

    public void increment() {
        state++;
    }
    public int get() {
        return state;
    }
}

// this 는

// Heap2 를 실행 시 main 메서드가 진입 점으로
// Stack Memory 에 main 메서드 Stack Frame 이 생김
// 그 다음 new Counter() 를 실행하는 순간 이 또한 메서드이기는 하므로 Stack Frame 에 Counter() 메서드 Stack Frame 이 생성이 됨
// 그 다음 Heap 메모리에 Counter (state=0) 객체가 저장이 됨 this 는 객체 생성자에 대한 Stack Frame 에서 this 는
// heap 에 저장 되어 있는 객체를 가르켜주는 역할을 함 this 는 heap 에 저장 된 메모리 주소 값을 앎
// 객체 생성자 메서드 실행이 끝나는 순간 Stack 메모리 에서 객체 생성 Stack Frame 메모리는 사라지게 됨

// 그 다음 Counter 객체 c 변수 값을 main 메서드 Stack Fraem 안 c 값이 저장이 됨 (객체 주소 값)
// 이 main 메서드 Stack Frame 에 저장 된 c 값은 Heap 메모리에 저장 된 객체 값을 가르켜주는 주소값이 됨

// two(c) 라는 메서드를 호출 하게 되면 서 two 메서드 Stack Frame 이 생기면 서 이 Stack Frame 안에서
// Parameter 로 c 값을 전달해 주면서 two 메서드 Stack Frame 안에 c 변수 값이 저장이 됨 이 저장 된 c 값은
// Heap 에 저장 되어있는 객체를 가르키는 주소값 정보를 저장하게 됨

// two 메서드 안에 c.increment() 도 메서드 또한 메서드 이므로 Stack 안에 increment method Stack Frame 이 생성이 됨
// incrementMethod 도 Class 안에 저장된 Method 이고 인스턴스에 대한 메서드 호출이므로 암묵적으로 this 라는 변수가 있음
// 이 this 도 heap 에 저장 된 객체 값을 가르 킴

// two 라는 메서드가 2 번다 실행이 되면 Stack Memory 에 two Stack Memory two Stack Frame 메서드도 사라지게 됨
//

// 그 다음 int count = c.get();
// get 메서드는 c가 가르키는 heap 에 저장 되어 있는 getMethod() 를 실행하므로 2 값을 return 시켜 줌

// 주요 키 포인티는 !!!
// 호출 된 함수나 메서드가 파라미터로 객체를 전달받아 그 객체를 전달받아 상태를 변경하게 된다면
// 그 객체는 값이 변경 된 채로 남아 있다는 것이 Key Point


// 객체의 경우에는 변수들이 객체를 가르킨다는 사실을 인지하고 있어야 함
// 메서드의 파라미터로 객체를 전달 받아야 하는 일이 있다면 객체 상태값을 변화 한다는 것을 인지하여야 함

class Heap2 {
    public static void main(String[] args) {
        CounterTest c = new CounterTest();
        two(c);
        int count = c.get();
    }

    public static void two(CounterTest c) {
        c.increment();
        c.increment();
    }
}

class CounterTest {
    private int state = 0;

    public void increment() {
        state++;
    }

    public int get() {
        return state++;
    }
}

// Garbage Object
// make 메서드는 메서드 안에서 CounterGarbage 새로운 객체가 생성이 되며
// return 시에는 또 다른 객체가 생성이 되어 return 이 됨

// Stack 메모리에는 Mamin method stack frame 이 있음 c 가 있고 이 변수 c 값은 2번쨰 생성 이 된 CounterGarabage 객체 값만 참조를 함
// 첫번쨰 make 메서드 안에서 생성이 된 CounterGarbage Heap 메모리에 저장 되어 있는 것은 그 아무것도 참조를 안하게 됨

// make 메서드 안에서 처음 생성이 된 CounterGarbage 객체는 참조하는게 아무것도 없으므로 그 누구도 접근이 안되어 
// 아무것도 참조가 안되는 쓰레기 객체가 됨 이러한 쓰레기 객체를 처리하기 위하여서는
// 첫번쨰 방법은 개발자가 직접 명령어를 작성하여 쓰레기를 제거하거나 or 자바나 Python 에서는 Language Level 에서
// Garbage Collector 가 알아서 쓰리게 객체를 정리를 해 줌

class GarbageObject {
    public static void main(String[] args) {
        CounterGarbage cg = new CounterGarbage();
    }
    public static CounterGarbage make() {
        CounterGarbage cg = new CounterGarbage();
        return new CounterGarbage();
    }
}

class CounterGarbage {
    private int state = 0;

    public void increment() {
        state++;
    }

    public int get() {
        return state;
    }
}