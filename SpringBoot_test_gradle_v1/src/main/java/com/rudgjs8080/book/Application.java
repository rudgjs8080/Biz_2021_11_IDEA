package com.rudgjs8080.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Application Class
 * 앞으로 만들 프로젝트의 메인 클래스
 */
// @EnableJpaAuditing // JPA Auditing 활성화
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        // SpringApplication.run 으로 인해 내장 WAS를 실행
        SpringApplication.run(Application.class, args);
    }

}
