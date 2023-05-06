package com.study.toby_spring;

public interface HelloService {
    // 빈 오부젝트와 역할과 구분
    // Spring 이 생성하고
    // Application Bean - 개발자가 어떤 빈을 사용하겠다고 등록 하는 것 (개발자가 구성정보를 제공)
    // Application Login Bean (도메인 로직을 담고 있는 Bean) / Application InfraStrucre Bean (기술과 관련 되어 있는 Bean 들)
    // Container InfraStructure Bean - Spring Framework 가 발전하면서 추가 되어온 Bean 들 (Default 로 생성이 됨)

    // 사용자 구성 정보 - ComponentScan (Component 어노테이션 붙은 클래스 들은 ComponentScan 에 의하여 Bean에 등록)
    // 자동 구성 정보 - AutoConfiguration

    String sayHello(String name);

    // 구현을 하였으면 그 값을 가져오고 안했으면 0 을 return
    default int countOf(String name) {
        return 0;
    };

}
