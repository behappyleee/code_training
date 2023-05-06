package com.study.toby_spring;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;

// 만약 해당 파라미터값 없고 서버 꺼진 후 테스트 실행 시 테스트 Fail
// 우리가 지정한 application SERVER.PORT 를 실제 띄우고 테스트를 수행해달라는의미에 어노테이션
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class HelloApiSpringBootTest {

    // 해당 Test 를 수행하려면 항상 서버가 먼저 시작 해 있어야 함 !
    // 해당 어노테이션 수행
    // 해당 Test 를 먼저 시작시키는 방법은 @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)

    // HTTP REQ / RES Test Code !
    // TEST 를 진행 시 서버를 먼저 띄우고 Test 를 진행하여야 함 !
    @Test
    void helloApi() {
        // http localhost:7070/hello?name=httpTest
        // HTTPie
        // 요청을 소스로 보냄
        // RestTemplate 을 사용 시 코드에서 Api 요청을 할 수 가 있음
        // RestTemaple 객체를 사용 시 Exception 발생 시 그냥 Exception 을 던지지만
        // TestRestTamplate 객체를 사용 시 REQ / RES 전부를 볼 수 있음
        TestRestTemplate rest = new TestRestTemplate();

        ResponseEntity<String> res
                = rest.getForEntity("http://localhost:9090/app/hello?name={name}", String.class, "nameTestSpring");

        // 검증
        // 1. Status Code 가 200으로 왔는 지
        // Assertion 을 사용 시 assertThat 과 뒤에 값이 같은지 비교가 가능 !
        Assertions.assertThat(res.getStatusCode()).isEqualTo(HttpStatus.OK);

        // 2. Header 가 (content-type) 이 text/plain 인지
        Assertions.assertThat(res.getHeaders().getFirst(HttpHeaders.CONTENT_TYPE)).startsWith(MediaType.TEXT_PLAIN_VALUE);

        // 3. body 가 제대로 왔는 지
        Assertions.assertThat(res.getBody()).isEqualTo("* This is SimpleHello Service Hello nameTestSpring *");
    }

    @Test
    void failHelloApi() {
        // http localhost:7070/hello?name=httpTest
        // HTTPie
        // 요청을 소스로 보냄
        // RestTemplate 을 사용 시 코드에서 Api 요청을 할 수 가 있음
        // RestTemaple 객체를 사용 시 Exception 발생 시 그냥 Exception 을 던지지만
        // TestRestTamplate 객체를 사용 시 REQ / RES 전부를 볼 수 있음
        TestRestTemplate rest = new TestRestTemplate();

        // name Parameter NULL 테스트
        ResponseEntity<String> res
                //        = rest.getForEntity("http://localhost:8080/hello?name=", String.class);
                // property 값에 context Path 가 추가가 되어 url 변경
                = rest.getForEntity("http://localhost:9090/app/hello?name=", String.class);
        Assertions.assertThat(res.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);

    }

}
