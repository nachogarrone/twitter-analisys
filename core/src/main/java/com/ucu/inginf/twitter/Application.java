package com.ucu.inginf.twitter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String args[]) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class);

        Processor processor = (Processor) context.getBean("getProcessor");
        try {
            processor.analyzeCandidates();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}