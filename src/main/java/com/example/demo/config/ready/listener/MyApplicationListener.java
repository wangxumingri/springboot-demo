package com.example.demo.config.ready.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;

/**
 * Author:Created by wx on 2020/1/2
 * Desc:
 */
@Configuration
public class MyApplicationListener implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("MyApplicationListener 执行..."+event.toString());
    }
}
