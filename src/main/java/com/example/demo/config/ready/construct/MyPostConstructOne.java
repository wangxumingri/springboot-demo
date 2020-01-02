package com.example.demo.config.ready.construct;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Author:Created by wx on 2020/1/2
 * Desc:
 */

@Component
@DependsOn("myCommandLineRunnerOne")
public class MyPostConstructOne {
    @PostConstruct
    public void init(){
        System.out.println("MyPostConstructOne 执行...");
    }
}
