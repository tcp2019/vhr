package com.pactera.sms.vhr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan(basePackages = "com.pactera.sms.vhr.mapper")
@EnableScheduling
public class CvhrApplication {

    public static void main(String[] args) {
        SpringApplication.run(CvhrApplication.class, args);
    }

}
