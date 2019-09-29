package com.example.springcloudstreaminput.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@EnableBinding(value = {InputInterface.class})
public class MessageReceiver {

    @StreamListener(InputInterface.INPUT1)
    public void messageReceiverChannel1(@Payload Message<String> payload){

        log.error(payload.getPayload());
    }


}
