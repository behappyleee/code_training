package com.study.study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Map;

public class ConditionalTest {

    @Test
    void conditional() {
        // true (Conditional 이 True 이므로 정상적으로 Bean 이 생성이 되어 테스트 통과)
        ApplicationContextRunner contextRunner = new ApplicationContextRunner();
        contextRunner.withUserConfiguration(Config1.class)
                .run(context -> {
                    Assertions.assertThat(context).hasSingleBean(MyBean.class);
                    Assertions.assertThat(context).hasSingleBean(Config1.class);
                });

        // false (Conditional 이 True 이므로 정상적으로 Bean 이 생성이 되어 테스트 실패)
        new ApplicationContextRunner().withUserConfiguration(Config2.class)
                .run(context -> {
                    Assertions.assertThat(context).doesNotHaveBean(MyBean.class);
                    Assertions.assertThat(context).doesNotHaveBean(Config2.class);
                });
        
        
          // 위에 방식 Test 코드로 변경하면 훨씬 간결해짐
//        AnnotationConfigApplicationContext ac2 = new AnnotationConfigApplicationContext();
//        ac2.register(Config2.class);
//        ac2.refresh();
//        MyBean bean = ac.getBean(MyBean.class);   MyBean 이라는 Bean 을 가지고 있는지 확인하는 코드
    }

    // 어노테이션 생성
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @Conditional(BooleanCondition.class)
    @interface BooleanConditional{
        boolean value();    // Annotation 사용 시 Annotation 파라미터를 받을 수 있게 해줌
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @Conditional(TrueCondition.class)
    @interface TrueConditional{}    // True 인 상태

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @Conditional(FalseCondition.class)
    @interface FalseConditional{}   // False 인 상태


    @Configuration
    // @Conditional(TrueCondition.class)
    // @TrueConditional     // 직접 생성한 어노테이션을 사용
    @BooleanConditional(true)   // 직접 생성한 어노테이션 - 파라미터를 넘길 수 있게 해줌
    static class Config1 {
        @Bean
        MyBean myBean() {
            return new MyBean();
        }
    }

    @Configuration
    // @Conditional(FalseCondition.class)  // False 일 경우에 Bean 으로 등록이 안됨
    // @FalseConditional   // 직접 생성한 어노테이션을 사용
    @BooleanConditional(false)  // 직접 생성한 어노테이션 - 파라미터를 넘길 수 있게 해줌
    static class Config2 {
        // Conditional 이 false 이므로 Bean 으로 등록이 안됨
        @Bean
        MyBean myBean() {
            return new MyBean();
        }
    }

    static class MyBean {}

    static class TrueCondition implements Condition {
        @Override
        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
            return true;
        }
    }

    static class FalseCondition implements Condition {
        @Override
        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
            return false;
        }
    }

    static class BooleanCondition implements Condition {
        @Override
        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
            Map <String, Object> annotationAttributes = metadata.
                    getAnnotationAttributes(BooleanConditional.class.getName());
            Boolean value = (Boolean) annotationAttributes.get("value");
            return value;   // Annotation Parameter 로 설정한 Boolean value 값을 가져옴
        }
    }


}
