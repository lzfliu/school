package com.lzf.school;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableAutoConfiguration
@EnableTransactionManagement
@ComponentScan("com.lzf.school")
@EntityScan("com.lzf.school.entity")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
