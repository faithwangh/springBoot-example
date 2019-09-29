package com.example.springcloudstreamoutput.message;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

@Component
public interface OutputInterface {

    String OUTPUT1 = "output1";

    @Output(OUTPUT1)
    MessageChannel output1();

}
