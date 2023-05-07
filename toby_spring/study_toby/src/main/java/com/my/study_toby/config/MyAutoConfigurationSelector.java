package com.my.study_toby.config;

import org.springframework.boot.context.annotation.ImportCandidates;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.List;

public class MyAutoConfigurationSelector implements DeferredImportSelector {

    private final ClassLoader classLoader;

    public MyAutoConfigurationSelector(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public String[] selectImports(AnnotationMetadata importClassMetadata) {
        List<String> autoConfigs = new ArrayList<>();
        ImportCandidates.load(MyAutoConfiguration.class, classLoader).forEach(candidate -> {
            autoConfigs.add(candidate);
        });

        return autoConfigs.toArray(new String[0]);
    }


}
