package com.example.springbootlogging.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    protected String string=null;

    @GetMapping("/hello")
    public String hello() {

       Logger logger = LoggerFactory.getLogger("sms-info");

        logger.trace("logging trace");
        logger.debug("longing debug");
        logger.info("logging info");
        logger.error("logging error");


       //string.charAt(1);


        return "hello...";
    }
}
