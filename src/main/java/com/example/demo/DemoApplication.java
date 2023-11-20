package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
//        System.out.println(Arrays.asList(context.getApplicationName(),
//                context.getId(),
//                context.getDisplayName(),
//                context.getParent(),
//                context.getEnvironment(),
//                context.getStartupDate()));
//        String[] beans = context.getBeanDefinitionNames();
//
//        for (int i = 0; i < beans.length; i++) {
//            System.out.println(beans[i]);
//        }

    }
}
