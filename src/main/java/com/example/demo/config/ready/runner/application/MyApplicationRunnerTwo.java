package com.example.demo.config.ready.runner.application;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.Arrays;
import java.util.List;

/**
 * Author:Created by wx on 2020/1/2
 * Desc:
 */
@Configuration
@Order(2)
public class MyApplicationRunnerTwo implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("MyApplicationRunnerTwo 执行...");
//        String[] sourceArgs = args.getSourceArgs();
//        if (sourceArgs != null){
//            System.out.println(Arrays.toString(sourceArgs));
//        }
//        List<String> foo = args.getOptionValues("foo");
//        System.out.println(foo);
    }
}
