package com.bangvan.efyp;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class EFypApplication {

    @Value("${environment.info}")
    private String environmentInfo;

    public static void main(String[] args) {
        SpringApplication.run(EFypApplication.class, args);
    }

    @PostConstruct
    public void printEnvironmentInfo() {
        System.out.println("environmentInfo: " + environmentInfo);
    }
}
