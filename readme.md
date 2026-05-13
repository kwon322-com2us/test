# Spring Boot Sample Application

기본 Spring Boot 샘플 애플리케이션입니다.

## 구조

```
src/
├── main/java/com/example/demo/
│   ├── DemoApplication.java          # 애플리케이션 진입점
│   ├── controller/
│   │   └── HelloController.java      # REST 컨트롤러
│   ├── service/
│   │   └── HelloService.java         # 비즈니스 로직
│   └── dto/
│       └── GreetingResponse.java     # 응답 DTO
└── test/java/com/example/demo/
    ├── DemoApplicationTests.java          # 컨텍스트 로드 테스트
    ├── controller/
    │   └── HelloControllerTest.java       # MockMvc 컨트롤러 테스트
    └── service/
        └── HelloServiceTest.java          # 서비스 단위 테스트
```

## API 엔드포인트

| Method | URL | 설명 |
|--------|-----|------|
| GET | `/api/hello` | 기본 인사 반환 |
| GET | `/api/hello/{name}` | 이름 기반 인사 반환 |

## 실행 방법

```bash
./mvnw spring-boot:run
```

## 테스트 실행

```bash
./mvnw test
```

## 기술 스택

- Java 17
- Spring Boot 3.2.5
- Spring Web MVC
- JUnit 5
- Mockito
