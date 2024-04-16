package com.ohgiraffers.thymeleaf.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@SpringBootApplication // @Configuration을 상속받는 annotation이다. ComponentScan 대상 경로에 주의하자.
public class Chap01ThymeleafLectureSourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Chap01ThymeleafLectureSourceApplication.class, args);
    }

}
