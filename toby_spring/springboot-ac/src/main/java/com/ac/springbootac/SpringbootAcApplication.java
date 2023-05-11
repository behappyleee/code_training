package com.ac.springbootac;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionEvaluationReport;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootAcApplication {

	// Spring 시작 시 어떤 Bean 이 자동구성으로 시작 되는 지 알고싶으면
	// VM 옵션에 -Ddebug 로 설정해주면 보임 CONDITIONS EVALUATION REPORT 가 로그에 찎힘
	// EnableScheduleing 등 TaskExecutionAutoConfiguration Bean 이 작업을 수행
	
	// Sprinboot docs 공식 문서에 Springboot 에서 심플하게 구성 되어있는 Caching 이 설명 되어있음
	
	@Bean
	ApplicationRunner run(ConditionEvaluationReport report) {
		return args -> {
			report.getConditionAndOutcomesBySource().entrySet().stream()
					.filter(co -> co.getValue().isFullMatch())
					.filter(co -> co.getKey().indexOf("Jmx") < 0)	// Jmx 를 제거 하면 13개로 줄어 듬, web Module 추가하면 62여개로 늘어남
					.forEach(co -> {
						// 자동 구성 Bean Key 값 들 출력
						System.out.println("CO GET KEY : " + co.getKey());
						co.getValue().forEach(c -> {
							System.out.println("C GET OUT COME : " + c.getOutcome());
						});
					});
		};
	}

	// 위 람다식으로 사용
//	@Bean
//	ApplicationRunner run() {
//		return new ApplicationRunner() {
//			@Override
//			public void run(ApplicationArguments args) throws Exception {
//
//			}
//		};
//	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAcApplication.class, args);
	}

}
