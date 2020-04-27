package com.pactera.sms.mailserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @ClassName MailServerApplication
 * @Description: TODO
 * @Author TCP
 * @Date 2020/4/21 0021
 * @Version V1.0
 **/
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class MailServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(MailServerApplication.class, args);
    }
}
