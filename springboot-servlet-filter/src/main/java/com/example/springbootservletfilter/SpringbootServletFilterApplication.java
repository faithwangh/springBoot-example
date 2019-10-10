package com.example.springbootservletfilter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
@Slf4j
public class SpringbootServletFilterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootServletFilterApplication.class, args);
        log.error("application start");
    }

}
