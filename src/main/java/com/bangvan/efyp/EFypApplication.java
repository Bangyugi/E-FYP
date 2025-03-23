package com.bangvan.efyp;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class EFypApplication {

    @Value("${environment.info}")
    private String environmentInfo;

    public static void main(String[] args) {
        SpringApplication.run(EFypApplication.class, args);
    }

    @PostConstruct
    public void printEnvironmentInfo() {
        log.info("environmentInfo: " + environmentInfo);
    }
}
