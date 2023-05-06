package com.study.study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class ConfigurationTest {

    // Study Test
    // 어떤 추가한 라이브러리나 사용법들을 익힐 필요가 있을 시 사용하는 테스트 코드 클래스
    @Test
    void testConfig() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
        ac.register(MyConfig.class);
        ac.refresh();

        Bean1 bean1 = ac.getBean(Bean1.class);
        Bean2 bean2 = ac.getBean(Bean2.class);
        // 2 개 객체가 동일하다고 나옴 (Bean ProxyBeanMethod default 가 true 로 설정 되어 있는 경우는 
        // Bean 등록 시 바로 등록이 아니라 Proxy Pattern 을 앞에 두고 Bean 에 등록이 됨
        Assertions.assertThat(bean1.common).isSameAs(bean2.common);
    }

    @Test
    void configurationTest() {
        // 해당 내역은 Test 통과하지 못함 Object 가 서로 다름 !
        MyConfig myConfig = new MyConfig();
        Bean1 bean1 = myConfig.bean1();
        Bean2 bean2 = myConfig.bean2();
        Assertions.assertThat(bean1.common).isSameAs(bean2.common);
    }

    @Test
    void configuration() {
        // 2개 완전히 다른 Object 임 해당 내역은 Test 통과를 하지못함
        // Assertions.assertThat(new Common()).isSameAs(new Common());

        // 해당 테스트는 통과함 2개 완전히 같은 Object 임
        Common cm = new Common();
        Assertions.assertThat(cm).isSameAs(cm);
    }

    @Test
    void proxyCommonMethod() {
        // Proxy Pattern 으로 객체 생성 후 Test
        // 딱 1개의 Object 만 생성이 되므로 2개의 객체는 같은 상태임
        MyConfig myConfigProxy = new MyConfigProxy();

        Bean1 bean1 = myConfigProxy.bean1();
        Bean2 bean2 = myConfigProxy.bean2();

        Assertions.assertThat(bean1.common).isSameAs(bean2.common);
    }

    static class MyConfigProxy extends MyConfig {
        private Common common;
        @Override
        Common common() {
            if(this.common == null) this.common = super.common();
            return common;
        }
    }

    // 만약 proxyBeanMethod = false 로 지정 시, default 는 true 임
    // SpringContainer 에서 관리하는 Bean 은 기본적으로 Singletone 이지만
    // 만약 proxyBeanMethod = false 로 지정 시 서로 다른 객체로 생성이 됨 (다른 객체로 생성)
    @Configuration(proxyBeanMethods = false)
    static class MyConfig {
        @Bean
        Common common() {
            return new Common();
        }
        // Common Object 는 총 2번이 실행이 됨
        // Bean1 이라는 Object 를 만들 때
        @Bean
        Bean1 bean1() {
            return new Bean1(common());
        }
        @Bean
        Bean2 bean2() {
            return new Bean2(common());
        }
    }

    // SpringContainer Bean 들은 대부분 모두 Singletone 형식
    // Bean1, Bean2 가 모두 Common Bean 에 의존을 하게 되면 

    static class Bean1 {
        private final Common common;
        Bean1(Common common) {
            this.common = common;
        }
    }

    static class Bean2 {
        private final Common common;
        Bean2(Common common) {
            this.common = common;
        }
    }

    static class Common {

    }

}
