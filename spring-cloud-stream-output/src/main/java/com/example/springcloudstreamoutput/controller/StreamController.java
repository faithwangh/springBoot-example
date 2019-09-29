package com.example.springcloudstreamoutput.controller;

import com.example.springcloudstreamoutput.message.SendMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class StreamController {

    @Autowired
    SendMessage sendMessage;

    @GetMapping("/producer")
    public void hello(){

        sendMessage.sendMessageMethod1();
    }
}
