package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

//    @Bean("demoJdbcTemplate")
////    @Bean
//    public JdbcTemplate getJdbcTemplate(){
//        return new JdbcTemplate();
//    }
}
