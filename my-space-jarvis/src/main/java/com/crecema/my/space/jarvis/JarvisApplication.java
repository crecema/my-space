package com.crecema.my.space.jarvis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.crecema.my.space")
public class JarvisApplication {

    public static void main(String[] args) {
        SpringApplication.run(JarvisApplication.class, args);
    }

}
