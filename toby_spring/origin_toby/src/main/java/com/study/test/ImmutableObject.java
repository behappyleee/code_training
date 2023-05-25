package com.study.test;

import org.w3c.dom.css.RGBColor;

import java.util.HashSet;
import java.util.Set;

public class ImmutableObject {

    // 불변 객체 (Immutable Object)
    // 불변 객체는 객체를 처음 만들 시 값들을 처음에 넣어주고 그 값들을 바꿀 수 없는 상태
    // 불변 객체는 안정적인 개발이 가능 함

    // 불변 객체를 사용 하는 이유는 객체를 조회 후 여러 서비스 로직을 수행하다 보면 객체가 변할 걱정 도 하게됨
    // 하지만 불변 객체일 시 로직을 아무리 많이 지나도 객체가 변할 걱정을 하지 않게 됨

    // 불변 객체의 장점은 - 이해하기 쉽고 안정적인 서비스 개발에 도움이 되며 map set cache 에 쓰기 적합

    public static void main(String[] args) {
        Set<RGB> myRGB = new HashSet<>();
        RGB green = new RGB(0, 128, 0);

        myRGB.add(green);

        RGB greenInverted = green.invert();     // RGB 객체 내부의 상태를 바꾸어 줌 (바뀐 객체에 값을 그대로 return 을 하므로 객체가 달라져 버림

        System.out.println(myRGB.contains(greenInverted));  // false 현재 Set 에 없으므로
        System.out.println(myRGB.contains(green));          // 현재 객체도 false (invert 메서드 때문에 값이 바뀌어 버림)

        // J



    }
}

class RGB {
    public final int r;
    public final int g;
    public final int b;

    public RGB(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public int hashCode() {
        return r << 16 + g << 8 + b;
    }
    
    public boolean equals(Object obj) {
        RGB o = (RGB)obj;
        return r == o.r && g == o.g && b == o.b;
    }

    /*
    public RGB invert() {
        r = 255 - r;
        g = 255 - g;
        b = 255 - b;
        return this;
    }
    */
    // 일반적으로 immutable 객체의 장점은 일반적으로 thread-safe 함, 불변적 객체를 필드로 쓰면 방어적 복사를 할 필요 없음
    // 위 메서드는 객체의 값을 그대로 뺴주어서 return 을 해주므로 값이 변해 버림
    // 아래 메서드 처럼 해주면 새로운 객체를 생성을 해주어 return 해주므로 객체가 변하지 않아 안전함 (immutable)
    // 객체 값이 변하지 않는 걸 보장 하므로 안전한 개발이 가능함
    public RGB invert() {
        RGB rgb = new RGB(255 - r, 255 - g, 255 - b);
        return rgb;
    }



}


