package com.my.study_toby.config;

import com.my.study_toby.config.autoConfig.MyAutoConfiguration;
import org.springframework.boot.context.annotation.ImportCandidates;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.List;

public class MyAutoConfigurationSelector implements DeferredImportSelector {

    static {
        System.out.println("THIS IS STATIC METHOD IN MY AUTO CONFIG");
    }


    private final ClassLoader classLoader;

    public MyAutoConfigurationSelector(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public String[] selectImports(AnnotationMetadata importClassMetadata) {
        List<String> autoConfigs = new ArrayList<>();
        ImportCandidates.load(MyAutoConfiguration.class, classLoader).forEach(
                candidate -> {
            autoConfigs.add(candidate);
        });

        System.out.println("selectImports Config Check : " + autoConfigs);

        return autoConfigs.toArray(new String[0]);
    }

    public static void main(String[] args) {
        {
            System.out.println("THIS IS TES");
        }

        // Test DeployTest My.jar
        callDeploy();
    }

    public static void callDeploy() {
        System.out.println("THIS IS CALL DEPOLY METHOD TEST !!!");
    }

    public void testDeploy() {
        // DeployTest dt = new DeployTest();
    }

    public String streamTest() {
        System.out.println("System Out Println Test");
        return null;
    }

}
