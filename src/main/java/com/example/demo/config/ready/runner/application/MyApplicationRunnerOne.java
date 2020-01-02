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
@Order(1)
public class MyApplicationRunnerOne implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("MyApplicationRunnerOne 执行...");
//        String[] sourceArgs = args.getSourceArgs();// [--foo=bar, --name=rgyb]
//        if (sourceArgs != null){
//            System.out.println(Arrays.toString(sourceArgs));
//        }
//        List<String> foo = args.getOptionValues("foo");// 根据name获取值
//        System.out.println(foo);
    }
}
