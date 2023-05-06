package com.study.config;

import org.springframework.boot.context.annotation.ImportCandidates;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import java.util.ArrayList;
import java.util.List;

public class MyAutoConfigImportsSelector implements DeferredImportSelector {

    private final ClassLoader classLoader;

    public MyAutoConfigImportsSelector(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        // 어떤 Bean 이 등록이 될 지후보를 잡음
        // Load 를 함 해당 객체가 어떤 Annotation 을 Bean 으로 등록을 해 줄지 결정을 해 줌
        // 자동구성에 사용할 목록들이 들어가 있음
        // ImportCandidates candidates = ImportCandidates.load(MyAutoConfiguration.class, classLoader);

        // Iterable 타입으로 받아도 상관 없음
        // Iterable<String> candidates = ImportCandidates.load(MyAutoConfiguration.class, classLoader);
        
        // 바로 For 문으로도 사용이 가능
        List<String> autoConfigs = new ArrayList<>();

//       for(String candidate : ImportCandidates.load(MyAutoConfiguration.class, classLoader)) {
//            autoConfigs.add(candidate);
//       }

        ImportCandidates.load(MyAutoConfiguration.class, classLoader).forEach(candidate -> {
            autoConfigs.add(candidate);
        });

        if(autoConfigs.isEmpty()) {
            // MethodReference 로도 대체가 가능 
            // Paramet 변수 중 모두 한번씩 실행 하라는 의미
            ImportCandidates.load(MyAutoConfiguration.class, classLoader).forEach(autoConfigs::add);
        }

        return autoConfigs.toArray(new String[0]);
        // Stream 사용 시
        // return autoConfigs.stream().toArray(String[]::new);
    }

}
