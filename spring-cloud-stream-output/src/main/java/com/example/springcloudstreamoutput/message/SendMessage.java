package com.example.springcloudstreamoutput.message;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@EnableBinding(value = {OutputInterface.class})
@Service
public class SendMessage {

    @Autowired
    OutputInterface outputInterface;


    /**
     * 第一种方法, 没有指定output的MessageChannel, 通过OutputInterface去拿具体的Channel
     * 设置partitionKey主要是为了分区用, 可以根据根据这个partitionKey来分区
     */
    public void sendMessageMethod1() {

        Message message = MessageBuilder.withPayload("form messageMethod-01-test22").build();

        outputInterface.output1().send(message);
    }


    @Autowired
    @Qualifier(OutputInterface.OUTPUT1)
    MessageChannel output;

    public void sendMessageMethod2() {

        Message message = MessageBuilder.withPayload("form messageMethod-2-").build();

        output.send(message);
    }
}
