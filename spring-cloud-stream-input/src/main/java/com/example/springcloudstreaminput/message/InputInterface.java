package com.example.springcloudstreaminput.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

@Component
public interface InputInterface {

    String INPUT1 = "input1";

    @Input(INPUT1)
    SubscribableChannel input1();

}
