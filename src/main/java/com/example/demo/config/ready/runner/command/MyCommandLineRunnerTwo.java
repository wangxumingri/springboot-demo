package com.example.demo.config.ready.runner.command;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * Author:Created by wx on 2020/1/2
 * Desc:
 */
@Configuration
@Order(4)
public class MyCommandLineRunnerTwo implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        if (args.length > 0) {
            for (String arg : args) {
                System.out.println("MyCommandLineRunnerTwo 执行...args=" + arg);
            }
        }
    }
}

