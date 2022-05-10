package com.sparta.cicdtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // 수정일짜를 반영하는 annotation
@SpringBootApplication
public class CicdTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(CicdTestApplication.class, args);
    }

}
